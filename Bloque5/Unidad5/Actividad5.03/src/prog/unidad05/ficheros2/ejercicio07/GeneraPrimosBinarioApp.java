package prog.unidad05.ficheros2.ejercicio07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

import prog.unidad05.ficheros2.ejercicio01.GeneraPrimosTextoApp;

public class GeneraPrimosBinarioApp {

  public static void main(String[] args) {

    // Se comprueban los argumentos de línea de comandos
    if (args.length >= 1) {
      
      Path rutaFichero = Path.of(args[0]);
      
      // Se crea el nuevo fichero y se accede al mismo
      try (FileOutputStream writer = new FileOutputStream(rutaFichero.toString())) {
        
        System.out.printf("Escribiendo todos los números primos entre 1 y 255 en el archivo \"%s\"%n", 
            rutaFichero.toString());
        
        
        for (int i = 1; i <= 255; i++) {
          if (GeneraPrimosTextoApp.esPrimo(i)) {
            writer.write(i);
          }
        }
        
        System.out.println("Fichero creado correctamente.");
        
      } catch (IOException e) {
        System.out.println("Problemas en la escritura del fichero.");
      }
      
      
    } else {
      System.out.println("Faltan argumentos. Se necesita 1, la ruta del fichero de salida.");
    }
    
  }

}
