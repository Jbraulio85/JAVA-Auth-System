package org.braulioecheverria.system;
import org.braulioecheverria.models.Profesor;

public class Main {

    public static void main(String[] args) {
        //Crear un objeto haciendo uso del const. vacío
        Profesor profesor = new Profesor();
        
        //crear un objeto haciendo uso del const. lleno
        Profesor profesor2 = new Profesor("Jose","Montufar",40,
        "braulioecheverria@kinal.edu.gt","2025002","2160099");

        profesor.setNombres("Braulio");
        profesor.setApellidos("Echeverria");
        profesor.setEdad(40);
        profesor.setEmail("braulioecheverria@kinal.org.gt");
        profesor.setId("2025001");
        profesor.setPhone("22160000");

        
        System.out.println(profesor);
        System.out.println(profesor2);
    }
    
}
