import java.util.Scanner;

public class CalculoVertical {
  
  public static final double ACELERACION_GRAVEDAD = 9.8;
  
  public static final double PIES_POR_METRO = 3.28; 

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("EXAMEN DE JOSE MARTIN BELLIDO. CALCULO DE LANZAMIENTO VERTICAL");
    
    System.out.print("Introduzca la velocidad inicial del objeto (en m/s): ");
    
    double velocidadInicial = Double.parseDouble(sc.nextLine());
    
    /* Para calcular el tiempo que se tarda en llegar a la altura maxima,
     * usamos la formula t = V0 / g
     */
    
    double tiempoAlturaMaxima = velocidadInicial / ACELERACION_GRAVEDAD;
    
    /* Para calcular la altura maxima que alcanza el objeto usamos la formula, 
     * usamos la formula h= V0 * t  - (g * t * t) / 2
     */

    double alturaMaxima = velocidadInicial * tiempoAlturaMaxima 
        - (ACELERACION_GRAVEDAD * tiempoAlturaMaxima * tiempoAlturaMaxima) / 2;
    
    System.out.println("La altura máxima en metros es de " + alturaMaxima);
    
    // Hacemos la conversion a pies con un casting a entero.
    
    int piesAlturaMaxima = (int) (alturaMaxima * PIES_POR_METRO);
    
    System.out.println("Esta altura equivale a " + piesAlturaMaxima + " pies.");
    
    System.out.println("El tiempo necesario es " + tiempoAlturaMaxima + " segundos.");
    
    sc.close();
    
    
    
    
  }

}
