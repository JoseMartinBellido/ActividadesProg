package prog.unidad04.actividad403.ejercicio05;

public class Circulo {

  // ------------------------------ Bloque de atributos ------------------------------
  
  /**
   * Centro del círculo
   */
  private Punto centro;
  
  /**
   * Longitud del radio del círculo
   */
  private double radio;
 
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Construye un círculo a partir del centro y del radio
   * @param centro Punto de coordenadas que representa el centro del círculo
   * @param radio Radio del círculo
   * @throws FiguraException En caso de que el radio sea menor a cero.
   */
  public Circulo(Punto centro, double radio) {
    this.centro = centro;
    if (radio < 0) {
      throw new FiguraException();
    } else {
      this.radio = radio;
    }

  }
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Calcula el perímetro del círculo en función del radio.
   * @return El perímetro del círculo.
   */
  public double perimetro() {
    
    return 2 * Math.PI * radio;
  }
  
  /**
   * Calcula el área del círculo en función del radio.
   * @return El área del círculo.
   */
  public double area() {
    
    return Math.PI * radio * radio;
  }
  
}