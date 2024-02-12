package prog.unidad03.seleccion;

import java.util.Scanner;

public class SituacionAlumnoApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Promociona o no promociona.");
    
    // Solicitamos las notas de las asignaturas
    System.out.print("Introduce la calificación de matemáticas: ");
    double notaMatematicas = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la calificación de Lengua: ");
    double notaLengua = Double.parseDouble(sc.nextLine());
    
    // Dividimos los casos
    if (notaMatematicas >= 5 && notaLengua >= 5) {
      System.out.println("El alumno promociona sin asignaturas pendientes.");
    } else if(notaMatematicas >= 5 || notaLengua >= 5) {
      System.out.println("El alumno promociona con una asignatura pendiente.");
    } else {
      System.out.println("El alumno repite curso.");
    }
    
    sc.close();
  }

}
