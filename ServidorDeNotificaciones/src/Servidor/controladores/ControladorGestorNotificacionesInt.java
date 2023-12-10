package Servidor.controladores;

import DTO.notificacionDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControladorGestorNotificacionesInt extends Remote{
    boolean registrarReferenciaRemota(ControladorCallBackNotificacionesInt objNotificacion) throws RemoteException;
    public void notificarServidorNotificaciones(notificacionDTO objNotificacion)throws RemoteException;
}
