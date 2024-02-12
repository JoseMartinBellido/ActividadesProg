package prog.unidad06.arraysuni.ejercicio07;
import java.util.Scanner;

public class SuperArray {

  // Constantes
  private static final int CANTIDAD_ELEMENTOS = 30;
  
  public static void main(String[] args) {

    // Scanner para solicitar datos por teclado
    Scanner sc = new Scanner(System.in);
    
    // Creamos el array vacío
    long[] array = new long[CANTIDAD_ELEMENTOS];
    
    // Solicitamos el dato hasta tener un número entero válido
    boolean valido = false;
    
    do {
      try {
        // Solicitamos el primer número y lo introducimos en el array
        System.out.print("Introduzca un número entero para realizar el cálculo: ");
        long numeroIntroducido = Long.parseLong(sc.nextLine());
        
        // Llegados aquí, el número será correcto
        valido = true;
        array[0] = numeroIntroducido;
        
        // A partir de ahí, generamos los siguientes
        for (int i = 1; i < array.length; i++) {
          array[i] = (array[i - 1] + 1) * 2;
        }
        
      } catch (NumberFormatException e) {
        System.out.println("El dato introducido no es válido. Inténtelo de nuevo.");
      }
    } while (!valido);
    
    // En este punto, el array está completo. Imprimimos resultado
    for (int i = array.length - 1; i >= 0; i--) {
      System.out.println("El elemento " + (i + 1) + " es: " + array[i]);
    }
    // Cerramos Scanner
    sc.close();
  }

}
