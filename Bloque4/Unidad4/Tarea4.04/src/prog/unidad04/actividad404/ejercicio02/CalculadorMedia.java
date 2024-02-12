package prog.unidad04.actividad404.ejercicio02;

/**Clase destinada al cálculo de la media de todos los valores introducidos
 * @author jose
 * @version 1.0
 */
public class CalculadorMedia {

  // Suma de todos los números introducidos para el cálculo
  private double suma;
  
  // contador de todos los números introducidos para el cálculo
  private int contador;
  
  /**
   * Constructor que almacena números para calcular la media de todos ellos.
   * @param valorInicial Primer valor introducido para el cálculo de la media.
   */
  public CalculadorMedia(double valorInicial) {
    
    suma = valorInicial;
    contador = 1;
  }
  
  /**
   * Método que agrega un nuevo número al cálculo de la media.
   * @param numero Nuevo número introducido al cálculo.
   */
  public void add(double numero) {
    suma += numero;
    contador++;
  }
  
  /**
   * Método que calcula la media de todos los números introducidos
   * @return Un número real que representa la media
   */
  public double getMedia() {
    return suma / contador;
  }
  
  
}
