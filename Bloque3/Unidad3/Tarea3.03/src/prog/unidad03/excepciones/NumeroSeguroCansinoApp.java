package prog.unidad03.excepciones;

import java.util.Scanner;

public class NumeroSeguroCansinoApp {

  public static void main(String[] args) {

    System.out.println("INTRODUCCIÓN DE NÚMEROS SEGURA Y CANSINA");
    
    Scanner sc = new Scanner(System.in);
    
    /* Integer numeroIntroducido = null;
    // Para realizar este programa, aprovechamos el anterior y lo metemos en un bucle do-while que repita el proceso hasta que se cumpla.
    
    do {
      try {
        
        System.out.print("Introduce un número entero: ");
        numeroIntroducido = Integer.parseInt(sc.nextLine());
        
      }catch(NumberFormatException e) {
        System.out.println("El dato introducido no es un número válido.");
      }
    } while(numeroIntroducido == null);
    */
    
    // Otra forma
    
      int numeroIntroducido = 0;
      boolean flag = false;
     
      do {
        try {
        
          System.out.print("Introduce un número entero: ");
          numeroIntroducido = Integer.parseInt(sc.nextLine());
          
          // Si se ha llegado hasta aquí, el número introducido es válido.
          flag = true;
        
        }catch(NumberFormatException e) {
          System.out.println("El dato introducido no es un número válido.");
        }
      } while(!flag);
      
      
      System.out.println("El número introducido es " + numeroIntroducido);
      
      sc.close();
  }

}
