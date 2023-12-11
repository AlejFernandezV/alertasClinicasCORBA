
package Servidor.Repositorios;

import java.rmi.RemoteException;
import Servidor.DTO.notificacionDTO;

public interface NotificacionRepositoryInt
{    
    public notificacionDTO registrarNotificacion (notificacionDTO objNotificacion)throws RemoteException;
}


