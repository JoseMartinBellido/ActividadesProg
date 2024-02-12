package prog.unidad04.atributos.ejercicio05;

import java.util.Scanner;

public class PruebaIntervaloTiempo {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("PROGRAMA DE MANEJO DE INTERVALOS DE TIEMPO");
    
    int numeroDeIntervalos;
    
    try {
      // Pedimos la cantidad de intervalos a introducir
      System.out.print("Introduzca la cantidad de intervalos a crear (1 o mas): ");
      numeroDeIntervalos = Integer.parseInt(sc.nextLine());
      
      // Realizamos un bucle for
      for (int i = 1; i <= numeroDeIntervalos; i++) {
        
        IntervaloTiempo intervaloTiempo = new IntervaloTiempo();
        
        // Pedimos el número de horas
        System.out.print("Introduce la cantidad de horas del intervalo " + i + " (Mayor o igual a cero): ");
        intervaloTiempo.horas = Integer.parseInt(sc.nextLine());
        
        // Si tenemos un número de horas negativo, cerramos el programa con el subsiguiente error.
        if (intervaloTiempo.horas < IntervaloTiempo.MINIMO) {
          
          System.out.println("Error. El número de horas debe ser mayor o igual a cero.");
          break;
        }
          
        // Pedimos el número de minutos
        System.out.print("Introduce la cantidad de minutos del intervalo " + i 
            + " (" + IntervaloTiempo.MINIMO + "-" + IntervaloTiempo.MAXIMO_SEGUNDOS_Y_MINUTOS + "): ");
        intervaloTiempo.minutos = Integer.parseInt(sc.nextLine());
        
        // Si estamos fuera del intervalo, damos un error y cerramos el programa.
        if (intervaloTiempo.minutos < IntervaloTiempo.MINIMO || intervaloTiempo.minutos > IntervaloTiempo.MAXIMO_SEGUNDOS_Y_MINUTOS) {
          
          System.out.println("Error. El número de minutos no está en el intervalo 0-59.");
          break;
        }
        
        // Pedimos el número de segundos
        System.out.print("Introduce la cantidad de segundos del intervalo " + i 
            + " (" + IntervaloTiempo.MINIMO + "-" + IntervaloTiempo.MAXIMO_SEGUNDOS_Y_MINUTOS + "): ");
        intervaloTiempo.segundos = Integer.parseInt(sc.nextLine());
        
        // Si estamos fuera del intervalo, damos un error y cerramos el programa.
        if (intervaloTiempo.segundos < IntervaloTiempo.MINIMO || intervaloTiempo.segundos > IntervaloTiempo.MAXIMO_SEGUNDOS_Y_MINUTOS) {
          
          System.out.println("Error. El número de segundos no está en el intervalo " 
          + IntervaloTiempo.MINIMO + "-" + IntervaloTiempo.MAXIMO_SEGUNDOS_Y_MINUTOS + ".");
          break;
        }
        
      }
      
      
    } catch (NumberFormatException e) {
      System.out.println("Uno de los datos no es en el formato correcto. Inténtelo de nuevo.");
    }
    
    sc.close();

  }

}
