import java.util.Scanner;

public class Tarea09e13 {

  public static final int KB_POR_MB = 1024;
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double mb;
    
    System.out.print("Introduce un número de MB para convertir a KB: ");
    
    mb = Double.parseDouble(sc.nextLine());
    
    System.out.println("La cantidad equivalente a " + mb + "MB son " + (mb*KB_POR_MB) + "KB");
    
    sc.close();
  }

}
