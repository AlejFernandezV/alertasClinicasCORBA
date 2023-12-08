package Servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.alertaDTO;

public class ControladorCallBackNotificacionesImpl extends UnicastRemoteObject implements ControladorCallBackNotificacionesInt{

    public ControladorCallBackNotificacionesImpl() throws RemoteException{
        super();
    }

    
    
    @Override
    public void notificarAlertaPaciente(alertaDTO objAlerta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
