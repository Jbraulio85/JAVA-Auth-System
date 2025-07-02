package org.braulioecheverria.views;

import org.braulioecheverria.utils.SingletonScanner;
import org.braulioecheverria.controllers.AlumnoController;
import org.braulioecheverria.models.Alumno;

public class AlumnoView {
    Integer op1, op2;
    Boolean flag = true;
    String carnet;
    //para constantes es en MAYUSCULA
    final java.util.Scanner LEER = SingletonScanner.getInstance().getScanner();
    AlumnoController ac = new AlumnoController();
    Alumno alumno;
    
    public void menuAlumno(){
        flag = true;
        while(flag){
            try{
                System.out.println("\n --- MENU DE ALUMNO ---");
                System.out.println("1. Agregar alumno");
                System.out.println("2. Listar alumnos");
                System.out.println("3. Buscar alumno");
                System.out.println("4. Actualizar alumno");
                System.out.println("5. Eliminar alumno");
                System.out.println("6. Regresar al menu general");
                int opcion = 0;
                while(true){
                    System.out.println("Selecciona una opcion: ");
                    if(!LEER.hasNextInt()){
                        System.out.println("Entrada inválida, se esperaba un numero");
                        LEER.nextLine();
                    }
                    opcion = LEER.nextInt();
                    LEER.nextLine();
                    break;
                }
                op1 = opcion;
                switch(op1){
                    case 1 -> {
                        ac.agregarAlumno();
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 2 -> {
                        ac.listarAlumnos();
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 3 -> {
                        System.out.println("Ingresa el carnet a buscar");
                        carnet = LEER.nextLine();
                        alumno = ac.buscarAlumno(carnet);
                        if(alumno != null) System.out.println(alumno);
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 4 -> {
                        System.out.println("Ingresa el carnet a actualizar");
                        carnet = LEER.nextLine();
                        alumno = ac.actualizarAlumno(carnet);
                        if(alumno != null) System.out.println(alumno);
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 5 -> {
                        System.out.println("Ingresa el carnet a eliminar");
                        carnet = LEER.nextLine();
                        System.out.println(ac.eliminarAlumno(carnet));
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 6 -> {
                        flag = false;
                    }
                    default -> {
                        System.out.println("Opcion no valida");
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                }
            }catch(Exception e){
                System.out.println("Error inesperado " + e.getMessage());
                LEER.nextLine();
            }
        }
    }
    
    private int pedirContinuar(){
        op1 = 0;
        while(true){
            System.out.println("¿Deseas continuar? (1. Si, 2. No)");
            if(!LEER.hasNextInt()){
                System.out.println("Entrada invalida, se esperaba un numero.");
                LEER.nextLine();
            }
            op1 = LEER.nextInt();
            if(op1 == 1 || op1 == 2) break;
            else System.out.println("Opcion no valida");
        }
        return op1;
    }
    
    public static boolean menuRepetir(int op){
        return op != 2;
    }
}
