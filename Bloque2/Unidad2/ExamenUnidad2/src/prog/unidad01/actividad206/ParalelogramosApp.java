package prog.unidad01.actividad206;

import java.util.Random;
import java.util.Scanner;

import es.iespablopicasso.programacion.bloque02.figuras.Paralelogramo;

public class ParalelogramosApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("EXÁMEN DE JOSÉ MARTÍN BELLIDO. PROPIEDADES DE LOS PARALELOGRAMOS.");

    // Pedimos la longitud de los lados horizontales del paralelogramo
    System.out.print("Introduzca la longitud de los lados horizontales: ");
    double ladoHorizontal = Double.parseDouble(sc.nextLine());
    
    // Solicitamos por teclado un rango para generar el número aleatorio de los lados verticales (límites inferior y superior)
    System.out.print("Introduzca el límite mínimo de los posibles valores de la longitud del lado vertical:");
    double rangoMinimo = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduzca el límite máximo de los posibles valores de la longitud del lado vertical:");
    double rangoMaximo = Double.parseDouble(sc.nextLine());
    
    // Generamos el número aleatorio estableciendo el número mínimo y el máximo.
    // Para ello creamos un generador de la clase Random y pedimos un número aleatorio con el método nextDouble(númeroMínimo, numeroMáximo).
    Random generador = new Random();
    
    double ladoVertical = generador.nextDouble(rangoMinimo, rangoMaximo);
    
    // Imprimimos por pantalla el resultado del lado vertical
    System.out.println("La longitud del lado vertical obtenida al azar es de: " + ladoVertical);
    
    // Creamos el paralelogramo con el constructor de la API facilitada y obtenemos la cadena con su área y perímetro juntos
    
    Paralelogramo paralelogramo = new Paralelogramo(ladoHorizontal, ladoVertical);
    
    String areaPerimetro = paralelogramo.getAreaPerimetro();
    
    // Para separar el área del perímetro, buscamos el índice del carácter ';' y hacemos un substring anterior y otro posterior al mismo
    // Los rangos van de 0 al índice anterior al ';' (para no incluirlo) 
    // y del posterior al ';' hasta la longitud del String - 1 , respectivamente
    // Con estos substring simplemente los pasamos a double para obtener sus valores
    int indicePuntoYComa = areaPerimetro.indexOf(';');
    
    double area = Double.parseDouble(areaPerimetro.substring(0, indicePuntoYComa));
    double perimetro = Double.parseDouble(areaPerimetro.substring(indicePuntoYComa + 1));
    
    System.out.println("El área del paralelogramo vale " + area + " y el perimetro vale " + perimetro);
    
    // Comenzamos con el apartado del escalado. Pedimos el valor por teclado
    System.out.print("Introduzca el factor real positivo por el que quiere ampliar (mayor que 1) "
        + "o reducir (menor que 1) el paralelogramo: ");
    
    double factorEscalado = Double.parseDouble(sc.nextLine());
    
    // Escalamos el paralelogramo con el método de la API. Como el método es void, no da resultado y no hay que almacenar variable alguna
    paralelogramo.escala(factorEscalado);
    
    // Para calcular el área y el perímetro, simplemente usamos el mismo código anterior. Reutilizamos las variables anteriores
    areaPerimetro = paralelogramo.getAreaPerimetro();
    
    indicePuntoYComa = areaPerimetro.indexOf(';');
    
    area = Double.parseDouble(areaPerimetro.substring(0, indicePuntoYComa));
    perimetro = Double.parseDouble(areaPerimetro.substring(indicePuntoYComa + 1));
    
    System.out.println("Depués del escalado, el área del paralelogramo vale ahora " + area + " y el perimetro " 
        + perimetro);
    
    // Imprimimos la suma del área y el perímetro por pantalla. Como ya se han convertido antes a double, no es necesaria la conversión de nuevo.
    
    double sumaAreaPerimetro = area + perimetro;
    
    System.out.println("La suma del área y el perímetro es " + sumaAreaPerimetro);
    
    sc.close();
  }

}
