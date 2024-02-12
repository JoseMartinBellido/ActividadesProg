import java.util.Scanner;

public class Tarea09e30 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    int numero;
    boolean dosCifrasONo;
    
    System.out.println("Este programa calcula si el número tiene 2 cifras o no ");
    
    System.out.print("Introduce un número: ");
    
    numero = Integer.parseInt(sc.nextLine());
    
    // La forma de calcularlo va a ser si es >= 10 y <100. Esto se debe a que si es menor, tiene una cifra, y si es mayor tiene 3.
    // Además, considero los números tanto positivos como negativos que cumplen la condición.
    
    dosCifrasONo = (numero >= 10) && (numero < 100) || (numero <=-10) && (numero > -100);
    
    System.out.println("Se imprimirá true en caso de que se cumplan las condiciones y false en caso de que no lo haga:\n"
        +  dosCifrasONo);
    
    sc.close();
    
  }

}