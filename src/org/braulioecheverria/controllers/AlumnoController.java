package org.braulioecheverria.controllers;

import java.util.ArrayList;
import org.braulioecheverria.models.Alumno;
import org.braulioecheverria.utils.InputException;
import org.braulioecheverria.utils.SingletonScanner;

public class AlumnoController {
    final java.util.Scanner leer = SingletonScanner.getInstance().getScanner();
    ArrayList<Alumno> alumnos = new ArrayList<>();

    public void agregarAlumno() {
        Alumno alumno = new Alumno();
        System.out.print("Ingresa nombres: ");
        alumno.setNombres(leer.nextLine());
        System.out.print("Ingresa apellidos: ");
        alumno.setApellidos(leer.nextLine());
        while (true) {
            try {
                System.out.print("Ingresa la edad: ");
                if (!leer.hasNextInt()) throw new InputException("Edad inválida, se esperaba un número.");
                alumno.setEdad(leer.nextInt());
                leer.nextLine();
                break;
            } catch (InputException e) {
                System.out.println(e.getMessage());
                leer.nextLine();
            }
        }
        System.out.print("Ingresa el carnet: ");
        alumno.setCarnet(leer.nextLine());
        System.out.print("Ingresa el grado: ");
        alumno.setGrado(leer.nextLine());
        System.out.print("Ingresa la sección: ");
        alumno.setSeccion(leer.nextLine());
        alumnos.add(alumno);
        System.out.println("Alumno agregado exitosamente.");
    }

    public void listarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
            }
        }
    }

    public Alumno buscarAlumno(String carnet) {
        for (Alumno alumno : alumnos) {
            if (alumno.getCarnet().equalsIgnoreCase(carnet)) return alumno;
        }
        System.out.println("Alumno no encontrado.");
        return null;
    }

    public Alumno actualizarAlumno(String carnet) {
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = alumnos.get(i);
            if (alumno.getCarnet().equalsIgnoreCase(carnet)) {
                System.out.println("Datos actuales:");
                System.out.println(alumno);
                System.out.println("--- INGRESA LOS NUEVOS DATOS ---");
                System.out.print("Nombres: ");
                alumno.setNombres(leer.nextLine());
                System.out.print("Apellidos: ");
                alumno.setApellidos(leer.nextLine());
                while (true) {
                    try {
                        System.out.print("Edad: ");
                        if (!leer.hasNextInt()) throw new InputException("Edad inválida, se esperaba un número.");
                        alumno.setEdad(leer.nextInt());
                        leer.nextLine();
                        break;
                    } catch (InputException e) {
                        System.out.println(e.getMessage());
                        leer.nextLine();
                    }
                }
                System.out.print("Grado: ");
                alumno.setGrado(leer.nextLine());
                System.out.print("Sección: ");
                alumno.setSeccion(leer.nextLine());
                int eleccion = 0;
                while (true) {
                    try {
                        System.out.print("¿Deseas guardar los cambios? (1. Sí, 2. No): ");
                        if (!leer.hasNextInt()) throw new InputException("Entrada inválida, se esperaba un número.");
                        eleccion = leer.nextInt();
                        leer.nextLine();
                        if (eleccion == 1 || eleccion == 2) break;
                        else System.out.println("Opción no válida.");
                    } catch (InputException e) {
                        System.out.println(e.getMessage());
                        leer.nextLine();
                    }
                }
                if (eleccion == 1) {
                    alumnos.set(i, alumno);
                    System.out.println("Alumno actualizado exitosamente.");
                } else {
                    System.out.println("No se realizaron cambios.");
                }
                return alumno;
            }
        }
        System.out.println("Alumno no encontrado.");
        return null;
    }

    public String eliminarAlumno(String carnet) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getCarnet().equalsIgnoreCase(carnet)) {
                alumnos.remove(i);
                return "Alumno eliminado exitosamente.";
            }
        }
        return "Alumno no encontrado.";
    }
}
