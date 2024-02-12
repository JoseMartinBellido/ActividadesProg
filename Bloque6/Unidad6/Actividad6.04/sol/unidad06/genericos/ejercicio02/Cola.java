package unidad06.genericos.ejercicio02;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Clase que representa una cola<br>
 * En una cola los elementos entran por un extremo y salen por el otro
 * de forma que el primero que entra es el primero que sale
 * @param <T> Tipo de los elementos de la cola
 */
public class Cola<T> {

  // Vamos a almacenar los elementos en una lista
  List<T> cola;
  
  /**
   * Constructor. Crea una cola vacía
   */
  public Cola() {
    // Crea la lista para almacenar los elementos
    cola = new ArrayList<T>();
  }
  
  /**
   * Añade un elemento a la cola
   * @param elemento Elemento a añadir
   */
  public void push(T elemento) {
    // Siempre se puede añadir
    cola.add(elemento);
  }
  
  /**
   * Extrae un elemento de la cola. El elemento se quita de la cola
   * @return Elemento extraido de la cola
   * @throws EmptyStackException Si la cola está vacía
   */
  public T pop() {
    // Obtenemos el tamaño
    int size = getNumeroElementos();
    // Si la cola no está vacía
    if (size > 0) {
      // Obtenemos el elemento (siempre el cero)
      T elemento = cola.get(0);
      // Y se elimina 
      cola.remove(0);
      // Por último se devuelve
      return elemento;
    } else {
      // Si no hay elementos, lamzamos excepcion
      throw new EmptyStackException();
    }
  }

  /**
   * Chequea si la cola está vacía o no.
   * @return true si la cola está vacia, false si contiene algo
   */
  public boolean esVacia() {
    // Devuelve true si no hay algún elemento
    return getNumeroElementos() == 0;
  }

  /**
   * Obtiene el número de elementos contenidos en la cola
   * @return Número de elementos contenidos en la cola
   */
  public int getNumeroElementos() {
    // Devuelve el número de elementos contenidos en la cola
    return cola.size();
  }
}
