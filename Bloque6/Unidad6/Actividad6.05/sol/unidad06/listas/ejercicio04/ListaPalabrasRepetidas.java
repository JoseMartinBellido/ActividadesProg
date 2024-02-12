package unidad06.listas.ejercicio04;

import java.util.ArrayList;
import java.util.List;

/**
 * Lista de cadenas que impide repeticiones
 */
public class ListaPalabrasRepetidas {

  // Lista con las palabras
  List<String> lista;
  
  /**
   * Construye la lista vacía
   */
  public ListaPalabrasRepetidas() {
    lista = new ArrayList<>();
  }
  
  /**
   * Añade una nueva cadena a la lista. Si la lista ya contiene una 
   *   cadena igual no se añade
   * @param cadena Cadena a añadir
   */
  public void add(String cadena) {
    
    // Si la lista no contiene ya la cadena
    if (!lista.contains(cadena)) {
      // La añade
      lista.add(cadena);
    }
  }
  
  /**
   * Obtiene una representación de la lista completa de la forma:<br>
   *   ("cadena1", "cadena2", ....., "cadenan")
   * @return Resumen de la lista
   */
  public String obtenerResumen() {
    // Iniciamos la salida al paréntesis de apertura
    String salida = "(";
    
    // Para cada elemento de la lista
    // Bandera para saber si es el primero o no
    boolean esPrimero = true;
    for (String elemento: lista) {
      // Si no es el primero
      if (!esPrimero) {
        // Añade una coma antes del elemento
        salida += ", ";
      } else {
        // No añade coma pero el siguiente ya no será el primer elemento
        esPrimero = false;
      }
      // Extrae el elemento
      salida += "\"" + elemento + "\"";
    }
    // Una vez generados todos los elementos falta el paréntesis de cierre
    salida += ")";
    // Y por último devolver la salida
    return salida;
  }
}
