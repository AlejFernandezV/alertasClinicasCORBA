package Servidor.controladores;

import Servidor.respositorios.PacienteRepositoryInt;
import sop_corba.GestionPacientesPOA;
import sop_corba.GestionPacientesPackage.pacienteDTO;

public class GestionPacienteImpl extends GestionPacientesPOA{
    
    private PacienteRepositoryInt objRepositorio;
    
    public GestionPacienteImpl(PacienteRepositoryInt _repositorio){
        this.objRepositorio = _repositorio;
    }
    
    @Override
    public boolean registrarPaciente(pacienteDTO objPaciente) {
       System.out.println("Invocando a registrar paciente");
       boolean bandera=false;
       try{
           this.objRepositorio.registrarPaciente(objPaciente);
           bandera = true;
       }catch(Exception e){
           System.out.println("Error: "+e.getMessage());
       }finally{
           return bandera;
       }
    }

    @Override
    public pacienteDTO consultarPaciente(int noHabitacion) {
        System.out.println("Invocando a consultar paciente");
        return this.objRepositorio.consultarPaciente(noHabitacion);
    }    
}
