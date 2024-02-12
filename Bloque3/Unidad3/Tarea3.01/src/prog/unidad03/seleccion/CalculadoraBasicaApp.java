package prog.unidad03.seleccion;

import java.util.Scanner;

public class CalculadoraBasicaApp {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Programa de calculadora básica");
    
    // Solicitud de operación y datos
    System.out.println("Operaciones: S (Suma), R (Resta), P (Producto), D (División)");
    System.out.println("Introduce la operación a realizar: ");
    char operacion = sc.nextLine().toUpperCase().charAt(0);
    
    System.out.print("Introduce el primer operando: ");
    double operando1 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce el segundo operando: ");
    double operando2 = Double.parseDouble(sc.nextLine());
    
    double resultado;
    
    // Distintos casos a tratar
    
    switch (operacion) {
      case 'S':
        resultado = operando1 + operando2;
        System.out.println("El resultado de sumar " + operando1 + " con " + operando2 + " es de: " + resultado);
        break;
      case 'R':
        resultado = operando1 - operando2;
        System.out.println("El resultado de restar a " + operando1 + " el númerop " + operando2 + " es de: " + resultado);
        break;
      case 'P':
        resultado = operando1 * operando2;
        System.out.println("El resultado del producto de " + operando1 + " con " + operando2 + " es de: " + resultado);
        break;
      case 'D':
        resultado = operando1 / operando2;
        System.out.println("El resultado de la división de " + operando1 + " entre " + operando2 + " es de: " + resultado);
        break;
      default:
        System.out.println("La operación indicada no es válida");
    }
    
    sc.close();
  }

}
