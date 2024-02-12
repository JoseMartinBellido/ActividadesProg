package prog.unidad03.seleccion;

import java.util.Scanner;

public class ClasificaTriangulosApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Programa clasificador de triángulos.");
    
    // Toma de datos

    System.out.print("Introduce la longitud del primer lado: ");
    double lado1 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la longitud del segundo lado: ");
    double lado2 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la longitud del tercer lado: ");
    double lado3 = Double.parseDouble(sc.nextLine());
    
    if(lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
      if ((lado1 == lado2) && (lado2 == lado3)){
        System.out.println("El triángulo es equilátero.");
      } else {
        System.out.println("El triángulo es isósceles.");
      }
    } else {
      System.out.println("El triángulo es escaleno");
    }
    
    sc.close();
  }

}
