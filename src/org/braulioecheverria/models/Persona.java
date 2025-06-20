package org.braulioecheverria.models;

public abstract class Persona {
    private String nombres; // es accesible desde cualquier parte del programa
    private String apellidos; // es accesible solamente dentro de la misma clase
    private Integer edad; // es accesible desde subclases y dentro del mismo package
    
    //constructores
    public Persona(){}
      
    public Persona(String nombres, String apellidos, Integer edad){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }
            
    //getters y setters
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    
    public String getNombres(){
        return nombres;
    }
    
    public void setEdad(Integer edad){
        if(edad >= 0){
            this.edad =  edad;
        }
    }
    
    public Integer getEdad(){
        return edad;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombres + " " + apellidos + "\n" +
                "Edad: " + edad + "\n";
    }
}
