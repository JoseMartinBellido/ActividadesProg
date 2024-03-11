package prog.unidad05.ficheros.ejercicio05;

import java.util.Objects;

/**
 * Clase que representa un disco de música. Dicho disco será descrito a partir del título, autor, 
 * año de publicación, precio y si ha sido publicado en CD o no
 */
public class Disco {

  /**
   *  Título del disco
   */
  private String titulo;
  
  /**
   * Autor del disco
   */
  private String artista;
  
  /**
   * Año en el que se publicó el disco
   */
  private int anyoPublicacion;
  
  /**
   * Precio del disco en euros
   */
  private double precio;
  
  /**
   * Booleano que indica si un disco ha sido o no publicado en CD
   */
  private boolean estaPublicadoCD;
  
  /**
   * Constructor de la clase con todos los parámetros
   * @param titulo Título del disco. No puede estar vacío
   * @param artista Autor del disco. No puede estar vacío
   * @param anyoPublicacion Año en que se publicó el disco. Debe ser positivo o cero
   * @param precio Precio del disco en euros. Debe ser positivo o cero
   * @param estaPublicadoCD Indica si el disco está publicado en CD o no
   * @throws IllegalArgumentException En caso de que alguno de los parámetros no cumpla las condiciones
   */
  public Disco(String titulo, String artista, int anyoPublicacion, double precio, 
      boolean estaPublicadoCD) {
    
    // Se comprueban los requisitos para crear el cd
    if (!titulo.isEmpty() && !artista.isEmpty() && anyoPublicacion >= 0 && precio >= 0) {
      this.titulo = titulo;
      this.artista = artista;
      this.anyoPublicacion = anyoPublicacion;
      this.precio = precio;
      this.estaPublicadoCD = estaPublicadoCD;
    
      // Sino, se lanza el error
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Método que obtiene el título del disco
   * @return El título del disco
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * Método que obtiene el artista del disco
   * @return El autor del disco
   */
  public String getArtista() {
    return artista;
  }

  /**
   * Método que obtiene el año de publicación del disco
   * @return El año de publicación del disco
   */
  public int getAnyoPublicacion() {
    return anyoPublicacion;
  }

  /**
   * Método que obtiene el precio del disco
   * @return El precio del disco
   */
  public double getPrecio() {
    return precio;
  }

  /**
   * Método que indica si un disco ha sido publicado en CD o no
   * @return true si el disco ha sido publicado en CD, false en caso contrario
   */
  public boolean estaPublicadoCD() {
    return estaPublicadoCD;
  }
  
  public String aCadena() {
    return String.format("Título: %s, Artista: %s, Año de Publicación: %d, Precio: %.2f, "
        + "¿Formato CD? %s", titulo, artista, anyoPublicacion, precio, (estaPublicadoCD) ? "s" : "n");
  }

  @Override
  public int hashCode() {
    return Objects.hash(anyoPublicacion, artista, estaPublicadoCD, precio, titulo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Disco other = (Disco) obj;
    return anyoPublicacion == other.anyoPublicacion && Objects.equals(artista, other.artista)
        && estaPublicadoCD == other.estaPublicadoCD
        && Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
        && Objects.equals(titulo, other.titulo);
  }
  
  
  
}
