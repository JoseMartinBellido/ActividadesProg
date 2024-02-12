package prog.unidad06.genericos.ejercicio01;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class PruebaPilaArray {

  @Test
  void testPilaNueva() {
    // Caso: Se crea una pila nueva
    // RE: La pila está vacía y el número de elementos es cero
    PilaArray<String> pila = new PilaArray<>();
    assertTrue(pila.esVacia());
    assertEquals(0, pila.getNumeroElementos());
  }

  @Test
  void testPilaUnElemento() {
    // Caso: Se crea una pila nueva y se inserta un elemento
    // RE: La pila NO está vacía y el número de elementos es uno
    PilaArray<String> pila = new PilaArray<>();
    String valorOriginal = "Uno";
    pila.push(valorOriginal);
    assertFalse(pila.esVacia());
    assertEquals(1, pila.getNumeroElementos());
  }

  @Test
  void testPilaUnElementoSale() {
    // Caso: Se crea una pila nueva, se inserta un elemento y luego se extrae
    // RE: La pila está vacía, el número de elementos es cero y el elemento
    //     extraido coincide con el introducido
    PilaArray<String> pila = new PilaArray<>();
    String valorOriginal = "Uno";
    pila.push(valorOriginal);
    String valorLeido = pila.pop();
    assertTrue(pila.esVacia());
    assertEquals(0, pila.getNumeroElementos());
    assertEquals(valorOriginal, valorLeido);
  }

  @Test
  void testPilaUnElementoDosSalen() {
    // Caso: Se crea una pila nueva, se inserta un elemento y luego se extraen dos
    // RE: Se produce una excepción EmptyStackException
    PilaArray<String> pila = new PilaArray<>();
    String valorOriginal = "Uno";
    pila.push(valorOriginal);
    pila.pop();
    assertThrows(EmptyStackException.class, () -> pila.pop());
  }

  @Test
  void testPilaDosElementosEntran() {
    // Caso: Se crea una pila nueva, se insertan dos elementos
    // RE: La pila NO está vacía y tiene 2 elementos
    PilaArray<String> pila = new PilaArray<>();
    String valorOriginal1 = "Uno";
    pila.push(valorOriginal1);
    String valorOriginal2 = "Dos";
    pila.push(valorOriginal2);
    assertFalse(pila.esVacia());
    assertEquals(2, pila.getNumeroElementos());
  }

  @Test
  void testPilaDosElementosEntranUnoSale() {
    // Caso: Se crea una pila nueva, se insertan dos elementos y se extrae uno
    // RE: La pila NO está vacía, tiene 1 elemento y el extraido coincide con
    //     el segundo introducido
    PilaArray<String> pila = new PilaArray<>();
    String valorOriginal1 = "Uno";
    pila.push(valorOriginal1);
    String valorOriginal2 = "Dos";
    pila.push(valorOriginal2);
    String valorLeido = pila.pop();
    assertFalse(pila.esVacia());
    assertEquals(1, pila.getNumeroElementos());
    assertEquals(valorOriginal2, valorLeido);
  }

  @Test
  void testPilaDosElementosEntranDosSalen() {
    // Caso: Se crea una pila nueva, se insertan dos elementos y se extraen ambos
    // RE: La pila está vacía, tiene 0 elementos y el primer extraido coincide
    //     con el último introducido y el segundo extraido con el primero
    PilaArray<String> pila = new PilaArray<>();
    String valorOriginal1 = "Uno";
    pila.push(valorOriginal1);
    String valorOriginal2 = "Dos";
    pila.push(valorOriginal2);
    String valorLeido1 = pila.pop();
    String valorLeido2 = pila.pop();
    assertTrue(pila.esVacia());
    assertEquals(0, pila.getNumeroElementos());
    assertEquals(valorOriginal2, valorLeido1);
    assertEquals(valorOriginal1, valorLeido2);
  }

  @Test
  void testPilaDosElementosEntranTresSalen() {
    // Caso: Se crea una pila nueva, se insertan dos elementos y se extraen tres
    // RE: Se produce EmptyStackException
    PilaArray<String> pila = new PilaArray<>();
    String valorOriginal1 = "Uno";
    pila.push(valorOriginal1);
    String valorOriginal2 = "Dos";
    pila.push(valorOriginal2);
    pila.pop();
    pila.pop();
    assertThrows(EmptyStackException.class, () -> pila.pop());
  }
  
  @Test
  void testPilaMiscelanea() {
    // Caso: Se crea una pila nueva, se insertan dos elementos, se extraen,
    //       se añaden 5 mas, se extrae uno, se añaden dos mas y se extrae 1
    // RE: Pila Vacia (V), cero elementos (0), Pila No Vacía (NV), un elemento (1)
    //     ,NV 2, NV 1 es igual al segundo introducido, V 0 es igual al primer introducido
    //     , NV 1, NV 2, NV 3, NV 4, NV 5, NV 4 es igual al ultimo introducido,
    //     , NV 5, NV 6, NV 5 es igual al último introducido
    PilaArray<String> pila = new PilaArray<>();
    assertTrue(pila.esVacia());
    assertEquals(0, pila.getNumeroElementos());
    pila.push("Uno");
    assertFalse(pila.esVacia());
    assertEquals(1, pila.getNumeroElementos());
    pila.push("Dos");
    assertFalse(pila.esVacia());
    assertEquals(2, pila.getNumeroElementos());
    String valor = pila.pop();
    assertFalse(pila.esVacia());
    assertEquals(1, pila.getNumeroElementos());
    assertEquals("Dos", valor);
    valor = pila.pop();
    assertTrue(pila.esVacia());
    assertEquals(0, pila.getNumeroElementos());
    assertEquals("Uno", valor);
    pila.push("Tres");
    assertFalse(pila.esVacia());
    assertEquals(1, pila.getNumeroElementos());
    pila.push("Cuatro");
    assertFalse(pila.esVacia());
    assertEquals(2, pila.getNumeroElementos());
    pila.push("Cinco");
    assertFalse(pila.esVacia());
    assertEquals(3, pila.getNumeroElementos());
    pila.push("Seis");
    assertFalse(pila.esVacia());
    assertEquals(4, pila.getNumeroElementos());
    pila.push("Siete");
    assertFalse(pila.esVacia());
    assertEquals(5, pila.getNumeroElementos());
    valor = pila.pop();
    assertFalse(pila.esVacia());
    assertEquals(4, pila.getNumeroElementos());
    assertEquals("Siete", valor);
    pila.push("Ocho");
    assertFalse(pila.esVacia());
    assertEquals(5, pila.getNumeroElementos());
    pila.push("Nueve");
    assertFalse(pila.esVacia());
    assertEquals(6, pila.getNumeroElementos());
    valor = pila.pop();
    assertFalse(pila.esVacia());
    assertEquals(5, pila.getNumeroElementos());
    assertEquals("Nueve", valor);
  }
  
  
}
