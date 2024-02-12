package sol.unidad06.arraysobjetos.ejercicio02;

import java.util.Scanner;

/**
 * Gestiona publicaciones de una biblioteca
 */
public class GestionaPublicacionesApp {

  // Opciones del menu
  // Opción de salir de la aplicación
  private static final int OPCION_SALIR = 0;
  // Agregar una publicacion
  private static final int OPCION_AGREGAR_PUBLICACION = 1;
  // Mostrar todas las publicaciones
  private static final int OPCION_MOSTRAR_PUBLICACIONES = 2;
  // Buscar por titulo
  private static final int OPCION_BUSCAR_POR_TITULO = 3;
  // Buscar por año
  private static final int OPCION_BUSCAR_POR_ANYO = 4;
  // Rango válido de opciones
  private static final int OPCION_MINIMO = OPCION_SALIR;
  private static final int OPCION_MAXIMO = OPCION_BUSCAR_POR_ANYO;
  
  // Array con lA PUBLICACIONES
  private Publicacion[] publicaciones;
  // Scanner para leer desde teclado
  private Scanner sc;
  
  public static void main(String[] args) {
    // Crea una instancia de la clase
    GestionaPublicacionesApp app = new GestionaPublicacionesApp();
    // Inicia los atributos
    app.publicaciones = new Publicacion[0];
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
        case OPCION_AGREGAR_PUBLICACION:
          agregarPublicacion();
          break;
        case OPCION_MOSTRAR_PUBLICACIONES:
          mostrarPublicaciones();
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
    System.out.println("GESTIÓN DE PUBLICACIONES");
    System.out.println("------------------------");
    System.out.println("(1) Agregar publicación");
    System.out.println("(2) Mostrar todas las publicaciones");
    System.out.println("(3) Buscar publicación por título");
    System.out.println("(4) Buscar publicación por año de publicación");
    System.out.println("(0) Salir de la aplicación");
    System.out.print("Introduzca una opción (0-4): ");
  }

  /**
   * Agrega una publicación a la biblioteca tras solicitar sus datos
   */
  private void agregarPublicacion() {
    // Cabecera
    System.out.println();
    System.out.println("AGREGAR PUBLICACIÓN");
    System.out.println("-------------------");
    
    try {
      // Solicita el tipo de publicación
      System.out.print("¿Qué tipo de publicación quiere crear, libro o revista? (l/r): ");
      char tipo = sc.nextLine().toLowerCase().charAt(0);
      Publicacion publicacion;
      // Si es libro
      if (tipo == 'l') {
        // Solicita datos del libro
        System.out.print("Introduzca el título del libro: ");
        String titulo = sc.nextLine();
        System.out.print("Introduzca el nombre del autor del libro: ");
        String autor = sc.nextLine();
        System.out.print("Introduzca el año de publicación del libro: ");
        int anyo = Integer.parseInt(sc.nextLine());
        // Crea el libro
        publicacion = new Libro(titulo, autor, anyo);
      } else if (tipo == 'r') {
        // Si es revista, solicita los datos de la revista
        System.out.print("Introduzca el título de la revista: ");
        String titulo = sc.nextLine();
        System.out.print("Introduzca el número de la revista: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.print("Introduzca el año de publicación de la revista: ");
        int anyo = Integer.parseInt(sc.nextLine());
        // Crea la revista
        publicacion = new Revista(titulo, numero, anyo);
      } else {
        // Tipo erróne. Error y termina
        System.out.println("Tipo elegido incorrecto. Debe ser 'l' para libro o 'r' para revista");
        return;
      }
      // Amplia el array
      ampliaArrayLibros();
      // Y almacena la publicacion
      publicaciones[publicaciones.length - 1] = publicacion;
      
    } catch (NumberFormatException e) {
      // Muestra un mensaje y termina
      System.out.println("Dato incorrecto. Debe introducir un número entero.");
    } catch (IndexOutOfBoundsException e) {
      // El carácter se ha dejado en blanco
      System.out.println("Error. No se ha especificado el carácter");
    }
    
  }

  /**
   * Ampliamos el array publicaciones para que tenga un elemento mas
   */
  private void ampliaArrayLibros() {
    // Crea un array alternativo con un elemento mas
    Publicacion[] nuevo = new Publicacion[publicaciones.length + 1];
    // Copia los elementos del array antiguo al nuevo
    for (int i = 0; i < publicaciones.length; i++) {
      nuevo[i] = publicaciones[i];
    }
    // Por último guarda el nuevo array en el atributo
    publicaciones = nuevo;
  }

  /**
   * Muestra las publicaciones de la biblioteca
   */
  private void mostrarPublicaciones() {
    // Cabecera
    System.out.println();
    System.out.println("MOSTRAR PUBLICACIONES");
    System.out.println("---------------------");
    
    // Para cada publicacion de la biblioteca
    for (Publicacion publicacion: publicaciones) {
      // Imprime la representación textual de la publicacion
      System.out.println(publicacion.obtenerCadena());
      
    }
  }

  /**
   * Busca publicaciones por parte del título
   */
  private void buscarPorTitulo() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR PUBLICACIÓN POR TÍTULO");
    System.out.println("-----------------------------");
    
    // Solicita el texto de búsqueda
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String textoBusqueda = sc.nextLine();
    // Si no está vacío
    if (!textoBusqueda.isBlank()) {
      // Para cada publicación
      // Contador de resultados
      int resultados = 0;
      for (Publicacion publicacion: publicaciones) {
        // Si el titulo contiene el texto de búsqueda
        if (publicacion.getTitulo().contains(textoBusqueda)) {
          // Muestra el contenido de la publicacion
          System.out.println(publicacion.obtenerCadena());
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
   * Busca publicaciones por año
   */
  private void buscarPorAnyo() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR PUBLICACIÓN POR AÑO DE PUBLICACIÓN");
    System.out.println("-----------------------------------------");
    
    try {
      // Solicita el texto de búsqueda
      System.out.print("Introduzca el año de publicación a buscar: ");
      int anyoBusqueda = Integer.parseInt(sc.nextLine());
      // Para cada publicacion
      // Contador de resultados
      int resultados = 0;
      for (Publicacion publicacion: publicaciones) {
        // Si la publicación está publicado en el año buscado
        if (publicacion.getAnyo() == anyoBusqueda) {
          // Muestra el contenido de la publicación
          System.out.println(publicacion.obtenerCadena());
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
