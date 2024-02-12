package sol.unidad06.arraysobjetos.ejercicio04;



/**
 * Estudiante del centro
 */
public class Estudiante extends Persona implements Cadenable {
  
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
  // Curso (primero, segundo, master)
  private String curso;

  /**
   * Constructor
   * @param dni DNI del alumno. Debe constar de 8 números y una letra mayúscula, sin espacios
   * @param nombre Nombre del alumno. Entre 1 y 100 caracteres
   * @param curso Curso del alumno. Uno de "primero", "segundo", "master"
   */
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
   * Obtiene el curso
   * @return Curso
   */
  public String getCurso() {
    return curso;
  }
  
  public String obtenerCadena() {
    return "ESTUDIANTE DNI: " + dni + ", Nombre: " + nombre + ", Curso: " + curso;
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
