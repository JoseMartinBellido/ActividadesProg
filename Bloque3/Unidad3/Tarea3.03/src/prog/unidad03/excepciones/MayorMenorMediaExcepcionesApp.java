package prog.unidad03.excepciones;

import java.util.Scanner;

public class MayorMenorMediaExcepcionesApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("MAYOR, MENOR Y MEDIA (A PRUEBA DE USUARIOS MALICIOSOS)");
    
    //Inseción de la cantidad de números que vamos a introducir.
    int cantidadDeNumeros = 0;
    boolean numeroValido = false;
   
    do {
      try {
      
        System.out.print("¿Cuántos números deseas introducir?: ");
        cantidadDeNumeros = Integer.parseInt(sc.nextLine());
        // Establecemos un caso <= 0 y mayor que cero
        if(cantidadDeNumeros <= 0)
          System.out.println("No tiene sentido que se introduzcan 0 números o menos. Inténtelo de nuevo.");
        
        // Cuando el número es mayor que 0, salimos del bucle
        else if(cantidadDeNumeros > 0)
          numeroValido = true;
      
      }catch(NumberFormatException e) {
        System.out.println("El valor introducido no es un número entero correcto. Inténtelo de nuevo.");
      }
    } while(!numeroValido);
    
    
    // Metemos el primer número, declarándolo fuera del bucle para tener ya un primer mayor o menor
    numeroValido = false;
    double numeroIntroducido = 0;
    
    do {
      try {
      
        // Comprobamos si el primer número es válido
        System.out.print("Introduce un número: ");
        numeroIntroducido = Double.parseDouble(sc.nextLine());
        
        numeroValido = true;
      
      }catch(NumberFormatException e) {
        System.out.println("El valor introducido no es un número real correcto. Inténtelo de nuevo");
      }
    } while(!numeroValido);
    
    // Establecemos los números mayor, menor y media para comenzar
    double mayor = numeroIntroducido;
    double menor = numeroIntroducido;
    double media = numeroIntroducido;
    
    
    // Metemos el resto de números.
    
    int numeroInserciones = cantidadDeNumeros-1;
    
    while(numeroInserciones > 0) {
      try {
      
        //Metemos un número y, si no da error, establecemos las condiciones para el mayor y menor, y sumamos el número a la media
        System.out.print("Introduce un número: ");
        numeroIntroducido = Double.parseDouble(sc.nextLine());
        
        if (numeroIntroducido > mayor) mayor = numeroIntroducido;
        if(numeroIntroducido < menor) menor = numeroIntroducido;
        media += numeroIntroducido;
        
        // Para acabar el bucle, reducimos en 1 la variable numeroInserciones
        numeroInserciones--;
      
      }catch(NumberFormatException e) {
        System.out.println("El valor introducido no es un número real correcto. Inténtelo de nuevo.");
      }
    }
    
    // Imprimimos los resultados
    System.out.println("El mayor de los números introducidos ha sido: " + mayor);
    System.out.println("El menor de los números introducidos ha sido: " + menor);
    System.out.println("La media de todos los números vale: " + (media / cantidadDeNumeros));
  
  
    sc.close();
  }


  
}
