package prog.unidad06.genericos.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class PruebaColaArray {

  @Test
  void testColaNueva() {
    // Caso: Se crea una cola nueva
    // RE: La cola está vacía y el número de elementos es cero
    ColaArray<String> cola = new ColaArray<>();
    assertTrue(cola.esVacia());
    assertEquals(0, cola.getNumeroElementos());
  }

  @Test
  void testColaUnElemento() {
    // Caso: Se crea una cola nueva y se inserta un elemento
    // RE: La cola NO está vacía y el número de elementos es uno
    ColaArray<String> cola = new ColaArray<>();
    String valorOriginal = "Uno";
    cola.push(valorOriginal);
    assertFalse(cola.esVacia());
    assertEquals(1, cola.getNumeroElementos());
  }

  @Test
  void testColaUnElementoSale() {
    // Caso: Se crea una cola nueva, se inserta un elemento y luego se extrae
    // RE: La cola está vacía, el número de elementos es cero y el elemento
    //     extraido coincide con el introducido
    ColaArray<String> cola = new ColaArray<>();
    String valorOriginal = "Uno";
    cola.push(valorOriginal);
    String valorLeido = cola.pop();
    assertTrue(cola.esVacia());
    assertEquals(0, cola.getNumeroElementos());
    assertEquals(valorOriginal, valorLeido);
  }

  @Test
  void testColaUnElementoDosSalen() {
    // Caso: Se crea una cola nueva, se inserta un elemento y luego se extraen dos
    // RE: Se produce una excepción EmptyStackException
    ColaArray<String> cola = new ColaArray<>();
    String valorOriginal = "Uno";
    cola.push(valorOriginal);
    cola.pop();
    assertThrows(EmptyStackException.class, () -> cola.pop());
  }

  @Test
  void testColaDosElementosEntran() {
    // Caso: Se crea una cola nueva, se insertan dos elementos
    // RE: La cola NO está vacía y tiene 2 elementos
    ColaArray<String> cola = new ColaArray<>();
    String valorOriginal1 = "Uno";
    cola.push(valorOriginal1);
    String valorOriginal2 = "Dos";
    cola.push(valorOriginal2);
    assertFalse(cola.esVacia());
    assertEquals(2, cola.getNumeroElementos());
  }

  @Test
  void testColaDosElementosEntranUnoSale() {
    // Caso: Se crea una cola nueva, se insertan dos elementos y se extrae uno
    // RE: La cola NO está vacía, tiene 1 elemento y el extraido coincide con
    //     el primero introducido
    ColaArray<String> cola = new ColaArray<>();
    String valorOriginal1 = "Uno";
    cola.push(valorOriginal1);
    String valorOriginal2 = "Dos";
    cola.push(valorOriginal2);
    String valorLeido = cola.pop();
    assertFalse(cola.esVacia());
    assertEquals(1, cola.getNumeroElementos());
    assertEquals(valorOriginal1, valorLeido);
  }

  @Test
  void testColaDosElementosEntranDosSalen() {
    // Caso: Se crea una cola nueva, se insertan dos elementos y se extraen ambos
    // RE: La cola está vacía, tiene 0 elementos y el primer extraido coincide
    //     con el primer introducido y el segundo extraido con el segundo introducido
    ColaArray<String> cola = new ColaArray<>();
    String valorOriginal1 = "Uno";
    cola.push(valorOriginal1);
    String valorOriginal2 = "Dos";
    cola.push(valorOriginal2);
    String valorLeido1 = cola.pop();
    String valorLeido2 = cola.pop();
    assertTrue(cola.esVacia());
    assertEquals(0, cola.getNumeroElementos());
    assertEquals(valorOriginal1, valorLeido1);
    assertEquals(valorOriginal2, valorLeido2);
  }

  @Test
  void testColaDosElementosEntranTresSalen() {
    // Caso: Se crea una cola nueva, se insertan dos elementos y se extraen tres
    // RE: Se produce EmptyStackException
    ColaArray<String> cola = new ColaArray<>();
    String valorOriginal1 = "Uno";
    cola.push(valorOriginal1);
    String valorOriginal2 = "Dos";
    cola.push(valorOriginal2);
    cola.pop();
    cola.pop();
    assertThrows(EmptyStackException.class, () -> cola.pop());
  }
  
  @Test
  void testColaMiscelanea() {
    // Caso: Se crea una cola nueva, se insertan dos elementos, se extraen,
    //       se añaden 5 mas, se extrae uno, se añaden dos mas y se extrae 1
    // RE: Cola Vacia (V), cero elementos (0), Cola No Vacía (NV), un elemento (1)
    //     ,NV 2, NV 1 es igual al primero introducido, V 0 es igual al segundo introducido
    //     , NV 1, NV 2, NV 3, NV 4, NV 5, NV 4 es igual al tercero introducido,
    //     , NV 5, NV 6, NV 5 es igual al cuarto introducido
    ColaArray<String> cola = new ColaArray<>();
    assertTrue(cola.esVacia());
    assertEquals(0, cola.getNumeroElementos());
    cola.push("Uno");
    assertFalse(cola.esVacia());
    assertEquals(1, cola.getNumeroElementos());
    cola.push("Dos");
    assertFalse(cola.esVacia());
    assertEquals(2, cola.getNumeroElementos());
    String valor = cola.pop();
    assertFalse(cola.esVacia());
    assertEquals(1, cola.getNumeroElementos());
    assertEquals("Uno", valor);
    valor = cola.pop();
    assertTrue(cola.esVacia());
    assertEquals(0, cola.getNumeroElementos());
    assertEquals("Dos", valor);
    cola.push("Tres");
    assertFalse(cola.esVacia());
    assertEquals(1, cola.getNumeroElementos());
    cola.push("Cuatro");
    assertFalse(cola.esVacia());
    assertEquals(2, cola.getNumeroElementos());
    cola.push("Cinco");
    assertFalse(cola.esVacia());
    assertEquals(3, cola.getNumeroElementos());
    cola.push("Seis");
    assertFalse(cola.esVacia());
    assertEquals(4, cola.getNumeroElementos());
    cola.push("Siete");
    assertFalse(cola.esVacia());
    assertEquals(5, cola.getNumeroElementos());
    valor = cola.pop();
    assertFalse(cola.esVacia());
    assertEquals(4, cola.getNumeroElementos());
    assertEquals("Tres", valor);
    cola.push("Ocho");
    assertFalse(cola.esVacia());
    assertEquals(5, cola.getNumeroElementos());
    cola.push("Nueve");
    assertFalse(cola.esVacia());
    assertEquals(6, cola.getNumeroElementos());
    valor = cola.pop();
    assertFalse(cola.esVacia());
    assertEquals(5, cola.getNumeroElementos());
    assertEquals("Cuatro", valor);
  }
  
  
}
