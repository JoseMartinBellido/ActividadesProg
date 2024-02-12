package prog.ud06.actividad611.coleccion;

/**
 * Tarjeta de clave de un usuario
 * Una tarjeta de claves contiene una tabla con claves numéricas enteras
 */
public class TarjetaClaves {

  // Constantes
  // Valor mínimo de una clave
  private static final int CLAVE_MINIMO = 0;
  // Valor máximo de una clave
  private static final int CLAVE_MAXIMO = 999;
  // Atributos
  // Claves
  private int[][] claves;
  
  /**
   * Crea una tarjeta de claves con las filas y columnas indicadas<br>
   * Inicialmente las claves son todas 000
   * @param filas Número de filas de la tarjeta. Debe ser mayor que cero
   * @param columnas Número de columnas de la tarjeta. Debe ser mayor que cero
   * @throws IllegalArgumentException Si filas o columnas o ambos no son mayores que cero
   */
  public TarjetaClaves(int filas, int columnas) {
    // Si filas y columnas son mayores que cero
    if (filas > 0 && columnas > 0) {
      // Crea el array de claves vacío
      claves = new int[filas][columnas];
    } else {
      // Error en los argumentos
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Obtiene el número de filas que tiene la tabla de claves de la tarjeta
   * @return Número de filas de la tabla de claves
   */
  public int getFilas() {
    return claves.length;
  }
  
  /**
   * Obtiene el número de columnas que tiene la tabla de claves de la tarjeta
   * @return Número de columnas de la tabla de claves
   */
  public int getColumnas() {
    return claves[0].length;
  }
  
  /**
   * Modifica el valor de una clave
   * @param fila Fila donde está la clave. Debe valer entre 1 y el total de filas de la tarjeta
   * @param columna Columna donde está la clave. Debe valer entre 1 y el total de columnas de la tarjeta
   * @param clave Nuevo valor de la clave. Debe estar comprendido entre 0 y 999, ambos incluidos
   * @throws IllegalArgumentException Si fila, columna o clave son incorrectos
   */
  public void setClave(int fila, int columna, int clave) {
    // Si los parámetros son correctos
    if (filaEsCorrecta(fila) && columnaEsCorrecta(columna)
      && claveEsCorrecta(clave)) {
      // Ajusta la clave
      claves[fila - 1][columna - 1] = clave;
    } else {
      // Parámetros incorrectos
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Valida que la clave es correcta
   * @param fila Número de fila de la clave. Debe valer desde 1 hasta el número
   *   de filas de la tarjeta
   * @param columna Número de columna de la clave. Debe valer desde 1 hasta el
   *   número de columnas de la tarjeta
   * @param clave Valor de clave a validar
   * @return true si la clave es válida. false si no lo es
   * @throws IllegalArgumentException Si fila o columna no son válidos
   */
  public boolean validarClave(int fila, int columna, int clave) {
    // Si fila y columna son válidos
    if (filaEsCorrecta(fila) && columnaEsCorrecta(columna)) {
      return claves[fila - 1][columna - 1] == clave;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Comprueba si el valor proporcionado es un valor de clave correcto
   * @param clave Valor de clave a comprobar
   * @return true si el valor es correcto. false en caso contrario
   */
  private boolean claveEsCorrecta(int clave) {
    return clave >= CLAVE_MINIMO && clave <= CLAVE_MAXIMO;
  }

  /**
   * Comprueba si el valor de columna proporcionado es válido para esta tarjeta
   * @param columna Valor de columna a comprobar
   * @return true si el valor de columna es correcto. false en caso contrario
   */
  private boolean columnaEsCorrecta(int columna) {
    // Esto funciona porque debe haber una fila al menos
    return columna >= 1 && columna <= claves[0].length;
  }

  /**
   * Comprueba si el valor de fila proporcionado es válido para esta tarjeta
   * @param fila Valor de fila a comprobar
   * @return true si el valor es válido. false en caso contrario
   */
  private boolean filaEsCorrecta(int fila) {
    return fila >= 1 && fila <= claves.length;
  }
}
