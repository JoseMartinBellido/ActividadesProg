package prog.unidad04.actividad404.ejercicio03.pruebas;

import java.util.Scanner;

import prog.unidad04.actividad404.ejercicio03.MayorMenor;

public class MayorMenorPositivosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    boolean primerNumeroIntroducido = false;
    
    // Solicitamos el primer número para poder llamar al constructor
    int numeroIntroducido = 0;
    do {
      
      try {
        System.out.print("Introduce un número entero (negativo para terminar): ");
        numeroIntroducido = Integer.parseInt(sc.nextLine());
        
        // Si hemos llegado hasta aquí, se ha introducido correctamente un número
        primerNumeroIntroducido = true;
        
      } catch (NumberFormatException e) {
        System.out.println("Lo que se ha introducido no es un número entero. Inténtalo de nuevo");
      }
      
    }while (!primerNumeroIntroducido);

    // Una vez tenemos el primer número, si es menor que cero no calculamos nada.
    if (numeroIntroducido < 0) {
      
      System.out.println("No se introdujo ningún número, por lo que no hay resultado");
      
    } else {
      
      // Si es mayor o igual a cero, llamamos al constructor que calcule la media y seguimos solicitando datos
      MayorMenor mayorMenor = new MayorMenor(numeroIntroducido);
      
      boolean banderaSolicitudDatos = false;
      
      while (!banderaSolicitudDatos) {
        
        try {
          
          System.out.print("Introduce un número entero (negativo para terminar): ");
          numeroIntroducido = Integer.parseInt(sc.nextLine());
          
          // Si el número es mayor o igual a cero, lo tratamos
          if (numeroIntroducido >= 0) {
            mayorMenor.add(numeroIntroducido);
          } else {
            // Si el número es menor a cero, terminamos el bucle
            banderaSolicitudDatos = true;
          }
          
        } catch (NumberFormatException e) {
          System.out.println("Lo que se ha introducido no es un número entero. Inténtalo de nuevo");
        }
      }
      
      //Imprimimos por pantalla el mayor y el menor número de la secuencia
      System.out.println("El mayor de los números introducidos es " + mayorMenor.getMayor() + " y el menor es " + mayorMenor.getMenor());
    }

    sc.close();
  }

}
