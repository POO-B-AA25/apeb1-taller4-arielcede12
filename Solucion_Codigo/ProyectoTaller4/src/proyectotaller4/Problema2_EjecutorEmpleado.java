package proyectotaller4;

import java.util.ArrayList;
import java.util.Scanner;

public class Problemas2_EjecutorEmpleado {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> aNombres = new ArrayList<>();
    public static ArrayList<Double> aSalario = new ArrayList<>();
    public static ArrayList<Integer> aEdad = new ArrayList<>();
    public static void main(String[] args) {

        String nombres[] = {"Patricio", "Yampatrick", "Lina", "Angelina", "Daniel"};
        String apellidos[] = {"Ramirez", "Garcia", "Robles", "Zambrano", "Cedeno"};
        double salarios[] = {450.5, 785.5, 900, 890.4, 459.5};
        int edades[] = {26, 21, 20, 52, 29, 62, 58, 56, 30, 40, 41, 45, 50};
        String empleadosCambioSalario = "";
        char seleccion = 's';
        double sumasalarios;
        int opcion;

        do {
            System.out.print("Seleccione una opcion : ");
            System.out.println("[1] Agregar un empleado");
            System.out.println("[2] Mostrar información de los empleados");
            System.out.println("[3] Calcular aumento de salario");
            System.out.println("[4] salir ");
            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 4) {
                System.out.println("Opcion incorrecta ");
            }
            switch (opcion) {
                case 1 -> {
                    while (seleccion == 's') {
                        String nombreEm = nombres[(int) Math.floor(Math.random() * nombres.length)] + " " + apellidos[(int) Math.floor(Math.random() * apellidos.length)];
                        double salarioEm = salarios[(int) Math.floor(Math.random() * salarios.length)];
                        int edadEm = edades[(int) Math.floor(Math.random() * edades.length)];
                        aNombres.add(nombreEm);
                        aSalario.add(salarioEm);
                        aEdad.add(edadEm);
                        Empleado empleado = new Empleado(nombreEm, salarioEm, edadEm); 
                        System.out.println("Empleado : " + empleado.mostrarInformacion());
                        System.out.print("Desea agregar otro empleado? (s/n): ");
                        seleccion = sc.next().charAt(0);
                    }
                    seleccion = 's'; 
                }

                case 2 -> {
                    if (aNombres.isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                        System.out.println("Información de los empleados:");
                        for (int i = 0; i < aNombres.size(); i++) {
                            Empleado empleado = new Empleado(aNombres.get(i), aSalario.get(i), aEdad.get(i));
                            System.out.println(empleado.mostrarInformacion());
                        }
                    }
                }
                case 3 -> {
                    if (aSalario.isEmpty()) {
                        System.out.println("No hay empleados ");
                    } else {
                        System.out.println("Aumento ");
                        System.out.print("Ingrese el porcentaje de aumento: ");
                        double porcentajedeAumento = sc.nextDouble();
                        sumasalarios = 0;

                        for (int i = 0; i < aSalario.size(); i++) {
                            sumasalarios += aSalario.get(i);
                        }
                        double promediosalarios = sumasalarios / aSalario.size();
                        empleadosCambioSalario = "";

                        for (int i = 0; i < aSalario.size(); i++) {
                            Empleado empleado = new Empleado(aNombres.get(i), aSalario.get(i), aEdad.get(i));
                            if (empleado.getSalario() < promediosalarios) {
                                empleado.aplicarAumento(porcentajedeAumento);
                                aSalario.set(i, empleado.getSalario());
                                empleadosCambioSalario += empleado.mostrarInformacion() + "\n";
                            }
                        }
                        System.out.println("Empleados Cambio de salario: \n" + empleadosCambioSalario);
                    }
                }
                case 4 ->
                    System.out.println("Gracias por usar nuestro Programa");
                    
            }
        } while (opcion != 4);
    }
}
class Empleado {

    public String nombre;
    private double salario;
    public int edad;
    public double aumento;

    public Empleado() {
    }

    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;

    }

    public double getSalario() {
        return salario;
    }

    public void aplicarAumento(double porcentaje) {
        double aumentoCalculado = salario * (porcentaje / 100);
        salario += aumentoCalculado;
        aumento = aumentoCalculado;
    }

    public String mostrarInformacion() {
        return "Empleado{"
                + "nombre=" + nombre
                + ", salario=" + String.format("%.2f", salario)
                + ", edad=" + edad
                + ", aumento=" + String.format("%.2f", aumento)
                + '}';
    }

}
