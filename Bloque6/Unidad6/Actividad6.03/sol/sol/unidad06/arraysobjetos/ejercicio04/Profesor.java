package sol.unidad06.arraysobjetos.ejercicio04;


/**
 * Profesor del centro
 */
public class Profesor extends Persona implements Cadenable {
  // Atributos
  private String materia;
  
  /**
   * Constructor
   * @param dni DNI del alumno. Debe constar de 8 números y una letra mayúscula, sin espacios
   * @param nombre Nombre del alumno. Entre 1 y 100 caracteres
   * @param materia Materia que imparte el profesor. No puede ser null, ni vacío
   */
  public Profesor(String dni, String nombre, String materia) {
    // Si los parámetros son correctos
    if (esDniCorrecto(dni) && esNombreCorrecto(nombre)
      && esMateriaCorrecta(materia)) {
      // Los almacena
      this.dni = dni;
      this.nombre = nombre;
      this.materia = materia;
    } else {
      // Si no lo son, lanza excepcion
      throw new IllegalArgumentException();
    }
  }

  /**
   * Chequea si la materia es o no válida
   * @param materia Materia a comprobar
   * @return true si la materia es válida. false en caso contrario
   */
  private boolean esMateriaCorrecta(String materia) {
    // Si es null falla
    if (materia == null) {
      return false;
    }
    
    // Si está vacío falla. Si no, no
    return !materia.isBlank();
  }

  @Override
  public String obtenerCadena() {
    return "PROFESOR DNI: " + dni + ", Nombre: " + nombre + ", Materia: " + materia;
  }

}
