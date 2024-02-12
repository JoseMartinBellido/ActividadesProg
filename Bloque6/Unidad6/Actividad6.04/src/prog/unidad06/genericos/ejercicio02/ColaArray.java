package prog.unidad06.genericos.ejercicio02;

import java.util.EmptyStackException;

/**
 * Clase Cola. Clase que crea una colección del tipo Cola, donde se almacenan objetos del tipo genérico T y,
 * a la hora de extraer un elemento, el primero que sale es el primero introducido
 * @author Jose
 *
 */
public class ColaArray <T>{

  /**
   * Colección de objetos del tipo T
   */
  private Object[] coleccion;
  
  /**
   * Constructor de la clase Pila. Inicializa la colección de objetos.
   */
  public ColaArray(){
    coleccion = new Object[0];
  }
  
  /**
   * Método que comprueba si una cola está vacía o no
   * @return
   */
  public boolean esVacia() {
    return coleccion.length == 0;
  }
  
  /**
   * Método que devuelve el número de elementos que hay en la cola
   * @return El número de elementos de la cola
   */
  public int getNumeroElementos() {
    return coleccion.length;
  }
  
  /**
   * Método que añade un nuevo elemento a la cola
   * @param elemento Nuevo elemento a añadir a la cola
   */
  public void push (T elemento) {
    // Creamos el nuevo array que actualizaremos con el nuevo elemento
    Object[] coleccionActualizada = new Object[coleccion.length + 1];
    // Insertamos todos los elementos
    for (int i = 0; i < coleccion.length; i++) {
      coleccionActualizada[i] = coleccion[i];
    }
    coleccionActualizada[coleccion.length] = elemento;
    // Actualizamos nuestra colección
    coleccion = coleccionActualizada;
  }
  
  /**
   * Método que extrae el primer elemento de la cola
   * @return El primer elemento de la cola
   * @throws EmptyStackException En caso de que la cola esté vacía
   */
  public T pop() {
    
    // Comprobamos el tamaño de la colección. Si no es 0, sacamos el elemento
    if (coleccion.length != 0) {
      // Creamos el nuevo array que actualizaremos con el nuevo elemento
      Object[] coleccionActualizada = new Object[coleccion.length - 1];
      // Insertamos todos los elementos
      for (int i = 1; i < coleccion.length; i++) {
        coleccionActualizada[i - 1] = coleccion[i];
      }
      // Podemos hacer el casting seguro porque todo elemento insertado con push es de tipo T
      T elemento = (T)coleccion[0];
      // Actualizamos nuestra colección
      coleccion = coleccionActualizada;
      
      return elemento;
    // En otro caso, lanzamos el error
    } else {
      throw new EmptyStackException();
    }

  }
  
}
