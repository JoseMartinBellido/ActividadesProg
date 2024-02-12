package prog.unidad06.arraysobjetos.ejercicio04;

public class Estudiante extends Persona{

  // Constantes de curso
  private static final String CURSO_PRIMERO = "primero";
  private static final String CURSO_SEGUNDO = "segundo";
  private static final String CURSO_MASTER = "master";
  
  /**
   * Curso al que pertenece el estudiante. Podrá ser primero, segundo o master
   */
  private String curso;
  
  /**
   * Constructor de la clase con parámetros dni, nombre y curso
   * @param dni DNI del estudiante. Debe componerse de 8 dígitos comprendidos entre 0 y 9 y una letra asignada
   * @param nombre Nombre del estudiante. Debe tener entre 1 y 100 caracteres
   * @param curso Curso del estudiante. Debe ser primero, segundo o master
   * @throws IllegalArgumentException Si alguno de los parámetros no es correcto
   */
  public Estudiante(String dni, String nombre, String curso) {
    super(dni, nombre);
    if (compruebaCurso(curso)) {
      this.curso = curso;
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Método que devuelve el curso del estudiante
   * @return El curso del estudiante
   */
  public String getCurso() {
    return curso;
  }

  /**
   * Método que comprueba que el curso es correcto
   * @param curso Curso a comprobar del estudiante
   * @return true si es correcto, false si no lo es
   */
  private boolean compruebaCurso(String curso) {
    // Comprobamos que el curso es correcto
    if (curso.equals(CURSO_PRIMERO) || curso.equals(CURSO_SEGUNDO) || curso.equals(CURSO_MASTER)) {
      return true;
    }
    // Si no se ha devuelto true, es false
    return false;
  }  
  
}
