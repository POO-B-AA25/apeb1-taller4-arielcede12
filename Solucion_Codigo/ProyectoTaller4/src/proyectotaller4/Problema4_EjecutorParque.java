package proyectotaller4;

import java.util.Scanner;

public class Problema4_EjecutorParque {
    public static JuegosP juego1 = new JuegosP ("Montania Rusa", 10, 125);
    public static JuegosP juego2 = new JuegosP ("Casa del terror", 16, 150);
    public static JuegosP juego3 = new JuegosP ("Barco pirata", 8, 170);
    public static JuegosP juego4 = new JuegosP ("Picina", 5, 110);
    public static Scanner sc = new Scanner(System.in);
    public static void main (String args[] ) {
        
       
        int edades[] = {23, 18, 16, 20, 21, 12, 61, 9, 10};
        int altura [] = {110, 180, 103, 140, 170, 115, 135, 102};
        String personasconAc = "";
        char opcion = 'S';
        int seleccion;
        JuegosP juegoSeleccionado;
        while (opcion == 'S') {
            int edadVis = edades[(int) Math.floor(Math.random() * edades.length)];
            int alturaVis = altura[(int) Math.floor(Math.random() * altura.length)];
            System.out.println("Seleccion el juego que desea ");
            do  {
                System.out.println("[1] Montania Rusa");
                System.out.println("[2] Casa del terror");
                System.out.println("[3] Barco Pirata");
                System.out.println("[4] Tobogan de pelotas");
                seleccion = sc.nextInt();
            }while (seleccion < 1 || seleccion > 4);
           switch (seleccion) {
                case 1:
                    juegoSeleccionado = juego1;
                    break;
                case 2:
                    juegoSeleccionado = juego2;
                    break;
                case 3:
                    juegoSeleccionado = juego3;
                    break;
                case 4:
                    juegoSeleccionado = juego4;
                    break;
                default:
                    System.out.println("Selección no válida.");
                    continue; 
            }
            Visitante visitante = new Visitante (edadVis, alturaVis,juegoSeleccionado );
            if (visitante.Acceso()) {
                personasconAc += visitante.toString() + "\n";
            } 
            System.out.println("Visitante generado: " + visitante);
            System.out.print("¿Desea ingresar otro visitante(S/N)?: ");
            opcion = sc.next().charAt(0);
        }
        
        System.out.println("La cantidad de personas con acceso a los juegos fueron :" + personasconAc);
        
        

    }
    
}
class JuegosP {

    public String nombre;
    public int edadMinima;
    public int alturaMinima;

    public JuegosP() {}

    public JuegosP(String nombre, int edadMinima, int alturaMinima) {

        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.alturaMinima = alturaMinima;
    }


    @Override
    public String toString() {
        return "Juego{" + "nombre=" + nombre + ", edadminima=" + edadMinima + ", alturaminima=" + alturaMinima + '}';
    }
    

}

class Visitante {

    public int edad;
    public int altura;
    public JuegosP juego;
    public boolean acceso;
    

    public Visitante() {}

    public Visitante( int edad, int altura, JuegosP juego) {
        this.edad = edad;
        this.altura = altura;
        this.juego = juego;
                
    }
    
    public boolean Acceso () {
        if (this.edad >= juego.edadMinima && this.altura >= juego.alturaMinima) {
            this.acceso = true;
            return this.acceso;
        } else {
            this.acceso = false;
            return this.acceso;
        }
    }

    @Override
    public String toString() {
        return "Visitante{" + "edad=" + edad + ", altura=" + altura + ", juego=" + juego + ", acceso=" + acceso + '}';
    }
    
    
}