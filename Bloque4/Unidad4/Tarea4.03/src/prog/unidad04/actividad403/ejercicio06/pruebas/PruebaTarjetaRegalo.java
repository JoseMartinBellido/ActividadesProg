package prog.unidad04.actividad403.ejercicio06.pruebas;

import prog.unidad04.actividad403.ejercicio06.InsufficientFundsException;
import prog.unidad04.actividad403.ejercicio06.TarjetaRegalo;

/**
 * Prueba la clase TarjetaRegalo
 */
public class PruebaTarjetaRegalo {

  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("TARJETAS REGALO MANEGO");
    
    // Creamos dos tarjetas
    TarjetaRegalo tarjeta1 = new TarjetaRegalo(100);
    TarjetaRegalo tarjeta2 = new TarjetaRegalo(120);
    
    // Imprimimos los datos de las dos tarjetas
    System.out.println("Las tarjetas recien creadas tienen la siguiente información");
    System.out.println(tarjeta1.obtenerCadena());
    System.out.println(tarjeta2.obtenerCadena());
    
    try {
      // Intentamos crear una tarjeta con saldo negativo
      System.out.println("Intentamos crear una tarjeta con saldo negativo");
      TarjetaRegalo tarjetaMala = new TarjetaRegalo(-10);
      // Este mensaje no se debería mostrar
      System.out.println("Error. Se ha podido crear una tarjeta con saldo negativo");
    } catch (IllegalArgumentException e) {
      // Se debe imprimir este mensaje
      System.out.println("OK. Se ha impedido la creación de la tarjeta");
    }

    // Gasta en las dos tarjetas
    System.out.println("Hacemos algún gasto en las tarjetas");
    tarjeta1.gasta(45.90);
    tarjeta2.gasta(5);
    
    try {
      // Este gasto debe fallar porque no hay saldo suficiente
      System.out.println("Intentando gastar en una tarjeta más cantidad que el saldo");
      tarjeta2.gasta(200);
      System.out.println("Error. Se ha permitido gastar mas que el saldo");
    } catch (InsufficientFundsException e) {
      System.out.println("OK. Se ha prohibido gastar más que el saldo");
    }
    tarjeta1.gasta(3.55);
    
    // Volvemos a imprimir las tarjetas
    System.out.println("Después del gasto las tarjetas tienen el siguiente estado");
    System.out.println(tarjeta1.obtenerCadena());
    System.out.println(tarjeta2.obtenerCadena());
    
    // Fusionamos las dos para obtener una nueva
    System.out.println("Fusionamos las dos tarjetas y obtenemos una nueva");
    TarjetaRegalo tarjeta3 = tarjeta1.fusionaCon(tarjeta2);
    
    // Imprimimos las tres tarjetas para ver como han quedado
    System.out.println("Después de la fusión, las tarjetas tienen el siguiente estado");
    System.out.println(tarjeta1.obtenerCadena());
    System.out.println(tarjeta2.obtenerCadena());
    System.out.println(tarjeta3.obtenerCadena());
  }

}
