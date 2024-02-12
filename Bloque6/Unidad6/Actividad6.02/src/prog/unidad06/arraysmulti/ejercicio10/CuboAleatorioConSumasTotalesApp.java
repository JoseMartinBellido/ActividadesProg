package prog.unidad06.arraysmulti.ejercicio10;

import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class CuboAleatorioConSumasTotalesApp {

  // Dimensiones cubo
  private static final int PLANOS = 5;
  private static final int FILAS = 3;
  private static final int COLUMNAS = 2;  
  
  // Rango de valores
  private static final int VALOR_MINIMO_INCLUIDO = 100;
  private static final int VALOR_MAXIMO_NO_INCLUIDO = 1000;
  
  
  public static void main(String[] args) {
    
    System.out.println("CUBO ALEATORIO CON SUMAS TOTALES");
    
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
      
      // Calculamos el máximo elemento para imprimir las tablas con la cantidad de dígitos
      int maximo = 0;
      for (int i = 0; i < cubo.length; i++) {
        if (cubo[i].getTotalTabla() > maximo) {
          maximo = cubo[i].getTotalTabla();
        }
      }
      int digitosMaximo = String.valueOf(maximo).toCharArray().length;
      
      
      // Imprimimos la tabla usando las utilidades ya definidas
      for (int i = 0; i < cubo.length; i++) {
        System.out.println("Plano " + (i + 1));
        System.out.println("------------------");
        // Imprimimos cada plano por separado, como tabla
        for (int j = 0; j < FILAS; j++) {
          for (int k = 0; k < COLUMNAS; k++) {
            System.out.print(String.format("%" + digitosMaximo + "d" ,cubo[i].getCasilla(j, k)) + "\s\s\s");
            // Imprimimos el total de la fila
            if (k == COLUMNAS - 1) {
              System.out.println(String.format("%" + digitosMaximo + "d" ,cubo[i].getTotalFila(j)));
            } 
            
          }
        }
        // Imprimimos el total de las columnas y de la tabla
        for (int k = 0; k < COLUMNAS; k++) {
          System.out.print(String.format("%" + digitosMaximo + "d" ,cubo[i].getTotalColumna(k)) + "\s\s\s");
        }
        
        System.out.println(String.format("%" + digitosMaximo + "d" ,cubo[i].getTotalTabla()) + "\s\s\s");
        
        System.out.println("------------------");
      }

  }

}
