package sol.unidad06.arraysobjetos.ejercicio01;

import java.util.Scanner;

/**
 * Gestiona libros de una biblioteca
 */
public class GestionaLibrosApp {

  // Opciones del menu
  // Opción de salir de la aplicación
  private static final int OPCION_SALIR = 0;
  // Agregar un libro
  private static final int OPCION_AGREGAR_LIBRO = 1;
  // Mostrar todos los libros
  private static final int OPCION_MOSTRAR_LIBROS = 2;
  // Buscar por titulo
  private static final int OPCION_BUSCAR_POR_TITULO = 3;
  // Buscar por año
  private static final int OPCION_BUSCAR_POR_ANYO = 4;
  // Rango válido de opciones
  private static final int OPCION_MINIMO = OPCION_SALIR;
  private static final int OPCION_MAXIMO = OPCION_BUSCAR_POR_ANYO;
  
  // Array con los libros
  private Libro[] libros;
  // Scanner para leer desde teclado
  private Scanner sc;
  
  public static void main(String[] args) {
    // Crea una instancia de la clase
    GestionaLibrosApp app = new GestionaLibrosApp();
    // Inicia los atributos
    app.libros = new Libro[0];
    app.sc = new Scanner(System.in);
    // Lanza la aplicación
    app.run();
    
  }

  /**
   * Inicia la ejecución de la aplicación
   */
  private void run() {
    // Mientras no se nos indique terminar
    int opcion = OPCION_SALIR;
    do {
      // Muestra el menu y devuelve la opción
      opcion = muestraMenu();
      // Según la opción elegida
      switch (opcion) {
        case OPCION_AGREGAR_LIBRO:
          agregarLibro();
          break;
        case OPCION_MOSTRAR_LIBROS:
          mostrarLibros();
          break;
        case OPCION_BUSCAR_POR_TITULO:
          buscarPorTitulo();
          break;
        case OPCION_BUSCAR_POR_ANYO:
          buscarPorAnyo();
          break;
        case OPCION_SALIR:
          System.out.println("Saliendo del programa");
          break;
        default:
          System.out.println("Opción inválida (" + opcion + ")");
          throw new IllegalArgumentException();
      }
    // Hasta que la opción sea salir
    } while (opcion != OPCION_SALIR);
  }

  /**
   * Muestra el menu y devuelve la opción elegida.
   * Muestra el menú de manera persistente hasta que se elige una opción correcta
   * @return Opción elegida
   */
  private int muestraMenu() {
    // Mientras no se tenga una opción correcta
    for (;;) {
      // Muestra el menu
      showMenu();
      // Intenta leer la opción
      try {
        int opcion = Integer.parseInt(sc.nextLine());
        // Si se pudo leer, comprueba que esté en el rango correcto
        if (opcion >= OPCION_MINIMO && opcion <= OPCION_MAXIMO) {
          // Opción OK. La devuelve y terminamos
          return opcion;
        } else {
          // Opción NO OK
          // Mensaje y vuelta de nuevo
          System.out.println("La opción elegida no es válida. Inténtelo de nuevo");
        }
      } catch (NumberFormatException e) {
        // Lo que se ha introducido no es un número
        System.out.println("La opción elegida no es un número. Inténtelo de nuevo");
      }
    }
  }

  /**
   * Imprime el menú por pantalla
   */
  private void showMenu() {
    System.out.println();
    System.out.println("GESTIÓN DE LIBROS");
    System.out.println("-----------------");
    System.out.println("(1) Agregar libro");
    System.out.println("(2) Mostrar todos los libros");
    System.out.println("(3) Buscar libro por título");
    System.out.println("(4) Buscar libro por año de publicación");
    System.out.println("(0) Salir de la aplicación");
    System.out.print("Introduzca una opción (0-4): ");
  }

  /**
   * Agrega un libro a la biblioteca tras solicitar sus datos
   */
  private void agregarLibro() {
    // Cabecera
    System.out.println();
    System.out.println("AGREGAR LIBRO");
    System.out.println("-------------");
    
    try {
      // Solicita datos del libro
      System.out.print("Introduzca el título del libro: ");
      String titulo = sc.nextLine();
      System.out.print("Introduzca el nombre del autor del libro: ");
      String autor = sc.nextLine();
      System.out.print("Introduzca el año de publicación del libro: ");
      int anyo = Integer.parseInt(sc.nextLine());
      // Crea el libro
      Libro libro = new Libro(titulo, autor, anyo);
      // Amplia el array
      ampliaArrayLibros();
      // Y almacena el libro
      libros[libros.length - 1] = libro;
    } catch (NumberFormatException e) {
      // Muestra un mensaje y termina
      System.out.println("Error. El año de publicación del libro no es correcto. Aboratando.");
    }
    
  }

  /**
   * Ampliamos el array libros para que tenga un elemento mas
   */
  private void ampliaArrayLibros() {
    // Crea un array alternativo con un elemento mas
    Libro[] nuevo = new Libro[libros.length + 1];
    // Copia los elementos del array antiguo al nuevo
    for (int i = 0; i < libros.length; i++) {
      nuevo[i] = libros[i];
    }
    // Por último guarda el nuevo array en el atributo
    libros = nuevo;
  }

  /**
   * Muestra los libros de la biblioteca
   */
  private void mostrarLibros() {
    // Cabecera
    System.out.println();
    System.out.println("MOSTRAR LIBROS");
    System.out.println("--------------");
    
    // Para cada libro de la biblioteca
    for (Libro libro: libros) {
      // Imprime la representación textual del libro
      System.out.println(libro.obtenerCadena());
      
    }
  }

  /**
   * Busca libros por parte del título
   */
  private void buscarPorTitulo() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR LIBRO POR TÍTULO");
    System.out.println("-----------------------");
    
    // Solicita el texto de búsqueda
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String textoBusqueda = sc.nextLine();
    // Si no está vacío
    if (!textoBusqueda.isBlank()) {
      // Para cada libro
      // Contador de resultados
      int resultados = 0;
      for (Libro libro: libros) {
        // Si el titulo contiene el texto de búsqueda
        if (libro.getTitulo().contains(textoBusqueda)) {
          // Muestra el contenido del libro
          System.out.println(libro.obtenerCadena());
          resultados++;
        }
      }
      // Muestra resumen
      System.out.println("Se encontraron " + resultados + " coincidencias");
    } else {
      // Muestra error
      System.out.println("Error. El texto de búsqueda no puede dejarse vacío");
    }
  }

  /**
   * Busca libros por año
   */
  private void buscarPorAnyo() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR LIBRO POR AÑO DE PUBLICACIÓN");
    System.out.println("-----------------------------------");
    
    try {
      // Solicita el texto de búsqueda
      System.out.print("Introduzca el año de publicación a buscar: ");
      int anyoBusqueda = Integer.parseInt(sc.nextLine());
      // Para cada libro
      // Contador de resultados
      int resultados = 0;
      for (Libro libro: libros) {
        // Si el libro está publicado en el año buscado
        if (libro.getAnyo() == anyoBusqueda) {
          // Muestra el contenido del libro
          System.out.println(libro.obtenerCadena());
          resultados++;
        }
      }
      // Muestra resumen
      System.out.println("Se encontraron " + resultados + " coincidencias");
    } catch (NumberFormatException e) {
      // Lo que se ha introducido no es un número
      System.out.println("Error. Lo que se ha introducido no es un número válido.");
    }
  }

}
