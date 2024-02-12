package prog.unidad03.seleccion;

import java.util.Scanner;

public class EcuacionesSegundoGradoApp {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Programa de cálculo de ecuaciones de segundo grado. Forma de la ecuación: ax^2 + bx + c = 0");
    
    // Solicitamos los coeficientes de la ecuación.
    
    System.out.print("Introduce un valor para el coeficiente a: ");
    double a = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce un valor para el coeficiente b: ");
    double b = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce un valor para el coeficiente c: ");
    double c = Double.parseDouble(sc.nextLine());
    
    /* Calculamos el discriminante (parte de la raíz en la solución de la ecuación de segundo grado
     *  y establecemos la condición. En este caso, diferenciamos por:
     * discriminante > 0 -> Dos soluciones
     * discriminante = 0 -> Una solución
     * discriminante < 0 -> Ninguna solución
     */
    
    double discriminante = b*b - 4 * a * c;
    double denominador = 2 * a;
    
    if(discriminante > 0) {
      
      // Calculamos las 2 soluciones reales y las imprimimos por pantalla
      double solucion1 = (Math.sqrt(discriminante) - b) / denominador;
      double solucion2 = (-b - Math.sqrt(discriminante)) / denominador;
      
      System.out.println("Existen 2 soluciones reales: x = " + solucion1 + " y x = " + solucion2);
      
    } else if(discriminante == 0) {
      
      // Calculamos la única solución real y la imprimimos
      double solucion = -b / denominador;
      
      System.out.println("La única solución real es: x = " + solucion);
      
    } else {
      System.out.println("La ecuación no tiene soluciones reales.");      
    }
    
    sc.close();
  }

}
