package Servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import servidor.DTO.notificacionDTO;

public class ControladorGestorNotificacionesImpl extends UnicastRemoteObject implements ControladorGestorNotificacionesInt{
    
    private final LinkedList<ControladorCallBackNotificacionesInt> listaReferencias;

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
    public void notificarServidorNotificaciones(notificacionDTO objNotificacion){
        System.out.println("Notificando a Servidor notificaciones...");
        this.listaReferencias.forEach(
                obj -> {
                    try{
                        obj.notificarAlertaPaciente(objNotificacion);
                    }catch(Exception e){
                        System.out.println("Error: "+e.getMessage());
                    }
                }
        );
    }
    
}
