package servidor.operaciones.verificaciones;

import servidor.DTO.Indicadores.*;
import servidor.DTO.alertaDTO;
import sop_corba.GestionPacientesPackage.pacienteDTO;

/**
 *
 * @author Alejandro
 */
public class verificarNormIndicador {
    private contenedorIndicadores contInd;
    private String tipoEdad;
    private int cantidadEdad;
    
    public verificarNormIndicador(){    
    }

    public verificarNormIndicador(pacienteDTO paciente, alertaDTO alerta) {
        this.contInd =  alerta.getContInd();
        this.tipoEdad = paciente.tipoEdad;
        this.cantidadEdad = paciente.cantEdad;
    }

    public contenedorIndicadores getContInd() {
        return contInd;
    }

    public void setContInd(contenedorIndicadores contInd) {
        this.contInd = contInd;
    }

    public String getTipoEdad() {
        return tipoEdad;
    }

    public void setTipoEdad(String tipoEdad) {
        this.tipoEdad = tipoEdad;
    }

    public int getCantidadEdad() {
        return cantidadEdad;
    }

    public void setCantidadEdad(int cantidadEdad) {
        this.cantidadEdad = cantidadEdad;
    }
    
    public int normalidadFC(){
        frecuenciaCardiaca objFC = this.contInd.getObjFC();
        int valor = objFC.getLatidosPM();
        
        if((this.tipoEdad.equals("semanas") || this.tipoEdad.equals("días") || this.tipoEdad.equals("dias")) && 
                (this.cantidadEdad < 6) &&
                (valor < 120 || valor > 140)){
            return 1;
        }
        else if((this.tipoEdad.equals("semanas") && (this.cantidadEdad >= 7))|| 
                (this.tipoEdad.equals("meses") && (this.cantidadEdad <= 11)) &&
                (valor < 100 || valor > 130)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && this.cantidadEdad == 1 && (valor < 100 || valor > 120)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 2 && this.cantidadEdad < 6) && (valor < 80 || valor > 120)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 6 && this.cantidadEdad < 13) && (valor < 80 || valor > 100)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 13 && this.cantidadEdad < 16) && (valor < 70 || valor > 80)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 16) && (valor < 60 || valor > 80)){
            return 1;
        }
        return -1;
    }
    
    public int normalidadTA(){
        tensionArterial objTA = this.contInd.getObjTA();
        int valorS = objTA.getSistolica();
        int valorD = objTA.getDiastolica();
        
        if((this.tipoEdad.equals("semanas") || this.tipoEdad.equals("días") || this.tipoEdad.equals("dias")) && 
                (this.cantidadEdad < 6) &&
                ((valorS < 70 || valorS > 100) || (valorD < 50 || valorD > 68))){
            return 1;
        }
        else if((this.tipoEdad.equals("semanas") && (this.cantidadEdad > 7))|| 
                (this.tipoEdad.equals("meses") && (this.cantidadEdad <= 11)) &&
                ((valorS < 84 || valorS > 106) || (valorD < 56 || valorD > 70))){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && this.cantidadEdad == 1 && ((valorS < 98 || valorS > 106) || (valorD < 58 || valorD > 70))){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 2 && this.cantidadEdad < 6) && ((valorS < 99 || valorS > 112) || (valorD < 64 || valorD > 70))){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 6 && this.cantidadEdad < 13) && ((valorS < 104 || valorS > 124) || (valorD < 64 || valorD > 86))){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 13 && this.cantidadEdad < 16) && ((valorS < 118 || valorS > 132) || (valorD < 70 || valorD > 82))){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 16) && ((valorS < 110 || valorS > 140) || (valorD < 70 || valorD > 90))){
            return 1;
        }
        return -1;
    }
    
    public int normalidadFR(){
        frecuenciaRespiratoria objFR = this.contInd.getObjFR();
        int valor = objFR.getVentilacionesPM();
        
        if((this.tipoEdad.equals("semanas") || this.tipoEdad.equals("días") || this.tipoEdad.equals("dias")) && 
                (this.cantidadEdad < 6) &&
                (valor < 40 || valor > 45)){
            return 1;
        }
        else if((this.tipoEdad.equals("semanas") && (this.cantidadEdad > 7))|| 
                (this.tipoEdad.equals("meses") && (this.cantidadEdad <= 11)) ||
                (this.tipoEdad.equals("años") && (this.cantidadEdad >= 1 && this.cantidadEdad <6)) &&
                (valor < 20 || valor > 30)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 6) && (valor < 12 || valor > 20)){
            return 1;
        }
        
        return -1;
    }
    
    public int normalidadTemp(){
        temperatura objTemp = this.contInd.getObjTemp();
        double valor = objTemp.getGradosC();
        
        if((this.tipoEdad.equals("semanas") || this.tipoEdad.equals("días") || this.tipoEdad.equals("dias")) && 
                (this.cantidadEdad < 6) &&
                (valor < 38.0 || valor > 38.0)){
            return 1;
        }
        else if((this.tipoEdad.equals("semanas") && (this.cantidadEdad > 7))|| 
                (this.tipoEdad.equals("meses") && (this.cantidadEdad <= 11)) ||
                (this.tipoEdad.equals("años") && (this.cantidadEdad >= 1 && this.cantidadEdad <6)) &&
                (valor < 37.5 || valor > 37.8)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 6 && this.cantidadEdad < 13) && (valor < 37.0 || valor > 37.5)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 13 && this.cantidadEdad < 16) && (valor < 37.0 || valor > 37.0)){
            return 1;
        }
        else if(this.tipoEdad.equals("años") && (this.cantidadEdad >= 16) && (valor < 36.2 || valor > 37.2)){
            return 1;
        }
        
        return -1;
    }
    
    public int normalidadSO(){
        saturacionOxigeno objSO = this.contInd.getObjSO();
        int valor = objSO.getPerOxigeno();
        
        if( valor <  90){
            return 1;
        }
        
        return -1;
    }
}
