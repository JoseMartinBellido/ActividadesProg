import java.util.Scanner;

public class Tarea09e17 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Scanner sc = new Scanner(System.in);
    
    double presupuestoAnual;
    double ginecologia;
    double pediatria;
    double traumatologia;
    
    System.out.print("Introduce el presupuesto anual del hospital en €: ");
    
    presupuestoAnual = Double.parseDouble(sc.nextLine());
    
    ginecologia = presupuestoAnual * 0.4;
    traumatologia = presupuestoAnual * 0.35;
    pediatria = presupuestoAnual * 0.25;
    
    System.out.println("El presupuesto anual para ginecología es de " + ginecologia + "€");
    System.out.println("El presupuesto anual para traumatologia es de " + traumatologia + "€");
    System.out.println("El presupuesto anual para pediatria es de " + pediatria + "€");
    
    sc.close();
  }

}
