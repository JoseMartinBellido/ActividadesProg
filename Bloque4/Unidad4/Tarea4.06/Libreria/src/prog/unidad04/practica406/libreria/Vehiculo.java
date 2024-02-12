package prog.unidad04.practica406.libreria;

/**
 * Clase que representa un vehículo genérico
 */
public class Vehiculo {
  
  // Bloque de constantes
  
  // Bloque de atributos no constantes
  /**
   * Número de vehículos matriculados hasta el momento
   */
  protected static int vehiculosMatriculados;
  
  /**
   * Fecha de matriculación del vehículo
   */
  protected Fecha fechaMatriculacion;
  
  /**
   * Matrícula del vehículo
   */
  protected String matricula;
  
 
  // Constructor
  /**
   * Constructor de la clase vehículo que toma por parámetros la matrícula y la fecha de matriculación.
   * @param matricula Matrícula del vehículo en formato NNNN LLL donde NNNN son 4 números, LLL son 3 letras mayúsculas y pueden 
   * haber tantos espacios como se desee entre ambos datos
   * @param fechaMatriculacion Fecha de la matriculación del vehículo. No puede ser null
   * @throws IllegalArgumentException En caso de que uno de los parámetros no sea válido
   */
  protected Vehiculo(String matricula, Fecha fechaMatriculacion){
    // Comprobamos la matrícula y la asignamos
	// Por construcción de Fecha, el único posible error sería el insertar un valor null
    if (compruebaMatricula(matricula) && fechaMatriculacion != null) {
  	  this.matricula = matricula;
      this.fechaMatriculacion = fechaMatriculacion;
      // Al construir un nuevo vehículo, sumamos uno al contador de vehículos matriculados
      vehiculosMatriculados++;
    } else {
    	throw new IllegalArgumentException();
    }

  }
  
  // Bloque de métodos públicos
  
  /**
   * Método que devuelve la cantidad de vehículos matriculados
   * @return La cantidad de vehículos matriculados
   */
  public static int getVehiculosMatriculados() {
    return vehiculosMatriculados;
  }

  /**
   * Método que devuelve la fecha de matriculación del vehículo
   * @return La fecha de matriculación del vehículo
   */
  public Fecha getFechaMatriculacion() {
    return fechaMatriculacion;
  }

  /**
   * Método que devuelve la matrícula del vehículo
   * @return La matrícula del vehículo
   */
  public String getMatricula() {
    return matricula;
  }

  // Bloque de métodos privados
  
  /**
   * Método privado para comprobar la matrícula de un vehículo
   * @param matricula Matrícula que debe tener un formato NNNN LLL donde NNNN son 4 números, LLL son 3 letras mayúsculas y pueden 
   * haber tantos espacios como se desee entre ambos datos
   * @return La matrícula en caso de que sea correcta
   * @throws IllegalArgumentException En caso de que no se cumplan las condiciones
   */
  private boolean compruebaMatricula(String matricula) {
    
    // Si la matrícula tiene menos de 7 elementos, evidentemente no cumple el formato
    if (matricula.length() < 7) {
      return false;
    }
    
    // Comprobamos los números de la matrícula
    for (int i = 0; i < 4; i++) {
      int caracterAscii = (int) matricula.charAt(i);
      // Los números asignados de los caracteres '0' a '9' van desde el 48 hasta el 57. Si los números no corresponden, no es correcta
      if (caracterAscii < 48 || caracterAscii > 57) {
        return false;
      }
    }
    
    // Comprobamos las letras de la matrícula. 
    // No sabemos el tamaño exacto del String, pero sí que sus 3 últimos caracteres deben ser letras mayúsculas
    for (int i = matricula.length() - 1; i >= matricula.length() - 3; i--) {
      int caracterAscii = (int) matricula.charAt(i);
      // Los números asignados de los caracteres 'A'-'Z' van desde el 65 hasta el 90
      if (caracterAscii < 65 || caracterAscii > 90) {
        return false;
      }
    }
    
    // Por último, recorremos desde el 5º carácter hasta el 4º empezando por la cola y comprobando que sean espacios
    // Si no hay elementos, no se entra al bucle
    for (int i = 4; i < matricula.length() - 3; i++) {
      char caracter = matricula.charAt(i);
      if (caracter != ' ') {
        return false;
      }
    }
    
    // Si llegamos hasta aquí sin modificaciones de la variable, la matrícula es correcta
    // La construcción se ha realizado así para salir inmediatamente en caso de matrícula incorrecta
    return true;
  }  
  
}
