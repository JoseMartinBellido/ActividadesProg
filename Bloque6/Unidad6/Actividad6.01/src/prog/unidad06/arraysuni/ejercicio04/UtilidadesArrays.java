package prog.unidad06.arraysuni.ejercicio04;

import java.util.Random;

public class UtilidadesArrays {

  /**
   * Método para generar un array de números aleatorios enteros
   * @param longitud Longitud del array. Debe ser mayor a 0
   * @param valorMinimo Valor mínimo del array
   * @param valorMaximo Valor máximo del array. Debe ser mayor que valorMinimo
   * @return Un array con un número "longitud" de valores entre valorMinimo y valorMaximo
   */
  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {
    
    if (valorMaximo < valorMinimo || longitud <= 0) {
      throw new IllegalArgumentException();
    }
    
    // Creamos el array de la longitud determinada
    int[] numerosEnteros = new int[longitud];
    
    // Generador de números aleatorios
    Random generador = new Random();
    
    // Rellenamos el array con números entre valorMinimo y valorMaximo
    for (int i = 0; i < numerosEnteros.length; i++) {
      
      numerosEnteros[i] = (int) (generador.nextDouble() * (valorMaximo - valorMinimo) + valorMinimo);
    }
    
    return numerosEnteros;
  }
  
  /**
   * Método para calcular el valor mínimo de un array de números enteros
   * @param array Array sobre el que se averigua el mínimo. Debe tener una longitud mayor a cero
   * @return El valor mínimo entero del array
   * @throws IllegalArgumentException En caso de que el array sea null o tenga longitud 0
   */
  public static int getMinimoArrayEntero (int [] array) {
    
    // Caso de error
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException();
    }
    
    // Llegados aquí, si no ha saltado el error es que está ok el array
    // Para calcular el valor mínimo, lo recorremos y lo determinamos con una variable auxiliar
    int minimo = array[0];
    
    for (int numero : array) {
      minimo = (numero < minimo) ? numero : minimo;
    }
    
    return minimo;
  }
  
  /**
   * Método para calcular el valor máximo de un array de números enteros
   * @param array Array sobre el que se averigua el máximo. Debe tener una longitud mayor a cero
   * @return El valor máximo entero del array
   * @throws IllegalArgumentException En caso de que el array sea null o tenga longitud 0
   */
  public static int getMaximoArrayEntero (int [] array) {
    
    // Caso de error
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException();
    }
    
    // Llegados aquí, si no ha saltado el error es que está ok el array
    // Para calcular el valor máximo, lo recorremos y lo determinamos con una variable auxiliar
    int maximo= array[0];
    
    for (int numero : array) {
      maximo = (numero > maximo) ? numero : maximo;
    }
    
    return maximo;
  }
  
  /**
   * Método que calcula el número de apariciones de un valor en un array
   * @param array Array sobre el que se comprueban apariciones de un valor
   * @param valor Valor del que se observan las repeticiones
   * @return Devuelve 0 si el array es null o vacío, o el número de veces que aparece dicho valor en el 
   * array en caso contrario
   */
  public static int enteroApareceEnArrayEntero (int[] array, int valor) {
    
    // Comprobamos array null o vacío
    if (array == null || array.length == 0) {
      return 0;
    
    } else {
      // En caso contrario, recorremos el array en busca de una coincidencia de valor
      int coincidencias = 0;
      
      for (int numero : array) {
        coincidencias += (valor == numero) ? 1 : 0;
      }
      
      return coincidencias;
    }

  }
  
  
}
