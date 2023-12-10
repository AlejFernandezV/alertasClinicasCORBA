package Servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControladorGestorNotificacionesInt extends Remote{
    boolean registrarReferenciaRemota(ControladorCallBackNotificacionesInt objNotificacion) throws RemoteException;
}
