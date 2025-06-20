package org.braulioecheverria.models;

//herencia de clase persona y abstacción, al ser una clase abstracta
public class Profesor extends Persona{
    //Atributos de clase Encapsulamiento
    private String email;
    private String id;
    private String phone;
    
    //constructor vacío
    public Profesor(){}
    
    //constructor lleno (sobrecarga de constructor, polimorfismo)
    public Profesor(String nombres, String apellidos, Integer edad, 
            String email, String id, String phone){
        super(nombres, apellidos, edad);
        if(email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            this.email = email;
        }else{
            this.email = "Email inválido";
        }
        this.id = id;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            this.email = email;
        }else{
            this.email = "Email inválido";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return """
               
               --- PROFESOR ---
               Nombre: """ + getNombres() + " " + getApellidos() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "ID: " + id + "\n" +
                "Email: " + email + "\n" +
                "Telefono: " + phone + "\n";        
    }  
}
