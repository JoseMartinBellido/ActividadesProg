package prog.unidad03.repeticion;

import java.util.Scanner;

public class MayorMenorMediaApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("MAYOR, MENOR Y MEDIA");
    
    // Solicitamos los datos
    System.out.print("¿Cuántos números deseas introducir? ");
    int cantidadDeNumeros = Integer.parseInt(sc.nextLine());
    
    // Solicitamos el primer número
    System.out.print("Introduce el número 1: ");
    double numeroIntroducido = Double.parseDouble(sc.nextLine());
    
    // Declaramos una serie de variables de uso posterior.
    double numeroMasBajo = numeroIntroducido;
    double numeroMasAlto = numeroIntroducido;
    double sumatoria = numeroIntroducido;
    
    // Como sabemos cuántos números vamos a introducir, usaremos un bloque for.
    for(int i = 1; i < cantidadDeNumeros ; i++) {
      
      // Solicitamos el número.
      System.out.print("Introduce el número " + (i + 1) + ": ");
      numeroIntroducido = Double.parseDouble(sc.nextLine());
      
      // A partir de la segunda vuelta, hacemos la comprobación número a número
      if (numeroIntroducido < numeroMasBajo) numeroMasBajo = numeroIntroducido;
        
      if (numeroIntroducido > numeroMasAlto) numeroMasAlto = numeroIntroducido;
          
      // En cualquier caso, actualizamos la sumatoria
      sumatoria += numeroIntroducido;    
    }
    
    // Calculamos e imprimimos resultados por pantalla
    System.out.println("El mayor de los números introducidos ha sido: " + numeroMasAlto);
    System.out.println("El menor de los números introducidos ha sido: " + numeroMasBajo);
    
    System.out.println("La media de todos los números vale: " + (sumatoria / cantidadDeNumeros));
    
    sc.close();
  }

}
