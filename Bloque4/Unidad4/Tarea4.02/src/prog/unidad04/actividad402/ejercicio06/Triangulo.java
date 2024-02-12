package prog.unidad04.actividad402.ejercicio06;

public class Triangulo {

  // ------------------------------ Bloque de atributos ------------------------------
  
  /**
   * Primer vértice del triángulo.
   */
  private Punto vertice1;
  
  /**
   * Segundo vértice del triángulo.
   */
  private Punto vertice2;
  
  /**
   * Tercer vértice del triángulo.
   */
  private Punto vertice3;

  
  // ------------------------------ Bloque de constructores ------------------------------
  
  public Triangulo (Punto vertice1, Punto vertice2, Punto vertice3) {
    this.vertice1 = vertice1;
    this.vertice2 = vertice2;
    this.vertice3 = vertice3;

  } 
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Calcula el perímetro del triángulo a partir de los tres vértices.
   * @return El perímetro del triángulo
   */
  public double perimetro() {
    
    // Calculamos la longitud de cada lado 
    double lado1 = calculaLado(vertice1, vertice2);
    double lado2 = calculaLado(vertice2, vertice3);
    double lado3 = calculaLado(vertice3, vertice1);
    
    // Calculamos y devolvemos el perímetro
    return lado1 + lado2 + lado3;
  }
  
  /**
   * Calcula el área del triángulo en función de los tres vértices usando el método de Herón
   * @return El área del triángulo
   */
  public double area() {
    // Calculamos el semiperimetro
    double lado1 = calculaLado(vertice1, vertice2);
    double lado2 = calculaLado(vertice2, vertice3);
    double lado3 = calculaLado(vertice3, vertice1);
    
    double semiperimetro = (lado1 + lado2 + lado3) / 2;
    
    return Math.sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));
  }
  
  // Método para simplificar el cálculo de lados
  private double calculaLado(Punto punto1, Punto punto2) {
    
    return Math.sqrt (Math.pow (punto2.getX() - punto1.getX(), 2) + Math.pow (punto2.getY() - punto1.getY(), 2));
  }
  
}
