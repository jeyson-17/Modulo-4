package com.mycompany.sistemagestionempleados;

import java.util.ArrayList;
import java.util.Scanner;

class Empleado {
    private String nombre;
    private int edad;
    private double salario;

  
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

   
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salario: " + salario);
    }
}

class GestorEmpleados {
    private final ArrayList<Empleado> empleados;
    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

   
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    
    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado empleado : empleados) {
            empleado.imprimirInformacion();
            System.out.println(); 
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        try (Scanner scanner = new Scanner(System.in)) {
            String continuar;

            do {
                System.out.println("Agregar empleado:");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Edad: ");
                int edad = Integer.parseInt(scanner.nextLine());
                System.out.print("Salario: ");
                double salario = Double.parseDouble(scanner.nextLine());

                Empleado nuevoEmpleado = new Empleado(nombre, edad, salario);
                gestor.agregarEmpleado(nuevoEmpleado);

              
                System.out.print("Vas a agregar otro empleado? (si/no): ");
                continuar = scanner.nextLine();
                
            } while (continuar.equalsIgnoreCase("si"));

            
            System.out.println("\nDetalles de los empleados registrados:");
            gestor.mostrarEmpleados();
        }
    }
}
