package prog.unidad06.arraysuni.ejercicio02;

import java.util.Random;

public class UtilidadesArrays {
  
  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {
    
    if (valorMaximo < valorMinimo || longitud <= 0) {
      throw new IllegalArgumentException();
    }
    
    // Creamos el array de la longitud determinada
    int[] numerosEnteros = new int[longitud];
    
    // Generador de números aleatorios
    Random generador = new Random();
    
    // Rellenamos el array con números entre valorMinimo y valorMaximo
    for (int i = 0; i < numerosEnteros.length; i++) {
      
      numerosEnteros[i] = (int) Math.round(
          (generador.nextDouble() * (valorMaximo - valorMinimo) + valorMinimo));
    }
    
    return numerosEnteros;
  }

}
