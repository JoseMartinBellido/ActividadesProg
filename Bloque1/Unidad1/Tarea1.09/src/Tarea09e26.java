import java.util.Scanner;

public class Tarea09e26 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double calificacion1;
    double calificacion2;
    double calificacion3;
    double notaMedia;
    boolean apruebaONo;
    
    System.out.println("Este programa calculará la nota media para todo el curso, dadas 3 calificaciones.");
    
    System.out.print("Indica la primera calificación: ");
    
    calificacion1 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Indica la segunda calificación: ");
    
    calificacion2 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Indica la tercera calificación: ");
    
    calificacion3 = Double.parseDouble(sc.nextLine());
    
    notaMedia = (calificacion1 + calificacion2 + calificacion3) / 3 ;
    
    apruebaONo = notaMedia >= 5;
    
    System.out.println("La nota media del curso será de: " + notaMedia +". ¿Está aprobado? " + apruebaONo);
    
    sc.close();
    
  }

}
