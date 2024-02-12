package unidad06.arraysuni.ejercicio02;

import java.util.Random;

/**
 * Clase con utilidades para arrays
 */
public class UtilidadesArrays {

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
}
