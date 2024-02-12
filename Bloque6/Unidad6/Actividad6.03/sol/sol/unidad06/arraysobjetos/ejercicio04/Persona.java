package sol.unidad06.arraysobjetos.ejercicio04;

import sol.unidad06.arraysobjetos.ejercicio02.Cadenable;

/**
 * Persona relacionada con el centro
 */
public class Persona implements Cadenable {

  // Atributos
  // DNI (8 números y una letra mayúscula
  protected String dni;
  // Nombre
  protected String nombre;
  
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

  protected boolean esDniCorrecto(String dni) {
    
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

  protected boolean esNombreCorrecto(String nombre) {
    // Si es null falla
    if (nombre == null) {
      return false;
    }
    
    // Es OK si la longitud está entre 1 y 100
    return (nombre.length() >= 1 && nombre.length() <= 100); 
  }

  @Override
  public String obtenerCadena() {
    return "";
  }
}
