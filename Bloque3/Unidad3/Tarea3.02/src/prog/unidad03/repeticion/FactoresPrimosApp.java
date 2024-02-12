package prog.unidad03.repeticion;

import java.util.Scanner;

public class FactoresPrimosApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("CALCULO DE FACTORES PRIMOS");
    
    // Solicitamos el número para poder averiguar sus divisores primos
    System.out.print("Introduce un número entero mayor que 1 para descomponerlo en factores primos: ");
    int numeroIntroducido = Integer.parseInt(sc.nextLine());
    
    // Solución distinta
    
    // Establecemos el primer divisor
    
    int divisor = 2;
    
    // Trabajamos con el número hasta que sea mayor que 1. En el momento que alcance dicha cifra, habremos terminado.
    while (numeroIntroducido > 1) {
      
      if (numeroIntroducido % divisor == 0) {
        
        numeroIntroducido /= divisor;
        System.out.println(divisor + " es un divisor primo.");
      } else {
        
        divisor++;
        
      }
      
    }
    

    /* Solución propia
   
    // Comprobamos los divisores y vemos si son primos
    for(int i = 2; i <= numeroIntroducido / 2; i++) {
      
      // Comprobación de si el divisor tiene divisores (si es o no primo)
      if(numeroIntroducido % i == 0) {
        
        //Contador para los divisores del divisor
        int cantidadDivisoresDelDivisor = 0;
        
        for(int j = 2; j <= i / 2; j++) {
          if(i % j == 0) cantidadDivisoresDelDivisor++; 
        }
        
        // Si el divisor no tiene divisores, es primo
        if(cantidadDivisoresDelDivisor == 0) {
          System.out.println( i + " es un divisor primo.");
        }
      
      }
      
    }
    */
    sc.close();
    
  }

}
