/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.servicios;


import utilidades.UtilidadesRegistroS;
import java.rmi.RemoteException;
import Servidor.Repositorios.NotificacionRepositoryImpl;
import Servidor.controladores.ControladorCallBackNotificacionesImpl;
import Servidor.controladores.ControladorGestorNotificacionesInt;
import utilidades.UtilidadesRegistroC;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {        
        int numPuertoRMIRegistry = 2025;
        String direccionIpRMIRegistry = "localhost";
        
        NotificacionRepositoryImpl objRepository = new NotificacionRepositoryImpl();

        ControladorCallBackNotificacionesImpl objRemoto = new ControladorCallBackNotificacionesImpl(objRepository);
        ControladorGestorNotificacionesInt objRemotoServidor
                = (ControladorGestorNotificacionesInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorNotificaciones");
        objRemotoServidor.registrarReferenciaRemota(objRemoto);
        System.out.println("Esperando notificaciones");
    }
}
