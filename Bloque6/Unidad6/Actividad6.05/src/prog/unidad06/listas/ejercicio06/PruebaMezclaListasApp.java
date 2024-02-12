package prog.unidad06.listas.ejercicio06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import prog.unidad06.listas.ejercicio05.MezclaListasCadenas;


public class PruebaMezclaListasApp {

  public static void main(String[] args) {

    System.out.println("MEZCLA DE LISTAS");
    
    Scanner sc = new Scanner(System.in);
    
    // Solicitamos los datos de la primera lista
    List<String> primeraLista = new ArrayList<>();
    System.out.println("Introduce la primera lista de palabras\nIntroduce palabras, una por línea. Línea vacía para terminar.");
    String palabra = "";
    
    do {
      palabra = sc.nextLine();
      if (!palabra.isEmpty()) {
        primeraLista.add(palabra);
      }
    } while (!palabra.isEmpty());
  
    // Solicitamos los datos de la segunda lista
    List<String> segundaLista = new ArrayList<>();
    System.out.println("Introduce la primera lista de palabras\nIntroduce palabras, una por línea. Línea vacía para terminar.");
    
    do {
      palabra = sc.nextLine();
      if (!palabra.isEmpty()) {
        segundaLista.add(palabra);
      }
    } while (!palabra.isEmpty());
  
    // Imprimimos las listas
    System.out.println("La primera lista es: " +listaACadena(primeraLista));
    System.out.println("La segunda lista es: " + listaACadena(segundaLista));
    
    // Unión
    System.out.println("La unión de ambas listas es: " 
    + listaACadena(MezclaListasCadenas.union(primeraLista, segundaLista)));
    // Intersección
    System.out.println("La intersección de ambas listas es: " 
    + listaACadena(MezclaListasCadenas.interseccion(primeraLista, segundaLista)));
    // Diferencia
    System.out.println("La diferencia de la primera lista menos la segunda es: " 
    + listaACadena(MezclaListasCadenas.diferencia(primeraLista, segundaLista)));    
    System.out.println("La diferencia de la segunda lista menos la primera es: " 
        + listaACadena(MezclaListasCadenas.diferencia(segundaLista, primeraLista)));
    
    
    sc.close();
  }
  
  private static String listaACadena(List<String> lista) {
    String representacion = "[";
    for (int i = 0; i < lista.size(); i++) {
      representacion += "\"" + lista.get(i) + "\"";
      if (i < lista.size() - 1) {
        representacion += ", ";
      }
    }
    representacion += "]";
    
    return representacion;
  
  }
  
  

}
