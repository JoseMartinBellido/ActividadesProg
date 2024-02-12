package unidad06.conjuntos.ejercicio02;

import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Lee nombres desde teclado y elimina los duplicados
 * Imprime los nombres de forma ordenada
 */
public class NombresEliminaDuplicadosOrdenados {

  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    // Cabecera
    System.out.println("NOMBRES DUPLICADOS II");
    
    // Conjunto donde vamos a almacenar los nombres
    Set<String> nombres = new TreeSet<>();
    
    // Mientras que no se introduzca un nombre vacio
    String nombreLeido = "";
    do {
      // Leemos el nombre siguiente
      System.out.print("Introduzca un nombre (vacío para terminar): ");
      nombreLeido = sc.nextLine();
      // Si el nombre no está vacío
      if (!nombreLeido.isBlank()) {
        // Se añade al conjunto
        nombres.add(nombreLeido);
      }
    } while (!nombreLeido.isBlank());
    
    // Ahora mostramos los nombres contenidos en el conjunto
    System.out.println("Los nombres introducidos sin duplicados son: ");
    for (String nombre: nombres) {
      System.out.println(nombre);
    }
  }

}
