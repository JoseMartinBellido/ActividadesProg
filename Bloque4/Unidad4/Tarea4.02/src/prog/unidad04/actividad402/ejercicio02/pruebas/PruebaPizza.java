package prog.unidad04.actividad402.ejercicio02.pruebas;

import prog.unidad04.actividad402.ejercicio02.Pizza;

/**
 * Prueba la clase Pizza
 */
public class PruebaPizza {
  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("PROGRAMA DE PRUEBA DE PIZZAS 3");

    // Creamos dos pizzas distintas
    Pizza pizza1 = new Pizza("mediana", "margarita");
    Pizza pizza2 = new Pizza("familiar", "funghi");
    
    // Intentamos crear pizzas con valores erróneos y debe imprimir errores
    Pizza pizzaErronea1 = new Pizza("grande", "margarita");
    Pizza pizzaErronea2 = new Pizza("mediana", "barbacoa");
    
    // Servimos la segunda pizza
    pizza2.sirve();
    
    // Creamos otra pizza mas
    Pizza pizza3 = new Pizza("mediana", "cuatro quesos");
    
    // Imprimimos las pizzas, incluyendo el coste
    System.out.println("Pizza 1. Tamaño: " + pizza1.getTamanyo() + ", Tipo: " + pizza1.getTipo() + ", Estado: " + pizza1.getEstado() + ", Coste: " + pizza1.coste());
    System.out.println("Pizza 2. Tamaño: " + pizza2.getTamanyo() + ", Tipo: " + pizza2.getTipo() + ", Estado: " + pizza2.getEstado() + ", Coste: " + pizza2.coste());
    System.out.println("Pizza 3. Tamaño: " + pizza3.getTamanyo() + ", Tipo: " + pizza3.getTipo() + ", Estado: " + pizza3.getEstado() + ", Coste: " + pizza3.coste());

    // Servimos la segunda pizza (otra vez). Debe mostrar mensaje
    pizza2.sirve();
    
    // Mostramos el número de pizzas creadas y servidas
    System.out.println("Número de pizzas creadas: " + Pizza.getPizzasCreadas());
    System.out.println("Número de pizzas servidas: " + Pizza.getPizzasServidas());
  }

}
