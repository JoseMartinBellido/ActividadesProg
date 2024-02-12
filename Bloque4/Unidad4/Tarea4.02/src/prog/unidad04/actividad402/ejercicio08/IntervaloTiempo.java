package prog.unidad04.actividad402.ejercicio08;

public class IntervaloTiempo {
  
  // ------------------------------ Bloque de atributos ------------------------------
  /**
   * Horas del intervalo
   */
  private int horas;
  
  /**
   * Minutos del intervalo
   */
  private int minutos;
  
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
  public IntervaloTiempo(int horas, int minutos, int segundos) {
      
    // Almacenamos en los segundos el módulo de dividir los segundos entre 60
    this.segundos = segundos % 60;
    // Sumamos a los minutos los que nos pasemos de 60 segundos
    minutos += segundos / 60;
    
    // Realizamos la misma operación con los minutos
    this.minutos = minutos % 60;
    horas += minutos / 60;
    this.horas = horas;
  }
  
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Devuelve una cadena descriptiva del intervalo de tiempo en formato "AAh BBm CCs", 
   * siendo AA las horas, BB los minutos y CC los segundos.
   * @return Cadena de caractéres con formato "AAh BBm CCs".
   */
  public String obtenerCadena() {
    if (this != null)
      return horas + "h " + minutos + "m " + segundos + "s";
    else
      return "Este intervalo de tiempo no puede imprimirse";
  }
  
  /**
   * Método que suma dos intervalos de tiempo.
   * @param intervalo Intervalo que sumaremos al objeto sobre el que llamamos el método.
   * @return Un nuevo intervalo de tiempo que sea la suma de los dos anteriores.
   */
  public IntervaloTiempo suma(IntervaloTiempo intervalo) {
    
    return new IntervaloTiempo(this.horas + intervalo.horas, this.minutos + intervalo.minutos, this.segundos + intervalo.segundos);
    
  }
  
  public IntervaloTiempo resta(IntervaloTiempo intervalo) {
    
    // Comprobamos que se pueden restar. Si no pueden, devolvemos un intervalo de tiempo 0.
    if (this.horas < intervalo.horas || (this.horas == intervalo.horas && this.minutos < intervalo.minutos) 
        || (this.horas < intervalo.horas && this.minutos == intervalo.minutos && this.segundos == intervalo.segundos)){
      
      System.out.println("No se pueden restar los intervalos indicados puesto que no puede haber un intervalo de tiempo negativo."
          + " Devolvemos el intervalo por defecto: null");
      return null;
    }else {
      // Si se pueden restar hay que considerar los casos en los que haya que mover dígitos para restar segundos
      if (this.segundos < intervalo.segundos && this.minutos != 0) {
        minutos--;
        segundos += 60;

      } else if (this.segundos < intervalo.segundos && this.minutos == 0) {
        horas--;
        minutos += 59;
        segundos += 60;
      }
      
      // Consideramos los casos para restar los minutos
      if (this.minutos < intervalo.minutos) {
        horas--;
        minutos += 60;
      }
      
      int segundos = this.segundos - intervalo.segundos;
      int minutos = this.minutos - intervalo.minutos;
      int horas = this.horas - intervalo.horas;
      
      return new IntervaloTiempo(horas, minutos, segundos);
      
    }
    
  }
  
}
