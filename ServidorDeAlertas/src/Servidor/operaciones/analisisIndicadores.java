package servidor.operaciones;

import servidor.DTO.Indicador;
import servidor.DTO.notificacionDTO;
import servidor.DTO.alertaDTO;
import servidor.operaciones.verificaciones.verificarNormIndicador;
import sop_corba.GestionPacientesPackage.pacienteDTO;

/**
 *
 * @author Alejandro
 */
public class analisisIndicadores {

    public analisisIndicadores() {
    }
    
    public int calcularPuntuacion(pacienteDTO objPaciente,alertaDTO objAlerta){
        verificarNormIndicador objVNI = new verificarNormIndicador(objPaciente,objAlerta);
        int sumPuntos = 0;
        if(objVNI.normalidadFC() == 1){
            sumPuntos = sumPuntos + 1;
        }
        if(objVNI.normalidadTA() == 1){
            sumPuntos = sumPuntos + 1;
        }
        if(objVNI.normalidadFR() == 1){
            sumPuntos = sumPuntos + 1;
        }
        if(objVNI.normalidadTemp() == 1){
            sumPuntos = sumPuntos + 1;
        }
        if(objVNI.normalidadSO() == 1){
            sumPuntos = sumPuntos + 1;
        }
        return sumPuntos;
    }
    
    public void agregarIndicadoresRaros(pacienteDTO objPaciente,alertaDTO objAlerta,notificacionDTO objNotificacion){
        verificarNormIndicador objVNI = new verificarNormIndicador(objPaciente,objAlerta);
        if(objVNI.normalidadFC() == 1){
            Indicador objIndicador = new Indicador("Frecuencia Cardiaca",objAlerta.getContInd().getObjFC().getLatidosPM()+"");
            objNotificacion.getIndicadores().add(objIndicador);
        }
        if(objVNI.normalidadTA() == 1){
            Indicador objIndicador = new Indicador("Tension Arterial",objAlerta.getContInd().getObjTA().getSistolica()+"/"+objAlerta.getContInd().getObjTA().getDiastolica());
            objNotificacion.getIndicadores().add(objIndicador);
        }
        if(objVNI.normalidadFR() == 1){
            Indicador objIndicador = new Indicador("Frecuencia Respiratoria",objAlerta.getContInd().getObjFR().getVentilacionesPM()+"");
            objNotificacion.getIndicadores().add(objIndicador);
        }
        if(objVNI.normalidadTemp() == 1){
            Indicador objIndicador = new Indicador("Temperatura",objAlerta.getContInd().getObjTemp().getGradosC()+"");
            objNotificacion.getIndicadores().add(objIndicador);
        }
        if(objVNI.normalidadSO() == 1){
            Indicador objIndicador = new Indicador("Saturacion Oxigeno",objAlerta.getContInd().getObjSO().getPerOxigeno()+"");
            objNotificacion.getIndicadores().add(objIndicador);
        }
    }
    
}
