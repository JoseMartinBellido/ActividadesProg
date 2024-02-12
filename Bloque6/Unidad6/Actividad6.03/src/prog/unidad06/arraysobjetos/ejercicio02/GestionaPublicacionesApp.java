package prog.unidad06.arraysobjetos.ejercicio02;

import java.util.Scanner;


public class GestionaPublicacionesApp {

  // Declaramos la colección de libros de la biblioteca
  private Publicacion[] publicaciones;
  // Generamos el scanner para solicitar datos
  private Scanner sc;
  
  public static void main(String[] args) {
    
    // Inicializamos la clase y corremos la aplicación
    GestionaPublicacionesApp app = new GestionaPublicacionesApp();
    app.publicaciones = new Publicacion[0];
    app.sc = new Scanner(System.in);
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
            System.out.println("AGREGAR PUBLICACIÓN"
                           + "\n-------------------\n");
            addPublicacion(solicitaPublicacion());
            break;
          case 2: 
            System.out.println("MOSTRAR PUBLICACIONES"
                           + "\n---------------------\n");
            muestraTodasLasPublicaciones();
            break;
          case 3: 
            System.out.println("BUSCAR PUBLICACIÓN POR TÍTULO"
                           + "\n-----------------------------\n");
            buscaPorTitulo();
            break;
          case 4: 
            System.out.println("BUSCAR PUBLICACIÓN POR AÑO DE PUBLICACIÓN"
                           + "\n-----------------------------------------\n");
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
      } catch (IllegalArgumentException e) {
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
  public int despliegaMenu() {
    System.out.println("GESTIÓN DE PUBLICACIONES");
    System.out.println("-----------------");
    
    System.out.println("(1) Agregar publicación");
    System.out.println("(2) Mostrar todos las publicaciones");
    System.out.println("(3) Buscar publicación por título");
    System.out.println("(4) Buscar publicación por año de publicación");
    System.out.println("(0) Salir de la aplicación");
    
    
    System.out.print("Introduzca una opción (0-4): ");
    int eleccion = Integer.parseInt(sc.nextLine());
    System.out.println();
    
    return eleccion;
  }
  
  /**
   * Método que solicita un libro por consola al usuario
   * @return El libro creado con los parámetros insertados
   * @throws IllegalArgumentException En caso de que alguno de los parámetros insertados sea incorrecto
   */
  public Publicacion solicitaPublicacion() {
    // Solicitamos el tipo de publicación a crear
    System.out.print("¿Qué tipo de publicación quiere crear, libro o revista? (l/r): ");
    String eleccion = sc.nextLine();
    
    // Si la publicación es un libro
    if (eleccion.equals("l")) {
   
      // Solicitamos los datos para generar un nuevo libro
      System.out.print("Introduzca el título del libro: ");
      String titulo = sc.nextLine();
      
      System.out.print("Introduzca el nombre del autor: ");
      String autor = sc.nextLine();

      System.out.print("Introduzca el año de publicación: ");
      int anyo = Integer.parseInt(sc.nextLine());

      return new Libro(titulo, autor, anyo);
    // Si la publicación es una revista
    } else if (eleccion.equals("r")) {
      
      // Solicitamos los datos para crear una nueva revista
      System.out.print("Introduzca el título de la revista: ");
      String titulo = sc.nextLine();
      
      System.out.print("Introduzca el número de la revista: ");
      int numero = Integer.parseInt(sc.nextLine());

      System.out.print("Introduzca el año de publicación: ");
      int anyo = Integer.parseInt(sc.nextLine());

      return new Revista(titulo, numero, anyo);
    // Si se introduce un texto que no corresponde con ninguna de nuestras opciones, lanzamos un error
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Método que añade un libro en el array de libros almacenados de la biblioteca
   * @param libro Libro a añadir
   */
  public void addPublicacion(Publicacion publicacion) {
    // Calculamos el tamaño del nuevo array y creamos el nuevo array de libros
    Publicacion[] publicacionesActualizado = new Publicacion[publicaciones.length + 1];
    
    // Copiamos libro a libro en el nuevo array
    for (int i = 0; i < publicaciones.length; i++) {
      publicacionesActualizado[i] = publicaciones[i];
    }
    // Añadimos el último elemento. No contemplamos añadir un caso libro == null porque se construye 
    // por parámetros
    publicacionesActualizado[publicaciones.length] = publicacion;
    
    // Actualizamos nuestro atributo libros
    publicaciones = publicacionesActualizado;
  }
  
  /**
   * Función que muestra por consola la información de todas las publicaciones de la biblioteca.
   * Si no hay publicaciones, informará de ello al usuario.
   */
  public void muestraTodasLasPublicaciones() {
    if (publicaciones.length == 0) {
      System.out.println("No hay ningún libro en la biblioteca.");
    } else {
      for (int i = 0; i < publicaciones.length; i++) {
        imprimePublicacion(publicaciones[i]);
      }
    }
  }
  
  /**
   * Método que busca publicaciones por título e imprime por pantalla su información, 
   * además del número de coincidencias
   * @throws IllegalArgumentException En caso de que el título sea una cadena en blanco
   */
  public void buscaPorTitulo() {
    // Número de coincidencias por título
    int coincidencias = 0;
    
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String texto = sc.nextLine();
    
    // Si el título se ha dejado en blanco
    if (texto.isBlank()) {
      
      throw new IllegalArgumentException();
    // En otro caso
    } else {
      // Buscamos las coincidencias de título
      for (int i = 0; i < publicaciones.length; i++) {
        if (publicaciones[i].getTitulo().contains(texto)) {
          imprimePublicacion(publicaciones[i]);
          coincidencias++;
        }
      }
      System.out.println("Se encontraron " + coincidencias + " coincidencias.");
    }

  }
  
  /**
   * Método que busca publicaciones por año introducido e imprime por pantalla su información
   * @throws NumberFormatException En caso de introducir un dato en formato incorrecto
   */
  public void buscaPorAnyo() {
    // Número de coincidencias por año de publicación
    int coincidencias = 0;
    
    System.out.print("Introduzca el año de publicación a buscar: ");
    int anyoPublicacion = Integer.parseInt(sc.nextLine());
    // Buscamos las coincidencias de título
    for (int i = 0; i < publicaciones.length; i++) {
      if (publicaciones[i].getAnyoPublicacion() == anyoPublicacion) {
        imprimePublicacion(publicaciones[i]);
        coincidencias++;
      }
    }
    System.out.println("Se encontraron " + coincidencias + " coincidencias.");
  }
  
  /**
   * Método privado que imprime por consola toda la información de una publicación, diferenciando de si 
   * se trata de un libro o una revista
   * @param publicacion Publicación de la cual se imprimen sus datos
   */
  private void imprimePublicacion(Publicacion publicacion) {
    // No se contempla caso de Publicacion null porque todo libro se introduce por teclado
    if (publicacion instanceof Libro libro) {
      System.out.println("LIBRO Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() 
      + ", Año Publicación: " + libro.getAnyoPublicacion());
    
    } else {
      Revista revista = (Revista) publicacion;
      System.out.println("REVISTA Título: " + revista.getTitulo() + ", Número: " + revista.getNumero() 
      + ", Año Publicación: " + revista.getAnyoPublicacion());
    }
    
  }

}
