package prog.unidad06.arraysuni.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PruebaGeneraArrayEnteroAleatorio {

  @Test
  void testLongitudIncorrectaCero() {
    // Caso: Intenta usar una longitud incorrecta (0). El resto de parámetros correctos (0 y 1)
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> UtilidadesArrays2.generaArrayEnteroAleatorio(0, 0, 1));
  }

  @Test
  void testLongitudIncorrectaNegativa() {
    // Caso: Intenta usar una longitud incorrecta (-1). El resto de parámetros correctos (0 y 1)
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> UtilidadesArrays2.generaArrayEnteroAleatorio(-1, 0, 1));
  }

  @Test
  void testValorMinimoMayorValorMaximo() {
    // Caso: Intenta usar una longitud correcta (1). El valor minimo será mayor que el máximo
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> UtilidadesArrays2.generaArrayEnteroAleatorio(1, 1, 0));
  }

  @Test
  void testCorrectoTodosPositivos() {
    // Caso: Intenta crear un array de longitud 10 con todos los números positivos entre 1 y 10
    // Resultado esperado: El array tiene la longitud esperada (10) y todos los números están entre 1 y 10
    
    // Hacemos la prueba
    hazPrueba(10, 1, 10);
  }

  @Test
  void testCorrectoTodosPositivosConCero() {
    // Caso: Intenta crear un array de longitud 10 con todos los números positivos entre 0 y 10
    // Resultado esperado: El array tiene la longitud esperada (10) y todos los números están entre 0 y 10

    hazPrueba(10, 0, 10);
  }

  @Test
  void testCorrectoTodosNegativos() {
    // Caso: Intenta crear un array de longitud 10 con todos los números negativos entre -10 y -1
    // Resultado esperado: El array tiene la longitud esperada (10) y todos los números están entre 0 y 10

    hazPrueba(10, -10, -1);
  }

  @Test
  void testCorrectoTodosNegativosConCero() {
    // Caso: Intenta crear un array de longitud 10 con todos los números negativos entre -10 y 0
    // Resultado esperado: El array tiene la longitud esperada (10) y todos los números están entre 0 y 10

    hazPrueba(10, -10, 0);
  }

  @Test
  void testCorrectoInicioNegativoFinPositivo() {
    // Caso: Intenta crear un array de longitud 10 con todos los números negativos entre -10 y 10
    // Resultado esperado: El array tiene la longitud esperada (10) y todos los números están entre -10 y 10

    hazPrueba(10, -10, 10);
  }

  private void hazPrueba(int longitud, int minimo, int maximo) {
    // Obtenemos el array
    int[] array = UtilidadesArrays2.generaArrayEnteroAleatorio(longitud, minimo, maximo);
    // La longitud debe ser la esperada
    assertEquals(longitud, array.length);
    // Para cada elemento
    for (int elemento: array) {
      // Debe estar incluido en el intervalo, incluyendo los extremos
      assertTrue(elemento >= minimo && elemento <= maximo);
    }
  }

}
