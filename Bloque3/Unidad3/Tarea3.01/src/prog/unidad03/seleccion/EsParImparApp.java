package prog.unidad03.seleccion;

import java.util.Scanner;

public class EsParImparApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("¿Par o Impar?");
    
    // Solicitamos los datos por teclado
    System.out.print("Introduce un número entero: ");
    int numeroAComprobar = Integer.parseInt(sc.nextLine());
    
    System.out.print("El número " + numeroAComprobar + " ");
    
    // Comprobamos si el número es par o impar usando su módulo
    String parOImpar = (numeroAComprobar % 2 == 0) ? "es par." : "es impar";
    
    System.out.println(parOImpar);
    
    sc.close();
    
  }

}
