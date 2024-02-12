package unidad06.listas.ejercicio05;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilidades para mezclar listas
 */
public class MezclaListasCadenas {
  
  /**
   * Obtiene la lista unión de dos listas cualquiera.<br>
   * La lista unión contiene los elementos que estén en la primera lista o en 
   * la segunda o en ambas. Un elemento determinado sólo aparecerá una vez en
   * el resultado<br>
   * En el resultado aparecerán primero los valores presentes en la primera lista
   * seguidos de aquellos presentes en la segunda, en el mismo orden en que
   * aparecen en ambas
   * @param lista Primera lista a unir
   * @param otraLista Segunda lista a unir
   * @return Lista con los elementos presentes en la primera lista o en la
   * segunda o en ambas.
   * @throws IllegalArgumentException Si alguna de las listas es null
   */
  public static List<String> union(List<String> lista, List<String> otraLista) {

    // Si ninguna de las dos listas es null
    if (lista != null && otraLista != null) {
      // Creamos el resultado
      List<String> resultado = new ArrayList<>();
      // Para cada elemento de la primera lista
      for (String elemento: lista) {
        // Si no está en el resultado lo añade
        if (!resultado.contains(elemento)) {
          resultado.add(elemento);
        }
      }
      // Ahora pasamos a los elementos de la segunda lista
      for (String elemento: otraLista) {
        // Si no está en el resultado, se añade
        if (!resultado.contains(elemento)) {
          resultado.add(elemento);
        }
      }
      
      // Devolvemos el resultado
      return resultado;
    } else {
      // Alguna de las listas es null
      throw new IllegalArgumentException();
    }
  }

  /**
   * Obtiene la lista intersección de otras dos listas.<br>
   * La intersección contiene aquellos elementos que están en ambas listas.<br>
   * Un elemento determinado aparecerá sólo una vez en el resultado<br>
   * En el resultado aparecerán los valores en el mismo orden en que aparecen
   * en la primera lista
   * @param lista Primera lista
   * @param otraLista Segunda lista
   * @return Nueva lista con la intersección de las dos proporcionadas
   * @throws IllegalArgumentException Si alguna de las lista es null
   */
  public static List<String> interseccion(List<String> lista, List<String> otraLista) {
    // Si ninguna de las listas es null
    if (lista != null && otraLista != null) {
      // Creamos el resultado
      List<String> resultado = new ArrayList<>();
      // Para cada elemento de la primera lista
      for (String elemento: lista) {
        // Si el elemento está en la otra lista y no está en el resultado
        if (otraLista.contains(elemento) && !resultado.contains(elemento)) {
          // Lo añadimos al resultado
          resultado.add(elemento);
        }
      }
      // Devolvemos el resultado
      return resultado;
    } else {
      // Alguna de las listas es null
      throw new IllegalArgumentException();
    }
  }

  /**
   * Obtiene la lista diferencia de otras dos listas.<br>
   * La diferencia contiene aquellos elementos que están en la primera lista
   * pero no en la segunda.<br>
   * Un elemento determinado aparecerá sólo una vez en el resultado<br>
   * En el resultado apareceran los valores en mismo el orden en que aparecen
   * en la primera lista
   * @param lista Primera lista
   * @param otraLista Segunda lista
   * @return Nueva lista con la diferencia de las dos proporcionadas
   * @throws IllegalArgumentException Si alguna de las lista es null
   */
  public static List<String> diferencia(List<String> lista, List<String> otraLista) {
    // Si ninguna de las listas es null
    if (lista != null && otraLista != null) {
      // Creamos el resultado
      List<String> resultado = new ArrayList<>();
      // Para cada elemento de la primera lista
      for (String elemento: lista) {
        // Si el elemento no está en la otra lista ni en el resultado
        if (!otraLista.contains(elemento) && !resultado.contains(elemento)) {
          // Lo añadimos al resultado
          resultado.add(elemento);
        }
      }
      // Devolvemos el resultado
      return resultado;
    } else {
      // Alguna de las listas es null
      throw new IllegalArgumentException();
    }
  }
}
