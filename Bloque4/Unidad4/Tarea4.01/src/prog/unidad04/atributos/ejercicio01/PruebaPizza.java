package prog.unidad04.atributos.ejercicio01;

import java.util.Scanner;

public class PruebaPizza {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("PROGRAMA DE MANEJO DE PIZZAS.");
    
    try {
      // Primero, metemos todo el bloque en un try/catch para evitar un posible error en el formato del int
      // Pedimos el número total de pizzas
      
      System.out.print("Introduzca la cantidad de pizzas a crear (1 o más): ");
      int numeroDePizzas = Integer.parseInt(sc.nextLine());
      
      // Solo hacemos toda la operación si tenemos un número de pizzas válido
      if (numeroDePizzas > 0) {
        
        // Por cada pizza, creamos un bucle for dependiendo del número de pizzas requeridas
        for (int i = 1; i <= numeroDePizzas; i++) {
          
          // Creamos un objeto de la clase Pizza e introducimos los atributos uno a uno según se requieren al usuario
          Pizza pizza = new Pizza();
          
          // Solicitamos el tamaño de la pizza. Si no es el adecuado, insistimos
          do{
            System.out.print("Introduzca el tamaño de la pizza " + i + "(" + Pizza.TAMANIO_MEDIANA + " / " + Pizza.TAMANIO_FAMILIAR + "): ");
            pizza.tamanio = sc.nextLine();

            if (!pizza.tamanio.equalsIgnoreCase(Pizza.TAMANIO_MEDIANA) && !pizza.tamanio.equalsIgnoreCase(Pizza.TAMANIO_FAMILIAR))
              System.out.println("El tamaño de la pizza no concuerda con lo ofrecido. Inténtelo de nuevo.");
            
          } while (!pizza.tamanio.equalsIgnoreCase(Pizza.TAMANIO_MEDIANA) && !pizza.tamanio.equalsIgnoreCase(Pizza.TAMANIO_FAMILIAR));
          
          // Solicitamos el tipo de la pizza. Si no es adecuado, insistimos
          do{
            System.out.print("Introduzca el tipo de la pizza " + i + " (" + Pizza.TIPO_MARGARITA + " / " + Pizza.TIPO_CUATRO_QUESOS 
                + " / " + Pizza.TIPO_FUNGHI + "): ");
            pizza.tipo = sc.nextLine();

            if (!pizza.tipo.equalsIgnoreCase(Pizza.TIPO_MARGARITA) && !pizza.tipo.equalsIgnoreCase(Pizza.TIPO_CUATRO_QUESOS) 
                && !pizza.tipo.equalsIgnoreCase(Pizza.TIPO_FUNGHI))
              System.out.println("El tipo de la pizza no concuerda con lo ofrecido. Inténtelo de nuevo.");
            
          } while (!pizza.tipo.equalsIgnoreCase(Pizza.TIPO_MARGARITA) && !pizza.tipo.equalsIgnoreCase(Pizza.TIPO_CUATRO_QUESOS) 
              && !pizza.tipo.equalsIgnoreCase(Pizza.TIPO_FUNGHI));
          
          // Pedimos al usuario que nos diga si quiere que le sirvamos la pizza. Usamos una variable auxiliar.
          String servida;
          
          do{
            System.out.print("¿Servir la pizza? (s / n): ");
            servida = sc.nextLine();

            if (!servida.equalsIgnoreCase("s") && !servida.equalsIgnoreCase("n")) 
              System.out.println("Las únicas opciones son s / n. Inténtelo de nuevo.");
            else {
              if(servida.equalsIgnoreCase("s"))
                pizza.estado = Pizza.ESTADO_SERVIDA;
              
              else
                pizza.estado = Pizza.ESTADO_PEDIDA;
            }
            
          } while (!servida.equalsIgnoreCase("s") && !servida.equalsIgnoreCase("n"));
          
          // Actualizamos los atributos estáticos dependiendo del caso
          Pizza.numeroDePizzasTotales++;
          
          if (pizza.estado.equalsIgnoreCase(Pizza.ESTADO_SERVIDA))
            Pizza.numeroDePizzasServidas++;
          
          // Imprimimos los resultados.
          
          System.out.println("Datos de la pizza " + i);
          System.out.println("Tamaño: " + pizza.tamanio);
          System.out.println("Tipo: " + pizza.tipo);
          System.out.println("Estado: " + pizza.estado);
          System.out.println("Pizzas totales creadas: " + Pizza.numeroDePizzasTotales);
          System.out.println("Pizzas totales servidas: " + Pizza.numeroDePizzasServidas);
        }
        

        
      } else {
        //Caso en el que no se ha metido un número de pizzas totales mayor que 0
        System.out.println("Lo sentimos, no podemos servir " + numeroDePizzas + " pizzas.");
      }
      
    } catch (NumberFormatException e) {
      System.out.println("No se ha introducido una cantidad válida de pizzas. Inténtelo de nuevo.");
    }
    
    
    
    sc.close();
  }

}
