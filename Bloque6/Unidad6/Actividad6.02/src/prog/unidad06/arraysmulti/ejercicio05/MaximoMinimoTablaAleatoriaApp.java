package prog.unidad06.arraysmulti.ejercicio05;

import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class MaximoMinimoTablaAleatoriaApp {

  // Constantes de la tabla
  private static final int CANTIDAD_FILAS = 6;
  private static final int CANTIDAD_COLUMNAS = 10;
  
  // Constantes de los valores
  private static final int NUMERO_MINIMO_INCLUIDO = 100;
  private static final int NUMERO_MAXIMO_NO_INCLUIDO = 1001;
  
  public static void main(String[] args) {
    
    System.out.println("MÁXIMO Y MÍNIMO EN TABLA ALEATORIA");
    
 // Generador de números aleatorios
    Random generador = new Random();

    // Creamos la tabla. Sabemos que no habrá un error del tipo IllegalArgumentException porque se 
    // establecen como constantes las dimensiones
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);
    
    // Variables para almacenar máximo y mínimo. En estos arrays almacenaremos fila, columna y valor
    int[] maximo = new int[3];
    int[] minimo = new int[3];
    
    // Por defecto, maximo[0] y maximo[1] valen 0. Lo mismo con el mínimo, con lo que solo inicializamos índice 2
    // Estos valores sabemos, por definición, que variarán
    maximo[2] = NUMERO_MINIMO_INCLUIDO;
    minimo[2] = NUMERO_MAXIMO_NO_INCLUIDO;
    
    // Rellenamos la tabla con datos aleatorios
    for (int j = 0; j < CANTIDAD_COLUMNAS; j++) {
      for (int i = 0; i < CANTIDAD_FILAS; i++) {
        // Generamos un número aleatorio con la clase Random
        int valor = generador.nextInt(NUMERO_MINIMO_INCLUIDO, NUMERO_MAXIMO_NO_INCLUIDO);
        tabla.setCasilla(i, j, valor);
        
        // Actualizamos el valor máximo y mínimo en caso de ser necesario
        if (valor > maximo[2]) {
          maximo[0] = i;
          maximo[1] = j;
          maximo[2] = valor;
        }
        
        if (valor < minimo[2]) {
          minimo[0] = i;
          minimo[1] = j;
          minimo[2] = valor;
        }
        
      }
    }
    
    // Comprobamos el tamaño del máximo número generado. Este será la suma de todos los valores

    int digitosMayorNumero = String.valueOf(maximo[2]).toCharArray().length;
    
    // Imprimimos los resultados
    System.out.println("--------------------------------------------");
    for (int i = 0; i < CANTIDAD_FILAS; i++) {
      for (int j = 0; j < CANTIDAD_COLUMNAS; j++) {
        // Impresión normal de la tabla
        System.out.print(String.format("%" + digitosMayorNumero + "d", tabla.getCasilla(i, j)) + "\s\s\s");
        
      }
      System.out.println();
    }    
    System.out.println("--------------------------------------------");
    
    // Imprimimos los valores máximo y mínimo
    System.out.println("El valor máximo vale " + maximo[2] + " y está localizado en la fila " + (maximo[0] + 1)
        + ", columna " + (maximo[1] + 1));
    System.out.println("El valor mínimo vale " + minimo[2] + " y está localizado en la fila " + (minimo[0] + 1) 
        + ", columna " + (minimo[1] + 1));
    
    
  }
  
}
