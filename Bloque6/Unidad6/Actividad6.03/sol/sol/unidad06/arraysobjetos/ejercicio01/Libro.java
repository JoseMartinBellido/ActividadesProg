package sol.unidad06.arraysobjetos.ejercicio01;

/**
 * Clase que representa un libro
 */
public class Libro {

  // Atributos
  // Titulo del libro
  private String titulo;
  // Autor
  private String autor;
  // Año de publicacion
  private int anyo;
  
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
   * Obtiene el titulo del libro
   * @return Titulo del libro
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * Obtiene el autor del libro
   * @return Autor del libro
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Obtiene el año de publicación del libro
   * @return Año de publicacion del libro
   */
  public int getAnyo() {
    return anyo;
  }
  
  /**
   * Obtiene una cadena con los datos del libro en formato:<br>
   * Titulo: titulo, Autor: autor, Año Publicación: anyo
   * @return Cadena con los datos del libro
   */
  public String obtenerCadena() {
    return "Titulo: " + titulo + ", Autor: " + autor + ", Año Publicación: " + anyo;
  }
  
}
