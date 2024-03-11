package prog.unidad05.ficheros2.ejercicio03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

/**
 * Clase que lee dos ficheros y crea uno nuevo con un algoritmo de cremallera (añadiendo alternativamente
 * uno de cada fichero hasta vaciar uno de los dos, momento en el que se completa con las restantes 
 * del otro)
 */
public class GeneraCremalleraTextoApp {

  public static void main(String[] args) {
    
    // Se verifican los argumentos
    if (args.length >= 3) {

      // Se determinan las rutas a los ficheros
      Path rutaF1 = Path.of(args[0]);
      Path rutaF2 = Path.of(args[1]);
      Path rutaSalida = Path.of(args[2]);
      
      // Se conecta con ambos ficheros y se crea y conecta con el nuevo de salida
      try(
          BufferedReader readerF1 = new BufferedReader(new FileReader(rutaF1.toString()));
          BufferedReader readerF2 = new BufferedReader(new FileReader(rutaF2.toString()));
          PrintWriter writer = new PrintWriter(rutaSalida.toString())){
        
        System.out.printf("Procesando los ficheros de entrada \"%s\" y \"%s\" para generar el"
            + " archivo de salida \"%s\"%n", rutaF1.toString(), rutaF2.toString(), rutaSalida.toString());
        
        // Se definen las líneas de lectura
        String lineaF1 = null;
        String lineaF2 = null;
        
        // Se itera mientras ambos sean distinto de null.
        do {
          lineaF1 = readerF1.readLine();
          lineaF2 = readerF2.readLine();
          
          // Si alguna de las 2 no es null, se añade la que permita
          if (lineaF1 != null || lineaF2 != null) {
            escribeEnFichero(lineaF1, lineaF2, writer);
          }
            
        } while (lineaF1 != null || lineaF2 != null);
        
        System.out.println("Terminado.");
        
      } catch (FileNotFoundException e) {
        System.out.println("Alguno de los ficheros no se ha podido encontrar.");
      
      } catch (IOException e) {
        System.out.println("Error en la lectura de ficheros");
      }
      
    } else {
      System.out.println("Faltan rutas de archivo. Se deben proporcionar 3.");
    }
    
  }
  
  /**
   * Método privado que escribe primero la linea 1 y luego la 2 con el PrintWriter aportado
   * @param linea1 Primera linea a insertar. Si es null, no se añadirá
   * @param linea2 Segunda linea a insertar. Si es null, no se añadirá
   * @param writer Objeto de la clase PrintWriter conectado al fichero que escribirá las líneas en él
   */
  private static void escribeEnFichero(String linea1, String linea2, PrintWriter writer) {
    
    if (linea1 != null) {
      writer.write(String.format("%s%n", linea1));
    }
    
    if (linea2 != null) {
      writer.write(String.format("%s%n", linea2));
    }
  }
  

}
