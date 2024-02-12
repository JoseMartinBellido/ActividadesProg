package prog.unidad04.practica406.libreria;

/**
 * Clase que representa una motocicleta.
 */
public class Motocicleta extends Vehiculo implements ConvertibleATexto {

  // Bloque de constantes
  private static final int CILINDRADA_MINIMA = 50;
  
  // Bloque de atributos no constantes
  /**
   * Cilindrada de la motocicleta
   */
  protected int cilindrada;
  
  /**
   * Constructor de la motocicleta que toma por parámetros la matrícula, la fecha de matriculación y la cilindrada
   * @param matricula Matrícula de la motocicleta en formato NNNN LLL donde NNNN son 4 números, LLL son 3 letras mayúsculas y pueden 
   * haber tantos espacios como se desee entre ambos datos
   * @param fechaMatriculacion Fecha de la matriculación del vehículo. No puede ser null
   * @param cilindrada Cilindrada de la motocicleta. No puede ser menor a 50
   * @throws IllegalArgumentException En caso de que alguno de los parámetros no cumpla los requisitos
   */
  public Motocicleta(String matricula, Fecha fechaMatriculacion, int cilindrada) {
    super(matricula, fechaMatriculacion);
    
    if (cilindrada < CILINDRADA_MINIMA) {
      // Si es incorrecto, decrezco el contador de vehículos matriculados. 
      // Por definición del constructor Vehiculo, se suma una vez se llama al super. Es necesario volver a quitarlo llegados aquí.
      Vehiculo.vehiculosMatriculados--;
      throw new IllegalArgumentException();
    } else {
      this.cilindrada = cilindrada;
    }
  }

  @Override
  /**
   * Obtiene una representación en texto del contenido del objeto. El formato es:
   * Matricula: MMMM, Fecha Matriculacion: FFFF, cilindrada: CCCC
   * donde MMMM es la matrícula, FFFF es la fecha de matriculación y CCCC es la cilindrada
   */
  public String aTexto() {
    return "Matricula: " + matricula + ", Fecha Matriculacion: " + fechaMatriculacion.aTexto() 
      + ", cilindrada: " + cilindrada;

  }

  /**
   * Método que obtiene la cilindrada de la motocicleta
   * @return La cilindrada de la motocicleta
   */
  public int getCilindrada() {
    return cilindrada;
  }
  
  
  
  
  
}
