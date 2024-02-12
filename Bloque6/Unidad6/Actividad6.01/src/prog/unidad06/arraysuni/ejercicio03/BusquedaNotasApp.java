package prog.unidad06.arraysuni.ejercicio03;

import java.util.Scanner;
import prog.unidad06.arraysuni.ejercicio02.*;

public class BusquedaNotasApp {

  // Constantes
  private static final int NUMERO_ALUMNOS = 30;
  private static final int NOTA_MINIMA = 0;
  private static final int NOTA_MAXIMA = 10;
  
  public static void main(String[] args) {

    // Scanner para solicitar los datos por teclado
    Scanner sc = new Scanner(System.in);
    
    // Array de notas 
    int[] notas  = UtilidadesArrays2.generaArrayEnteroAleatorio(NUMERO_ALUMNOS, NOTA_MINIMA, NOTA_MAXIMA);
   
    
    // Solicitamos una calificación por pantalla hasta introducir una nota negativa
    int calificacionIntroducida = 0;
    
    do {
      
      try {
        System.out.print("Introduzca la calificación a buscar (0 a 10, negativa para terminar): ");
        calificacionIntroducida = Integer.parseInt(sc.nextLine());
        
        // Comprobamos que es un valor comprendido en el intervalo aceptable
        if (calificacionIntroducida >= NOTA_MINIMA && calificacionIntroducida <= NOTA_MAXIMA) {
          
          // Iniciamos un contador y lo devolvemos por pantalla al usuario recorriendo el array
          int coincidencias = 0;
          for (int calificacion : notas) {
            coincidencias += (calificacion == calificacionIntroducida) ? 1 : 0;
          }
          
          System.out.println("Con la calificación " + calificacionIntroducida + " se han encontrado " 
              + coincidencias + " alumnos.");
          
        // Si la calificación es mayor al máximo, avisamos de entrada incorrecta  
        } else if (calificacionIntroducida > NOTA_MAXIMA) {
          System.out.println("Entrada incorrecta. Debe introducir un número entero entre 0 y 10,"
              + " ambos incluidos");
        }
        // Si la calificación es menor al dato mínimo, simplemente salimos del programa
        
      // En caso de que lo introducido no sea un número correcto, atrapamos el error y avisamos al usuario
      } catch (NumberFormatException e) {
        System.out.println("Entrada incorrecta. Debe introducir un número entero entre 0 y 10,"
            + " ambos incluidos");
      }
      
    } while (calificacionIntroducida >= 0);
    
    // Avisamos del fin del programa y cerramos el Scanner
    System.out.println("FIN DEL PROGRAMA");
    sc.close();
    
  }

}
