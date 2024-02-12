package cadenas;

import java.util.Scanner;

public class NavajaSuizaCadenasApp {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    // Solicitamos los datos para trabajar con las cadenas de caracteres con la clase Scanner
    
    System.out.print("Introduce la primera cadena de caracteres: ");
    String cadena1 = sc.nextLine();
    
    System.out.print("Introduce la segunda cadena de caracteres: ");
    String cadena2 = sc.nextLine();
    
    // Imprimimos por pantalla su longitud, si está vacía y si tiene caracteres blancos o no.
    
    System.out.println("La primera cadena tiene " + cadena1.length() + " caracteres. ¿Está vacia? " + cadena1.isEmpty() 
      + ". ¿Sólo tiene caracteres blancos? " + cadena1.isBlank());
    
    System.out.println("La segunda cadena tiene " + cadena2.length() + " caracteres. ¿Está vacia? " + cadena2.isEmpty() 
    + ". ¿Sólo tiene caracteres blancos? " + cadena2.isBlank());
    
    // Imprimimos por pantalla la concatenacion de ambas cadenas
    
    System.out.println("La concatenación de ambas cadenas es: " + cadena1 + cadena2);
    
    // Comprobamos si son iguales teniendo en cuenta mayúsculas y sin tenerlo en cuenta.
    
    System.out.println("¿Son iguales teniendo en cuenta las mayúsculas como diferenciador? " + cadena1.equals(cadena2));
    
    System.out.println("¿Son iguales sin tener en cuenta las mayúsculas como diferenciador? " + cadena1.equalsIgnoreCase(cadena2));
    
    // Mostramos el valor de comparación con o sin sensiblidad a mayúsculas
    
    System.out.println("El valor de compararlos con sensibilidad a mayúsculas/minúsculas es de: " + cadena1.compareTo(cadena2));
    
    System.out.println("El valor de compararlos sin sensibilidad a mayúsculas/minúsculas es de: " + cadena1.compareToIgnoreCase(cadena2));
    
    // Comprobamos si la primera cadena contiene a la segunda
    
    System.out.println("¿La primera cadena contiene a la segunda? " + cadena1.contains(cadena2));
    
    // Mostramos si la primera cadena empieza con la segunda
    
    System.out.println("¿La primera cadena empieza por la segunda? " + cadena1.startsWith(cadena2));
    
    // Comprobamos si la primera cadena termina con la segunda
    
    System.out.println("¿La primera cadena termina con la segunda? " + cadena1.endsWith(cadena2));
    
    // Imprimimos el primer y último carácter de la primera cadena
    
    System.out.println("El primer carácter de la cadena es \'" + cadena1.charAt(0) + "\' y el último es \'" 
        + cadena1.charAt(cadena1.length()-1) + "\'");
    
    // Imprimimos la primera cadena sin el primer carácter
    
    System.out.println("La primera cadena sin el primer carácter es: " + cadena1.substring(1));
    
    // Imprimimos la primera cadena con todas las letras en minúsculas y mayúsculas
    
    System.out.println("La primera cadena con todas las letras en minúscula: " + cadena1.toLowerCase());

    System.out.println("La primera cadena con todas las letras en mayúscula: " + cadena1.toUpperCase());
    
    sc.close();
    
  }

}
