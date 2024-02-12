package prog.unidad06.re.ejercicio01;

/**
 * Clase que almacena a un usuario del sistema
 */
public class Usuario {
  
  private static final String NOMBRE_COMPLETO_REGEX = "[A-ZÑ][A-ZÑa-zñ\\s\\-]*";
  
  /**
   * Patrón a usar para la comprobación del nombre completo del usuario.
   */
  private static final String NOMBRE_REGEX = "[A-ZÑ][a-zñ]*";
  
  /**
   * Patrón a usar para la comprobación del teléfono del usuario.
   */
  private static final String TELEFONO_REGEX = "[6789]\\d{8}";
  
  /**
   * Patrón a usar para la comprobación del código postal del usuario.
   */
   private static final String CODIGO_POSTAL_REGEX = "(5[012]\\d{3})|([1-4]\\d{4})|(0[1-9]\\d{3})";
   
   /**
    * Patrón a usar para comprobar el nombre de usuario
    */
   private static final String USUARIO_REGEX = "[A-Za-z]\\w{0,9}";
   
   /**
    * Patrón a usar para comprobar la contraseña del usuario
    */
   private static final String PASSWORD_REGEX = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\.;,:\\/\\*&%\\$\\(\\)])"
       + "[A-Za-z\\d\\.;,:\\/\\*&%\\$\\(\\)]{8,16}";
  
  /**
   * Nombre del usuario
   */
  private String nombre;
  
  /**
   * Teléfono del usuario
   */
  private String telefono;
  
  /**
   * Código postal perteneciente a la dirección del usuario
   */
  private String codigoPostal;
  
  /**
   * Nombre de usuario
   */
  private String user;
  
  /**
   * Contraseña asignada del usuario
   */
  private String password;

  /**
   * Constructor de la clase con todos los parámetros
   * @param nombre Nombre del usuario. No puede ser null ni vacío. Consta únicamente de letras españolas, espacios y guiones.
   * La longitud máxima es de 100 caracteres y cada parte debe comenzar con mayúscula
   * @param telefono Teléfono del usuario. No puede ser null y consta de 9 dígitos, comenzando por 6, 7, 8 o 9.
   * @param codigoPostal Código postal del lugar de residencia. No puede ser null y debe constar de 5 dígitos , estando los dos 
   * primeros comprendidos entre 01 y 52 (ambos incluidos)
   * @param usuario Nombre de usuario. No puede ser null y debe constar de entre 1 y 10 caracteres: letras minúsculas o 
   * mayúsculas del alfabeto inglés, dígitos, barras baja (_), teniendo que comenzar obligatoriamente por una letra
   * @param password Contraseña del usuario. No puede ser null, y debe constar de entre 8 y 16 caracteres: letras minúsculas o 
   * mayúsculas del alfabeto inglés, dígitos y uno de los siguientes caracteres especiales:
   * Punto (.), Punto y coma (;), Coma (,), Dos puntos (:), Barra (/), Asterisco (*), Ampersand (&), Porcentaje (%),
   * Dolar ($) o Paréntesis de apertura o cierre (). 
   * Debe contener al menos una mayúscula, una minúscula, un dígito y un carácter especial
   * @throws IllegalArgumentException En caso de que alguno de los parámetros sea erróneo
   */
  public Usuario(String nombre, String telefono, String codigoPostal, String usuario, String password) {
    setNombre(nombre);
    setTelefono(telefono);
    setCodigoPostal(codigoPostal);
    setUsuario(usuario);
    setPassword(password);
  }

  /**
   * Método que obtiene el nombre completo del usuario
   * @return El nombre completo del usuario
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Método que modifica el nombre completo del usuario
   * @param nombre Nombre del usuario. No puede ser null ni vacío. Consta únicamente de letras españolas, espacios y guiones.
   * La longitud máxima es de 100 caracteres y cada parte debe comenzar con mayúscula
   * @throws IllegalArgumentException Si el nombre no cumple los requisitos
   */
  public void setNombre(String nombre) {
    if (compruebaNombre(nombre)) {
      this.nombre = nombre;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Método que obtiene el número de teléfono del usuario
   * @return El teléfono del usuario
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * Método que modifica el número de teléfono del usuario
   * @param telefono Teléfono del usuario. No puede ser null y consta de 9 dígitos, comenzando por 6, 7, 8 o 9.
   */
  public void setTelefono(String telefono) {
    if (compruebaTelefono(telefono)) {
      this.telefono = telefono;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Método que comprueba el código postal de la dirección del usuario
   * @return El código postal
   */
  public String getCodigoPostal() {
    return codigoPostal;
  }

  /**
   * Método que modifica el código postal del usuario
   * @param codigoPostal Código postal del lugar de residencia. No puede ser null y debe constar de 5 dígitos , estando los dos 
   * primeros comprendidos entre 01 y 52 (ambos incluidos)
   */ 
  public void setCodigoPostal(String codigoPostal) {
    if (compruebaCodigoPostal(codigoPostal)) {
      this.codigoPostal = codigoPostal;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Método que obtiene el nombre de usuario
   * @return El nombre de usuario
   */
  public String getUsuario() {
    return user;
  }

  /**
   * Método que modifica el nombre de usuario
   * @param usuario Nombre de usuario. No puede ser null y debe constar de entre 1 y 10 caracteres: letras minúsculas o 
   * mayúsculas del alfabeto inglés, dígitos, barras baja (_), teniendo que comenzar obligatoriamente por una letra
   */
  public void setUsuario(String usuario) {
    if (compruebaUsuario(usuario)) {
      this.user = usuario;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Método que obtiene la contraseña del usuario
   * @return La contraseña del usuario
   */
  public String getPassword() {
    return password;
  }

  /**
   * Método que modifica la contraseña del usuario
   * @param password Contraseña del usuario. No puede ser null, y debe constar de entre 8 y 16 caracteres: letras minúsculas o 
   * mayúsculas del alfabeto inglés, dígitos y uno de los siguientes caracteres especiales:
   * Punto (.), Punto y coma (;), Coma (,), Dos puntos (:), Barra (/), Asterisco (*), Ampersand (&), Porcentaje (%),
   * Dolar ($) o Paréntesis de apertura o cierre (). 
   * Debe contener al menos una mayúscula, una minúscula, un dígito y un carácter especial
   */
  public void setPassword(String password) {
    if (compruebaPassword(password)) {
      this.password = password;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Método que comprueba el formato de un nombre
   * @param nombre Nombre a comprobar. Debe ser distinto de null, no vacío y tener 100 o menos caracteres. Además, 
   * las palabras del nombre irán separadas por espacios o guiones y cada una comenzará por mayúscula.
   * @return true si cumple las condiciones, false en caso contrario
   */
  private boolean compruebaNombre(String nombre) {
    boolean nombreCorrecto = true;
    if (nombre != null && nombre.length() >= 1 && nombre.length() <= 100 
        && nombre.matches(NOMBRE_COMPLETO_REGEX)) {
      String[] partesNombre = nombre.split("[\\s-]+");
      for (String parte : partesNombre) {
        if (!parte.matches(NOMBRE_REGEX)) {
          nombreCorrecto = false;
        }
      }
    } else {
      nombreCorrecto = false;
    }
    return nombreCorrecto;
  }
  
  /**
   * Método que comprueba el formato de un teléfono
   * @param telefono Teléfono a comprobar. Debe ser distinto de null, comenzar por 6, 7, 8 o 9 y constar de 9 dígitos en total
   * @return true si cumple las condiciones, false en caso contrario
   */
  private boolean compruebaTelefono(String telefono) {
    return telefono != null && telefono.matches(TELEFONO_REGEX);
  }
  

  /**
   * Método que comprueba el formato de un código postal
   * @param codigoPostal Código postal a comprobar. Debe ser distinto de null y estar compuesto por 5 dígitos, comenzando 
   * por dos dígitos comprendidos entre 01 y 52, ambos incluidos.
   * @return true si cumple las condiciones, false en caso contrario
   */
  private boolean compruebaCodigoPostal(String codigoPostal) {
    return codigoPostal != null && codigoPostal.matches(CODIGO_POSTAL_REGEX);
  }
  
  /**
   * Método que comprueba el formato de un usuario
   * @param usuario Usuario a comprobar. Debe ser distinto de null y estar compuesto de 1-10 caracteres que pueden ser
   * letras mayúsculas o minúsculas del alfabeto inglés, dígitos o el símbolo _. Debe comenzar por letra obligatoriamente.
   * @return true si cumple las condiciones, false en caso contrario
   */
  private boolean compruebaUsuario(String usuario) {
    return usuario != null && usuario.matches(USUARIO_REGEX);
  }

  /**
   * Método que comprueba el formato de la contraseña de un usuario
   * @param password Contraseña a comprobar. Debe ser distinto de null y estar compuesto de 8-16 caracteres, donde al menos 
   * uno de ellos debe ser una letra mayúscula, otra minúscula, un dígito y un símbolo (.;,:/*&%$())
   * @return true si cumple las condiciones, false en caso contrario
   */
  private boolean compruebaPassword(String password) {
    return password != null && password.matches(PASSWORD_REGEX);
  }
}
