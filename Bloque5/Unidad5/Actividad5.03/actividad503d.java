package prog.unidad01.actividad206;

import java.util.Random;
import java.util.Scanner;
import es.iespablopicasso.programacion.bloque02.figuras.Paralelogramo;

public class ParalelogramosApp {

  public static void main(String[] args) {
    // Creamos el scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Imprime la cabecera
    System.out.println("EXAMEN DE tu_nombre_aqui. PROPIEDADES DE LOS PARALELOGRAMOS");
    
    // Solicitamos al usuario la longitud del primer lado
    System.out.print("Introduzca la longitud de los lados horizontales: ");
    double longitudHorizontal = Double.parseDouble(sc.nextLine());

    // Solicitamos al usuario el limite mínimo y máximo del intervalo para generar la longitud del lado vertical
    System.out.print("Introduzca el límite mínimo de los posibles valores de la longitud del lado vertical: ");
    double longitudVerticalMinima = Double.parseDouble(sc.nextLine());
    System.out.print("Introduzca ahora el límite maximo de los posibles valores de la longitud del lado vertical: ");
    double longitudVerticalMaxima = Double.parseDouble(sc.nextLine());
    
    // Creamos un objeto de clase Random para generar el número aleatorio
    Random generadorNumerosAleatorios = new Random();
    // Obtenemos el valor del lado vertical
    double longitudVertical = generadorNumerosAleatorios.nextDouble() * (longitudVerticalMaxima - longitudVerticalMinima) + longitudVerticalMinima;
    // Y lo mostramos
    System.out.println("La longitud del lado vertical obtenida al azar es de: " + longitudVertical);

    // Creamos el objeto 
    Paralelogramo paralelogramo = new Paralelogramo(longitudHorizontal, longitudVertical);
    
    // Obtenemos el área y el perímetro
    String areaPerimetro = paralelogramo.getAreaPerimetro();
    String area = areaPerimetro.substring(0, areaPerimetro.indexOf(";"));
    String perimetro = areaPerimetro.substring(areaPerimetro.indexOf(";") + 1);
    
    // Y los imprimimos
    System.out.println("El área del paralelogramo vale " + area + " y el perimetro vale " + perimetro);

    // Ahora solicitamos al usuario el factor de ampliación / reducción
    System.out.print("Introduzca el factor real positivo por el que quiere ampliar (mayor que 1) o reducir (menor que 1) el paralelogramo: ");
    double factor = Double.parseDouble(sc.nextLine());
    
    // Aplicamos el factor
    paralelogramo.escala(factor);
    
    // Volvemos a obtener e imprimir el área y el perimetro
    areaPerimetro = paralelogramo.getAreaPerimetro();
    area = areaPerimetro.substring(0, areaPerimetro.indexOf(";"));
    perimetro = areaPerimetro.substring(areaPerimetro.indexOf(";") + 1);
    
    // Y los imprimimos
    System.out.println("Depués del escalado, el área del paralelogramo vale ahora " + area + " y el perimetro " + perimetro);
    
    // Convertimos el area y el perimetro a numeros y los sumamos
    double sumaAreaPerimetro = Double.parseDouble(area) + Double.parseDouble(perimetro);
    // La imprimimos
    System.out.println("La suma del área y el perímetro es " + sumaAreaPerimetro);
  }

}
