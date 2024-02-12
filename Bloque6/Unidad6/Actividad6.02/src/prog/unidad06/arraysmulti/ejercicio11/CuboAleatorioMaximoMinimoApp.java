package prog.unidad06.arraysmulti.ejercicio11;
import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class CuboAleatorioMaximoMinimoApp {

  // Dimensiones cubo
  private static final int PLANOS = 5;
  private static final int FILAS = 6;
  private static final int COLUMNAS = 10;  
  
  // Rango de valores
  private static final int VALOR_MINIMO_INCLUIDO = 100;
  private static final int VALOR_MAXIMO_NO_INCLUIDO = 1001;
  
  public static void main(String[] args) {

    System.out.println("MÁXIMO Y MÍNIMO EN CUBO ALEATORIO");
    
    // Clase Random para generar los números aleatorios
    Random generador = new Random();
    
    // Creamos un array vacío de tablas, reutilizando el ejercicio para tablas
    TablaEnteraConTotales[] cubo = new TablaEnteraConTotales[PLANOS];
    for (int i = 0; i < cubo.length; i++) {
      cubo[i] = new TablaEnteraConTotales(FILAS, COLUMNAS);
    }
    
    // Insertamos valores aleatorios en el cubo
      for (int i = 0; i < cubo.length; i++) {
        for (int j = 0; j < FILAS; j++) {
          for (int k = 0; k < COLUMNAS; k++) {     
            // Generamos el valor y lo insertamos en la tabla
            int valor = generador.nextInt(VALOR_MINIMO_INCLUIDO, VALOR_MAXIMO_NO_INCLUIDO);
            
            cubo[i].setCasilla(j, k, valor);
          }
        }
      }
      
      // Calculamos el máximo y el mínimo
      // Formato de máximo y mínimo: plano, fila, columna, valor
      int[] maximo = new int[4];
      int[] minimo = new int[4];
      // Establecemos el máximo y el mínimo como el primer elemento del cubo. Automáticamente, queda seteado
      // plano, fila y columna como 0
      maximo[3] = cubo[0].getCasilla(0, 0);
      minimo[3] = cubo[0].getCasilla(0, 0);
      
      // Recorremos el cubo buscando máximo y mínimo
      for (int i = 0; i < PLANOS; i++) {
        for (int j = 0; j < FILAS; j++) {
          for (int k = 0; k < COLUMNAS; k++) {
            
            int valor = cubo[i].getCasilla(j, k);
            // Si es mayor al máximo, modificamos todo el array
            if (valor > maximo[3]) {
              maximo[0] = i;
              maximo[1] = j;
              maximo[2] = k;
              maximo[3] = valor;
            }
            // Misma operación para el mínimo
            if (valor < minimo[3]) {
              minimo[0] = i;
              minimo[1] = j;
              minimo[2] = k;
              minimo[3] = valor;  
            }
          }
        }
      }
      
      int digitosMaximo = String.valueOf(maximo[3]).toCharArray().length;
      
      // Imprimimos el cubo
      for (int i = 0; i < PLANOS; i++) {
        System.out.println("Plano " + (i + 1));
        // Imprimimos las líneas
        for (int l = 0; l < COLUMNAS; l++) {
          for (int m = 0; m <= digitosMaximo; m++) {
            System.out.print("-");
          }
          System.out.print("--");
        }
        System.out.println();

        // Imprimimos cada plano por separado, como tabla
        for (int j = 0; j < FILAS; j++) {
          for (int k = 0; k < COLUMNAS; k++) {
            System.out.print(String.format("%" + digitosMaximo + "d" ,cubo[i].getCasilla(j, k)) + "\s\s\s");
          }
          System.out.println();
        }
      }
      // Imprimimos las líneas
      for (int l = 0; l < COLUMNAS; l++) {
        for (int m = 0; m <= digitosMaximo; m++) {
          System.out.print("-");
        }
        System.out.print("--");
      }
      System.out.println();
      
      //Imprimimos máximo y mínimo
      System.out.println("El valor máximo es " + maximo[3] + " y está situado en la posición (" + (maximo[0] + 1) 
          + ", " + (maximo[1] + 1) + ", " + (maximo[2] + 1) + ")");

      System.out.println("El valor mínimo es " + minimo[3] + " y está situado en la posición (" + (minimo[0] + 1) 
          + ", " + (minimo[1] + 1) + ", " + (minimo[2] + 1) + ")");
    
  }

}
