package prog.unidad06.mapas.ejercicio02;

import java.util.Scanner;

import prog.unidad06.mapas.ejercicio01.DiccionarioSpanishEnglish;

public class TraductorSpanishEnglish {

  public static void main(String[] args) {

    System.out.println("TRADUCCIÓN ESPAÑOL - INGLÉS");
    
    // Scanner para pedir las palabras al usuario
    Scanner sc = new Scanner(System.in);
    
    // Declaramos el diccionario
    DiccionarioSpanishEnglish diccionario = new DiccionarioSpanishEnglish();
    
    String palabra = "";
    do {
      // Solicitamos la palabra
      System.out.print("Introduzca una palabra a traducir al inglés (vacía para terminar): ");
      palabra = sc.nextLine();
      
      // SI lo introducido no es una cadena en blanco, se opera
      if (!palabra.isBlank()) {
        // Si la palabra se encuentra en el diccionario
        if (diccionario.traducir(palabra) != null) {
          System.out.println("La palabra española \"" + palabra + "\" significa \"" + diccionario.traducir(palabra) 
          + "\" en inglés");
        } else {
          System.out.println("La palabra indicada no se encuentra en el diccionario");
        }
      }
      
    } while (!palabra.isBlank());
    
    // Salimos del programa porque ya se ha introducido una cadena vacía
    System.out.println("Saliendo del programa...");
    
    sc.close();
  }

}
