import java.util.Scanner;

public class Tarea09e21 {
  
  public static final double LITROS_POR_GALON = 3.785;

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double litros;
    double galones;
    double precioPorGalon;
    double precioTotal;
    
    System.out.print("Introduce el número de litros de la producción del día: ");
    
    litros = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce el precio en euros por cada galón: ");
    
    precioPorGalon = Double.parseDouble(sc.nextLine());
    
    galones = litros / LITROS_POR_GALON;
    
    precioTotal = galones * precioPorGalon;
    
    System.out.println("Con una producción de " + galones + " galones se recibirán " + precioTotal + "€");
    
    sc.close();
    
  }

}
