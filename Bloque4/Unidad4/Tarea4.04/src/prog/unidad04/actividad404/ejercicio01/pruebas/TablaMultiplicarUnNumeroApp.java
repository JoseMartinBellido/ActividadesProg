package prog.unidad04.actividad404.ejercicio01.pruebas;

import java.util.Scanner;

import prog.unidad04.actividad404.ejercicio01.TablaMultiplicar;

public class TablaMultiplicarUnNumeroApp {

  public static void main(String[] args) {
    
    System.out.println("PROGRAMA DE CÁLCULO DE LA TABLA DE MULTIPLICAR");
    
    Scanner sc = new Scanner(System.in);
    
    // Solicitamos el número por teclado
    System.out.print("Introduzca un número entero mayor que cero para calcular la tabla de multiplicar: ");
    
    try {
      // Tomamos el número e imprimimos la tabla de multiplicar
      int numero = Integer.parseInt(sc.nextLine());
      
      TablaMultiplicar tabla = new TablaMultiplicar(numero);
      
      tabla.imprimeTabla();
    // Nos da igual si el error es NumberFormatException o IllegalArgumentException. En ambos casos, el error es la inserción
    // errónea por parte del usuario del número
    } catch (RuntimeException e) {
      System.out.println("El número introducido no es un número entero mayor que cero");
    }

    sc.close();
    
    
    
    
    
    
    
    
    
    
    
  }

}
