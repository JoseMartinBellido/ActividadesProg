package unidad06.listas.ejercicio03.versionavanzada.reductores;

/**
 * ReductorEntero que obtiene el mínimo de los valores añadidos
 */
public class ReductorEnteroMinimo implements ReductorEntero {
  
  // Mínimo hasta el momento
  private int minimo;
  // Si se ha iniciado o no el reductor
  private boolean iniciado;
  
  /**
   * Constructor. Marca como no iniciado
   */
  public ReductorEnteroMinimo() {
    // No se ha iniciado
    iniciado = false;
  }
  

  @Override
  public void add(int valor) {
    // Si no se ha iniciado o el valor es menor que el mínimo
    if (!iniciado || valor < minimo) {
      // Marca como iniciado (no importa si ya lo estaba)
      iniciado = true;
      // Y el mínimo es el valor
      minimo = valor;
    }
  }

  @Override
  public double getResultado() {
    // Si estaba iniciado
    if (iniciado) {
      // Devuelve el mínimo
      return minimo;
    } else {
      // No estaba iniciado. Lanza Excepcion
      throw new ReductorEnteroException();
    }
  }

}
