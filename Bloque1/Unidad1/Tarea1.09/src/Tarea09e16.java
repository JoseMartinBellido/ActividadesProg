import java.util.Scanner;

public class Tarea09e16 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double inversion1;
    double inversion2;
    double inversion3;
    double inversionTotal;
    
    System.out.print("Introduce la cantidad en € que invierte la primera persona: ");
    
    inversion1 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la cantidad en € que invierte la segunda persona: ");
    
    inversion2 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la cantidad en € que invierte la tercera persona: ");
    
    inversion3 = Double.parseDouble(sc.nextLine());
    
    inversionTotal = inversion1 + inversion2 + inversion3;
    
    System.out.println("La primera persona ha invertido un " + (inversion1 * 100 / inversionTotal) + "%");
    System.out.println("La segunda persona ha invertido un " + (inversion2 * 100 / inversionTotal) + "%");
    System.out.println("La tercera persona ha invertido un " + (inversion3 * 100 / inversionTotal) + "%");
    
    sc.close();
    
  }

}
