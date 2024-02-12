package prog.unidad04.actividad404.ejercicio03;

/**
 * Clase definida para el cálculo del mayor y el menor de una secuencia de números enteros
 * @author jose
 * @version 1.0
 */
public class MayorMenor {

  // Mayor número introducido
  private int mayor;
  
  // Menor número introducido
  private int menor;
  
  /**
   * Construye la estructura de la clase con un valor inicial para el mayor y el menor
   * @param numeroInicial Número de comienzo del constructor. El mayor y el menor serán este número de comienzo.
   */
  public MayorMenor(int numeroInicial) {
    // Igualamos el mayor y el menor al inicial para comenzar
    mayor = numeroInicial;
    menor = numeroInicial;
  }

  /**
   * Método que añade un número a la secuencia de enteros
   * @param numero Número añadido a la secuencia de enteros
   */
  public void add(int numero) {
    
    if (numero < menor) {
      menor = numero;
    }
    
    if (numero > mayor) {
      mayor = numero;
    }
     
  }
  
  /**
   * Método que devuelve el mayor número de toda la secuencia de enteros
   * @return El mayor
   */
  public int getMayor() {
    return mayor;
  }

  /**
   * Método que devuelve el menor número de toda la secuencia de enteros
   * @return El menor
   */
  public int getMenor() {
    return menor;
  }
  
  
  
  
  
  
}
