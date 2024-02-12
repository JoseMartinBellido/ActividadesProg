import java.util.Scanner;

public class Tarea09e20 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double ladoA;
    double ladoB;
    double ladoC;
    
    /* He dividido la superficie en dos figuras geométricas claras. Una de ellas es el rectángulo formado por los lados B y C
     * La otra es el triángulo formado por la base B y la altura A-C. He pedido datos, calculado áreas y las he sumado.
     */
    
    double areaRectangulo;
    double areaTriangulo;
    
    System.out.print("Introduce la longitud del lado A: ");
    
    ladoA = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la longitud del lado B: ");
    
    ladoB = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la longitud del lado C: ");
    
    ladoC = Double.parseDouble(sc.nextLine());
    
    areaRectangulo = ladoB * ladoC;
    
    areaTriangulo = (ladoA - ladoC) * ladoB / 2;
    
    System.out.println("El área total de la superficie es de: " + (areaRectangulo + areaTriangulo));
    
    sc.close();
    
  }

}
