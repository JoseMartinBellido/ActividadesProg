package prog.unidad06.arraysuni.ejercicio04;

import java.util.Random;

/**
 * Clase con utilidades para arrays
 */
public class UtilidadesArrays2 {

  /**
   * Genera un array de números enteros aleatorios a elegir de un intervalo dado
   * @param longitud Longitud del array a devolver. Debe ser mayor que cero
   * @param valorMinimo Valor mínimo del intervalo desde el que se va a elegir los números aleatorios
   * @param valorMaximo Valor máximo del intervalo. Debe ser mayor o igual que el valor minimo
   * @return Nuevo array de la longitud dada con números tomados del intervalo especificado
   * @throws IllegalArgumentException Si la longitud es menor que 1 ó el intervalo no está
   *   correctamente especificado
   */
  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {
    // Comprobamos que los parámetros son correctos
    if (longitud > 0 && valorMinimo <= valorMaximo) {
      // Creamos un objeto Random para obtener los números aleatorios
      Random generador = new Random();
      // Creamos el array con la longitud dada
      int[] resultado = new int[longitud];
      // Para cada elemento del array
      for (int i = 0; i < resultado.length; i++) {
        // Generamos el número y lo almacenamos
        // Hay que sumar 1 a valor maximo porque si no no lo incluye
        resultado[i] = generador.nextInt(valorMinimo, valorMaximo + 1);
      }
      // Devolvemos el resultado
      return resultado;
    } else {
      // Error en los parámetros
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Obtiene el valor mínimo de entre los contenidos en el array
   * @param array Array con los valores enteror. No puede ser
   *   null y su longitud debe ser 1 ó superior
   * @return El valor mínimo contenido en el array
   * @throws IllegalArgumentException Si el array es null o su longitud es menor a 1
   */
  public static int getMinimoArrayEntero(int[] array) {
    // Si el array es null o su longitud es menor a 1
    if (array == null || array.length < 1) {
      // Argumento inválido
      throw new IllegalArgumentException();
    } else {
      // El array es correcto
      // Tomamos inicialmente el menor como el primero del array
      int menor = array[0];
      // Para cada elemento del array
      for (int elemento: array) {
        // Si es menor que el menor que llevamos hasta el momento
        if (elemento < menor) {
          // Lo hacemos el nuevo menor
          menor = elemento;
        }
      }
      // Devolvemos el menor
      return menor;
    }
  }
  
  /**
   * Obtiene el valor maximo de entre los contenidos en el array
   * @param array Array con los valores enteros. No puede ser
   *   null y su longitud debe ser 1 ó superior
   * @return El valor máximo contenido en el array
   * @throws IllegalArgumentException Si el array es null o su longitud es menor a 1
   */
  public static int getMaximoArrayEntero(int[] array) {
    // Si el array es null o su longitud es menor a 1
    if (array == null || array.length < 1) {
      // Argumento inválido
      throw new IllegalArgumentException();
    } else {
      // El array es correcto
      // Tomamos inicialmente el mayor como el primero del array
      int mayor = array[0];
      // Para cada elemento del array
      for (int elemento: array) {
        // Si es mayor que el mayor que llevamos hasta el momento
        if (elemento > mayor) {
          // Lo hacemos el nuevo mayor
          mayor = elemento;
        }
      }
      // Devolvemos el mayor
      return mayor;
    }
  }
  
  /**
   * Obtiene el número de veces que aparece un valor determinado en un
   *   array de enteros
   * @param array Array donde se quiere localizar el valor. Si es null o
   *   tiene cero elementos se devolverá cero
   * @param valor Valor a localizar
   * @return Número de veces que aparece el valor en el array
   */
  public static int enteroApareceEnArrayEntero(int[] array, int valor) {
    // Si el array es nulo o está vacío
    if (array == null || array.length < 1) {
      // Devuelve 0
      return 0;
    } else {
      // Iniciamos el contador a cero
      int contador = 0;
      // Para cada elemento del array
      for (int elemento: array) {
        // Si es el buscado
        if (elemento == valor) {
          // Añadimos uno al contador
          contador++;
        }
      }
      // Devolvemos el resultado
      return contador;
    }
  }
}
