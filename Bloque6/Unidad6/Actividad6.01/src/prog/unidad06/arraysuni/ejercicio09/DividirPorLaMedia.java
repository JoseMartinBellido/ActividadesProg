package prog.unidad06.arraysuni.ejercicio09;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays2;

public class DividirPorLaMedia {

  // Constantes
  private static final int CANTIDAD_ELEMENTOS = 50;
  private static final int VALOR_MINIMO = 300;
  private static final int VALOR_MAXIMO = 800;
  
  public static void main(String[] args) {
    
    System.out.println("DIVIDIR POR LA MEDIA");
    
    // Creamos un array y lo rellenamos con los números aleatorios
    int[] aleatorios = UtilidadesArrays2.generaArrayEnteroAleatorio
        (CANTIDAD_ELEMENTOS, VALOR_MINIMO, VALOR_MAXIMO);
    
    // Guardamos en un string el array entero
    String aleatoriosStr = "El array entero es:";
    for (int i = 0; i < aleatorios.length; i++) {
      aleatoriosStr += (i % 10 == 0) ? "\n" : "";
      aleatoriosStr += (i == aleatorios.length - 1) ? aleatorios[i] : aleatorios[i] + ", ";
    }
    
    // Calculamos la media
    
    double mediaAleatorios = 0;
    for (int aleatorio : aleatorios) {
      mediaAleatorios += aleatorio;
    }
    
    mediaAleatorios /= CANTIDAD_ELEMENTOS;
    
    // Una vez tenemos la media, creamos el nuevo array y modificamos los elementos
    double[] aleatoriosModificados = new double[aleatorios.length];
    
    // A su vez, guardamos de nuevo el array en un string
    String aleatoriosModificadosStr = "El array real es:";
    for (int i = 0; i < aleatoriosModificados.length; i++) {
      aleatoriosModificados[i] = aleatorios[i] / mediaAleatorios;
      
      aleatoriosModificadosStr += (i % 5 == 0) ? "\n" : "";
      aleatoriosModificadosStr += (i == aleatoriosModificados.length - 1) ? aleatoriosModificados[i] 
          : aleatoriosModificados[i] + ", ";
    }
    
    // Imprimimos resultados
    System.out.println(aleatoriosStr + "\n\n" + aleatoriosModificadosStr);
  
    // Cerramos el Scanner
  }

}
