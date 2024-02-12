package prog.unidad06.listas.ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Clase de métodos estáticos con diferentes utilidades para listas
public class ListaEnterosUtils {

  private static final Random generador = new Random();
  
  /**
   * Método que genera una lista con una cantidad aleatoria de enteros de números enteros aleatorios
   * @param longitudMin Longitud mínima de la lista. Debe ser mayor o igual a cero
   * @param longitudMax Longitud máxima de la lista. Debe ser mayor o igual a la longitud mínima
   * @param valorMin Valor mínimo del rango donde se elegirán los números aleatorios
   * @param valorMax Valor máximo del rango donde se elegirán los números aleatorios. Debe ser mayor
   * o igual al valor mínimo
   * @return La lista ya generada con un número de elementos entre longitudMin y longitudMax, 
   * en el rango
   * @throws IllegalArgumentException En caso de que no se cumplan los requisitos de parámetros
   */
  public static List<Integer> generaListaEnterosAleatorios (int longitudMin, int longitudMax, 
      int valorMin, int valorMax){
    
    // Comprobamos que se cumplen las condiciones
    if (valorMax >= valorMin && longitudMax >= longitudMin && longitudMin >= 0) {
      // Creamos la lista que devolveremos al final
      List<Integer> lista = new ArrayList<>();
      
      // Generamos un número aleatorio entre longitudMin y longitudMax.
      int cantidadElementos = generador.nextInt(longitudMin, longitudMax + 1);
      
      // Añadimos los elementos aleatorios
      for (int i = 0; i < cantidadElementos; i++) {
        lista.add(generador.nextInt(valorMin, valorMax + 1));
        
      }
      // Devolvemos la lista
      return lista;
    // Si no se cumplen condiciones, se lanza el error
    } else {
      throw new IllegalArgumentException();
    }

  }
  
  /**
   * Obtiene una representación textual de una lista de enteros
   * @param lista Lista a convertir en texto
   * @return Una cadena vacía si la lista es null, () si la lista está vacía o una cadena con formato
   * (valor1, valor2, valor3,...) 
   */
  public static String generaCadena(List<Integer> lista) {
    // Comprobamos los casos excepcionales
    if (lista == null) {
      return "";
      
    } else if (lista.isEmpty()) {
      return "()";
    // Si no está vacía ni es null, generamos la cadena
    } else {
      // Creamos el string a devolver
      String representacion = "(";
      
      // Añadimos los valores uno a uno
      for (int i = 0; i < lista.size(); i++) {
        representacion += lista.get(i);
        if (i < lista.size() - 1) {
          representacion += ", ";
        }
      }
      representacion += ")";
      
      return representacion;
    }
    
    
  }
  
}
