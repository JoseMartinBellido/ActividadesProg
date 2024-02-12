package prog.unidad03.examen;

import java.util.Scanner;

public class SuperEstadisticaApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("EXAMEN DE José Martín Bellido. PROGRAMA DE SUPER ESTADÍSTICA.");
    
    // Creamos la variable numeroIntroducido y realizamos el programa completo en un bucle do-while, 
    // que funcionará mientras el número sea distinto de cero. Le damos un valor inicial de 1 para evitar errores.
    int numeroIntroducido = 1;
    
    // La variable media se crea fuera de bucles porque si el primer número es cero, debe dar la media cero.
    double media = 0;
    double cantidadDeNumeros = 0;
    
    do {
      
      // Creamos un try-catch para que, en caso de que excepción al insertar el número, no pare el programa.
      try {
        
        System.out.print("Introduce un número entero (Introduzca 0 para finalizar el programa): ");
        numeroIntroducido = Integer.parseInt(sc.nextLine());
        
        // Como el primer número introducido puede ser cero, establecemos la condición para que funcione solo si es distinto.
        if (numeroIntroducido != 0) {
          
          
          // Comprobamos si es par o impar e imprimimos resultado.
          String esParONo = (numeroIntroducido % 2 == 0) ? "par" : "impar";
          System.out.println("El número " + numeroIntroducido + " es " + esParONo);
          
          // Comprobamos si es positivo o negativo e imprimimos resultado. No puede ser cero.
          String esPositivoONegativo = (numeroIntroducido > 0) ? "positivo" : "negativo";
          System.out.println("El número " + numeroIntroducido + " es " + esPositivoONegativo);
          
          // Comprobamos si entra o no en la media y realizamos cálculos
          if (esParONo.equals("impar") 
              && (numeroIntroducido <= -11 || numeroIntroducido > 20 || numeroIntroducido == -1 || numeroIntroducido == 3)) {
            
            // Imprimimos por pantalla que entra en el cálculo
            System.out.println("El número " + numeroIntroducido + " cumple las condiciones para el cálculo de la media.");
            
            // Sumamos el número a la media y subimos el contador para luego al dividir en la media.
            media += numeroIntroducido;
            cantidadDeNumeros ++;
            
          } else {
            // Avisamos al usuario que el número no cumple las condiciones
            System.out.println("El número " + numeroIntroducido + " NO cumple las condiciones para el cálculo de la media.");
          }
        }
        
      } catch (NumberFormatException e) {
        // Si tenemos un error del tipo NumberFormatException, imprimimos un mensaje de error
        System.out.println("El dato introducido no es un número entero válido");
      }
      
      System.out.println();
    } while (numeroIntroducido != 0);
    
    // Una vez salimos del bucle, tenemos dos casos a diferenciar. 
    
    // El primer número es cero (El contador de números introducidos es cero)-> La media es cero.
    // El primer número no es cero -> Realizamos el cálculo de la media
    
    if (cantidadDeNumeros != 0) {
      
      media /= cantidadDeNumeros;
    }
    
    // Imprimimos resultado de la media
    
    System.out.println("La media de los números que cumplen la condición inicial es de: " + media);
    
    sc.close();
  }

}
