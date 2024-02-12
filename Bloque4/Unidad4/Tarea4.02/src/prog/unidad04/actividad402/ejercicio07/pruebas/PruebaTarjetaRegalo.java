package prog.unidad04.actividad402.ejercicio07.pruebas;

import prog.unidad04.actividad402.ejercicio07.TarjetaRegalo;

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

    // Gasta en las dos tarjetas
    System.out.println("Hacemos algún gasto en las tarjetas");
    tarjeta1.gasta(45.90);
    tarjeta2.gasta(5);
    // Este gasto debe fallar porque no hay saldo suficiente
    tarjeta2.gasta(200);
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
