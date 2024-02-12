package prog.unidad06.arraysobjetos.ejercicio04;

import java.util.Scanner;


public class GestionaCentroApp {

  /**
   * Atributo Scanner implementado para la inserción de datos
   */
  Scanner sc;
  
  /**
   * Atributo personas, compuesto por un array de objetos de la clase Persona (y subclases), sin repetir el dni
   */
  Persona[] personas;
  
  /**
   * Constructor de la clase
   * @param sc Scanner para la inserción de datos
   */
  public GestionaCentroApp(Scanner sc) {
    this.sc = sc;
    personas = new Persona[0];
  }
  
  /**
   * Método main de la clase
   * @param args Argumentos de la función main
   */
  public static void main(String[] args) {
    GestionaCentroApp miApp = new GestionaCentroApp(new Scanner(System.in));
    miApp.run();
  }

  /**
   * Método run de la aplicación
   */
  public void run() {
    // Declaramos la variable elección, que dependerá del usuario. Repetimos el bucle hasta insertar 0
    int eleccion = -1;
    do {
      try {
        // Desplegamos el menú, y si la elección es una opción correcta, se ejecuta según la opción deseada
        eleccion = despliegaMenu();
        if (eleccion >= 0 && eleccion <= 5) {
          switch (eleccion) {
          case 1: 
            addPersona();
            break;
          case 2: 
            muestraTodasLasPersonas();
            break;
          case 3: 
            eliminaPersona();
            break;
          case 4:
            buscaPorNombre();
            break;
          case 5: 
            buscaPorDNI();
            break;
          default:
            System.out.println("Saliendo de la aplicación...");
          }
          
        // Si la opción no es un número válido  
        } else {
          System.out.println("La opción elegida no es válida. Inténtelo de nuevo");
        }
      // Error por opción en formato incorrecto  
      } catch (NumberFormatException e) {
        System.out.println("La opción elegida no es válida. Inténtelo de nuevo");
      // Error por intento de creación de estudiante con parámetros erróneos
      } catch (IllegalArgumentException e) {
        System.out.println("Alguno de los parámetros introducidos para el estudiante es erróneo. "
            + "Inténtelo de nuevo.");
      }
      
      
    } while (eleccion != 0);
  }
  
  /**
   * Menú que despliega el menú por consola y solicita al usuario una acción
   * @return Un número entre el 0 y el 5, siendo cada uno de ellos una opción elegida distinta (1: Agregar
   * estudiante, 2: Listar estudiantes, 3: Eliminar estudiante, 4: Buscar estudiante por nombre, 
   * 5: Buscar estudiante por DNI y 0: salir de la aplicación
   * @throws NumberFormatException En caso de que el dato no tenga un formato válido
   */
   private int despliegaMenu() {
    System.out.println("GESTIÓN DE CENTRO");
    System.out.println("----------------------");
    
    System.out.println("(1) Agregar persona");
    System.out.println("(2) Mostrar todas las personas");
    System.out.println("(3) Eliminar persona");
    System.out.println("(4) Buscar persona por nombre");
    System.out.println("(5) Buscar persona por DNI");
    System.out.println("(0) Salir de la aplicación");
    
    
    System.out.print("Introduzca una opción (0-5): ");
    int eleccion = Integer.parseInt(sc.nextLine());
    System.out.println();
    
    return eleccion;
  }
  
  /**
   * Método que agrega una persona al conjunto ya definido mediante los parámetros insertados por consola.
   * Incluirá el estudiante si estos parámetros son válidos y, además, no existe ninguna
   * persona ya guardada con el mismo dni
   */
  private void addPersona() {
    System.out.println("AGREGAR PERSONA");
    System.out.println("------------------");

    // Solicitamos el tipo de persona a añadir
    System.out.print("Qué tipo de persona quiere añadir? (p = profesor / e = estudiante):");
    String eleccion = sc.nextLine();
    
    //
    if (eleccion.equals("p") || eleccion.equals("e")) {
   // Solicitamos los datos de la persona
      System.out.print("Introduzca el DNI de la persona (8 números y una letra mayúscula, sin espacios): ");
      String dni = sc.nextLine();
      
      System.out.print("Introduzca el nombre del estudiante (entre 1 y 100 caracteres): ");
      String nombre = sc.nextLine();
      
      // Creamos la variable persona y, dependiendo del tipo, será estudiante o profesor
      Persona persona = null;
      
      try {
        if (eleccion.equals("p")) {
          // Solicitamos la materia
          System.out.print("Introduzca la materia que imparte el profesor (no puede estar vacío): ");
          String materia = sc.nextLine();

          // Creamos al profesor
          persona = new Profesor(dni, nombre, materia);
          
        } else {
          System.out.print("Introduzca el curso al que pertenece el estudiante (primero/segundo/master): ");
          String curso = sc.nextLine();

          // Creamos el estudiante
          persona = new Estudiante(dni, nombre, curso);
        }

        // Si la persona es correcta, comprobamos que no esté incluido en el array
        boolean incluido = false;
        for (int i = 0; i < personas.length; i++) {
          if (personas[i].getDni().equals(dni)) {
            incluido = true;
            break;
          }
        }
        // Si está ya incluido, avisamos al usuario
        if (incluido) {
          System.out.println("No puede añadirse la persona porque ya hay otra con el mismo DNI.");

          // En caso contrario, ampliamos el array e introducimos el nuevo estudiante
        } else {

          Persona[] personasActualizado = new Persona[personas.length + 1];
          for (int i = 0; i < personas.length; i++) {
            personasActualizado[i] = personas[i];
          }
          personasActualizado[personas.length] = persona;

          // Actualizamos el array antiguo de estudiantes
          personas = personasActualizado;

        }
      } catch (IllegalArgumentException e) {
        System.out.println("Alguno de los datos de la persona es erróneo. Por favor, inténtelo de nuevo.");
      }
    }
    
  }
  
  /**
   * Método que imprime todos los datos de las personas del grupo
   */
  private void muestraTodasLasPersonas() {
    System.out.println("MOSTRAR PERSONAS");
    System.out.println("-------------------");
    
    if (personas.length == 0) {
      System.out.println("No hay estudiantes en el grupo.");
    } else {
      for (Persona persona : personas) {
        imprimePersona(persona);
      }
    }
  }
  
  private void eliminaPersona() {
    System.out.println("ELIMINAR PERSONA");
    System.out.println("-------------------");
   
    // Solicitamos el dni de la persona a eliminar
    System.out.print("Introduzca el DNI de la persona a eliminar (8 números y 1 letra mayúscula, "
        + "sin espacios): ");
    String dni = sc.nextLine();
    
    // Buscamos el dni en el array. Por definición, no habrá repetidos    
    boolean encontrado = false;
    for (Persona persona : personas) {
      // Si lo encontramos, paramos. En caso contrario, avisamos al usuario
      if (persona.getDni().equals(dni)) {
        encontrado = true;
      }
    }
    if (!encontrado) {
      System.out.println("No se encontró a la persona en el grupo.");
    } else {
      // Si lo hemos encontrado, creamos un nuevo array de personas y almacenamos la lista actualizada
      Persona[] personasActualizado = new Persona[personas.length - 1];
      int indice = 0;
      
      for (Persona persona : personas) {
        if (!persona.getDni().equals(dni)) {
          personasActualizado[indice] = persona;
          indice++;
        }
      }
      
      // Modificamos el array original
      personas = personasActualizado;
    }
  }
  
  /**
   * Método que busca por nombre. Avisa al usuario si no encuentra coincidencias, y si encuentra alguna persona
   * cuyo nombre contenga el texto aportado, imprime sus datos, junto con el número de coincidencias encontradas
   */
  private void buscaPorNombre() {
    System.out.println("BUSCAR PERSONA POR NOMBRE");
    System.out.println("----------------------------");
    
    // Solicitamos el texto al usuario
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String texto = sc.nextLine();
    
    // Número de coincidencias de texto
    int coincidencias = 0;
    
    for (Persona persona : personas) {
      if (persona.getNombre().contains(texto)) {
        imprimePersona(persona);
        coincidencias++;
      }
    }
    System.out.println("Se encontraron " + coincidencias + " coincidencias");
  }
  
  /**
   * Método que busca una persona por su dni. Avisa al usuario si encuentra la coincidencia. En caso de que no
   * lo haga, imprime un mensaje por pantalla con un aviso.
   */
  private void buscaPorDNI() {
    System.out.println("BUSCAR PERSONA POR DNI");
    System.out.println("-------------------------");
    
    // Solicitamos el texto al usuario
    System.out.print("Introduzca el DNI de la persona a buscar (8 números y 1 letra mayúscula): ");
    String dni = sc.nextLine();
    
    for (Persona persona : personas) {
      if (persona.getDni().equals(dni)) {
        imprimePersona(persona);
        break;
      }
    }
  }
  
  /**
   * Método que imprime todos los datos de una persona
   * @param persona Persona del cual se imprimen los datos. No puede ser null
   */
  private void imprimePersona(Persona persona) {
    if (persona != null) {
      // Comprobamos si es del tipo estudiante o profesor. En cada caso, realizamos su impresión
      if (persona instanceof Estudiante estudiante) {
        System.out.println("ESTUDIANTE DNI: " + estudiante.getDni() + ", Nombre: " + estudiante.getNombre() 
        + ", Curso: " + estudiante.getCurso());
      
      } else {
        Profesor profesor = (Profesor) persona;
        System.out.println("PROFESOR DNI: " + profesor.getDni() + ", Nombre: " + profesor.getNombre() 
        + ", Materia: " + profesor.getMateria());
        
      }

    }
  }
  
}
