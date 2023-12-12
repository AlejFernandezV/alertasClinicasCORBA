package Servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import Servidor.DTO.notificacionDTO;

public class ControladorGestorNotificacionesImpl extends UnicastRemoteObject implements ControladorGestorNotificacionesInt{
    
    private LinkedList<ControladorCallBackNotificacionesInt> listaReferencias;

    public ControladorGestorNotificacionesImpl() throws RemoteException{
        super();
        this.listaReferencias = new LinkedList();
    }
    
    @Override
    public boolean registrarReferenciaRemota(ControladorCallBackNotificacionesInt referencia) throws RemoteException {
        System.out.println("Agregando referencia remota...");
        return this.listaReferencias.add(referencia);
    }
    
    @Override
    public void notificarServidorNotificaciones(notificacionDTO objNotificacion) throws RemoteException{
        System.out.println("Notificando a Servidor notificaciones...");
        this.listaReferencias.forEach(
                obj -> {
                    try{
                        obj.notificarAlertaPaciente(objNotificacion);
                    }catch(RemoteException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                }
        );
    }
    
}
