package prog.unidad06.arraysmulti.ejercicio02;

/**
 * Clase tabla. Representa una tabla con filas y columnas de números enteros
 * @author Jose
 *
 */
public class TablaEnteraConTotales {

  /**
   * Longitud mínima de la tabla tanto para filas como para columnas. 
   * Debe ser 1 como mínimo
   */
  private int LONGITUD_MINIMA_TABLA = 1;
  
  /**
   * Tabla asociada a nuestra clase. En ella se almacenarán todos los valores
   */
  private int[][] tabla;
  
  /**
   * Constructor de la clase tabla. Crea una tabla vacía
   * @param filas Número de filas que tendrá la tabla. Deberá ser 1 como mínimo
   * @param columnas Número de columnas que tendrá la tabla. Deberá ser 1 como mínimo
   * @throws IllegalArgumentException En caso de que alguno de los parámetros no se cumpla
   */
  public TablaEnteraConTotales(int filas, int columnas) {
    if (filas < LONGITUD_MINIMA_TABLA ||  columnas < LONGITUD_MINIMA_TABLA) {
      throw new IllegalArgumentException();
    } else {
      tabla = new int[filas][columnas];
    }
  }
  
  /**
   * Método que agrega un entero a la tabla. 
   * @param fila Posición de fila de la casilla a modificar. 
   * Desde 0 hasta el valor de filas dado en el constructor - 1
   * @param columna Posición de columna de la casilla a modificar. 
   * Desde 0 hasta valor de columnas dado en el constructor - 1
   * @param entero
   * @throws ArrayIndexOutOfBoundsException Si se intenta insertar un elemento con una fila o columna errónea
   */
  public void setCasilla(int fila, int columna, int entero) {
      tabla[fila][columna] = entero;
  }
  
  /**
   * Método que obtiene un entero de la tabla dada la posición. 
   * @param fila Posición de fila de la casilla a modificar. 
   * Desde 0 hasta el valor de filas dado en el constructor - 1
   * @param columna Posición de columna de la casilla a modificar. 
   * Desde 0 hasta valor de columnas dado en el constructor - 1
   * @return El elemento de la posición deseada
   * @throws ArrayIndexOutOfBoundsException Si se intenta obtener un elemento con una fila o columna errónea
   */
  public int getCasilla(int fila, int columna) {
    return tabla[fila][columna];
  }
  
  /**
   * Método que suma todos los elementos de la misma fila
   * @param fila Fila de la cual se suman todos los valores
   * @return El resultado de la suma
   */
  public int getTotalFila(int fila) {
    
    int sumaTotal = 0;
    // Obtenemos la fila y sumamos todos los elementos para devolverlo en el método
    for (int valor : tabla[fila]) {
      sumaTotal += valor;
    }
    return sumaTotal;
  }
  
  /**
   * Método que devuelve la suma de los valores de una columna concreta
   * @param columna Columna de la cual se suman todos los valores
   * @return El resultado de la suma
   */
  public int getTotalColumna(int columna) {
    int sumaTotal = 0;
    // Recorremos todas las filas y sumamos el valor de dicha columna únicamente
    for (int[] fila : tabla) {
      sumaTotal += fila[columna];
    }
    return sumaTotal;
  }
  
  /**
   * Método que calcula la suma de todos los valores de la tabla
   * @return La suma de todos los valores de la tabla
   */
  public int getTotalTabla() {
    int sumaTotal = 0;
    // Vamos a sumar cada fila, lo cual dará el resultado total
    for (int i = 0; i < tabla.length; i++) {
      sumaTotal += getTotalFila(i);
    }
    return sumaTotal;
  }
  
}
