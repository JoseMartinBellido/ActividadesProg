package prog.unidad06.listas.ejercicio08;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
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
   * Lista de calificaciones del alumno
   */
  private List<Double> calificaciones;
  
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
      calificaciones = new ArrayList<>();
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
  
  public List<Double> getCalificaciones(){
    return calificaciones;
  }
  
  /**
   * Método que convierte un objeto Alumno a una cadena de caracteres
   * @return Una cadena de caracteres que representa al alumno
   */
  public String aCadena() {
    return "DNI: " + dni + ", Nombre: " + nombre + ", Edad: " + edad + ", calificación media: " + getMedia();
  }

  /**
   * Método que añade una nueva calificación al alumno
   * @param calificacion Calificación a añadir. Debe encontrarse en el rango 0-10, ambos incluidos
   * @throws IllegalArgumentException En caso de que la calificación se salga de rango.
   */
  public void addCalificacion(double calificacion) {
    if (calificacion >= 0 && calificacion <= 10) {
      calificaciones.add(calificacion);
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Método que calcula la media de calificaciones
   * @return La media de calificaciones si hay al menos una calificación, o 0 si no hay ninguna
   */
  public double getMedia() {
    if (!calificaciones.isEmpty()) {
      double suma = 0;
      for (int i = 0; i < calificaciones.size(); i++) {
        suma += calificaciones.get(i);
      }
      return suma / calificaciones.size();
    } else {
      return 0;
    }

  }

}
