package cliente.operaciones;

import java.rmi.RemoteException;
import servidor.DTO.alertaDTO;
import Servidor.controladores.ControladorGestorAlertasInt;
import sop_corba.GestionPacientesOperations;
import sop_corba.GestionPacientesPackage.pacienteDTO;

/**
 *
 * @author Alejandro
 */
public class menuOperaciones {
    
    private pacienteDTO paciente;
    private alertaDTO alerta;
    private final ControladorGestorAlertasInt objRemoto;
    private final GestionPacientesOperations ref;
    private pacienteOperaciones pOps;
    private indicadorOperaciones objIndOps;
    
    public menuOperaciones(ControladorGestorAlertasInt objRemoto, GestionPacientesOperations ref) {
        this.objRemoto = objRemoto;
        this.ref = ref;
        this.pOps = new pacienteOperaciones();
        this.paciente = new pacienteDTO();
        this.alerta = new alertaDTO();
        this.objIndOps = new indicadorOperaciones();
    }

    public pacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(pacienteDTO paciente) {
        this.paciente = paciente;
    }

    public alertaDTO getAlerta() {
        return alerta;
    }

    public void setAlerta(alertaDTO alerta) {
        this.alerta = alerta;
    }

    public pacienteOperaciones getpOps() {
        return pOps;
    }

    public void setpOps(pacienteOperaciones pOps) {
        this.pOps = pOps;
    }

    public indicadorOperaciones getObjIndOps() {
        return objIndOps;
    }

    public void setObjIndOps(indicadorOperaciones objIndOps) {
        this.objIndOps = objIndOps;
    }
    
    public void imprimirMenu(){
        System.out.println("==========\tMenu de sensores\t==========");
        System.out.println("1. Ingresar datos del paciente");
        System.out.println("2. Comenzar lectura de los sensores");
        System.out.println("Digite una opcion: ");
    }
    
    public void opcionRegistroPaciente() {
        try {
            System.out.println("== Registro del paciente ==");

            this.pOps.ingresoNoHabitacion(this.paciente);
            this.pOps.ingresoNombreCompleto(this.paciente);
            this.pOps.ingresoEdad(this.paciente);
            
            System.out.println("Imprimiendo info paciente: "+this.paciente.nombres+","+this.paciente.apellidos+","+this.paciente.cantEdad);

            boolean bandera = this.ref.registrarPaciente(this.paciente);
            this.getObjIndOps().setCantidadEdad(this.paciente.getCantEdad());
            this.getObjIndOps().setTipoEdad(this.paciente.getTipoEdad());
            
            if (bandera) {
                System.out.println("Registro del paciente realizado satisfactoriamente...");
            } else {
                System.out.println("No se pudo realizar el registro...");
            }
            
        } catch (Exception e) {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
            System.out.println("Excepcion: "+e.getMessage());
        }
    }

    public void opcionComenzarLectura() {
        
        try{
            System.out.println("== Lectura de sensores ==");
            
            while (true){
                System.out.println("Enviando indicadores...\n");
                this.alerta.setNoHabitacion(this.paciente.noHabitacion);
                this.objIndOps.setObjAlerta(this.alerta);
                this.objIndOps.generarValoresIndicadores();
                
                alertaDTO bandera = this.objRemoto.enviarAlerta(this.alerta);
                
                if (bandera != null) {
                    
                    System.out.println("Freecuencia cardiaca: " + this.getAlerta().getContInd().getObjFC().getLatidosPM());
                    System.out.println("Presion arterial: " + this.getAlerta().getContInd().getObjTA().getSistolica()+"/"+this.getAlerta().getContInd().getObjTA().getDiastolica());
                    System.out.println("Freecuencia respiratoria: " + this.getAlerta().getContInd().getObjFR().getVentilacionesPM());
                    System.out.println("Temperatura : " + this.getAlerta().getContInd().getObjTemp().getGradosC()+" C");
                    System.out.println("Saturacion de oxigeno: " + this.getAlerta().getContInd().getObjSO().getPerOxigeno()+"%");
                    System.out.println("");
                } else {
                    System.out.println("No se pudo realizar el envío de los datos...");
                }
                Thread.sleep(8000);
            }
        }catch(RemoteException e){
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }catch(Exception e){
            System.out.println("Error! Excepcion: "+e.getMessage());
        }
        
    }
}
