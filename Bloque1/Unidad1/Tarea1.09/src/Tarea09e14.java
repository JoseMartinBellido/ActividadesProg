import java.util.Scanner;

public class Tarea09e14 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double nota1;
    double nota2;
    double media;
    
    System.out.print("Introduce la nota de tu primer exámen de programación: ");
    
    nota1 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la nota media que deseas conseguir: ");
    
    media = Double.parseDouble(sc.nextLine());
    
    // A partir de la primera nota y la media, se puede usar la fórmula para obtener la segunda nota de la siguiente forma:
    
    nota2 = media * 2 - nota1;
    
    System.out.println("Para conseguir una nota media de " + media + " y tras haber obtenido un " + nota1 + 
        " en el primer exámen, necesitas sacar un " + nota2 + " en el segundo exámen.");
    
    sc.close();
    
  }

}
