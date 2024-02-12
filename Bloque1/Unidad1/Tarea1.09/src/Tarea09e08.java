import java.util.Scanner;

public class Tarea09e08 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);

    System.out.print("Indica en cm el largo del rectángulo: ");
    
    double largo = Double.parseDouble(sc.nextLine());
    
    System.out.print("Indica en cm el ancho del rectángulo: ");
    
    double ancho = Double.parseDouble(sc.nextLine());
    
    double area = largo * ancho;
    
    System.out.println("El área de un rectángulo de " + largo + "cm x" + ancho + "cm es de " + area + "cm^2");
    
    sc.close();
    
  }

}
