package unidad06.listas.ejercicio03.versionavanzada.filtros;

/**
 * Filtra los números impares
 */
public class FiltroImpares implements FiltroEnteros {

  @Override
  public boolean cumple(int valor) {
    // Devuelve true si el número es impar. false en caso contrario
    return valor % 2 != 0;
  }

}
