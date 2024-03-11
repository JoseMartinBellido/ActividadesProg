package prog.unidad05.gestionficheros.ejercicio05;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import prog.unidad05.gestionficheros.ejercicio02.RutaIncorrectaException;

/**
 * Clase de gestión de ficheros para el usuario. Desplegará un menú y solicitará la acción a realizar por 
 * parte del usuario
 */
public class GestionFicheros4App {
  
  // Bloque de constantes para el menú
  private static final int OPCION_SALIR = 0;
  private static final int OPCION_LISTAR_FICHEROS = 1;
  private static final int OPCION_COPIAR_ARCHIVO = 2;
  private static final int OPCION_MOVER_ARCHIVO = 3;
  private static final int OPCION_BORRAR_FICHERO = 4;
  private static final int OPCION_CREAR_CARPETA = 5;
  
  private static final int OPCION_ULTIMA = OPCION_CREAR_CARPETA;
  
  /**
   * Scanner para la solicitud de datos
   */
  private Scanner sc;
  
  /**
   * Constructor de la clase
   * @param sc Scanner para solicitar datos al usuario
   */
  public GestionFicheros4App(Scanner sc) {
    this.sc = sc;
  }

  /**
   * Método main
   * @param args Argumentos
   */
  public static void main(String[] args) {
    
    System.out.println("Gestión de ficheros");
    
    // Se inicia el constructor
    GestionFicheros4App app = new GestionFicheros4App(new Scanner(System.in));
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
        System.out.println("Operación realizada con éxito");
        
      } catch (IllegalArgumentException e) {
        System.out.println("Opción solicitada no válida");
      
      } catch (RutaIncorrectaException e) {
        System.out.println("Una o varias de las rutas indicadas no existe o no referencia al tipo de"
            + " archivo especificado.");
        
      } catch (FileAlreadyExistsException e) {
        System.out.println("La ruta sobre la cual se está intentando copiar/mover el fichero o crear el "
            + "directorio ya tiene un fichero con el mismo nombre");
        
      } catch (DirectoryNotEmptyException e) {
        System.out.println("No se puede eliminar el archivo. Compruebe que tiene permisos y que si es"
            + "una carpeta, está vacía.");
        
      } catch (IOException e) {
        System.out.println("Error en el acceso y/o tratamiento de ficheros");
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
    System.out.println("2) Copiar Ficheros");
    System.out.println("3) Mover Ficheros");
    System.out.println("4) Borrar Fichero");
    System.out.println("5) Crear Carpeta");

  }

  /**
   * Método que solicita varias rutas dependiendo de la opción elegida por el usuario en el menú.
   * Si la opción es 1, se solicitará solo 1 ruta a directorio. 
   * Si la opción es 2 o 3, se solicitarán 2 rutas, siendo la primera a fichero y teniendo la segunda un
   * directorio válido
   * Si la opción es 4, se solicitará solo 1 ruta, pudiendo ser a directorio o a fichero
   * @param opcionElegida Opción elegida por el usuario en el menú
   * @return Un array con las rutas necesarias para la opción elegida por el usuario. 
   * @throws RutaIncorrectaException En caso de que alguna de las rutas obtenidas no exista o tenga
   * un formato incorrecto
   */
  private Path[] solicitaRutas(int opcionElegida) {
    
    Path[] arrayRutas = new Path[0];
    
    switch (opcionElegida) {
      case OPCION_LISTAR_FICHEROS:
        // Se solicita la ruta para listar
        System.out.print("Introduzca la ruta a la carpeta a listar: ");
        Path rutaListado = Path.of(sc.nextLine());
        
        // Se inicializa el array
        arrayRutas = new Path[]{rutaListado};
        
        // Se verifica que cumple las condiciones para listar el contenido
        if (Files.exists(rutaListado) && Files.isDirectory(rutaListado)) {
          return arrayRutas;
          
        } else {
          throw new RutaIncorrectaException();
        }
      
      case OPCION_COPIAR_ARCHIVO:
      case OPCION_MOVER_ARCHIVO:
        // Se solicitan las rutas
        System.out.print("Introduzca la ruta al archivo de origen: ");
        Path rutaOrigen = Path.of(sc.nextLine());
        
        System.out.print("Introduzca la ruta al archivo de destino: ");
        Path rutaDestino = Path.of(sc.nextLine());
      
        // Se inicializa el array
        arrayRutas = new Path[]{rutaOrigen, rutaDestino};
        // Se verifica que existe la primera ruta (fichero) y el segundo tiene un directorio padre existente
        if (Files.exists(rutaOrigen) && Files.isRegularFile(rutaOrigen) 
            && Files.exists(rutaDestino.getParent()) && Files.isDirectory(rutaDestino.getParent())) {
          return arrayRutas;
          
        } else {
          throw new RutaIncorrectaException();
        }
      
      case OPCION_BORRAR_FICHERO:
        // Se solicita la ruta para borrar
        System.out.print("Introduzca la ruta al fichero o carpeta a eliminar: ");
        Path rutaBorrado = Path.of(sc.nextLine());
        
        // Se inicializa el array
        arrayRutas = new Path[]{rutaBorrado};
        // Se verifica que existe la ruta
        if (Files.exists(rutaBorrado)) {
          return arrayRutas;
        } else {
          throw new RutaIncorrectaException();
        }
        
      case OPCION_CREAR_CARPETA:
        
        // Se solicita la ruta para borrar
        System.out.print("Introduzca la ruta de la carpeta a crear: ");
        Path rutaCreaCarpeta = Path.of(sc.nextLine());
        
        // Se inicializa el array
        arrayRutas = new Path[]{rutaCreaCarpeta};
        // Se verifica que existe la ruta
        if (Files.notExists(rutaCreaCarpeta)) {
          return arrayRutas;
        } else {
          throw new RutaIncorrectaException();
        }
        
      // Se toma cualquier otra opción como un error, aunque no debería llegarse aquí nunca
      default: 
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
   * @param opcionElegida Opción elegida por el usuario. Será un número entre 0 y 3
   * @throws RutaIncorrectaException En caso de introducir una ruta incorrecta
   * @throws FileAlreadyExistsException En caso de que el fichero ya exista en la ruta destino si la 
   * acción es de copia o movimiento de ficheros
   * @throws IOException En caso de un error en el acceso y/o tratamiento de ficheros
   */
  private void ejecutaAccion(int opcionElegida) throws IOException {
    
    if (opcionElegida != 0) {
      Path[] rutas;
      
      // Se ejecuta la opción elegida
      switch (opcionElegida) {
        // Opción para listar ficheros
        case OPCION_LISTAR_FICHEROS: 
          rutas = solicitaRutas(1);
          listaFicheros(rutas[0]);
          break;
          
        case OPCION_COPIAR_ARCHIVO:
          rutas = solicitaRutas(2);
          copiaFichero(rutas[0], rutas[1]);
          break;
          
        case OPCION_MOVER_ARCHIVO:
          rutas = solicitaRutas(3);
          mueveFichero(rutas[0], rutas[1]);
          break;

        case OPCION_BORRAR_FICHERO:
          rutas = solicitaRutas(4);
          borraFicheroDirectorio(rutas[0]);
          break;
          
        case OPCION_CREAR_CARPETA:
          rutas = solicitaRutas(5);
          creaCarpeta(rutas[0]);
          break;
      }
    }
  }
  
  /**
   * Método que lista todos los ficheros contenidos en una carpeta, dada su ruta
   * @param ruta Ruta verificada de la carpeta de la cual listar los ficheros
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
  
  /**
   * Método que copia un fichero dada una ruta origen del fichero y otra ruta destino.
   * @param rutaOrigen Ruta verificada del fichero origen a copiar
   * @param rutaDestino Ruta destino donde copiar el fichero, incluyendo el nombre del mismo.
   * @throws FileAlreadyExistsException En caso de que el fichero ya exista en la ruta destino
   * @throws IOException En caso de fallo en la copia del fichero
   */
  private void copiaFichero(Path rutaOrigen, Path rutaDestino) throws IOException {
    Files.copy(rutaOrigen, rutaDestino);
  }
  
  /**
   * Método que mueve un fichero dada una ruta origen del fichero y otra ruta destino. Si la ruta de 
   * de directorios es igual, lo que se produce es un renombreado del fichero
   * @param rutaOrigen Ruta verificada del fichero origen a mover
   * @param rutaDestino Ruta destino donde mover el fichero, incluyendo el nombre del mismo
   * @throws FileAlreadyExistsException En caso de que el fichero ya exista en la ruta destino
   * @throws IOException En caso de fallo al mover el fichero
   */
  private void mueveFichero(Path rutaOrigen, Path rutaDestino) throws IOException {
    Files.move(rutaOrigen, rutaDestino);
    
  }
  
  /**
   * Método que borra el archivo aportado en la ruta. Si se trata de un directorio, se borrará si y solo si
   * está vacío.
   * @param ruta Ruta al archivo a borrar
   * @throws DirectoryNotEmptyException En caso de intentar borrar un directorio no vacío
   * @throws IOException Problema en el acceso / borrado del archivo
   */
  private void borraFicheroDirectorio(Path ruta) throws IOException {
    Files.delete(ruta);
  }
  
  /**
   * Método que crea una nueva carpeta dada la ruta a la misma
   * @param ruta Ruta a proporcionar para la creación de la carpeta
   * @throws FileAlreadyExistsException En caso de que exista un fichero con el mismo nombre de la carpeta
   * que se está intentando crear
   * @throws IOException En caso de haber algún problema en la creación de la carpeta
   */
  private void creaCarpeta(Path ruta) throws IOException {
    // Con la excepción RutaIncorrectaException se controla que no existe esta ruta específica
    Files.createDirectories(ruta);
  }
  
}