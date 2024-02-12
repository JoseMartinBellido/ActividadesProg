package unidad06.listas.ejercicio08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Gestiona alumnos de un centro (con calificaciones)
 */
public class GestionAlumnosConCalificacionesApp {

  // Constantes
  // Opciones del menu
  // Salir
  private static final int OPCION_SALIR = 0;
  // Añadir alumno
  private static final int OPCION_ADD = 1;
  // Listar alumnos
  private static final int OPCION_LISTAR = 2;
  // Eliminar alumno
  private static final int OPCION_ELIMINAR = 3;
  // Añadir calificacion a un alumno
  private static final int OPCION_ADD_CALIFICACION = 4;
  // Ver las calificaciones de un alumno
  private static final int OPCION_LISTAR_CALIFICACIONES = 5;
  // Opciones Mínima y máxima de las váliddas
  private static final int OPCION_MINIMA = OPCION_SALIR;
  private static final int OPCION_MAXIMA = OPCION_LISTAR_CALIFICACIONES;
  
  // Atributos
  // Scanner para leer desde teclado
  private Scanner sc;
  // Lista de alumnos
  private List<Alumno> alumnos;
  
  /**
   * Constructor privado para que sólo se pueda usar desde esta clase
   */
  private GestionAlumnosConCalificacionesApp() {
    // Iniciamos el scanner
    sc = new Scanner(System.in);
    // Y la lista a lista vacía
    alumnos = new ArrayList<>();
  }
  
  /**
   * Punto de entrada de la aplicación
   * @param args Argumentos
   */
  public static void main(String[] args) {
    // Creamos un objeto de esta clase
    GestionAlumnosConCalificacionesApp app = new GestionAlumnosConCalificacionesApp();
    // Y lo ejecutamos
    app.run();
  }

  /**
   * Función principal de la aplicación
   */
  private void run() {
    // Ciclo principal hasta que se señala la salida
    int opcion = OPCION_SALIR;
    do {
      // Mostramos el menú y obtenemos la opción elegida
      opcion = mostrarMenu();
      // Según la opción elegida llamamos a un método para que la lleve a cabo
      switch (opcion) {
        case OPCION_ADD:
          addAlumno();
          break;
        case OPCION_LISTAR:
          listarAlumnos();
          break;
        case OPCION_ELIMINAR:
          eliminarAlumnos();
          break;
        case OPCION_ADD_CALIFICACION:
          addCalificacion();
          break;
        case OPCION_LISTAR_CALIFICACIONES:
          listarCalificaciones();
          break;
        case OPCION_SALIR:
          // No hace nada
          break;
        default:
          // Opción incorrecta
          System.out.println("Opción elegida incorrecta. Las opciones válidas son entre " + OPCION_MINIMA + " y " + OPCION_MAXIMA);
      }
    } while (opcion != OPCION_SALIR);
  }

  /**
   * Muestra el menú y lee desde el usuario la opción elegida
   * @return Opción elegida por el usuario. No se comprueba si el número
   * está en el rango
   */
  private int mostrarMenu() {
    // Ciclo infinito. Se sale por el return
    for (;;) {
      try {
        // Mostramos la cabecera
        System.out.println();
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("--------------");
        System.out.println("1.- Añadir alumno");
        System.out.println("2.- Listar alumnos existentes");
        System.out.println("3.- Eliminar alumno");
        System.out.println("4.- Añadir calificación a un alumno");
        System.out.println("5.- Listar calificaciones de un alumno");
        System.out.println("0.- Salir de la aplicación");
        System.out.print("Elija una opción (" + OPCION_MINIMA + "-" + OPCION_MAXIMA + "): ");
        int opcion = Integer.parseInt(sc.nextLine());
        return opcion;
      } catch (NumberFormatException e) {
        // El usuario introdujo algo que no es un número
        System.out.println("Lo introducido no es un número. Inténtelo de nuevo");
      } 
    }
  }

  /**
   * Añade un alumno a los alumnos existentes
   */
  private void addAlumno() {
    // Cabecera
    System.out.println();
    System.out.println("AÑADIR ALUMNO");
    System.out.println("-------------");
    
    // Solicitamos los datos del alumno
    System.out.print("Introduzca el DNI del alumno (9 caracteres): ");
    String dni = sc.nextLine();
    System.out.print("Introduzca el nombre del alumno (no puede dejarse en blanco): ");
    String nombre = sc.nextLine();
    System.out.print("Introduzca la edad del alumno (debe ser mayor o igual a cero): ");
    try {
      int edad = Integer.parseInt(sc.nextLine());
      // Buscamos a un alumno con el dni proporcionado (si es -1 no se encontró)
      if (buscarAlumnoPorDni(dni) == -1) {
        // Creamos al alumno
        Alumno alumno = new Alumno(dni, nombre, edad);
        // Y lo inserta en la lista
        alumnos.add(alumno);
        System.out.println("Alumno añadido con éxito");
      } else {
        // Ya existe un alumno con el DNI proporcionado
        // No se añade y se muestra un error
        System.out.println("Error. Ya existe un alumno con el DNI proporcionado");
      }
    } catch (NumberFormatException e) {
      // El número introducido no es un número
      System.out.println("Error. La edad introducida no es un número válido");
    } catch (IllegalArgumentException e) {
      // Error creando el alumno. Alguno de los parámetros no es válido
      System.out.println("Error. Alguno de los datos proporcionados no es válido");
    }
  }

  /**
   * Lista los alumnos
   */
  private void listarAlumnos() {
    // Cabecera
    System.out.println();
    System.out.println("LISTAR ALUMNOS");
    System.out.println("--------------");
    
    // Si hay algún alumno
    if (!alumnos.isEmpty()) {
      // Para cada elemento
      for (Alumno alumno: alumnos) {
        // Obtiene la cadena y lo imprime
        String datosAlumno = alumno.aCadena();
        System.out.println(datosAlumno);
      }
    } else {
      // No hay alumnos
      System.out.println("No hay alumnos registrados aún");
    }
  }

  /**
   * Elimina un alumno a partir de su DNI
   */
  private void eliminarAlumnos() {
    // Cabecera
    System.out.println();
    System.out.println("ELIMINAR ALUMNO");
    System.out.println("---------------");
    
    // Solicitamos el DNI del alumno
    System.out.print("Introduzca el DNI del alumno a eliminar: ");
    String dni = sc.nextLine();
    // Obtenemos la posición del alumno en la lista (si es que está)
    int posicion = buscarAlumnoPorDni(dni);
    // Si se encontró se elimina
    if (posicion >= 0) {
      alumnos.remove(posicion);
      System.out.println("Alumno eliminado con éxito");
    } else {
      // Si no se encuentra mostramos un mensaje de error
      System.out.println("Alumno no encontrado");
    }
  }

  /**
   * Añade una calificación a un alumno
   */
  private void addCalificacion() {
    try {
      // Cabecera
      System.out.println();
      System.out.println("AÑADIR CALIFICACIÓN A UN ALUMNO");
      System.out.println("-------------------------------");
      
      // Solicitamos el DNI del alumno
      System.out.print("Introduzca el DNI del alumno al que se quiere añadir una calificación: ");
      String dni = sc.nextLine();
      // Y la calificación
      System.out.print("Introduzca ahora la calificación a añadir: ");
      double calificacion = Double.parseDouble(sc.nextLine());
      // Buscamos al alumno en la lista
      int posicion = buscarAlumnoPorDni(dni);
      // Si se encontró
      if (posicion >= 0) {
        // Añadimos la calificación al alumno
        alumnos.get(posicion).addCalificacion(calificacion);
        System.out.println("Calificación añadida con éxito");
      } else {
        // Si no se encontró el alumno
        // Mostramos error
        System.out.println("Error. No se encuentra ningún alumno con el DNI proporcionado");
      }
    } catch (NumberFormatException e) {
      // Lo leido desde teclado no es un real válido
      System.out.println("Error. Lo introducido no es una número válido");
    } catch (IllegalArgumentException e) {
      System.out.println("Error. La calificación no es correcta. Debe ser un número real entre 0 y 10");
    }
  }

  /**
   * Lista las calificaciones de un alumno a partir de su DNI
   */
  private void listarCalificaciones() {
    // Cabecera
    System.out.println();
    System.out.println("LISTAR CALIFICACIONES DE UN ALUMNO");
    System.out.println("----------------------------------");
    
    // Solicitamos el DNI del alumno
    System.out.print("Introduzca el DNI del alumno del que se quiere listar las calificaciones: ");
    String dni = sc.nextLine();
    // Buscamos al alumno en la lista
    int posicion = buscarAlumnoPorDni(dni);
    // Si se encontró
    if (posicion >= 0) {
      // Obtenemos las calificaciones del alumno
      List<Double> calificaciones = alumnos.get(posicion).getCalificaciones();
      // Si la lista no está vacía
      if (calificaciones.size() > 0) {
        // Mostramos una entradilla y las calificaciones
        System.out.println("La calificaciones del alumno son:");
        for (double calificacion: calificaciones) {
          System.out.println(calificacion);
        }
      } else {
        // El alumno no tiene calificaciones
        System.out.println("El alumno no tiene calificaciones");
      }
    } else {
      // Si no se encontró el alumno
      // Mostramos error
      System.out.println("Error. No se encuentra ningún alumno con el DNI proporcionado");
    }
  }

  /**
   * Busca a un alumno en la lista por su DNI
   * @param dni DNI del alumno a buscar. Si es null se devuelve null
   * @return Posición en la lista del alumno con el DNI proporcionado, si se
   *   encuentra. -1 si no se encuentra
   */
  private int buscarAlumnoPorDni(String dni) {
    // Si el dni no es null
    if (dni != null) {
      // Para cada elemento de la lista
      for (int i = 0; i < alumnos.size(); i++) {
        // Si es el alumno buscado
        Alumno alumno = alumnos.get(i);
        if (alumno.getDni().equals(dni)) {
          // Devuelve la posición y terminamos
          return i;
        }
      }
    }
    // Si se llega al final del ciclo o dni era null se devuelve -1
    return -1;
  }
}
