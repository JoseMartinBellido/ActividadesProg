package prog.unidad06.arraysmulti.ejercicio07;

import prog.unidad06.arraysmulti.ejercicio06.TablaEnteraUtils;
import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

public class DiagonalTabla {
  
  // Constantes de la tabla
  private static final int TAMANYO_TABLA = 10;
  
  // Constantes de los valores
  private static final int NUMERO_MINIMO_INCLUIDO = 200;
  private static final int NUMERO_MAXIMO_INCLUIDO = 300;
  
  public static void main(String[] args) {
    
    // Generamos la tabla de números aleatorios
    int[][] tabla = TablaEnteraUtils.nuevaTablaAleatoria(TAMANYO_TABLA, TAMANYO_TABLA, 
        NUMERO_MINIMO_INCLUIDO, NUMERO_MAXIMO_INCLUIDO);
    
    // Imprimimos la tabla
    System.out.println("Tabla original");
    System.out.println("------------------------------------");
    TablaEnteraUtils.imprimeTabla(tabla, 3);
    System.out.println("------------------------------------");
    
    // Buscamos los elementos de la diagonal y los almacenamos
    int[] diagonal = new int[TAMANYO_TABLA];
    for (int i = 0; i < diagonal.length; i++) {
      diagonal[i] = tabla[i][i];
    }
    
    // Imprimimos la diagonal
    System.out.print("Elementos de la diagonal: ");
    for (int i = 0; i < diagonal.length; i++) {
      String elemento = (i != diagonal.length - 1) ? diagonal[i] + ", " : diagonal[i] + " ";
      System.out.print(elemento);
    }
    System.out.println();
    
    // Imprimimos máximo y mínimo
    System.out.println("El máximo de los elementos de la diagonal es " 
        + UtilidadesArrays.getMaximoArrayEntero(diagonal) + ", el mínimo es " 
        + UtilidadesArrays.getMinimoArrayEntero(diagonal));
    
    // Calculamos e imprimimos la media
    double media = 0;
    for (int valor : diagonal) {
      media += valor;
    }
    media = media / diagonal.length;
    System.out.println("La media de todos los los elementos de la diagonal vale " + media);
  }

}
