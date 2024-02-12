package unidad06.listas.ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase con métodos estáticos de utilidad para listas
 */
public class ListaEnterosUtils {

  /**
   * Genera una lista de longitud aleatoria de números enteros también
   *   aleatorios.
   * @param longitudMin Longitud mínima de la lista. Debe ser mayor o igual a cero
   * @param longitudMax Longitud máxima de la lista. Debe ser igual o mayor a
   *   la longitud mínima
   * @param valorMin Valor mínimo del rango desde el que se elegirán los
   *   números aleatorio que formarán la lista
   * @param valorMax Valor máximo del rango. Debe ser igual o mayor que el
   *   mínimo
   * @return Lista con los enteros aleatorios. La longitud de la lista estará
   *   en el rango especificado
   * @throws IllegalArgumentException Si longitudMin es mayor que longitudMax
   *   o valorMin es mayor que valorMax 
   */
  public static List<Integer> generaListaEnterosAleatorios(int longitudMin,
    int longitudMax, int valorMin, int valorMax) {
    
    // Generador de números aleatorios
    Random random = new Random();
    
    // Si la longitud es correcta
    if (longitudMin >=0 && longitudMin <= longitudMax) {
      // La calcula
      int longitud = random.nextInt(longitudMin, longitudMax + 1);
      // Si el rango de valores es correcto
      if (valorMin <= valorMax) {
        // Creamos la lista
        List<Integer> resultado = new ArrayList<>();
        // Mientras no lleguemos a la longitud
        for (int i = 0; i < longitud; i++) {
          // Generamos un valor aleatorio
          int valor = random.nextInt(valorMin, valorMax + 1);
          // Y lo añadimos a la lista
          resultado.add(valor);
        }
        // Devolvemos el resultado
        return resultado;
      } else {
        // El rango indicado no es correcto
        throw new IllegalArgumentException();
      }
    } else {
      // El rango de la longitud no es correcto
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Obtiene una representación textual de una lista de enteros<br>
   * Si la lista es null, devuelve una cadena vacía<br>
   * Si la lista está vacía devuelve ()<br>
   * Si la lista no está vacía devuelve (valor1, valor2, ...., valorn)
   * @param lista Lista a convertir a texto
   * @return Cadena con la representacion de la lista
   */
  public static String generaCadena(List<Integer> lista) {
    String salida = "";
    // Si el parámetro no es null
    if (lista != null) {
      // Genera el paréntesis de apertura
      salida+= "(";
      // Flag para generar o no comas
      boolean coma = false;
      // Para cada elemento de la lista
      for (int valor: lista) {
        // Si se debe generar la coma
        if (coma) {
          // Se genera
          salida += ", ";
        } else {
          // En esta iteración no se genera pero en la siguiente si
          coma = true;
        }
        // Genera el valor
        salida += valor;
      }
      // Se genera el paréntesis de cierre
      salida += ")";
    }
    return salida;
  }
}
