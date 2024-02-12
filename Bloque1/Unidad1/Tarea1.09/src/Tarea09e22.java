import java.util.Scanner;

public class Tarea09e22 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    
    double largo;
    double ancho;
    double alto;
    double volumen;
    double precioPorLitro;
    
    // Se van a dar las medidas en metros con la idea de transformar metros cúbicos a litros (1m^3 = 1000 l)
    
    System.out.print("Introduce el lado largo de la piscina en metros: ");
    
    largo = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce el lado ancho de la piscina en metros: ");
    
    ancho = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce la altura de la piscina en metros: ");
    
    alto = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduce el precio en € por cada litro de agua: ");
    
    precioPorLitro = Double.parseDouble(sc.nextLine());
    
    // El volumen lo transformo directamente a litros con la idea de hacer el cálculo sólo multiplicando por el precioPorLitro
    
    volumen = largo * ancho * alto * 1000 ;
    
    System.out.println("El precio total de llenado de la piscina es de " + volumen * precioPorLitro + "€.");
    
    sc.close();
    
  }

}
