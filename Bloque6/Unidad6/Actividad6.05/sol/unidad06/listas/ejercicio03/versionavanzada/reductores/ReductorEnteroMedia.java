package unidad06.listas.ejercicio03.versionavanzada.reductores;

/**
 * ReductorEntero que calcula la media de los valores
 */
public class ReductorEnteroMedia implements ReductorEntero {

  // Suma de los valores
  private double suma;
  // Número de valores introducidos
  private int valores;
  
  /**
   * Constructor. Inicia la suma y el número de valores a cero
   */
  public ReductorEnteroMedia() {
    suma = 0;
    valores = 0;
  }
  
  @Override
  public void add(int valor) {
    // Lo añade a la suma
    suma += valor;
    // Y un valor mas
    valores++;
  }

  @Override
  public double getResultado() {
    // Si el número de valores es mayor que cero
    if (valores > 0) {
      // Devuelve la media
      return suma / valores;
    } else {
      // Devuelve cero
      return 0;
    }
  }

}
