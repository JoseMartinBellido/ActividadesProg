package prog.unidad06.arraysuni.ejercicio03;

import java.util.Scanner;
import prog.unidad06.arraysuni.ejercicio02.UtilidadesArrays;

/**
 * Aplicación que busca notas de alumnos
 */
public class BusquedaNotasApp2 {

  // Cantidad de calificaciones
  private static final int CALIFICACIONES = 30;
  // Calificacion minima
  private static final int CALIFICACION_MINIMA = 0;
  // Calificacion maxima
  private static final int CALIFICACION_MAXIMA = 10;
  
  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("BÚSQUEDA DE CALIFICACIONES");
    
    // Creamos el array con las 30 notas. Para ello empleamos la clase
    // UtilidadesArrays creada en el ejercicio anterior
    int[] calificaciones = UtilidadesArrays.generaArrayEnteroAleatorio(CALIFICACIONES, CALIFICACION_MINIMA, CALIFICACION_MAXIMA);
    
    int calificacionABuscar = 0;
    // Mientras no se introduzca un número negativo
    do {
      // Capturamos excepción por si se introduce algo que no es un número entero
      try {
        // Solicita un numero
        System.out.print("Introduzca la calificación a buscar (0 a 10, negativa para terminar): ");
        calificacionABuscar = Integer.parseInt(sc.nextLine());
        // Si está en el rango 
        if (calificacionABuscar >= CALIFICACION_MINIMA && calificacionABuscar <= CALIFICACION_MAXIMA) {
          // Iniciamos la cuenta a cero
          int encontrados = 0;
          // Para cada calificacion
          for (int calificacion: calificaciones) {
            // Si la calificacion es la buscada
            if (calificacion == calificacionABuscar) {
              // Contamos uno más encontrado
              encontrados++;
            }
          }
          // Mostramos el resultado
          System.out.println("Con la calificacion " + calificacionABuscar
            + " se han encontrado " + encontrados + " alumnos");
        } else {
          // Si la calificación es positiva
          if (calificacionABuscar >= 0) {
            // La calificacion a buscar no es correcta. Mostramos mensaje y no hacemos mas
            System.out.println("La calificación introducida no es correcta. Debe ser un número entero entre 0 y 10, ambos incluidos");
          }
        }
      } catch (NumberFormatException e) {
        // Lo que se ha introducido no es un número entero. Mostramos un mensaje y continuamos con el siguiente
        System.out.println("Entrada incorrecta. Debe introducir un número entero entre 0 y 10, ambos incluidos");
      }
    } while (calificacionABuscar >= 0);
    System.out.println("FIN DEL PROGRAMA");
  }

}
