package prog.unidad04.actividad403.ejercicio05;

public class Rectangulo {

  // ------------------------------ Bloque de atributos ------------------------------
  
  /**
   * Vértice inicial del rectángulo.
   */
  private Punto verticeInicial;
  
  /**
   * Punto. Vértice opuesto al inicial.
   */
  private Punto verticeOpuesto;
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Construye un rectángulo con un vértice inicial y el vértice opuesto al mismo en el rectángulo
   * @param verticeInicial Vértice inicial del rectángulo.
   * @param verticeOpuesto Vértice opuesto al inicial.
   */
  public Rectangulo(Punto verticeInicial, Punto verticeOpuesto) {
    this.verticeInicial = verticeInicial;
    this.verticeOpuesto = verticeOpuesto;
  }
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Calcula el perímetro del rectángulo
   * @return El perímetro del rectángulo
   */
  public double perimetro() {
    Punto verticeComplementario = calculaVerticeComplementario(verticeInicial,verticeOpuesto);
    
    double base = calculaLado(verticeInicial.getX(), verticeComplementario.getX());
    double altura = calculaLado(verticeComplementario.getY(), verticeOpuesto.getY());
    
    double perimetro = base * 2 + altura * 2;
    return perimetro;
  }
  
  /**
   * Calcula el área del rectángulo
   * @return El área del rectángulo
   */
  public double area() {
    Punto verticeComplementario = calculaVerticeComplementario(verticeInicial,verticeOpuesto);
    
    double base = calculaLado(verticeInicial.getX(), verticeComplementario.getX());
    double altura = calculaLado(verticeComplementario.getY(), verticeOpuesto.getY());
    
    double area = base * altura;
    return area;
  }
  
  /**
   * Determina si el rectángulo es también un cuadrado
   * @return true si es un cuadrado, false si no lo es
   */
  public boolean esCuadrado() {
    
    Punto verticeComplementario = calculaVerticeComplementario(verticeInicial,verticeOpuesto);
    
    double base = calculaLado(verticeInicial.getX(), verticeComplementario.getX());
    double altura = calculaLado(verticeComplementario.getY(), verticeOpuesto.getY());
    
    return base == altura;
  }
  
  // Método para simplificar el cálculo de lados
  private double calculaLado(double coordenada1, double coordenada2) {
    
    return Math.abs(coordenada1 - coordenada2);
  }
  
  // Método para calcular el vértice complementario
  private Punto calculaVerticeComplementario(Punto punto1, Punto punto2) {
    return new Punto(punto2.getX(), punto1.getY());
  }
}
