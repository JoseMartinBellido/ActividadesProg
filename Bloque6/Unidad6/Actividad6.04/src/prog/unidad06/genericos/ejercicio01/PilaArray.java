package prog.unidad06.genericos.ejercicio01;

import java.util.EmptyStackException;

/**
 * Clase Pila. Clase que crea una colección del tipo Pila, donde se almacenan objetos del tipo genérico T y,
 * a la hora de extraer un elemento, el primero que sale es el último introducido
 * @author Jose
 */
public class PilaArray<T> {

  /**
   * Colección de objetos del tipo T
   */
  private Object[] coleccion;
  
  /**
   * Constructor de la clase Pila. Inicializa la colección de objetos.
   */
  public PilaArray(){
    coleccion = new Object[0];
  }
  
  /**
   * Método que comprueba si una pila está vacía o no
   * @return
   */
  public boolean esVacia() {
    return coleccion.length == 0;
  }
  
  /**
   * Método que devuelve el número de elementos que hay en la pila
   * @return El número de elementos de la pila
   */
  public int getNumeroElementos() {
    return coleccion.length;
  }
  
  /**
   * Método que añade un nuevo elemento a la pila
   * @param elemento Nuevo elemento a añadir a la pila
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
   * Método que extrae el último elemento de la pila
   * @return El último elemento de la pila
   * @throws EmptyStackException En caso de que la pila esté vacía
   */
  public T pop() {
    
    // Comprobamos el tamaño de la colección. Si no es 0, sacamos el elemento
    if (coleccion.length != 0) {
   // Creamos el nuevo array que actualizaremos con el nuevo elemento
      Object[] coleccionActualizada = new Object[coleccion.length - 1];
      // Insertamos todos los elementos
      for (int i = 0; i < coleccion.length - 1; i++) {
        coleccionActualizada[i] = coleccion[i];
      }
      // Podemos hacer el casting seguro porque todo elemento insertado con push es de tipo T
      T elemento = (T)coleccion[coleccion.length - 1];
      // Actualizamos nuestra colección
      coleccion = coleccionActualizada;
      
      return elemento;
    // En otro caso, lanzamos el error
    } else {
      throw new EmptyStackException();
    }

  }
}
