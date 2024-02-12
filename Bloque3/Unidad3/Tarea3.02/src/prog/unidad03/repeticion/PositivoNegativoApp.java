package prog.unidad03.repeticion;

import java.util.Scanner;

public class PositivoNegativoApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("NÚMEROS POSITIVOS Y NEGATIVOS");
    
    int numeroIntroducido = 0;

    do {
      // Pedimos el número al usuario
      System.out.print("Introduce un número entero (0 para terminar): ");
      numeroIntroducido = Integer.parseInt(sc.nextLine());
      
      // Contemplamos los casos negativo y positivo
      if (numeroIntroducido < 0 ) {
        System.out.println("El número " + numeroIntroducido + " es negativo");
      } else if( numeroIntroducido > 0) {
        System.out.println("El número " + numeroIntroducido + " es positivo");
      }
      
    } while (numeroIntroducido != 0);
    
    sc.close();
  }

}
