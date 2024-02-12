package sol.unidad06.arraysobjetos.ejercicio04;

import java.util.Scanner;


/**
 * Gestiona personas (profesores y alumnos) de un centro
 */
public class GestionaCentroApp {

  // Opciones del menu
  // Opción de salir de la aplicación
  private static final int OPCION_SALIR = 0;
  // Agregar un persona
  private static final int OPCION_AGREGAR_PERSONA = 1;
  // Mostrar todos las personas
  private static final int OPCION_MOSTRAR_PERSONAS = 2;
  // Eliminar persona
  private static final int OPCION_ELIMINAR_PERSONA = 3;
  // Buscar por nombre
  private static final int OPCION_BUSCAR_POR_NOMBRE = 4;
  // Buscar por DNI
  private static final int OPCION_BUSCAR_POR_DNI = 5;
  // Rango válido de opciones
  private static final int OPCION_MINIMO = OPCION_SALIR;
  private static final int OPCION_MAXIMO = OPCION_BUSCAR_POR_DNI;
  
  // Array con las personas
  private Persona[] personas;
  // Scanner para leer desde teclado
  private Scanner sc;
  
  public static void main(String[] args) {
    // Crea una instancia de la clase
    GestionaCentroApp app = new GestionaCentroApp();
    // Inicia los atributos
    app.personas = new Persona[0];
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
        case OPCION_AGREGAR_PERSONA:
          agregarPersona();
          break;
        case OPCION_MOSTRAR_PERSONAS:
          mostrarPersonas();
          break;
        case OPCION_ELIMINAR_PERSONA:
          eliminarPersona();
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
    System.out.println("GESTIÓN DE CENTRO");
    System.out.println("-----------------");
    System.out.println("(1) Agregar persona");
    System.out.println("(2) Mostrar todos las personas");
    System.out.println("(3) Eliminar persona");
    System.out.println("(4) Buscar persona por nombre");
    System.out.println("(5) Buscar persona por DNI");
    System.out.println("(0) Salir de la aplicación");
    System.out.print("Introduzca una opción (0-5): ");
  }

  /**
   * Agrega una persona tras solicitar sus datos
   */
  private void agregarPersona() {
    // Cabecera
    System.out.println();
    System.out.println("AGREGAR PERSONA");
    System.out.println("---------------");
    
    try {
      // Solicita el tipo de persona
      System.out.print("¿Qué tipo de persona quieres añadir (p=profesor/e=estudiante)?: ");
      char tipo = sc.nextLine().toLowerCase().charAt(0);
      // Solicita datos comunes de la persona
      System.out.print("Introduzca el DNI de la persona (8 números y una letra mayúscula, sin espacios): ");
      String dni = sc.nextLine();
      System.out.print("Introduzca el nombre de la persona (entre 1 y 100 caracteres): ");
      String nombre = sc.nextLine();
      Persona persona;
      // Si es un profesor
      if (tipo == 'p') {
        // Solicita la materia
        System.out.print("Introduca la materia que imparte el profesor (no puede estar vacío): ");
        String materia = sc.nextLine();
        // Crea la persona
        persona = new Profesor(dni, nombre, materia);
      } else if (tipo == 'e') {
        // Si es estudiante, pedimos el curso
        System.out.print("Introduca el curso en el que está el alumno (primero/segundo/master): ");
        String curso = sc.nextLine();
        // Crea la persona
        persona = new Estudiante(dni, nombre, curso);
      } else {
        // Tipo incorrecto
        System.out.println("Error. Tipo elegido incorrecto");
        return;
      }
      // Intenta localizar a la persomna en el array
      int posicion = localizarPersonaPorDni(dni);
      // Si no existe 
      if (posicion < 0) {
        // Amplia el array
        ampliaArrayPersonas();
        // Y almacena la persona
        personas[personas.length - 1] = persona;
      } else {
        // Error
        System.out.println("No puede añadirse la persona porque ya hay otra con el mismo DNI");
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Error. Algunos de los datos de la persona no son correctos");
    }
  }

  /**
   * Ampliamos el array personas para que tenga un elemento mas
   */
  private void ampliaArrayPersonas() {
    // Crea un array alternativo con un elemento mas
    Persona[] nuevo = new Persona[personas.length + 1];
    // Copia los elementos del array antiguo al nuevo
    for (int i = 0; i < personas.length; i++) {
      nuevo[i] = personas[i];
    }
    // Por último guarda el nuevo array en el atributo
    personas = nuevo;
  }

  /**
   * Muestra las personas
   */
  private void mostrarPersonas() {
    // Cabecera
    System.out.println();
    System.out.println("MOSTRAR PERSONAS");
    System.out.println("----------------");
    
    // Para cada personna
    for (Persona persona: personas) {
      // Imprime la representación textual de la persona
      System.out.println(persona.obtenerCadena());
    }
  }

  /**
   * Elimina una persona por dni
   */
  private void eliminarPersona() {
    // Cabecera
    System.out.println();
    System.out.println("ELIMINAR PERSONA");
    System.out.println("----------------");
    
    // Solicita el DNI
    System.out.print("Introduzca el DNI de la persona a eliminar (8 números y una letra mayúscula): ");
    String dni = sc.nextLine();
    // Localiza a la persona
    int posicion = localizarPersonaPorDni(dni);
    // Si se encontró
    if (posicion >= 0) {
      // Lo elimina
      eliminaPersonaEnPosicion(posicion);
      // Y muestra un mensaje
      System.out.println("Persona eliminada");
    } else {
      // Mensaje de error
      System.out.println("No se localiza a la persona con el DNI \"" + dni + "\"");
    }
  }

  /**
   * Busca personas por parte del nombre
   */
  private void buscarPorNombre() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR PERSONA POR NOMBRE");
    System.out.println("-------------------------");
    
    // Solicita el texto de búsqueda
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String textoBusqueda = sc.nextLine();
    // Si no está vacío
    if (!textoBusqueda.isBlank()) {
      // Para cada persona
      // Contador de resultados
      int resultados = 0;
      for (Persona persona: personas) {
        // Si el nombre contiene el texto de búsqueda
        if (persona.getNombre().contains(textoBusqueda)) {
          // Muestra el contenido del estudiante
          System.out.println(persona.obtenerCadena());
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
   * Busca personas por DNI
   */
  private void buscarPorDni() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR PERSONA POR DNI");
    System.out.println("----------------------");
    
    // Solicita el DNI
    System.out.print("Introduzca el DNI de la persona a buscar (8 números y una letra mayúscula): ");
    String dni = sc.nextLine();
    // Localiza a la persona
    int posicion = localizarPersonaPorDni(dni);
    // Si se encontró
    if (posicion >= 0) {
      // Lo muestra
      System.out.println(personas[posicion].obtenerCadena());
    } else {
      // Mensaje de error
      System.out.println("No se localiza a la persona con el DNI \"" + dni + "\"");
    }
  }

  /**
   * Localiza la posición de una persona a partir de su DNI
   * @param dni DNI de la persona a localizar
   * @return Posición de la persona con el DNI proporcionado o -1 si no se
   *   localiza una persona con el DNI proporcionado
   */
  private int localizarPersonaPorDni(String dni) {
    // Para cada persona
    for (int i = 0; i < personas.length; i++) {
      // Si la persona en la posición actual tiene el DNI buscado
      if (personas[i].getDni().equals(dni)) {
        // Devuelve la posición
        return i;
      }
    }
    // Si terminamos el ciclo es que no lo hemos encontrado
    // Devolvemos -1
    return -1;
  }

  /**
   * Elimina la persona en la posición indicada
   * @param posicion Posición dentro del array de la persona a eliminar
   */
  private void eliminaPersonaEnPosicion(int posicion) {
    // Crea un nuevo array con una entrada menos
    Persona[] nuevo = new Persona[personas.length - 1];
    // Para cada entrada del array nuevo
    for (int i = 0; i < nuevo.length; i++) {
      // La entrada valdrá la equivalente al antiguo, si la posición es anterior a la
      // posición a eliminar o la equivalente al antiguo + 1 si la posición es superior o igual
      nuevo[i] = personas[i + ((i >= posicion) ? 1 : 0)];
    }
    // Sustituimos el array antiguo por el nuevo
    personas = nuevo;
  }

}
