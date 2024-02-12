package prog.unidad06.arraysmulti.ejercicio09;

import java.util.Scanner;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class CuboConSumasTotalesApp {

  private static final int PLANOS = 5;
  private static final int FILAS = 3;
  private static final int COLUMNAS = 2;  
  
  public static void main(String[] args) {
    
    // Scanner para solicitar los datos
    Scanner sc = new Scanner(System.in);
    
    // Creamos un array vacío de tablas, reutilizando el ejercicio para tablas
    TablaEnteraConTotales[] cubo = new TablaEnteraConTotales[PLANOS];
    for (int i = 0; i < cubo.length; i++) {
      cubo[i] = new TablaEnteraConTotales(FILAS, COLUMNAS);
    }
    
    // Insertamos los valores introducidos por teclado en el cubo
    boolean valorCorrecto = false;

      for (int i = 0; i < cubo.length; i++) {
        for (int j = 0; j < FILAS; j++) {
          for (int k = 0; k < COLUMNAS; k++) {
            valorCorrecto = false;
            // Se solicita el dato mientras el valor no sea correcto
            do {
              try {
                System.out.print("Introduce un valor para la posición (" + (i + 1) + "," + (j + 1) 
                    + "," + (k + 1) + "): ");
                int valor = Integer.parseInt(sc.nextLine());
                // Si el valor no ha generado un error, se inserta en el cubo, en su tabla correspondiente
                cubo[i].setCasilla(j, k, valor);
                // Modificamos el valor de valorCorrecto
                valorCorrecto = true;
              } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es válido. Inténtelo de nuevo.");
              }
              
            } while (!valorCorrecto);
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
        System.out.println("-----------");
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
        
        System.out.println("-----------");
      }
      
      sc.close();
  }

}
