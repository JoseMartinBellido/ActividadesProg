package prog.unidad06.arraysuni.ejercicio01;

import java.util.Scanner;

public class Array8App {

  private static final int TAMANYO_ARRAY = 8;
  
  public static void main(String[] args) {

    // Scanner para leer por teclado
    Scanner sc = new Scanner(System.in);
    
    // Array de almacenamiento
    double[] numeros = new double[TAMANYO_ARRAY];
    
    // Almacenamiento de los números
    for (int i = 0; i < numeros.length; i++) {
      System.out.print("Introduce el número " + (i + 1) + ": ");
      numeros[i] = Double.parseDouble(sc.nextLine());
      
    }
    
    double sumaTotal = 0;
    double sumaMayores36 = 0;
    int numerosMayores50 = 0;
    
    double sumaValores1030 = 0;
    int contadorMediaValores = 0;
    
    // Recorremos el array para calcular los datos
    for (double numero : numeros) {
      sumaTotal += numero;
      
      sumaMayores36 += (numero > 36) ? numero : 0;
      
      numerosMayores50 += (numero > 50) ? 1 : 0;
      
      if (numero > 10 && numero < 30) {
        sumaValores1030 += numero;
        contadorMediaValores += 1;
      }
    }
    
    // Imprimimos los resultados
    
    System.out.println("La suma total de los números es " + sumaTotal);
    System.out.println("La suma total de los números mayores a 36 es " + sumaMayores36);
    System.out.println("La cantidad de los números mayores a 50 es " + numerosMayores50);
    
    // Si el contador es 0, no hay valores entre 10 y 30, con lo que la media no se puede calcular. Sino, se calcula.
    if (contadorMediaValores == 0) {
      System.out.println("No hay ningún valor que cumpla el requisito para calcular la media.");
    } else {
      System.out.println("La media de los valores comprendidos entre 10 y 30 es de " + (sumaValores1030 / contadorMediaValores));
    }
    
    sc.close();
  }

}
