package prog.unidad06.arraysobjetos.ejercicio01;

import java.util.Scanner;


public class GestionaLibrosApp {

  // Declaramos la colección de libros de la biblioteca
  private Libro[] libros;
  // Generamos el scanner para solicitar datos
  private Scanner sc;
  
  /**
   * Constructor de la clase. Inicializa el scanner y la colección de libros
   * @param sc Scanner de la clase
   */
  public GestionaLibrosApp(Scanner sc) {
    this.sc = sc;
  }
  
  public static void main(String[] args) {
    
    // Inicializamos la clase y corremos la aplicación
    GestionaLibrosApp app = new GestionaLibrosApp(new Scanner(System.in));
    app.libros = new Libro[0];
    app.run();
    
  }
  
  public void run() {
    // Declaramos la elección del usuario y continuamos la aplicación mientras no sea 0
    int eleccion = -1;
    do {
      try {
        // Solicitamos la elección del usuario en el menú
        eleccion = despliegaMenu();  
        if (eleccion >= 0 && eleccion < 5) {
          // Ejecutamos la opción elegida por el usuario
          switch (eleccion) {
          case 1: 
            System.out.println("AGREGAR LIBRO\n-------------\n");
            addLibro(solicitaLibro());
            break;
          case 2: 
            System.out.println("MOSTRAR LIBROS\n--------------\n");
            muestraTodosLosLibros();
            break;
          case 3: 
            System.out.println("BUSCAR LIBRO POR TÍTULO\n-----------------------\n");
            buscaPorTitulo();
            break;
          case 4: 
            System.out.println("BUSCAR LIBRO POR AÑO DE PUBLICACIÓN\n-----------------------------------\n");
            buscaPorAnyo();
            break;
          default:
            System.out.println("Saliendo del programa...");
          } 
        // Si la opción elegida no es válida  
        } else {
          System.out.println("La opción elegida no es válida. Inténtelo de nuevo por favor.");
        }
      // Si se introduce un dato que no es válido, se avisa al usuario y el programa continúa
      } catch (NumberFormatException e) {
        System.out.println("Alguno de los datos introducidos no tiene un formato válido. Inténtelo de nuevo.");
      }
       
    } while (eleccion != 0);
    
  }
  
  /**
   * Menú que despliega el menú por consola y solicita al usuario una acción
   * @return Un número entre el 0 y el 4, siendo cada uno de ellos una opción elegida distinta (1: Agregar
   * libro, 2: Mostrar todos los libros, 3: Buscar libro por título, 4: Buscar libro por año de publicación y
   * 0: salir de la aplicación
   */
  private int despliegaMenu() {
    System.out.println("GESTIÓN DE LIBROS");
    System.out.println("-----------------");
    
    System.out.println("(1) Agregar libro");
    System.out.println("(2) Mostrar todos los libros");
    System.out.println("(3) Buscar libro por título");
    System.out.println("(4) Buscar libro por año de publicación");
    System.out.println("(0) Salir de la aplicación");
    
    
    System.out.print("Introduzca una opción (0-4): ");
    int eleccion = Integer.parseInt(sc.nextLine());
    System.out.println();
    
    return eleccion;
  }
  
  /**
   * Método que solicita un libro por consola al usuario
   * @return El libro creado con los parámetros insertados
   * @throws NumberFormatException En caso de que alguno de los parámetros insertados sea incorrecto
   */
  private Libro solicitaLibro() {
    
    // Solicitamos los datos para generar un nuevo libro
    System.out.print("Introduzca el título del libro: ");
    String titulo = sc.nextLine();
    
    System.out.print("Introduzca el nombre del autor: ");
    String autor = sc.nextLine();

    System.out.print("Introduzca el año de publicación: ");
    int anyo = Integer.parseInt(sc.nextLine());

    return new Libro(titulo, autor, anyo);
  }
  
  /**
   * Método que añade un libro en el array de libros almacenados de la biblioteca
   * @param libro Libro a añadir
   */
  private void addLibro(Libro libro) {
    // Calculamos el tamaño del nuevo array y creamos el nuevo array de libros
    Libro[] librosActualizado = new Libro[libros.length + 1];
    
    // Copiamos libro a libro en el nuevo array
    for (int i = 0; i < libros.length; i++) {
      librosActualizado[i] = libros[i];
    }
    // Añadimos el último elemento. No contemplamos añadir un caso libro == null porque se construye 
    // por parámetros
    librosActualizado[libros.length] = libro;
    
    // Actualizamos nuestro atributo libros
    libros = librosActualizado;
  }
  
  /**
   * Función que muestra por consola la información de todos los libros de la biblioteca (título, autor
   * y año de publicación). Si no hay libros, informará de ello al usuario.
   */
  private void muestraTodosLosLibros() {
    if (libros.length == 0) {
      System.out.println("No hay ningún libro en la biblioteca.");
    } else {
      for (int i = 0; i < libros.length; i++) {
        imprimeLibro(libros[i]);
      }
    }
  }
  
  /**
   * Método que busca libros por título e imprime por pantalla su información, 
   * además del número de coincidencias
   */
  private void buscaPorTitulo() {
    // Número de coincidencias por título
    int coincidencias = 0;
    
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String texto = sc.nextLine();
    
    // Si el título se ha dejado en blanco
    if (texto.isBlank()) {
      
      System.out.println("No se puede dejar el título en blanco.");
    // En otro caso
    } else {
      // Buscamos las coincidencias de título
      for (int i = 0; i < libros.length; i++) {
        if (libros[i].getTitulo().contains(texto)) {
          imprimeLibro(libros[i]);
          coincidencias++;
        }
      }
      System.out.println("Se encontraron " + coincidencias + " coincidencias.");
    }

  }
  
  /**
   * Método que busca libros por año introducido e imprime por pantalla su información
   * @throws NumberFormatException En caso de introducir un dato en formato incorrecto
   */
  private void buscaPorAnyo() {
    // Número de coincidencias por año de publicación
    int coincidencias = 0;
    
    System.out.print("Introduzca el año de publicación a buscar: ");
    int anyoPublicacion = Integer.parseInt(sc.nextLine());
    // Buscamos las coincidencias de título
    for (int i = 0; i < libros.length; i++) {
      if (libros[i].getAnyoPublicacion() == anyoPublicacion) {
        imprimeLibro(libros[i]);
        coincidencias++;
      }
    }
    System.out.println("Se encontraron " + coincidencias + " coincidencias.");
  }
  
  /**
   * Método privado que imprime por consola toda la información de un libro
   * @param libro Libro del cual se imprimen título, autor y año de publicación
   */
  private void imprimeLibro(Libro libro) {
    // No se contempla caso de Libro null porque todo libro se introduce como parámetro
    System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() 
        + ", Año Publicación: " + libro.getAnyoPublicacion());
  }

}
