package unidad06.listas.ejercicio03.versionavanzada;

import java.util.ArrayList;
import java.util.List;

import unidad06.listas.ejercicio01.ListaEnterosUtils;
import unidad06.listas.ejercicio03.versionavanzada.reductores.*;
import unidad06.listas.ejercicio03.versionavanzada.filtros.*;

/**
 * Crea listas a partir de una aleatoria y el criterio par / impar
 * Luego procesa ambas listas y extrae estadísticas
 */
public class EstadisticasParImparApp {

  // Longitud mínima y máxima de la lista de números aleatorios
  private static final int LONGITUD_MINIMA = 10;
  private static final int LONGITUD_MAXIMA = 20;
  // Rango de valores entre los que elegir para rellenar la lista
  private static final int RANGO_MINIMO = 0;
  private static final int RANGO_MAXIMO = 100;

  public static void main(String[] args) {
    // Cabecera
    System.out.println("ESTADÍSTICAS II");

    // Crea la lista
    List<Integer> listaEnteros = ListaEnterosUtils.generaListaEnterosAleatorios(LONGITUD_MINIMA,
      LONGITUD_MAXIMA, RANGO_MINIMO, RANGO_MAXIMO);
    
    // La imprime
    System.out.println("La lista generada es: " + ListaEnterosUtils.generaCadena(listaEnteros));
    
    // Obtiene la lista de pares e impares
    List<Integer> listaPares = filtraLista(listaEnteros, new FiltroPares());
    List<Integer> listaImpares = filtraLista(listaEnteros, new FiltroImpares());
   
    // Las imprime
    System.out.println("La lista de los pares es: " + ListaEnterosUtils.generaCadena(listaPares));
    System.out.println("La lista de los impares es: " + ListaEnterosUtils.generaCadena(listaImpares));
    
    // Calcula la suma, media, maximo y minimo
    // Vamos a hacerlo empleando reductores que son clases que toman una serie de valores
    // y calculan un resultado reducido (reductor) o resumen de todos los datos
    // Obtenemos un reductor por operacion y lista
    ReductorEntero sumaPares = new ReductorEnteroSuma();
    ReductorEntero mediaPares = new ReductorEnteroMedia();
    ReductorEntero maximoPares = new ReductorEnteroMaximo();
    ReductorEntero minimoPares = new ReductorEnteroMinimo();
    ReductorEntero sumaImpares = new ReductorEnteroSuma();
    ReductorEntero mediaImpares = new ReductorEnteroMedia();
    ReductorEntero maximoImpares = new ReductorEnteroMaximo();
    ReductorEntero minimoImpares = new ReductorEnteroMinimo();
    
    // Para cada elemento de la lista de los pares
    for (int elemento: listaPares) {
      // Añadimos el elemento a los reductores
      sumaPares.add(elemento);
      mediaPares.add(elemento);
      maximoPares.add(elemento);
      minimoPares.add(elemento);
    }

    // Para cada elemento de la lista de los impares
    for (int elemento: listaImpares) {
      // Añadimos el elemento a los reductores
      sumaImpares.add(elemento);
      mediaImpares.add(elemento);
      maximoImpares.add(elemento);
      minimoImpares.add(elemento);
    }
    
    // Mostramos los resultados
    try {
      System.out.println("La suma de los elementos de la lista par es de "
        + (int)sumaPares.getResultado());
      System.out.println("La media es de "
        + mediaPares.getResultado() + ".");
      System.out.println("El mínimo vale "
        + (int)minimoPares.getResultado() + " y el máximo vale "
        + (int)maximoPares.getResultado());
    } catch (ReductorEnteroException e) {
      // No existe media, máximo y mínimo
      System.out.println("La media vale 0 y no hay máximo ni mínimo porque la lista está vacía");
    }
    try {
      System.out.println("La suma de los elementos de la lista impar es de "
          + (int)sumaImpares.getResultado());
        System.out.println("La media es de "
          + mediaImpares.getResultado() + ".");
        System.out.println("El mínimo vale "
          + (int)minimoImpares.getResultado() + " y el máximo vale "
          + (int)maximoImpares.getResultado());
    } catch (ReductorEnteroException e) {
      // No existe media, máximo y mínimo
      System.out.println("La media vale 0 y no hay máximo ni mínimo porque la lista está vacía");
    }
  }

  /**
   * Crea una nueva lista con los elementos de la original que cumplan el filtro
   * @param lista Lista a filtrar
   * @param filtro FiltroEnteros a utilizar para filtrar los valores 
   * @return Nueva lista con los valores que cumplen el filtro
   */
  private static List<Integer> filtraLista(List<Integer> lista,
      FiltroEnteros filtro) {
    // Crea la lista vacía
    List<Integer> resultado = new ArrayList<>();
    
    // Para cada elemento de la lista original
    for (int elemento: lista) {
      // Si el elemento cumple el filtro
      if (filtro.cumple(elemento)) {
        // Lo añade a la salida
        resultado.add(elemento);
      }
    }
    // Devuelve el resultado
    return resultado;
  }

}
