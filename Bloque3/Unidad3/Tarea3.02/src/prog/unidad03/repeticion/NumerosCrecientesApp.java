package prog.unidad03.repeticion;

import java.util.Scanner;

public class NumerosCrecientesApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("NÚMEROS CRECIENTES");
    
    // Solicitamos el primer número entero
    System.out.print("Introduce un número entero: ");
    int numeroInicial = Integer.parseInt(sc.nextLine());
    int numeroAnterior = numeroInicial;
    int numeroSiguiente = numeroInicial;
    
    do {
      // En esta vuelta del bucle, el número anterior evoluciona al siguiente y el siguiente se pide al usuario
      numeroAnterior = numeroSiguiente;
      
      // Solicitamos el siguiente número siempre que el sea mayor que el anterior
      System.out.print("Introduce ahora un número mayor que " + numeroAnterior + " (Introduce un número menor o igual para terminar):");
      numeroSiguiente = Integer.parseInt(sc.nextLine());
      
    }while (numeroSiguiente > numeroAnterior);
    
    System.out.println("El número " + numeroSiguiente + " no es mayor que el número anterior " + numeroAnterior + ". Terminando");
    
    sc.close();
  }

}
