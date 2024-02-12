package prog.unidad06.arraysmulti.ejercicio06;

public class MaximoMinimoTablaAleatoriaVersion2App {

  // Constantes de la tabla
  private static final int CANTIDAD_FILAS = 6;
  private static final int CANTIDAD_COLUMNAS = 10;
  
  // Constantes de los valores
  private static final int NUMERO_MINIMO_INCLUIDO = 100;
  private static final int NUMERO_MAXIMO_INCLUIDO = 1000;
  
  public static void main(String[] args) {

    System.out.println("MÁXIMO Y MÍNIMO EN TABLA ALEATORIA");
    
    // Generamos la tabla con números aleatorios
    int[][] tabla = TablaEnteraUtils.nuevaTablaAleatoria(CANTIDAD_FILAS, CANTIDAD_COLUMNAS, 
        NUMERO_MINIMO_INCLUIDO, NUMERO_MAXIMO_INCLUIDO);
    
    // Imprimimos la tabla con una separación de 3 espacios
    System.out.println("---------------------------------------");
    TablaEnteraUtils.imprimeTabla(tabla, 3);
    System.out.println("---------------------------------------");
    
    // Imprimimos el máximo y su localización. El máximo y minimo deben sumar 1 porque la función devuelve
    // el índice del array
    int[] posicionMaximo = TablaEnteraUtils.localizaMaximo(tabla);
    System.out.println("El máximo vale " + TablaEnteraUtils.getMaximo(tabla) + " y está localizado en la fila "
        + (posicionMaximo[0] + 1) + ", columna " + (posicionMaximo[1] + 1));
    
    // Imprimimos el mínimo y su localización
    int[] posicionMinimo = TablaEnteraUtils.localizaMinimo(tabla);
    System.out.println("El mínimo vale " + TablaEnteraUtils.getMinimo(tabla) + " y está localizado en la fila "
        + (posicionMinimo[0] + 1) + ", columna " + (posicionMinimo[1] + 1));
    
  }

}
