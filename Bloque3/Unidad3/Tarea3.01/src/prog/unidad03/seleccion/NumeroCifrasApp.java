package prog.unidad03.seleccion;

import java.util.Scanner;

public class NumeroCifrasApp {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Cifras de un número");
    
    // Introducción de datos
    System.out.print("Introduce un número: ");
    int numero = Integer.parseInt(sc.nextLine());
    int numeroAbsoluto = Math.abs(numero);
    
    // Opción 1. Sin usar String.
    
    // Comprobamos si el número absoluto está entre 0 y 9, entre 10 y 99, entre 100 y 999 o más e imprimimos resultados.
    System.out.print("El número " + numero + " tiene ");
    
    if(numeroAbsoluto < 10) {
      System.out.print("1 cifra.");
    } else if (numeroAbsoluto < 100) {
      System.out.print("2 cifras.");
    } else if(numeroAbsoluto < 1000) {
      System.out.print("3 cifras.");
    } else {
      System.out.print("más de 3 cifras.");
    }
    
    System.out.println();
    // Opción 2. Usando String.
    
    String numeroStr = Integer.toString(numeroAbsoluto);
    
    // Imprimimos resultados dependiendo de si tiene 3 cifras o más
    
    if(numeroStr.length() < 4) {
      System.out.println("El número " + numero + " tiene " + numeroStr.length() + " cifras.");
    } else {
      System.out.println("El número " + numero + " tiene más de 3 cifras.");
    }
    
    sc.close();
  }

}
