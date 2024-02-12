package prog.unidad06.arraysuni.ejercicio01;

import java.util.Scanner;

/**
 * Aplicacion que realiza diversas operaciones con un array de 8 elementos
 */
public class Array8App2 {

  private static final int LONGITUD_NUMEROS = 8;

  public static void main(String[] args) {
    
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("OPERACIONES VARIAS SOBRE UN ARRAY DE 8 ELEMENTOS");
    
    // Lee los datos desde teclado al array
    System.out.println("A continuación se van a solicitar " + LONGITUD_NUMEROS + " números reales");
    // Creamos el array
    double[] numeros = new double[LONGITUD_NUMEROS]; 
    // Y vamos leyendo los números
    for (int i = 0; i < numeros.length; i++) {
      System.out.print("Introduce el número " + (i + 1) + ": ");
      numeros[i] = Double.parseDouble(sc.nextLine());
    }
    
    // Ahora procesamos el array. Inicializamos primero los contadores necesarios
    // Suma total
    double sumaTotal = 0;
    // Suma de los mayores de 36
    double sumaMayores36 = 0;
    // Cantidad de valores superiores a 50
    int cantidadMayores50 = 0;
    // Suma de los valores entre 10 y 30
    double sumaEntre10Y30 = 0;
    // Contador de los valores entre 10 y 30
    int cantidadEntre10Y30 = 0;
    // Ahora recorremos el array y vamos procesando cada elemento
    for (double numero: numeros) {
      // Se añade a la suma total SIEMPRE
      sumaTotal += numero;
      // Si es mayor de 36 se añade a dicha suma
      if (numero > 36) {
        sumaMayores36 += numero;
      }
      // Si es mayor de 50
      if (numero > 50) {
        // Se cuenta
        cantidadMayores50++;
      }
      // Si está entre 10 y 30
      if ((numero >= 10) && (numero <= 30)) {
        // Se suma y se cuenta
        sumaEntre10Y30 += numero;
        cantidadEntre10Y30++;
      }
    }
    
    // Ahora se muestran los resultados
    System.out.println("La suma de todos los elementos vale " + sumaTotal);
    System.out.println("La suma de los elementos mayores de 36 vale " + sumaMayores36);
    System.out.println("La cantidad de elementos mayores a 50 es de " + cantidadMayores50);
    // Si había algún elemento entre 10 y 30
    if (cantidadEntre10Y30 > 0) {
      // Muestra la media
      System.out.println("La media de los " + cantidadEntre10Y30 + " elementos comprendidos entre 10 y 30 vale " + (sumaEntre10Y30 / cantidadEntre10Y30));
    } else {
      System.out.println("No hay elementos entre 10 y 30, por lo que no se puede calcular la media");
    }
    
    System.out.println("Fin del programa");
  }
    

}
