package unidad06.mapas.ejercicio02;

import java.util.Scanner;
import prog.unidad06.mapas.ejercicio01.DiccionarioSpanishEnglish;

/**
 * Permite al usuario traducir palabras del inglés al español
 */
public class TraductorSpanishEnglish {

  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Diccionario para traducir las palabras
    DiccionarioSpanishEnglish diccionario = new DiccionarioSpanishEnglish();
    
    // Cabecera
    System.out.println("TRADUCCIÓN ESPAÑOL - INGLÉS");
    
    // Palabra
    String palabra = "";
    // Mientras no se introduzca una palabra vacía
    do {
      // Lee la palabra desde teclado
      System.out.print("Introduzca una palabra a traducir al inglés (vacía para terminar): ");
      palabra = sc.nextLine();
      // Busca la palabra en el diccionario
      String traduccion = diccionario.traducir(palabra);
      // Si no es vacía
      if (!palabra.isBlank()) {
        // Si hay traducción
        if (traduccion != null) {
          // La muestra por pantalla
          System.out.println("La palabra española \"" + palabra + "\" significa \"" + traduccion + "\" en inglés");
        } else {
          // La palabra no está en el diccionario. Muestra mensaje al usuario
          System.out.println("Lo siento. La palabra \"" + palabra + "\" no se encuentra en nuestro diccionario");
        }
      }
    } while (!palabra.isBlank());
  }

}
