import java.util.Scanner;

public class Tarea09e09 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double base;
    double altura;
    double area;
    
    System.out.print("Indica en cm la base del triángulo: ");
    
    base = Double.parseDouble(sc.nextLine());
    
    System.out.print("Indica en cm la altura del triángulo: ");
    
    altura = Double.parseDouble(sc.nextLine());
    
    area = base * altura / 2;
    
    System.out.println("El área de un triángulo de base " + base + "cm y " + altura + "cm de altura es de " + area + "cm^2");
    
    sc.close();
    
  }

}
