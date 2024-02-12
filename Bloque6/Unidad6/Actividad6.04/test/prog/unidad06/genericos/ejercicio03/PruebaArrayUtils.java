package prog.unidad06.genericos.ejercicio03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PruebaArrayUtils {

  @Test
  void testIntercambiarElementosNull() {
    // Caso: Se intenta intercambiar dos elementos en un array null
    // RE  : Se lanza NullPointerException
    assertThrows(NullPointerException.class, ()->ArrayUtils.intercambiarElementos(null, 0, 1));
  }

  @Test
  void testIntercambiarElementosUnElemento() {
    // Caso: Se intenta intercambiar el mismo elemento de un array de un solo elemento
    // RE  : Se intercambia pero no tiene efecto
    String[] array = {"Uno"};
    ArrayUtils.intercambiarElementos(array, 0, 0);
    assertEquals("Uno", array[0]);
  }

  @Test
  void testIntercambiarElementosDosElementos() {
    // Caso: Se intenta intercambiar dos elementos distintos de un array
    // RE  : Se intercambia y los elementos tienen los valores intercambiados
    String[] array = {"Uno", "Dos"};
    ArrayUtils.intercambiarElementos(array, 0, 1);
    assertEquals("Dos", array[0]);
    assertEquals("Uno", array[1]);
  }

  @Test
  void testIntercambiarElementosMalPrimerIndice() {
    // Caso: Se intenta intercambiar dos elementos distintos de un array usando
    //       el primer indice incorrecto
    // RE  : Se lanza ArrayIndexOutOfBoundsException
    String[] array = {"Uno", "Dos"};
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> ArrayUtils.intercambiarElementos(array, 2, 1));
  }

  @Test
  void testIntercambiarElementosMalSegundoIndice() {
    // Caso: Se intenta intercambiar dos elementos distintos de un array usando
    //       el segundo indice incorrecto
    // RE  : Se lanza ArrayIndexOutOfBoundsException
    String[] array = {"Uno", "Dos"};
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> ArrayUtils.intercambiarElementos(array, 0, 2));
  }

  @Test
  void testInvertirArrayNull() {
    // Caso: Se intenta invertir un array nulo
    // RE  : Se lanza NullPointerException
    String[] array = null;
    assertThrows(NullPointerException.class, () -> ArrayUtils.invertirArray(array));
  }

  @Test
  void testInvertirArrayVacio() {
    // Caso: Se intenta invertir un array vacio
    // RE  : No hace nada
    String[] array = {};
    ArrayUtils.invertirArray(array);
  }

  @Test
  void testInvertirArrayUnElemento() {
    // Caso: Se intenta invertir un array de un elemento
    // RE  : El array queda igual
    String[] array = {"Uno"};
    String[] re = {"Uno"};
    ArrayUtils.invertirArray(array);
    assertArrayEquals(re,  array);
  }

  @Test
  void testInvertirArrayDosElementos() {
    // Caso: Se intenta invertir un array de dos elementos (Uno y Dos)
    // RE  : El array queda invertido Dos y Uno
    String[] array = {"Uno", "Dos"};
    String[] re = {"Dos", "Uno"};
    ArrayUtils.invertirArray(array);
    assertArrayEquals(re,  array);
  }

  @Test
  void testInvertirArrayTresElementos() {
    // Caso: Se intenta invertir un array de tres elementos (Uno, Dos, Tres)
    // RE  : El array queda invertido Tres, Dos y Uno
    String[] array = {"Uno", "Dos", "Tres"};
    String[] re = {"Tres", "Dos", "Uno"};
    ArrayUtils.invertirArray(array);
    assertArrayEquals(re,  array);
  }

}
