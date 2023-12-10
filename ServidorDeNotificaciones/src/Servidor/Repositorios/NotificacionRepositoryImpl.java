package Servidor.Repositorios;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import DTO.notificacionDTO;
import Repositorios.NotificacionRepositoryInt;


/**
 *
 * @author Jhossef
 */
public class NotificacionRepositoryImpl implements NotificacionRepositoryInt{

    private LinkedList<notificacionDTO> notificaciones;
    
    public NotificacionRepositoryImpl() {
        this.notificaciones = new LinkedList();
    }

    @Override
    public notificacionDTO registrarNotificacion(notificacionDTO objNotificacion) {
        this.notificaciones.add(objNotificacion);
        objNotificacion.imprimir();
        this.mostrarNotificaciones(objNotificacion.getNoHabitacion());
        return objNotificacion;
    }
    
    private void mostrarNotificaciones(int noHabitacion){
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        ArrayList<notificacionDTO> auxNotificacion = new ArrayList<>();
        for(int i = this.notificaciones.size()-1; i <= 0; i --){
            notificacionDTO noti = this.notificaciones.get(i);
            if(noti.getNoHabitacion() == noHabitacion){
                auxNotificacion.add(noti);
            }
        }
        
        System.out.println("\t\tUltimas 5 alertas:");
        System.out.println("|    Fecha   |   Hora   | Puntuacion |");
        System.out.println("|------------|----------|------------|");
        
        for (int i = 0; i<auxNotificacion.size();i++){
            if(i < 5){
                System.out.printf("| %s | %s |      %s     |\n", auxNotificacion.get(i).getFechaAlerta(),
                    auxNotificacion.get(i).getHoraAlerta().format(formatoHora),auxNotificacion.get(i).getPuntuacion());
            }
        }   
    }
}
