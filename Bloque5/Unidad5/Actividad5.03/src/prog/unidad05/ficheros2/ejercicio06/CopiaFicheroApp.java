package prog.unidad05.ficheros2.ejercicio06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class CopiaFicheroApp {

  public static void main(String[] args) {

    // Se comprueban los argumentos de línea de comandos
    if (args.length >= 2) {
      
      Path rutaEntrada = Path.of(args[0]);
      Path rutaSalida = Path.of(args[1]);
      
      // Se accede a los bytes del fichero
      try (FileInputStream reader = new FileInputStream(rutaEntrada.toString());
          FileOutputStream writer = new FileOutputStream(rutaSalida.toString())){
        
        System.out.printf("Copiando todos los bytes del archivo \"%s\" al archivo \"%s\".%n",
            rutaEntrada.toString(), rutaSalida.toString());
        int byteLeido = -1;
        
        // Se lee byte a byte y, si no es -1, se inserta en el nuevo fichero creado
        do {
          byteLeido = reader.read();
          if (byteLeido != -1) {
            writer.write(byteLeido);
          }
          
        } while (byteLeido != -1);
        
        System.out.println("Archivo copiado con éxito.");
        
      } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado");
      } catch (IOException e) {
        System.out.println("Error en la lectura del fichero");
      }
      
    } else {
      System.out.println("Faltan argumentos. Se necesitan 2 rutas hacia ficheros, uno de entrada y"
          + " otro de salida.");
    }
    
  }

}
