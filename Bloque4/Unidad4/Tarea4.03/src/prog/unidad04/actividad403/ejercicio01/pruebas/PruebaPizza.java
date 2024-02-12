package prog.unidad04.actividad403.ejercicio01.pruebas;

import prog.unidad04.actividad403.ejercicio01.Pizza;
import prog.unidad04.actividad403.ejercicio01.PizzaAlreadyServedException;

/**
 * Prueba la clase Pizza
 */
public class PruebaPizza {
  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("PROGRAMA DE PRUEBA DE PIZZAS 2");

    // Creamos dos pizzas distintas
    Pizza pizza1 = new Pizza("mediana", "margarita");
    Pizza pizza2 = new Pizza("familiar", "funghi");
    
    // Intentamos crear pizzas con valores erróneos y debe lanzar excepciones
    try {
      Pizza pizzaErronea1 = new Pizza("grande", "margarita");
      System.out.println("Error. Se ha creado una pizza con valores erróneos");
    } catch (IllegalArgumentException e) {
      System.out.println("Se ha intentando crear una pizza con valores erróneos y ha fallado");
    }
    try {
      Pizza pizzaErronea2 = new Pizza("mediana", "barbacoa");
      System.out.println("Error. Se ha creado una pizza con valores erróneos");
    } catch (IllegalArgumentException e) {
      System.out.println("Se ha intentando crear una pizza con valores erróneos y ha fallado");
    }
    
    // Servimos la segunda pizza. Puede pero no debería lanzar una excepcion
    try {
      pizza2.sirve();
      System.out.println("La pizza se sirvió con éxito");
    } catch (PizzaAlreadyServedException e) {
      System.out.println("Error. La pizza no debía estar servida aun");
    }
    
    // Creamos otra pizza mas
    Pizza pizza3 = new Pizza("mediana", "cuatro quesos");
    
    // Imprimimos las pizzas
    System.out.println("Pizza 1. Tamaño: " + pizza1.getTamanyo() + ", Tipo: " + pizza1.getTipo() + ", Estado: " + pizza1.getEstado());
    System.out.println("Pizza 2. Tamaño: " + pizza2.getTamanyo() + ", Tipo: " + pizza2.getTipo() + ", Estado: " + pizza2.getEstado());
    System.out.println("Pizza 3. Tamaño: " + pizza3.getTamanyo() + ", Tipo: " + pizza3.getTipo() + ", Estado: " + pizza3.getEstado());

    // Servimos la segunda pizza (otra vez). Debe producir una excepcion
    try {
      pizza2.sirve();
      System.out.println("Error. La pizza se sirvió dos veces");
    } catch (PizzaAlreadyServedException e) {
      System.out.println("Ok. La pizza ya se había servido y ha fallado al hacerlo otra vez");
    }
    
    // Mostramos el número de pizzas creadas y servidas
    System.out.println("Número de pizzas creadas: " + Pizza.getPizzasCreadas());
    System.out.println("Número de pizzas servidas: " + Pizza.getPizzasServidas());
  }

}
