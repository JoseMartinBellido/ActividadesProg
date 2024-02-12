package prog.unidad03.repeticion;

public class CuadriculaDiezPorDiezApp {
  
  public static final int NUMEROS_A_IMPRIMIR = 100;
  public static final int NUMERO_PARA_SALTO_DE_LINEA = 10;

  public static void main(String[] args) {
    
    System.out.println("NÚMEROS DEL 1 AL 100");
    
    // Separamos los números por una tabulación. Si el número es divisible por 10 añadimos un salto de línea.
    for (int i = 1 ; i <= NUMEROS_A_IMPRIMIR; i++) {
      System.out.print(i + "\t");
      if(i % NUMERO_PARA_SALTO_DE_LINEA == 0) System.out.print("\n");
      
    }
  }

}
