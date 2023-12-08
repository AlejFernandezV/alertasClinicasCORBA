package servidor.DTO.Indicadores;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class frecuenciaRespiratoria implements Serializable{
    private int ventilacionesPM;

    public frecuenciaRespiratoria() {
    }

    public int getVentilacionesPM() {
        return ventilacionesPM;
    }

    public void setVentilacionesPM(int ventilacionesPM) {
        this.ventilacionesPM = ventilacionesPM;
    } 
}
