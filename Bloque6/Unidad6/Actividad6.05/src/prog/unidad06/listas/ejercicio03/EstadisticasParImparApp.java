package prog.unidad06.listas.ejercicio03;

import java.util.ArrayList;
import java.util.List;

import prog.unidad06.listas.ejercicio01.ListaEnterosUtils;

public class EstadisticasParImparApp {

  // Constantes
  public static final int LONGITUD_MINIMA = 10;
  public static final int LONGITUD_MAXIMA = 20;
  
  public static final int VALOR_MINIMO = 0;
  public static final int VALOR_MAXIMO = 100;
  
  public static void main(String[] args) {
    
    System.out.println("ESTADÍSTICAS II");
    
    // Generamos la lista
    List<Integer> listaAleatorios = ListaEnterosUtils.generaListaEnterosAleatorios(
        LONGITUD_MINIMA, LONGITUD_MAXIMA, VALOR_MINIMO, VALOR_MAXIMO);
    
    // La imprimimos por pantalla
    System.out.println("La lista generada es: " + ListaEnterosUtils.generaCadena(listaAleatorios));
      
      // Creamos las dos listas nuevas
      List<Integer> listaPares = new ArrayList<>();
      List<Integer> listaImpares = new ArrayList<>();
      
      // Separamos la lista en pares o impares
      for (int i = 0; i < listaAleatorios.size(); i++) {
        if (listaAleatorios.get(i) % 2 == 0) {
          listaPares.add(listaAleatorios.get(i));
        } else {
          listaImpares.add(listaAleatorios.get(i));
        }
      }
      
      double suma; 
      int minimo;
      int maximo;
      
      // Imprimimos las listas
      System.out.println("La lista de los pares es: " + ListaEnterosUtils.generaCadena(listaPares));
      System.out.println("La lista de los impares es: " + ListaEnterosUtils.generaCadena(listaImpares));
            
      // Como podrían ser todos pares o impares, diferenciamos casos
      if (!listaPares.isEmpty()) {
        // Declaramos las variables para los cálculos
        suma = listaPares.get(0);
        minimo = listaPares.get(0);
        maximo = listaAleatorios.get(0);
       
       // La recorremos para realizar operaciones 
       for (int i = 1; i < listaPares.size(); i++) {
         suma += listaPares.get(i);
         minimo = (listaPares.get(i) < minimo) ? listaPares.get(i) : minimo;
         maximo = (listaPares.get(i) > maximo) ? listaPares.get(i) : maximo;
         
       }
       // Imprimimos los resultados
       System.out.println("La suma de los elementos pares vale " + suma + ", su media vale " 
           + (suma / listaPares.size()));
       System.out.println("El valor mínimo es " + minimo + " y el máximo es " + maximo + ".");
      
      // En caso de que la lista de pares sea vacía
      } else {
        System.out.println("La lista de elementos pares está vacía. Todos los elementos generados son impares, con lo que"
            + " no es posible realizar los cálculos.");
      }
      
      // Se sigue la misma lógica para los impares
      if (!listaImpares.isEmpty()) {
        // Declaramos las variables para los cálculos
        suma = listaImpares.get(0);
        minimo = listaImpares.get(0);
        maximo = listaImpares.get(0);
       
       // La recorremos para realizar operaciones 
       for (int i = 1; i < listaImpares.size(); i++) {
         suma += listaImpares.get(i);
         minimo = (listaImpares.get(i) < minimo) ? listaImpares.get(i) : minimo;
         maximo = (listaImpares.get(i) > maximo) ? listaImpares.get(i) : maximo;
         
       }
       // Imprimimos los resultados
       System.out.println("La suma de los elementos impares vale " + suma + ", su media vale " 
           + (suma / listaImpares.size()));
       System.out.println("El valor mínimo es " + minimo + " y el máximo es " + maximo + ".");
      
      // En caso de que la lista de pares sea vacía
      } else {
        System.out.println("La lista de elementos impares está vacía. Todos los elementos generados son pares, con lo que"
            + " no es posible realizar los cálculos.");
      }
      

    }
  

}
