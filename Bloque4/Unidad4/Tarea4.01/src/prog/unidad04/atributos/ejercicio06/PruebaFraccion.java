package prog.unidad04.atributos.ejercicio06;

import java.util.Scanner;

public class PruebaFraccion {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("PROGRAMA DE MANEJO DE FRACCIONES");
    
    int numeroDeFracciones;
    
    // Solicitamos el número de fracciones dentro de un try/catch
    try {
      System.out.print("Introduzca la cantidad de fracciones a crear (1 o mas): ");
      numeroDeFracciones = Integer.parseInt(sc.nextLine());
      
      for (int i = 1; i <= numeroDeFracciones; i++) {
        
        Fraccion fraccion = new Fraccion();
        
        // Solicitamos un numerador para la fracción
        System.out.print("Introduce el numerador de la fracción " + i + ": ");
        fraccion.numerador = Integer.parseInt(sc.nextLine());
        
        // Solicitamos un denominador para la fracción. Como el denominador no debe ser cero nunca, pedimos el dato hasta que sea distinto de cero.
        do{
          System.out.print("Introduce el denominador de la fracción " + i + ": ");
          fraccion.denominador = Integer.parseInt(sc.nextLine());
          
          if (fraccion.denominador == 0)
            System.out.println("El denominador no puede ser cero. Inténtelo de nuevo.");
          
        } while (fraccion.denominador == 0);
        
        // Imprimimos resultado de la fracción
        System.out.println("Datos de la Fracción " + i);
        System.out.println("Numerador: " + fraccion.numerador);
        System.out.println("Denominador " + fraccion.denominador);
      }
      
    } catch(NumberFormatException e) {
      System.out.println("Se ha introducido uno de los datos en un formato erróneo. Inténtelo de nuevo.");
    }

    sc.close();
    
  }

}
