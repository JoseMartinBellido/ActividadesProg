package prog.unidad06.arraysmulti.ejercicio06;

public class PruebaImprimeTabla {

  public static void main(String[] args) {
    
    int[][] tablaAleatorios = TablaEnteraUtils.nuevaTablaAleatoria(7, 10, -1000, 1000);
 
    TablaEnteraUtils.imprimeTabla(tablaAleatorios, 5);
    
    
  }

}
