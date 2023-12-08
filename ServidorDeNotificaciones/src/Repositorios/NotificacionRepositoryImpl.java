package Repositorios;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import DTO.Notificacion;
import Repositorios.NotificacionRepositoryInt;


/**
 *
 * @author Jhossef
 */
public class NotificacionRepositoryImpl implements NotificacionRepositoryInt{

    private LinkedList<Notificacion> notificaciones;
    
    public NotificacionRepositoryImpl() {
        this.notificaciones = new LinkedList();
    }

    @Override
    public Notificacion registrarNotificacion(Notificacion objNotificacion) {
        this.notificaciones.add(objNotificacion);
        objNotificacion.imprimir();
        this.mostrarNotificaciones(objNotificacion.getNoHabitacion());
        return objNotificacion;
    }
    
    private void mostrarNotificaciones(int noHabitacion){
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        ArrayList<Notificacion> auxNotificacion = new ArrayList<>();
        for(Notificacion noti: this.notificaciones.reversed()){
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
