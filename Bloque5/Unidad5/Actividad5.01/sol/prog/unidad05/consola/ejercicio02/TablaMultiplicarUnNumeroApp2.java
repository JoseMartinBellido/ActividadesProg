package prog.unidad05.consola.ejercicio02;

import java.util.Scanner;
import prog.unidad05.consola.ejercicio01.TablaMultiplicar;

/**
 * Programa que muestra por pantalla la tabla
 * de multiplicar de un número que se solicita por
 * teclado
 */
public class TablaMultiplicarUnNumeroApp2 {

  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Solicitamos el número
    System.out.print("Introduzca un número entero superior a cero para calcular su tabla de multiplicar: ");
    int numero = Integer.parseInt(sc.nextLine());

    // Creamos el objeto tabla de multiplicar (puede dar una excepción si el número no es correcto)
    try {
      // Crea un objeto tabla de multiplicar
      TablaMultiplicar tabla = new TablaMultiplicar(numero);
      // Imprime la cabecera de la tabla (esto no lo hace el objeto)
      System.out.println("TABLA DE MULTIPLICAR DEL " + numero);
      // Usamos el objeto para imprimir el cuerpo de la tabla
      tabla.imprimeTabla();
    } catch (IllegalArgumentException e) {
      // Si el número no es válido mostramos error
      System.out.println("El número introducido no es válido");
    }
    
    // Cierra el scanner
    sc.close();
    
  }

}
