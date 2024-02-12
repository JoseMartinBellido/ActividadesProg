package prog.unidad06.arraysuni.ejercicio09;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

/**
 * Crea un array aleatorio y otro a partir de él dividiendo
 * todos los elementos por la media
 */
public class DividirPorLaMedia2 {

  // Cantidad de elementos del array
  private static final int ELEMENTOS = 50;
  // Límite inferior del intervalo
  private static final int INICIO_INTERVALO = 300;
  // Limite superior del intervalo
  private static final int FIN_INTERVALO = 800;
  
  public static void main(String[] args) {
    
    // Creamos el array entero aleatorio usando UtilidadesArrays
    int[] arrayEntero = UtilidadesArrays.generaArrayEnteroAleatorio(ELEMENTOS, INICIO_INTERVALO, FIN_INTERVALO);
    
    // Calculamos la media
    // Iniciamos suma
    double suma = 0;
    // Para cada elemento del array entero
    for (int elemento: arrayEntero) {
      // Lo añadimos a la suma
      suma += elemento;
    }
    // Calculamos la media
    double media = suma / arrayEntero.length;
    
    // Creamos el array real
    double[] arrayReal = new double[ELEMENTOS];
    
    // Para cada elemento de ambos arrays
    for (int i = 0; i < arrayEntero.length; i++) {
      // Almacena en el real el resultado de dividir el original entero por la media
      arrayReal[i] = arrayEntero[i] / media;
    }
    
    // Imprimimos ambos arrays
    System.out.println("DIVIDIR POR LA MEDIA");
    System.out.print("El array entero es: ");
    imprimeArrayEntero(arrayEntero);
    System.out.println();
    System.out.print("El array real es: ");
    imprimeArrayReal(arrayReal);
    System.out.println();
  }

  // Imprime un array entero por pantalla
  private static void imprimeArrayEntero(int[] array) {
    // Para cada elemento
    for (int i = 0; i < array.length; i++) {
      // Imprimimos el elemento
      System.out.print(array[i]);
      // SI no es el último
      if (i < (array.length - 1)) {
        // Imprime una coma para separalo del siguiente
        System.out.print(", ");
      }
    }
  }

  // Imprime un array real. Excepto el tipo (double en lugar de int) es identico al anterior
  private static void imprimeArrayReal(double[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i < (array.length - 1)) {
        System.out.print(", ");
      }
    }
  }

}
