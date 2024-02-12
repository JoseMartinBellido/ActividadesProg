package prog.unidad06.mapas.ejercicio04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TerminalVentasApp {

  /**
   * Código de descuento ECODTO
   */
  private static final String CODIGO_ECODTO = "ECODTO";
  
  /**
   * Descuento en tanto por uno del código ECODTO
   */
  private static final double DESCUENTO_ECODTO = 0.1;
  
  public static void main(String[] args) {

    System.out.println("TERMINAL DE PUNTO DE VENTA");
    
    // Scanner y producto introducid en la compra
    Scanner sc = new Scanner(System.in);
    String producto = "";
    
    // Mapa de producto - precio
    Map<String, Double> mapaPrecios = new HashMap<>();
    mapaPrecios.put("avena", 2.21);
    mapaPrecios.put("garbanzos", 2.39);
    mapaPrecios.put("tomate", 1.59);
    mapaPrecios.put("jengibre", 3.31);
    mapaPrecios.put("quinoa", 4.50);
    mapaPrecios.put("guisantes", 1.60);
    
    // Mapa de producto - cantidad
    Map<String, Integer> mapaCantidades = new HashMap<>();
    
    do {
      // Solicitamos el producto
      System.out.print("Introduzca el nombre del producto (vacío para terminar): ");
      producto = sc.nextLine();
      
      if (!producto.isBlank()) {
     // Si está en el mapa, solicitamos la cantidad
        if (mapaPrecios.keySet().contains(producto)) {
          System.out.print("Introduzca la cantidad de producto comprada (número entero): ");
          
          try {
            int cantidad = Integer.parseInt(sc.nextLine());
            // Comprobamos que la cantidad sea correcta
            if (cantidad >= 0) {
              
              // Comprobamos si el producto está ya añadido en el mapa de cantidades. Sino, se añade
              mapaCantidades.put(producto, 
                  (mapaCantidades.get(producto) == null) ? cantidad : mapaCantidades.get(producto) + cantidad);
              
            // Avisamos si la cantidad es incorrecta  
            } else {
              System.out.println("La cantidad indicada no es un número válido. No se añadirá a la compra");
            }
          } catch (NumberFormatException e) {
            System.out.println("La cantidad introducida no es un número entero correcto. No se añadirá a la compra.");
          }
        
        // Si el producto no se encuentra en el mapa de precios
        } else {
          System.out.println("El producto especificado \"" + producto + "\" no está a la venta en esta tienda.");
        }

      }
      
      
    } while (!producto.isBlank());
    
    // Solicitamos descuento y comprobamos si es válido
    System.out.print("Introduzca el código de descuento (vacío si no tiene ninguno): ");
    String descuento = sc.nextLine();
    
    if (descuento.equals(CODIGO_ECODTO)) {
      System.out.println("Código descuento aplicado.");
    } else if (!descuento.isBlank()) {
      System.out.println("Código descuento erróneo. No se aplicará descuento en su compra.");
    }
    
    // Imprimimos resultados
    System.out.println("Producto Precio Cantidad Subtotal");
    System.out.println("---------------------------------");
    
    
    double subtotal = 0;
    
    // Si no está vacío, calculamos la factura
    if (!mapaCantidades.keySet().isEmpty()) {
      
      for (String prod : mapaCantidades.keySet()) {
        // Variables
        double subtotalProducto = mapaPrecios.get(prod) * mapaCantidades.get(prod);
        subtotal += subtotalProducto;
        // Impresión de resultado
        System.out.println(prod + "\t" + String.format("%6.2f", mapaPrecios.get(prod)) 
            + String.format("%8d", mapaCantidades.get(prod)) +  String.format("%10.2f", subtotalProducto));
      }
    }
    
    System.out.println("---------------------------------");
    System.out.println("Subtotal: " + String.format("%.2f", subtotal));
    
    // Descuento
    double totalDescontado = (descuento.equals(CODIGO_ECODTO)) ? subtotal * DESCUENTO_ECODTO : 0;
    System.out.println("Descuento: " + String.format("%.2f", totalDescontado));
    
    // Total
    System.out.println("---------------------------------");
    System.out.println("Total: " + String.format("%.2f", (subtotal - totalDescontado)));
    
    sc.close();
  }

}
