package Servidor.controladores;

import Servidor.DTO.notificacionDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControladorCallBackNotificacionesInt extends Remote{
    public void notificarAlertaPaciente(notificacionDTO objAlerta) throws RemoteException;
}
