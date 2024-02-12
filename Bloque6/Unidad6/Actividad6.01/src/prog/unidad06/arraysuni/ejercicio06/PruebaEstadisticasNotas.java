package prog.unidad06.arraysuni.ejercicio06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PruebaEstadisticasNotas {

  @Test
  void testAddCalificacionCorrectaLimiteBajo() {
    // Caso: Crea un objeto EstadisticasNotas y añade la calificación 0
    // Respuesta esperada: No deben ocurrir excepciones
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    assertDoesNotThrow(() -> notas.addCalificacion(0));
  }

  @Test
  void testAddCalificacionCorrectaMedio() {
    // Caso: Crea un objeto EstadisticasNotas y añade una calificación intermedia (5)
    // Respuesta esperada: No deben ocurrir excepciones
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    assertDoesNotThrow(() -> notas.addCalificacion(5));
  }

  @Test
  void testAddCalificacionCorrectaLimiteAlto() {
    // Caso: Crea un objeto EstadisticasNotas y añade una calificación limite alta (10)
    // Respuesta esperada: No deben ocurrir excepciones
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    assertDoesNotThrow(() -> notas.addCalificacion(10));
  }

  @Test
  void testAddCalificacionIncorrectaPorDebajo() {
    // Caso: Crea un objeto EstadisticasNotas y añade una calificación por debajo del rango (-1)
    // Respuesta esperada: Debe lanzarse IllegalArgumentException
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    assertThrows(IllegalArgumentException.class, () -> notas.addCalificacion(-1));
  }

  @Test
  void testAddCalificacionIncorrectaPorEncima() {
    // Caso: Crea un objeto EstadisticasNotas y añade una calificación por encima del rango (11)
    // Respuesta esperada: Debe lanzarse IllegalArgumentException
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    assertThrows(IllegalArgumentException.class, () -> notas.addCalificacion(11));
  }

  @Test
  void testMediaNingunaCalificacion() {
    // Caso: Crea un objeto EstadisticasNotas
    //       y no añade calificaciones
    // Respuesta esperada: La media debe devolver 0
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    assertEquals(0, notas.calificacionMedia());
  }

  @Test
  void testMediaUnaCalificacion() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade una calificación intermedia (5).
    // Respuesta esperada: La media debe devolver la misma nota (5)
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    int calificacion = 5;
    notas.addCalificacion(calificacion);
    assertEquals(calificacion, notas.calificacionMedia());
  }

  @Test
  void testMediaUnaCalificacionDosVeces() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade una calificación intermedia (5) dos veces.
    // Respuesta esperada: La media debe devolver la misma nota (5)
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    int calificacion = 5;
    notas.addCalificacion(calificacion);
    notas.addCalificacion(calificacion);    
    assertEquals(calificacion, notas.calificacionMedia());
  }

  @Test
  void testMediaUnaCalificacionMasDeDosVeces() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade una calificación intermedia (5) ocho veces.
    // Respuesta esperada: La media debe devolver la misma nota (5)
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    int calificacion = 5;
    notas.addCalificacion(calificacion);
    notas.addCalificacion(calificacion);    
    notas.addCalificacion(calificacion);
    notas.addCalificacion(calificacion);    
    notas.addCalificacion(calificacion);
    notas.addCalificacion(calificacion);    
    notas.addCalificacion(calificacion);
    notas.addCalificacion(calificacion);    
    assertEquals(calificacion, notas.calificacionMedia());
  }

  @Test
  void testMediaDosCalificacionesUnaVez() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade una calificación intermedia (5) y una alta (10).
    // Respuesta esperada: La media debe devolver la media de ambas (7.5)
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    notas.addCalificacion(5);
    notas.addCalificacion(10);    
    assertEquals(7.5, notas.calificacionMedia());
  }

  @Test
  void testMediaDosCalificacionesDosVeces() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade una calificación intermedia (5) y una alta (10) dos veces cada una.
    // Respuesta esperada: La media debe devolver la media de ambas (7.5)
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    notas.addCalificacion(5);
    notas.addCalificacion(10);    
    notas.addCalificacion(5);
    notas.addCalificacion(10);    
    assertEquals(7.5, notas.calificacionMedia());
  }

  @Test
  void testMediaVariada() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade varias calificaciones (0, 2, 4, 6, 8, 10). Algunas se añaden
    //       dos veces (0, 8) y 4 se añade tres veces
    // Respuesta esperada: La media debe ser 4.6
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    notas.addCalificacion(0);
    notas.addCalificacion(0);
    notas.addCalificacion(2);
    notas.addCalificacion(4);
    notas.addCalificacion(4);
    notas.addCalificacion(4);
    notas.addCalificacion(6);
    notas.addCalificacion(8);
    notas.addCalificacion(8);
    notas.addCalificacion(10);
    assertEquals(4.6, notas.calificacionMedia());
  }

  @Test
  void testModaSinCalificaciones() {
    // Caso: Crea un objeto EstadisticasNotas y solicita la moda sin añadir ninguna calificación
    // Respuesta esperada: Se debe lanzar EstadisticasNotasException
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    assertThrows(EstadisticasNotasException2.class, () -> notas.calificacionModa());
  }

  @Test
  void testModaUnaCalificacion() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade una calificación intermedia (5)
    // Respuesta esperada: La moda debe ser la calificacion
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    int calificacion = 5;
    notas.addCalificacion(calificacion);
    try {
      assertEquals(calificacion, notas.calificacionModa());
    } catch (EstadisticasNotasException2 e) {
      fail("Error. Se ha obtenido excepción cuando no se esperaba");
    }
  }

  @Test
  void testModaDosCalificaciones() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade una calificación intermedia (5) y una alta (10)
    // Respuesta esperada: La moda debe ser la calificacion mas baja (5)
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    notas.addCalificacion(5);
    notas.addCalificacion(10);
    try {
      assertEquals(5, notas.calificacionModa());
    } catch (EstadisticasNotasException2 e) {
      fail("Error. Se ha obtenido excepción cuando no se esperaba");
    }
  }

  @Test
  void testModaCalificacionRepetida() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade una calificación intermedia (5) y dos altas (10)
    // Respuesta esperada: La moda debe ser la calificacion 10
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    notas.addCalificacion(5);
    notas.addCalificacion(10);
    notas.addCalificacion(10);
    try {
      assertEquals(10, notas.calificacionModa());
    } catch (EstadisticasNotasException2 e) {
      fail("Error. Se ha obtenido excepción cuando no se esperaba");
    }
  }

  @Test
  void testModaVariada() {
    // Caso: Crea un objeto EstadisticasNotas
    //       , añade varias calificaciones (0, 2, 4, 6, 8, 10). Algunas se añaden
    //       dos veces (0, 8) y 4 se añade tres veces
    // Respuesta esperada: La moda debe ser 4
    EstadisticasNotas2 notas = new EstadisticasNotas2();
    notas.addCalificacion(0);
    notas.addCalificacion(0);
    notas.addCalificacion(2);
    notas.addCalificacion(4);
    notas.addCalificacion(4);
    notas.addCalificacion(4);
    notas.addCalificacion(6);
    notas.addCalificacion(8);
    notas.addCalificacion(8);
    notas.addCalificacion(10);
    try {
      assertEquals(4, notas.calificacionModa());
    } catch (EstadisticasNotasException2 e) {
      fail("Error. Se ha obtenido excepción cuando no se esperaba");
    }
  }

}
