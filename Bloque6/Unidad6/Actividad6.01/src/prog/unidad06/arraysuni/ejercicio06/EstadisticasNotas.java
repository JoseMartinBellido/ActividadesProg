package prog.unidad06.arraysuni.ejercicio06;

/**
 * @author Jose
 * Clase EstadisticasNotas, que calcula estadísticas sobre las calificaciones de un grupo
 * de alumnos
 */
public class EstadisticasNotas {

  // Constantes
  private static final int CANTIDAD_NOTAS = 11;
  private static final int CALIFICACION_MINIMA = 0;
  private static final int CALIFICACION_MAXIMA = 10;
  
  // Atributos
  private int[] frecuenciaNotas;
  
  // Constructores
  /**
   * Constructor de la clase. Inicializa el objeto vacío
   */
  public EstadisticasNotas() {
    frecuenciaNotas = new int[CANTIDAD_NOTAS];
  }
  
  /**
   * Método que añade una nueva calificación al conjunto ya almacenado
   * @param calificacion Nueva calificación, que debe tener un valor entre 0 y 10, ambos incluidos.
   * @throws IllegalArgumentException En caso de que la calificación no se encuentre entre los valores 
   * válidos
   */
  public void addCalificacion (int calificacion) {
    // Si la calificación no se encuentra en el rango indicado, lanzamos el error
    if (calificacion < CALIFICACION_MINIMA || calificacion > CALIFICACION_MAXIMA) {
      throw new IllegalArgumentException();
    // Si es correcta, subimos la frecuencia en la que aparece en 1
    } else {
      frecuenciaNotas[calificacion]++;
    }
  }
  
  /**
   * Método que calcula la calificación media de todas las notas obtenidas
   * @return La calificación media de todas las notas. Será cero si aún no hay notas introducidas
   */
  public double calificacionMedia() {
    
    // Contador para la cantidad de notas al realizar la media y la suma acumulada
    int cantidadDeNotas = 0;
    double sumaDeNotas = 0;
    
    // Recorremos el array y modificamos las variables para calcular la media
    for (int i = 0; i < frecuenciaNotas.length; i++) {
      // La cantidad de notas se irá acumulando
      cantidadDeNotas += frecuenciaNotas[i];
      // La suma de Notas se realiza dependiendo de la posición y de la frecuencia
      sumaDeNotas += i * frecuenciaNotas[i];
    }
    
    // Devolvemos la media dependiendo de si hay notas introducidas o no
    return (compruebaFrecuenciaNotasVacio()) ? sumaDeNotas / cantidadDeNotas : 0;
  }
  
  /**
   * Método que calcula la moda de las calificaciones (calificación más repetida)
   * @return Devuelve la moda. En caso de tener la misma frecuencia, se devolverá el valor más bajo
   * @throws EstadisticasNotasException2 En caso de que no haya notas introducidas
   */
  public int calificacionModa() throws EstadisticasNotasException2 {
    
    // Si el array está vacío, lanzamos el error. En caso contrario, operamos
    if (!compruebaFrecuenciaNotasVacio()) {
      throw new EstadisticasNotasException2();
    }
    
    // Recorremos el array frecuenciaNotas para calcular la moda, ya que llegados aquí, no está vacío
    int frecuencia = 0;
    int moda = 0;
    
    for (int i = 0; i < frecuenciaNotas.length; i++) {
      // Si la frecuencia es mayor, modificamos la moda
      if (frecuenciaNotas[i] > frecuencia) {
        frecuencia = frecuenciaNotas[i];
        moda = i;
        
      // Si son iguales, adoptamos como moda la calificación más baja, pero la frecuencia sería igual 
      } else if (frecuenciaNotas[i] == frecuencia) {
        moda = (i < moda) ? i : moda;
      }
    }
    
    return moda;
    
  }
  
  /**
   * Método que comprueba si tenemos calificaciones añadidas o no
   * @return true si hay calificaciones, false en caso contrario
   */
  private boolean compruebaFrecuenciaNotasVacio() {

    // Recorremos el array y comprobamos si hay elementos
    for (int frecuencia : frecuenciaNotas) {
      if (frecuencia != 0) {
        return true;
      }
    }
    // Si llegamos aquí, no hay elementos
    return false;
  }
  
}
