package prog.unidad06.listas.ejercicio01;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PruebaListaEnterosUtils {

  @Test
  void testGeneraListaEnterosAleatoriosVacia() {
    // Caso: Genera una lista vacia con elementos en rango 1, 1
    // RE  : Se obtiene una lista vacía
    List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(0, 0, 1, 1);
    // La lista está vacía
    assertEquals(0, lista.size());
  }

  @Test
  void testGeneraListaEnterosAleatoriosUnElementoRangoUno() {
    // Caso: Genera una lista de un elemento con el valor en el rango 1, 1
    // RE  : Se obtiene una lista de un elemento cuyo valor es 1
    List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(1, 1, 1, 1);
    // La lista tiene un elemento
    assertEquals(1, lista.size());
    // El elemento es 1
    assertEquals(1, lista.get(0));
  }

  @Test
  void testGeneraListaEnterosAleatoriosUnElementoRangoDos() {
    // Caso: Genera una lista de un elemento con el valor en el rango 1, 2
    // RE  : Se obtiene una lista de un elemento cuyo valor es 1 ó 2
    List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(1, 1, 1, 2);
    // La lista tiene un elemento
    assertEquals(1, lista.size());
    // El elemento es 1 o es 2
    assertTrue(lista.get(0) == 1 || lista.get(0) == 2);
  }

  @Test
  void testGeneraListaEnterosAleatoriosUnElementoRangoDosBis() {
    // Caso: Genera una lista de un elemento con el valor en el rango -1, 1
    // RE  : Se obtiene una lista de un elemento cuyo valor es -1, 0, 1
    List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(1, 1, -1, 1);
    // La lista tiene un elemento
    assertEquals(1, lista.size());
    // El elemento es -1 o es 0 o es 1
    assertTrue(lista.get(0) == -1 || lista.get(0) == 0 || lista.get(0) == 1);
  }

  @Test
  void testGeneraListaEnterosGeneral() {
    // Caso: Genera una lista de uno a 10 elementos con el valor en el rango -10, 10
    // RE  : Se obtiene una lista de uno a 10 elementos cuyo valor es entre -10 y 10
    List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(1, 10, -10, 10);
    // La longitud debe estar entre 1 y 10
    assertTrue(lista.size() >= 1 && lista.size() <= 10);
    // Para cada elemento de la lista
    for (int elemento: lista) {
      assertTrue(elemento >= -10 && elemento <= 10);
    }
  }
  
  @Test
  void testGeneraListaEnterosLongitudMinIncorrecta() {
    // Caso: Intenta generar una lista con una longitud minima de -1
    // RE  : Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> ListaEnterosUtils.generaListaEnterosAleatorios(-1, 1, 1, 1));
  }
  
  @Test
  void testGeneraListaEnterosLongitudMaxIncorrecta() {
    // Caso: Intenta generar una lista con una longitud máxima menor que la mínima
    // RE  : Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> ListaEnterosUtils.generaListaEnterosAleatorios(2, 1, 1, 1));
  }
  
  @Test
  void testGeneraListaEnterosLongitudRangoIncorrecto() {
    // Caso: Intenta generar una lista con un rango incorrecto (maximo menor que el minimo)
    // RE  : Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> ListaEnterosUtils.generaListaEnterosAleatorios(1, 2, 2, 1));
  }
  
  @Test
  void testObtenerCadenaListaNula() {
    // Caso: Intenta generar cadena a partir de una lista nula
    // RE  : Se obtiene la cadena vacía
    List<Integer> lista = null;
    String esperada = "";
    assertEquals(esperada, ListaEnterosUtils.generaCadena(lista));
  }
  
  @Test
  void testObtenerCadenaListaVacia() {
    // Caso: Intenta generar cadena a partir de una lista vacía
    // RE  : Se obtiene la cadena ()
    List<Integer> lista = new ArrayList<>();
    String esperada = "()";
    assertEquals(esperada, ListaEnterosUtils.generaCadena(lista));
  }
  
  @Test
  void testObtenerCadenaListaUnElemento() {
    // Caso: Intenta generar cadena a partir de una lista de un elemento (10)
    // RE  : Se obtiene la cadena (10)
    List<Integer> lista = new ArrayList<>();
    lista.add(10);
    String esperada = "(10)";
    assertEquals(esperada, ListaEnterosUtils.generaCadena(lista));
  }
  
  @Test
  void testObtenerCadenaListaMiscelanea() {
    // Caso: Intenta generar cadena a partir de una lista
    //       con los elementos -10, 6, -3, -4, 1, 3 
    // RE  : Se obtiene la cadena (-10, 6, -3, -4, 1, 3)
    List<Integer> lista = new ArrayList<>();
    lista.add(-10);
    lista.add(6);
    lista.add(-3);
    lista.add(-4);
    lista.add(1);
    lista.add(3);
    String esperada = "(-10, 6, -3, -4, 1, 3)";
    assertEquals(esperada, ListaEnterosUtils.generaCadena(lista));
  }
  
}
