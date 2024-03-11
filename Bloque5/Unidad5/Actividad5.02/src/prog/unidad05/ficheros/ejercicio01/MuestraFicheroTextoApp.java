package prog.unidad05.ficheros.ejercicio01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que muestra todo el contenido de un fichero de texto
 */
public class MuestraFicheroTextoApp {

  public static void main(String[] args) {
    
    // Se crea la ruta
    String rutaFichero;
    
    // Se comprueba si se pasa por linea de comandos
    if (args.length != 0) {
      
      rutaFichero = args[0];
    } else {
      // Sino, se pide al usuario
      Scanner sc = new Scanner(System.in);
      
      System.out.print("Introduce la ruta del archivo a mostrar: ");
      rutaFichero = sc.nextLine();
      
      sc.close();
    }
    
    System.out.printf("Contenidos del fichero \"%s\"%n", rutaFichero);
    
    // Se crea el BufferedReader y se lee el archivo si existe
    try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero))){
      String linea = null;
      
      // Se lee el archivo mientras no se haya llegado al final
      do {
        
        linea = reader.readLine();
        // Si no es null, se imprime por pantalla
        if (linea != null) {
          System.out.println(linea);  
        }
        
      } while (linea != null);
      
      
    } catch (FileNotFoundException e) {
      System.out.println("Archivo no encontrado");
      
    } catch (IOException e) {
      System.out.println("Problema en la lectura del archivo");
    }
    
  }

}
