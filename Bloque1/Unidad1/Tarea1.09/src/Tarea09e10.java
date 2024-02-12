import java.util.Scanner;

public class Tarea09e10 {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    double base;
    
    double total;
    
    System.out.print("Indica la cantidad de base imponible: ");
    
    base = Double.parseDouble(sc.nextLine());
    
    System.out.print("Indica la cantidad de base imponible: ");
    
    double iva = Double.parseDouble(sc.nextLine());
    
    total = base * (1+iva);
    
    System.out.println("Aplicando el 21% a la factura, queda el total en " + total + "€.");
    
    sc.close();
    
  }

}