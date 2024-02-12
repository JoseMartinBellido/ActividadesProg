package unidad06.listas.ejercicio08;

import java.util.ArrayList;
import java.util.List;

/**
 * Alumno del centro con calificaciones
 */
public class Alumno {

  // Atributos
  // DNI (no debe ser null y debe constar de 9 caracteres)
  private String dni;
  // Nombre (no debe ser vacío ni null)
  private String nombre;
  // Edad (debe ser positiva)
  private int edad;
  // Lista con las calificaciones
  List<Double> calificaciones;
  
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
      // Las calificaciones inicialmente están vacías
      calificaciones = new ArrayList<>();
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
    return "DNI: " + dni + ", Nombre: " + nombre + ", Edad: " + edad
      + ", Calificacion Media: " + getCalificacionMedia();
  }
  
  /**
   * Añade una calificación a un alumno
   * @param calificacion Calificación a añadir. Debe valer entre 0 y 10, ambos inclusive
   * @throws IllegalArgumentException Si la calificación no es válida
   */
  public void addCalificacion(double calificacion) {
    // Si la calificación es válida
    if (calificacion >= 0 && calificacion <= 10) {
      // Se añade
      calificaciones.add(calificacion);
    } else {
      // Si no es válida se lanza excepción
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Obtiene las calificaciones de un alumno
   * @return Calificaciones del alumno. Puede ser vacía
   */
  public List<Double> getCalificaciones() {
    return calificaciones;
  }

  /**
   * Obtiene la calificación media del alumno.
   * @return Calificacion media del alumno. Si no tiene calificaciones devuelve 0
   */
  private double getCalificacionMedia() {
    // Si hay alguna calificacion
    if (calificaciones.size() > 0) {
      // Inicializa la suma
      double suma = 0;
      // Para cada calificacion
      for (double calificacion: calificaciones) {
        suma += calificacion;
      }
      // Devuelve la media
      return suma / calificaciones.size();
    } else {
      // No hay calificaciones. Devuelve 0
      return 0;
    }
  }
}
