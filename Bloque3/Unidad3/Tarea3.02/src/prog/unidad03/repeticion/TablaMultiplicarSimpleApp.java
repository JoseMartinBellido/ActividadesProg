package prog.unidad03.repeticion;

import java.util.Scanner;

public class TablaMultiplicarSimpleApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("TABLA DE MULTIPLICAR DE.....");
    
    //Solicitamos el número entero de la tabla de multiplicar
    System.out.print("¿De qué número entero quieres mostrar su tabla de multiplicar?: ");
    int numeroTablaMultiplicar = Integer.parseInt(sc.nextLine());
    
    System.out.println("Tabla del " + numeroTablaMultiplicar);
    
    //Realizamos la tabla con un bucle for del 1 al 10
    for (int i = 1; i < 11; i++) {
      System.out.println(numeroTablaMultiplicar + " X " + i + " = " + (numeroTablaMultiplicar * i));
    }
    sc.close();
  }

}
