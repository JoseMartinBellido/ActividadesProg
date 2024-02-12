package unidad06.listas.ejercicio02;

import java.util.List;
import prog.unidad06.listas.ejercicio01.ListaEnterosUtils;

/**
 * Crea una lista de números aleatorios y calcula suma, máximo, mínimo
 * y media
 */
public class EstadisticasApp {

  // Longitud mínima y máxima de la lista de números aleatorios
  private static final int LONGITUD_MINIMA = 10;
  private static final int LONGITUD_MAXIMA = 20;
  // Rango de valores entre los que elegir para rellenar la lista
  private static final int RANGO_MINIMO = 0;
  private static final int RANGO_MAXIMO = 100;

  public static void main(String[] args) {
    // Cabecera
    System.out.println("ESTADÍSTICAS");
    
    // Crea la lista
    List<Integer> listaEnteros = ListaEnterosUtils.generaListaEnterosAleatorios(LONGITUD_MINIMA,
      LONGITUD_MAXIMA, RANGO_MINIMO, RANGO_MAXIMO);
    
    // La imprime
    String listaImprimible = ListaEnterosUtils.generaCadena(listaEnteros);
    System.out.println("La lista generada es: " + listaImprimible);
    
    // Recorre la lista y calcula la suma, mínimo y máximo
    // Inicialmente los dos últimos valen lo mismo que el primer elemento de la lista
    // Dado que la lista tiene entre 10 y 20 elementos está garantizado que al menos
    // uno tiene
    // La suma se inicia a 0
    int suma = 0;
    int minimo = listaEnteros.get(0);
    int maximo = minimo;
    
    // Para cada elemento de la lista
    for (int elemento: listaEnteros) {
      // Lo añade a la suma
      suma += elemento;
      // Si es mayor que el máximo
      if (elemento > maximo) {
        // Es el nuevo máximo
        maximo = elemento;
      }
      // Si es menor que el mínimo
      if (elemento < minimo) {
        // Es el nuevo mínimo
        minimo = elemento;
      }
    }
    // Calculamos la media a partir de la suma y la longitud de la lista
    double media = (double)suma / listaEnteros.size();
    
    // Imprimimos los resultados
    System.out.println("La suma de los elementos vale " + suma + ", su media vale "
      + media + ". El valor mínimo es " + minimo + " y el máximo es " + maximo + ".");
  }
}
