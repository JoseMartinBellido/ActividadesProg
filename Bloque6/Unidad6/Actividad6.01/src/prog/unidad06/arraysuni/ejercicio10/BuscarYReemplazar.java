package prog.unidad06.arraysuni.ejercicio10;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays2;
import java.util.Scanner;

public class BuscarYReemplazar {

  // Constantes
  public static final int CANTIDAD_NUMEROS = 30;
  public static final int VALOR_MINIMO = 0;
  public static final int VALOR_MAXIMO = 20;
  
  public static void main(String[] args) {

    // Scanner
    Scanner sc = new Scanner(System.in);
    
    System.out.println("BUSCAR Y REEMPLAZAR EN ARRAY");
    
    // Generamos el array de aleatorios y lo imprimimos
    int[] aleatorios = UtilidadesArrays2.generaArrayEnteroAleatorio
        (CANTIDAD_NUMEROS, VALOR_MINIMO, VALOR_MAXIMO);
    
    System.out.println("Array original");
    for (int i = 0; i < aleatorios.length; i++) {
      System.out.print(aleatorios[i] + " ");
    }
    System.out.println();
    // Se solicitan los dos valores
    boolean valoresCorrectos = false;
    
    int valorASustituir = 0;
    int valorSustituto = 0;
    
    do {
      try {
        System.out.print("Introduzca el valor a sustituir: ");
        valorASustituir = Integer.parseInt(sc.nextLine());
        
        System.out.print("Introduzca el valor sustituto: ");
        valorSustituto = Integer.parseInt(sc.nextLine());
            
        // Valores correctos si se llega aquí
        valoresCorrectos = true;
        
      } catch (NumberFormatException e) {
        System.out.println("Uno de los valores o ambos no tienen el formato correcto");
      }
      
    } while (!valoresCorrectos);
    
    // Se modifica el array y se imprime
    for (int i = 0; i < aleatorios.length; i++) {
      // Si el valor del array coincide con el valor a sustituir, se modifica y se imprime entrecomillado
      if (valorASustituir == aleatorios[i]) {
        aleatorios[i] = valorSustituto;
        System.out.print("\'" + aleatorios[i] + "\' ");     
      } else {
        System.out.print(aleatorios[i] + " "); 
      }
      
    }
    
    // Cerramos el Scanner
    sc.close();
    
  }

}
