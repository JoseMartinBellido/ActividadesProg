package prog.unidad03.repeticion;

import java.util.Scanner;

public class MediaPositivosApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("MediaPositivosApp");
    
    // Declaramos el primer número que no va a afectar a la suma y pedimos a continuación en bucle los siguientes
    // Declaramos la suma y el contador de positivos en 0;
    
    int numeroIntroducido;
    int sumaDePositivos = 0;
    int contadorDePositivos = 0;
    
    do {
      System.out.print("Introduce un número real positivo o cero (negativo para terminar): ");
      numeroIntroducido = Integer.parseInt(sc.nextLine());
      
      // Solo sumamos los números positivos
      if(numeroIntroducido >= 0) {
        sumaDePositivos += numeroIntroducido;
        contadorDePositivos++;
      }
      
    } while (numeroIntroducido >= 0);
    
    // Impresión de resultados
    System.out.println("La media de los " + contadorDePositivos + " números introducidos vale " + sumaDePositivos);
    
    sc.close();
  }

}
