package servidor.DTO;

import java.io.Serializable;
import servidor.DTO.Indicadores.contenedorIndicadores;

public class alertaDTO implements Serializable{
    private contenedorIndicadores contInd;
    private int noHabitacion;

    public alertaDTO() {
    }

    public alertaDTO(int _noHabitacion) {
        this.noHabitacion = _noHabitacion;
        this.contInd = new contenedorIndicadores();
    }

    public contenedorIndicadores getContInd() {
        return contInd;
    }

    public void setContInd(contenedorIndicadores contInd) {
        this.contInd = contInd;
    }

    public int getNoHabitacion() {
        return noHabitacion;
    }

    public void setNoHabitacion(int noHabitacion) {
        this.noHabitacion = noHabitacion;
    }
}
