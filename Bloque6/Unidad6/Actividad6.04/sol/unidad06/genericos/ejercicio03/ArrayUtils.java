package unidad06.genericos.ejercicio03;

/**
 * Clase con utilidades genéricas para arrays
 */
public class ArrayUtils {
  
  /**
   * Intercambia dos elementos de un array, dando las posiciones de los elementos a intercambiar
   * @param <T> Tipo de los elementos del array
   * @param array Array
   * @param indiceDesde Indice del primer elemento a intercambiar
   * @param indiceHasta Indice del segundo elemento a intercambiar
   * @throws ArrayIndexOutOfBoundsException Si indiceDesde o indiceHasta
   *   no son indices válidos del array
   * @throws NullPointerException Si el array es null
   */
  public static <T> void intercambiarElementos(T[] array, int indiceDesde, int indiceHasta) {
    // Almacena el valor contenido en el primer elemento
    T valor = array[indiceDesde];
    // Copia el segundo elemento en el primero
    array[indiceDesde] = array[indiceHasta];
    // Y el valor guardado en el segundo
    array[indiceHasta]= valor;
  }
  
  /**
   * Invierte el array colocando en la primera posición el elemento que inicialmente
   *   ocupaba la última, el segundo el que ocupaba la penúltima y asi sucesivamente
   * @param <T> Tipo del array
   * @param array Array a invertir
   * @throws NullPointerException Si el array es null
   */
  public static <T> void invertirArray(T[] array) {
    // Indices de inicio y fin
    int inicio = 0;
    int fin = array.length - 1;
    
    // Mientras no se haya intercambiado la mitad de los elementos
    while (inicio < fin) {
      // Intercambia los elementos
      intercambiarElementos(array, inicio, fin);
      // Pasa a los siguientes
      inicio++;
      fin--;
    }
  }

}
