package unidad06.listas.ejercicio06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import prog.unidad06.listas.ejercicio05.MezclaListasCadenas;

/**
 * Solicita dos listas y realiza la tres mezclas (unión, intersección y diferencia)
 */
public class PruebaMezclaListasApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("MEZCLA DE LISTAS");
    
    // Solicitamos la primera lista de palabras
    System.out.println("Introduce la primera lista de palabras");
    System.out.println("Introduce palabras, una por línea. Línea vacía para terminar");
    List<String> lista1 = leeListaPalabras(sc);
    
    // Y después la segunda
    System.out.println("Introduce la segunda lista de palabras");
    System.out.println("Introduce palabras, una por línea. Línea vacía para terminar");
    List<String> lista2 = leeListaPalabras(sc);
    
    // Imprime ambas listas por pantalla
    System.out.print("La primera lista es: ");
    imprimeListaPalabras(lista1);
    System.out.println();
    System.out.print("Y la segunda es: ");
    imprimeListaPalabras(lista2);
    System.out.println();

    // Calcula la unión, intersección y diferencia utilizando MezclaListaCadenas
    List<String> union = MezclaListasCadenas.union(lista1, lista2);
    List<String> interseccion = MezclaListasCadenas.interseccion(lista1, lista2);
    List<String> diferencia = MezclaListasCadenas.diferencia(lista1, lista2);
    List<String> diferencia2 = MezclaListasCadenas.diferencia(lista2, lista1);
    
    // Imprimimos los resultados
    System.out.print("La unión de ambas listas es: ");
    imprimeListaPalabras(union);
    System.out.println();
    System.out.print("La intersección de ambas listas es: ");
    imprimeListaPalabras(interseccion);
    System.out.println();
    System.out.print("La diferencia de la primera lista menos la segunda es: ");
    imprimeListaPalabras(diferencia);
    System.out.println();
    System.out.print("La diferencia de la segunda lista menos la primera es: ");
    imprimeListaPalabras(diferencia2);
    System.out.println();
  }

  /**
   * Lee una lista de palabras desde teclado. Se leen palabras hasta
   * que se introduce la cadena vacía
   * @param sc Scanner a usar para leer desde teclado
   * @return Lista de palabras introducidas (puede ser vacía)
   */
  private static List<String> leeListaPalabras(Scanner sc) {
    // Creamos la lista a devolver
    List<String> resultado = new ArrayList<>();
    
    // Mientras se introduzcan palabras
    String palabra = "";
    do {
      // Lee la palabra
      palabra = sc.nextLine();
      // Si no es vacía
      if (!palabra.isBlank()) {
        // La añade a la lista
        resultado.add(palabra);
      }
    } while (!palabra.isBlank());
    // Devolvemos el resultado
    return resultado;
  }

  /**
   * Imprime una lista de cadenas por pantalla
   * @param lista Lista a imprimir
   */
  private static void imprimeListaPalabras(List<String> lista) {
    // Imprimimos el corchete de apertura
    System.out.print("[");
    // Para cada palabra
    for (int i = 0; i < lista.size(); i++) {
      // Si no es la primera
      if (i != 0) {
        // Imprimimos una coma para separar de la anterior
        System.out.print(", ");
      }
      // Imprimimos la palabra entre comillas
      System.out.print("\"" + lista.get(i) + "\"");
    }
    // Cerramos la lista
    System.out.print("]");
  }

}
