package prog.unidad06.arraysuni.ejercicio05;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays2;

public class ProcesaAleatorios {

  // Constantes
  public static final int CANTIDAD_NUMEROS = 150;
  public static final int VALOR_MINIMO = 1;
  public static final int VALOR_MAXIMO = 300;
  
  public static void main(String[] args) {
    
    // Creamos el array
    int[] numerosAleatorios = UtilidadesArrays2.generaArrayEnteroAleatorio
        (CANTIDAD_NUMEROS, VALOR_MINIMO, VALOR_MAXIMO);
    
    
    // Creamos las variables para buscar el mayor, menor y sus coincidencias
    int mayor = UtilidadesArrays2.getMaximoArrayEntero(numerosAleatorios);
    int repeticionesMayor = UtilidadesArrays2.enteroApareceEnArrayEntero(numerosAleatorios, mayor);
    
    int menor = UtilidadesArrays2.getMinimoArrayEntero(numerosAleatorios);
    int repeticionesMenor = UtilidadesArrays2.enteroApareceEnArrayEntero(numerosAleatorios, menor);
    
    
    // Imprimimos los resultados
    String vezVeces = (repeticionesMayor > 1) ? "veces" : "vez";
    
    System.out.println("El número " + mayor + " es el mayor del array y se repite " + repeticionesMayor 
        + " " + vezVeces);
    
    vezVeces = (repeticionesMenor > 1) ? "veces" : "vez";
    System.out.println("El número " + menor + " es el menor del array y se repite " + repeticionesMenor 
        + " " + vezVeces);
    
    
  }

}
