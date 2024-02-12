package prog.unidad06.arraysmulti.ejercicio12;

import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class CuboAleatorioDiagonalApp {

  // Dimensiones cubo
  private static final int LONGITUD_CUBO = 10;
  
  // Rango de valores
  private static final int VALOR_MINIMO_INCLUIDO = 200;
  private static final int VALOR_MAXIMO_NO_INCLUIDO = 301;
  
  public static void main(String[] args) {

    System.out.println("DIAGONAL EN CUBO ALEATORIO");
    
 // Clase Random para generar los números aleatorios
    Random generador = new Random();
    
    // Creamos un array vacío de tablas, reutilizando el ejercicio para tablas
    TablaEnteraConTotales[] cubo = new TablaEnteraConTotales[LONGITUD_CUBO];
    for (int i = 0; i < cubo.length; i++) {
      cubo[i] = new TablaEnteraConTotales(LONGITUD_CUBO, LONGITUD_CUBO);
    }
    
    // Insertamos valores aleatorios en el cubo
      for (int i = 0; i < cubo.length; i++) {
        for (int j = 0; j < LONGITUD_CUBO; j++) {
          for (int k = 0; k < LONGITUD_CUBO; k++) {     
            // Generamos el valor y lo insertamos en la tabla
            int valor = generador.nextInt(VALOR_MINIMO_INCLUIDO, VALOR_MAXIMO_NO_INCLUIDO);
            
            cubo[i].setCasilla(j, k, valor);
          }
        }
      }
      

      // Calculamos el máximo, el mínimo y la diagonal
      // Formato de máximo y mínimo: plano, fila, columna, valor
      int maximo = cubo[0].getCasilla(0, 0);
      int minimo = cubo[0].getCasilla(0, 0);
      double media = cubo[0].getCasilla(0, 0);
      int[] diagonal = new int[LONGITUD_CUBO];     
      
      // La cantidad de planos, filas y columnas es igual
      for (int i = 0; i < cubo.length; i++) {
        for (int j = 0; j < cubo.length; j++) {
          for (int k = 0; k < cubo.length; k++) {
            diagonal[i] = cubo[i].getCasilla(i, i);
            int valor = cubo[i].getCasilla(j, k);
            
            media += valor;
            maximo = (valor > maximo) ? valor : maximo;
            minimo = (valor < minimo) ? valor : minimo;

          }
        }
      }
      media = media / (Math.pow(LONGITUD_CUBO, 3));
      
      int digitosMaximo = String.valueOf(maximo).toCharArray().length;
      
      // Imprimimos el cubo
      for (int i = 0; i < LONGITUD_CUBO; i++) {
        System.out.println("Plano " + (i + 1));
        // Imprimimos las líneas
        for (int l = 0; l < LONGITUD_CUBO; l++) {
          for (int m = 0; m <= digitosMaximo; m++) {
            System.out.print("-");
          }
          System.out.print("--");
        }
        System.out.println();

        // Imprimimos cada plano por separado, como tabla
        for (int j = 0; j < LONGITUD_CUBO; j++) {
          for (int k = 0; k < LONGITUD_CUBO; k++) {
            System.out.print(String.format("%" + digitosMaximo + "d" ,cubo[i].getCasilla(j, k)) + "\s\s\s");
          }
          System.out.println();
        }
        // Imprimimos las líneas
        for (int l = 0; l < LONGITUD_CUBO; l++) {
          for (int m = 0; m <= digitosMaximo; m++) {
            System.out.print("-");
          }
          System.out.print("--");
        }
        System.out.println();
      }
      
      
      //Imprimimos los resultados
      System.out.print("Los elementos de la diagonal son: ");
      for (int i = 0; i < diagonal.length; i++) {
        System.out.print((i != diagonal.length - 1) ? diagonal[i] + ", " : diagonal[i]);
      }
      System.out.println();
      
      System.out.println("El valor máximo es " + maximo + ", el mínimo es " + minimo + " y la media vale "
          + media);

      
  }

}
