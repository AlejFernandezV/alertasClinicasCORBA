
package Servidor.repositorios;

import java.util.LinkedList;
import servidor.DTO.alertaDTO;
import servidor.operaciones.guardadoInfo.almacenarInfoAlerta;

public class AlertasRepositoryImpl implements AlertasRepositoryInt{

    private LinkedList<alertaDTO> alertas;
    private almacenarInfoAlerta objArchivo;
    
    @Override
    public boolean agregarAlerta(alertaDTO _alerta) {
        if(_alerta != null){
            this.alertas.add(_alerta);
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
    
}