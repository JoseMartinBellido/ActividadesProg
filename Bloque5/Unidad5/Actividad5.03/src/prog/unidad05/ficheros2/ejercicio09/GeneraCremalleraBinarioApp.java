package prog.unidad05.ficheros2.ejercicio09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class GeneraCremalleraBinarioApp {

  public static void main(String[] args) {

    // Se verifican los argumentos
    if (args.length >= 3) {

      // Se determinan las rutas a los ficheros
      Path rutaF1 = Path.of(args[0]);
      Path rutaF2 = Path.of(args[1]);
      Path rutaSalida = Path.of(args[2]);
      
      // Se conecta con ambos ficheros y se crea y conecta con el nuevo de salida
      try(
          FileInputStream readerF1 = new FileInputStream(rutaF1.toString());
          FileInputStream readerF2 = new FileInputStream(rutaF2.toString());
          FileOutputStream writer = new FileOutputStream(rutaSalida.toString())){
        
        System.out.printf("Procesando los ficheros de entrada \"%s\" y \"%s\" para generar el"
            + " archivo de salida \"%s\"%n", rutaF1.toString(), rutaF2.toString(), rutaSalida.toString());
        
        // Se definen los bytes de lectura
        int numF1 = -1;
        int numF2 = -1;
        
        // Se itera mientras uno de los dos sea distinto de -1.
        do {
          numF1 = readerF1.read();
          numF2 = readerF2.read();
          
          // Si alguna de las 2 no es null, se añade la que permita
          if (numF1 != -1 || numF2 != -1) {
            escribeEnFichero(numF1, numF2, writer);
          }
            
        } while (numF1 != -1 || numF2 != -1);
        
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
   * Método privado que escribe primero el número 1 y luego el número 2 con el FileOutputStream aportado
   * @param linea1 Primer número a insertar. Si es -1, no se añadirá
   * @param linea2 Segundo número a insertar. Si es -1, no se añadirá
   * @param writer Objeto de la clase FileOutputStream conectado al fichero que escribirá 
   * las líneas en él
   * @throws IOException En caso de haber cualquier problema de escritura
   */
  private static void escribeEnFichero(int num1, int num2, FileOutputStream writer) throws IOException {
    
    if (num1!= -1) {
      writer.write(num1);
    }
    
    if (num2 != -1) {
      writer.write(num2);
    }
  }
  

}

