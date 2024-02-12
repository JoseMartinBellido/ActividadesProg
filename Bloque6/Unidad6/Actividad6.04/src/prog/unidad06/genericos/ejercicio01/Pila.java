package prog.unidad06.genericos.ejercicio01;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Clase Pila. Clase que crea una colección del tipo Pila, donde se almacenan objetos del tipo genérico T y,
 * a la hora de extraer un elemento, el primero que sale es el último introducido
 */
public class Pila<T> {

  /**
   * Colección de objetos del tipo T
   */
  private List<T> coleccion;
  
  /**
   * Constructor de la clase Pila. Inicializa la colección de objetos.
   */
  public Pila(){
    coleccion = new ArrayList<>();
  }
  
  /**
   * Método que comprueba si una pila está vacía o no
   * @return
   */
  public boolean esVacia() {
    return coleccion.isEmpty();
  }
  
  /**
   * Método que devuelve el número de elementos que hay en la pila
   * @return El número de elementos de la pila
   */
  public int getNumeroElementos() {
    return coleccion.size();
  }
  
  /**
   * Método que añade un nuevo elemento al final de la pila
   * @param elemento Nuevo elemento a añadir a la pila
   */
  public void push (T elemento) {
    coleccion.add(elemento);
  }
  
  /**
   * Método que extrae el último elemento de la pila
   * @return El último elemento de la pila
   * @throws EmptyStackException En caso de que la pila esté vacía
   */
  public T pop() {
    if (!coleccion.isEmpty()) {
      return coleccion.remove(coleccion.size() - 1);
    }
    throw new EmptyStackException();
  }
}
