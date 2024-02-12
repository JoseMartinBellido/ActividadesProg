package prog.unidad03.repeticion;

import java.util.Scanner;

public class CalculaFactorialApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("CÁLCULO DE FACTORIAL");
    
    // Solicitamos los datos iniciales
    System.out.println("Introduce un número entero mayor que cero para calcular su factorial: ");
    int numeroIntroducido = Integer.parseInt(sc.nextLine());
    long factorial = numeroIntroducido;
    
    
    // Para calcular el factorial multiplicamos por todos los anteriores, uno a uno
    for(int i = (numeroIntroducido - 1); i >= 1; i--) {
      
      factorial *= i;
    }
    
    System.out.println("El factorial de " + numeroIntroducido + " es " + factorial);
    
    sc.close();
  }

}
