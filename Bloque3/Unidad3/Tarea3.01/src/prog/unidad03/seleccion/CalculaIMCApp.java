package prog.unidad03.seleccion;

import java.util.Scanner;

public class CalculaIMCApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Programa de cálculo de IMC");
    
    // Pedimos los datos necesarios
    System.out.print("Introduce la altura en metros: ");
    double altura = Double.parseDouble(sc.nextLine());
    

    System.out.print("Introduce el peso en Kg: ");
    double peso = Double.parseDouble(sc.nextLine());
    
    // Calculamos e imprimimos el IMC
    double imc = peso / (altura * altura);
    
    System.out.println("Su IMC es: " + imc);
    
    // Dependiendo del valor del IMC. Menor de 16
    if (imc < 16) {
      System.out.println("Ingreso en hospital");
    } else if (imc >= 16 && imc < 17) {
      System.out.println("Infrapeso");
    }else if (imc >= 17 && imc < 18) {
      System.out.println("Bajo peso");
    }else if (imc >= 18 && imc < 25) {
      System.out.println("Peso normal");
    }else if (imc >= 25 && imc < 30) {
      System.out.println("Sobrepeso. Obesidad de grado 1.");
    }else if (imc >= 30 && imc < 35) {
      System.out.println("Sobrepeso crónico. Obesidad de grado 2.");
    }else if (imc >= 35 && imc <= 40) {
      System.out.println("Obesidad premórbida. Obesidad de grado 3.");
    } else {
      System.out.println("Obesidad mórbida. Obesidad de grado 4.");
      
      sc.close();

    }
  }

}
