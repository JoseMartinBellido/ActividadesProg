package prog.unidad01.actividad206;

import java.util.Random;
import java.util.Scanner;
import es.iespablopicasso.programacion.bloque02.figuras.Paralelogramo;

public class ParalelogramosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("EXAMEN DE tu_nombre_aqui. PROPIEDADES DE LOS PARALELOGRAMOS");
    
    System.out.print("Introduzca la longitud de los lados horizontales: ");
    double longitudHorizontal = Double.parseDouble(sc.nextLine());

    System.out.print("Introduzca el límite mínimo de los posibles valores de la longitud del lado vertical: ");
    double longitudVerticalMinima = Double.parseDouble(sc.nextLine());
    System.out.print("Introduzca ahora el límite maximo de los posibles valores de la longitud del lado vertical: ");
    double longitudVerticalMaxima = Double.parseDouble(sc.nextLine());
    
    Random generadorNumerosAleatorios = new Random();
    double longitudVertical = generadorNumerosAleatorios.nextDouble() * (longitudVerticalMaxima - longitudVerticalMinima) + longitudVerticalMinima;
    System.out.println("La longitud del lado vertical obtenida al azar es de: " + longitudVertical);

    Paralelogramo paralelogramo = new Paralelogramo(longitudHorizontal, longitudVertical);
    
    String areaPerimetro = paralelogramo.getAreaPerimetro();
    String area = areaPerimetro.substring(0, areaPerimetro.indexOf(";"));
    String perimetro = areaPerimetro.substring(areaPerimetro.indexOf(";") + 1);
    
    System.out.println("El área del paralelogramo vale " + area + " y el perimetro vale " + perimetro);

    System.out.print("Introduzca el factor real positivo por el que quiere ampliar (mayor que 1) o reducir (menor que 1) el paralelogramo: ");
    double factor = Double.parseDouble(sc.nextLine());
    
    paralelogramo.escala(factor);
    
    areaPerimetro = paralelogramo.getAreaPerimetro();
    area = areaPerimetro.substring(0, areaPerimetro.indexOf(";"));
    perimetro = areaPerimetro.substring(areaPerimetro.indexOf(";") + 1);
    
    System.out.println("Depués del escalado, el área del paralelogramo vale ahora " + area + " y el perimetro " + perimetro);
    
    double sumaAreaPerimetro = Double.parseDouble(area) + Double.parseDouble(perimetro);
    System.out.println("La suma del área y el perímetro es " + sumaAreaPerimetro);
  }

}
