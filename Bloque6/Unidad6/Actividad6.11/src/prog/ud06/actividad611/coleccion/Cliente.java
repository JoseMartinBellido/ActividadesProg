package prog.ud06.actividad611.coleccion;

/**
 * Un cliente de la empresa
 */
public class Cliente implements Comparable<Cliente>{

  // Constantes
  private static final String REGEX_DNI = "[0-9]{8}[ABCDEFGHJLMNPQRSTVWXYZ]";
  // Letras correspondientes a cada resto en el DNI
  private static final char[] LETRAS_DNI = {
    'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
    'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
  };

  // Atributos
  // Nombre de pila
  private String nombre;
  // Apellidos
  private String apellidos;
  // DNI
  private String dni;
  // Edad
  private int edad;

  /**
   * Constructor
   * @param nombre Nombre de pila de la persona. No puede ser null o vacío o
   *   contener sólo espacios
   * @param apellidos Apellidos de la persona. No puede ser null o vacío o
   *   contener sólo espacios
   * @param dni DNI de la persona. No puede ser null y debe constar de 8
   *   números y una letra. La letra debe ser mayúscula y válida según las
   *   normas del DNI
   * @param edad Edad de la persona. Debe ser 0 ó superior
   * @throws IllegalArgumentException Si alguno de los paarámetros no es correcto
   */
  public Cliente(String nombre, String apellidos, String dni, int edad) {
    if (esNombreValido(nombre) && esApellidosValido(apellidos)
      && esDniValido(dni) && esEdadValido(edad)) {
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.dni = dni;
      this.edad = edad;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Obtiene el nombre de pila del cliente
   * @return Nombre de pila del cliente
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene los apellidos del cliente
   * @return Apellidos del cliente
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * Obtiene el DNI del cliente
   * @return DNI del cliente
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene la edad del cliente
   * @return Edad del cliente
   */
  public int getEdad() {
    return edad;
  }

  @Override
  public int compareTo(Cliente o) {
    return this.apellidos.compareTo(o.apellidos);
  }

  /**
   * Comprueba que el nombre de pila es válido<br>
   * Para ser válido no puede ser null o vacío o contener sólo espacios
   * @param nombre Nombre de pila
   * @return true si el nombre es válido. false en caso contrario
   */
  private boolean esNombreValido(String nombre) {
    return nombre != null && !nombre.isBlank();
  }

  /**
   * Comprueba que los apellidos son válidos<br>
   * Para ser válidos no puede ser null o vacío o contener sólo espacios
   * @param apellidos Apellidos a validar
   * @return true si el apellido es válido. false en caso contrario
   */
  private boolean esApellidosValido(String apellidos) {
    return apellidos != null && !apellidos.isBlank();
  }

  /**
   * Comprueba si el DNI es válido<br>
   * Para ser válido debe constar de 8 números y una letra mayúscula válida
   * , según las reglas del DNI. Además la letra debe coincidir con la calculada
   * según dichas reglas
   * @param dni DNI a validar
   * @return true si el dni es válido, false si no lo es
   */
  private boolean esDniValido(String dni) {
    // Si no es null
    if (dni != null) {
      // Si "parece" un dni
      if (dni.matches(REGEX_DNI)) {
        return validaLetraDNI(dni);
      } else {
        // Formato no válido
        return false;
      }
    } else {
      // Null no es válido
      return false;
    }
  }

  /**
   * Determina si la edad es válida<br>
   * Para ser válida deber ser superior o igual a cero
   * @param edad Edad a comprobar
   * @return true si la edad es válida. false en caso contrario
   */
  private boolean esEdadValido(int edad) {
    return edad >= 0;
  }

  /**
   * Valida la letra del DNI
   * @param dni DNI a validar
   * @return true si la letra del DNI es válida. false en caso contrario
   */
  private boolean validaLetraDNI(String dni) {
    // Convertimos el número a entero
    int numero = Integer.parseInt(dni.substring(0, 8));
    // Calculamos el resto
    int resto = numero % 23;
    // La letra debe coincidir con la correspondiente al resto
    return dni.charAt(8) == LETRAS_DNI[resto];
  }

}
