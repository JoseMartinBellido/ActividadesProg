import java.util.Scanner;

public class Tarea09e05 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Indica un valor entero: ");
    
    int valor1 = Integer.parseInt(sc.nextLine());
    
    System.out.print("Indica un segundo valor entero: ");
    
    int valor2 = Integer.parseInt(sc.nextLine());
    
    System.out.println("El valor de sumar " + valor1 + " y " + valor2 + " es " + (valor1 + valor2));
    
    System.out.println("El valor de restar " + valor2 + " a " + valor1 + " es " + (valor1 - valor2));
    
    System.out.println("El valor de multiplicar " + valor1 + " y " + valor2 + " es " + (valor1 * valor2));
    
    System.out.println("El valor de entero de dividir " + valor1 + " entre " + valor2 + " es " + (valor1 / valor2));
    
    System.out.println("El valor del módulo al dividir " + valor1 + " entre " + valor2 + " es " + (valor1 % valor2));
    
    sc.close();
    
  }

}
