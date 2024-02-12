package prog.unidad06.listas.ejercicio02;

import java.util.List;

import prog.unidad06.listas.ejercicio01.ListaEnterosUtils;

public class EstadisticasApp {
  
  // Constantes
  public static final int LONGITUD_MINIMA = 10;
  public static final int LONGITUD_MAXIMA = 20;
  
  public static final int VALOR_MINIMO = 0;
  public static final int VALOR_MAXIMO = 100;
  

  public static void main(String[] args) {

    System.out.println("ESTADÍSTICAS");
    
    // Generamos la lista
    List<Integer> listaAleatorios = ListaEnterosUtils.generaListaEnterosAleatorios(
        LONGITUD_MINIMA, LONGITUD_MAXIMA, VALOR_MINIMO, VALOR_MAXIMO);
    
    // La imprimimos por pantalla
    System.out.println("La lista generada es: " + ListaEnterosUtils.generaCadena(listaAleatorios));
    
    // Declaramos las variables para los cálculos
    double suma = listaAleatorios.get(0);
    int minimo = listaAleatorios.get(0);
    int maximo = listaAleatorios.get(0);
    
    // La recorremos para realizar operaciones 
    for (int i = 1; i < listaAleatorios.size(); i++) {
      suma += listaAleatorios.get(i);
      minimo = (listaAleatorios.get(i) < minimo) ? listaAleatorios.get(i) : minimo;
      maximo = (listaAleatorios.get(i) > maximo) ? listaAleatorios.get(i) : maximo;
      
    }
    
    // Imprimimos los resultados
    System.out.println("La suma de los elementos vale " + suma + ", su media vale " 
        + (suma / listaAleatorios.size()));
    System.out.println("El valo mínimo es " + minimo + " y el máximo es " + maximo + ".");
  }

  

}
