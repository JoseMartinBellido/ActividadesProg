package sol.unidad06.arraysobjetos.ejercicio02;


/**
 * Revista
 */
public class Revista extends Publicacion implements Cadenable {

  // Atributos
  // Número
  private int numero;
  
  public Revista(String titulo, int numero, int anyo) {
    this.titulo = titulo;
    this.numero = numero;
    this.anyo = anyo;
  }
  
  /**
   * Obtiene la cadena con los datos del objeto. El formato es:<br>
   * REVISTA Titulo: titulo, Número: numero, Año Publicación: anyo
   * @return Cadena con los datos del objeto
   */
  @Override
  public String obtenerCadena() {
    return "REVISTA Titulo: " + titulo + ", Número: " + numero + ", Año Publicación: " + anyo;
  }
}
