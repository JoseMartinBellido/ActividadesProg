package prog.unidad03.seleccion;

import java.util.Scanner;

public class CalculadoraSalarioApp {

  // Declaración de variables
  public static final int SALARIO_HORA_NORMAL = 16;
  public static final int SALARIO_HORA_EXTRA = 20;
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Programa calculador de salarios.");
    
    // Solicitud de datos
    System.out.print("Introduce el número de horas trabajadas: ");
    int horasTrabajadas = Integer.parseInt(sc.nextLine());
    
    // Contemplamos las opciones dependiendo del número de horas introducidas
    // Si se ha trabajado más de 40 horas, habrán horas extra. En caso contrario, no las habrá
    
    double salario;
    
    if(horasTrabajadas > 40) {
      
      // Calculamos el número de horas extra y el salario final.
      int horasExtra = horasTrabajadas - 40;
      salario = 40 * 16 + horasExtra * 20;
      
      System.out.print("El salario por trabajar 40 horas normales y " + horasExtra + " horas extra es de " + salario + "€");
      
    } else {
      
      //En este caso solo calculamos el salario con las horas normales trabajadas.
      salario = horasTrabajadas * 16;
      
      System.out.println("El salario por trabajar " + horasTrabajadas + " horas es de " + salario + "€");
    }
        
    
    sc.close();
    
  }

}
