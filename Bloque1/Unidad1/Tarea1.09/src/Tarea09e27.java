import java.util.Scanner;

public class Tarea09e27 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    int edad;
    boolean mayorONo;
    
    System.out.println("Este programa se usará para saber si tienes edad para obtener el permiso de conducir. "
        + "\nEn caso de devolver true, si podrás obtenerlo. En caso de que sea false, no podrás.");
    
    System.out.print("Indica tu edad en años (sin decimales): ");
    
    edad = Integer.parseInt(sc.nextLine());
    
    mayorONo = edad>=18;
    
    System.out.println(mayorONo);
    
    sc.close();
    
  }

}
