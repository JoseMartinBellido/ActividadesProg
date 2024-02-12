package prog.unidad06.arraysuni.ejercicio10;

import java.util.Scanner;
import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

/**
 * Busca y reemplaza elementos en un array
 */
public class BuscarYReemplazar2 {
  
  // Longitud del array
  private static final int LONGITUD = 30;
  // Valor mínimo del rango de números aleatorios
  private static final int VALOR_MINIMO = 0;
  // Valor maximo del rango de números aleatorios
  private static final int VALOR_MAXIMO = 20;

  public static void main(String[] args) {
    // Para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Mostramos cabecera
    System.out.println("BUSCAR Y REEMPLAZAR EN ARRAY");
    
    // Generamos el array
    int[] array = UtilidadesArrays.generaArrayEnteroAleatorio(LONGITUD, VALOR_MINIMO, VALOR_MAXIMO);
    
    // Se imprime el array por pantalla
    System.out.println("Array original");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    
    // Se solicitan los valores a sustituir y el sustituto
    System.out.print("Introduzca el valor a sustituir: ");
    int valorASustituir = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el valor sustituto: ");
    int valorSustituto = Integer.parseInt(sc.nextLine());
    
    
    // Array con las sustituciones realizadas
    boolean[] sustituidos = new boolean[LONGITUD];
    // Para cada elemento del array
    for (int i = 0; i < array.length; i++) {
      // Si es el buscado
      if (array[i] == valorASustituir) {
        // Hacemos la sustitucion
        array[i] = valorSustituto;
        // Marcamos este como sustituido
        sustituidos[i] = true;
      } else {
        // No se ha sustituido
        sustituidos[i] = false;
      }
    }
    
    // Imprimimos el array
    for (int i = 0; i < array.length; i++) {
      // Si se ha sustituido
      if (sustituidos[i]) {
        // Se imprime entre comillas
        System.out.print("'" + array[i] + "' ");
      } else {
        // Se imprime sin comillas
        System.out.print(array[i] + " ");
      }
    }
  }

}
