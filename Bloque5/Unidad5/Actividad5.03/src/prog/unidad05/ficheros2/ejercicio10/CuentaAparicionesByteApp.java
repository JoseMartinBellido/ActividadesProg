package prog.unidad05.ficheros2.ejercicio10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class CuentaAparicionesByteApp {

  public static void main(String[] args) {

    // Se verifican los argumentos
    if (args.length >= 2) {
      
      Path rutaFichero = Path.of(args[0]);
      String byteABuscar = args[1];
      
      // Si el dato introducido cumple el formato
      if (byteABuscar.matches("[\\dABCDEF]{2}")) {
     // Se accede al fichero para su lectura
        try (FileInputStream reader = new FileInputStream(rutaFichero.toString())){
          
          // Se lee mientras el byte sea distinto de -1
          int byteLeidoInt = -1;
          int contadorRepeticiones = 0;
          do {
            byteLeidoInt = reader.read();
            // Se pasa el byte a hexadecimal y si es igual al buscado, se añade al contador
            String byteLeidoStr = Integer.toHexString(byteLeidoInt).toUpperCase();
            contadorRepeticiones += (byteLeidoStr.equals(byteABuscar)) ? 1 : 0;
          } while (byteLeidoInt != -1);
          
          System.out.printf("El byte %s aparece %d veces en el fichero %s", 
              byteABuscar, contadorRepeticiones, rutaFichero.toString());
          
        } catch (FileNotFoundException e) {
          System.out.println("Archivo no encontrado");
        } catch (IOException e) {
          System.out.println("Problema en la lectura del archivo");
        }
      
      
      } else {
        System.out.println("El byte introducido no es válido.");
      }
      
    } else {
      System.out.println("Cantidad de argumentos insuficiente. Es necesaria una ruta a un fichero binario"
          + " y un byte a buscar en formato hexadecimal.");
    }
    
  }

}
