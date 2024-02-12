package prog.unidad06.arraysuni.ejercicio06;

/**
 * Clase que calcula estadísticas sobre las calificaciones de un grupo de alumnos
 */
public class EstadisticasNotas2 {

  // Calificaion Mínima
  private static final int CALIFICACION_MINIMA = 0;
  // Calificacioń Máxima
  private static final int CALIFICACION_MAXIMA = 10;
  // Total de calificaciones
  private static final int CALIFICACIONES = 11;
  
  // Array con las frecuencias de las calificaciones
  private  int[] frecuenciaCalificaciones;
  
  /**
   * Constructor. Inicializa el objeto y la frecuencia de cada nota es cero
   */
  public EstadisticasNotas2() {
    frecuenciaCalificaciones = new int[CALIFICACIONES];
  }
  
  /**
   * Añade una nueva aparición de la calificación indicada
   * @param calificacion Calificacion. Debe valer entre 0 y 10, ambos inclusive
   * @throws IllegalArgumentException Si la calificación no es válida
   */
  public void addCalificacion(int calificacion) {
   
    // Si la calificacion es válida
    if (calificacion >= CALIFICACION_MINIMA && calificacion <= CALIFICACION_MAXIMA) {
      // Añade uno a la frecuencia de la calificacion
      frecuenciaCalificaciones[calificacion]++;
    } else {
      // Argumento inválido
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Obtiene la calificación media de la clase
   * @return Calificación media de la clase. Cero si no se han introducido calificaciones
   *   aún
   */
  public double calificacionMedia() {
    // Inicia la suma y la cantidad a cero
    double suma = 0;
    int elementos = 0;
    // Para cada calificación
    for (int calificacion = CALIFICACION_MINIMA; calificacion <= CALIFICACION_MAXIMA; calificacion++) {
      // Sumamos la calificación por el número de veces que aparece
      suma += calificacion * frecuenciaCalificaciones[calificacion];
      // Añadimos la frecuencia al número de elementos
      elementos += frecuenciaCalificaciones[calificacion];
    }
    // Devolvemos el resultado teniendo cuidado si no hay elementos
    if (elementos > 0) {
      return suma / elementos;
    } else {
      return 0;
    }
  }

  /**
   * Obtiene la calificación moda de la clase. La calificacioń moda es aquella que tienen
   *   más alumnos.
   * @return Calificación moda de la clase. Si hay varias se devuelve la más baja
   * @throws EstadisticasNotasException2 Si no se han introducido calificaciones
   */
  public int calificacionModa() throws EstadisticasNotasException2 {
    // Moda inicial -1
    int moda = 0;
    // Calificacion Moda inicial -1
    int calificacionModa = -1;
    // Para cada calificacion
    for (int calificacion = CALIFICACION_MINIMA; calificacion <= CALIFICACION_MAXIMA; calificacion++) {
      // Si la frecuencia de la calificacion es mayor que la moda
      if (frecuenciaCalificaciones[calificacion] > moda) {
        // Almacenamos la calificación y la moda
        moda = frecuenciaCalificaciones[calificacion];
        calificacionModa = calificacion;
      }
    }
    // Si hay alguna moda
    if (calificacionModa >= CALIFICACION_MINIMA) {
      // La devuelve
      return calificacionModa;
    } else {
      // Excepcion
      throw new EstadisticasNotasException2();
    }
  }

}
