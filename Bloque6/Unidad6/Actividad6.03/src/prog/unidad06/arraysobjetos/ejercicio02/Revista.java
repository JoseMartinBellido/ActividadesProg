package prog.unidad06.arraysobjetos.ejercicio02;


public class Revista extends Publicacion{
  
  /**
   * Atributo que almacena el número de la revista
   */
  private int numero;

  /**
   * Constructor de la clase. Genera una revista dados el título, autor y año de publicación.
   * @param titulo Título del libro
   * @param autor Autor del libro
   * @param anyoPublicacion Año de publicación
   */
  public Revista(String titulo, int numero, int anyoPublicacion) {
    super(titulo, anyoPublicacion);
    this.numero = numero;
  }

  /**
   * Método que obtiene el número de la revista
   * @return Número de la revista
   */
  public int getNumero() {
    return numero;
  }

 

}
