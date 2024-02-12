import java.util.Scanner;

public class PruebaPreExamen1 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Se va a calcular la segunda nota de exámen para obtener la media que desee. ");
    
    System.out.print("Introduzca la nota de su primer exámen: ");
    
    double nota1 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduzca la nota media que desea: ");
    
    double media = Double.parseDouble(sc.nextLine());
    
    double nota2 = media * 2 - nota1;
    
    System.out.println("La nota que necesita sacar para obtener un " + media + " de media teniendo un " + nota1 
        + " en el primer exámen es de " + nota2);
    
    sc.close();
    
  }
  
  
}
