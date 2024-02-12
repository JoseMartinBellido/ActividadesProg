import java.util.Scanner;

public class Tarea09e23 {
  
  public static final int resistencia = 4;

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double voltaje;
    double intensidad;
    double potencia;
    
    System.out.print("Introduce el voltaje en voltios de la batería conectada al circuito eléctrico: ");
    
    voltaje = Double.parseDouble(sc.nextLine());
    
    // He considerado preguntar el voltaje para obtener la intensidad mediante la fórmula I = V / R, ya que dependiendo de la conexión que
    // se haga y con una resistencia fija, conseguimos la resistencia.
    
    intensidad = voltaje / resistencia;
    
    // Una vez tenemos la intensidad, obtenemos la potencia en vatios con  P = V * I
    
    potencia = voltaje * intensidad;
    
    System.out.println("La intensidad de la instalación es de: " + intensidad + " amperios");
    System.out.println("La potencia de la instalación son: " + potencia + " vatios");
    
    sc.close();
  }

}
