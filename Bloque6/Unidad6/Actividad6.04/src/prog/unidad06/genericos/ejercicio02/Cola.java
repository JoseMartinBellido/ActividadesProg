package prog.unidad06.genericos.ejercicio02;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Clase Cola. Clase que crea una colección del tipo Cola, donde se almacenan objetos del tipo genérico T y,
 * a la hora de extraer un elemento, el primero que sale es el primero introducido
 * @author Jose
 *
 */
public class Cola <T>{

  /**
   * Colección de objetos del tipo T
   */
  private List<T> coleccion;
  
  /**
   * Constructor de la clase Pila. Inicializa la colección de objetos.
   */
  public Cola(){
    coleccion = new ArrayList<>();
  }
  
  /**
   * Método que comprueba si una cola está vacía o no
   * @return
   */
  public boolean esVacia() {
    return coleccion.isEmpty();
  }
  
  /**
   * Método que devuelve el número de elementos que hay en la cola
   * @return El número de elementos de la cola
   */
  public int getNumeroElementos() {
    return coleccion.size();
  }
  
  /**
   * Método que añade un nuevo elemento a la cola
   * @param elemento Nuevo elemento a añadir a la cola
   */
  public void push (T elemento) {
    coleccion.add(elemento);
  }
  
  /**
   * Método que extrae el primer elemento de la cola
   * @return El primer elemento de la cola
   * @throws EmptyStackException En caso de que la cola esté vacía
   */
  public T pop() {
    if (!coleccion.isEmpty()) {
      return coleccion.remove(0);      
    } else {
      throw new EmptyStackException();
    }

  }
}
