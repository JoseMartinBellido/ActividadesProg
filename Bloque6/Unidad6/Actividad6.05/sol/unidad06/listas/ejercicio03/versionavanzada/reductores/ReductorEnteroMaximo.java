package unidad06.listas.ejercicio03.versionavanzada.reductores;

/**
 * ReductorEntero que obtiene el máximo de los valores añadidos
 */
public class ReductorEnteroMaximo implements ReductorEntero {
  
  // Máximo hasta el momento
  private int maximo;
  // Si se ha iniciado o no el reductor
  private boolean iniciado;
  
  /**
   * Constructor. Marca como no iniciado
   */
  public ReductorEnteroMaximo() {
    // No se ha iniciado
    iniciado = false;
  }
  
  @Override
  public void add(int valor) {
    // Si no se ha iniciado o el valor es mayor que el máximo
    if (!iniciado || valor > maximo) {
      // Marca como iniciado (no importa si ya lo estaba)
      iniciado = true;
      // Y el máximo es el valor
      maximo = valor;
    }
  }

  @Override
  public double getResultado() {
    // Si estaba iniciado
    if (iniciado) {
      // Devuelve el máximo
      return maximo;
    } else {
      // No estaba iniciado. Lanza Excepcion
      throw new ReductorEnteroException();
    }
  }

}
