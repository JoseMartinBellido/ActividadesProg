package prog.unidad06.listas.ejercicio04;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase que representa una lista de cadenas que impide repeticiones de elementos
 * @author Jose
 *
 */
public class ListaPalabrasRepetidas {

  /**
   * Lista de las palabras almacenadas
   */
  private List<String> listaPalabras;
  
  /**
   * Constructor de la clase. Genera una lista vacía
   */
  public ListaPalabrasRepetidas() {
    listaPalabras = new LinkedList<>();
  }
  
  /**
   * Método que añade una nueva cadena a la lista. Si ya se encuentra añadida, no realiza la operación
   * @param cadena Cadena de caracteres a añadir
   */
  public void add(String cadena) {
    // Comprobamos si está añadida. Si no lo está, la añadimos
    if (!listaPalabras.contains(cadena)) {
      listaPalabras.add(cadena);
    }
  }
  
  /**
   * Método que obtiene una representación de la cadena
   * @return Una representación de la cadena en formato ("Cadena1", "Cadena2", ...)
   */
  public String obtenerResumen() {
    String representacion = "(";
    for (int i = 0; i < listaPalabras.size(); i++) {
      representacion += "\"" + listaPalabras.get(i) + "\"";
      if (i < listaPalabras.size() - 1) {
        representacion += ", ";
      }
    }
    representacion += ")";
    
    return representacion;
  }
}
