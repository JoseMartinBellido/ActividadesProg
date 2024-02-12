package unidad06.mapas.ejercicio04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Programa de terminal de punto de venta
 */
public class TerminalVentaApp {

  // Constantes
  // Codigo de descuento de 10%
  private static final String CODIGO_DESCUENTO_10 = "ECODTO";
  // Descuento del 10%
  private static final double DESCUENTO_10 = 0.1;
  
  // Atributos
  // Productos
  private Map<String, Double> productos;
  // Productos comprados
  private Map<String, Integer> compra;
  // Scanner para leer desde teclado
  private Scanner sc;

  public TerminalVentaApp() {
    // Iniciamos los precios
    productos = new HashMap<>();
    productos.put("avena", 2.21);
    productos.put("garbanzos", 2.39);
    productos.put("tomate", 1.59);
    productos.put("jengibre", 3.13);
    productos.put("quinoa", 4.5);
    productos.put("guisantes", 1.6);
    // Y la compra
    compra = new HashMap<>();
    // Scanner
    sc = new Scanner(System.in);
  }
  
  /**
   * Punto de entrada del programa
   * @param args
   */
  public static void main(String[] args) {
    TerminalVentaApp app = new TerminalVentaApp();
    app.run();
  }

  /**
   * Funcion principal no estática del programa
   */
  private void run() {
    // Cabecera
    System.out.println("TERMINAL DE PUNTO DE VENTA");
    
    // Solicitamos productos hasta que se introduzca uno en blanco
    String producto = "";
    do {
      // Solicitamos producto
      System.out.print("Introduzca el nombre del producto (vacío para terminar): ");
      producto = sc.nextLine();
      // Si no es vacío
      if (!producto.isEmpty()) {
        // Si existe el producto
        if (productos.containsKey(producto)) {
          // Solicitamos la cantidad
          System.out.print("Introduza la cantidad de producto comprada (número entero): ");
          int cantidadComprada = Integer.parseInt(sc.nextLine());
          // Obtenemos la cantidad de compra que hay ahora para ese producto (0 si aun no hay compra para el producto)
          int cantidadActual = compra.getOrDefault(producto, 0);
          // Le sumamos la cantidad comprada
          cantidadActual += cantidadComprada;
          // Y la almacenamos en la compra (si ya había entrada se sobreescribirá)
          compra.put(producto, cantidadActual);
        } else {
          // Producto no existente
          System.out.println("El producto especificado \"" + producto + "\" no está a la venta en esta tienda");
        }
      }
    } while (!producto.isEmpty());
    // Ya hemos terminado con la compra
    // Si hay algún producto en la compra
    if (!compra.isEmpty()) {
      // Inicialmente no hay descuento
      double descuento = 0;
      // Solicitamos el código de descuento
      System.out.print("Introduzca el código de descuento (vacío si no tiene ninguno): ");
      String codigo = sc.nextLine();
      // Si es correcto
      if (codigo.equals(CODIGO_DESCUENTO_10)) {
        // Anotamos el descuento
        descuento = DESCUENTO_10;
      }
      
      // Iniciamos el subtotal de la compra
      double subtotal = 0;
      // Imprimimos la compra
      // Primero la cabecera
      System.out.println("Producto Precio Cantidad Subtotal");
      System.out.println("---------------------------------");
      // Para cada elemento de la compra
      for (String productoComprado: compra.keySet()) {
        // Imprimimos el nombre
        System.out.print(justificaIzquierda(productoComprado, 8));
        System.out.print(" ");
        // Precio
        System.out.print(justificaDerecha(productos.get(productoComprado), 6));
        System.out.print(" ");
        // Cantidad
        System.out.print(justificaDerecha(compra.get(productoComprado), 8));
        System.out.print(" ");
        // Subtotal
        double importe = compra.get(productoComprado) * productos.get(productoComprado);
        importe = Math.round(importe * 100) / 100.0;
        System.out.print(justificaDerecha(importe, 8));
        System.out.println();
        // Sumamos el subtotal
        subtotal += importe;
      }
      System.out.println("---------------------------------");
      // Imprimimos el subtotal sin descuento
      System.out.println("Subtotal: " + subtotal);
      // Descuento
      double importeDescuento = Math.round(subtotal * descuento * 100) / 100.0;
      System.out.println("Descuento: " + importeDescuento);
      System.out.println("---------------------------------");
      double total = Math.round((subtotal - importeDescuento) * 100) / 100.0;
      System.out.println("Total: " + total);
    }
  }

  /**
   * Justifica el número a la derecha de forma que tenga la longitud
   *   especificada como mínimo
   * Si la longitud es menor se rellena con espacios
   * @param valor Valor a convertir a cadena
   * @param longitud Longitud mínima que debe tener el resultado
   * @return Valor del número relleno con espacios por la izquierda hasta
   *   alcanzar la longitud requerida
   */
  private String justificaDerecha(int valor, int longitud) {
    // Convertimos el número a cadena
    String resultado = String.valueOf(valor);
    // Y lo rellena
    return rellena(resultado, longitud, true);
  }

  /**
   * Justifica el número a la derecha de forma que tenga la longitud
   *   especificada como mínimo
   * Si la longitud es menor se rellena con espacios
   * @param valor Valor a convertir a cadena
   * @param longitud Longitud mínima que debe tener el resultado
   * @return Valor del número relleno con espacios por la izquierda hasta
   *   alcanzar la longitud requerida
   */
  private String justificaDerecha(double valor, int longitud) {
    // Convertimos el número a cadena
    String resultado = String.valueOf(valor);
    // Y lo rellena
    return rellena(resultado, longitud, true);
  }

  /**
   * Justifica un valor de cadena con espacios por la derecha
   * @param valor Valor a justificar
   * @param longitud Longitud mínima de la cadena (incluyendo espacios)
   * @return Cadena justificada
   */
  private String justificaIzquierda(String valor, int longitud) {
    return rellena(valor, longitud, false);
  }

  /**
   * Rellena una cadena con espacios hasta alcanzar una longitud determinada
   * @param valor Valor a rellenar
   * @param longitud Longitud mínima
   * @param inicio true si hay que rellenar por el inicio. false si hay que
   *   rellenar por el final
   * @return Cadena rellena.
   */
  private String rellena(String valor, int longitud, boolean inicio) {
    // Mientras que no tenga la longitud requerida
    while (valor.length() < longitud) {
      // Según por donde haya que rellenar añade un espacio por esa zona
      if (inicio) {
        valor = " " + valor;
      } else {
        valor += " ";
      }
    }
    // Devolvemos el resultado
    return valor;
  }

}
