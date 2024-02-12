package prog.unidad06.arraysuni.ejercicio07;

import java.util.Scanner;

/**
 * Operaciones varias con un array
 */
public class SuperArray2 {

  // Longitud del array
  private static final int LONGITUD = 30;

  public static void main(String[] args) {
    // Para solicitar desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Mostramos cabecera
    System.out.println("Super Array");
    
    // Solicitamos el entero
    System.out.print("Introduce un número entero cualquiera: ");
    long inicial = Long.parseLong(sc.nextLine());
    
    // Creamos el array
    long[] array = new long[LONGITUD];
    // Y asignamos el primero 
    array[0] = inicial;
    
    // Para cada elemento del segundo en adelante
    for (int i = 1; i < LONGITUD; i++) {
      // Hace el cálculo y almacena el resultado
      array[i] = (array[i - 1] + 1) * 2;
    }
    
    System.out.println("El array al revés es");
    // Imprimimos el array al reves
    for (int i = LONGITUD - 1; i >= 0; i--) {
      System.out.print(array[i]);
      if (i != 0) {
        System.out.print(", ");
      }
    }
  }

}
