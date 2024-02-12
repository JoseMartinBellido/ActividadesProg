package prog.unidad06.arraysmulti.ejercicio06;

import java.util.Random;

/**
 * Clase compuesta por métodos estáticos de generación de tablas con números aleatorios y operaciones
 * con dichas tablas
 * @author Jose
 *
 */
public class TablaEnteraUtils {
    
  /**
   * Tamaño mínimo de filas y columnas para una tabla
   */
  private static final int TAMANYO_MINIMO_TABLA = 1;
  
  /**
   * Constructor de la clase
   */
  public TablaEnteraUtils() {
  }
    
  /**
   * Método que genera una tabla con las dimensiones especificadas, rellena con números aleatorios
   * en el rango comprendido entre el inicio y el fin dados como parámetros
   * @param filas Número de filas de la nueva tabla. Debe ser mayor a cero
   * @param columnas Número de columnas de la nueva tabla. Debe ser mayor a cero
   * @param inicioRango Valor de inicio del rango sobre el cual se calcularán los números de la tabla
   * Se incluye en el rango.
   * @param finRango Valor de fin del rango sobre el cual se calcularán los números de la tabla.
   * Se incluye en el rango, y debe ser mayor o igual que el de inicio.
   * @return Array de dos dimensiones con la tabla
   * @throws IllegalArgumentException Si alguno de los parámetros no cumple las condiciones estipuladas.
   */
  public static int[][] nuevaTablaAleatoria(int filas, int columnas, int inicioRango, int finRango) {
    // Comprobamos los parámetros
    if (filas > TAMANYO_MINIMO_TABLA && columnas > TAMANYO_MINIMO_TABLA 
        &&  finRango >= inicioRango) {
      // Creamos la tabla
      int[][] tabla = new int[filas][columnas];
      // Generamos los números aleatorios y los almacenamos
      Random generador = new Random();
      for (int i = 0; i < tabla.length; i++) {
        for (int j = 0; j < tabla[i].length; j++) {
          tabla[i][j] = generador.nextInt(inicioRango, finRango + 1);
        }
      }
      return tabla;
      
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  
  /**
   * Método que calcula el valor máximo de una tabla
   * @param tabla Tabla sobre la cual se calcula el máximo
   * @return El número entero máximo de una tabla (array bidimensional)
   * @throws IllegalArgumentException En caso de que se introduzca una tabla vacía o nula
   */
  public static int getMaximo(int[][] tabla) {
    // Comprobamos tanto si la tabla es null como si alguna de las filas de la tabla es 0
    if (compruebaTabla(tabla)) {
   // Calculamos el máximo. 
      int maximo = tabla[0][0];
      for (int[] fila : tabla) {
        for (int valor : fila) {
          maximo = (valor > maximo)? valor : maximo;
        }
      }
      return maximo;  
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Método que localiza la posición del máximo, almacenado en una tabla. 
   * @param tabla Tabla sobre la que se calcula la posición del máximo.
   * @return Un array de dos posiciones, donde la primera es la fila de la tabla donde se encuentra el máximo
   * y la segunda es la columna. El índice aportado comienza a contar desde cero. En caso de que haya más de 
   * una repetición, se devuelve la posición de la primera.
   */
  public static int[] localizaMaximo(int[][] tabla) {
    
    // Buscamos el mínimo aprovechando la función ya definida. 
    // Los errores, en caso de haberlos, se lanzan al buscar el mínimo.
    int maximo = getMaximo(tabla);
    int[] posicionMaximo = new int[2];
    
    // Localizamos el máximo y devolvemos la primera posición donde lo encontremos
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        if (maximo == tabla[i][j]) {
          posicionMaximo[0] = i;
          posicionMaximo[1] = j;
          return posicionMaximo;
        }
      }
    }
    // Si se llega aquí, ha ocurrido algún error con los parámetros, ya que no debería ejecutarse nunca
    throw new IllegalArgumentException();
  }
  
  /**
   * Método que calcula el valor mínimo de una tabla
   * @param tabla Tabla sobre la cual se calcula el mínimo
   * @return El número entero mínimo de una tabla (array bidimensional)
   * @throws IllegalArgumentException En caso de que se introduzca una tabla vacía o nula
   */
  public static int getMinimo(int[][] tabla) {
    // Comprobamos tanto si la tabla es null como si alguna de las filas de la tabla es 0
    if (compruebaTabla(tabla)) {
      // Calculamos el mínimo. 
      int minimo = tabla[0][0];
      for (int[] fila : tabla) {
        for (int valor : fila) {
          minimo = (valor < minimo)? valor : minimo;
        }
      }
      return minimo;  
    } else {
      throw new IllegalArgumentException();
    }
    
  }
  
  /**
   * Método que localiza la posición del mínimo, almacenado en una tabla. 
   * @param tabla Tabla sobre la que se calcula la posición del mínimo.
   * @return Un array de dos posiciones, donde la primera es la fila de la tabla donde se encuentra el mínimo
   * y la segunda es la columna. El índice aportado comienza a contar desde cero. En caso de que haya más de 
   * una repetición, se devuelve la posición de la primera.
   */
  public static int[] localizaMinimo(int[][] tabla) {
    
    // Buscamos el mínimo aprovechando la función ya definida. 
    // Los errores, en caso de haberlos, se lanzan al buscar el mínimo.
    int minimo = getMinimo(tabla);
    int[] posicionMinimo = new int[2];
    
    // Localizamos el mínimo y devolvemos la primera posición donde lo encontremos
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        if (minimo == tabla[i][j]) {
          posicionMinimo[0] = i;
          posicionMinimo[1] = j;
          return posicionMinimo;
        }
      }
    }
    // Si se llega aquí, ha ocurrido algún error con los parámetros, ya que no debería ejecutarse nunca
    throw new IllegalArgumentException();
  }
  
  /**
   * Imprime una tabla entera cualquiera por pantalla
   * @param tabla Tabla a imprimir. No debe ser null o vacía
   * @param separacion Cantidad de espacios que separan los números. Debe ser superior o igual a 1
   * @throws IllegalArgumentException Si la tabla no es correcta o la separacion es menor a 1
   */
  public static void imprimeTabla(int[][] tabla, int separacion) {
    // Comprobamos los parámetros
    if (compruebaTabla(tabla) && separacion >= 1) {
      // Imprimimos los valores de la tabla recorriendola valor a valor
      for (int[] fila : tabla) {
        for (int valor : fila) {
          // Para comprobar el número de dígitos a dejar entre elementos, se busca el máximo y se calculan
          int digitos = String.valueOf(getMaximo(tabla)).toCharArray().length;
          // Damos formato a los valores de la tabla. Dejamos un dígito más por si hay valores negativos
          System.out.print(String.format("%" + (digitos + 1) + "d", valor));
          // Añadimos los espacios estipulados en la separación
          for (int k = 0; k < separacion; k++) {
            System.out.print("\s");
          }
        }
        System.out.println();
      }
      
      
    } else {
      throw new IllegalArgumentException();
    }
    
    
  }
  
  private static boolean compruebaTabla(int[][] tabla) {
    if (tabla == null || tabla.length == 0) {
      return false;
    } else {
      // Comprobamos la longitud de las filas
      for (int[] fila : tabla) {
        // Comprobamos si alguna fila está vacía
        if (fila.length == 0) {
          return false;
        }
      }
    }
    // Si llegamos aquí, la tabla es correcta
    return true;
  }

}
