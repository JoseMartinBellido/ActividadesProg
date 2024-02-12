package prog.unidad03.repeticion;

import java.util.Scanner;

public class SumaParesIntervaloApp {

  public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
    
    System.out.println("SUMA DE PARES DE UN INTERVALO");
    
    // Declaramos los dos números para poder usarlos en el bucle
    System.out.print("Introduce el número de comienzo del intervalo: ");
    int limiteInferior = Integer.parseInt(sc.nextLine());
    
    System.out.print("Introduce el número de fin del intervalo: ");
    int limiteSuperior = Integer.parseInt(sc.nextLine());
    
    // Solicitamos la entrada de datos de forma infinita mientras no se hagan correctamente
    while (limiteSuperior < limiteInferior) {
      
      System.out.println("Error. El número de inicio (" + limiteInferior + ") debe ser menor o igual al de final (" 
          + limiteSuperior + "). Inténtelo de nuevo.");
      
      System.out.print("Introduce el número de comienzo del intervalo: ");
      limiteInferior = Integer.parseInt(sc.nextLine());
      
      System.out.print("Introduce el número de fin del intervalo: ");
      limiteSuperior = Integer.parseInt(sc.nextLine());
    } 
    
    // Realizamos la suma de los números pares del intervalo.
    // En caso de que coincidan el límite inferior y superior, no debería haber problema con el siguiente bucle.
    int sumaIntervalo = limiteInferior % 2 == 0 ? limiteInferior : 0;
    
    for( int i = limiteInferior + 1; i <= limiteSuperior; i++) {
      
      sumaIntervalo += (i % 2 == 0) ? i : 0;
    }
    
    // Imprimimos el resultado
    System.out.println("La suma de los números pares desde el " + limiteInferior + " hasta " + limiteSuperior + " vale " + sumaIntervalo);
    
    sc.close();
    
    
  }

}
