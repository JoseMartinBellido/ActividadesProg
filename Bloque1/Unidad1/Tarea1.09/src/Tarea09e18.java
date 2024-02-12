import java.util.Scanner;

public class Tarea09e18 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Scanner sc = new Scanner(System.in);
    
    double unidad1;
    double unidad2;
    double unidad3;
    double examenFinal;
    double trabajoExposicion;
    
    double notaFinal;
    
    System.out.print("Introduce la nota de la primera unidad: ");
    
    unidad1 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la nota de la segunda unidad: ");
    
    unidad2 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la nota de la tercera unidad: ");
    
    unidad3 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la nota del exámen final: ");
    
    examenFinal = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la nota de la exposición en clase: ");
    
    trabajoExposicion = Double.parseDouble(sc.nextLine());
    
    // Se calcula la nota final con la fórmula ofrecida por el ejercicio, usando su porcentaje para cada parte.
    
    notaFinal = ((unidad1 + unidad2 + unidad3) / 3) * 0.55 + examenFinal * 0.3 + trabajoExposicion * 0.15;
    
    System.out.println("La nota final de la asignatura es: " + notaFinal);
    
    sc.close();
  }

}
