package prog.unidad04.actividad403.ejercicio08.pruebas;

import java.util.Scanner;
import prog.unidad04.actividad403.ejercicio08.Fraccion;

/**
 * Prueba la clase Fraccion
 */
public class PruebaFraccion {

  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("PROGRAMA DE PRUEBA DE FRACCIONES");

    // Solicitamos al usuario los datos de dos fracciones y las creamos
    // Las creamos aqui y las iniciamos a null porque hay que usarlas en este bloque
    Fraccion fraccion1 = null;;
    Fraccion fraccion2 = null;
    try {
      System.out.print("Introduzca el numerador de la primera fracción: ");
      int numerador = Integer.parseInt(sc.nextLine());
      System.out.print("Introduzca el denominador de la primera fracción (no debe ser cero): ");
      int denominador = Integer.parseInt(sc.nextLine());
      fraccion1 = new Fraccion(numerador, denominador);

      System.out.print("Introduzca el numerador de la segunda fracción: ");
      numerador = Integer.parseInt(sc.nextLine());
      System.out.print("Introduzca el denominador de la segunda fracción (no debe ser cero): ");
      denominador = Integer.parseInt(sc.nextLine());
      fraccion2 = new Fraccion(numerador, denominador);
    } catch (NumberFormatException e) {
      // Numero introducido no correcto
      System.out.println("Error. Número introducido no correcto. Terminando");
      return;
    } catch (IllegalArgumentException e) {
      System.out.println("Error. El denominador de una fracción no puede ser cero. Terminando");
      return;
    }
    
    // Calculamos la suma, resta, producto y división
    Fraccion suma = fraccion1.suma(fraccion2);
    Fraccion resta = fraccion1.resta(fraccion2);
    Fraccion producto = fraccion1.multiplica(fraccion2);
    Fraccion division = fraccion1.divide(fraccion2);

    // Muestra las fracciones usando un método privado de esta clase
    System.out.println("Los resultados de las operaciones son");
    System.out.println("Suma: " + suma.obtieneString());
    System.out.println("Resta: " + resta.obtieneString());
    System.out.println("Producto: " + producto.obtieneString());
    System.out.println("Division: " + division.obtieneString());

    // Simplificamos los resultados
    suma.simplifica();
    resta.simplifica();
    producto.simplifica();
    division.simplifica();
    
    // Y volvemos a imprimir los resultados ya simplificados
    System.out.println("Los resultados simplificados de las operaciones son");
    System.out.println("Suma: " + suma.obtieneString());
    System.out.println("Resta: " + resta.obtieneString());
    System.out.println("Producto: " + producto.obtieneString());
    System.out.println("Division: " + division.obtieneString());
    
  }
}
