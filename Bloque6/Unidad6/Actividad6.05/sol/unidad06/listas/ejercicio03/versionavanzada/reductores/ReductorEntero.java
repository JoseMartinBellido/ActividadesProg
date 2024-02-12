package unidad06.listas.ejercicio03.versionavanzada.reductores;

/**
 * Un reductor recibe varios valores y los reduce a un único resultado<br>
 * Por ejemplo, la media, suma, varianza, número de elementos, etc.
 */
public interface ReductorEntero {

  /**
   * Añade un nuevo valor a laa reducción
   * @param valor Valor a añadir a la reducción
   */
  void add(int valor);
  
  /**
   * Obtiene el resultado con los valores introducidos hasta el momento
   * @return Resultado de la reducción con los valores introducidos hasta el momento
   * @throws ReductorEnteroException Si no se tienen datos suficientes para hacer la reducción<br>
   *   En general es porque no se ha proporcionado ningún valor aún al reductor
   */
  double getResultado();
}
