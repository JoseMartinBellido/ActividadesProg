package prog.ud06.actividad611.coleccion.diccionario;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que implementa un diccionario
 * Un diccionario guarda cosas de un tipo determinado (Tipo Genérico V) con un
 * nombre (String)
 * @param <V> Tipo de los elementos a guardar
 */
public class Diccionario<V> {

  // Atributos
  // Mapa para realizar el diccionario
  Map<String, V> mapa;
  
  /**
   * Constructor. Crea un diccionario vacío
   */
  public Diccionario() {
    // Inicializa el mapa
    mapa = new HashMap<>();
  }
  
  /**
   * Comprueba si existe una entrada en el diccionario con el nombre dado
   * @param nombre Nombre de la entrada a comprobar
   * @return true si existe en el diccionario una entrada con el nombre
   *   proporcionado. false si no existe
   */
  public boolean contieneNombre(String nombre) {
    // Determina si el nombre está contenido en el mapa (si no es null)
    return (nombre != null) && mapa.containsKey(nombre);
  }
  
  /**
   * Añade una nueva entrada al diccionario
   * @param nombre Nombre de la entrada a añadir. No puede ser null ni
   *   coincidir con el nombre de una entrada ya existente en el diccionario
   * @param valor Valor a almacenar en la entrada. No puede ser null
   * @throws DiccionarioException Si ya existe previamente una entrada con el
   *   nombre proporcionado en el diccionario
   * @throws IllegalArgumentException Si el nombre o el valor son null
   */
  public void add(String nombre, V valor) {
    // Si el nombre no es null
    if (nombre != null) {
      // Si no hay ya una entrada en el mapa con el nombre
      if (!mapa.containsKey(nombre)) {
        // Si el valor no es null
        if (valor != null) {
          // Crea la entrada en el mapa
          mapa.put(nombre, valor);
        } else {
          // Si el valor es null lanza IllegalArgumentException
          throw new IllegalArgumentException();
        }
      } else {
        // Si la entrada ya existe lanza DiccionarioException
        throw new DiccionarioException();
      }
    } else {
      // El nombre es null. Se lanza IllegalArgumentException
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Obtiene el valor almacenado en una entrada del diccionario a partir de
   *   su nombre
   * @param nombre Nombre de la entrada a recuperar.
   * @return Valor almacenado en la entrada con el nombre proporcionado. Si no
   *   existe una entrada con dicho nombre devuelve null
   */
  public V getEntrada(String nombre) {
    // Devuelve la entrada o null
    return mapa.get(nombre);
  }
}
