package prog.unidad04.actividad402.ejercicio05;

public class Zona {
  

  // ------------------------------ Bloque de atributos ------------------------------
  
  /**
   * Número de entradas de una zona
   */
  private int entradasPorVender;
  
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Constructor con un parámetro.
   * @param entradasIniciales Define el número de entradas iniciales por vender. Si es erróneo, su valor por defecto será 50.
   */
  public Zona(int entradasIniciales) {
    // Consideramos un caso inicial erróneo y ponemos por defecto 50.
    if (entradasIniciales < 0) {
      System.out.println("El número de entradas iniciales no pueden ser un número negativo. Se establecerá por defecto: 50.");
      entradasIniciales = 50;
    }
    
    entradasPorVender = entradasIniciales;

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
   * Método para vender un número de entradas aportado por el usuario. Se venderán todas si es posible, o cero en caso contrario.
   * @param entradas Número de entradas que intentan ser compradas por el usuario
   * @return Número de entradas vendidas al final. Será el número inicial que se intenta comprar, o cero si no quedan suficientes.
   */
  public int vender(int entradas) {
    
    int entradasVendidas = 0;
    
    if (entradas <= entradasPorVender) {
      entradasPorVender -= entradas;
      entradasVendidas = entradas;
      System.out.println("Venta realizada correctamente.");
    } else
      System.out.println("El número de entradas que intenta comprar es mayor del existente. No se venderá ninguna.");
    
    return entradasVendidas;
    
  }

}
