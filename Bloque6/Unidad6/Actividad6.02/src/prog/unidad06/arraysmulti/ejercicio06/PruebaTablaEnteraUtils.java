package prog.unidad06.arraysmulti.ejercicio06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PruebaTablaEnteraUtils {

  @Test
  void testNuevaTablaAleatoriaCeroFilas() {
    // Caso: Usa TablaEnteraUtils.nuevaTablaAleatoria con 0 filas (el resto de parámetros correctos)
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.nuevaTablaAleatoria(0, 1, 0, 10));
  }

  @Test
  void testNuevaTablaAleatoriaCeroColumnas() {
    // Caso: Usa TablaEnteraUtils.nuevaTablaAleatoria con 0 columnas (el resto de parámetros correctos)
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.nuevaTablaAleatoria(1, 0, 0, 10));
  }

  @Test
  void testNuevaTablaAleatoriaLimitesIncorrectos() {
    // Caso: Usa TablaEnteraUtils.nuevaTablaAleatoria con el limite inferior superior al superior
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.nuevaTablaAleatoria(1, 1, 10, 0));
  }

  @Test
  void testNuevaTablaAleatoriaNormal() {
    // Caso: Usa TablaEnteraUtils.nuevaTablaAleatoria para crear una tabla de 5 x 6 elementos
    //   comprendidos entre 1 y 10
    // Resultado esperado: Se crea correctamente, tiene las dimensiones especificadas y los elementos
    //   pertenecen al rango dado
    try {
      // Se crea la tabla
      int[][] tabla = TablaEnteraUtils.nuevaTablaAleatoria(5, 6, 1, 10);
      // Las dimensiones son las esperadas
      assertEquals(5, tabla.length);
      assertEquals(6, tabla[0].length);
      // Para cada elemento
      for (int[] fila: tabla) {
        for (int elemento: fila) {
          assertTrue(elemento >= 1 && elemento <= 10);
        }
      }
    } catch (IllegalArgumentException e) {
      fail("Se lanzó IllegalArgumentException");
    }
  }

  @Test
  void testGetMaximoNull() {
    // Caso: Usa TablaEnteraUtils.getMaximo con una tabla null
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.getMaximo(null));
  }

  @Test
  void testGetMaximoVacia() {
    // Caso: Usa TablaEnteraUtils.getMaximo con una tabla vacia
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.getMaximo(null));
  }

  @Test
  void testGetMaximoUnElemento() {
    // Caso: Usa TablaEnteraUtils.getMaximo con una tabla con un elemento
    // Resultado esperado: Devuelve el elemento
    int[][]tabla = new int[1][1];
    tabla[0][0] = 10;
    assertEquals(10, TablaEnteraUtils.getMaximo(tabla));
  }

  @Test
  void testGetMaximoElementosVariadosNoRepetidos() {
    // Caso: Usa TablaEnteraUtils.getMaximo con una tabla con elementos variados no repetidos
    // Resultado esperado: Devuelve el elemento máximo
    int[][]tabla = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20}
    };
    assertEquals(20, TablaEnteraUtils.getMaximo(tabla));
  }

  @Test
  void testGetMaximoElementosVariadosNoRepetidosInverso() {
    // Caso: Usa TablaEnteraUtils.getMaximo con una tabla con elementos variados no repetidos
    // Resultado esperado: Devuelve el elemento máximo
    int[][]tabla = {
        {20, 19, 18, 17, 16},
        {15, 14, 13, 12, 11},
        {10, 9, 8, 7, 6},
        {5, 4, 3, 2, 1}
    };
    assertEquals(20, TablaEnteraUtils.getMaximo(tabla));
  }

  @Test
  void testGetMaximoElementosVariadosRepetidos() {
    // Caso: Usa TablaEnteraUtils.getMaximo con una tabla con elementos variados repetidos
    // Resultado esperado: Devuelve el elemento máximo
    int[][]tabla = {
        {20, 19, 18, 17, 16},
        {15, 20, 13, 12, 11},
        {10, 9, 20, 7, 6},
        {5, 4, 3, 20, 1}
    };
    assertEquals(20, TablaEnteraUtils.getMaximo(tabla));
  }

  @Test
  void testGetMinimoNull() {
    // Caso: Usa TablaEnteraUtils.getMinimo con una tabla null
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.getMinimo(null));
  }

  @Test
  void testGetMinimoVacia() {
    // Caso: Usa TablaEnteraUtils.getMinimo con una tabla vacia
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.getMinimo(null));
  }

  @Test
  void testGetMinimoUnElemento() {
    // Caso: Usa TablaEnteraUtils.getMinimo con una tabla con un elemento
    // Resultado esperado: Devuelve el elemento
    int[][]tabla = new int[1][1];
    tabla[0][0] = 10;
    assertEquals(10, TablaEnteraUtils.getMinimo(tabla));
  }

  @Test
  void testGetMinimoElementosVariadosNoRepetidos() {
    // Caso: Usa TablaEnteraUtils.getMinimo con una tabla con elementos variados no repetidos
    // Resultado esperado: Devuelve el elemento mínimo
    int[][]tabla = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20}
    };
    assertEquals(1, TablaEnteraUtils.getMinimo(tabla));
  }

  @Test
  void testGetMinimoElementosVariadosNoRepetidosInverso() {
    // Caso: Usa TablaEnteraUtils.getMinimo con una tabla con elementos variados no repetidos
    // Resultado esperado: Devuelve el elemento mínimo
    int[][]tabla = {
        {20, 19, 18, 17, 16},
        {15, 14, 13, 12, 11},
        {10, 9, 8, 7, 6},
        {5, 4, 3, 2, 1}
    };
    assertEquals(1, TablaEnteraUtils.getMinimo(tabla));
  }

  @Test
  void testGetMinimoElementosVariadosRepetidos() {
    // Caso: Usa TablaEnteraUtils.getMaximo con una tabla con elementos variados repetidos
    // Resultado esperado: Devuelve el elemento máximo
    int[][]tabla = {
        {20, 1, 18, 17, 16},
        {15, 16, 1, 12, 11},
        {10, 9, 8, 1, 6},
        {5, 4, 3, 2, 1}
    };
    assertEquals(1, TablaEnteraUtils.getMinimo(tabla));
  }

  @Test
  void testLocalizaMaximoNull() {
    // Caso: Usa TablaEnteraUtils.localizaMaximo con una tabla null
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.localizaMaximo(null));
  }

  @Test
  void testLocalizaMaximoVacia() {
    // Caso: Usa TablaEnteraUtils.localizaMaximo con una tabla vacia
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.localizaMaximo(null));
  }

  @Test
  void testLocalizaMaximoUnElemento() {
    // Caso: Usa TablaEnteraUtils.localizaMaximo con una tabla con un elemento
    // Resultado esperado: Devuelve la posición (0,0)
    int[][]tabla = new int[1][1];
    tabla[0][0] = 10;
    int[] posicionMaximo = {0, 0};
    assertArrayEquals(posicionMaximo, TablaEnteraUtils.localizaMaximo(tabla));
  }

  @Test
  void testLocalizaMaximoElementosVariadosNoRepetidos() {
    // Caso: Usa TablaEnteraUtils.localizaMaximo con una tabla con elementos variados no repetidos
    // Resultado esperado: Devuelve la posición del elemento máximo (3,4)
    int[][]tabla = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20}
    };
    int[] posicionMaximo = {3, 4};   
    assertArrayEquals(posicionMaximo, TablaEnteraUtils.localizaMaximo(tabla));
  }

  @Test
  void testLocalizaMaximoElementosVariadosNoRepetidosInverso() {
    // Caso: Usa TablaEnteraUtils.localizaMaximo con una tabla con elementos variados no repetidos
    // Resultado esperado: Devuelve la posicion del elemento máximo (0,0)
    int[][]tabla = {
        {20, 19, 18, 17, 16},
        {15, 14, 13, 12, 11},
        {10, 9, 8, 7, 6},
        {5, 4, 3, 2, 1}
    };
    int[] posicionMaximo = {0, 0};
    assertArrayEquals(posicionMaximo, TablaEnteraUtils.localizaMaximo(tabla));
  }

  @Test
  void testLocalizaMaximoElementosVariadosRepetidos() {
    // Caso: Usa TablaEnteraUtils.localizaMaximo con una tabla con elementos variados repetidos
    // Resultado esperado: Devuelve la primera posición del elemento máximo (0,0)
    int[][]tabla = {
        {20, 19, 18, 17, 16},
        {15, 20, 13, 12, 11},
        {10, 9, 20, 7, 6},
        {5, 4, 3, 20, 1}
    };
    int[] posicionMaximo = {0, 0};
    assertArrayEquals(posicionMaximo, TablaEnteraUtils.localizaMaximo(tabla));
  }

  @Test
  void testLocalizaMinimoNull() {
    // Caso: Usa TablaEnteraUtils.localizaMinimo con una tabla null
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.localizaMinimo(null));
  }

  @Test
  void testLocalizaMinimoVacia() {
    // Caso: Usa TablaEnteraUtils.localizaMinimo con una tabla vacia
    // Resultado esperado: Lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, ()->TablaEnteraUtils.localizaMinimo(null));
  }

  @Test
  void testLocalizaMinimoUnElemento() {
    // Caso: Usa TablaEnteraUtils.localizaMinimo con una tabla con un elemento
    // Resultado esperado: Devuelve la posición (0,0)
    int[][]tabla = new int[1][1];
    tabla[0][0] = 10;
    int[] posicionMinimo = {0, 0};
    assertArrayEquals(posicionMinimo, TablaEnteraUtils.localizaMinimo(tabla));
  }

  @Test
  void testLocalizaMinimoElementosVariadosNoRepetidos() {
    // Caso: Usa TablaEnteraUtils.localizaMinimo con una tabla con elementos variados no repetidos
    // Resultado esperado: Devuelve la posición del elemento mínimo (0,0)
    int[][]tabla = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20}
    };
    int[] posicionMinimo = {0, 0};   
    assertArrayEquals(posicionMinimo, TablaEnteraUtils.localizaMinimo(tabla));
  }

  @Test
  void testLocalizaMinimoElementosVariadosNoRepetidosInverso() {
    // Caso: Usa TablaEnteraUtils.localizaMinimo con una tabla con elementos variados no repetidos
    // Resultado esperado: Devuelve la posicion del elemento minimo (3,4)
    int[][]tabla = {
        {20, 19, 18, 17, 16},
        {15, 14, 13, 12, 11},
        {10, 9, 8, 7, 6},
        {5, 4, 3, 2, 1}
    };
    int[] posicionMinimo = {3, 4};
    assertArrayEquals(posicionMinimo, TablaEnteraUtils.localizaMinimo(tabla));
  }

  @Test
  void testLocalizaMinimoElementosVariadosRepetidos() {
    // Caso: Usa TablaEnteraUtils.localizaMinimo con una tabla con elementos variados repetidos
    // Resultado esperado: Devuelve la primera posición del elemento mínimo (0,1)
    int[][]tabla = {
        {20, 1, 18, 17, 16},
        {15, 14, 1, 12, 11},
        {10, 9, 8, 1, 6},
        {5, 4, 3, 2, 1}
    };
    int[] posicionMinimo = {0, 1};
    assertArrayEquals(posicionMinimo, TablaEnteraUtils.localizaMinimo(tabla));
  }

}
