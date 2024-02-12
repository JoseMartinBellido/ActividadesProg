package prog.unidad06.arraysobjetos.ejercicio02;

public class Publicacion {
  
  /**
   * Atributo que almacena el título del libro
   */
  private String titulo;
  
  /**
   * Añi en el que se publica el libro
   */
  private int anyoPublicacion;

  /**
   * Constructor de la clase. Genera una publicación dados el título y el año de publicación.
   * @param titulo Título de la publicación
   * @param anyoPublicacion Año de publicación
   */
  public Publicacion(String titulo, int anyoPublicacion) {
    this.titulo = titulo;
    this.anyoPublicacion = anyoPublicacion;
  }

  /**
   * Método que obtiene el título de la publicación
   * @return El título de la publicación
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * Método que devuelve el año de publicación de la publicación
   * @return El año de publicación de la publicación
   */
  public int getAnyoPublicacion() {
    return anyoPublicacion;
  }  
}
