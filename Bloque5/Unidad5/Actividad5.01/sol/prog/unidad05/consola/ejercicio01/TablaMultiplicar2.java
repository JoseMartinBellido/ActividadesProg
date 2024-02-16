package prog.unidad05.consola.ejercicio01;

/**
 * Clase que representa la tabla de multiplicar de un número entero determinado
 */
public class TablaMultiplicar2 {
  
  // Numero de la tabla
  private int numero;
  
  /**
   * Crea la tabla de multiplicar del número dado
   * @param numero Número de la tabla de multiplicar (tabla del ....). Debe ser mayor que cero
   * @throws IllegalArgumentException Si el número proporcionado es menor o igual a cero
   */
  public TablaMultiplicar2(int numero) {
    // Si el número es mayor que cero
    if (numero > 0) {
      // Lo almacena en el atributo
      this.numero = numero;
    } else {
      // Lanza una excepción
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Imprime la tabla por consola
   * La tabla se imprime en 10 líneas del formato "N x M = R",
   * donde N es el número dado en constructor, M es un número
   * que va cambiando de 1 a 10 y R es el resultado de multiplicar
   * N por M
   * Los números van alineados a la derecha y encolumnados
   */
  public void imprimeTabla() {
    // Calculamos las longitudes del número y del mayor resultado (10 * numero)
    // Usamos el método de convertir a cadena y calcular la longitud del resultado
    int longitudNumero = String.format("%d", numero).length();
    int longitudResultado = String.format("%d", numero * 10).length();

    // Creamos la cadena de formato empleando las longitudes
    String formato = "%2d x %" + longitudNumero + "d = %" + longitudResultado + "d%n";
    // Para cada número
    for (int i = 1; i <= 10; i++) {
      // Imprime la linea correspondiente
      System.out.printf(formato, i, numero, numero * i);
    }
  }

}
