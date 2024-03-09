package prog.unidad04.practica406.libreria;

/**
 * Clase que representa un automóvil.
 */
public class Automovil extends Vehiculo implements ConvertibleATexto{

  // Bloque de constantes
  /**
   * Color azul
   */
  public static final String COLOR_AZUL = "azul";
  
  /**
   * Color blanco
   */
  public static final String COLOR_BLANCO = "blanco";
  
  /**
   * Color negro
   */
  public static final String COLOR_NEGRO = "negro";
  
  /**
   * Número mínimo de plazas: 1
   */
  private static final int NUMERO_MINIMO_PLAZAS = 1;
  
  // Bloque de atributos no constantes
  /**
   * Color del automóvil
   */
  protected String color;
  
  /**
   * Número de plazas del automovil
   */
  protected int plazas;
  
  // Constructor
  
  /**
   * Constructor de clase
   * @param matricula Matrícula del automóvil en formato NNNN LLL donde NNNN son 4 números, LLL son 3 letras mayúsculas y pueden 
   * haber tantos espacios como se desee entre ambos datos
   * @param fechaMatriculacion Fecha de la matriculación del automóvil. No puede ser null
   * @param color Color del automóvil. Debe ser blanco, negro o azul
   * @param plazas Número de plazas del automóvil. Debe ser mayor que 1
   * @throws IllegalArgumentException En caso de que alguno de los parámetros no cumpla las condiciones
   */
  public Automovil(String matricula, Fecha fechaMatriculacion, String color, int plazas) {
    super(matricula, fechaMatriculacion);
    // Comprobamos los parámetros restantes no heredados
    this.color = compruebaColor(color);
    this.plazas = compruebaPlazas(plazas);
  }

  // Métodos públicos
  
  @Override
  /**
   * Obtiene una representación en texto del automóvil 
   * El formato es Matrícula: MMMM, Fecha de Matriculación: FFFF, Color: CCCC, Num. Plazas: PPPPP donde MMMM es la matricula, 
   * FFFF es la fecha de matriculación, CCCC es el color, PPPP es el número de plazas
   */
  public String aTexto() {
    
    return "Matricula: " + matricula + ", Fecha Matriculacion: " + fechaMatriculacion.aTexto() 
        + ", color: " + color + ", Num. Plazas: " + plazas;
  }
  
  
  /**
   * Método que obtiene el color del automóvil
   * @return El color del automóvil
   */
  public String getColor() {
    return color;
  }

  /**
   * Método que obtiene el número de plazas del automóvil
   * @return Las plazas del automóvil
   */
  public int getPlazas() {
    return plazas;
  }

  // Métodos privados
  /**
   * Método que comprueba el color del automóvil
   * @param color Color del automóvil. Debe ser blanco, negro o azul
   * @return El color del automóvil si es correcto.
   * @throws IllegalArgumentException Si el color no es correcto
   */
  private String compruebaColor(String color) {
    // Hay dos posibilidades para un error. Que el color, al ser un String, sea null, o que sea una cadena de caracteres distinta
    // de los valores predeterminados
    if (color == null || (!color.equals(COLOR_AZUL) && !color.equals(COLOR_NEGRO) && !color.equals(COLOR_BLANCO))) {
      // Si es incorrecto, decrezco el contador de vehículos matriculados. 
      // Por definición del constructor Vehiculo, se suma una vez se llama al super. Es necesario volver a quitarlo llegados aquí.
      Vehiculo.vehiculosMatriculados--;
      throw new IllegalArgumentException();
    } else {
      return color;
    }
  }
  
  /**
   * Método que comprueba el número de plazas del automóvil
   * @param plazas Plazas del automóvil. Debe ser 1 como mínimo
   * @return El número de plazas del automóvil si es correcto.
   * @throws IllegalArgumentException Si el número no es correcto
   */
  private int compruebaPlazas(int plazas) {
    if (plazas < NUMERO_MINIMO_PLAZAS) {
      // Si es incorrecto, decrezco el contador de vehículos matriculados. 
      // Por definición del constructor Vehiculo, se suma una vez se llama al super. Es necesario volver a quitarlo llegados aquí.
      Vehiculo.vehiculosMatriculados--;
      throw new IllegalArgumentException();
    } else {
      return plazas;
    }
  }
  
}
