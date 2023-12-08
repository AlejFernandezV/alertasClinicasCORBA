
package Repositorios;

import java.rmi.RemoteException;
import java.util.List;
import DTO.Notificacion;

public interface NotificacionRepositoryInt
{    
    public Notificacion registrarNotificacion (Notificacion objNotificacion)throws RemoteException;
}


