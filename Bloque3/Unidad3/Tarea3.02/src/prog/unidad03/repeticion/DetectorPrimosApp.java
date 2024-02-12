package prog.unidad03.repeticion;

import java.util.Scanner;

public class DetectorPrimosApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("DETECTOR DE NUMEROS PRIMOS");
    
    // Solicitamos el número.
    System.out.print("Introduce un número entero mayor que 1 para ver si es primo o no: ");
    int numeroIntroducido = Integer.parseInt(sc.nextLine());
    
    if(numeroIntroducido > 1) {
      int contadorDivisores = 0;
      int divisor = 2;
      
      // Buscamos el divisor estableciendo como condición que el contador de divisores sea 0 y que el divisor esté en un rango determinado
      while(contadorDivisores == 0 && divisor <= (numeroIntroducido / 2)) {
        
        // Si el divisor divide al número, el contador deja de ser 0 y salimos del bucle.
        if (numeroIntroducido % divisor == 0) {
          contadorDivisores++;
        }
        
        divisor++;
        
      }
      
      /*for (int i = 2; i <= (numeroIntroducido / 2); i++) {
          if (numeroIntroducido % i == 0) {
            contadorDivisores++;
            break;
          }
      }*/
      
      System.out.print("El número " + numeroIntroducido + " ");
      
      String mensaje = (contadorDivisores == 0) ? "es primo" : "no es primo";
      
      System.out.println(mensaje);
      
    } else {
      // El número introducido no era mayor que 1
      System.out.println("Error: Debes introducir un número mayor que 1.");
    }
    
    
    sc.close();
    
    
  }

}
