package cliente.servicios;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.vista.Menu;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import servidor.controladores.ControladorGestorAlertasInt;
import sop_corba.GestionPacientesHelper;
import sop_corba.GestionPacientesOperations;

public class ClienteDeObjetos {

    private static ControladorGestorAlertasInt objRemoto;
    private static GestionPacientesOperations ref;

    public static void main(String[] args) {
        try {
            //RMI        
            int numPuertoRMIRegistry = 2023;
            String direccionIpRMIRegistry = "localhost";

            objRemoto = (ControladorGestorAlertasInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorAlertas");
            //********************************************************************

            //CORBA
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            vec[1] = "localhost";
            vec[2] = "-ORBInitialPort";
            vec[3] = "2024";

            // se crea e inicia el ORB
            ORB orb = ORB.init(vec, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objUsuarios";
            ref = GestionPacientesHelper.narrow(ncRef.resolve_str(name));
            //********************************************************************

            Menu objMenu = new Menu(objRemoto, ref);
            objMenu.ejecutarMenuPrincipal();
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }

    }

}
