package Servidor.controladores;

import DTO.notificacionDTO;
import Repositorios.NotificacionRepositoryInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ControladorCallBackNotificacionesImpl extends UnicastRemoteObject implements ControladorCallBackNotificacionesInt{

    private NotificacionRepositoryInt repositorio;
    
    public ControladorCallBackNotificacionesImpl(NotificacionRepositoryInt repositorio) throws RemoteException{
        super();
        this.repositorio = repositorio;
    }
    
    @Override
    public void notificarAlertaPaciente(notificacionDTO objNotificacion) throws RemoteException {
        System.out.println("Notificación recibida!");
        repositorio.registrarNotificacion(objNotificacion);
    }
    
}
