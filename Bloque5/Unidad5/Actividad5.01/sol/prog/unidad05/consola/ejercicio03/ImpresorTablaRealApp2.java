package prog.unidad05.consola.ejercicio03;

/**
 * Prueba de ImpresorTablaReal
 */
public class ImpresorTablaRealApp2 {

  /**
   * Punto de entrada a la aplicación
   * @param args Argumentos
   */
  public static void main(String[] args) {
    
    // Crea la tabla de pruebas
    double[][] tabla = {
      {10.123456, -123.5656121, 432.7817812},
      {1000.7871212, -8762.7877, 32.232323}
        
    };
    
    // La imprime
    System.out.println("Tabla de 2 x 3");
    System.out.println("---------------");
    ImpresorTablaReal.imprimeTabla(tabla, 2);
  }

}
