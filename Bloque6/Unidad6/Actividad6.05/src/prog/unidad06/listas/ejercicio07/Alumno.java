package prog.unidad06.listas.ejercicio07;

public class Alumno{

  /**
   * DNI del alumno. Es una cadena de caracteres con formato "NNNNNNNNL", 
   * siendo N un número entre 0 y 9 y L una letra mayúscula
   */
  private String dni;
  
  /**
   * Nombre del alumno. Debe ser no nulo
   */
  private String nombre;
  
  /**
   * Edad del alumno. Debe ser un entero positivo
   */
  private int edad;
  
  /**
   * Constructor de la clase.
   * @param dni DNI con formato "NNNNNNNNL", siendo N un número entre 0 y 9 y L una letra mayúscula
   * @param nombre Nombre. No puede ser nulo
   * @param edad Edad. Debe ser un entero positivo.
   */
  public Alumno(String dni, String nombre, int edad) {
    // Realizamos las comprobaciones
    if (dni.length() == 9 && nombre != null && edad >= 0) {
      this.dni = dni;
      this.nombre = nombre;
      this.edad = edad;
    // Si no cumple los requisitos, lanzamos error
    } else {
      throw new IllegalArgumentException();
    }
  }

  public String getDni() {
    return dni;
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }
  
  public String aCadena() {
    return "DNI: " + dni + ", Nombre: " + nombre + ", Edad: " + edad;
  }


  
  
  
}
