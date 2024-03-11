package prog.unidad05.ficheros.ejercicio05;

import java.util.Scanner;
import java.util.Set;

/**
 * Clase que gestiona la lectura e inserción de nuevos discos de música
 */
public class CreceDiscosApp {

  /**
   * Scanner para la lectura de información por parte del usuario
   */
  private Scanner sc;
  
  public CreceDiscosApp() {
    sc = new Scanner(System.in);
  }
  
  public static void main(String[] args) {
    
    CreceDiscosApp app = new CreceDiscosApp();
    app.run();
    
  }
  
  private void run() {
    // Gestionador de información de un fichero
    GestionaDiscosFichero gestionador = new GestionaDiscosFichero("discos.dat");
    
    // Conjunto de discos del fichero
    Set<Disco> discos = gestionador.leeDiscos();
    
    Disco nuevoDisco = null;
    
    try {
      // Se solicita un nuevo disco y se introduce en el conjunto
      nuevoDisco = solicitaDisco();
      discos.add(nuevoDisco);
      
      // Se reescribe el fichero
      gestionador.guardaDiscos(discos);
      
    } catch (IllegalArgumentException e) {
      System.out.println("El nuevo disco introducido tiene algún parámetro incorrecto. No se insertará"
          + " ningún disco nuevo en el fichero.");
    }
    
  }

  /**
   * Método que solicita la información necesaria para crear un disco de música
   * @return El disco ya generado
   * @throws IllegalArgumentException En caso de que los parámetros para crear el disco sean incorrectos
   */
  private Disco solicitaDisco() {
    
    // Se solicitan los datos uno a uno para crear un disco
    System.out.println("Introduce los datos del nuevo disco");
    
    System.out.print("Introduce el título del disco (no puede dejarse en blanco): ");
    String titulo = sc.nextLine();
    
    System.out.print("Introduce el nombre del autor del disco (no puede dejarse en blanco): ");
    String autor = sc.nextLine();
    
    System.out.print("Introduce el año de publicación del disco (entero positivo): ");
    int anyoPublicacion = Integer.parseInt(sc.nextLine());
    
    System.out.print("Introduce el precio del disco (real positivo): ");
    double precio = Double.parseDouble(sc.nextLine());
    
    System.out.print("¿Es el disco un CD? (s/n): ");
    boolean estaPublicadoCD = switch (sc.nextLine()) {
      case "s" -> true;
      case "n" -> false;
      default -> throw new IllegalArgumentException();
    };
    
    return new Disco(titulo, autor, anyoPublicacion, precio, estaPublicadoCD);
    
  
  
  
  
  
  
  }
  
  
}
