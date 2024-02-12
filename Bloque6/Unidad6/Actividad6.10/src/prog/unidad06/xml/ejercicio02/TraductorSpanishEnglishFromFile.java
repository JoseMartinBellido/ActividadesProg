package prog.unidad06.xml.ejercicio02;

import java.util.Scanner;

import prog.unidad06.xml.ejercicio01.DiccionarioSpanishEnglishFromFile;

public class TraductorSpanishEnglishFromFile {

  /**
   * Scanner para solicitar datos al usuario por consola
   */
  private Scanner sc;
  
  private DiccionarioSpanishEnglishFromFile diccionario;
  
  public static void main(String[] args) {
    TraductorSpanishEnglishFromFile traductor = new TraductorSpanishEnglishFromFile();
    traductor.sc = new Scanner(System.in);
    traductor.diccionario = new DiccionarioSpanishEnglishFromFile("diccionario.xml");
    traductor.run();
  }

  private void run() {

    System.out.println("TRADUCCIÓN ESPAÑOL - INGLÉS (XML)");
    
    String palabra = null;
    
    do {
      palabra = solicitaPalabra();
      // Si la palabra no es  un espacio en blanco
      if (!palabra.isBlank()) {
        String traduccion = diccionario.traducir(palabra);
        imprimePalabra(palabra, traduccion);  
      }
    } while (!palabra.isBlank());
  
  }
  
  /**
   * Método que solicita una palabra al usuario por consola
   * @return La palabra introducida por el usuario
   */
  private String solicitaPalabra() {
    System.out.print("Introduzca una palabra a traducir al inglés (vacía para terminar):");
    return sc.nextLine();
  }
  

  private void imprimePalabra(String palabra, String traduccion) {
    if (traduccion != null) {
      System.out.println("La palabra española \"" + palabra + "\" significa \"" + traduccion + "\" en inglés.");
    } else {
      System.out.println("Lo siento, la palabra \"" + palabra + "\" no se encuentra en nuestro diccionario.");
    }
  }
}
