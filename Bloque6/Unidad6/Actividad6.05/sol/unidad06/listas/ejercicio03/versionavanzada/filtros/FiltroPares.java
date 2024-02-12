package unidad06.listas.ejercicio03.versionavanzada.filtros;

/**
 * Filtra los números pares
 */
public class FiltroPares implements FiltroEnteros {

  @Override
  public boolean cumple(int valor) {
    // Devuelve true si el número es par o false si no lo es.
    return valor % 2 == 0;
  }

}
