package prog.unidad06.listas.ejercicio05;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PruebaMezclaListasCadenas {

  @Test
  void testUnionPrimeraNull() {
    // Caso: Unión siendo la primera lista null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = null;
    List<String> lista2 = new ArrayList<>();
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.union(lista1, lista2));
  }

  @Test
  void testUnionSegundaNull() {
    // Caso: Unión siendo la segunda lista null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = null;
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.union(lista1, lista2));
  }

  @Test
  void testUnionAmbasNull() {
    // Caso: Unión siendo ambas listas null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = null;
    List<String> lista2 = null;
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.union(lista1, lista2));
  }

  @Test
  void testUnionDosVacias() {
    // Caso: Unión siendo ambas listas vacías
    // RE  : Se obtiene la lista vacía
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = new ArrayList<>();
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionUnaVaciaOtraSinRepetidos() {
    // Caso: Unión siendo una lista vacía y la otra no y sin repetidos
    // RE  : Se obtiene la lista no vacía
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionUnaVaciaOtraConRepetidos() {
    // Caso: Unión siendo una lista vacía y la otra no y con repetidos
    // RE  : Se obtiene la lista no vacía pero sin los valores repetidos
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    lista2.add("Dos");
    lista2.add("Uno");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionUnaSinRepetidosOtraVacia() {
    // Caso: Unión siendo una lista con valores no repetidos y otra vacía
    // RE  : Se obtiene la lista no vacía
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionUnaConRepetidosOtraVacia() {
    // Caso: Unión siendo una lista con valores repetidos y otra vacía
    // RE  : Se obtiene la lista no vacía pero sin los valores repetidos
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionDosSinRepetidosSinComunes() {
    // Caso: Unión siendo ambas listas no vacías con valores no repetidos
    //       Sin elementos comunes a ambas listas
    // RE  : Se obtiene la lista con todos los valores de ambas listas
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Dos");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionDosPrimeraRepetidosSinComunes() {
    // Caso: Unión siendo ambas listas no vacías
    //       La primera tiene valores repetidos, la segunda no
    //       No hay valores comunes entre ambas listas
    // RE  : Se obtiene la lista con todos los valores de ambas listas,
    //       excepto el repetido que aparece una sola vez
    //       y en la posición que aparece en la primera lista
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    resultadoEsperado.add("Tres");
    resultadoEsperado.add("Cuatro");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionDosSegundaRepetidosSinComunes() {
    // Caso: Unión siendo ambas listas no vacías
    //       La primera tiene no valores repetidos, la segunda si
    // RE  : Se obtiene la lista con todos los valores de ambas listas,
    //       excepto el repetido que aparece una sola vez
    //       y en la misma posición que en la primera lista
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    resultadoEsperado.add("Tres");
    resultadoEsperado.add("Cuatro");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionDosAmbosRepetidosSinComunes() {
    // Caso: Unión siendo ambas listas no vacías
    //       Ambas tienen valores repetidos
    //       No hay valores comunes entre ambas listas
    // RE  : Se obtiene la lista con todos los valores de ambas listas,
    //       excepto el repetido que aparece una sola vez
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    resultadoEsperado.add("Tres");
    resultadoEsperado.add("Cuatro");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionDosSinRepetidosConComunes() {
    // Caso: Unión siendo ambas listas no vacías con valores no repetidos
    //       Con elementos comunes a ambas listas
    // RE  : Se obtiene la lista con todos los valores de ambas listas.
    //       Los comunes sólo deben aparecer una vez y en la posición
    //       ocupada en la primera lista
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Tres");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Dos");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Tres");
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionDosPrimeraRepetidosConComunes() {
    // Caso: Unión siendo ambas listas no vacías
    //       La primera tiene valores repetidos, la segunda no
    //       Hay valores comunes entre las dos listas
    // RE  : Se obtiene la lista con todos los valores de ambas listas,
    //       excepto el repetido y el común que aparece una sola vez
    //       y en la posición que aparece en la primera lista
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    lista1.add("Cuatro");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    resultadoEsperado.add("Cuatro");
    resultadoEsperado.add("Tres");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionDosSegundaRepetidosConComunes() {
    // Caso: Unión siendo ambas listas no vacías
    //       La primera tiene no valores repetidos, la segunda si
    //       Hay valores comunes entre las dos listas
    // RE  : Se obtiene la lista con todos los valores de ambas listas,
    //       excepto el repetido y el común que aparece una sola vez
    //       y en la misma posición que en la primera lista
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Cinco");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Cinco");
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    resultadoEsperado.add("Cinco");
    resultadoEsperado.add("Tres");
    resultadoEsperado.add("Cuatro");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testUnionDosAmbosRepetidosConComunes() {
    // Caso: Unión siendo ambas listas no vacías
    //       Ambas tienen valores repetidos
    //       Hay valores comunes entre las dos listas
    // RE  : Se obtiene la lista con todos los valores de ambas listas,
    //       excepto el repetido y el común que aparecen una sola vez
    //       Y en el mismo orden en que aparece en el primero
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    lista1.add("Cinco");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    lista2.add("Cinco");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    resultadoEsperado.add("Cinco");
    resultadoEsperado.add("Tres");
    resultadoEsperado.add("Cuatro");
    List<String> resultado = MezclaListasCadenas.union(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionPrimeraNull() {
    // Caso: Intersección siendo la primera lista null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = null;
    List<String> lista2 = new ArrayList<>();
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.interseccion(lista1, lista2));
  }

  @Test
  void testInterseccionSegundaNull() {
    // Caso: Intersección siendo la segunda lista null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = null;
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.interseccion(lista1, lista2));
  }

  @Test
  void testInterseccionAmbasNull() {
    // Caso: Intersección siendo ambas listas null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = null;
    List<String> lista2 = null;
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.interseccion(lista1, lista2));
  }

  @Test
  void testInterseccionDosVacias() {
    // Caso: Intersección siendo ambas listas vacías
    // RE  : Se obtiene la lista vacía
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = new ArrayList<>();
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionPrimeraVacia() {
    // Caso: Intersección siendo una lista vacía y la otra no
    // RE  : Se obtiene una lista vacía
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionSegundaVacia() {
    // Caso: Intersección siendo una lista con valores y otra vacía
    // RE  : Se obtiene la lista vacía
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosSinRepetidosSinComunes() {
    // Caso: Intersección siendo ambas listas no vacías con valores no
    //       repetidos y no habiendo ningún elemento en común entre ambas listas
    // RE  : Se obtiene la lista vacía
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Dos");
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosPrimeraRepetidosSinComunes() {
    // Caso: Intersección siendo ambas listas no vacías
    //       La primera tiene valores repetidos, la segunda no
    //       No hay valores comunes entre las dos listas
    // RE  : Se obtiene la lista vacia
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosSegundaRepetidosSinComunes() {
    // Caso: Intersección siendo ambas listas no vacías
    //       La primera no tiene valores repetidos, la segunda si
    //       No hay valores comunes entre ambas listas
    // RE  : Se obtiene la lista vacia
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosAmbosRepetidosSinComunes() {
    // Caso: Intersección siendo ambas listas no vacías
    //       Ambas tienen valores repetidos
    //       No hay valores en común entre ambas listas
    // RE  : Se obtiene la lista vacía
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosSinRepetidosConComunes() {
    // Caso: Intersección siendo ambas listas no vacías con valores no
    //       repetidos y habiendo un elemento en común entre ambas listas
    // RE  : Se obtiene la lista con el elemento común
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosPrimeraRepetidosConComunes() {
    // Caso: Intersección siendo ambas listas no vacías
    //       La primera tiene valores repetidos, la segunda no
    //       Hay un valor común entre las dos listas
    // RE  : Se obtiene la lista con el elemento común
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    lista2.add("Tres");
    lista2.add("Cuatro");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosSegundaRepetidosConComunes() {
    // Caso: Intersección siendo ambas listas no vacías
    //       La primera no tiene valores repetidos, la segunda si
    //       Hay un valor común entre ambas listas
    // RE  : Se obtiene la lista con el elemento común
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Dos");
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosAmbosRepetidosConComunes() {
    // Caso: Intersección siendo ambas listas no vacías
    //       Ambas tienen valores repetidos
    //       Hay un valor en común entre ambas listas
    // RE  : Se obtiene la lista con el valor común
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testInterseccionDosInversos() {
    // Caso: Intersección conteniendo ambas listas los mismos elementos
    //       pero en orden inverso
    // RE  : Se obtiene la lista idéntida a la primera
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Tres");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Dos");
    lista2.add("Uno");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    resultadoEsperado.add("Tres");
    List<String> resultado = MezclaListasCadenas.interseccion(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaPrimeraNull() {
    // Caso: Diferencia siendo la primera lista null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = null;
    List<String> lista2 = new ArrayList<>();
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.diferencia(lista1, lista2));
  }

  @Test
  void testDiferenciaSegundaNull() {
    // Caso: Diferencia siendo la segunda lista null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = null;
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.diferencia(lista1, lista2));
  }

  @Test
  void testDiferenciaAmbasNull() {
    // Caso: Diferencia siendo ambas listas null
    // RE  : Se lanza IllegalArgumentException
    List<String> lista1 = null;
    List<String> lista2 = null;
    assertThrows(IllegalArgumentException.class, () -> MezclaListasCadenas.diferencia(lista1, lista2));
  }

  @Test
  void testDiferenciaDosVacias() {
    // Caso: Diferencia siendo ambas listas vacías
    // RE  : Se obtiene la lista vacía
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = new ArrayList<>();
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaPrimeraVacia() {
    // Caso: Diferencia siendo la primera lista vacía y la otra no
    // RE  : Se obtiene una lista vacía
    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaSegundaVacia() {
    // Caso: Diferencia siendo la primera lista con valores y otra vacía
    // RE  : Se obtiene la primera lista
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosSinRepetidosSinComunes() {
    // Caso: Diferencia siendo ambas listas no vacías con valores no
    //       repetidos y no habiendo ningún elemento en común entre ambas
    //       listas
    // RE  : Se obtiene la primera lista
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Dos");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosPrimeraRepetidosSinComunes() {
    // Caso: Diferencia siendo ambas listas no vacías
    //       La primera tiene valores repetidos, la segunda no
    //       No hay valores comunes entre las dos listas
    // RE  : Se obtiene la primera lista pero sin valores repetidos
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosSegundaRepetidosSinComunes() {
    // Caso: Diferencia siendo ambas listas no vacías
    //       La primera no tiene valores repetidos, la segunda si
    //       No hay valores comunes entre ambas listas
    // RE  : Se obtiene la primera lista
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosAmbosRepetidosSinComunes() {
    // Caso: Diferencia siendo ambas listas no vacías
    //       Ambas tienen valores repetidos
    //       No hay valores en común entre ambas listas
    // RE  : Se obtiene la primera lista sin repetidos
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosSinRepetidosConComunes() {
    // Caso: Diferencia siendo ambas listas no vacías con valores no
    //       repetidos y habiendo un elemento en común entre ambas listas
    // RE  : Se obtiene la primera lista sin el elemento común
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosPrimeraRepetidosConComunes() {
    // Caso: Diferencia siendo ambas listas no vacías
    //       La primera tiene valores repetidos, la segunda no
    //       Hay un valor común entre las dos listas
    // RE  : Se obtiene la lista con el elemento no común y sin repeticiones
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    lista2.add("Tres");
    lista2.add("Cuatro");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosSegundaRepetidosConComunes() {
    // Caso: Diferencia siendo ambas listas no vacías
    //       La primera no tiene valores repetidos, la segunda si
    //       Hay un valor común entre ambas listas
    // RE  : Se obtiene la lista igual que la primera pero sin el elemento
    //       común
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Dos");
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Uno");
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosAmbosRepetidosConComunes() {
    // Caso: Diferencia siendo ambas listas no vacías
    //       Ambas tienen valores repetidos
    //       Hay un valor en común entre ambas listas
    // RE  : Se obtiene la primera lista sin el valor común y sin repetidos
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Uno");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Uno");
    lista2.add("Tres");
    lista2.add("Cuatro");
    lista2.add("Tres");
    List<String> resultadoEsperado = new ArrayList<>();
    resultadoEsperado.add("Dos");
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

  @Test
  void testDiferenciaDosInversos() {
    // Caso: Intersección conteniendo ambas listas los mismos elementos
    //       pero en orden inverso
    // RE  : Se obtiene la lista vacía
    List<String> lista1 = new ArrayList<>();
    lista1.add("Uno");
    lista1.add("Dos");
    lista1.add("Tres");
    List<String> lista2 = new ArrayList<>();
    lista2.add("Tres");
    lista2.add("Dos");
    lista2.add("Uno");
    List<String> resultadoEsperado = new ArrayList<>();
    List<String> resultado = MezclaListasCadenas.diferencia(lista1, lista2);
    assertIterableEquals(resultadoEsperado, resultado);
  }

}
