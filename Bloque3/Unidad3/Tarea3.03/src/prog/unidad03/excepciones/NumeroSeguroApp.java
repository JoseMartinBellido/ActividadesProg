package prog.unidad03.excepciones;

import java.util.Scanner;

public class NumeroSeguroApp {

  public static void main(String[] args) {

    System.out.println("INTRODUCCIÓN DE NÚMERO SEGURA.");
    
    Scanner sc = new Scanner(System.in);
    
    // Solicitamos la introducción de un número entero. Se intenta hacer dentro de un try, con el catch indicando la excepción de parseInt
    try {
      
      System.out.print("Introduce un número entero: ");
      int numeroIntroducido = Integer.parseInt(sc.nextLine());
      
      // Si hemos llegado hasta aquí, es que lo anterior no ha dado error, con lo que imprimimos un mensaje de que el número es correcto.
      System.out.println("El número introducido es " + numeroIntroducido);
      
    }catch(NumberFormatException e) {
      System.out.println("El dato introducido no es un número válido.");
    }
    
    sc.close();    
    
  }

}
