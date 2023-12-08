package Servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.Notificacion;

public interface ControladorGestorNotificacionesInt extends Remote{
    Notificacion notificar(Notificacion objNotificacion) throws RemoteException;
}
