
package Repositorios;

import java.rmi.RemoteException;
import java.util.List;
import DTO.notificacionDTO;

public interface NotificacionRepositoryInt
{    
    public notificacionDTO registrarNotificacion (notificacionDTO objNotificacion)throws RemoteException;
}


