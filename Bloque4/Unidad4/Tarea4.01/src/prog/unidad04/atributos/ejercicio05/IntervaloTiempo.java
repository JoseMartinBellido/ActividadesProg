package prog.unidad04.atributos.ejercicio05;

public class IntervaloTiempo {

  // Constantes de tiempo máximo y mínimo
  
  /**
   * int. Constante. Tiempo mínimo que puede pasar en cualquier unidad del intervalo: 0
   */
  public static final int MINIMO = 0;
  
  /**
   * int. Constante. Tiempo máximo que puede pasar en segundos o minutos: 59
   */
  public static final int MAXIMO_SEGUNDOS_Y_MINUTOS = 59;
  
  /**
   * int. Número de horas del intervalo. Mayor o igual a 0.
   */
  public int horas;
  
  /**
   * int. Número de minutos del intervalo. Debe estar entre 0 y 59.
   */
  public int minutos;
  
  /**
   * int. Número de segundos del intervalo. Debe estar entre 0 y 59.
   */
  public int segundos;
}
