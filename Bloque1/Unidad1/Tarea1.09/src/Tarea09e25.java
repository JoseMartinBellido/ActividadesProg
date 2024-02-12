import java.util.Scanner;

public class Tarea09e25 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Scanner sc = new Scanner(System.in);
    
    int numero;
    
    boolean parONo;
    
    System.out.print("Indica un número entero por pantalla para informar si es par o no: ");
     
    numero = Integer.parseInt(sc.nextLine());
    
    parONo = numero % 2 == 0;
    
    System.out.println("El número " + numero + " es par en caso de true e impar en caso de false: " + parONo);

    sc.close();
    
  }

}
