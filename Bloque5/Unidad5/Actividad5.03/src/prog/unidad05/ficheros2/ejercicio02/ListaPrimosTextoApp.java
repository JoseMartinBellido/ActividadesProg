package prog.unidad05.ficheros2.ejercicio02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class ListaPrimosTextoApp {

  public static void main(String[] args) {

    // Ruta del fichero y apertura
    String rutaFichero = "primos.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(rutaFichero).toString()))){
      
      // Se lee el fichero
      String linea = null;
      do {
        linea = reader.readLine();
        if (linea != null) {
          System.out.println(linea);
        }
      } while (linea != null);
    
    } catch (FileNotFoundException e) {
      System.out.println("Fichero no encontrado");
    
    } catch (IOException e) {
      System.out.println("Problema en la lectura del fichero");
    }
    
    
  }

}
