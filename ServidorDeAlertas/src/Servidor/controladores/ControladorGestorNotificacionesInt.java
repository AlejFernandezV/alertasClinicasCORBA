package Servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.notificacionDTO;

public interface ControladorGestorNotificacionesInt extends Remote{
    boolean registrarReferenciaRemota(ControladorCallBackNotificacionesInt objNotificacion) throws RemoteException;
    public void notificarServidorNotificaciones(notificacionDTO objNotificacion)throws RemoteException;
}
