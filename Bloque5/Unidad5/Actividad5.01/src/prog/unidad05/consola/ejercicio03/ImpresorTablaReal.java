package prog.unidad05.consola.ejercicio03;

/**
 * Clase cuya función es la de imprimir tablas de números reales
 */
public class ImpresorTablaReal {

  /**
   * Método que imprime una tabla dada de números reales con una serie de números decimales determinados
   * @param tabla Tabla de números reales a imprimir
   * @param numDecimales Número de decimales a dejar en la impresión
   */
  public static void imprimeTabla(double[][] tabla, int numDecimales) {
    
    // Calculamos el mayor y menor
    double mayor = getMayorMenorTabla(tabla)[0];
    double menor = getMayorMenorTabla(tabla)[1];

    // Se calcula el número con la parte entera más grande
    int parteEnteraMayor = getLongitudParteEntera(mayor);
    int parteEnteraMenor = getLongitudParteEntera(menor);
    
    int longitud = (parteEnteraMayor > parteEnteraMenor) ? parteEnteraMayor : parteEnteraMenor;
    
    // Se imprime la tabla
    System.out.printf("Tabla de %d x %d%n", tabla.length, tabla[0].length);
    System.out.println("-----------------");
    
    for (double[] fila : tabla) {
      for (double numero : fila) {
        // El extra de 3 espacios es para separar los números unos de otros 2 espacios y considerar el punto
        String textoAImprimir = "% " + (longitud + numDecimales + 2) + "." 
      + numDecimales + "f";
        System.out.printf(textoAImprimir, numero);
      }
      System.out.println();
    }
  }
  
  /**
   * Método que calcula la longitud de la parte entera de un número
   * @param numero Número del cual obtener dicha parte entera
   * @return Un número entero que indica la longitud de la parte entera del número dado
   */
  private static int getLongitudParteEntera(double numero) {
    
    // Si es decimal con punto, se elige la parte izquierda a él. Sino, nos quedamos el número entero
    String parteEntera = (String.valueOf(numero).contains(".")) ? 
        String.valueOf(numero).split("\\.")[0] : String.valueOf(numero);
    
    // Se devuelve su longitud
    return parteEntera.length();
  }
  
  
  /**
   * Método que obtiene el mayor y el menor de una tabla de números reales
   * @param tabla Tabla de la cual obtener los valores
   * @return Un array que contiene el mayor y el menor, en dicho orden
   */
  private static double[] getMayorMenorTabla(double[][] tabla) {
    
    double mayor = tabla[0][0];
    double menor = tabla[0][0];
    
    for (double[] fila : tabla) {
      for (double numero : fila) {
        mayor = (numero > mayor) ? numero : mayor;
        menor = (numero < menor) ? numero : menor;
      }
    }
    
    return new double[]{mayor, menor};
    
  }
  
  
}
