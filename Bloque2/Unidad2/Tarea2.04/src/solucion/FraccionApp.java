package solucion;

import java.util.Scanner;
import paquete1.Fraccion;

public class FraccionApp {

  public static final void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Solicita los datos para las dos fracciones
    System.out.print("Introduzca el numerador de la primera fracción: ");
    int numerador = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el denominador de la primera fracción: ");
    int denominador = Integer.parseInt(sc.nextLine());
    
    // Creamos la primera Fraccion
    Fraccion fraccion1 = new Fraccion(numerador, denominador);
    
    // Repetimos la operación para la segunda
    System.out.print("Introduzca el numerador de la segunda fracción: ");
    numerador = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el denominador de la segunda fracción: ");
    denominador = Integer.parseInt(sc.nextLine());
    Fraccion fraccion2 = new Fraccion(numerador, denominador);

    // Calculamos las operaciones
    Fraccion suma = fraccion1.suma(fraccion2);
    Fraccion resta = fraccion1.resta(fraccion2);
    Fraccion producto = fraccion1.producto(fraccion2);
    Fraccion division = fraccion1.division(fraccion2);
    
    // Y las imprimimos
    System.out.println("La suma de las dos fracciones vale " + suma.getNumerador() + " / " + suma.getDenominador());
    System.out.println("La resta de las dos fracciones vale " + resta.getNumerador() + " / " + resta.getDenominador());
    System.out.println("El producto de las dos fracciones vale " + producto.getNumerador() + " / " + producto.getDenominador());
    System.out.println("La división de las dos fracciones vale " + division.getNumerador() + " / " + division.getDenominador());
    
    // Ahora intentamos simplificar los resultados
    paquete2.Fraccion otraSuma = new paquete2.Fraccion(suma.getNumerador(), suma.getDenominador());
    paquete2.Fraccion sumaSimplificada = otraSuma.simplifica();
    paquete2.Fraccion otraResta = new paquete2.Fraccion(resta.getNumerador(), resta.getDenominador());
    paquete2.Fraccion restaSimplificada = otraResta.simplifica();
    paquete2.Fraccion otroProducto = new paquete2.Fraccion(producto.getNumerador(), producto.getDenominador());
    paquete2.Fraccion productoSimplificado = otroProducto.simplifica();
    paquete2.Fraccion otraDivision = new paquete2.Fraccion(division.getNumerador(), division.getDenominador());
    paquete2.Fraccion divisionSimplificada = otraDivision.simplifica();
    
    // Y las imprimimos
    System.out.println("La suma simplificada de las dos fracciones vale " + sumaSimplificada.getNum() + " / " + sumaSimplificada.getDen());
    System.out.println("La resta simplificada de las dos fracciones vale " + restaSimplificada.getNum() + " / " + restaSimplificada.getDen());
    System.out.println("El producto simplificado de las dos fracciones vale " + productoSimplificado.getNum() + " / " + productoSimplificado.getDen());
    System.out.println("La division simplificada de las dos fracciones vale " + divisionSimplificada.getNum() + " / " + divisionSimplificada.getDen());
    
    
    sc.close();
  }
}
