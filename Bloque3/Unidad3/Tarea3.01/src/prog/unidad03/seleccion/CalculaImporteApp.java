package prog.unidad03.seleccion;

import java.util.Scanner;

public class CalculaImporteApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Descuentos al comprar");

    //Solicitamos los datos por teclado
    System.out.print("Introduce el importe de la compra en euros: ");
    double importe = Double.parseDouble(sc.nextLine());
    
    // Dividimos los casos dependiendo de si el importe es superior o no a 100€
    if(importe > 100) {
      System.out.println("Como el importe es superior a 100€, la compra tiene un descuento del 20%.");
      System.out.println("El importe a pagar es " + (importe * 0.8) + "€");
    } else {
      System.out.println("Como el importe es inferior o igual a 100€, la compra no tiene descuento.");
      System.out.println("El importe a pagar es " + importe + "€");
    }
    
    sc.close();
    
  }

}
