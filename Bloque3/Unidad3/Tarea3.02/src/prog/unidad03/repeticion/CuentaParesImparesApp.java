package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaParesImparesApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("CUENTA PARES O IMPARES");
    
    // Solicitamos los datos por teclado
    System.out.print("¿Cuántos números deseas introducir?: ");
    int cantidadDeNumeros = Integer.parseInt(sc.nextLine());
    
    int numeroParOImpar;
    int contadorDePares = 0;
    
    // Hacemos un bucle for que repita la solicitud de un número "cantidadDeNumeros" veces.
    for (int i = 0; i < cantidadDeNumeros ; i++) {
      
      // Solicitamos el número i
      System.out.print("Introduce el número " + (i + 1) + ": ");
      numeroParOImpar = Integer.parseInt(sc.nextLine());
      
      // Comprobamos si el número es par o impar, imprimimos el resultado y sumamos al contador en caso de que sea el caso.
      System.out.print("El número " + numeroParOImpar + " es "); 
      if(numeroParOImpar % 2 == 0) {
        System.out.println("par.");
        contadorDePares++;
      }else {
        System.out.println("impar.");
      }
    } // -------- Fin del bucle for
    
    // Imprimimos el resto de resultados globales y fin del programa.
    System.out.println("Se han introducido " + contadorDePares + " números pares y " + (cantidadDeNumeros - contadorDePares) + " números impares");
    System.out.println("Fin del programa.");
    
    sc.close();
  }

}
