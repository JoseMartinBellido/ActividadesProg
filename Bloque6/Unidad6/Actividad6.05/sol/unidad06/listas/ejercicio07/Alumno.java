package unidad06.listas.ejercicio07;

/**
 * Alumno del centro
 */
public class Alumno {

  // Atributos
  // DNI (no debe ser null y debe constar de 9 caracteres)
  private String dni;
  // Nombre (no debe ser vacío ni null)
  private String nombre;
  // Edad (debe ser positiva)
  private int edad;
  
  /**
   * Constructor
   * @param dni DNI del alumno. No puede ser null y debe constar de 9 caracteres
   * @param nombre Nombre del alumno. No puede ser null ni vacío
   * @param edad Edad del alumno. Debe ser positiva
   * @throws IllegalArgumentException Si alguno de los parámetros es incorrecto
   */
  public Alumno(String dni, String nombre, int edad) {
    // Si los parámetros son correctos
    if (dni != null && dni.length() == 9 && nombre != null && !nombre.isEmpty() && edad >= 0) {
      // Los almacena
      this.dni = dni;
      this.nombre = nombre;
      this.edad = edad;
    } else {
      // Algún parámetro es incorrecto
      // Lanza excepción
      throw new IllegalArgumentException();
    }
  }

  /**
   * Obtiene el DNI
   * @return DNI del alumno
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene el nombre
   * @return Nombre del alumno
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene la edad
   * @return Edad del alumno
   */
  public int getEdad() {
    return edad;
  }
  
  /**
   * Obtiene una representación en formato cadena de la información del alumno
   * @return Cadena con la información del alumno
   */
  public String aCadena() {
    return "DNI: " + dni + ", Nombre: " + nombre + ", Edad: " + edad;
  }
}
