package unidad06.mapas.ejercicio03;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import prog.unidad06.mapas.ejercicio01.DiccionarioSpanishEnglish;

/**
 * Juego de traducción de palabras del español al inglés
 */
public class JuegoPalabrasIngles {
  
  // Número de palabras a traducir
  private static int PALABRAS = 5;
  

  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Diccionario
    DiccionarioSpanishEnglish diccionario = new DiccionarioSpanishEnglish();
    
    // Cabecera
    System.out.println("¿CUANDO SABES DE INGLÉS?");
    
    // Contador de aciertos
    int aciertos = 0;
    // Para cada palabra
    for (int i = 0; i < PALABRAS; i++) {
      // Seleccionamos la palabra al azar de entre las que contiene el diccionario
      String palabra = getPalabraAlAzar(diccionario.getPalabrasSpanish());
      // Mostramos la pregunta al usuario
      System.out.print("Palabra nº" + (i + 1) + ". Dime cual es la traducción al inglés de \"" + palabra + "\": ");
      // Leemos la respuesta
      String respuesta = sc.nextLine();
      // Si la respuesta es correcta
      if (respuesta.equals(diccionario.traducir(palabra))) {
        // Mensaje
        System.out.println("¡ACERTASTE!");
        // Y contamos un acierto mas
        aciertos++;
      } else {
        // Mensaje de error
        System.out.println("¡FALLASTE! La respuesta correcta es \"" + diccionario.traducir(palabra) + "\"");
      }
    }
    // Mostramos el resultado final
    System.out.println("Acertaste " + aciertos + " de " + PALABRAS);
  }


  /**
   * Obtiene una palabra al azar de un conjunto de palabras
   * @param palabras Conjunto de palabras
   * @return Palabra elegida
   */
  private static String getPalabraAlAzar(Set<String> palabras) {
    // Obtiene un número al azar desde 0 hasta la longitud del conjunto - 1
    int posicionPalabra = new Random().nextInt(0, palabras.size());
    
    // Resultado
    String resultado = "";
    
    // Para cada palabra del conjunto
    for (String palabra: palabras) {
      // Si es la palabra
      if (posicionPalabra == 0) {
        // La almacena
        resultado = palabra;
      }
      // Descontamos
      posicionPalabra--;
    }
    return resultado;
  }

}
