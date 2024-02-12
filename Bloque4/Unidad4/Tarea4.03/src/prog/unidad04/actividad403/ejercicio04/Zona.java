package prog.unidad04.actividad403.ejercicio04;

public class Zona {
  

  // ------------------------------ Bloque de atributos ------------------------------
  
  /**
   * Número de entradas de una zona
   */
  private int entradasPorVender;
  
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Constructor con un parámetro.
   * @param entradasIniciales Define el número de entradas iniciales por vender. Debe ser mayor o igual a 1.
   * @throws IllegalArgumentException Si uno de los parámetros tiene un valor no válido.
   */
  public Zona(int entradasIniciales) {
    // Consideramos un caso inicial erróneo y ponemos por defecto 50.
    if (entradasIniciales < 1) {
      throw new IllegalArgumentException();
    } else {
      entradasPorVender = entradasIniciales;
    }
    

  }
  
  // ------------------------------ Bloque de métodos ------------------------------

  /**
   * Método que obtiene el número de entradas que quedan por vender.
   * @return Número de entradas que quedan por vender.
   */
  public int getEntradasPorVender() {
    return entradasPorVender;
    
  }
  
  /**
   * Método para vender un número de entradas aportado por el usuario. Se venderán todas si es posible.
   * @param entradas Número de entradas que intentan ser compradas por el usuario
   * @return Número de entradas vendidas al final.
   * @throws ZonaException Si el no quedan entradas suficientes.
   */
  public int vender(int entradas) throws ZonaException {
    
    int entradasVendidas = 0;
    
    if (entradas <= entradasPorVender) {
      entradasPorVender -= entradas;
      entradasVendidas = entradas;
      System.out.println("Venta realizada correctamente.");
    } else
      throw new ZonaException();
    
    return entradasVendidas;
    
  }

}
