package Servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Servidor.DTO.notificacionDTO;

public interface ControladorCallBackNotificacionesInt extends Remote{
    public void notificarAlertaPaciente(notificacionDTO objAlerta) throws RemoteException;
}
