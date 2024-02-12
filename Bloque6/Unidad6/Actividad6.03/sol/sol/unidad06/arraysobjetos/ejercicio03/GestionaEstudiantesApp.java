package sol.unidad06.arraysobjetos.ejercicio03;

import java.util.Scanner;


/**
 * Gestiona estudiantes de un centro
 */
public class GestionaEstudiantesApp {

  // Opciones del menu
  // Opción de salir de la aplicación
  private static final int OPCION_SALIR = 0;
  // Agregar un estudiante
  private static final int OPCION_AGREGAR_ESTUDIANTE = 1;
  // Mostrar todos los estudiantes
  private static final int OPCION_MOSTRAR_ESTUDIANTES = 2;
  // Eliminar estudiante
  private static final int OPCION_ELIMINAR_ESTUDIANTE = 3;
  // Buscar por nombre
  private static final int OPCION_BUSCAR_POR_NOMBRE = 4;
  // Buscar por DNI
  private static final int OPCION_BUSCAR_POR_DNI = 5;
  // Rango válido de opciones
  private static final int OPCION_MINIMO = OPCION_SALIR;
  private static final int OPCION_MAXIMO = OPCION_BUSCAR_POR_DNI;
  
  // Array con los estudiantes
  private Estudiante[] estudiantes;
  // Scanner para leer desde teclado
  private Scanner sc;
  
  public static void main(String[] args) {
    // Crea una instancia de la clase
    GestionaEstudiantesApp app = new GestionaEstudiantesApp();
    // Inicia los atributos
    app.estudiantes = new Estudiante[0];
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
        case OPCION_AGREGAR_ESTUDIANTE:
          agregarEstudiante();
          break;
        case OPCION_MOSTRAR_ESTUDIANTES:
          mostrarEstudiantes();
          break;
        case OPCION_ELIMINAR_ESTUDIANTE:
          eliminarEstudiante();
          break;
        case OPCION_BUSCAR_POR_NOMBRE:
          buscarPorNombre();
          break;
        case OPCION_BUSCAR_POR_DNI:
          buscarPorDni();
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
    System.out.println("GESTIÓN DE ESTUDIANTES");
    System.out.println("----------------------");
    System.out.println("(1) Agregar estudiante");
    System.out.println("(2) Mostrar todos los estudiantes");
    System.out.println("(3) Eliminar estudiante");
    System.out.println("(4) Buscar estudiante por nombre");
    System.out.println("(5) Buscar estudiante por DNI");
    System.out.println("(0) Salir de la aplicación");
    System.out.print("Introduzca una opción (0-5): ");
  }

  /**
   * Agrega un estudiante tras solicitar sus datos
   */
  private void agregarEstudiante() {
    // Cabecera
    System.out.println();
    System.out.println("AGREGAR ESTUDIANTE");
    System.out.println("------------------");
    
    try {
      // Solicita datos de la persona
      System.out.print("Introduzca el DNI del estudiante (8 números y una letra mayúscula, sin espacios): ");
      String dni = sc.nextLine();
      System.out.print("Introduzca el nombre del estudiante (entre 1 y 100 caracteres): ");
      String nombre = sc.nextLine();
      System.out.print("Introduzca el curso al que pertenece el estudiante (primero/segundo/master): ");
      String curso = sc.nextLine();
      // Intenta localizar al estudiante en el array
      int posicion = localizarEstudiantePorDni(dni);
      // Si no existe 
      if (posicion < 0) {
        // Crea el estudiante
        Estudiante estudiante = new Estudiante(dni, nombre, curso);
        // Amplia el array
        ampliaArrayEstudiantes();
        // Y almacena el estudiante
        estudiantes[estudiantes.length - 1] = estudiante;
      } else {
        // Error
        System.out.println("No puede añadirse el estudiante porque ya hay otro con el mismo DNI");
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Error. Algunos de los datos del estudiante no son correctos");
    }
    
  }

  /**
   * Ampliamos el array estudiantes para que tenga un elemento mas
   */
  private void ampliaArrayEstudiantes() {
    // Crea un array alternativo con un elemento mas
    Estudiante[] nuevo = new Estudiante[estudiantes.length + 1];
    // Copia los elementos del array antiguo al nuevo
    for (int i = 0; i < estudiantes.length; i++) {
      nuevo[i] = estudiantes[i];
    }
    // Por último guarda el nuevo array en el atributo
    estudiantes = nuevo;
  }

  /**
   * Muestra los estudiantes
   */
  private void mostrarEstudiantes() {
    // Cabecera
    System.out.println();
    System.out.println("MOSTRAR ESTUDIANTES");
    System.out.println("-------------------");
    
    // Para cada estudiante
    for (Estudiante estudiante: estudiantes) {
      // Imprime la representación textual del estudiante
      System.out.println(estudiante.obtenerCadena());
    }
  }

  /**
   * Elimina un estudiante por dni
   */
  private void eliminarEstudiante() {
    // Cabecera
    System.out.println();
    System.out.println("ELIMINAR ESTUDIANTE");
    System.out.println("-------------------");
    
    // Solicita el DNI
    System.out.print("Introduzca el DNI del estudiante a eliminar (8 números y una letra mayúscula): ");
    String dni = sc.nextLine();
    // Localiza al estudiante
    int posicion = localizarEstudiantePorDni(dni);
    // Si se encontró
    if (posicion >= 0) {
      // Lo elimina
      eliminaEstudianteEnPosicion(posicion);
      // Y muestra un mensaje
      System.out.println("Estudiante eliminado");
    } else {
      // Mensaje de error
      System.out.println("No se localiza al estudiante con el DNI \"" + dni + "\"");
    }
  }

  /**
   * Busca alumnos por parte del nombre
   */
  private void buscarPorNombre() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR ALUMNO POR NOMBRE");
    System.out.println("------------------------");
    
    // Solicita el texto de búsqueda
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String textoBusqueda = sc.nextLine();
    // Si no está vacío
    if (!textoBusqueda.isBlank()) {
      // Para cada alumno
      // Contador de resultados
      int resultados = 0;
      for (Estudiante estudiante: estudiantes) {
        // Si el nombre contiene el texto de búsqueda
        if (estudiante.getNombre().contains(textoBusqueda)) {
          // Muestra el contenido del estudiante
          System.out.println(estudiante.obtenerCadena());
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
   * Busca estudiantes por DNI
   */
  private void buscarPorDni() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR ESTUDIANTE POR DNI");
    System.out.println("-------------------------");
    
    // Solicita el DNI
    System.out.print("Introduzca el DNI del estudiante a buscar (8 números y una letra mayúscula): ");
    String dni = sc.nextLine();
    // Localiza al estudiante
    int posicion = localizarEstudiantePorDni(dni);
    // Si se encontró
    if (posicion >= 0) {
      // Lo muestra
      System.out.println(estudiantes[posicion].obtenerCadena());
    } else {
      // Mensaje de error
      System.out.println("No se localiza al estudiante con el DNI \"" + dni + "\"");
    }
  }

  /**
   * Localiza la posición de un estudiante a partir de su DNI
   * @param dni DNI del estudiante a localizar
   * @return Posición del estudiante con el DNI proporcionado o -1 si no se
   *   localiza un estudiante con el DNI proporcionado
   */
  private int localizarEstudiantePorDni(String dni) {
    // Para cada estudiante
    for (int i = 0; i < estudiantes.length; i++) {
      // Si el estudiante en la posición actual tiene el DNI buscado
      if (estudiantes[i].getDni().equals(dni)) {
        // Devuelve la posición
        return i;
      }
    }
    // Si terminamos el ciclo es que no lo hemos encontrado
    // Devolvemos -1
    return -1;
  }

  /**
   * Elimina el estudiante en la posición indicada
   * @param posicion Posición dentro del array del estudiante a eliminar
   */
  private void eliminaEstudianteEnPosicion(int posicion) {
    // Crea un nuevo array con una entrada menos
    Estudiante[] nuevo = new Estudiante[estudiantes.length - 1];
    // Para cada entrada del array nuevo
    for (int i = 0; i < nuevo.length; i++) {
      // La entrada valdrá la equivalente al antiguo, si la posición es anterior a la
      // posición a eliminar o la equivalente al antiguo + 1 si la posición es superior o igual
      nuevo[i] = estudiantes[i + ((i >= posicion) ? 1 : 0)];
    }
    // Sustituimos el array antiguo por el nuevo
    estudiantes = nuevo;
  }

}
