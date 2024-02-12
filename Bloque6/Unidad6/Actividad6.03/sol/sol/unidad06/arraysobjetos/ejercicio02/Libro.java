package sol.unidad06.arraysobjetos.ejercicio02;

/**
 * Clase que representa un libro
 */
public class Libro extends Publicacion implements Cadenable {

  // Atributos
  // Autor
  private String autor;
  
  /**
   * Constructor
   * @param titulo Titulo del libro
   * @param autor Autor del libro
   * @param anyo Año de publicacion del libro
   */
  public Libro(String titulo, String autor, int anyo) {
    this.titulo = titulo;
    this.autor = autor;
    this.anyo = anyo;
  }

  /**
   * Obtiene el autor del libro
   * @return Autor del libro
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Obtiene una cadena con los datos del libro en formato:<br>
   * LIBRO Titulo: titulo, Autor: autor, Año Publicación: anyo
   * @return Cadena con los datos del libro
   */
  @Override
  public String obtenerCadena() {
    return "LIBRO Titulo: " + titulo + ", Autor: " + autor + ", Año Publicación: " + anyo;
  }
  
}
