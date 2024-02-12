package prog.unidad04.actividad403.ejercicio05;

public class Punto {

  // ------------------------------ Bloque de atributos ------------------------------
  
  /**
   * Coordenada X del punto.
   */
  private double x;
  
  /**
   * double. Coordenada Y del punto.
   */
  private double y;
  
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Constructor con los parámetros coordenada.
   * @param x Coordenada X del punto
   * @param y Coordenada Y del punto
   */
  public Punto(double x, double y) {
    this.x = x;
    this.y = y;
    
  }
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Método para obtener la coordenada X del punto.
   * @return Coordenada X
   */
  public double getX() {
    return x;
  }

  /**
   * Método para obtener la coordenada X del punto.
   * @return Coordenada Y
   */
  public double getY() {
    return y;
  }
  
}
