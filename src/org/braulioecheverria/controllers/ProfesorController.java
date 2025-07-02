package org.braulioecheverria.controllers;

import java.util.ArrayList;
import org.braulioecheverria.models.Profesor;
import org.braulioecheverria.utils.SingletonScanner;
import org.braulioecheverria.utils.InputException;

public class ProfesorController {
    final java.util.Scanner leer = SingletonScanner.getInstance().getScanner();
    ArrayList<Profesor> profesores = new ArrayList<>();

    public ProfesorController(){}
    
    public void agregarProfesor(){
        
        Profesor profesor = new Profesor();
        System.out.println("Ingresa nombres");
        profesor.setNombres(leer.nextLine());
        System.out.println("Ingresa apellidos");
        profesor.setApellidos(leer.nextLine());
        //codigo exis que va a tener alguna exceción de cualquier tipo
        while (true){
            try{
                System.out.println("Ingresa la edad");
                if(!leer.hasNextInt()){
                    throw new InputException("Edad no válida, se espera un número");
                } 
                profesor.setEdad(leer.nextInt());
                leer.nextLine();
                break;
            }catch(InputException error){
                System.out.println(error.getMessage());
                leer.nextLine();
            }
        }
        
        while(true){
            try{
                System.out.println("Ingresa el email");
                profesor.setEmail(leer.nextLine());
                if(profesor.getEmail().equals("Email inválido")){
                    throw new InputException("Ingrese un email valido");
                }else{
                    break;
                }
            }catch(InputException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Ingresa el # teléfono");
        profesor.setPhone(leer.nextLine());
        System.out.println("Ingresa el ID");
        profesor.setId(leer.nextLine());
        profesores.add(profesor);
    }
    
    public void listarProfesores(){
        for(int i = 0; i < profesores.size(); i++){
            System.out.println(profesores.get(i));
        }
    }
    
    public Profesor buscarProfesor(String id){
        Profesor profesorTemporal;
        Profesor mostrarProfesor = new Profesor();
        for(int i = 0; i < profesores.size(); i++){
            profesorTemporal = profesores.get(i);
            if(profesorTemporal.getId().equals(id)){
               mostrarProfesor = profesorTemporal; 
            }
        }
        return mostrarProfesor;
    }
    
    public Profesor actualizarProfesor(String id){
        Profesor profesorTemporal = new Profesor();
        Profesor profesorActualizado = new Profesor();
        
        for(int i = 0; i < profesores.size(); i++){
            profesorTemporal = profesores.get(i);
            if(profesorTemporal.getId().equals(id)){
                profesorActualizado = profesorTemporal;
                profesores.remove(i);
            }
        }
        
        System.out.println("Los datos del profesor buscado son: ");
        System.out.println(profesorTemporal.toString());
        System.out.println("----------------------------------------");
        System.out.println("INGRESA AHORA LOS NUEVOS DATOS");
        System.out.println("Ingresa nombres");
        profesorActualizado.setNombres(leer.nextLine());
        System.out.println("Ingresa apellidos");
        profesorActualizado.setApellidos(leer.nextLine());
        System.out.println("Ingresa telefono");
        profesorActualizado.setPhone(leer.nextLine());
        
        int eleccion;
        while(true){
            try{
                System.out.println("Estas seguro que deseas actualizar los datos");
                System.out.println("1. Para si, 2. Para No");
                if(!leer.hasNextInt()){
                    throw new InputException("Debes ingresar un numero valido");
                }
                eleccion = leer.nextInt();
                leer.nextLine();
                if(eleccion == 1 || eleccion == 2){
                    break;
                }else{
                    System.out.println("Opcion no valida, selecciona una correcta");
                }
            }catch(InputException e){
                System.out.println(e.getMessage());
                leer.nextLine();
            }
        }  
        
        if(eleccion == 1){
            System.out.println("Datos actualizados exitosamente");
            profesorTemporal = profesorActualizado;
            profesores.add(profesorTemporal);
        }else{
            System.out.println("No se realizaron cambios");
            profesores.add(profesorTemporal);
        }
        return profesorTemporal;
    }
    
    public String eliminarProfesor(String id){
        String respuesta = "";
        Profesor profesorEncontrado;
        for(int i = 0; i < profesores.size(); i++){
            profesorEncontrado = profesores.get(i);
            if(profesorEncontrado.getId().equals(id)){
                profesores.remove(i);
                respuesta = "Profesore eliminado exitosamente";
            }
        }
        return respuesta;
    }
}
