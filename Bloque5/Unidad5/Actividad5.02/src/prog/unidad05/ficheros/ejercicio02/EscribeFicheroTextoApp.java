package prog.unidad05.ficheros.ejercicio02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase que crea o sobreescribe un fichero de texto, indicando la ruta y el texto a incluir por consola
 * o por línea de comandos
 */
public class EscribeFicheroTextoApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    // Ruta del fichero
    String rutaFichero;
    if (args.length != 0) {
      rutaFichero = args[0];
      
    } else {
      System.out.print("Introduce la ruta del archivo a crear: ");
      rutaFichero = sc.nextLine();
    }
    
    String linea = null;
    
    try (PrintWriter writer = new PrintWriter(rutaFichero)) {
      
      System.out.println("Fichero iniciado con éxito. Introduzca el texto a almacenar línea a línea "
          + "y una línea vacía para terminar.");
      
      // Se insertan lineas de texto hasta que se introduzca una línea vacía
      do {
        // Se solicita el texto y se introduce en el fichero
        System.out.print("Texto de la línea: ");
        linea = sc.nextLine();
        
        writer.printf("%s%n", linea);
        
      } while (!linea.isEmpty());
      
    } catch (IOException e) {
      System.out.println("Se ha detectado un problema en la escritura del fichero. Cerrando el programa");
    }
    
    sc.close();

  }

}
