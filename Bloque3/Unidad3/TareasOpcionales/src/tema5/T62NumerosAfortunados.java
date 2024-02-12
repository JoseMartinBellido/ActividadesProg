package tema5;

import java.util.Scanner;

public class T62NumerosAfortunados {

  public static void main(String[] args) {

    System.out.println("NÚMEROS AFORTUNADOS");
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Introduzca un número entero: ");
    try {
      int numeroIntroducido = sc.nextInt();
      
      String numeroStr = String.valueOf(numeroIntroducido);
      
      int contadorNumerosAfortunados = 0;
      
      for (int i = 0; i < numeroStr.length(); i++) {
        if(numeroStr.charAt(i) == '3' || numeroStr.charAt(i) == '7' || numeroStr.charAt(i) == '8' || numeroStr.charAt(i) == '9')
          contadorNumerosAfortunados++;
      }
      
      int contadorNumerosNoAfortunados = numeroStr.length() - contadorNumerosAfortunados;
      
      String isAfortunado = (contadorNumerosAfortunados > contadorNumerosNoAfortunados) ? 
          " es un número afortunado" : " no es un número afortunado";
      
      System.out.println("El " + numeroIntroducido + isAfortunado);
      
    }catch(NumberFormatException e) {
      System.out.println("El dato introducido no es un número en el formato correcto");
    }
    
    sc.close();
    
  }

}
