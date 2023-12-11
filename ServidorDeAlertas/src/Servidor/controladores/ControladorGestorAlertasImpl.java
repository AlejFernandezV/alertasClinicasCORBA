package Servidor.controladores;

import Servidor.repositorios.AlertasRepositoryInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.alertaDTO;

public class ControladorGestorAlertasImpl extends UnicastRemoteObject implements ControladorGestorAlertasInt{

    private AlertasRepositoryInt objRepositorio;
    
    public ControladorGestorAlertasImpl(AlertasRepositoryInt _repositorio) throws RemoteException{
        super();
        this.objRepositorio = _repositorio;
    }
    
    @Override
    public alertaDTO enviarAlerta(alertaDTO objAlerta) throws RemoteException {
        System.out.println("Invocando metodo enviar alerta");
        this.objRepositorio.agregarAlerta(objAlerta);
        return objAlerta;
    }
}
