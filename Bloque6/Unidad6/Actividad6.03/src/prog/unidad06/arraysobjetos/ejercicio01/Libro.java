package prog.unidad06.arraysobjetos.ejercicio01;

public class Libro {

  /**
   * Atributo que almacena el título del libro
   */
  private String titulo;
  
  /**
   * Atributo que almacena el nombre del autor
   */
  private String autor;
  
  /**
   * Añi en el que se publica el libro
   */
  private int anyoPublicacion;

  /**
   * Constructor de la clase. Genera un libro dados el título, autor y año de publicación.
   * @param titulo Título del libro
   * @param autor Autor del libro
   * @param anyoPublicacion Año de publicación
   */
  public Libro(String titulo, String autor, int anyoPublicacion) {
    this.titulo = titulo;
    this.autor = autor;
    this.anyoPublicacion = anyoPublicacion;
  }

  /**
   * Método que obtiene el título del libro
   * @return El título del libro
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * Método que obtiene el autor del libro
   * @return El autor del libro
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Método que devuelve el año de publicación del libro
   * @return El año de publicación del libro
   */
  public int getAnyoPublicacion() {
    return anyoPublicacion;
  }  
  
}
