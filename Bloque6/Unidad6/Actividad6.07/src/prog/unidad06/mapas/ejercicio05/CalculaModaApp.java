package prog.unidad06.mapas.ejercicio05;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class CalculaModaApp {
  
  Scanner sc;

  public CalculaModaApp(Scanner sc){
    this.sc = sc;
  }
  
  public static void main(String[] args) {

    System.out.println("CÁLCULO DE MODA");
    
    CalculaModaApp miApp = new CalculaModaApp(new Scanner(System.in));
    miApp.run();    
  }

  public void run() {
    
    int[] arrayAleatorios = null;
  
    // Solicitamos los datos hasta introducirlos correctamente
    do {
      try {
        arrayAleatorios = generaArrayEnteroAleatorio();
      } catch (NumberFormatException e) {
        System.out.println("Alguno de los datos introducidos no tiene un formato correcto. Inténtelo de nuevo.");
      } catch (IllegalArgumentException e) {
        System.out.println("Las condiciones de los datos no cumplen los requisitos básicos.");
      }
      
    } while (arrayAleatorios == null);
  
    // Impresión del array generado
    System.out.print("La serie generada es: ");
    imprimeArray(arrayAleatorios);
    
    // Una vez creado, se crea un mapa calificación - repetición ordenado naturalmente
    Map<Integer, Integer> mapaCalificaciones = new HashMap<>();
    
    // Recorremos el array aleatorio y comprobamos repeticiones
    for (int i = 0; i < arrayAleatorios.length; i++) {
      mapaCalificaciones.put(arrayAleatorios[i]
          , (mapaCalificaciones.get(arrayAleatorios[i]) == null) ? 1 : mapaCalificaciones.get(arrayAleatorios[i]) + 1);
    }
    
    // Declaramos moda y repeticiones
    Integer moda = null;
    int repeticiones = 0;
    // Recorremos el mapa buscando la moda
    for (Integer numero : mapaCalificaciones.keySet()) {
      if (mapaCalificaciones.get(numero) > repeticiones) {
        moda = numero;
        repeticiones = mapaCalificaciones.get(numero);
      }
    }
    
    // Imprimimos resultado
    System.out.println("La moda de la serie es " + moda + " y aparece " + repeticiones + " veces en la serie");
  }

  /**
   * Método que genera un array de números enteros aleatorios con una longitud y un rango de valores estipulado
   * mediante consola por el usuario
   * @return El array de números enteros aleatorios
   */
  public int[] generaArrayEnteroAleatorio() {

    System.out.print("Introduzca la cantidad de números de la serie (mayor que cero): ");
    int longitud = Integer.parseInt(sc.nextLine());

    System.out.print("Valor mínimo del intervalo para generar los valores aleatorios: ");
    int valorMinimo = Integer.parseInt(sc.nextLine());

    System.out.print("Valor máximo del intervalo para generar los valores aleatorios (mayor o igual al mínimo): ");
    int valorMaximo = Integer.parseInt(sc.nextLine());

    if (valorMaximo < valorMinimo || longitud <= 0) {
      throw new IllegalArgumentException();
    }

    // Creamos el array de la longitud determinada
    int[] numerosEnteros = new int[longitud];

    // Generador de números aleatorios
    Random generador = new Random();

    // Rellenamos el array con números entre valorMinimo y valorMaximo
    for (int i = 0; i < numerosEnteros.length; i++) {

      numerosEnteros[i] = generador.nextInt(valorMinimo, valorMaximo + 1);
    }

    return numerosEnteros;
  }
  
  /**
   * Método que imprime por pantalla el array con formato [valor1, valor2, ... ]
   * @param array Array a imprimir
   */
  public void imprimeArray(int[] array) {
    System.out.print("[");
    
    for (int i = 0; i < array.length; i++) {
      // Impresión del número
      System.out.print(array[i]);
      // Impresión de coma cuando corresponde
      if (i < array.length - 1) {
        System.out.print(",");
      }
    }
    System.out.println("]");
  }
  
}
