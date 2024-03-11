package prog.unidad05.ficheros2.ejercicio05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class CuentaAparicionesPalabraApp {

  public static void main(String[] args) {

    // Se comprueban los argumentos de línea de comandos
    if (args.length >= 2) {
      
      Path rutaFichero = Path.of(args[0]);
      String palabraABuscar = args[1];
      
      // Se accede al fichero
      try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero.toString()))) {
        
        System.out.printf("Contando las apariciones de la palabra \"%s\" en el fichero \"%s\"%n"
            , palabraABuscar, rutaFichero.toString());
        
        // Se leen las líneas mientras que no sean null
        String linea = null;
        int contador = 0;
        do {
          linea = reader.readLine();
          if (linea != null) {
            // Se separan las palabras mediante los caracteres '.', ',', ';', y los espacios
            String[] palabras = linea.split("[\\s\\.,;]+");
            for (String palabra : palabras) {
              contador += (palabra.equals(palabraABuscar)) ? 1 : 0;
            }
          }
        } while (linea != null);
        
        // Se imprimen los resultados
        String veces = (contador == 1) ? "vez" : "veces";
        System.out.printf("La palabra \"%s\" aparece %d %s en el archivo \"%s\"%n",
            palabraABuscar, contador, veces, rutaFichero.toString());
        
      } catch (FileNotFoundException e) {
        System.out.println("Fichero no encontrado");
      } catch (IOException e) {
        System.out.println("Error de lectura del fichero");
      }

    } else {
      System.out.println("Faltan argumentos. Se necesitan 2, el nombre del fichero y la palabra");
    }
    
  }

}
