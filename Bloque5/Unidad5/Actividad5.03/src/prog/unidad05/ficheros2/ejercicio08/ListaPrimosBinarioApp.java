package prog.unidad05.ficheros2.ejercicio08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class ListaPrimosBinarioApp {

  public static void main(String[] args) {

    // Se asigna la ruta directamente sobre el archivo creado anteriormente
    Path rutaArchivo = Path.of("primos.bin");
    
    try (FileInputStream reader = new FileInputStream(rutaArchivo.toString())) {
      
      // Se leen los bytes siempre y cuando existan en el archivo
      int byteLeido = -1;
      do {
        byteLeido = reader.read();
        if (byteLeido != -1) {
          System.out.println(byteLeido);
        }
        
      } while (byteLeido != -1);
      
    } catch (FileNotFoundException e) {
      System.out.println("Archivo no encontrado");
    } catch (IOException e) {
      System.out.println("Problema en la lectura del archivo");
    }
    
    
  }

}
