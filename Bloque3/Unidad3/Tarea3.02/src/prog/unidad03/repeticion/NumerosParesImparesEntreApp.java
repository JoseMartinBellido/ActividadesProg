package prog.unidad03.repeticion;

import java.util.Scanner;

public class NumerosParesImparesEntreApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    /*
    System.out.print("Introduce el número de comienzo del intervalo: ");
    int limiteInferior = Integer.parseInt(sc.nextLine());
    
    System.out.print("Introduce el número de fin del intervalo: ");
    int limiteSuperior = Integer.parseInt(sc.nextLine());
    
    if (limiteInferior > limiteSuperior) {
      
      System.out.println("El número de inicio es mayor que el final. Terminamos el programa.");
      
    } else {
      
      for (int i = limiteInferior ; i <= limiteSuperior ; i++) {
        String mensaje;
        
        if (i % 2 == 0) {
          mensaje = "par";
        } else {
          mensaje = "impar";
        }
        
        String mensaje = (i % 2 == 0) ? "par" : "impar";
        
        System.out.println("El número " + i + " es " + mensaje);

      }
    }
    sc.close();
    */
    int limiteInferior;
    int limiteSuperior;
    
    do {
      System.out.print("Introduce el número de comienzo del intervalo: ");
      limiteInferior = Integer.parseInt(sc.nextLine());
      
      System.out.print("Introduce el número de fin del intervalo: ");
      limiteSuperior = Integer.parseInt(sc.nextLine());
      
      if (limiteSuperior < limiteInferior) {
        System.out.println("El rango de números está mal introducido. Introduce de nuevo los datos numéricos por favor.");
      }
      
    } while (limiteSuperior < limiteInferior);

    for (int i = limiteInferior ; i <= limiteSuperior ; i++) {
      
      String mensaje = (i % 2 == 0) ? "par" : "impar";
      
      System.out.println("El número " + i + " es " + mensaje);

    }
    
    sc.close();
    
  }

}
