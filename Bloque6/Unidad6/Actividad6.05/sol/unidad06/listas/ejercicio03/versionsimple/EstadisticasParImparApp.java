package unidad06.listas.ejercicio03.versionsimple;

import java.util.ArrayList;
import java.util.List;
import unidad06.listas.ejercicio01.ListaEnterosUtils;

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
    List<Integer> listaPares = filtraListaPares(listaEnteros);
    List<Integer> listaImpares = filtraListaImpares(listaEnteros);
   
    // Las imprime
    System.out.println("La lista de los pares es: " + ListaEnterosUtils.generaCadena(listaPares));
    System.out.println("La lista de los impares es: " + ListaEnterosUtils.generaCadena(listaImpares));
    
    // Calcula la suma, media, maximo y minimo
    int sumaPares = calculaSumaLista(listaPares);
    int sumaImpares = calculaSumaLista(listaImpares);
    double mediaPares = (listaPares.size() > 0) ? (double)sumaPares / listaPares.size() : 0;  
    double mediaImpares = (listaImpares.size() > 0) ? (double)sumaImpares / listaImpares.size() : 0;  
    int maximoPares = calculaMaximoLista(listaPares);
    int maximoImpares = calculaMaximoLista(listaImpares);
    int minimoPares = calculaMinimoLista(listaPares);
    int minimoImpares = calculaMinimoLista(listaImpares);

    // Mostramos los resultados
    try {
      System.out.println("La suma de los elementos de la lista par es de " + sumaPares);
      System.out.println("La media es de " + mediaPares);
      System.out.println("El mínimo vale " + minimoPares + " y el máximo vale "
        + maximoPares);
    } catch (IllegalArgumentException e) {
      // Si la lista está vacía la media es 0 y no hay máximo ni mínimo
      System.out.println("La media vale 0 y no hay máximo ni mínimo porque la lista está vacía");
    }
    try {
      System.out.println("La suma de los elementos de la lista impar es de " + sumaImpares);
      System.out.println("La media es de " + mediaImpares);
      System.out.println("El mínimo vale " + minimoImpares + " y el máximo vale "
        + maximoImpares);
    } catch (IllegalArgumentException e) {
      // Si la lista está vacía la media es 0 y no hay máximo ni mínimo
      System.out.println("La media vale 0 y no hay máximo ni mínimo porque la lista está vacía");
    }
  }

  /**
   * Obtiene una nueva lista con los elementos pares de la lista proporcionada
   * @param lista Lista con los elementos a procesar
   * @return Lista con los elementos de la lista original que son pares, en el mismo orden
   */
  private static List<Integer> filtraListaPares(List<Integer> lista) {
    // Crea la lista vacía
    List<Integer> resultado = new ArrayList<>();
    
    // Para cada elemento de la lista original
    for (int elemento: lista) {
      // Si el elemento es par
      if (elemento % 2 == 0) {
        // Lo añade a la salida
        resultado.add(elemento);
      }
    }
    // Devuelve el resultado
    return resultado;
  }

  /**
   * Obtiene una nueva lista con los elementos impares de la lista proporcionada
   * @param lista Lista con los elementos a procesar
   * @return Lista con los elementos de la lista original que son impares, en el mismo orden
   */
  private static List<Integer> filtraListaImpares(List<Integer> lista) {
    // Crea la lista vacía
    List<Integer> resultado = new ArrayList<>();
    
    // Para cada elemento de la lista original
    for (int elemento: lista) {
      // Si el elemento es par
      if (elemento % 2 != 0) {
        // Lo añade a la salida
        resultado.add(elemento);
      }
    }
    // Devuelve el resultado
    return resultado;
  }

  /**
   * Calcula la suma de los elementos de una lista de enteros
   * @param lista Lista con los enteros
   * @return Suma de la lista
   */
  private static int calculaSumaLista(List<Integer> lista) {
    // Inicia la suma
    int suma = 0;
    // Para cada elemento de la lista
    for (int elemento:lista) {
      // Lo añade a la suma
      suma += elemento;
    }
    // Devuelve el resultado
    return suma;
  }

  /**
   * Calcula el valor mínimo de una lista de enteros
   * @param lista Lista con los valores enteros
   * @return Valor mínimo de la lista
   * @throws IllegalArgumentException Si la lista es null o está vacía
   */
  private static int calculaMinimoLista(List<Integer> lista) {
    // Si la lista no está vacía o es nula
    if (lista != null && lista.size() > 0) {
      // Inicia el minimo
      int minimo = lista.get(0);
      // Para cada elemento de la lista
      for (int elemento:lista) {
        // Si es menor que el mínimo
        if (elemento < minimo) {
          // Es el nuevo mínimo
          minimo = elemento;
        }
      }
      // Devuelve el resultado
      return minimo;
    } else {
      // Argumento ilegal
      throw new IllegalArgumentException();
    }
  }

  /**
   * Calcula el valor máximo de una lista de enteros
   * @param lista Lista con los valores enteros
   * @return Valor máximo de la lista
   * @throws IllegalArgumentException Si la lista es null o está vacía
   */
  private static int calculaMaximoLista(List<Integer> lista) {
    // Si la lista no está vacía o es nula
    if (lista != null && lista.size() > 0) {
      // Inicia el máximo
      int maximo = lista.get(0);
      // Para cada elemento de la lista
      for (int elemento:lista) {
        // Si es mayor que el máximo
        if (elemento > maximo) {
          // Es el nuevo máximo
          maximo = elemento;
        }
      }
      // Devuelve el resultado
      return maximo;
    } else {
      // Argumento ilegal
      throw new IllegalArgumentException();
    }
  }

}
