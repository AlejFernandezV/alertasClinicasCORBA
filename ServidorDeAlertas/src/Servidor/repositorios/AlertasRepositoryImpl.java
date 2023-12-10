
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

    private LinkedList<alertaDTO> alertas;
    private analisisIndicadores objAnalisisInd;
    private almacenarInfoAlerta objArchivo;
    private GestionPacientesOperations ref;
    private final ControladorGestorNotificacionesInt objRemoto;
    private pacienteDTO objPaciente;
    private int puntuacion;

    public AlertasRepositoryImpl(GestionPacientesOperations _ref,ControladorGestorNotificacionesInt objRemoto) {
        this.ref = _ref;
        this.objAnalisisInd = new analisisIndicadores();
        this.objRemoto = objRemoto;
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
        if(puntuacion == 2){
            this.objArchivo.guardarEnArchivo(objPaciente, puntuacion);
            this.enviarNotificacion(objPaciente,alerta,puntuacion);
            System.out.println("Enviando alerta a enfermeras! ");
        }
        else if(puntuacion >= 3){
            this.objArchivo.guardarEnArchivo(objPaciente, puntuacion);
            this.enviarNotificacion(objPaciente,alerta,puntuacion);
            System.out.println("Enviando alerta a enfermeras y médico!");
        }
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

        } catch (Exception ex) {
            System.out.println("Error al enviar la notificación!");
            System.out.println("Excepcion: "+ex.getMessage());
        }
    }
    
}
