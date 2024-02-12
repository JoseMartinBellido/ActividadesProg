import java.util.Scanner;

public class Tarea09e28 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Scanner sc = new Scanner(System.in);
    
    int edadPrimero;
    int edadSegundo;
    int edadTercero;
    boolean cumpleCondiciones;
    
    System.out.print("Indica la primera edad: ");
    
    edadPrimero = Integer.parseInt(sc.nextLine());
    
    System.out.print("Indica la segunda edad: ");
    
    edadSegundo = Integer.parseInt(sc.nextLine());
    
    System.out.print("Indica la tercera edad: ");
    
    edadTercero = Integer.parseInt(sc.nextLine());
    
    cumpleCondiciones = (edadPrimero > edadSegundo) && (edadSegundo > edadTercero);
    
    System.out.println("Se imprimirá true en caso de que se cumplan las condiciones y false en caso de que no lo haga:\n" 
    + cumpleCondiciones);
    
    sc.close();
  }

}
