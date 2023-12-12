package Servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Servidor.DTO.alertaDTO;

public interface ControladorGestorAlertasInt extends Remote{
    alertaDTO enviarAlerta(alertaDTO objAlerta) throws RemoteException;
}
