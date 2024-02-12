package prog.unidad06.arraysmulti.ejercicio01;

public class MiPrimerArrayBidimensional {

  public static void main(String[] args) {

    System.out.println("MI PRIMER ARRAY BIDIMENSIONAL");
    
    // Creamos el array
    int[][] numeros = new int[3][6];
    
    // Rellenamos el array con las posiciones convenidas
    numeros[0][0] = 35;
    numeros[0][2] = 64;
    numeros[0][3] = 69;
    numeros[0][5] = 93;
    numeros[1][1] = 12;
    numeros[1][4] = 92;
    numeros[1][5] = 97;
    numeros[2][0] = 13;
    numeros[2][2] = 33;
    numeros[2][4] = 52;
    
    // Imprimimos por pantalla el resultado
    System.out.println("---------------------------");
    for(int[] array : numeros) {
      for (int valor : array) {
        // Convertimos cada número al formato adecuado para imprimir
        System.out.print(String.format("%2d", valor) + "\s\s\s");
      }
      System.out.println();
    }
    
    
    System.out.println("---------------------------");
    
    
  }

}
