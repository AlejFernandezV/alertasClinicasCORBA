/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;


import utilidades.UtilidadesRegistroS;
import utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import Repositorios.NotificacionRepositoryImpl;
import controladores.ControladorGestorNotificacionesImpl;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {        
         
        int numPuertoRMIRegistry = 2024;
        String direccionIpRMIRegistry = "Localhost";
     
        //Crear el repositorio
        NotificacionRepositoryImpl objNotificacionRepositoryImpl = new NotificacionRepositoryImpl();
        //Crear el objeto remoto
        ControladorGestorNotificacionesImpl objRemoto = new ControladorGestorNotificacionesImpl(objNotificacionRepositoryImpl);
        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorPacientes");            
           
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
        
        
    }
}
