package prog.ud06.actividad611.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import prog.ud06.actividad611.coleccion.Cliente;
import prog.ud06.actividad611.coleccion.ProveedorUsuariosException;
import prog.ud06.actividad611.coleccion.TarjetaClaves;
import prog.ud06.actividad611.coleccion.Usuario;
import prog.ud06.actividad611.coleccion.Usuarios;
import prog.ud06.actividad611.proveedores.ProveedorUsuariosArchivoXML;

/**
 * Clase principal de la aplicación
 * Maneja el interfaz de usuario de la aplicación
 */
public class ColeccionAppCompleta {
  
  // Constantes
  // Archivo XML con los datos
  private static final String ARCHIVO = "biblioteca.xml";
  // Opción salir del programa
  private static final int OPCION_SALIR = 0;
  // Opción Listar libros
  private static final int OPCION_LISTAR = 1;
  // Opción Buscar por titulo
  private static final int OPCION_BUSCAR_NOMBRE = 2;
  // Opcion Buscar por autor
  private static final int OPCION_BUSCAR_APELLIDOS = 3;
  // Opción Buscar por año de publicación
  private static final int OPCION_BUSCAR_DNI = 4;
  // Opción Buscar por año de publicación
  private static final int OPCION_BUSCAR_EDAD = 5;
  // Opciones minima y maxima (para comprobar los rangos)
  private static final int OPCION_MINIMA = OPCION_SALIR;
  private static final int OPCION_MAXIMA = OPCION_BUSCAR_EDAD;
  
  // Atributos
  // Contenedor de usuarios
  private Usuarios usuarios;
  // Scanner para leer desde teclado
  private Scanner sc;
  // Usuario autenticado
  Usuario usuario;

  /**
   * Constructor del objeto<br>
   * Recibe un contenedor de usuarios y crea el scanner para acceder al teclado
   * @param usuarios Contenedor de usuarios
   */
  public ColeccionAppCompleta(Usuarios usuarios) {
    this.usuarios = usuarios;
    sc = new Scanner(System.in);
    usuario = null;
  }

  /**
   * Main. Punto de entrada de la aplicación
   * @param args Argumentos de la línea de comandos
   */
  public static void main(String[] args) {
    
    // Obtenemos los usuarios
    try {
      Usuarios usuarios = new ProveedorUsuariosArchivoXML(ARCHIVO).obtieneUsuarios();
      // Creamos un objeto de la clase
      ColeccionAppCompleta app = new ColeccionAppCompleta(usuarios);
      // Y lanzamos el interfaz
      app.run();
    } catch (ProveedorUsuariosException e) {
      // Si no se puede obtener la información de usuarios y libros terminamos
      System.out.println("Error. No se puede acceder al archivo XML. Terminando");
    }
  }

  /**
   * Método principal del interfaz
   */
  private void run() {
    // Lo primero es autenticar al usuario
    usuario = autenticarUsuario();
    // Si se pudo hacer
    if (usuario != null) {
      // Muestra el menú repetidamente hasta que se elija la opción Salir
      int opcionElegida = OPCION_SALIR;
      do {
        // Muestra el menú y obtiene una elección
        opcionElegida = mostrarMenu();
        // Según la opción elegida
        switch (opcionElegida) {
          case OPCION_LISTAR:
            comandoListarClientes();
            break;
          case OPCION_BUSCAR_NOMBRE:
            comandoBuscarNombre();
            break;
          case OPCION_BUSCAR_APELLIDOS:
            comandoBuscarApellidos();
            break;
          case OPCION_BUSCAR_DNI:
            comandoBuscarDni();
            break;
          case OPCION_BUSCAR_EDAD:
            comandoBuscarEdad();
            break;
          case OPCION_SALIR:
            break;
          default:
            // No se debe llegar aqui
            System.out.println("Error. Opción incorrecta.");
        }
      } while (opcionElegida != OPCION_SALIR);
    } else {
      // No se pudo autenticar al usuario. Termina
      System.out.println("Error de autenticación. Terminando programa");
    }
  }

  /**
   * Autentifica al usuario
   * @return Usuario si la autenticación tuvo éxito. null si no lo tuvo
   */
  private Usuario autenticarUsuario() {
    // Solicitamos el nombre del usuario
    System.out.println("Autenticación");
    System.out.print("Introduzca el nombre de usuario: ");
    String nombreUsuario = sc.nextLine();
    // Accede al usuario en el contenedor
    Usuario usuario = usuarios.getUsuarioPorNombreUsuario(nombreUsuario);
    // Si no es null
    if (usuario != null) {
      // Accedemos a la tarjeta
      TarjetaClaves tarjeta = usuario.getTarjeta();
      // Obtenemos el número de filas y columnas de la tarjeta
      int filas = tarjeta.getFilas();
      int columnas = tarjeta.getColumnas();
      
      // Obtenemos un valor aleatorio de fila y columna
      Random random = new Random();
      int fila = random.nextInt(1, filas + 1);
      int columna = random.nextInt(1, columnas - 1);
      
      // Lo mostramos al usuario
      System.out.print("Introduzca la clave en las coordenadas (" + fila + ", " + columna + "): ");
      int clave = 1000;
      try {
        clave = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        // Autenticación incorrecta. terminamos
        System.out.println("Autenticación incorrecta");
        return null;
      }
      // Si el usuario autentica correctamente
      if (tarjeta.validarClave(fila, columna, clave)) {
        // Mostramos un mensaje y devolvemos el usuario
        System.out.println("Autenticación correcta.");
        return usuario;
      } else {
        // Autenticación incorrecta
        System.out.println("Autenticación incorrecta");
        return null;
      }
    } else {
      // Usuario no encontrado
      System.out.println("Autenticación incorrecta");
      return null;
    }
  }

  /**
   * Muestra el menú y elige la opción
   * @return Opción elegida. Se comprueba que es correcta y está en rango
   */
  private int mostrarMenu() {
    // Inicializamos la opción elegida a un valor invalido
    int opcion = OPCION_MINIMA - 1;
    // Mientras no se elija una opción correcta
    for (;;) {
      // Mostramos el menu
      System.out.println();
      System.out.println("MENU PRINCIPAL");
      System.out.println("--------------");
      System.out.println("1. Listar clientes");
      System.out.println("2. Buscar clientes por nombre de pila");
      System.out.println("3. Buscar clientes por apellidos");
      System.out.println("4. Buscar clientes por DNI");
      System.out.println("5. Buscar clientes por edad");
      System.out.println("0. Salir del programa");
      System.out.print("Elija una opción (" + OPCION_MINIMA + "-" + OPCION_MAXIMA + "): ");
      try {
        opcion = Integer.parseInt(sc.nextLine());
        // Si la opción está en rango se devuelve. Si no se muestra error y se da otra vuelta
        if (opcion >= OPCION_MINIMA && opcion <= OPCION_MAXIMA) {
          return opcion;
        } else {
          System.out.println("Opción elegida incorrecta. Debe introducir un número"
            + " comprendido entre " + OPCION_MINIMA + " y " + OPCION_MAXIMA);
        }
      } catch (NumberFormatException e) {
        System.out.println("Opción elegida incorrecta. Debe introducir un número"
            + " comprendido entre " + OPCION_MINIMA + " y " + OPCION_MAXIMA);
      }
    }
  }

  /**
   * Lista los clientes del usuario
   */
  private void comandoListarClientes() {
    // Cabecera
    System.out.println();
    System.out.println("LISTAR CLIENTES");
    System.out.println("---------------");
    
    // Lista todos los clientes
    System.out.println("Los clientes del usuario son:");
    listarClientes(usuario.getClientes());
  }

  /**
   * Busca los clientes del usuario cuyo nombre de pila contiene un texto determinado
   */
  private void comandoBuscarNombre() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR CLIENTE POR NOMBRE DE PILA");
    System.out.println("---------------------------------");
    
    // Solicita el modo de búsqueda
    System.out.print("¿Buscar por nombre completo o parte del nombre? (c=nombre completo, p=parte del nombre): ");
    String entrada = sc.nextLine();
    if (entrada.length() > 0) {
      char opcion = entrada.toLowerCase().charAt(0);
      // Si la opción es correcta
      if (opcion == 'c' || opcion == 'p') {
        // Solicita el texto a buscar
        System.out.print("Introduzca el texto a buscar en el nombre del cliente: ");
        String cadenaBusqueda = sc.nextLine();
        if (!cadenaBusqueda.isBlank()) {
          // Hace la búsqueda
          List<Cliente> resultado = buscarClienteTexto(usuario.getClientes(), cadenaBusqueda, opcion, CAMPO_NOMBRE);
          // Y muestra el resultado
          System.out.println("Los clientes del usuario que contienen \"" + cadenaBusqueda + "\" en el nombre de pila son:");
          listarClientes(resultado);
        } else {
          // Mensaje de error
          System.out.println("Texto de búsqueda en blanco. Cancelando");
        }
      } else {
        // Opción incorrecta
        System.out.println("La opción elegida no es válida. Debe ser una de c, p");
      }
    } else {
      // Mensaje de error
      System.out.println("No se ha elegido opción. Cancelando");
    }
  }

  /**
   * Busca los clientes del usuario cuyos apellidos contienen un texto determinado
   */
  private void comandoBuscarApellidos() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR CLIENTE POR APELLIDOS");
    System.out.println("----------------------------");
    
    // Solicita el modo de búsqueda
    System.out.print("¿Buscar por apellidos completos o parte de los apellidos? (c=apellidos completos, p=parte de los apellidos): ");
    String entrada = sc.nextLine();
    if (entrada.length() > 0) {
      char opcion = entrada.toLowerCase().charAt(0);
      // Si la opción es correcta
      if (opcion == 'c' || opcion == 'p') {
        // Solicita el texto a buscar
        System.out.print("Introduzca el texto a buscar en los apellidos de los clientes del usuario: ");
        String cadenaBusqueda = sc.nextLine();
        // Hace la búsqueda
        List<Cliente> resultado = buscarClienteTexto(usuario.getClientes(), cadenaBusqueda, opcion, CAMPO_APELLIDOS);
        // Y muestra el resultado
        System.out.println("Los clientes del usuario que contienen \"" + cadenaBusqueda + "\" en los apellidos son:");
        listarClientes(resultado);
      } else {
        // Opción incorrecta
        System.out.println("La opción elegida no es válida. Debe ser una de c, p");
      }
    } else {
      // Mensaje de error
      System.out.println("No se ha elegido opción. Cancelando");
    }
  }

  /**
   * Busca los clientes del usuario cuyos DNI es el proporcionado
   */
  private void comandoBuscarDni() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR CLIENTE POR DNI");
    System.out.println("----------------------");
    
    // Solicita el texto a buscar
    System.out.print("Introduzca el DNI a buscar (DNI completo): ");
    String cadenaBusqueda = sc.nextLine();
    // Hace la búsqueda
    List<Cliente> resultado = buscarClienteTexto(usuario.getClientes(), cadenaBusqueda, 'c', CAMPO_DNI);
    // Y muestra el resultado
    if (resultado.size() > 0) {
      System.out.println("El cliente con el DNI \"" + cadenaBusqueda + "\" es:");
      listarClientes(resultado);
    } else {
      System.out.println("No se encontró cliente con el DNI especificado");
    }
  }

  /**
   * Busca los clientes del usuario por su edad
   */
  private void comandoBuscarEdad() {
    // Cabecera
    System.out.println();
    System.out.println("BUSCAR CLIENTE POR AÑO");
    System.out.println("----------------------");
    
    // Edades
    Integer edadInicio = null;
    Integer edadFin = null;
    // Intenta leer las edades (o null) desde teclado
    try {
      edadInicio = leeEnteroONull("¿Buscar clientes cuya edad sera mayor o igual a? (vacío para cualquiera): ");
    } catch (NumberFormatException e) {
      // Error y abortamos
      System.out.println("Error. El dato introducido no es un número. Cancelando");
      return;
    }
    
    try {
      edadFin = leeEnteroONull("¿Buscar clientes cuya edad sea menor o igual a? (vacío para cualquiera): ");;
    } catch (NumberFormatException e) {
      // Error y abortamos
      System.out.println("Error. El dato introducido no es un número. Cancelando");
      return;
    }
    
    // Si ninguno es null, el de inicio debe ser menor o igual al final
    if (edadInicio == null || edadFin == null || edadInicio <= edadFin) {
      // Iniciamos la salida a lista vacía
      List<Cliente> encontrados = new ArrayList<>();
      
      // Para cada elemento de la lista
      for (Cliente cliente: usuario.getClientes()) {
        // Si la edad está comprendida en el rango
        if (enteroEnRango(cliente.getEdad(), edadInicio, edadFin)) {
          // Se añade a la lista
          encontrados.add(cliente);
        }
      }
      // Imprime el resultado
      System.out.println("Los clientes encontrados son:");
      listarClientes(encontrados);
      
    } else {
      // Error y cancelamos
      System.out.println("Error. El año de inicio es mayor que el año final");
      return;
    }
  }

  // Campos de búsqueda
  private static final int CAMPO_NOMBRE = 0;
  private static final int CAMPO_APELLIDOS = 1;
  private static final int CAMPO_DNI = 2;
  
  /**
   * Busca clientes cuyo nombre, apellidos o DNI contiene el texto espeificado
   * @param clientes Lista donde buscar los clientes
   * @param cadenaBusqueda Cadena a buscar
   * @param opcion Opción de búsqueda (c en todo el texto, p en cualquier parte de texto)
   * @param campo campo en que buscar (0=nombre, 1=apellidos, 2=dni)
   * @return Lista con los clientes
   */
  private List<Cliente> buscarClienteTexto(List<Cliente> clientes, String cadenaBusqueda,
    char opcion, int campo) {
    
    // Iniciamos la salida a lista vacía
    List<Cliente> salida = new ArrayList<>();
    
    // Para cada elemento de la lista
    for (Cliente cliente: clientes) {
      // Si se busca por nombre
      if (campo == CAMPO_NOMBRE) {
        // Según la opción
        if (opcion == 'c' && cliente.getNombre().equalsIgnoreCase(cadenaBusqueda)) {
          salida.add(cliente);
        } else if (opcion == 'p' && cliente.getNombre().contains(cadenaBusqueda)) {
          salida.add(cliente);
        }
      }
      // Si se busca por apellidos
      if (campo == CAMPO_APELLIDOS) {
        // Según la opción
        if (opcion == 'c' && cliente.getApellidos().equalsIgnoreCase(cadenaBusqueda)) {
          salida.add(cliente);
        } else if (opcion == 'p' && cliente.getApellidos().contains(cadenaBusqueda)) {
          salida.add(cliente);
        }
      }
      // Si se busca por DNI
      if (campo == CAMPO_DNI) {
        if (cliente.getDni().equalsIgnoreCase(cadenaBusqueda)) {
          salida.add(cliente);
        }
      }
    }
    // Devuelve el resultado
    return salida;
  }

  /**
   * Muestra por pantalla una lista de clientes
   * ordenados por apellidos
   * @param clientes Lista de clientes a mostrar
   */
  private void listarClientes(List<Cliente> clientes) {
    // Si la lista no está vacía
    if (clientes.size() > 0) {
      // Se ordena
      List<Cliente> clientesOrdenados = new ArrayList<>(clientes);
      clientesOrdenados.sort(null);
      // Para cada libro del usuario
      for (Cliente cliente: clientes) {
        // Lo imprime
        System.out.println(cliente.getApellidos() + ", " + cliente.getNombre()
          + ". DNI: " + cliente.getDni() + ". Edad: " + cliente.getEdad());
      }
    } else {
      // No hay clientes
      System.out.println("No hay clientes");
    }
  }

  /**
   * Lee un número entero desde teclado o null si se introduce una línea vacía
   * @param prompt Mensaje a mostrar al usuario para solicitar el número
   * @return Número introducido o null si se introdujo algo vacío
   * @throws NumberFormatException Si se intruduce algo pero no es un número
   */
  private Integer leeEnteroONull(String prompt) {
    // Prompt
    System.out.print(prompt);
    // Lee el dato en modo texto porque puede ser vacío
    String temporal = sc.nextLine();
    // Si es vacío
    if (temporal.isBlank()) {
      // Devuelve null
      return null;
    } else {
      // Si no, intentamos convertir la entrada en número
      return Integer.parseInt(temporal);
    }
  }

  /**
   * Determina si el número entero proporcionado está en el rango. El rango
   *   puede ser abierto o cerrado, por lo que permite valores null en los 
   *   límites. Un valor null indica que este límite está abierto. Si ambos
   *   límites están abiertos siempre se devuelve true.
   * @param valor Valor a comprobar
   * @param limiteInferior Limite inferior del rango. Si es null no hay
   *   límite inferior (el rango está abierto por abajo)
   * @param limiteSuperior Limite superior del rango. Igual que el inferior
   * @return true si el valor está en el rango. false si no lo está
   */
  private boolean enteroEnRango(int valor, Integer limiteInferior, Integer limiteSuperior) {
    // Si el límite inferior es abierto o el valor es superior a él si no lo es
    if (limiteInferior == null || valor >= limiteInferior) {
      // Ahora comprobamos si el limite superior es null o el valor es inferior a él si no lo es
      // Y devolvemos el resultado
      return limiteSuperior == null || valor <= limiteSuperior;
    } else {
      // Si no se cumple la primera condición ya sabemos que el valor no está en el rango
      return false;
    }
  }

}
