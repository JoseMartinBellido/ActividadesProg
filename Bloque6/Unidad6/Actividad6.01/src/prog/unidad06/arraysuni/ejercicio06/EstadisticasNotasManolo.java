package prog.unidad06.arraysuni.ejercicio06;

public class EstadisticasNotasManolo {

  // Suma de todas las calificaciones añadidas
  private double suma;
  
  // Cantidad de calificaciones
  private int calificaciones;
  
  // Frecuencias de las calificaciones
  private int[] frecuencias;

  public EstadisticasNotasManolo() {
    // Inicializamos los atributos
    suma = 0;
    calificaciones = 0;
    frecuencias = new int[11];
  }
  
  // Método para añadir una nueva calificación. Debe valer entre 0 y 10, ambos incluidos
  // Lanza IllegalArgumentException
  public void addCalificacion(int calificacion) {
    
    if (calificacion >= 0 && calificacion <= 10) {
      frecuencias[calificacion]++;
      suma += calificacion;
      calificaciones++;
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  public double calificacionMedia() {
    if (calificaciones > 0) {
      return suma / calificaciones;
    } else {
      return 0;
    }
  }
  
  public int calificacionModa() throws EstadisticasNotasException2{
    if (calificaciones > 0) {
      int posicion = 0;
      int maximo = frecuencias[0];
      
      for (int i = 0; i < frecuencias.length; i++) {
        if (frecuencias[i] > maximo) {
          posicion = i;
          maximo = frecuencias[i];
        }
      }
      return posicion;
    } else {
      throw new EstadisticasNotasException2();
    }       
  }
}
