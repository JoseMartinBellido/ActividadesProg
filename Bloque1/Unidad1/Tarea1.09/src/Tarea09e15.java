import java.util.Scanner;

public class Tarea09e15 {

  public static final double COMISION = 0.1;
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double salarioBase;
    double ventaPrimera;
    double ventaSegunda;
    double ventaTercera;

    double salarioFinal;

    
    System.out.print("Introduce tu salario base en €: ");
    
    salarioBase = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce el valor en € de la primera venta: ");
    
    ventaPrimera = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce el valor en € de la segunda venta: ");
    
    ventaSegunda = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce el valor en € de la tercera venta: ");
    
    ventaTercera = Double.parseDouble(sc.nextLine());
    
    // El salario final se calcula sumando al salario base las ventas por su comisión.
    
    salarioFinal = salarioBase + (ventaPrimera + ventaSegunda + ventaTercera) * COMISION;
    
    System.out.println("El salario total sería de: " + salarioFinal);
    
    sc.close();
  }

}
