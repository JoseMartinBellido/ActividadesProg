import java.util.Scanner;

public class Tarea09e07 {

  public static final double PESETAS_POR_EURO = 166.368;
    
  public static void main (String[] args) {
      
    Scanner sc = new Scanner(System.in);
      
    double eurosAPtas;
  
    System.out.print("Inserte una cantidad de euros para convertir a pesetas: ");
      
    int euros = Integer.parseInt(sc.nextLine());
      
    eurosAPtas = euros * PESETAS_POR_EURO;
      
    System.out.println(euros+"€ son " + eurosAPtas + " pesetas");
      
    sc.close();
    
  }

}
