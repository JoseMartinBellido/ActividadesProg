package prog.unidad04.atributos.ejercicio04;

import java.util.Scanner;

public class PruebaFigura {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("PROGRAMA DE MANEJO DE FIGURAS");
    
    // Creamos la variable numeroDeFiguras e iniciamos nuestro programa con un try/catch que recoja cualquier error de formato numérico.
    int numeroDeFiguras;
    
    try {
      
      System.out.print("Introduzca la cantidad de figuras a crear (1 o mas):");
      numeroDeFiguras = Integer.parseInt(sc.nextLine());
      
      // Hacemos un bucle for que repita la operación tantas veces como indique el usuario
      for(int i = 1; i <= numeroDeFiguras; i++) {
        
        // Le pedimos al usuario que indique la figura a crear. Si no da una válida, insistimos.
        String figuraACrear;
        do {
          System.out.print("¿Qué tipo de figura quieres crear? (t=triángulo, c=círculo, r=rectángulo):");
          figuraACrear = sc.nextLine();
          
          if (!figuraACrear.equalsIgnoreCase("t") && !figuraACrear.equalsIgnoreCase("c") && !figuraACrear.equalsIgnoreCase("r"))
            System.out.println("La figura introducida no se encuentra dentro de las opciones. Inténtelo de nuevo");
          
        } while (!figuraACrear.equalsIgnoreCase("t") && !figuraACrear.equalsIgnoreCase("c") && !figuraACrear.equalsIgnoreCase("r"));

        // Si la figura es un triángulo, pedimos los 3 vértices.
        if (figuraACrear.equalsIgnoreCase("t")) {
          
          Triangulo triangulo = new Triangulo();
          
          Punto vertice1 = new Punto();
          Punto vertice2 = new Punto();
          Punto vertice3 = new Punto();
          
          // Vértice 1 y asignación
          System.out.print("Introduce la coordenada X del primer vértice del triángulo: ");
          vertice1.coordenadaX = Double.parseDouble(sc.nextLine());
          
          System.out.print("Introduce la coordenada Y del primer vértice del triángulo: ");
          vertice1.coordenadaY = Double.parseDouble(sc.nextLine());
          
          triangulo.vertice1 = vertice1;
          
          // Vértice 2 y asignación
          System.out.print("Introduce la coordenada X del segundo vértice del triángulo: ");
          vertice2.coordenadaX = Double.parseDouble(sc.nextLine());
          
          System.out.print("Introduce la coordenada Y del segundo vértice del triángulo: ");
          vertice2.coordenadaY = Double.parseDouble(sc.nextLine());
          
          triangulo.vertice2 = vertice2;
          
          // Vértice 3 y asignación
          System.out.print("Introduce la coordenada X del tercer vértice del triángulo: ");
          vertice3.coordenadaX = Double.parseDouble(sc.nextLine());
          
          System.out.print("Introduce la coordenada Y del tercer vértice del triángulo: ");
          vertice3.coordenadaY = Double.parseDouble(sc.nextLine());
          
          triangulo.vertice3 = vertice3;
          
          //Imprimimos resultado del triángulo
          System.out.println("Datos del triángulo:");
          System.out.println("Primer vértice: (" + triangulo.vertice1.coordenadaX + ", " + triangulo.vertice1.coordenadaY + ")");
          System.out.println("Segundo vértice: (" + triangulo.vertice2.coordenadaX + ", " + triangulo.vertice2.coordenadaY + ")");
          System.out.println("Tercer vértice: (" + triangulo.vertice3.coordenadaX + ", " + triangulo.vertice3.coordenadaY + ")");
          
          // Si es un círculo, pedimos centro y longitud del radio
        } else if (figuraACrear.equalsIgnoreCase("c")) {
          
          Circulo circulo = new Circulo();
          
          Punto centro = new Punto();
          
          // Centro y asignación
          System.out.print("Introduce la coordenada X del centro del círculo: ");
          centro.coordenadaX = Double.parseDouble(sc.nextLine());
          
          System.out.print("Introduce la coordenada Y del centro del círculo: ");
          centro.coordenadaY = Double.parseDouble(sc.nextLine());
          
          circulo.centro = centro;
          
          // Pedimos el radio y, si es un número menor o igual a cero, repetimos la acción.
          do {
            System.out.print("Introduce la longitud del radio del círculo (debe ser mayor o igual a 0): ");
            circulo.radio = Double.parseDouble(sc.nextLine());
            
            if (circulo.radio <= 0)
              System.out.println("El radio no puede ser menor o igual a cero. Inténtelo de nuevo.");
          } while (circulo.radio <= 0);

          //Imprimimos resultado del círculo
          System.out.println("Datos del círculo:");
          System.out.println("Centro: (" + circulo.centro.coordenadaX + ", " + circulo.centro.coordenadaY + ")");
          System.out.println("Radio del círculo: " + circulo.radio);
          
        } else {
          
          Rectangulo rectangulo = new Rectangulo();
          
          Punto verticeInicial = new Punto();
          Punto verticeOpuesto = new Punto();
          
          // Vértice inicial y asignación
          System.out.print("Introduce la coordenada X de una esquina del rectángulo: ");
          verticeInicial.coordenadaX = Double.parseDouble(sc.nextLine());
          
          System.out.print("Introduce la coordenada Y de la misma esquina del rectángulo: ");
          verticeInicial.coordenadaY = Double.parseDouble(sc.nextLine());
          
          rectangulo.verticeInicial = verticeInicial;
          
          // Vértice opuesto y asignación
          System.out.print("Introduce la coordenada X de la esquina opuesta del rectángulo: ");
          verticeOpuesto.coordenadaX = Double.parseDouble(sc.nextLine());
          
          System.out.print("Introduce la coordenada Y de la misma esquina del rectángulo: ");
          verticeOpuesto.coordenadaY = Double.parseDouble(sc.nextLine());
          
          rectangulo.verticeOpuesto = verticeOpuesto;
          
          // Imprimimos el resultado del rectángulo
          System.out.println("Datos del rectángulo:");
          System.out.println("Primera esquina del rectángulo: (" 
          + rectangulo.verticeInicial.coordenadaX + ", " + rectangulo.verticeInicial.coordenadaY + ")");
          System.out.println("Segunda esquina del rectángulo: (" 
          + rectangulo.verticeOpuesto.coordenadaX + ", " + rectangulo.verticeOpuesto.coordenadaY + ")");
          
        }
        
      }
      
    } catch (NumberFormatException e) {
      System.out.println("Se ha introducido un dato numérico de forma errónea. Inténtelo de nuevo.");
    }
    
    sc.close();
  }

}
