package prog.unidad05.consola.ejercicio01;

/**
 * Clase que realiza la tabla de multiplicar de un número dado
 */
public class TablaMultiplicar {

  // Constantes para hacer la tabla de multiplicar, desde el mínimo hasta el máximo
  private static final int MINIMO = 1;
  
  private static final int MAXIMO = 10;
  
  // Número para la tabla de multiplicar
  private int numero;
  
  
  /**
   * Constructor que crea la tabla de multiplicar de un número
   * @param numero Número del cual se va a realizar la tabla de multiplicar. Debe ser mayor a 0.
   * @throws IllegalArgumentException Si el número introducido no cumple las condiciones.
   */
  public TablaMultiplicar(int numero) {
    
    // Si el número es menor o igual a cero, lanzamos excepción. Sino, almacenamos el atributo.
    if (numero <= 0) {
      throw new IllegalArgumentException();
    } else {
      this.numero = numero;
    }
  }
  
  /**
   * Método que imprime la tabla de multiplicar en 10 lineas, con formato "N x i = R", siendo N el número 
   * inicial de nuestra clase, i es el número que variará en la tabla de multiplicar del 1 al 10 y R el 
   * resultado del producto.
   */
  public void imprimeTabla() {
    int maximo = numero * MAXIMO;
    int cantidadDigitos = String.valueOf(maximo).length();
    for (int i = MINIMO; i <= MAXIMO; i++) {
      String textoAImprimir = "%d x %2d = %" + cantidadDigitos + "d%n";
      System.out.printf(textoAImprimir, numero, i, numero * i);
    }
  }

}
