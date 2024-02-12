import java.util.Scanner;

public class Tarea09e24 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Scanner sc = new Scanner(System.in);
    
    double duracionLlamada;
    double costeEstablecimiento;
    double costePorMinuto;
    double costeTotal;
    
    System.out.println("Indica la duración de la llamada en minutos: ");
    
    duracionLlamada = Double.parseDouble(sc.nextLine());
    
    System.out.println("Indica el coste en € del establecimiento de llamada: ");
    
    costeEstablecimiento = Double.parseDouble(sc.nextLine());
    
    System.out.println("Indica el coste por minuto en €: ");
    
    costePorMinuto = Double.parseDouble(sc.nextLine());
    
    // Hay que tener en cuenta que, una vez con los datos, el coste total se forma sumando al coste por establecimiento de llamada, que
    // es un valor fijo, la duración de la llamada multiplicada por el coste por minuto.
    
    costeTotal = costeEstablecimiento + duracionLlamada * costePorMinuto;
    
    System.out.println("El coste total de la llamada bajo los parámetros establecidos es de " + costeTotal + "€");
    
    sc.close();

  }

}
