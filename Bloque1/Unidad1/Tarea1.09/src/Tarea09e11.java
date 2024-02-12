import java.util.Scanner;

public class Tarea09e11 {
  
  public static final int SUELDO_HORA = 12;

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double horasTrabajadas;
    
    System.out.print("Indica el número de horas que has trabajado esta semana: ");
    
    horasTrabajadas = Double.parseDouble(sc.nextLine());
    
    System.out.println("Habiendo trabajado " + horasTrabajadas + " horas esta semana, a un precio de " + SUELDO_HORA +
        "€/hora, deberías cobrar " + (horasTrabajadas * SUELDO_HORA) + "€");
    
    sc.close();
    
  }

}
