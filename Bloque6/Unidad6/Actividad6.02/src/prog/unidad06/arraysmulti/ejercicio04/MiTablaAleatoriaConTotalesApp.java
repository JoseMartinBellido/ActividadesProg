package prog.unidad06.arraysmulti.ejercicio04;

import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class MiTablaAleatoriaConTotalesApp {

  // Constantes de la tabla
  private static final int CANTIDAD_FILAS = 4;
  private static final int CANTIDAD_COLUMNAS = 5;
  
  // Constantes de los valores
  private static final int NUMERO_MINIMO_INCLUIDO = 100;
  private static final int NUMERO_MAXIMO_NO_INCLUIDO = 1000;
  
  public static void main(String[] args) {

    System.out.println("TABLA ALEATORIA CON TOTALES");
    
    // Generador de números aleatorios
    Random generador = new Random();

    // Creamos la tabla. Sabemos que no habrá un error del tipo IllegalArgumentException porque se 
    // establecen como constantes las dimensiones
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);
    
    // Rellenamos la tabla con datos aleatorios
    for (int j = 0; j < CANTIDAD_COLUMNAS; j++) {
      for (int i = 0; i < CANTIDAD_FILAS; i++) {
        // Generamos un número aleatorio con la clase Random
        int valor = generador.nextInt(NUMERO_MINIMO_INCLUIDO, NUMERO_MAXIMO_NO_INCLUIDO);
        tabla.setCasilla(i, j, valor);
      }
    }
    
    // Comprobamos el tamaño del máximo número generado. Este será la suma de todos los valores
    int maximo = tabla.getTotalTabla();
    int digitosMayorNumero = String.valueOf(maximo).toCharArray().length;
    
    // Imprimimos los resultados
    System.out.println("--------------------------------------------");
    for (int i = 0; i < CANTIDAD_FILAS; i++) {
      for (int j = 0; j < CANTIDAD_COLUMNAS; j++) {
        // Impresión normal de la tabla
        System.out.print(String.format("%" + digitosMayorNumero + "d", tabla.getCasilla(i, j)) + "\s\s\s");
        // Impresión de las sumas por cada fila
        if (j == CANTIDAD_COLUMNAS - 1) {
          System.out.print(String.format("%" + digitosMayorNumero + "d", tabla.getTotalFila(i)));
        }
      }
      System.out.println();
    }
    
    // Imprimimos las sumas de cada columna
    for (int j = 0; j < CANTIDAD_COLUMNAS; j++) {
      System.out.print(String.format("%" + digitosMayorNumero + "d", tabla.getTotalColumna(j)) + "\s\s\s");
    }
    
    System.out.println(String.format("%" + digitosMayorNumero + "d", tabla.getTotalTabla()) + "\s\s\s");
    
    System.out.println("--------------------------------------------");
  }

}
