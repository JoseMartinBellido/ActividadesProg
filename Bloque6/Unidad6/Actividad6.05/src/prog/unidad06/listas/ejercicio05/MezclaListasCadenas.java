package prog.unidad06.listas.ejercicio05;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades para cadenas cuya principal funcionalidad es mezclar listas
 * @author Jose
 *
 */
public class MezclaListasCadenas {

  /**
   * Método que obtiene la unión entre dos listas sin repetir elementos entre una y otra. 
   * Primero se obtendrán los elementos de la primera lista, seguidos por los de la segunda en dicho orden
   * @param lista Primera lista a unir
   * @param otraLista Segunda lista a unir
   * @return La unión entre ambas listas
   * @throws IllegalArgumentException en caso de que alguna de las listas sea nula. 
   */
  public static List<String> union(List<String> lista, List<String> otraLista) {
    
    if (lista == null || otraLista == null) {
      throw new IllegalArgumentException();
    }
    
    // Creamos la lista resultado
    List<String> listaUnion = new ArrayList<>();
    // Insertamos los elementos de la lista
    for (String cadena : lista) {
      if (!listaUnion.contains(cadena)) {
        listaUnion.add(cadena);
      }
    }
    // Insertamos los elementos de la otraLista
    for (String cadena : otraLista) {
      if (!listaUnion.contains(cadena)) {
        listaUnion.add(cadena);
      }
    }
    // Devolvemos resultado
    return listaUnion;
  }
  
  /**
   * Método que obtiene la intersección entre dos listas (elementos que aparezcan sólo en ambas)
   * Cada elemento sólo aparecerá una vez en el orden que aparecen en la primera lista
   * @param lista Primera lista  
   * @param otraLista Segunda lista
   * @return Una lista con los elementos generados al realizar la intersección entre las listas
   * @throws IllegalArgumentException en caso de que alguna de las listas sea nula. 
   */
  public static List<String> interseccion (List<String> lista, List<String> otraLista) {
    
    if (lista == null || otraLista == null) {
      throw new IllegalArgumentException();
    }
    
    List<String> listaInterseccion = new ArrayList<>();
    // Recorremos los elementos de la primera lista y vemos si están en la segunda (o repetidos)
    for (String cadena : lista) {
      if (otraLista.contains(cadena) && !listaInterseccion.contains(cadena)) {
        listaInterseccion.add(cadena);
      }
    }
    // Devolvemos resultado
    return listaInterseccion;
  } 
  
  /**
   * Método que obtiene la diferencia entre dos listas (elementos que estén en la primera lista pero no en la segunda)
   * Cada elemento sólo aparecerá una vez en el orden que aparecen en la primera lista
   * @param lista Primera lista  
   * @param otraLista Segunda lista
   * @return Una lista con los elementos generados al realizar la diferencia entre las listas
   * @throws IllegalArgumentException en caso de que alguna de las listas sea nula. 
   */
  public static List<String> diferencia (List<String> lista, List<String> otraLista) {
    
    if (lista == null || otraLista == null) {
      throw new IllegalArgumentException();
    }
    
    List<String> listaDiferencia = new ArrayList<>();
    // Recorremos los elementos de la primera lista y vemos si están en la segunda (o repetidos)
    for (String cadena : lista) {
      if (!otraLista.contains(cadena) && !listaDiferencia.contains(cadena)) {
        listaDiferencia.add(cadena);
      }
    }
    // Devolvemos resultado
    return listaDiferencia;
  } 
  
}
