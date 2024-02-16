package prog.unidad05.consola.ejercicio02;

import java.util.Scanner;

import prog.unidad05.consola.ejercicio01.TablaMultiplicar;

public class TablaMultiplicarUnNumeroApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Introduzca un número entero superior a cero para calcular su tabla"
        + "de multiplicar: ");
    
    try {
      
      int numero = Integer.parseInt(sc.nextLine());  
      
      TablaMultiplicar tabla = new TablaMultiplicar(numero);
      
      tabla.imprimeTabla();
      
    } catch (NumberFormatException e) {
      System.out.println("Dato incorrecto");
    }
    
    
    
    

  }

}
