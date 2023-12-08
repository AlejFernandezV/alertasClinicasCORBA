package controladores;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import DTO.Notificacion;
import Repositorios.NotificacionRepositoryInt;
/**
 *
 * @author Jhossef
 */
public class ControladorGestorNotificacionesImpl extends UnicastRemoteObject implements ControladorGestorNotificacionesInt{
    
    NotificacionRepositoryInt repositorio;
    
    public ControladorGestorNotificacionesImpl(NotificacionRepositoryInt repositorio) throws RemoteException {
        super();
        this.repositorio = repositorio;
    }
    
    @Override
    public Notificacion notificar(Notificacion objNotificacion) throws RemoteException {
        System.out.println("Notificación recibida!");
        return repositorio.registrarNotificacion(objNotificacion);
    }
}
