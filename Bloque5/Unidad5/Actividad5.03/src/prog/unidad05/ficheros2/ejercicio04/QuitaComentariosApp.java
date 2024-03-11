package prog.unidad05.ficheros2.ejercicio04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class QuitaComentariosApp {

  public static void main(String[] args) {

    // Se comprueba si se han pasado los argumentos
    if (args.length >= 2) {
      
      // Rutas a los ficheros de entrada y salida
      Path rutaE = Path.of(args[0]);
      Path rutaS = Path.of(args[1]);
      
      // Acceso a los ficheros
      try (
          BufferedReader reader = new BufferedReader(new FileReader(rutaE.toString()));
          PrintWriter writer = new PrintWriter(rutaS.toString())) {
        
        System.out.printf("Eliminando comentarios de archivo \"%s\".%nSalida en archivo \"%s\"%n",
            rutaE.toString(), rutaS.toString());
        
        // Se lee cada línea en busca de comentarios
        String linea = null;
        
        do {
          linea = reader.readLine();
          // Se comprueba si la linea (sin espacios al comienzo) empieza por //. Si no, se añade
          if (linea != null &&  (!linea.trim().matches("//.*"))) {
              writer.write(String.format("%s%n", linea));
          }
          
        } while (linea != null);
        
      } catch (FileNotFoundException e) {
        System.out.println("Fichero no encontrado");
      
      } catch (IOException e) {
        System.out.println("Error en la lectura/escritura de ficheros");
      }
      
      
    } else {
      System.out.println("Se esperan al menos dos parámetros. Terminando");
    }
    
  }

}
