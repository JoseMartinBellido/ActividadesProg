package prog.unidad06.listas.ejercicio08;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionAlumnosConCalificacionesApp {

  private static final int ELECCION_ADD = 1;
  private static final int ELECCION_LISTAR = 2;
  private static final int ELECCION_ELIMINAR = 3;
  private static final int ELECCION_ADD_CALIFICACION = 4;
  private static final int ELECCION_LISTAR_CALIFICACIONES = 5;
  
  private static final int ELECCION_SALIR = 0;
  
  
  // Scanner como atributo
  private Scanner sc;
  
  // Lista que almacene a los alumnos
  private List<Alumno> listaAlumnos = new LinkedList<>();
  
  /**
   * Constructor de la clase que toma por parámetro el Scanner
   * @param sc Scanner para recoger datos del usuario
   */
  public GestionAlumnosConCalificacionesApp(Scanner sc) {
    this.sc = sc;
  }
  
  /**
   * Método main de la clase
   * @param args Argumentos de la clase
   */
  public static void main(String[] args) {
    GestionAlumnosConCalificacionesApp miApp = new GestionAlumnosConCalificacionesApp(new Scanner(System.in));
    miApp.run();
  }
  
  /**
   * Método run de la clase
   */
  public void run() {
    // Elección tomada por el usuario
    int eleccion = -1;
    
    // Desplegamos el menú tantas veces como sea necesario
    do {
      // Comprobamos todas las opciones de inserción de datos
      try{
        eleccion = imprimeMenu();
        System.out.println();
        // Solo operamos si la elección no es salir
        if (eleccion != ELECCION_SALIR) {
          switch (eleccion) {
            case ELECCION_ADD:
              addAlumno();
              break;
            case ELECCION_LISTAR:
              listarAlumnos();
              break;
            case ELECCION_ELIMINAR:
              eliminarAlumno();
              break;
            case ELECCION_ADD_CALIFICACION: 
              addCalificacion();
              break;
            case ELECCION_LISTAR_CALIFICACIONES: 
              listarCalificacionesAlumno();
              break;
            default:
              System.out.println("Opción elegida incorrecta. Las opciones válidas son entre 0 y 3");
          }

        }

      } catch (NumberFormatException e) {
        System.out.println("Lo introducido no es un número. Inténtelo de nuevo.");
      }
      
      System.out.println();
      
    } while (eleccion != ELECCION_SALIR);
    
    System.out.println("Saliendo del programa...");
  }

  /**
   * Método que imprime el menú por consola para que interactúe el usuario
   */
  private int imprimeMenu() {
    System.out.println("MENÚ PRINCIPAL");
    System.out.println("--------------");
    
    System.out.println("1.- Añadir alumno");
    System.out.println("2.- Listar alumnos existentes");
    System.out.println("3.- Eliminar alumno");
    System.out.println("4.- Añadir calificación a un alumno");
    System.out.println("5.- Listar calificaciones de un alumno");
    
    System.out.println("0.- Salir de la aplicación");
    
    System.out.print("Elija una opción (0-3): ");
    int eleccion = Integer.parseInt(sc.nextLine());
    return eleccion;
  }
  
  /**
   * Método que añade un alumno a la lista. No se añadirá si se encuentra ya en la lista, o si su dni está repetido
   */
  private void addAlumno() {
    
    System.out.println("AÑADIR ALUMNO");
    System.out.println("-------------");
    
    // Solicitamos los datos del alumno
    System.out.print("Introduzca el DNI del alumno (9 caracteres): ");
    String dni = sc.nextLine();
    
    System.out.print("Introduzca el nombre del alumno (no puede dejarse en blanco): ");
    String nombre = sc.nextLine();
    
    // A partir de aquí se inserta en un try-catch de IllegalArgumentException por si hubiese algún dato erróneo
    try {
      System.out.print("Introduzca la edad del alumno (debe ser mayor o igual a cero): ");
      int edad = Integer.parseInt(sc.nextLine());
      
      Alumno alumno = new Alumno(dni, nombre, edad);
      
      // Insertamos el alumno en la lista. Para ello, comprobamos si no hay ningún alumno con el mismo dni
      boolean noRepetido = true;
      for (int i = 0; i < listaAlumnos.size(); i++) {
        if (listaAlumnos.get(i).getDni().equals(dni)) {
          noRepetido = false;
        }
      }
      if (noRepetido) {
        listaAlumnos.add(alumno);
        System.out.println("Alumno añadido con éxito");
      } else {
        System.out.println("No puede añadirse un Alumno con el mismo dni que otro ya existente");
      }

      
    } catch (IllegalArgumentException e) {
      System.out.println("Error. Alguno de los datos proporcionados no es válido.");
    }
  }

  /**
   * Método que lista los alumnos por consola. Imprimirá un mensaje de aviso al usuario si la lista está vacía
   */
  private void listarAlumnos() {
    
    System.out.println("LISTAR ALUMNOS");
    System.out.println("--------------");
    
    // Recorremos la lista de alumnos si no está vacía
    if (!listaAlumnos.isEmpty()) {
      for (Alumno alumno : listaAlumnos) {
        System.out.println(alumno.aCadena());
      }
      System.out.println();
    // Si no hay alumnos, se alerta al usuario
    } else {
      System.out.println("La lista de alumno se encuentra vacía. Inserte elementos para poder listarlos.");
    }
    
  }
  
  /**
   * Método que elimina un alumno concreto dado su dni
   * @param dni Dni del alumno a eliminar de la lista
   * @return El elemento que con el dni especificado que se acaba de sacar de la lista, o null en caso de no encontrarse
   */
  private Alumno eliminarAlumno() {
    
    System.out.println("ELIMINAR ALUMNO");
    System.out.println("---------------");
    
    // Solicitamos el dni para buscar
    System.out.print("Introduzca el DNI del alumno a eliminar: ");
    String dni = sc.nextLine();
    
    // Buscamos el alumno con el dni introducido. Si se encuentra, se elimina
    for (int i = 0; i < listaAlumnos.size(); i++) {
      if (listaAlumnos.get(i).getDni().equals(dni)) {
        System.out.println("Alumno eliminado con éxito");

        return listaAlumnos.remove(i);
      }
    }
    // Llegados aquí, no se ha encontrado
    System.out.println("Alumno no encontrado");
    return null;
  }
  
  /**
   * Método que añade una nueva calificación a un alumno, solicitando por consola el dni del mismo y la calificación añadir
   */
  private void addCalificacion() {
    System.out.println("AÑADIR CALIFICACIÓN DE UN ALUMNO");
    System.out.println("--------------------------------");
  
    // Solicitamos los datos
    System.out.print("Introduzca el DNI del alumno al que se le quiere añadir una calificación: ");
    String dni = sc.nextLine();
    
    try {
      System.out.print("Introduzca ahora la calificación a añadir: ");
      double calificacion = Double.parseDouble(sc.nextLine());
      
      //Booleano para saber si se ha encontrado el elemento y su modificación directa
      boolean encontrado = false;
      
      for (int i = 0; i < listaAlumnos.size(); i++) {
        if (listaAlumnos.get(i).getDni().equals(dni)) {
          listaAlumnos.get(i).addCalificacion(calificacion);
          System.out.println("Calificación añadida con éxito.");
          encontrado = true;
          break;
        }
      }

      // Si no se ha encontrado, se avisa al usuario
      if (!encontrado) {
        System.out.println("No se pudo encontrar al alumno. Inténtelo de nuevo introduciendo otro dni.");
      }
    // Si alguno de los parámetros no cumple las condiciones, se recoge el error  
    } catch (IllegalArgumentException e) {
      System.out.println("Alguno de los datos introducidos no es correcto. Inténtelo de nuevo.");
    }

  }
  
  /**
   * Método que lista las calificaciones de un alumno, dado un dni insertado por consola 
   */
  public void listarCalificacionesAlumno() {
    System.out.println("LISTAR CALIFICACIONES DE UN ALUMNO");
    System.out.println("----------------------------------");
  
    // Solicitamos el dni 
    System.out.print("Introduzca el DNI del alumno del que se quiere listar las calificaciones: ");
    String dni = sc.nextLine();
    
    boolean encontrado = false;
    
    // Si se encuentra al alumno con dni coincidente
    for (Alumno alumno : listaAlumnos) {
      if (alumno.getDni().equals(dni)) {
        encontrado = true;
        // Imprimimos las calificaciones. Las obtenemos de alumno.
        System.out.println("Las calificaciones del alumno son: ");
        List<Double> calificaciones = alumno.getCalificaciones();
        // Recorremos la lista de calificaciones para imprimirlas
        for (double calificacion : calificaciones) {
          System.out.println(calificacion);
        }
      }
      break;
    }
    // Si no se ha encontrado, se avisa al usuario
    if (!encontrado) {
      System.out.println("No se pudo encontrar al alumno. Inténtelo de nuevo insertando otro DNI.");
    }
  
  }

}
