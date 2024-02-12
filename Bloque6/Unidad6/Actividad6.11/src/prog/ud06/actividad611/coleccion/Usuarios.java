package prog.ud06.actividad611.coleccion;

import prog.ud06.actividad611.coleccion.diccionario.Diccionario;
import prog.ud06.actividad611.coleccion.diccionario.DiccionarioException;

/**
 * Contenedor de los usuarios del sistema<br>
 * La clase Usuarios se encarga de almacenar y recuperar los usuarios que
 * forman el sistema
 */
public class Usuarios {

  // Atributos
  // Diccionario con los usuarios
  private Diccionario<Usuario> usuarios;
  
  /**
   * Constructor. Inicializa el contenedor
   */
  public Usuarios() {
    usuarios = new Diccionario<>();
  }
  
  /**
   * Añade un nuevo usuario al contenedor.<br>
   * Falla si ya hay un usuario con el mismo nombre de usuario
   * @param usuario Usuario a añadir. No puede ser null
   * @throws IllegalArgumentException Si el usuario es null
   * @throws UsuariosException Si ya existe un usuario en el contenedor
   *   con el mismo nombre de usuario que el que se está intentando añadir
   */
  public void addUsuario(Usuario usuario) {
    try {
      // Intenta añadir el usuario al diccionario
      usuarios.add(usuario.getNombreUsuario(), usuario);
    } catch (DiccionarioException e) {
      // No se pudo añadir el usuario. Lanzamos nuestra excepcion
      throw new UsuariosException();
    }
    // No hay catch para IllegalArgumentException porque no queremos procesar
    // esa excepción sino la dejamos seguir hacia nuestro llamador
  }
  
  /**
   * Localiza un usuario por su nombre de usuario
   * @param nombreUsuario Nombre de usuario del usuario a localizar
   * @return usuario si se encontró. null si no se encontró
   */
  public Usuario getUsuarioPorNombreUsuario(String nombreUsuario) {
    // Usamos el diccionario. Si la entrada no existe se devolverá null y
    // nosotros lo re-devolvemos
    return usuarios.getEntrada(nombreUsuario);
  }
}
