package prog.unidad04.actividad404.ejercicio01.pruebas;

import prog.unidad04.actividad404.ejercicio01.TablaMultiplicar;

public class TablasMultiplicarApp {
  
  private static final int MINIMO = 1;
  
  private static final int MAXIMO = 10;

  public static void main(String[] args) {
    
    System.out.println("PROGRAMA QUE IMPRIME LAS TABLAS DE MULTIPLICAR DE LOS NÚMEROS DEL 1 AL 10");
    
    // Imprimimos las tablas de multiplicar de los números del 1 al 10
    for (int i = MINIMO; i <= MAXIMO; i++) {
      TablaMultiplicar tabla = new TablaMultiplicar(i);
      System.out.println();
      tabla.imprimeTabla();
    }
    
  }

}
