import java.util.Scanner;

public class Tarea09e12 {

  public static final double PI = 3.1415;
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double radioBase;
    double altura;
    double volumen;
    
    System.out.print("Indica en cm el radio de la base del cono: ");
    
    radioBase = Double.parseDouble(sc.nextLine());
    
    System.out.print("Indica en cm la altura del cono: ");
    
    altura = Double.parseDouble(sc.nextLine());
    
    volumen = radioBase * radioBase * altura * PI/ 3;
    
    System.out.println("El volumen del cono es de " + volumen + " cm^3");
    
    sc.close();
    
  }

}
