package prog.unidad04.actividad404.ejercicio02.pruebas;

import java.util.Scanner;

import prog.unidad04.actividad404.ejercicio02.CalculadorMedia;

public class CalculaMediaApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("PROGRAMA QUE CALCULA LA MEDIA DE LOS NÚMEROS INTRODUCIDOS");
    
    int cantidadNumeros = 0;
 
    // Mientras el número sea menor o igual a 0 solicitamos el número
    while (cantidadNumeros <= 0) {
      // Estructura try/catch por si se introduce un dato que no sea tipo int
      try {
        System.out.print("Introduce la cantidad de números que vas a introducir (uno o más): ");
        cantidadNumeros = Integer.parseInt(sc.nextLine());
        
        // Aviso al usuario en caso de que el número introducido no cumpla los parámetros
        if (cantidadNumeros <= 0) {
          System.out.println("El número debe ser mayor que cero. Inténtalo de nuevo.");
        }

        // Impresión de error en caso de que el dato introducido no sea del tipo válido
      } catch (NumberFormatException e) {
        System.out.println("Lo que se ha introducido no es un número entero válido. Inténtelo de nuevo.");
      }
    }
      
    // Solicitamos los números hasta tener los deseados. El primero se realiza en el exterior para llamar al constructor.
    
    int contador = 0;
    double numeroIntroducido = 0;
    
    while (contador == 0) {
      try {
        
        System.out.print("Introduce el número (" + (contador + 1) + "): ");
        numeroIntroducido = Double.parseDouble(sc.nextLine());
        
        // En este punto, si no se ha lanzado el error, tenemos nuestro valor inicial
        contador++;

      } catch (NumberFormatException e) {
        System.out.println("Lo que se ha introducido no es un número entero. Inténtalo de nuevo.");
      }
    }

    // Constructor de la clase CalculadorMedia
    CalculadorMedia calculadorMedia = new CalculadorMedia(numeroIntroducido);

    // Pedimos los datos restantes
    while (contador < cantidadNumeros) {
      
      // Si el número introducido no cumple el formato, avisamos al usuario y se vuelve a requerir
      try {
        
        System.out.print("Introduce el número (" + (contador + 1) + "): ");
        numeroIntroducido = Double.parseDouble(sc.nextLine());
        
        // En este punto, si no se ha lanzado el error, podemos continuar
        calculadorMedia.add(numeroIntroducido);
        contador++;
        
      } catch (NumberFormatException e) {
        System.out.println("Lo que se ha introducido no es un número entero. Inténtalo de nuevo.");
      }

    }

    //Calculamos la media y la imprimimos por pantalla
    System.out.println("La media de los números introducidos es: " + calculadorMedia.getMedia());
    
    sc.close();
  }

}
