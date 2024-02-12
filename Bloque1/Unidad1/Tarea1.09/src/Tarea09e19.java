import java.util.Scanner;

public class Tarea09e19 {
  
  public static final double PI = 3.1415;

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double radio;
    
    double area;
    double longitud;
    
    System.out.print("Introduce el radio del círculo en cm: ");
    
    radio = Double.parseDouble(sc.nextLine());
    
    // Se aplican las fórmulas del área del círculo y de la longitud de la circunferencia.
    
    area = PI * radio * radio;
    longitud = PI * radio;
    
    System.out.println("El área del círculo de radio " + radio + " es de " + area + " y la longitud de su circunferencia " 
        + longitud);
    
    sc.close();
  }

}
