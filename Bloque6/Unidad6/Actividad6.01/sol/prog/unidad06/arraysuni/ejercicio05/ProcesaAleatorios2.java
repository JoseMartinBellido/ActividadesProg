package prog.unidad06.arraysuni.ejercicio05;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

/**
 * Crea un array de enteros aleatorios y busca el mayor,
 * menor y cuantas veces aparecen ambos
 */
public class ProcesaAleatorios2 {
  
  // Longitud del array de números aleatorios
  private static final int LONGITUD_ARRAY = 150;
  // Valor mínimo de los números aleatorios
  private static final int VALOR_MINIMO = 1;
  // Valor maximo de los números aleatorios
  private static final int VALOR_MAXIMO = 300;
  

  public static void main(String[] args) {
    // Creamos el array de números aleatorios
    // Usamos UtilidadesArrays
    int[] array = UtilidadesArrays.generaArrayEnteroAleatorio(LONGITUD_ARRAY
      , VALOR_MINIMO, VALOR_MAXIMO);
    
    // Buscamos el mayor y el menor
    // Usamos UtilidadesArrays
    int minimo = UtilidadesArrays.getMinimoArrayEntero(array);
    int maximo = UtilidadesArrays.getMaximoArrayEntero(array);
    
    // Contamos cuantas veces aparece cada uno en el array
    int aparicionesMinimo = UtilidadesArrays.enteroApareceEnArrayEntero(array, minimo);
    int aparicionesMaximo = UtilidadesArrays.enteroApareceEnArrayEntero(array, maximo);
    
    // Mostramos los resultados
    System.out.println("El valor mínimo en el array es " + minimo
      + " y aparece " + aparicionesMinimo + " veces");
    System.out.println("El valor máximo en el array es " + maximo
        + " y aparece " + aparicionesMaximo + " veces");
  }

}
