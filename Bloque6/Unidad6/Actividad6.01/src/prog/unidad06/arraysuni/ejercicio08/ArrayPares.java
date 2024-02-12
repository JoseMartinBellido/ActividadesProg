package prog.unidad06.arraysuni.ejercicio08;

public class ArrayPares {

  // Constantes
  public static final int CANTIDAD_ELEMENTOS = 20;
  
  public static void main(String[] args) {

    System.out.println("NÚMEROS PARES");
    
    // Creamos el array y lo rellenamos con los números pares
    int[] pares = new int[CANTIDAD_ELEMENTOS];
    
    for (int i = 0; i < pares.length; i++) {
      pares[i] = (i + 1) * 2;
    }
    
    // Otra opción era establecer el número de comienzo en 2 e ir sumando 2 al anterior en cada vuelta
    
    // Imprimimos resultados
    String resultado = "Los primeros números pares son: ";
    for (int numero : pares) {
      resultado += numero + ", ";
    }
    
    System.out.println(resultado.substring(0, resultado.length() - 2));
  }

}
