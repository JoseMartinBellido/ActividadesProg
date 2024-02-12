package prog.unidad06.arraysmulti.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PruebaTablaEnteraConTotales {

  @Test
  void testTablaVacia() {
    // Caso: Crea una tabla con 0 filas y 0 columnas
    // Resultado esperado: Excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new TablaEnteraConTotales(0, 0));
  }

  @Test
  void testTablaVaciaFilas() {
    // Caso: Crea una tabla con 0 filas y 1 columna
    // Resultado esperado: Excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new TablaEnteraConTotales(0, 1));
  }

  @Test
  void testTablaVaciaColumnas() {
    // Caso: Crea una tabla con 1 filas y 0 columnas
    // Resultado esperado: Excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new TablaEnteraConTotales(1, 0));
  }

  @Test
  void testTablaUnElemento() {
    // Caso: Crea una tabla con 1 fila y 1 columna y asigna un valor cualquiera.
    // Resultado esperado: Tanto la casilla como todos los totales deben ser igual al valor
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    int valor = 5;
    tabla.setCasilla(0, 0, valor);
    assertEquals(valor, tabla.getCasilla(0, 0));
    assertEquals(valor, tabla.getTotalFila(0));
    assertEquals(valor, tabla.getTotalColumna(0));
    assertEquals(valor, tabla.getTotalTabla());
  }

  @Test
  void testTablaDosPorDos() {
    // Caso: Crea una tabla con 2 filas y 2 columnas y asigna los valores 1, 2, 3, 4
    // Resultado esperado: Los totales deben ser 3, 7 para las filas, 4, 6 para las columnas
    //   y 10 para la tabla
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(2, 2);
    tabla.setCasilla(0, 0, 1);
    tabla.setCasilla(0, 1, 2);
    tabla.setCasilla(1, 0, 3);
    tabla.setCasilla(1, 1, 4);
    assertEquals(3, tabla.getTotalFila(0));
    assertEquals(7, tabla.getTotalFila(1));
    assertEquals(4, tabla.getTotalColumna(0));
    assertEquals(6, tabla.getTotalColumna(1));
    assertEquals(10, tabla.getTotalTabla());
  }

  @Test
  void testTablaDosPorDosConSobreescritura() {
    // Caso: Crea una tabla con 2 filas y 2 columnas y asigna los valores 1, 2, 3, 4
    // Resultado esperado: Los totales deben ser  3, 7 para las filas, 4, 6 para las columnas
    //   y 10 para la tabla. A continuación se sobreescriben los valores a 5,6,7,8. Ahora los
    //   totales deben ser 11, 15 para las filas, 12, 14 para las columnas y 26 para la tabla
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(2, 2);
    tabla.setCasilla(0, 0, 1);
    tabla.setCasilla(0, 1, 2);
    tabla.setCasilla(1, 0, 3);
    tabla.setCasilla(1, 1, 4);
    assertEquals(3, tabla.getTotalFila(0));
    assertEquals(7, tabla.getTotalFila(1));
    assertEquals(4, tabla.getTotalColumna(0));
    assertEquals(6, tabla.getTotalColumna(1));
    assertEquals(10, tabla.getTotalTabla());

    // Sobreescribimos
    tabla.setCasilla(0, 0, 5);
    tabla.setCasilla(0, 1, 6);
    tabla.setCasilla(1, 0, 7);
    tabla.setCasilla(1, 1, 8);
    assertEquals(11, tabla.getTotalFila(0));
    assertEquals(15, tabla.getTotalFila(1));
    assertEquals(12, tabla.getTotalColumna(0));
    assertEquals(14, tabla.getTotalColumna(1));
    assertEquals(26, tabla.getTotalTabla());
  }

  @Test
  void testTablaUnElementoSetCasillaFilaMal1() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder a la segunda fila
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.setCasilla(1, 0, 0));
  }

  @Test
  void testTablaUnElementoSetCasillaFilaMal2() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder a la fila -1
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.setCasilla(-1, 0, 0));
  }

  @Test
  void testTablaUnElementoSetCasillaColumnaMal1() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder a la segunda columna
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.setCasilla(0, 1, 0));
  }

  @Test
  void testTablaUnElementoSetCasillaColumnaMal2() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder a la columna -1
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.setCasilla(0, -1, 0));
  }

  @Test
  void testTablaUnElementoGetCasillaFilaMal1() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder a la segunda fila
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.getCasilla(1, 0));
  }

  @Test
  void testTablaUnElementoGetCasillaFilaMal2() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder a la fila -1
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.getCasilla(-1, 0));
  }

  @Test
  void testTablaUnElementoGetCasillaColumnaMal1() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder a la segunda columna
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.getCasilla(0, 1));
  }

  @Test
  void testTablaUnElementoGetCasillaColumnaMal2() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder a la columna -1
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.getCasilla(0, -1));
  }

  @Test
  void testTablaUnElementoGetTotalFilaMal1() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder al total de la
    //   segunda fila
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.getTotalFila(1));
  }

  @Test
  void testTablaUnElementoGetTotalFilaMal2() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder al total de la
    //   fila -1
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.getTotalFila(-1));
  }

  @Test
  void testTablaUnElementoGetTotalColumnaMal1() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder al total de la
    //   segunda columna
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.getTotalColumna(1));
  }

  @Test
  void testTablaUnElementoGetTotalColumnaMal2() {
    // Caso: Crea una tabla con 1 fila y 1 columna e intenta acceder al total de la
    //   columna -1
    // Resultado esperado: Excepción ArrayIndexOutOfBoundsException
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(1, 1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> tabla.getTotalColumna(-1));
  }

}
