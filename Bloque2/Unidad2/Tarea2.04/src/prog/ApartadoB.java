package prog;

import java.util.Scanner;

// Importamos la clase Fraccion de paquete1 para poder usarlo sin necesidad de incluir el paquete en el nombre.
import paquete1.Fraccion;

public class ApartadoB {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Solicitamos los datos por Scanner para crear los objeto de paquete1 Fraccion
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Programa para usar Fracciones del paquete paquete1");
    
    System.out.print("Introduce un numerador entero para la primera fracción: ");  
    int numerador = Integer.parseInt(sc.nextLine());
    
    System.out.print("Introduce un denominador entero para la primera fracción: ");
    int denominador = Integer.parseInt(sc.nextLine());
 
    // Instanciamos la variable fraccion1
    
    Fraccion fraccion1 = new Fraccion(numerador, denominador);
    
    // Reutilizamos las variables numerador y denominador para pedir los datos de la segunda fracción
    
    System.out.print("Introduce un numerador entero para la primera fracción: ");  
    numerador = Integer.parseInt(sc.nextLine());
    
    System.out.print("Introduce un denominador entero para la primera fracción: ");
    denominador = Integer.parseInt(sc.nextLine());
    
    // Instanciamos la variable fraccion2
    
    Fraccion fraccion2 = new Fraccion(numerador, denominador);
    
    // Realizamos las operaciones con dicha fracción
    
    Fraccion suma = fraccion1.suma(fraccion2);
    Fraccion resta = fraccion1.resta(fraccion2);    
    Fraccion producto = fraccion1.producto(fraccion2);
    Fraccion division = fraccion1.division(fraccion2);
    
    // Imprimimos los resultados por pantalla
    
    System.out.println("\n");
    System.out.println("El resultado de la suma de ambas fracciones es de " + suma.getNumerador() + "/" + suma.getDenominador());
    System.out.println("El resultado de la resta de ambas fracciones es de " + resta.getNumerador() + "/" + resta.getDenominador());
    System.out.println("El resultado del producto de ambas fracciones es de " + producto.getNumerador() + "/" + producto.getDenominador());
    System.out.println("El resultado de la division de ambas fracciones es de " + division.getNumerador() + "/" + division.getDenominador());
    
    // Para simplificar los resultados, convertimos las fracciones resultado a la del paquete paquete2. 
    
    paquete2.Fraccion sumaSimplificada = new paquete2.Fraccion(suma.getNumerador(), suma.getDenominador());
    paquete2.Fraccion restaSimplificada = new paquete2.Fraccion(resta.getNumerador(), resta.getDenominador());
    paquete2.Fraccion productoSimplificada = new paquete2.Fraccion(producto.getNumerador(), producto.getDenominador());
    paquete2.Fraccion divisionSimplificada = new paquete2.Fraccion(division.getNumerador(), division.getDenominador());
    
    // Sobreescribimos las variables con su versión simplificada.
    
    sumaSimplificada = sumaSimplificada.simplifica();
    restaSimplificada = restaSimplificada.simplifica();
    productoSimplificada = productoSimplificada.simplifica();
    divisionSimplificada = divisionSimplificada.simplifica();
    
    
    // Imprimimos por pantalla los resultados simplificados
    
    System.out.println("\n");
    System.out.println("El resultado de la suma de ambas fracciones es de " + sumaSimplificada.getNum() + "/" + sumaSimplificada.getDen());
    System.out.println("El resultado de la resta de ambas fracciones es de " + restaSimplificada.getNum() + "/" + restaSimplificada.getDen());
    System.out.println("El resultado del producto de ambas fracciones es de " + productoSimplificada.getNum() 
    + "/" + productoSimplificada.getDen());
    System.out.println("El resultado de la division de ambas fracciones es de " + divisionSimplificada.getNum() 
    + "/" + divisionSimplificada.getDen());
    
    sc.close();
  }

}
