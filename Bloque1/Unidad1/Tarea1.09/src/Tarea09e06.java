import java.util.Scanner;

public class Tarea09e06 {

  public static final double PESETAS_POR_EURO = 166.368;
    
    public static void main (String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      double pesetas;
      
      double ptasAEuros;
  
      System.out.print("Inserte una cantidad de pesetas para convertir a euros: ");
      
      pesetas = Double.parseDouble(sc.nextLine());
      
      ptasAEuros = pesetas / PESETAS_POR_EURO;
      
      System.out.println(pesetas+" ptas son " + ptasAEuros + " pesetas");
      
      sc.close();
    
    
  }

}
