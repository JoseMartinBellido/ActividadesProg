package prog.unidad06.conjuntos.ejercicio01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NombresEliminaDuplicados {

  public static void main(String[] args) {

    System.out.println("NOMBRES DUPLICADOS I");
    
    // Scanner para leer datos del usuario
    Scanner sc = new Scanner(System.in);
    
    // Creamos el conjunto de nombres
    Set<String> nombres = new HashSet<>();
    
    String nombre = null;
    do {
      // Solicitamos el dato mientras no sea vacío
      System.out.print("Introduzca un nombre (vacío para terminar): ");
      nombre = sc.nextLine();
      
      // Lo insertamos en el conjunto si no es vacío
      if (!nombre.isEmpty()) {
        nombres.add(nombre);
      }
    } while (!nombre.isEmpty());
  
    // Mostramos los nombres
    System.out.println("Los nombres introducidos sin duplicados son:");
    for (String name : nombres) {
      System.out.println(name);
    }
    
    sc.close();
  }

}