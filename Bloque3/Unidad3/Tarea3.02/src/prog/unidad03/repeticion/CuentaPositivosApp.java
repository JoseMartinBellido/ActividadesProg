package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaPositivosApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("CONTADOR DE POSITIVOS");
    
    // Declaramos el primer número que usar en el bucle do-while, que realizaremos mientras el número sea >= 0
    int numeroIntroducido;
    
    // Establecemos un contador de positivos
    int contadorDePositivos = 0;
    
    do {
      // Solicitamos un número por teclado
      System.out.print("Introduce un número entero positivo o cero (negativo para terminar): ");
      numeroIntroducido = Integer.parseInt(sc.nextLine());
      
      // Comprobamos si es positivo para añadirlo al contador
      if(numeroIntroducido >= 0) contadorDePositivos++;
      
    }while (numeroIntroducido >= 0);
    
    System.out.println("Has introducido " + contadorDePositivos + " números positivos");
    
    sc.close();
  }

}
