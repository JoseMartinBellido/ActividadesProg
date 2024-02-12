package unidad06.listas.ejercicio03.versionavanzada.reductores;

/**
 * Reductor Entero que suma los valores que se le proporcionan
 */
public class ReductorEnteroSuma implements ReductorEntero {
  
  // Suma
  private int suma;

  /**
   * Constructor. Inicia la suma a cero
   */
  public ReductorEnteroSuma() {
    suma = 0;
  }
  
  @Override
  public void add(int valor) {
    // Añade el valor a la suma
    suma += valor;
  }

  @Override
  public double getResultado() {
    return suma;
  }

}
