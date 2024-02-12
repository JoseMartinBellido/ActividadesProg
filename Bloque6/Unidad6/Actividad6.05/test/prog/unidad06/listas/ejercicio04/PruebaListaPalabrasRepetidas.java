package prog.unidad06.listas.ejercicio04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PruebaListaPalabrasRepetidas {

  @Test
  void testLPRVacia() {
    // Caso: Se crea una lista vacía y se obtiene la cadena correspondiente
    // RE  : Se obtiene la lista ()
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Resultado esperado
    String esperado = "()";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

  @Test
  void testLPRUnElemento() {
    // Caso: Se crea una lista, se añaden los elementos (Uno) y se obtiene la cadena
    //       correspondiente
    // RE  : Se obtiene la lista ("Uno")
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Añadimos el elemento "Uno"
    lista.add("Uno");
    // Resultado esperado
    String esperado = "(\"Uno\")";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

  @Test
  void testLPRDosElementosDistintos() {
    // Caso: Se crea una lista, se añaden los elementos (Uno, Dos) y se obtiene la cadena
    //       correspondiente
    // RE  : Se obtiene la lista ("Uno", "Dos")
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Añadimos el elemento "Uno"
    lista.add("Uno");
    // Añadimos el elemento "Dos"
    lista.add("Dos");
    // Resultado esperado
    String esperado = "(\"Uno\", \"Dos\")";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

  @Test
  void testLPRDosElementosIguales() {
    // Caso: Se crea una lista, se añaden los elementos iguales (Uno, Uno)
    //       y se obtiene la cadena correspondiente
    // RE  : Se obtiene la lista ("Uno")
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Añadimos el elemento "Uno"
    lista.add("Uno");
    // Añadimos el elemento "Uno" (otra vez)
    lista.add("Uno");
    // Resultado esperado
    String esperado = "(\"Uno\")";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

  @Test
  void testLPRTresElementosDistintos() {
    // Caso: Se crea una lista, se añaden los elementos (Uno, Dos, Tres)
    //       y se obtiene la cadena correspondiente
    // RE  : Se obtiene la lista ("Uno", "Dos", "Tres")
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Añadimos el elemento "Uno"
    lista.add("Uno");
    // Añadimos el elemento "Dos"
    lista.add("Dos");
    // Añadimos el elemento "Tres"
    lista.add("Tres");
    // Resultado esperado
    String esperado = "(\"Uno\", \"Dos\", \"Tres\")";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

  @Test
  void testLPRTresElementosDosIguales() {
    // Caso: Se crea una lista, se añaden los elementos (Uno, Uno, Tres)
    //       y se obtiene la cadena correspondiente
    // RE  : Se obtiene la lista ("Uno", "Tres")
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Añadimos el elemento "Uno"
    lista.add("Uno");
    // Añadimos el elemento "Uno" (otra vez)
    lista.add("Uno");
    // Añadimos el elemento "Tres"
    lista.add("Tres");
    // Resultado esperado
    String esperado = "(\"Uno\", \"Tres\")";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

  @Test
  void testLPRTresElementosDosIguales2() {
    // Caso: Se crea una lista, se añaden los elementos (Uno, Dos, Uno)
    //       y se obtiene la cadena correspondiente
    // RE  : Se obtiene la lista ("Uno", "Dos")
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Añadimos el elemento "Uno"
    lista.add("Uno");
    // Añadimos el elemento "Dos"
    lista.add("Dos");
    // Añadimos el elemento "Uno" (Otra vez)
    lista.add("Uno");
    // Resultado esperado
    String esperado = "(\"Uno\", \"Dos\")";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

  @Test
  void testLPRTresElementosDosIguales3() {
    // Caso: Se crea una lista, se añaden los elementos (Uno, Dos, Dos)
    //       y se obtiene la cadena correspondiente
    // RE  : Se obtiene la lista ("Uno", "Dos")
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Añadimos el elemento "Uno"
    lista.add("Uno");
    // Añadimos el elemento "Dos"
    lista.add("Dos");
    // Añadimos el elemento "Dos" (Otra vez)
    lista.add("Dos");
    // Resultado esperado
    String esperado = "(\"Uno\", \"Dos\")";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

  @Test
  void testLPRTresElementosTresIguales() {
    // Caso: Se crea una lista, se añaden los elementos (Uno, Uno, Uno)
    //       y se obtiene la cadena correspondiente
    // RE  : Se obtiene la lista ("Uno")
    // Creamos la lista
    ListaPalabrasRepetidas lista = new ListaPalabrasRepetidas();
    // Añadimos el elemento "Uno"
    lista.add("Uno");
    // Añadimos el elemento "Uno" (otra vez)
    lista.add("Uno");
    // Añadimos el elemento "Uno" (otra mas)
    lista.add("Uno");
    // Resultado esperado
    String esperado = "(\"Uno\")";
    // El resultado obtenido debe ser igual al esperado
    assertEquals(esperado, lista.obtenerResumen());
  }

}
