package prog.unidad04.actividad402.ejercicio06.pruebas;

import prog.unidad04.actividad402.ejercicio06.Circulo;
import prog.unidad04.actividad402.ejercicio06.Punto;
import prog.unidad04.actividad402.ejercicio06.Rectangulo;
import prog.unidad04.actividad402.ejercicio06.Triangulo;

/**
 * Prueba Circulo, Triangulo, Rectangulo (y Punto)
 */
public class PruebaFiguras {
  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("PROGRAMA DE PRUEBA DE FIGURAS");
    
    // Creamos un triángulo 
    Triangulo triangulo = new Triangulo(new Punto(0,0), new Punto(0, 1), new Punto(1, 0));

    // Circulo
    Circulo circulo = new Circulo(new Punto(0,0), 2.5);
    
    // Y dos rectángulos. El segundo es en realidad un cuadrado
    Rectangulo rectangulo = new Rectangulo(new Punto(0, 0), new Punto(2, 3));
    Rectangulo cuadrado = new Rectangulo(new Punto(0, 0), new Punto(2, 2));
    
    // Calculamos área y perímetro de todas las figuras
    // Para los rectángulos usamos además el método esCuadrado
    System.out.println("Area triangulo = " + triangulo.area());
    System.out.println("Perimetro triangulo = " + triangulo.perimetro());
    System.out.println("Area circulo = " + circulo.area());
    System.out.println("Perimetro circulo (circunferencia) = " + circulo.perimetro());
    System.out.println("Area rectángulo no cuadrado = " + rectangulo.area());
    System.out.println("Perimetro rectángulo no cuadrado = " + rectangulo.perimetro());
    System.out.println("Area rectángulo cuadrado = " + cuadrado.area());
    System.out.println("Perimetro rectángulo cuadrado = " + cuadrado.perimetro());
    System.out.println("El primer rectángulo es cuadrado?: " + (rectangulo.esCuadrado() ? "si" : "no"));
    System.out.println("El segundo rectángulo es cuadrado?: " + (cuadrado.esCuadrado() ? "si" : "no"));
  }

}
