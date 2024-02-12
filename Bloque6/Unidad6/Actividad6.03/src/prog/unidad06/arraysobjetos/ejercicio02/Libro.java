package prog.unidad06.arraysobjetos.ejercicio02;


public class Libro extends Publicacion{

  /**
   * Atributo que almacena el nombre del autor
   */
  private String autor;

  /**
   * Constructor de la clase. Genera un libro dados el título, autor y año de publicación.
   * @param titulo Título del libro
   * @param autor Autor del libro
   * @param anyoPublicacion Año de publicación
   */
  public Libro(String titulo, String autor, int anyoPublicacion) {
    super(titulo, anyoPublicacion);
    this.autor = autor;

  }

  /**
   * Método que obtiene el autor del libro
   * @return El autor del libro
   */
  public String getAutor() {
    return autor;
  }
  
}
