package prog.unidad03.repeticion;

import java.util.Scanner;

public class CalculaDivisoresApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("DIVISORES DE UN NÚMERO");
    
    // Solicitamos el número por pantalla
    
    System.out.print("Introduce un número entero para que calcule sus divisores: ");
    int numeroIntroducido = Integer.parseInt(sc.nextLine());
    
    // Los divisores que pueden dividir a nuestro número introducido pueden llegar como mucho, aparte del 1 y del mismo número, hasta la mitad del mismo
    for (int i = 1; i <= (numeroIntroducido / 2); i++) {
      
      // Si el número es divisible por i, lo imprimimos por pantalla
      if(numeroIntroducido % i == 0) {
        System.out.println("Es divisible por " + i);
      }
    }
    
    System.out.println("Es divisible por " + numeroIntroducido);
    
    sc.close();
  }

}
