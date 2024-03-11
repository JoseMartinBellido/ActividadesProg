package prog.unidad05.ficheros2.ejercicio01;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class GeneraPrimosTextoApp {

  public static void main(String[] args) {
    
    // Se crea la ruta del fichero y se inicia la escritura
    String rutaFichero = "primos.txt";
    try (PrintWriter writer = new PrintWriter(Path.of(rutaFichero).toString())) {
      
        for (int i = 1; i <= 500; i++) {
          if (esPrimo(i)) {
            writer.write(String.format("%d%n", i));
          }
        }
    } catch (IOException e) {
      System.out.println("Error durante la escritura del archivo.");
    }
    

    
  }
  
  /**
   * Método que verifica si un número dado es primo
   * @param numero Número a verificar
   * @return true si es primo, false en caso contrario
   */
  public static boolean esPrimo(int numero) {
    // Si el número está entre -3 y 3 se establece como primo 
    if (numero >= -3 && numero <= 3) {
      return true;
    
    // Sino, se comprueban los divisores  
    } else {
      for (int i = 2; i <= (Math.abs(numero) / 2); i++) {
        if (numero % i == 0) {
          return false;
        }
      }
    }
    // Si se llega aquí, es primo
    return true;

  }

}
