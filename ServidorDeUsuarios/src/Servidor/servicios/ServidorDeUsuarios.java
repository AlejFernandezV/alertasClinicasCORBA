package Servidor.servicios;

import Servidor.controladores.GestionPacienteImpl;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import Servidor.respositorios.PacienteRepositoryImpl;
import sop_corba.GestionPacientes;
import sop_corba.GestionPacientesHelper;

public class ServidorDeUsuarios {
    
    static PacienteRepositoryImpl objPacienteRepositoryImpl = new PacienteRepositoryImpl();

    public static void main(String[] args) {
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialHost";
            vec[1] = "localhost";
            vec[2] = "-ORBInitialPort";
            vec[3] = "2024";
            GestionPacienteImpl objRemoto = new GestionPacienteImpl(objPacienteRepositoryImpl);
            inicializarORB(vec, objRemoto);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
        System.out.println("Servidor: Saliendo ...");
    }
    
    private static void inicializarORB(String[] vecS, GestionPacienteImpl objRemoto) throws ServantNotActive, WrongPolicy, org.omg.CORBA.ORBPackage.InvalidName, AdapterInactive, InvalidName, NotFound, CannotProceed {

        // crea e inicia el ORB
        ORB orb = ORB.init(vecS, null);
        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootpoa.the_POAManager().activate();

        //*** se genera la referencia del servant
        org.omg.CORBA.Object objRegis = rootpoa.servant_to_reference(objRemoto);
        GestionPacientes hrefRegis = GestionPacientesHelper.narrow(objRegis);
        
        org.omg.CORBA.Object objConsul = rootpoa.servant_to_reference(objRemoto);
        GestionPacientes hrefConsul = GestionPacientesHelper.narrow(objConsul);

        // se obtiene un link al name service
        org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
        NamingContextExt ncref = NamingContextExtHelper.narrow(objref);

        // *** se realiza el binding de la referencia del servant en el N_S ***
        String nameRegis = "objUsuariosRegis";
        NameComponent pathRegis[] = ncref.to_name(nameRegis);
        ncref.rebind(pathRegis, hrefRegis);
        
        String nameConsul = "objUsuariosConsul";
        NameComponent pathConsul[] = ncref.to_name(nameConsul);
        ncref.rebind(pathConsul, hrefConsul);

        System.out.println("El Servidor esta listo y esperando ...");

        // esperan por las invocaciones desde los clientes
        orb.run();
    }
}
