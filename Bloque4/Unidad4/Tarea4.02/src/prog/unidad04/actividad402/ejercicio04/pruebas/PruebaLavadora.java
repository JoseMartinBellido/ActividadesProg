package prog.unidad04.actividad402.ejercicio04.pruebas;

import prog.unidad04.actividad402.ejercicio04.Lavadora;

public class PruebaLavadora {

  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("LAVADORAS");
    
    // Creamos una por defecto, otra con pocos y otra con muchos parámetros
    Lavadora lavadora1 = new Lavadora();
    Lavadora lavadora2 = new Lavadora(500, 25);
    Lavadora lavadora3 = new Lavadora(650, "rojo", 'A', 75, 8);
    
    // Imprimimos las tres lavadoras
    System.out.println("Imprimimos las tres lavadoras");
    System.out.println(obtenerCadenaLavadora(lavadora1));
    System.out.println(obtenerCadenaLavadora(lavadora2));
    System.out.println(obtenerCadenaLavadora(lavadora3));
    
    // Imprimimos los precios finales de las tres lavadoras
    System.out.println("Imprimimos los precios finales de las tres lavadoras");
    System.out.println("Precio Lavadora 1 = " + lavadora1.getPrecioFinal());
    System.out.println("Precio Lavadora 2 = " + lavadora2.getPrecioFinal());
    System.out.println("Precio Lavadora 3 = " + lavadora3.getPrecioFinal());

  }

  /**
   * Obtiene una cadena con la información de la lavadora dada
   * @param lavadora Lavadora sobre la que extraer información
   * @return Cadena con la información de la lavadora
   */
  private static String obtenerCadenaLavadora(Lavadora lavadora) {
    return "Precio Base: " + lavadora.getPrecioBase() + ", Color: "
      + lavadora.getColor() + ", Consumo Energético: " + lavadora.getConsumoEnergetico()
      + ", Peso: " + lavadora.getPeso() + ", Carga Máxima: " + lavadora.getCarga();
  }

}
