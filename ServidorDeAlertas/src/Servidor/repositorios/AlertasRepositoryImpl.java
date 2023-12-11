
package Servidor.repositorios;

import Servidor.controladores.ControladorGestorNotificacionesImpl;
import Servidor.controladores.ControladorGestorNotificacionesInt;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.time.LocalDate;
import java.time.LocalTime;
import servidor.DTO.alertaDTO;
import servidor.DTO.notificacionDTO;
import servidor.operaciones.analisisIndicadores;
import servidor.operaciones.guardadoInfo.almacenarInfoAlerta;
import sop_corba.GestionPacientesOperations;
import sop_corba.GestionPacientesPackage.pacienteDTO;

public class AlertasRepositoryImpl implements AlertasRepositoryInt{
    
    private GestionPacientesOperations ref;
    private final ControladorGestorNotificacionesInt objRemoto;
    private LinkedList<alertaDTO> alertas;
    private analisisIndicadores objAnalisisInd;
    private almacenarInfoAlerta objArchivo;
    private pacienteDTO objPaciente;
    private int puntuacion;

    public AlertasRepositoryImpl(GestionPacientesOperations _ref,ControladorGestorNotificacionesInt objRemoto) {
        this.ref = _ref;
        this.objRemoto = objRemoto;
        this.alertas = new LinkedList();
        this.objAnalisisInd = new analisisIndicadores();
        this.objArchivo = new almacenarInfoAlerta();
    }

    @Override
    public boolean agregarAlerta(alertaDTO _alerta) {
        if(_alerta != null){
            this.alertas.add(_alerta);
            this.objPaciente = this.ref.consultarPaciente(_alerta.getNoHabitacion());
            this.puntuacion = this.objAnalisisInd.calcularPuntuacion(this.objPaciente,_alerta);
            analizarAlerta(_alerta);
            return true;
        }
        return false;
    }

    @Override
    public alertaDTO buscarAlerta(int noHabitacion) {
       for(int i=0; i < this.alertas.size(); i++){
           if(this.alertas.get(i).getNoHabitacion() == noHabitacion){
               return this.alertas.get(i);
           }
       }
       return null;
    }
    
    private void analizarAlerta(alertaDTO alerta){
        System.out.println("Imprimiendo puntuacion: "+ puntuacion);
        if(this.puntuacion == 2){
            System.out.println("Enviando alerta a enfermeras! ");
        }
        else if(this.puntuacion >= 3){    
            System.out.println("Enviando alerta a enfermeras y médico!");
        }
        this.objArchivo.guardarEnArchivo(this.objPaciente, this.puntuacion);
        this.enviarNotificacion(this.objPaciente,alerta,this.puntuacion);
    }
    
    private void enviarNotificacion(pacienteDTO paciente,alertaDTO alerta,int puntuacion){
        try {
            String nombreCompleto = paciente.nombres+" "+paciente.apellidos;
            String edad = paciente.cantEdad+" "+paciente.tipoEdad;
            LocalTime horaActual = LocalTime.now();
            LocalDate fechaActual = LocalDate.now();
            notificacionDTO objNotificacion = new notificacionDTO(paciente.noHabitacion
                    ,nombreCompleto,edad,horaActual,fechaActual,puntuacion);
            
            this.objAnalisisInd.agregarIndicadoresRaros(paciente, alerta,objNotificacion);
            
            this.objRemoto.notificarServidorNotificaciones(objNotificacion);
            System.out.println("Notificación enviada con exito!");

        } catch (RemoteException ex) {
            System.out.println("Error al enviar la notificación!");
            System.out.println("Excepcion: "+ex.getMessage());
        }
    }
    
}
