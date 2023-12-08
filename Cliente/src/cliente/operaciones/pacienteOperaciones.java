package cliente.operaciones;

import cliente.utilidades.UtilidadesConsola;
import sop_corba.GestionPacientesPackage.pacienteDTO;

/**
 *
 * @author Alejandro
 */
public class pacienteOperaciones {
    
    public void ingresoNoHabitacion(pacienteDTO paciente){
        int noHabitacion;
        
        do{
            System.out.println("Ingrese el numero de la habitacion: ");
            noHabitacion = UtilidadesConsola.leerEntero();
            
            if((noHabitacion < 100) || (noHabitacion > 999)){
                System.out.println("Error! Numero de habitacion no valido...");
            }
            else{
                paciente.setNoHabitacion(noHabitacion);
                System.out.println("Ingreso del numero de habitacian exitoso");
            }
        }while((noHabitacion < 99) || (noHabitacion > 1000));
    }
    
    public void ingresoNombreCompleto(pacienteDTO paciente){
        String nombres, apellidos;
        
        System.out.println("Ingrese los nombres: ");
        nombres = UtilidadesConsola.leerCadena();
        
        System.out.println("Ingrese los apellidos: ");
        apellidos = UtilidadesConsola.leerCadena();
        
        paciente.setNombres(nombres);
        paciente.setApellidos(apellidos);
        
        System.out.println("Ingreso del nombre completo exitoso");
    }
     
    public void ingresoEdad(pacienteDTO paciente){
        boolean band = false;
        int opcionEdad = 0;
        do{
            this.imprimirMenuEdad();
            opcionEdad = UtilidadesConsola.leerEntero();
            
            band = this.seleccionEdad(opcionEdad, paciente);
        }while (band == false); 
    }
    
    private void imprimirMenuEdad(){
        System.out.println("\t\tOpciones edad");
        System.out.println("1. Dias");
        System.out.println("2. Semanas");
        System.out.println("3. Meses");
        System.out.println("4. Años");
        System.out.println("Ingrese una opcion: ");
    }
    
    private boolean seleccionEdad(int opcion,pacienteDTO paciente){
        int cantidadEdad = 0;
        boolean band = false;
        switch(opcion){
            case 1:
                paciente.setTipoEdad("dias");
                do{
                    
                    System.out.println("Ingrese la cantidad de dias:");
                    cantidadEdad = UtilidadesConsola.leerEntero();
                    
                    paciente.setCantEdad(cantidadEdad);
                    
                    if(cantidadEdad < 1)
                        System.out.println("Error! La edad no puede ser menor o igual a 0");
                    else{
                        System.out.println("Ingreso de la edad exitoso");
                        band = true;
                    }
                }while(cantidadEdad < 1);                
                break;
            case 2:
                paciente.setTipoEdad("semanas");
                do{
                    
                    System.out.println("Ingrese la cantidad de semanas:");
                    cantidadEdad = UtilidadesConsola.leerEntero();
                    paciente.setCantEdad(cantidadEdad);
                    
                    if(cantidadEdad < 1)
                        System.out.println("Error! La edad no puede ser menor o igual a 0");
                    else{
                        System.out.println("Ingreso de la edad exitoso");
                        band = true;
                    }
                    
                }while(cantidadEdad < 1);
                break;
            case 3:
                paciente.setTipoEdad("meses");
                do{
                    
                    System.out.println("Ingrese la cantidad de meses:");
                    cantidadEdad = UtilidadesConsola.leerEntero();
                    paciente.setCantEdad(cantidadEdad);
                    
                    if(cantidadEdad < 1)
                        System.out.println("Error! La edad no puede ser menor o igual a 0");
                    else{
                        System.out.println("Ingreso de la edad exitoso");
                        band = true;
                    }
                    
                }while(cantidadEdad < 1);
                break;
            case 4:
                paciente.setTipoEdad("años");
                do{
                    
                    System.out.println("Ingrese la cantidad de años:");
                    cantidadEdad = UtilidadesConsola.leerEntero();
                    paciente.setCantEdad(cantidadEdad);
                    
                    if(cantidadEdad < 1)
                        System.out.println("Error! La edad no puede ser menor o igual a 0");
                    else{
                        System.out.println("Ingreso de la edad exitoso");
                        band = true;
                    }
                    
                }while(cantidadEdad < 1);    
                break;
            default:
                System.out.println("Opcion incorrecta!");
                break;
        }
        return band;
    }
    
}
