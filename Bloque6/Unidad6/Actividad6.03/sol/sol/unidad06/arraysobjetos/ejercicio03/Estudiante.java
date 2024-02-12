package sol.unidad06.arraysobjetos.ejercicio03;

/**
 * Estudiante del centro
 */
public class Estudiante {
  
  // Constantes
  // Nombre validos de los cursos
  /**
   * Primer curso
   */
  public static final String CURSO_PRIMERO = "primero";

  /**
   * Segundo curso
   */
  public static final String CURSO_SEGUNDO = "segundo";

  /**
   * Master
   */
  public static final String CURSO_MASTER = "master";

  // Atributos
  // DNI (8 números y una letra mayúscula
  private String dni;
  // Nombre
  private String nombre;
  // Curso (primero, segundo, master)
  private String curso;
  
  public Estudiante(String dni, String nombre, String curso) {
    // Si los parámetros son correctos
    if (esDniCorrecto(dni) && esNombreCorrecto(nombre)
      && esCursoCorrecto(curso)) {
      // Los almacena
      this.dni = dni;
      this.nombre = nombre;
      this.curso = curso;
    } else {
      // Si no lo son, lanza excepcion
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Obtiene el DNI
   * @return DNI
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene el nombre
   * @return Nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene el curso
   * @return Curso
   */
  public String getCurso() {
    return curso;
  }
  
  public String obtenerCadena() {
    return "DNI: " + dni + ", Nombre: " + nombre + ", Curso: " + curso;
  }


  private boolean esDniCorrecto(String dni) {
    
    // Si es null falla
    if (dni == null) {
      return false;
    }
    
    // Si no tiene 9 caracteres falla
    if (dni.length() != 9) {
      return false;
    }
    
    // Si los 8 primeros no son números falla
    for (int i = 0; i < 8; i++) {
      char caracter = dni.charAt(i);
      if (caracter < '0' || caracter > '9') {
        return false;
      }
    }
    
    // Si el noveno no es una letra mayúscula falla
    char caracter = dni.charAt(8);
    if (caracter < 'A' || caracter > 'Z') {
      return false;
    } else {
      // Todo OK
      return true;
    }
  }

  private boolean esNombreCorrecto(String nombre) {
    // Si es null falla
    if (nombre == null) {
      return false;
    }
    
    // Es OK si la longitud está entre 1 y 100
    return (nombre.length() >= 1 && nombre.length() <= 100); 
  }

  private boolean esCursoCorrecto(String curso) {
    // Si es null falla
    if (curso == null) {
      return false;
    }
    
    // Si no vale uno de los tres valores válidos falla
    return (curso.equals(CURSO_PRIMERO) || curso.equals(CURSO_SEGUNDO)
      || curso.equals(CURSO_MASTER));
  }

}
