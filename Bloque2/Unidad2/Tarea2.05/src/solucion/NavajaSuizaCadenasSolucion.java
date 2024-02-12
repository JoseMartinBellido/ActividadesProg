package solucion;
import java.util.Scanner;

public class NavajaSuizaCadenasSolucion {

  public static void main(String[] args) {
    // Scanner para la lectura desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Solicitamos las dos cadenas desde teclado
    System.out.print("Introduzca una cadena de texto cualquiera: ");
    String cadena1 = sc.nextLine();
    System.out.print("Introduzca ahora otra cadena de texto: ");
    String cadena2 = sc.nextLine();
    
    // Mostramos la longitud y si está vacía o si solo tiene blancos
    // Primera cadena
    System.out.println("La primera cadena tiene una longitud de " + cadena1.length() + " caracteres");
    System.out.println("La primera cadena está vacía? " + cadena1.isEmpty());
    System.out.println("La primera cadena contiene sólo blancos? " + cadena1.isBlank());
    // Segunda cadena
    System.out.println("La segunda cadena tiene una longitud de " + cadena2.length() + " caracteres");
    System.out.println("La segunda cadena está vacía? " + cadena2.isEmpty());
    System.out.println("La segunda cadena contiene sólo blancos? " + cadena2.isBlank());
    
    // Muestra la concatenación de ambas cadenas
    System.out.println("La concatenación de ambas cadenas es: \"" + cadena1 + cadena2 + "\"");

    // Compara las cadenas
    System.out.println("Son las dos cadenas iguales (incluso mayúsculas y minúsculas)? " + cadena1.equals(cadena2));
    System.out.println("Son las dos cadenas iguales (ignorando mayúsculas y minúsculas)? " + cadena1.equalsIgnoreCase(cadena2));

    // Compara alfabeticamente las cadenas
    System.out.println("Al comparar las dos cadenas alfabéticamente (con mayúsculas y minúsculas), el valor es: " + cadena1.compareTo(cadena2));
    System.out.println("Al comparar las dos cadenas alfabéticamente (ignorando mayúsculas y minúsculas), el valor es: " + cadena1.compareToIgnoreCase(cadena2));

    // La primera cadena contiene la segunda?
    System.out.println("Contiene la primera cadena a la segunda? " + cadena1.contains(cadena2));

    // Comienza la primera cadena por la segunda?
    System.out.println("Comienza la primera cadena por la segunda? " + cadena1.startsWith(cadena2));

    // Termina la primera cadena por la segunda?
    System.out.println("Termina la primera cadena por la segunda? " + cadena1.endsWith(cadena2));

    // Imprime el primer y ultimo caracter de la cadena
    System.out.println("El primer carácter de la primera cadena es: " + cadena1.charAt(0));
    System.out.println("El ultimo carácter de la primera cadena es: " + cadena1.charAt(cadena1.length() - 1));

    // Muestra por pantalla la primera cadena eliminando el primer carácter
    System.out.println("Eliminando el primer carácter, la primera cadena queda: " + cadena1.substring(1));

    // Muestra por pantalla la primera cadena todo en mayúsculas y todo en minúsculas
    System.out.println("La primera cadena toda en mayúsculas queda: " + cadena1.toUpperCase());
    System.out.println("La primera cadena toda en minúsculas queda: " + cadena1.toLowerCase());
    
    sc.close();
  }

}
