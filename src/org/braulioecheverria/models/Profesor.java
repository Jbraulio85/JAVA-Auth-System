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
        this.email = email;
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
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Profesor{" + "email=" + email + ", id=" + id + ", phone=" + phone + '}';
    }
     
    
}
