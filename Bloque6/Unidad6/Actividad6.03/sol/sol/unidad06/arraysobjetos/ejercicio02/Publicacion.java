package sol.unidad06.arraysobjetos.ejercicio02;

/**
 * Clase que representa a una publicación
 */
public class Publicacion implements Cadenable {

  // Atributos
  // Titulo de la publicación
  protected String titulo;
  // Año de publicacion
  protected int anyo;
  
  /**
   * Obtiene el titulo de la publicacion
   * @return Titulo de la publicación
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * Obtiene el año de publicación de la publicación
   * @return Año de publicacion de la publicación
   */
  public int getAnyo() {
    return anyo;
  }

  /**
   * Obtiene una cadena con los datos de la publicación en formato:<br>
   * Titulo: titulo, Año Publicación: anyo
   * @return Cadena con los datos del libro
   */
  @Override
  public String obtenerCadena() {
    return "Titulo: " + titulo + ", Año Publicación: " + anyo;
  }
  

}
