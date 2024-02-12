package prog.unidad06.genericos.ejercicio03;

/**
 * Clase de utilidades para arrays de tipo genérico
 * @author Jose
 */
public class ArrayUtils {

  /**
   * Método estático que, dado un array y dos índices, intercambia los elementos de las posiciones indice1 e indice2
   * @param <T> Tipo de los objetos
   * @param array Array sobre el que se opera
   * @param indice1 Posición del array en el que se inserta el elemento de indice2
   * @param indice2 Posición del array en el que se inserta el elemento de indice1
   * @throws ArrayIndexOutOfBoundsException Si indice1 o indice2 indican una posición del array que no existe
   * @throws NullPointerException si el array es null
   */
  public static <T> void intercambiarElementos(T[] array, int indice1, int indice2) {
    // Por defecto, los throws se realizan automáticamente al tratarse de errores definidos para arrays y objetos
    // Variable auxiliar para el intercambio
    T auxiliar = array[indice2];
    
    // Realizamos el intercambio
    array[indice2] = array[indice1];
    array[indice1] = auxiliar;
  }
  
  /**
   * Método estático que invierte un array dado, colocando en la primera posición el objeto que ocupaba la última,
   * en la segunda el de la penúltima, etc.
   * @param <T> Tipo de los objetos
   * @param array Array que se va a invertir
   * @throws NullPointerException En caso de que el array sea null
   */
  public static <T> void invertirArray(T[] array) {
    // Intercambiaremos los elementos de 2 en 2 por extremos
    for (int i = 0; i < array.length / 2; i++) {
      intercambiarElementos(array, i, array.length - 1 - i);
    }

  }
  
}
