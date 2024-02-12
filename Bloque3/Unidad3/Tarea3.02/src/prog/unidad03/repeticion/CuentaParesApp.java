package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaParesApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("CUENTA PARES");
    
    // Solicitamos la cantidad de números pares a introducir.
    System.out.print("¿Cuántos números pares deseas introducir?: ");
    int cantidadDePares = Integer.parseInt(sc.nextLine());
    
    // Introducimos un contador de pares para la condición de nuestro while
    int contadorDePares = 0;
    
    // Realizamos nuestro bucle do-while
    while(contadorDePares < cantidadDePares) {
      // Solicitamos la introducción de un número entero.
      System.out.print("Introduce un número entero: ");
      int numeroIntroducido = Integer.parseInt(sc.nextLine());
      
      // Comprobamos si el número introducido es par o impar y se informa al usuario en caso de que lo sea
      if(numeroIntroducido % 2 == 0) {  
        contadorDePares++;
        
        if (contadorDePares < cantidadDePares) {
          System.out.println("Te quedan " + (cantidadDePares - contadorDePares) + " números pares por introducir.");
        }
      }
    }
    
    
    // Una vez terminado el bucle, hemos terminado de solicitar números
    System.out.println("¡Ya has introducido " + cantidadDePares + " números pares!");
    
    sc.close();
    
  }

}
