package Servidor.controladores;

import Servidor.repositorios.AlertasRepositoryInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.alertaDTO;
import servidor.operaciones.analisisIndicadores;

public class ControladorGestorAlertasImpl extends UnicastRemoteObject implements ControladorGestorAlertasInt{

    private AlertasRepositoryInt objRepositorio;
    private analisisIndicadores objAnalisisInd;
    
    public ControladorGestorAlertasImpl(AlertasRepositoryInt _repositorio) throws RemoteException{
        super();
        this.objRepositorio = _repositorio;
        this.objAnalisisInd = new analisisIndicadores();
    }
    
    @Override
    public alertaDTO enviarAlerta(alertaDTO objAlerta) throws RemoteException {
        System.out.println("Invocando metodo enviar alerta");
        this.objRepositorio.agregarAlerta(objAlerta);
        return objAlerta;
    }
    
}
