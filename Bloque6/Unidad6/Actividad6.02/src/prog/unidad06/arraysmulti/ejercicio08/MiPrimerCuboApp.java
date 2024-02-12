package prog.unidad06.arraysmulti.ejercicio08;

public class MiPrimerCuboApp {

  private static final int PLANOS = 3;
  private static final int FILAS = 4;
  private static final int COLUMNAS = 5;
  
  
  public static void main(String[] args) {

    System.out.println("MI PRIMER CUBO");
    
    // Creamos nuestro cubo
    int[][][] cubo = new int[PLANOS][FILAS][COLUMNAS];
    
    // Rellenamos el plano 1 (índice 0)
    cubo[0][0][0] = 18;
    cubo[0][0][2] = 36;
    cubo[0][0][3] = 67;
    cubo[0][1][1] = 59;
    cubo[0][1][3] = 6;
    cubo[0][1][4] = 40;
    cubo[0][2][0] = 74;
    cubo[0][2][2] = 59;
    cubo[0][2][4] = 11;
    cubo[0][3][1] = 51;
    cubo[0][3][2] = 85;
    cubo[0][3][3] = 62;
    
    // Rellenamos el plano 2 (índice 1)
    cubo[1][0][1] = 25;
    cubo[1][0][2] = 38;
    cubo[1][0][3] = 99;
    cubo[1][1][0] = 92;
    cubo[1][1][2] = 31;
    cubo[1][1][4] = 74;
    cubo[1][2][1] = 78;
    cubo[1][2][2] = 81;
    cubo[1][2][4] = 76;
    cubo[1][3][0] = 1;
    cubo[1][3][1] = 26;
    cubo[1][3][3] = 96;
    
    // Rellenamos el plano 3 (índice 2)
    cubo[2][0][2] = 17;
    cubo[2][0][3] = 42;
    cubo[2][0][4] = 82;
    cubo[2][1][1] = 95;
    cubo[2][1][2] = 8;
    cubo[2][1][3] = 50;
    cubo[2][2][0] = 2;
    cubo[2][2][1] = 96;
    cubo[2][2][2] = 29;
    cubo[2][3][0] = 21;
    cubo[2][3][1] = 74;
    cubo[2][3][4] = 48;
    
    // Imprimos el resultado por pantalla. Recorremos los planos
    for (int i = 0; i < cubo.length; i++) {
      System.out.println("Plano " + (i + 1));
      System.out.println("----------------------");
      // Por cada plano, imprimimos cada tabla
      for (int[] fila : cubo[i]) {
        for (int valor : fila) {
          System.out.print(String.format("%2d", valor) + "\s\s\s");
        }
        System.out.println();
      }
      
      
      System.out.println("----------------------");
    }
    
    
    
  }

}
