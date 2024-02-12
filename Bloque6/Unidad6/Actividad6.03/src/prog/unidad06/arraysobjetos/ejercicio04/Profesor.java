package prog.unidad06.arraysobjetos.ejercicio04;


public class Profesor extends Persona{
  
  // Atributo privado materia. No puede estar vacío
  private String materia;

  /**
   * Clase constructora de Profesor.
    * @param dni DNI de la persona. Debe componerse de 8 dígitos comprendidos entre 0 y 9 y una letra asignada
    * @param nombre Nombre de la persona. Debe tener entre 1 y 100 caracteres
   * @param materia Materia de la asignatura que imparte. Debe tener 1 o más caracteres
   */
  public Profesor(String dni, String nombre, String materia) {
    super(dni, nombre);
    if (compruebaMateria(materia)) {
      this.materia = materia;
    } else {
      throw new IllegalArgumentException();
    }
    
  }

  public String getMateria() {
    return materia;
  }

  /**
   * Método que comprueba si una materia es correcta  
   * @param materia Materia sobre la que se realizan las comprobaciones. No debe estar vacía
   * @return true si está correcta, false si no lo está.
   */
  private boolean compruebaMateria(String materia) {
    if (materia.length() > 0) {
      return true;
    }
    return false;
  }
  
}
