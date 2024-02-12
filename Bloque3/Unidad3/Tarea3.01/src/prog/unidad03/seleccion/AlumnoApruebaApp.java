package prog.unidad03.seleccion;

import java.util.Scanner;

public class AlumnoApruebaApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Aprobados y suspensos");
    
    // Solicitamos los datos
    System.out.print("Introduce la calificación de la primera evaluación: ");
    double primeraNota = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la calificación de la segunda evaluación: ");
    double segundaNota = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la calificación de la tercera evaluación: ");
    double terceraNota = Double.parseDouble(sc.nextLine());
    
    // Calculamos la nota media
    double notaMedia = (primeraNota + segundaNota + terceraNota) / 3;
    
    // Consideramos las opciones para aprobado o suspenso e imprimimos resultado
    
    String aprobadoONo = (notaMedia >= 5) ? 
        "El alumno ha aprobado con una nota media de " + notaMedia : "El alumno ha suspendido con una nota media de " + notaMedia;
    
    System.out.println(aprobadoONo);
    
    sc.close();
    
  }

}
