package prog.unidad05.gui.ejercicio10;

/**
 * Clase que representa a un usuario del sistema
 */
public class Usuario {

  // Bloque de constantes para el ciclo 
  private static final String CICLO_ASIR = "ASIR";
  private static final String CICLO_DAM = "DAM";
  private static final String CICLO_DAW = "DAW";
  
  // Bloque de constantes para la titulación presentada
  private static final String TITULACION_BACHILLERATO = "Bachillerato";
  private static final String TITULACION_PRUEBA_DE_ACCESO = "Prueba de Acceso";
  
  /**
   * Nombre del usuario
   */
  private String nombre;
  
  /**
   * Contraseña asociada al usuario
   */
  private String password;
  
  /**
   * Ciclo al que se presenta el usuario
   */
  private String cicloSolicitud;
  
  /**
   * Titulación presentada por parte del usuario
   */
  private String titulacionPresentada;
  
  /**
   * Documentación aportada por parte del usuario 
   */
  private String documentacionAportada;

  /**
   * Constructor de la clase con todos los parámetros
   * @param nombre Nombre del usuario. Debe ser una cadena de entre 1 y 8 caracteres
   * @param password Contraseña del usuario. Debe ser una cadena de entre 5 y 10 caracteres
   * @param cicloSolicitud Ciclo sobre el que se realiza la solicitud. Debe ser ASIR, DAM o DAW
   * @param titulacionPresentada Debe ser Bachillerato o Prueba de Acceso
   * @param documentacionAportada No debe ser una cadena en blanco
   * @throws NombreUsuarioException En caso de tener un nombre incorrecto
   * @throws PasswordUsuarioException En caso de tener una contraseña incorrecta
   * @throws IllegalArgumentException En caso de que alguno de los parámetros restantes sea incorrecto
   */
  public Usuario(String nombre, String password, String cicloSolicitud, String titulacionPresentada,
      String documentacionAportada) {
    
    // Verificación del nombre
    if (compruebaNombre(nombre)){
      this.nombre = nombre;
    } else {
      throw new NombreUsuarioException();
    }
    
    // Verificación de la contraseña
    if (compruebaPassword(password)) {
      this.password = password;
    } else {
      throw new PasswordUsuarioException();
    }
    
    // Verificación del resto de parámetros
    if (compruebaCicloSolicitud(cicloSolicitud) && compruebaTitulacionPresentada(titulacionPresentada) 
        && !documentacionAportada.isBlank()) {
      this.cicloSolicitud = cicloSolicitud;
      this.titulacionPresentada = titulacionPresentada;
      this.documentacionAportada = documentacionAportada;
    
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Método que verifica que el nombre del usuario sea el correcto
   * @param nombre Nombre del usuario. Debe ser una cadena de entre 1 y 8 caracteres
   * @return true si el nombre es correcto, false en caso contrario
   */
  private boolean compruebaNombre(String nombre) {
    return nombre.length() >= 1 && nombre.length() <= 8;
  }
  
  /**
   * Método que verifica que la contraseña del usuario sea correcta
   * @param password Contraseña del usuario. Debe ser una cadena de entre 5 y 10 caracteres
   * @return true si la contraseña es correcta, false en caso contrario
   */
  private boolean compruebaPassword(String password) {
    return password.length() >= 5 && password.length() <= 10;
  }
  
  /**
   * Método que verifica que el ciclo que se ha solicitado es correcto
   * @param cicloSolicitud Ciclo sobre el que se realiza la solicitud. Debe ser ASIR, DAM o DAW
   * @return true si el ciclo es correcto, false en caso contrario
   */
  private boolean compruebaCicloSolicitud(String cicloSolicitud) {
    return cicloSolicitud.equals(CICLO_ASIR) || cicloSolicitud.equals(CICLO_DAM) 
        || cicloSolicitud.equals(CICLO_DAW);
  }
  
  /**
   * Método que verifica que la titulación presentada es correcta
   * @param titulacionPresentada Debe ser Bachillerato o Prueba de Acceso
   * @return true si la titulación presentada es correcta, false en caso contrario
   */
  private boolean compruebaTitulacionPresentada(String titulacionPresentada) {
    return titulacionPresentada.equals(TITULACION_BACHILLERATO)
        || titulacionPresentada.equals(TITULACION_PRUEBA_DE_ACCESO);
  }

  /**
   * Método que devuelve el nombre del usuario
   * @return El nombre del usuario
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Método que devuelve la contraseña del usuario
   * @return la contraseña del usuario
   */
  public String getPassword() {
    return password;
  }

  /**
   * Método que devuelve el ciclo que solicita el usuario
   * @return el ciclo que solicita el usuario
   */
  public String getCicloSolicitud() {
    return cicloSolicitud;
  }

  /**
   * Método que devuelve la titulación presentada por parte del usuario
   * @return la titulación presentada por parte del usuario
   */
  public String getTitulacionPresentada() {
    return titulacionPresentada;
  }

  /**
   * Método que devuelve la documentación aportada por parte del usuario
   * @return la documentación aportada por parte del usuario
   */
  public String getDocumentacionAportada() {
    return documentacionAportada;
  }
  
  
  
}
