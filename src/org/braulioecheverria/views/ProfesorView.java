package org.braulioecheverria.views;

import org.braulioecheverria.controllers.ProfesorController;
import org.braulioecheverria.models.Profesor;
import org.braulioecheverria.utils.SingletonScanner;

public class ProfesorView {
    Integer op1, op2;
    boolean flag = true;
    final java.util.Scanner leer = SingletonScanner.getInstance().getScanner();
    ProfesorController pc = new ProfesorController();
    Profesor pf;
    
    public ProfesorView(){}
    
    public void menuProfesor(){
        while(flag){
            try{
                System.out.println("\n === MENU PROFESOR ===");
                System.out.println("1. Agregar profesor");
                System.out.println("2. Listar profesores");
                System.out.println("3. Buscar profesor");
                System.out.println("4. Actualizar profesor");
                System.out.println("5. Eliminar profesor");
                System.out.println("6. Volver al menu general");
                int opcion = 0;
                while(true){
                    if(!leer.hasNextInt()){
                        System.out.println("Entrada invalida, se esperaba un numero");
                        leer.nextLine();
                    }
                    opcion = leer.nextInt();
                    leer.nextLine();
                    break;
                }
                op1 = opcion;
                switch(op1){
                    case 1 -> {
                        pc.agregarProfesor();
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 2 -> {
                        pc.listarProfesores();
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 3 -> {
                        System.out.println("Ingresa el ID del profesor a buscar");
                        String id = leer.nextLine();
                        pf = pc.buscarProfesor(id);
                        System.out.println(pf);
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 4 -> {
                        System.out.println("Ingresa el ID del profesor a actualizar");
                        String id = leer.nextLine();
                        pf = pc.actualizarProfesor(id);
                        System.out.println(pf);
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 5 -> {
                        System.out.println("Ingresa el ID del profesor a eliminar");
                        String id = leer.nextLine();
                        System.out.println(pc.eliminarProfesor(id));
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                    case 6 -> {
                        flag = false;
                    }
                    default -> {
                        System.out.println("Opción no válida");
                        op2 = pedirContinuar();
                        flag = menuRepetir(op2);
                    }
                }
            }catch(Exception e){
                System.out.println("Error inesperado " + e.getMessage());
                leer.nextLine();
            }
        }
    }
    
    private int pedirContinuar(){
        op1 = 0;
        while(true){
            System.out.println("¿Deseas continuar? (1. Si, 2. No): ");
            if(!leer.hasNextInt()){
                System.out.println("Entrada invalida, se esperaba un numero");
                leer.nextLine();
            }
            op1 = leer.nextInt();
            leer.nextLine();
            if(op1 == 1 || op1 == 2) break;
            else System.out.println("Opcion invalida");
        }
        return op1;
    }
    
    public static boolean menuRepetir(int op){
        return op != 2;
    }
}
