package prog.unidad01.actividad206;

// IMPORTACION

import java.util.Scanner;

import es.iespablopicasso.programacion.bloque02.figuras.Paralelogramo;

import java.util.Random;

public class SolucionNico {

  // MAIN

  public static void main(String[] args) {

    // INTRODUCCION

    Scanner sc = new Scanner(System.in);
    System.out.println("EXAMEN DE NICOLAS_AGUSTIN_MASSACCESI. PROPIEDADES DE LOS PARALELOGRAMOS");

    // PUNTO 1:

    System.out.print("Introduzca la longitud de los lados horizontales: ");
    double horizontal = Double.parseDouble(sc.nextLine());

    // PUNTO 2:

    System.out.print("Introduzca el límite mínimo de los posibles valores de la longitud\n" + "del lado vertical:");
    double minimo = Double.parseDouble(sc.nextLine());
    System.out.print("Introduzca ahora el límite maximo de los posibles valores de la longitud del lado vertical:");
    double maximo = Double.parseDouble(sc.nextLine());

    // PUNTO 3:

    Random aleatorio = new Random();
    double vertical = aleatorio.nextDouble(minimo, maximo);
    System.out.println("La longitud del lado vertical obtenida al azar es de: " + vertical);

    // PUNTO 4:

    Paralelogramo nuevoParalelogramo = new Paralelogramo(horizontal, vertical);
    String areaPerimetro = nuevoParalelogramo.getAreaPerimetro();
    int posicionPuntoComa = areaPerimetro.indexOf(";");
    String area = areaPerimetro.substring(0, posicionPuntoComa);
    String perimetro = areaPerimetro.substring(posicionPuntoComa + 1);

    // PUNTO 5:

    System.out.println("El área del paralelogramo vale " + area + " y el perimetro vale " + perimetro);
    System.out
        .println("La suma del area y el perimetro es " + (Double.parseDouble(area) + Double.parseDouble(perimetro)));

    // PUNTO 6:

    System.out.print("Introduzca el factor real positivo por el que quiere ampliar (mayor que 1)"
        + " o reducir (menor que 1) el paralelogramo: ");
    Double factor = Double.parseDouble(sc.nextLine());

    // PUNTO 7:

    nuevoParalelogramo.escala(factor);

    // PUNTO 8:

    String areaPerimetroEscalados = nuevoParalelogramo.getAreaPerimetro();
    int posicionPuntoComaEscalado = areaPerimetroEscalados.indexOf(";");
    String areaEscalada = areaPerimetroEscalados.substring(0, posicionPuntoComaEscalado);
    String perimetroEscalado = areaPerimetroEscalados.substring(posicionPuntoComaEscalado + 1);
    System.out.println("Despues del escalado, el área del paralelogramo vale ahora " + areaEscalada + " y el perimetro "
        + perimetroEscalado);

    // PUNTO 9:

    System.out.println("La suma del area y el perimetro escalados es "
        + (Double.parseDouble(areaEscalada) + Double.parseDouble(perimetroEscalado)));

    // FIN

    sc.close();
  }

}
