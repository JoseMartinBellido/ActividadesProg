package prog.unidad06.mapas.ejercicio03;

import java.util.Random;
import java.util.Scanner;

import prog.unidad06.mapas.ejercicio01.DiccionarioSpanishEnglish;

public class JuegoPalabrasIngles {
  
  private static final int CANTIDAD_PALABRAS = 5;

  public static void main(String[] args) {

    System.out.println("¿CUÁNTO SABES DE INGLÉS?");
    
    // Generador de números aleatorios
    Random generador = new Random();
    
    // Scanner
    Scanner sc = new Scanner(System.in);
    
    // Diccionario
    DiccionarioSpanishEnglish diccionario = new DiccionarioSpanishEnglish();
    
    // Contador de aciertos
    int aciertos = 0;
    
    for (int i = 0; i < CANTIDAD_PALABRAS; i++) {
      
      // Generamos un número aleatorio para obtener la palabra del diccionario
      int aleatorio = generador.nextInt(0, diccionario.getPalabrasSpanish().size());
      
      // Interactuamos con el usuario
      // Sabemos que la palabra es un String por fuerza, aunque el método toArray convierta a Object
      String palabra = diccionario.getPalabrasSpanish().toArray()[aleatorio].toString();
      // Solicitamos la traducción y comprobamos
      System.out.print("Palabra nº" + (i + 1) + ". Dime cuál es la traducción al inglés de \"" 
      + palabra + "\": ");
      String intento = sc.nextLine();
      if (intento.equalsIgnoreCase(diccionario.traducir(palabra))) {
        System.out.println("¡ACERTASTE!");
        aciertos++;
      } else {
        System.out.println("¡FALLASTE! La respuesta correcta es " + diccionario.traducir(palabra));
      }
    }
    
    System.out.println("Acertarse " + aciertos + " de " + CANTIDAD_PALABRAS);
    
    sc.close();
  }

}
