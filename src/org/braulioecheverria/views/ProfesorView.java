package org.braulioecheverria.views;
import java.util.Scanner;
import org.braulioecheverria.controllers.ProfesorController;
import org.braulioecheverria.models.Profesor;

public class ProfesorView {
    Integer op1, op2;
    boolean flag = true;
    Scanner leer = new Scanner(System.in);
    ProfesorController pc = new ProfesorController();
    Profesor pf;
    
    public ProfesorView(){}
    
    public void menuProfesor(){
        while(flag == true){
            System.out.println("Qué deseas realizar?");
            System.out.println("1. Agregar profesor");
            System.out.println("2. Listar profesores");
            System.out.println("3. Buscar profesor");
            System.out.println("4. Actualizar profesor");
            System.out.println("5. Eliminar profesor");
            op1 = leer.nextInt();
            leer.nextLine();
            switch(op1){
                case 1 -> {
                    pc.agregarProfesor();
                    System.out.println("Deseas continuar");
                    System.out.println("1. Para si, 2. Para no");
                    op2 = leer.nextInt();
                    flag = menuRepetir(op2);
                }
                case 2 -> {
                    pc.listarProfesores();
                    System.out.println("Deseas continuar?");
                    System.out.println("1. Para si, 2. Para no");
                    op2 = leer.nextInt();
                    flag = menuRepetir(op2);
                }
                case 3 -> {
                    System.out.println("Ingresa el ID del profesor a buscar");
                    String id = leer.nextLine();
                    pf = pc.buscarProfesor(id);
                    System.out.println(pf);
                    System.out.println("Deseas continuar?");
                    System.out.println("1. Para si, 2. Para no");
                    op2 = leer.nextInt();
                    flag = menuRepetir(op2);
                }
                case 4 -> {
                    System.out.println("Ingresa el ID del profesor a actualizar");
                    String id = leer.nextLine();
                    pf = pc.actualizarProfesor(id);
                    System.out.println(pf);
                    System.out.println("Deseas continuar?");
                    System.out.println("1. Para si, 2. Para no");
                    op2 = leer.nextInt();
                    flag = menuRepetir(op2);
                }
                case 5 -> {
                    System.out.println("Ingresa el ID del profesor a eliminar");
                    String id = leer.nextLine();
                    System.out.println(pc.eliminarProfesor(id));
                    System.out.println("Deseas continuar?");
                    System.out.println("1. Para si, 2. Para no");
                    op2 = leer.nextInt();
                    flag = menuRepetir(op2);
                }
                default -> {
                    System.out.println("Opción no válida");
                    System.out.println("Deseas continuar?");
                    System.out.println("1. Para si, 2. Para no");
                    op2 = leer.nextInt();
                    flag = menuRepetir(op2);
                }
            }
        }
    }
    
    public static boolean menuRepetir(int op){
        return op != 2;
    }
}
