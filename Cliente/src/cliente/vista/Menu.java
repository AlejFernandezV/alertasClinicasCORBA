package cliente.vista;

import cliente.operaciones.menuOperaciones;
import cliente.utilidades.UtilidadesConsola;
import Servidor.controladores.ControladorGestorAlertasInt;
import sop_corba.GestionPacientesOperations;

public class Menu {
    
    private final menuOperaciones mOps;
    
    public Menu(ControladorGestorAlertasInt objRemoto, GestionPacientesOperations ref) {
        this.mOps = new menuOperaciones(objRemoto,ref);
    }

    public void ejecutarMenuPrincipal() {
        int opcion = 0;
        do {
            
            this.mOps.imprimirMenu();
            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    this.mOps.opcionRegistroPaciente();
                    break;
                case 2:
                    this.mOps.opcionComenzarLectura();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 2);
    }  
}
