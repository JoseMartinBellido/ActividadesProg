package prog.unidad05.gestionficheros.ejercicio02;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Clase de gestión de ficheros para el usuario. Desplegará un menú y solicitará la acción a realizar por 
 * parte del usuario
 */
public class GestionFicheros1App {
  
  // Bloque de constantes para el menú
  private static final int OPCION_SALIR = 0;
  private static final int OPCION_LISTAR_FICHEROS = 1;
  private static final int OPCION_ULTIMA = OPCION_LISTAR_FICHEROS;
  
  /**
   * Scanner para la solicitud de datos
   */
  private Scanner sc;
  
  /**
   * Constructor de la clase
   * @param sc Scanner para solicitar datos al usuario
   */
  public GestionFicheros1App(Scanner sc) {
    this.sc = sc;
  }

  /**
   * Método main
   * @param args Argumentos
   */
  public static void main(String[] args) {
    
    System.out.println("Gestión de ficheros");
    
    // Se inicia el constructor
    GestionFicheros1App app = new GestionFicheros1App(new Scanner(System.in));
    app.run();
    
    System.out.println("Saliendo del programa");
  }
  
  /**
   * Método run que ejecuta toda la aplicación
   */
  private void run() {
    
    int opcionElegida = -1;
    do {
      // Se despliega menú y se solicita opción. Se recoge IllegalArgumentException
      despliegaMenu();
      
      try {
        opcionElegida = solicitaAccion();
        ejecutaAccion(opcionElegida);
        
      } catch (IllegalArgumentException e) {
        System.out.println("Opción solicitada no válida");
      
      } catch (RutaIncorrectaException e) {
        System.out.println("La ruta no existe o no es una carpeta");
      }
    } while (opcionElegida != 0);
  }
  
  /**
   * Método que despliega el menú completo de acciones por consola
   */
  private void despliegaMenu() {
    System.out.println("MENU");
    System.out.println("0) Salir");
    System.out.println("1) Listar Ficheros");
  }
  
  /**
   * Método que solicita una ruta correcta a una carpeta local del ordenador
   * @return Una ruta correcta a una carpeta local
   * @throws RutaIncorrectaException En caso de que la ruta sea incorrecta
   */
  private Path solicitaRuta() {
    // Se solicita la ruta
    System.out.print("Introduzca la ruta a la carpeta a listar: ");
    Path ruta = Path.of(sc.nextLine());
    
    // Se verifica que existe la ruta y que es a una carpeta
    if (Files.exists(ruta) && Files.isDirectory(ruta)) {
      return ruta;
    } else {
      throw new RutaIncorrectaException();
    }
  }

  /**
   * Método que solicita una acción a realizar al usuario de entre todas las ofrecidas en el menú
   * @return El número de la opción elegida por el usuario. Será 0 o 1.
   * @throws IllegalArgumentException En caso de formato incorrecto de opción u opción no válida
   */
  private int solicitaAccion() {
    System.out.print("Seleccione opción: ");
    int opcion = Integer.parseInt(sc.nextLine());
    
    // Se verifica que sea correcta
    if (opcion >= OPCION_SALIR && opcion <= OPCION_ULTIMA) {
      return opcion;
    
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Método que ejecuta la acción elegida por el usuario
   * @param opcionElegida Opción elegida por el usuario. Será un número entre 0 y 1
   */
  private void ejecutaAccion(int opcionElegida) {
    
    if (opcionElegida != 0) {
      // Se ejecuta la opción elegida
      switch (opcionElegida) {
        // Opción para listar ficheros
        case OPCION_LISTAR_FICHEROS: 
          Path ruta = solicitaRuta();
          listaFicheros(ruta);
          break;

      }
    }
  }
  
  /**
   * Método que lista todos los ficheros contenidos en una carpeta, dada su ruta (ya verificada)
   * @param ruta Ruta de la carpeta de la cual listar los ficheros
   */
  private void listaFicheros(Path ruta) {
    // Carpeta obtenidad e la ruta
    File carpeta = new File(ruta.toString());
    
    // Se obtienen los ficheros del directorio y se listan
    String[] ficheros = carpeta.list();
    for (String fichero : ficheros) {
      // Se verifica si es carpeta o fichero antes de listar
      String tipoFichero = (Files.isDirectory(Path.of(ruta.toString(), fichero))) ? "Carpeta: " : "Fichero: ";
      System.out.printf("%s%s%n", tipoFichero, fichero);
    }   
  }
  
}
