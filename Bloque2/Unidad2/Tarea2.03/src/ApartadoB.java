import java.util.Scanner;

public class ApartadoB {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    // Solicitamos la información del primer número e instanciamos.
    
    System.out.print("Indica la parte real del primer número complejo: ");
    double real = Double.parseDouble(sc.nextLine());
    
    System.out.print("Indica la parte imaginaria del primer número complejo: ");
    double imaginaria = Double.parseDouble(sc.nextLine());
    
    Complejo numero1 = new Complejo(real,imaginaria);
    
    // Solicitamos la información del segundo número e instanciamos.
    
    System.out.print("Indica la parte real del segundo número complejo: ");
    real = Double.parseDouble(sc.nextLine());
    
    System.out.print("Indica la parte imaginaria del segundo número complejo: ");
    imaginaria = Double.parseDouble(sc.nextLine());
    
    Complejo numero2 = new Complejo(real,imaginaria);
    
    // Realizamos los cálculos con los números imaginarios.
    
    Complejo suma = numero1.sumar(numero2);
    
    Complejo resta = numero1.restar(numero2);
    
    Complejo producto = numero1.multiplicar(numero2);
    
    Complejo division = numero1.dividir(numero2);
    
    // Imprimimos por pantalla los resultados
    
    System.out.println("El valor de la suma de ambos números complejos es de: " 
    + suma.getParteReal() + " + " + suma.getParteImaginaria() + "i");
    
    System.out.println("El valor de la resta de ambos números complejos es de: " 
    + resta.getParteReal() + " + " + resta.getParteImaginaria() + "i");
    
    System.out.println("El valor del producto de ambos números complejos es de: " 
    + producto.getParteReal() + " + " + producto.getParteImaginaria() + "i");
    
    System.out.println("El valor de la division entre ambos números complejos es de: " 
    + division.getParteReal() + " + " + division.getParteImaginaria() + "i");
    
    sc.close();
    
  }

}
