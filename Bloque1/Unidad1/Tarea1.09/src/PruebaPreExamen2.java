import java.util.Scanner;

public class PruebaPreExamen2 {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Se va a calcular el área del terreno formado por los lados A, B y C.");
    
    // Primero solicitamos los datos por Scanner de las tres medidas
    
    System.out.print("Introduzca la medida del lado A en metros: ");
    
    double ladoA = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduzca la medida del lado B en metros: ");
    
    double ladoB = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduzca la medida del lado C en metros: ");
    
    double ladoC = Double.parseDouble(sc.nextLine());
    
    /* Para calcular el área de la figura vamos a separarla en dos figuras geométricas y sumar sus áreas.
     * Por un lado tendremos el rectángulo de lados B y C, y por otro el triángulo de base B y altura A-C.
     */
    
    double areaRectangulo = ladoB * ladoC;
    
    double areaTriangulo = (ladoA - ladoC) * ladoB / 2;
    
    double areaFinal = areaRectangulo + areaTriangulo;
    
    System.out.println("El área final del terreno es de " + areaFinal + " m^2 (metros cuadrados)");
    
    
    sc.close();
    
  }

}
