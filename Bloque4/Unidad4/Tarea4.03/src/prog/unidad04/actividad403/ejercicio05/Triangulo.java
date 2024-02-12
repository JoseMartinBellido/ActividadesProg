package prog.unidad04.actividad403.ejercicio05;

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
  
  /**
   * Constructor que forma un triángulo a partir de 3 vértices de la clase Punto
   * @param vertice1 Primer vértice del triángulo
   * @param vertice2 Segundo vértice del triángulo
   * @param vertice3 Tercer vértice del triángulo
   * @throws FiguraException En caso de que los 3 vértices se encuentren alineados
   */
  public Triangulo (Punto vertice1, Punto vertice2, Punto vertice3) {
    this.vertice1 = vertice1;
    this.vertice2 = vertice2;
    this.vertice3 = vertice3;

    compruebaAlineamiento();
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
  
  // Método para comprobar la alineación de los puntos
  private void compruebaAlineamiento() {
    
    // Los 3 puntos estarán alineados si los vectores tienen la misma dirección, es decir, cuando sus coordenadas son proporcionales.
    
    double primeraParteIgualdad = (vertice2.getX() - vertice1.getX()) / (vertice3.getX() - vertice2.getX());
    
    double segundaParteIgualdad = (vertice2.getY() - vertice1.getY()) / (vertice3.getY() - vertice2.getY());
    
    if (primeraParteIgualdad == segundaParteIgualdad)
      throw new FiguraException();

  }
  
}