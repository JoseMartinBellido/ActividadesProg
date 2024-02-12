package prog.unidad06.arraysuni.ejercicio08;

/** 
 * Crea y muestra por pantalla un array con los 20 primeros números pares
 */
public class ArrayPares2 {

  // Cantidad de pares a generar
  private static final int CANTIDAD_PARES = 20;

  public static void main(String[] args) {
    // Creamos el array
    int[] array = new int[CANTIDAD_PARES];
    
    // Para cada elemento
    for (int i = 0; i < CANTIDAD_PARES; i++) {
      // Calculamos el par correspondiente y lo almacenamos
      // A cada elemento le corresponde 2 por la posición.
      // Como la posición comienza por cero, sumamos 1 para que las posiciones sean 1, 2, etc.
      array[i] = (i + 1 ) * 2;
    }
    
    // Mostramos la cabcera y el array
    System.out.println("NÚMEROS PARES");
    System.out.print("Los primeros números pares son: ");
    for (int i = 0; i < CANTIDAD_PARES; i++) {
      // Imprime el elemento que corresponde
      System.out.print(array[i]);
      // Si no es el último
      if (i < (CANTIDAD_PARES - 1)) {
        // Imprime una coma para separarlo del siguiente
        System.out.print(", ");
      }
    }
  }

}
