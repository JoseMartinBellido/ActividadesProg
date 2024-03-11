package prog.unidad05.gestionficheros.ejercicio01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InformacionFicherosApp {

  public static void main(String[] args) {

    // Scanner para la lectura de datos
    Scanner sc = new Scanner(System.in);
    
    // Se solicita la ruta
    System.out.print("Introduzca la ruta a un archivo (en blanco para acabar): ");
    String ruta = sc.nextLine();
    
    while (!ruta.isEmpty()) {
      Path path = Path.of(ruta);
      
      // Se verifica si existe y, en tal caso, si es fichero o carpeta
      if (Files.exists(path)) {
        String resultado = (Files.isDirectory(path)) ? "una carpeta" : "un fichero regular";
        System.out.printf("El fichero \"%s\" existe y es %s%n", ruta, resultado);
            
      } else {
        System.out.printf("El fichero \"%s\" no existe.%n", ruta);
      }
      
      // Se solicita la ruta
      System.out.print("Introduzca la ruta a un archivo (en blanco para acabar): ");
      ruta = sc.nextLine();
    } 
    
    
  }

}
