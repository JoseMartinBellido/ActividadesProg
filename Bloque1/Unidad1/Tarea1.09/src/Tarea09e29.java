import java.util.Scanner;

public class Tarea09e29 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    int numero;
    boolean cumpleCondiciones;
    
    System.out.println("Este programa calcula si el número está comprendido entre 20 y 30: ");
    
    System.out.print("Introduce un número: ");
    
    numero = Integer.parseInt(sc.nextLine());
    
    cumpleCondiciones = (numero >= 20) && (numero < 30);
    
    System.out.println("Se imprimirá true en caso de que se cumplan las condiciones y false en caso de que no lo haga:\n"
        +  cumpleCondiciones);
    
    sc.close();
    
  }

}
