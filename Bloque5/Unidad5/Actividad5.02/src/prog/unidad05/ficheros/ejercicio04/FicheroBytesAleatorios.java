package prog.unidad05.ficheros.ejercicio04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FicheroBytesAleatorios {
  
  private static Scanner sc;

  public static void main(String[] args) {

    sc = new Scanner(System.in);
    
    // Ruta del fichero
    String rutaArchivo = (args.length != 0) ? args[0] : obtenerRuta();
    
    try (FileOutputStream salidaBytes = new FileOutputStream(rutaArchivo)){
      // Se obtiene la longitud del archivo
      int longitudArchivo = obtenerLongitudArchivo();
      
      // Se obtienen los límites inferior y superior
      int[] rango = obtenerRangoBytes();
      
      // Se rellena el archivo con los datos anteriores
      rellenaArchivo(salidaBytes, longitudArchivo, rango[0], rango[1]);
      
    } catch (IllegalArgumentException e) {
    System.out.println("Error en la introducción de parámetros numéricos");
      
    } catch (FileNotFoundException e) {
      System.out.println("No se encontró el archivo");
      
    } catch (IOException e) {
      System.out.println("Error durante la manipulación del archivo");
    }
  }
  
  /**
   * Método que obtiene la ruta del fichero que el usuario desea crear
   * @return La ruta del fichero del usuario
   */
  private static String obtenerRuta() {
    System.out.print("Introduzca la ruta al archivo a crear: ");
    return sc.nextLine();
  }
  
  /**
   * Método que obtiene la longitud del archivo medida en bytes
   * @return La longitud del archivo medida en la cantidad de bytes. Deberá ser mayor o igual a 1
   * @throws IllegalArgumentException En caso de introducir la longitud en formato erróneo
   */
  private static int obtenerLongitudArchivo() {
      System.out.print("Introduzca la longitud del fichero a crear (en bytes): ");
      
      int longitud = Integer.parseInt(sc.nextLine());
      
      if (longitud > 0) {
        return longitud;
      } else {
        throw new IllegalArgumentException();
      }
  }
  
  /**
   * Método que obtiene el rango de bytes a insertar en el fichero
   * @return Un array de 2 posiciones, siendo la primera el límite inferior del rango y la segunda
   * el límite superior. Ambos serán números entre 0 y 255, cumpliendo el requisito de que el 
   * límite inferior será menor o igual al superior
   * @throws IllegalArgumentException En caso de que los nombres introducidos no cumplan las condiciones
   */
  private static int[] obtenerRangoBytes() {
    // Se obtiene el rango
    System.out.print("Introduzca el límite inferior del rango de extracción de bytes aleatorios "
        + "(0-255): ");
    int limInf = Integer.parseInt(sc.nextLine());
    
    System.out.print("Introduzca el límite superior del rango de extracción de bytes aleatorios "
        + "(0-255): ");
    int limSup = Integer.parseInt(sc.nextLine());
    
    // Se verifica que sea un rango válido
    if (limSup >= limInf && limInf >= 0 && limInf <= 255 && limSup >= 0 && limSup <= 255) {
      return new int[] {limInf, limSup};
      
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Método que rellena un archivo con bytes aleatorios
   * @param flujoSalidaBytes Stream de salida de bytes
   * @param longitud Longitud del archivo a rellenar
   * @param limiteInferior Límite inferior del rango de bytes a insertar
   * @param limiteSuperior Límite superior del rango de bytes a insertar
   * @throws IOException 
   */
  private static void rellenaArchivo(FileOutputStream flujoSalidaBytes, 
      int longitud, int limiteInferior, int limiteSuperior) throws IOException {
    
    Random generadorAleatorios = new Random();
    
    // Se rellena el archivo con bytes aleatorios
    for (int i = 0; i < longitud; i++) {
      flujoSalidaBytes.write(generadorAleatorios.nextInt(limiteInferior, limiteSuperior + 1)); 
    }
    
    System.out.println("Fichero creado");
  }
  
}
