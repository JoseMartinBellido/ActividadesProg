package unidad06.mapas.ejercicio05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import unidad06.arraysuni.ejercicio02.UtilidadesArrays;

/**
 * Obtiene una serie aleatoria de números enteros y calcula su moda
 */
public class CalculaModaApp {

  public static void main(String[] args) {
    // Solicita los parámetros al usuario
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("CALCULO DE MODA");
    
    // Solicita la cantidad de números
    System.out.print("Introduzca la cantidad de números de la serie: ");
    int cantidadNumeros = Integer.parseInt(sc.nextLine());
    System.out.print("Valor mínimo del intervalo para generar los valores aleatorios: ");
    int valorMinimo = Integer.parseInt(sc.nextLine());
    System.out.print("Valor máximo del intervalo para generar los valores aleatorios: ");
    int valorMaximo = Integer.parseInt(sc.nextLine());
    // Obtiene un array con los números aleatorios
    int[] serie = UtilidadesArrays.generaArrayEnteroAleatorio(cantidadNumeros, valorMinimo, valorMaximo);
    
    // Imprimimos la serie
    System.out.println("La serie generada es: " + aCadena(serie));
    
    // Creamos un mapa para almacenar la frecuencia con que aparece cada número de la serie
    // Las claves serán los números de la serie y los valores la frecuencia con la 
    // que aparece cada número
    Map<Integer, Integer> frecuencias = new HashMap<>();
    // Para cada elemento de la serie
    for (int valor: serie) {
      // Obtiene la frecuencia del valor (o 0 si aún no aparece en el mapa
      int frecuencia = frecuencias.getOrDefault(valor, 0);
      // Aumenta la frecuencia en uno
      frecuencia++;
      // Y la (vuelve?) a almacenar
      frecuencias.put(valor, frecuencia);
    }
    
    // En este punto tenemos en el mapa los valores de la serie, sin repeticiones,
    // y en cada valor correspondiente las veces que aparece ese valor en la serie
    
    // Para calcular la moda hay que buscar la frecuencia mayor. La clave de dicho
    // valor será la moda
    // Como hay que recorrerlos todos y en caso de empate de frecuencias da igual
    // el valor que se tome tomaremos el primero ya que es más sencillo
    
    // Usamos una bandera para saber si hemos inicializado o no la frecuencia máxima y su valor correspondiente
    int moda = 0;
    int frecuenciaModa = 0;
    boolean modaIniciada = false;
    // Para cada elemento del mapa de frecuencias
    for (int valor: frecuencias.keySet()) {
      // Obtenemos la frecuencia correspondiente
      int frecuencia = frecuencias.get(valor);
      // Si no se ha inicializado o la frecuencia es mayor que la actual
      if (!modaIniciada || frecuencia > frecuenciaModa) {
        // Actualizamos moda y frecuencia
        moda = valor;
        frecuenciaModa = frecuencia;
        // Y activamos la bandera
        modaIniciada = true;
      }
    }
    // Mostramos el resultado
    System.out.println("La moda de la serie es " + moda + " y aparece " + frecuenciaModa + " veces en la serie");
  }

  /**
   * Crea una representación en cadena del array de números aleatorios
   * @param serie Serie con valores enteros
   * @return Cadena con los valores de la serie, separados por comas y delimitados por []
   */
  private static String aCadena(int[] serie) {
    String resultado = "[";
    
    // Para cada elemento
    for (int elemento: serie) {
      // Si no es el primero
      if (resultado.length() > 1) {
        // Incluimos una coma
        resultado += ", ";
      }
      // Añadimos el valor
      resultado += elemento;
    }
    // Por último terminamos con ]
    resultado += "]";
    return resultado;
  }

}
