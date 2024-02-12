package prog.unidad06.arraysuni.ejercicio04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PruebaMinimoMaximoBusquedaArray {

  @Test
  void testMinimoVacio() {
    // Caso: Intenta obtener el mínimo de un array vacío (longitud cero)
    // Resultado esperado: Se lanza IllegalArgumentException
    int[] array = {};
    assertThrows(IllegalArgumentException.class, () -> UtilidadesArrays2.getMinimoArrayEntero(array));
  }

  @Test
  void testMinimoNull() {
    // Caso: Intenta obtener el mínimo de un array null
    // Resultado esperado: Se lanza IllegalArgumentException
    int[] array = null;
    assertThrows(IllegalArgumentException.class, () -> UtilidadesArrays2.getMinimoArrayEntero(array));
  }

  @Test
  void testMinimoUnElemento() {
    // Caso: Intenta obtener el mínimo de un array con un solo elemento
    // Resultado esperado: Se devuelve el único elemento
    int[] array = {1};
    assertEquals(1, UtilidadesArrays2.getMinimoArrayEntero(array));
  }

  @Test
  void testMinimoDosIguales() {
    // Caso: Intenta obtener el mínimo de un array con dos elementos iguales
    // Resultado esperado: Se devuelve el elemento
    int[] array = {1, 1};
    assertEquals(1, UtilidadesArrays2.getMinimoArrayEntero(array));
  }

  @Test
  void testMinimoMayorPrimero() {
    // Caso: Intenta obtener el mínimo de un array con dos elementos siendo el primero mayor que el segundo
    // Resultado esperado: Se devuelve el segundo elemento
    int[] array = {2, 1};
    assertEquals(1, UtilidadesArrays2.getMinimoArrayEntero(array));
  }

  @Test
  void testMinimoMenorPrimero() {
    // Caso: Intenta obtener el mínimo de un array con dos elementos siendo el primero menor que el segundo
    // Resultado esperado: Se devuelve el primer elemento
    int[] array = {1, 2};
    assertEquals(1, UtilidadesArrays2.getMinimoArrayEntero(array));
  }

  @Test
  void testMaximoVacio() {
    // Caso: Intenta obtener el maximo de un array vacío (longitud cero)
    // Resultado esperado: Se lanza IllegalArgumentException
    int[] array = {};
    assertThrows(IllegalArgumentException.class, () -> UtilidadesArrays2.getMaximoArrayEntero(array));
  }

  @Test
  void testMaximoNull() {
    // Caso: Intenta obtener el maximo de un array null
    // Resultado esperado: Se lanza IllegalArgumentException
    int[] array = null;
    assertThrows(IllegalArgumentException.class, () -> UtilidadesArrays2.getMaximoArrayEntero(array));
  }

  @Test
  void testMaximoUnElemento() {
    // Caso: Intenta obtener el maximo de un array con un solo elemento
    // Resultado esperado: Se devuelve el único elemento
    int[] array = {1};
    assertEquals(1, UtilidadesArrays2.getMaximoArrayEntero(array));
  }

  @Test
  void testMaximoDosIguales() {
    // Caso: Intenta obtener el maximo de un array con dos elementos iguales
    // Resultado esperado: Se devuelve el elemento
    int[] array = {1, 1};
    assertEquals(1, UtilidadesArrays2.getMaximoArrayEntero(array));
  }

  @Test
  void testMaximoMayorPrimero() {
    // Caso: Intenta obtener el maximo de un array con dos elementos siendo el primero mayor que el segundo
    // Resultado esperado: Se devuelve el primer elemento
    int[] array = {2, 1};
    assertEquals(2, UtilidadesArrays2.getMaximoArrayEntero(array));
  }

  @Test
  void testMaximoMenorPrimero() {
    // Caso: Intenta obtener el maximo de un array con dos elementos siendo el primero menor que el segundo
    // Resultado esperado: Se devuelve el segundo elemento
    int[] array = {1, 2};
    assertEquals(2, UtilidadesArrays2.getMaximoArrayEntero(array));
  }

  @Test
  void testEnteroBuscarNull() {
    // Caso: Intenta encontrar el número de ocurrencias de un entero en un array null
    // Resultado esperado: Se devuelve 0
    int[] array = null;
    int numero = 9;
    assertEquals(0, UtilidadesArrays2.enteroApareceEnArrayEntero(array, numero));
  }

  @Test
  void testEnteroBuscarVacio() {
    // Caso: Intenta encontrar el número de ocurrencias de un entero en un array vacio
    // Resultado esperado: Se devuelve 0
    int[] array = {};
    int numero = 9;
    assertEquals(0, UtilidadesArrays2.enteroApareceEnArrayEntero(array, numero));
  }

  @Test
  void testEnteroBuscarCeroOcurrencias() {
    // Caso: Intenta encontrar el número de ocurrencias de un entero en un array
    //       que no contiene ninguna ocurrencia del número
    // Resultado esperado: Se devuelve 0
    int[] array = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1};
    int numero = 9;
    assertEquals(0, UtilidadesArrays2.enteroApareceEnArrayEntero(array, numero));
  }

  @Test
  void testEnteroBuscarUnaOcurrencia() {
    // Caso: Intenta encontrar el número de ocurrencias de un entero en un array
    //       que contiene una ocurrencia del número
    // Resultado esperado: Se devuelve 1
    int[] array = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1};
    int numero = 5;
    assertEquals(1, UtilidadesArrays2.enteroApareceEnArrayEntero(array, numero));
  }

  @Test
  void testEnteroBuscarDosOcurrencias() {
    // Caso: Intenta encontrar el número de ocurrencias de un entero en un array
    //       que contiene dos ocurrencias del número
    // Resultado esperado: Se devuelve 2
    int[] array = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1};
    int numero = 4;
    assertEquals(2, UtilidadesArrays2.enteroApareceEnArrayEntero(array, numero));
  }

  @Test
  void testEnteroBuscarTresOcurrencias() {
    // Caso: Intenta encontrar el número de ocurrencias de un entero en un array
    //       que contiene tres ocurrencias del número
    // Resultado esperado: Se devuelve 2
    int[] array = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1};
    int numero = 3;
    assertEquals(3, UtilidadesArrays2.enteroApareceEnArrayEntero(array, numero));
  }

  @Test
  void testEnteroBuscarCuatroOcurrencias() {
    // Caso: Intenta encontrar el número de ocurrencias de un entero en un array
    //       que contiene cuatro ocurrencias del número
    // Resultado esperado: Se devuelve 2
    int[] array = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1};
    int numero = 2;
    assertEquals(4, UtilidadesArrays2.enteroApareceEnArrayEntero(array, numero));
  }

  @Test
  void testEnteroBuscarCincoOcurrencias() {
    // Caso: Intenta encontrar el número de ocurrencias de un entero en un array
    //       que contiene cinco ocurrencias del número
    // Resultado esperado: Se devuelve 5
    int[] array = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1};
    int numero = 1;
    assertEquals(5, UtilidadesArrays2.enteroApareceEnArrayEntero(array, numero));
  }

}
