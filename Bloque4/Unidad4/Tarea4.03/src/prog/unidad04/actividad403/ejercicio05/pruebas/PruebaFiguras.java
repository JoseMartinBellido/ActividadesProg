package prog.unidad04.actividad403.ejercicio05.pruebas;

import prog.unidad04.actividad403.ejercicio05.Circulo;
import prog.unidad04.actividad403.ejercicio05.FiguraException;
import prog.unidad04.actividad403.ejercicio05.Punto;
import prog.unidad04.actividad403.ejercicio05.Rectangulo;
import prog.unidad04.actividad403.ejercicio05.Triangulo;

/**
 * Prueba Circulo, Triangulo, Rectangulo (y Punto)
 */
public class PruebaFiguras {
  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("PROGRAMA DE PRUEBA DE FIGURAS");
    
    // Creamos un triángulo 
    Triangulo triangulo = new Triangulo(new Punto(0,0), new Punto(0, 1), new Punto(1, 0));
    
    // Otro "malo" (los tres puntos están alineados). Debe lanzar una excepción
    try {
      System.out.println("Intentado crear un triángulo con los vertices alineados");
      Triangulo trianguloMalo = new Triangulo(new Punto(0,0), new Punto (2, 1), new Punto(4,2));
      // Esta línea no debería ejecutarse porque lo anterior deberia fallar
      System.out.println("Error. Se ha creado un triángulo con los vértices alineados");
    } catch (FiguraException e) {
      System.out.println("OK. Se evitó crear el triángulo");
    }

    // Circulo
    Circulo circulo = new Circulo(new Punto(0,0), 2.5);
    
    // Otro "malo" (el radio es negativo). Debe lanzar una excepción
    try {
      System.out.println("Intentado crear un círculo con el radio negativo");
      Circulo circuloMalo = new Circulo(new Punto(0,0), -2);
      // Esta línea no debería ejecutarse porque lo anterior deberia fallar
      System.out.println("Error. Se ha creado un círculo de radio de negativo");
    } catch (FiguraException e) {
      System.out.println("OK. Se evitó crear el círculo");
    }

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
