package prog.unidad04.actividad402.ejercicio09;

public class Fraccion {
  
  // ------------------------------ Bloque de atributos ------------------------------
  /**
   * Numerador de la fracción
   */
  private int numerador;
  
  /**
   * Denominador de la fracción
   */
  private int denominador;
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Construye una fracción con un numerador y denominador.
   * @param numerador Numerador de la fracción
   * @param denominador Denominador de la fracción. Debe ser distinto a cero
   */
  public Fraccion(int numerador, int denominador) {
    if (denominador == 0) {
      denominador = 1;
      System.out.println("El denominador no puede ser cero.");
    }
    
    this.numerador = numerador;
    this.denominador = denominador;
  }
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Calcula la suma de dos fracciones
   * @param fraccion Fracción para sumar 
   * @return Devuelve la suma de las dos fracciones poniendo como denominador común el producto entre ambos
   */
  public Fraccion suma(Fraccion fraccion) {
    
    // Para hacer la suma, primero ponemos el signo en el numerador
    this.arreglaSigno();
    fraccion.arreglaSigno();
    
    // Ponemos el mismo denominador multiplicándolos y sumamos
    
    int num = numerador * fraccion.denominador + fraccion.numerador * denominador;
    int den = denominador * fraccion.denominador;
    
    return new Fraccion(num, den);
  }
  
  /**
   * Calcula la resta de dos fracciones
   * @param fraccion Fracción para restar
   * @return Devuelve la resta de las dos fracciones poniendo como denominador común el producto entre ambos
   */
  public Fraccion resta(Fraccion fraccion) {
    
 // Para hacer la resta, primero ponemos el signo en el numerador
    this.arreglaSigno();
    fraccion.arreglaSigno();
    
    // Ponemos el mismo denominador multiplicándolos y restamos
    
    int num = numerador * fraccion.denominador - fraccion.numerador * denominador;
    int den = denominador * fraccion.denominador;
    
    return new Fraccion(num, den);
    
  }
  
  /**
   * Calcula el producto de las dos fracciones
   * @param fraccion Fracción para multiplicar
   * @return Devuelve el producto de las dos fracciones
   */
  public Fraccion multiplica(Fraccion fraccion) {
    
    // Multiplicamos las fracciones en línea
    
    int num = numerador * fraccion.numerador;
    int den = denominador * fraccion.denominador;
    
    return new Fraccion(num,den);
  }
  
  /**
   * Calcula la división de las dos fracciones
   * @param fraccion Fracción para dividir
   * @return Devuelve la división de las dos fracciones
   */
  public Fraccion divide(Fraccion fraccion) {
    
    // Multiplicamos las fracciones en cruz
    
    int num = numerador * fraccion.denominador;
    int den = denominador * fraccion.numerador;
    
    return new Fraccion(num,den);
    
  }
  
/**
 * Método que simplifica la fracción todo lo posible.
 */
  public void simplifica() {
    
    arreglaSigno();
    
    int divisor = 2;
    
    while (divisor <= numerador && divisor <= denominador) {
      if (numerador % divisor == 0 && denominador % divisor == 0) {
        numerador = numerador / divisor;
        denominador = denominador / divisor;
      } else
        divisor++;      
    }
  }
  
  /**
   * Interpreta la fracción como cadena de caracteres "n / d" siendo n el numerador y d el denominador
   * @return La fración en formato "n / d"
   */
  public String obtieneString() {
    return numerador + " / " + denominador;
  }
  
  // Método para arreglar el signo de la fracción
  private void arreglaSigno() {
    if (numerador < 0 && denominador < 0) {
      numerador = Math.abs(numerador);
      denominador = Math.abs(denominador);
    
    } else if (numerador < 0 || denominador < 0) {
      numerador = (-1) * Math.abs(numerador);
      denominador = Math.abs(denominador);
    }

  } 

  // Getters
  
  public int getNumerador() {
    return numerador;
  }

  public int getDenominador() {
    return denominador;
  }
  

  
  
  
}
