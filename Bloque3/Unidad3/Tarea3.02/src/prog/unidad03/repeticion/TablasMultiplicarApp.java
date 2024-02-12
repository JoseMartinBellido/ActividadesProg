package prog.unidad03.repeticion;

public class TablasMultiplicarApp {
  
  public static final int NUMERO_DE_TABLAS = 10;
  public static final int NUMERO_DE_MULTIPLICACIONES_POR_TABLA = 10;

  public static void main(String[] args) {
    
    System.out.println("TABLAS DE MULTIPLICAR");
    
    // Realizamos un bucle for dentro de otro para ir recorriendo una por una las tablas de multiplicar
    
    for (int i = 1; i <= NUMERO_DE_TABLAS; i++) {
      
      System.out.println("Tabla del " + i);
      System.out.println("-----------");
      for (int j = 1; j <= NUMERO_DE_MULTIPLICACIONES_POR_TABLA; j++) {
        System.out.println(i + " X " + j + " = " + (i*j));

      }
      
      System.out.println();
    }
    
  }
}
