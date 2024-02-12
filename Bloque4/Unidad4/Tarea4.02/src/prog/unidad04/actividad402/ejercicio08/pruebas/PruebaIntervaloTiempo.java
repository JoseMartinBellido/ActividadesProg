package prog.unidad04.actividad402.ejercicio08.pruebas;

import java.util.Scanner;
import prog.unidad04.actividad402.ejercicio08.IntervaloTiempo;

/**
 * Prueba IntervaloTiempo
 */
public class PruebaIntervaloTiempo {
  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("PROGRAMA DE PRUEBA DE INTERVALOS DE TIEMPO");

    // Solicitamos al usuario los datos de dos intervalos y los creamos
    System.out.print("Introduzca el número de horas del primer intervalo (positivo): ");
    int horas = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el número de minutos del primer intervalo (positivo): ");
    int minutos = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el número de segundos del primer intervalo (positivo): ");
    int segundos = Integer.parseInt(sc.nextLine());
    IntervaloTiempo intervalo1 = new IntervaloTiempo(horas, minutos, segundos);

    System.out.print("Introduzca el número de horas del segundo intervalo (positivo): ");
    horas = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el número de minutos del segundo intervalo (positivo): ");
    minutos = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el número de segundos del segundo intervalo (positivo): ");
    segundos = Integer.parseInt(sc.nextLine());
    IntervaloTiempo intervalo2 = new IntervaloTiempo(horas, minutos, segundos);

    // Calculamos la suma y la resta
    IntervaloTiempo suma = intervalo1.suma(intervalo2);
    IntervaloTiempo resta = intervalo1.resta(intervalo2);

    // Muestra los intervalos
    System.out.println("Los resultados de las operaciones son");
    System.out.println("Suma: " + suma.obtenerCadena());
    // Si la resta se pudo hacer
    if (resta != null) {
      // Se imprime
      System.out.println("Resta: " + resta.obtenerCadena());
    } else {
      // Se imprime un mensaje
      System.out.println("La resta no se pudo realizar porque el segundo intervalo es mayor que el primero");
    }
  }

}
