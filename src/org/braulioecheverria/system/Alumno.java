package org.braulioecheverria.system;
import org.braulioecheverria.models.Persona;

public class Alumno extends Persona{
    private String carnet;
    private String grado;
    private String seccion;

    public Alumno() {
    }

    public Alumno(String carnet, String grado, String seccion, String nombres,
            String apellidos, Integer edad) {
        super(nombres, apellidos, edad);
        this.carnet = carnet;
        this.grado = grado;
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno{" + "carnet=" + carnet + ", grado=" + grado +
                ", seccion=" + seccion + '}';
    }
}
