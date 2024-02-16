package prog.unidad05.consola.ejercicio03;

/**
 * Utilidades de impresión de tablas de números reales
 */
public class ImpresorTablaReal2 {

  /**
   * Imprime una tabla de números reales por consola mostrando los números alineados a la derecha y encolumnados
   * @param tabla Tabla de reales a imprimir
   * @param decimales Número de decimales a mostrar para cada número
   */
  public static void imprimeTabla(double[][] tabla, int decimales) {
    // Calcula la anchura máxima de todos los datos (sólo la parte entera)
    int anchuraEnteraMaxima = calculaAnchuraEnteraMaxima(tabla);
    // Creamos la cadena de formato (se añade dos a la longitud para dejar sitio para el potencial signo y para el separador)
    String formato = "% " + (anchuraEnteraMaxima + decimales + 2) + "." + decimales + "f ";
    // Para cada fila
    for (double[] fila: tabla) {
      // Para cada celda de la fila
      for (double celda: fila) {
        // Imprime la celda
        System.out.printf(formato, celda);
      }
      // Imprime un salto de línea para finalizarla
      System.out.println();
    }
  }

  /**
   * Calcula la máxima longitud de los datos contenidos en la tabla
   * @param tabla Tabla con los datos a comprobar
   * @return Número máximo de decimales
   */
  private static int calculaAnchuraEnteraMaxima(double[][] tabla) {
    // Longitud máxima inicial la del primer elemento
    int maximo = calcularAnchuraElemento(tabla[0][0]);
    // Para cada elemento de la tabla
    for (double[] fila: tabla) {
      for (double celda: fila) {
        // Obtiene su anchura
        int anchura = calcularAnchuraElemento(celda);
        // Si es más ancha que el máximo
        if (anchura > maximo) {
          // Es el nuevo máximo
          maximo = anchura;
        }
      }
    }
    // Devuelve el máximo
    return maximo;
  }

  /**
   * Obtiene la anchura en dígitos de la parte entera del número indicado
   * @param valor  Valor real
   * @return Longitud en dígitos de la parte entera del número
   */
  private static int calcularAnchuraElemento(double valor) {
    // Redondeamos (recortamos) y eliminamos el signo
    long valorEntero = (long)Math.abs(Math.floor(valor));
    // Lo convertimos a cadena y devolvemos la longitud
    return String.format("%d", valorEntero).length();
  }
}
