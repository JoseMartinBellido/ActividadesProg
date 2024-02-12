package prog.unidad06.arraysmulti.ejercicio03;

import java.util.Scanner;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class MiTablaConTotalesApp {

  private static final int CANTIDAD_FILAS = 4;
  private static final int CANTIDAD_COLUMNAS = 5;
  
  public static void main(String[] args) {
    
    System.out.println("TABLA CON TOTALES");
    
    // Scanner para solicitar los datos por teclado
    Scanner sc = new Scanner(System.in);
    
    // Creamos la tabla. Sabemos que no habrá un error del tipo IllegalArgumentException porque se 
    // establecen como constantes las dimensiones
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);
    
    // Solicitamos los datos de la tabla
    boolean datoCorrecto = false;
    for (int j = 0; j < CANTIDAD_COLUMNAS; j++) {
      for (int i = 0; i < CANTIDAD_FILAS; i++) {
        // Se piden tantas veces como haga falta cada dato hasta tener uno correcto
        datoCorrecto = false;
        do {
          try {
            System.out.print("Introduzca el número correspondiente a la casilla (" 
                + (i + 1) + "," + (j + 1) + "): ");
            int valor = Integer.parseInt(sc.nextLine());
            tabla.setCasilla(i, j, valor);
            
            // Llegados aquí, establecemos como correcto el valor introducido
            datoCorrecto = true;
          } catch (NumberFormatException e) {
            System.out.println("El dato introducido es de un tipo incorrecto. Inténtelo de nuevo.");
          } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se ha intentado introducir un número");
          }
        } while (!datoCorrecto);
        
      }
    }
    
    // Calculamos el mayor número de todas las tablas para establecer el formato de impresión por número
    int maximo = tabla.getCasilla(0, 0);
    // Primero, comparamos todos los valores
    for (int i = 0; i < CANTIDAD_FILAS; i++) {
      for (int j = 0; j < CANTIDAD_COLUMNAS; j++) {
        if (tabla.getCasilla(i, j) > maximo) {
          maximo = tabla.getCasilla(i, j);
        }
      }
    }
    
    // Luego, comparamos con las sumas obtenidas de la tabla
    for (int i = 0; i < CANTIDAD_FILAS; i++) {
      if (tabla.getTotalFila(i) > maximo) {
        maximo = tabla.getTotalFila(i);
      }
    }
    
    for (int j = 0; j < CANTIDAD_COLUMNAS; j++) {
      if (tabla.getTotalColumna(j) > maximo) {
        maximo = tabla.getTotalColumna(j);
      }
    }
    
    if (tabla.getTotalTabla() > maximo) {
      maximo = tabla.getTotalTabla();
    }
    
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
    
    sc.close();
  }

}
