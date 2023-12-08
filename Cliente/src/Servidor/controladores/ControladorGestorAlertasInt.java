package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.alertaDTO;

public interface ControladorGestorAlertasInt extends Remote{
    alertaDTO enviarAlerta(alertaDTO objAlerta) throws RemoteException;
}
