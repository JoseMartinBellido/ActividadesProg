package prog.unidad04.actividad405.ejercicio02;

public interface Figura {

  /**
   * Método que calcula el área de una figura
   * @return Devuelve el área.
   */
  double area();
  
  /**
   * Método que calcula el perímetro de una figura
   * @return Devuelve el perímetro.
   */
  double perimetro();
  
  /**
   * Indica si la figura es regular o no, es decir, si todos los lados son iguales
   * @return true si la figura es regular (todos los lados iguales), o false si no lo es (algún lado desigual)
   */
  boolean esRegular();
  
}
