package prog.unidad05.ficheros.ejercicio03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase de interacción con un usuario que busca un byte en un fichero dado
 */
public class CuentaBytesEnArchivoApp {

  /**
   * Scanner para la inserción de datos del usuario
   */
  private Scanner sc;
  
  /**
   * Ruta del fichero sobre el cual trabajar
   */
  private String rutaFichero;
  
  /**
   * Constructor de la clase. Inicia el Scanner
   */
  public CuentaBytesEnArchivoApp() {
    sc = new Scanner(System.in);
  }
  
  public static void main(String[] args) {
    
    CuentaBytesEnArchivoApp app = new CuentaBytesEnArchivoApp();
    
    // Ruta del fichero
    app.rutaFichero = (args.length != 0) ? args[0] : app.obtenerRuta();
    
    app.run();
  }
  
  /**
   * Método run de la clase. Ejecuta las funcionalidades principales de la clase
   */
  public void run() {
    
    try (FileInputStream entrada = new FileInputStream(rutaFichero)){
      
      // Se obtiene el byte a buscar del usuario
      int byteABuscar = obtenerByte();
      
      // Se imprime el resultado de la búsqueda
      System.out.printf("El byte %d aparece %d veces en el fichero %s", 
          byteABuscar, cuentaBytesIguales(byteABuscar, entrada), rutaFichero);
      
    
    } catch (ByteIncorrectoException e) {
      System.out.println("El número de byte introducido no es el correcto");
      
    } catch (FileNotFoundException e) {
      System.out.println("No se encontró el archivo.");
      
    } catch (IOException e) {
      System.out.println("Error en la lectura del archivo.");
      
    }
    
  }
  
  /**
   * Método que obtiene la ruta del fichero del usuario
   * @return La ruta del fichero del usuario
   */
  private String obtenerRuta() {
    System.out.print("Introduce la ruta del archivo a acceder: ");
    return sc.nextLine();
  }
  
  /**
   * Método que obtiene el byte a buscar del usuario 
   * @return Un byte a buscar en el fichero. Debe ser un valor entre 0 y 255.
   * @throws ByteIncorrectoException Si el dato introducido es incorrecto
   */
  private int obtenerByte() {
    // Se solicita el byte
    System.out.print("Introduce el valor del byte a contabilizar: ");
    String byteInsertado = sc.nextLine();
    
    // Se verifica que el byte sea correcto
    try {
      int byteABuscar = Integer.parseInt(byteInsertado);
      
      if (byteABuscar >= 0 && byteABuscar <= 255) {
        return byteABuscar;
      } else {
        throw new IllegalArgumentException();
      }
      
    // Se lanza un error concreto para bytes incorrectos
    } catch (IllegalArgumentException e) {
      throw new ByteIncorrectoException();
    }
  }
  
  /**
   * Método que busca un byte concreto en un fichero y cuenta el número de repeticiones
   * @param byteABuscar Byte a buscar en el fichero
   * @return El número de repeticiones del byte aportado en el fichero
   * @throws IOException En caso de error en la lectura
   */
  private int cuentaBytesIguales(int byteABuscar, FileInputStream entrada) throws IOException{
    
    int byteLeido = -1;
    int contadorIguales = 0;
    
    do {
      byteLeido = entrada.read();
      contadorIguales += (byteLeido == byteABuscar) ? 1 : 0;

    } while (byteLeido != -1);
    
    return contadorIguales;
    
  }

}
