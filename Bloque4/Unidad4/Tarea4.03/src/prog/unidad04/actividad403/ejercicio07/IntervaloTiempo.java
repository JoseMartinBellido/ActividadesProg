package prog.unidad04.actividad403.ejercicio07;

public class IntervaloTiempo {


  // ------------------------------ Bloque de atributos ------------------------------
  
  // Valor mínimo de tiempo que se puede introducir en un intervalo para cualquiera de las tres unidades
  private static int VALOR_MINIMO_TIEMPO = 0;
  
  // Valor máximo de tiempo que se puede introducir en un intervalo para minutos y segundos
  private static int VALOR_MAXIMO_SEGUNDOS_Y_MINUTOS = 59;
  
  
  /**
   * Segundos del intervalo
   */
  private int segundos;
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Construye un intervalo de tiempo con horas, minutos y segundos.
   * @param horas Las horas del intervalo. Debe ser un número mayor que cero.
   * @param minutos Los minutos del intervalo. Debe ser un número entre 0 y 59. 
   * @param segundos Los segundos del intervalo. Debe ser un número entre 0 y 59.
   * @throws IllegalArgumentException En caso de que uno de los parámetros no se encuentre dentro de su intervalo.
   */
  public IntervaloTiempo(int horas, int minutos, int segundos) {
    
    if (horas < VALOR_MINIMO_TIEMPO || minutos < VALOR_MINIMO_TIEMPO || minutos > VALOR_MAXIMO_SEGUNDOS_Y_MINUTOS 
        || segundos < VALOR_MINIMO_TIEMPO || segundos > VALOR_MAXIMO_SEGUNDOS_Y_MINUTOS) {
      throw new IllegalArgumentException();
    }

    this.segundos = horas * 3600 + minutos*60 + segundos;
    
  }
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Método que suma dos intervalos de tiempo.
   * @param intervalo Intervalo que sumaremos al objeto sobre el que llamamos el método.
   * @return Un nuevo intervalo de tiempo que sea la suma de los dos anteriores.
   */
  public IntervaloTiempo suma(IntervaloTiempo otro) {
    
    int segundosSuma = this.segundos + otro.segundos;
    
    return new IntervaloTiempo(obtenerHorasDeSegundos(segundosSuma),obtenerMinutosDeSegundos(segundosSuma),
        obtenerRestoSegundosDeSegundos(segundosSuma));
    
  }
  
  
  /**
   * Método que resta dos intervalos de tiempo.
   * @param intervalo Intervalo que sumaremos al objeto sobre el que llamamos el método.
   * @return Un nuevo intervalo de tiempo que sea la suma de los dos anteriores.
   * @throws IntervaloTiempoException En caso de que el segundo intervalo sea mayor que el primero.
   */
  public IntervaloTiempo resta(IntervaloTiempo otro) throws IntervaloTiempoException {
    
    if (this.segundos - otro.segundos > 0) {
      
      int segundosResta = this.segundos - otro.segundos;
      
      return new IntervaloTiempo(obtenerHorasDeSegundos(segundosResta),obtenerMinutosDeSegundos(segundosResta),
          obtenerRestoSegundosDeSegundos(segundosResta));
    }

    else
      throw new IntervaloTiempoException();
    
  }
  
  /**
   * Devuelve una cadena descriptiva del intervalo de tiempo en formato "AAh BBm CCs", 
   * siendo AA las horas, BB los minutos y CC los segundos.
   * @return Cadena de caractéres con formato "AAh BBm CCs".
   */
  public String obtenerCadena() {

    return obtenerHorasDeSegundos(segundos) + "h " + obtenerMinutosDeSegundos(segundos) + "m " 
        + obtenerRestoSegundosDeSegundos(segundos) + "s";
      
  }
  
  private int obtenerHorasDeSegundos(int segundos) {
    return segundos / 3600;
  }
  
  private int obtenerMinutosDeSegundos(int segundos) {
    return (segundos % 3600) / 60;
  }
  
  private int obtenerRestoSegundosDeSegundos(int segundos) {
    return (segundos % 3600) % 60;    
  }
  
}
