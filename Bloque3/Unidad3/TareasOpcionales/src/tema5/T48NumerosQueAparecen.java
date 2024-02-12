package tema5;

import java.util.Scanner;

public class T48NumerosQueAparecen {

  public static void main(String[] args) {

    System.out.println("DÍGITOS QUE APARECEN Y NO APARECEN EN UN NÚMERO");
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Introduzca un número entero: ");
    String numeroIntroducido = sc.nextLine();
    
    String numerosQueAparecen = "";
    String numerosQueNoAparecen = "";
    
    for (int i = 0; i < 10; i++) {
      if (numeroIntroducido.contains(String.valueOf(i)))
        numerosQueAparecen += String.valueOf(i) + " ";
      
      else
        numerosQueNoAparecen += String.valueOf(i) + " ";
    }
    
    System.out.println("Dígitos que aparecen en el número " + numeroIntroducido + ": " + numerosQueAparecen);
    System.out.println("Dígitos que no aparecen en el número " + numeroIntroducido + ": " + numerosQueNoAparecen);
  }

}
