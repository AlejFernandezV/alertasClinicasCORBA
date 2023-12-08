package Servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.alertaDTO;

public interface ControladorCallBackNotificacionesInt extends Remote{
    public void notificarAlertaPaciente(alertaDTO objAlerta) throws RemoteException;
}
