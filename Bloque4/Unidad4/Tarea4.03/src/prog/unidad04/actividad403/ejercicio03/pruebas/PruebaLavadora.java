package prog.unidad04.actividad403.ejercicio03.pruebas;

import prog.unidad04.actividad403.ejercicio03.Lavadora;

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
    
    // Crea una lavadora con el precio base inválido
    try {
      System.out.println("Intentando crear una lavadora con un precio inválido");
      Lavadora lavadoraMala = new Lavadora(-1, "rojo", 'A', 75, 8);
      System.out.println("Error. Se ha creado correctamente una lavadora con un precio inválido");
    } catch (IllegalArgumentException e) {
      System.out.println("OK. Se ha impedido la creación de una lavadora con un precio incorrecto");
    }
    // Crea una lavadora con el color inválido
    try {
      System.out.println("Intentando crear una lavadora con un color niválido");
      Lavadora lavadoraMala = new Lavadora(650, "amarillo", 'A', 75, 8);
      System.out.println("Error. Se ha creado correctamente una lavadora con un color inválido");
    } catch (IllegalArgumentException e) {
      System.out.println("OK. Se ha impedido la creación de una lavadora con un color inválido");
    }
    // Crea una lavadora con la clasificación energética inválida
    try {
      System.out.println("Intentando crear una lavadora con una clasificación energética inválida");
      Lavadora lavadoraMala = new Lavadora(650, "rojo", 'G', 75, 8);
      System.out.println("Error. Se ha creado correctamente una lavadora con una clasificación energética inválida");
    } catch (IllegalArgumentException e) {
      System.out.println("OK. Se ha impedido la creación de una lavadora con una clasificación energética inválida");
    }
    // Crea una lavadora con el peso inválido
    try {
      System.out.println("Intentando crear una lavadora con un peso inválido");
      Lavadora lavadoraMala = new Lavadora(650, "rojo", 'A', 0, 8);
      System.out.println("Error. Se ha creado correctamente una lavadora con un peso inválido");
    } catch (IllegalArgumentException e) {
      System.out.println("OK. Se ha impedido la creación de una lavadora con un peso inválido");
    }
    // Crea una lavadora con la carga inválido
    try {
      System.out.println("Intentando crear una lavadora con una carga inválida");
      Lavadora lavadoraMala = new Lavadora(650, "rojo", 'A', 75, 0);
      System.out.println("Error. Se ha creado correctamente una lavadora con una carga inválida");
    } catch (IllegalArgumentException e) {
      System.out.println("OK. Se ha impedido la creación de una lavadora con una carga inválida");
    }
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
