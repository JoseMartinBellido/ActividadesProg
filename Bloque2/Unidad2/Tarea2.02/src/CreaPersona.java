import java.util.Scanner;

public class CreaPersona {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Scanner sc = new Scanner(System.in);
    
    Persona persona = new Persona();
    
    System.out.print("Introduzca la edad de la persona en años: ");
    
    persona.edad = Integer.parseInt(sc.nextLine());
    
    System.out.print("Introduzca el número de hijos de la persona: ");
    
    persona.numeroHijos = Integer.parseInt(sc.nextLine());
    
    System.out.print("Introduzca el peso de la persona en Kg: ");
    
    persona.peso = Double.parseDouble(sc.nextLine());
    
    System.out.println("La persona tiene " + persona.edad + " años, tiene " + persona.numeroHijos + " hijos y pesa "
        + persona.peso + " kg.");
    
    sc.close();

  }

}
