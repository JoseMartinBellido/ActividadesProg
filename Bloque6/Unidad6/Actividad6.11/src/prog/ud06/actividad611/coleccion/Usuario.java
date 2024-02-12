package prog.ud06.actividad611.coleccion;

import java.util.List;

/**
 * Clase que representa a un Usuario<br>
 * Un Usuario tiene un identificador único, un nombre completo,
 * una tarjeta de claves y una lista de clientes
 */
public class Usuario {

  // Atributos
  // Nombre de usuario
  private String nombreUsuario;
  private String nombreCompleto;
  private TarjetaClaves tarjeta;
  private List<Cliente> libros;
  
  /**
   * Crea un usuario
   * @param nombreUsuario Nombre de usuario único del usuario. No puede ser null y debe tener entre
   *   2 y 8 caracteres alfanuméricos, siendo el primero una letra.
   * @param nombreCompleto Nombre y apellidos. No puede ser null ni vacío.
   * @param tarjeta Tarjeta de claves del usuario. No puede ser null
   * @param clientes Lista de clientes del usuario. No puede ser null aunque puede estar vacía.
   * @throws IllegalArgumentException Si alguno de los parámetros no es correcto
   */
  public Usuario(String nombreUsuario, String nombreCompleto,
    TarjetaClaves tarjeta, List<Cliente> clientes) {
    // Si los datos son válidos los almacena
    if (nombreUsuario != null && esNombreUsuarioValido(nombreUsuario) && nombreCompleto != null && !nombreCompleto.isEmpty()
      && tarjeta != null && clientes != null) {
      this.nombreUsuario = nombreUsuario;
      this.nombreCompleto = nombreCompleto;
      this.tarjeta = tarjeta;
      this.libros = clientes;
    } else {
      // Si alguno no es válido lanza excepcion
      throw new IllegalArgumentException();
    }
  }

  /**
   * Devuelve el nombre de usuario del usuario
   * @return Nombre de Usuario del usuario
   */
  public String getNombreUsuario() {
    return nombreUsuario;
  }

  /**
   * Obtiene el nombre y apellidos del usuario
   * @return Nombre y apellidos del usuario
   */
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  /**
   * Obtiene la tarjeta de coordenadas del usuario
   * @return Tarjeta de coordenadas del usuario
   */
  public TarjetaClaves getTarjeta() {
    return tarjeta;
  }

  /**
   * Obtiene la lista de clientes del usuario
   * @return Lista de clientes del usuario
   */
  public List<Cliente> getClientes() {
    return libros;
  }

  /**
   * Determina si el nombre de usuario es válido o no<br>
   * Un nombre de usuario es válido si tiene entre 2 y 8 caracteres
   *   alfanuméricos, siendo el primero una letra
   * @param nombreUsuario Nombre de usuario a comprobar
   * @return true si el nombre de usuario es válido o false si no lo es
   */
  private boolean esNombreUsuarioValido(String nombreUsuario) {
    return nombreUsuario.matches("[A-Za-z][A-Za-z0-9]{1,7}");
  }
}
