package prog.unidad06.arraysobjetos.ejercicio03;

import java.util.Scanner;


public class GestionaEstudiantesApp {

  /**
   * Atributo Scanner implementado para la inserción de datos
   */
  Scanner sc;
  
  /**
   * Atributo estudiantes, compuesto por un array de objetos de la clase Estudiante, sin repetir el dni
   */
  Estudiante[] estudiantes;
  
  /**
   * Constructor de la clase
   * @param sc Scanner para la inserción de datos
   */
  public GestionaEstudiantesApp(Scanner sc) {
    this.sc = sc;
    estudiantes = new Estudiante[0];
  }
  
  /**
   * Método main de la clase
   * @param args Argumentos de la función main
   */
  public static void main(String[] args) {
    GestionaEstudiantesApp miApp = new GestionaEstudiantesApp(new Scanner(System.in));
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
            addEstudiante();
            break;
          case 2: 
            muestraTodosLosEstudiantes();
            break;
          case 3: 
            eliminaEstudiante();
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
    System.out.println("GESTIÓN DE ESTUDIANTES");
    System.out.println("----------------------");
    
    System.out.println("(1) Agregar estudiante");
    System.out.println("(2) Mostrar todos los estudiantes");
    System.out.println("(3) Eliminar estudiante");
    System.out.println("(4) Buscar estudiante por nombre");
    System.out.println("(5) Buscar estudiante por DNI");
    System.out.println("(0) Salir de la aplicación");
    
    
    System.out.print("Introduzca una opción (0-5): ");
    int eleccion = Integer.parseInt(sc.nextLine());
    System.out.println();
    
    return eleccion;
  }
  
  /**
   * Método que agrega un estudiante al conjunto ya definido mediante los parámetros insertados por consola 
   * (dni, nombre y curso). Incluirá el estudiante si estos parámetros son válidos y, además, no existe ningún
   * estudiante ya guardado con el mismo dni
   */
  private void addEstudiante() {
    System.out.println("AGREGAR ESTUDIANTE");
    System.out.println("------------------");

    // Solicitamos los datos del estudiante
    System.out.print("Introduzca el DNI del estudiante (8 números y una letra mayúscula, sin espacios): ");
    String dni = sc.nextLine();
    
    System.out.print("Introduzca el nombre del estudiante (entre 1 y 100 caracteres): ");
    String nombre = sc.nextLine();
    
    System.out.print("Introduzca el curso al que pertenece el estudiante (primero/segundo/master): ");
    String curso = sc.nextLine();
    
    // Creamos el estudiante
    Estudiante estudiante = null;
    try {
      estudiante = new Estudiante(dni, nombre, curso);
      
      // Si el estudiante es correcto, comprobamos que no esté incluido en el array 
      boolean incluido = false;
      for (int i = 0; i < estudiantes.length; i++) {
        if (estudiantes[i].getDni().equals(dni)) {
          incluido = true;
          break;
        }
      }
      // Si está ya incluido, avisamos al usuario
      if (incluido) {
        System.out.println("No puede añadirse el estudiante porque ya hay otro con el mismo DNI.");
        
      // En caso contrario, ampliamos el array e introducimos el nuevo estudiante
      } else {
        
        Estudiante[] estudiantesActualizado = new Estudiante[estudiantes.length + 1];
        for (int i = 0; i < estudiantes.length; i++) {
          estudiantesActualizado[i] = estudiantes[i];
        }
        estudiantesActualizado[estudiantes.length] = estudiante;
        
        // Actualizamos el array antiguo de estudiantes
        estudiantes = estudiantesActualizado;
        
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Alguno de los datos del estudiante es erróneo. Por favor, inténtelo de nuevo.");
    }
  }
 
  /**
   * Método que imprime todos los datos de un estudiante
   * @param estudiante Estudiante del cual se imprimen los datos. No puede ser null
   */
  private void imprimeEstudiante(Estudiante estudiante) {
    if (estudiante != null) {
      System.out.println("DNI: " + estudiante.getDni() + ", Nombre: " + estudiante.getNombre() 
          + ", Curso: " + estudiante.getCurso());
    }
  }
  
  /**
   * Método que imprime todos los datos de los estudiantes del grupo (dni, nombre y curso)
   */
  private void muestraTodosLosEstudiantes() {
    System.out.println("MOSTRAR ESTUDIANTES");
    System.out.println("-------------------");
    
    if (estudiantes.length == 0) {
      System.out.println("No hay estudiantes en el grupo.");
    } else {
      for (Estudiante estudiante : estudiantes) {
        imprimeEstudiante(estudiante);
      }
    }
  }
  
  private void eliminaEstudiante() {
    System.out.println("ELIMINAR ESTUDIANTE");
    System.out.println("-------------------");
   
    // Solicitamos el dni del estudiante a eliminar
    System.out.print("Introduzca el DNI del estudiante a eliminar (8 números y 1 letra mayúscula, "
        + "sin espacios): ");
    String dni = sc.nextLine();
    
    // Buscamos el dni en el array. Por definición, no habrá repetidos    
    boolean encontrado = false;
    for (Estudiante estudiante : estudiantes) {
      // Si lo encontramos, paramos. En caso contrario, avisamos al usuario
      if (estudiante.getDni().equals(dni)) {
        encontrado = true;
      }
    }
    if (!encontrado) {
      System.out.println("No se encontró al estudiante en el grupo.");
    } else {
      // Si lo hemos encontrado, creamos un nuevo array de estudiantes y almacenamos la lista actualizada
      Estudiante[] estudiantesActualizado = new Estudiante[estudiantes.length - 1];
      int indice = 0;
      
      for (Estudiante estudiante : estudiantes) {
        if (estudiante.getDni().equals(dni)) {
          estudiantesActualizado[indice] = estudiante;
          indice++;
        }
      }
      
      // Modificamos el array original
      estudiantes = estudiantesActualizado;
    }
  }
  
  /**
   * Método que busca por nombre. Avisa al usuario si no encuentra coincidencias, y si encuentra algún estudiante
   * cuyo nombre contenga el texto aportado, imprime sus datos, junto con el número de coincidencias encontradas
   */
  private void buscaPorNombre() {
    System.out.println("BUSCAR ESTUDIANTE POR NOMBRE");
    System.out.println("----------------------------");
    
    // Solicitamos el texto al usuario
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String texto = sc.nextLine();
    
    // Número de coincidencias de texto
    int coincidencias = 0;
    
    for (Estudiante estudiante : estudiantes) {
      if (estudiante.getNombre().contains(texto)) {
        imprimeEstudiante(estudiante);
        coincidencias++;
      }
    }
    System.out.println("Se encontraron " + coincidencias + " coincidencias");
  }
  
  private void buscaPorDNI() {
    System.out.println("BUSCAR ESTUDIANTE POR DNI");
    System.out.println("-------------------------");
    
    // Solicitamos el texto al usuario
    System.out.print("Introduzca el DNI del estudiante a buscar (8 números y 1 letra mayúscula): ");
    String texto = sc.nextLine();
    
    for (Estudiante estudiante : estudiantes) {
      if (estudiante.getDni().equals(texto)) {
        imprimeEstudiante(estudiante);
        break;
      }
    }
  }
  
}
