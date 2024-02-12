package prog.unidad04.actividad402.ejercicio08;

public class IntervaloTiempoS {

  // ------------------------------ Bloque de atributos ------------------------------
  /**
   * Segundos del intervalo
   */
  private int segundos;
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Construye un intervalo de tiempo con horas, minutos y segundos.
   * @param horas Las horas del intervalo. Debe ser un número mayor que cero. Su valor por defecto es 0.
   * @param minutos Los minutos del intervalo. Debe ser un número entre 0 y 59. Su valor por defecto es 0.
   * @param segundos Los segundos del intervalo. Debe ser un número entre 0 y 59. Su valor por defecto es 0.
   */
  public IntervaloTiempoS(int horas, int minutos, int segundos) {
    
    if (horas < 0 || minutos < 0 || segundos < 0) {
      horas = 0;
      System.out.println("El número de horas, minutos o segundos no puede ser menor que cero. Se pondrá cero por defecto.");
    }

    this.segundos = horas * 3600 + minutos*60 + segundos;
    
  }
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Método que suma dos intervalos de tiempo.
   * @param intervalo Intervalo que sumaremos al objeto sobre el que llamamos el método.
   * @return Un nuevo intervalo de tiempo que sea la suma de los dos anteriores.
   */
  public IntervaloTiempoS suma(IntervaloTiempoS otro) {
    
    return new IntervaloTiempoS(0,0,this.segundos + otro.getSegundos());
    
  }
  
  
  /**
   * Método que resta dos intervalos de tiempo.
   * @param intervalo Intervalo que sumaremos al objeto sobre el que llamamos el método.
   * @return Un nuevo intervalo de tiempo que sea la suma de los dos anteriores.
   */
  public IntervaloTiempoS resta(IntervaloTiempoS otro) {
    
    if (this.segundos - otro.getSegundos() > 0)
      return new IntervaloTiempoS(0,0,this.segundos - otro.getSegundos());
    else
      return null;
    
  }
  
  /**
   * Devuelve una cadena descriptiva del intervalo de tiempo en formato "AAh BBm CCs", 
   * siendo AA las horas, BB los minutos y CC los segundos.
   * @return Cadena de caractéres con formato "AAh BBm CCs".
   */
  public String obtenerCadena() {
    
    if(this == null)
      return "Este intervalo de tiempo no puede imprimirse";
    else {
      int horas = this.segundos / 3600;
      int resto = this.segundos % 3600;
      int minutos = resto /60;
      int segundos = resto % 60;
      
      return horas + "h " + minutos + "m " + segundos + "s";
      
    }
  }
  
  // Getters de los intervalos

  public int getSegundos() {
    return segundos;
  }
 
  
}
