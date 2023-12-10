package Servidor.servicios;

import Servidor.controladores.ControladorGestorAlertasImpl;
import Servidor.controladores.ControladorGestorNotificacionesImpl;
import Servidor.controladores.ControladorGestorNotificacionesInt;
import Servidor.repositorios.AlertasRepositoryImpl;
import Servidor.utilidades.UtilidadesRegistroS;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import sop_corba.GestionPacientesHelper;
import sop_corba.GestionPacientesOperations;

public class ServidorDeAlertas {
    private static ControladorGestorNotificacionesInt objRemoto;
    public static void main(String[] args) throws RemoteException{
        int numPuertoRMIRegistry = 2023;
        String direccionIpRMIRegistry = "localhost";

        AlertasRepositoryImpl objRepository = new AlertasRepositoryImpl(obtenerReferencia(),objRemoto);
        ControladorGestorAlertasImpl objControladorGestorAlertas = new ControladorGestorAlertasImpl(objRepository);
        ControladorGestorNotificacionesImpl objControladorGestorNotificaciones =  new ControladorGestorNotificacionesImpl();
        
        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto((Remote) objControladorGestorAlertas, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorAlertas");
            UtilidadesRegistroS.RegistrarObjetoRemoto((Remote) objControladorGestorNotificaciones, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorNotificaciones");
        } catch (RemoteException e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
    
    private static GestionPacientesOperations obtenerReferencia() {
        GestionPacientesOperations ref = null;

        String[] vec = new String[4];
        vec[0] = "-ORBInitialPort";
        vec[1] = "localhost";
        vec[2] = "-ORBInitialPort";
        vec[3] = "2024";
        
        // se crea e inicia el ORB
        ORB orb = ORB.init(vec, null);
        // se obtiene un link al name service
        org.omg.CORBA.Object objRef;
        try {
            objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objUsuariosConsul";
            ref = GestionPacientesHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);
        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(ServidorDeAlertas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ref;
    }
    
}
