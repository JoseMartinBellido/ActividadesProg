package unidad06.listas.ejercicio03.versionavanzada.filtros;

/**
 * Filtro de números enteros. Decide si un número entero cumple un criterio o no
 */
public interface FiltroEnteros {

  /**
   * Decide si el valor cumple o no el criterio del filtro  
   * @param valor Valor a comprobar
   * @return true si el valor cumple el criterio del filtro. false si no
   */
  boolean cumple(int valor);
}
