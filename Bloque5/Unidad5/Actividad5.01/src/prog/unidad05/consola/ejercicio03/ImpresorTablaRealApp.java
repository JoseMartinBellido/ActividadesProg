package prog.unidad05.consola.ejercicio03;

public class ImpresorTablaRealApp {

  public static void main(String[] args) {

    double[][] tabla = {{10.12, -123.57, 432.5820}, 
        {1000.79, -8762.7928, 32.323232},
        {1123.9482, -10.99, 1924294.232}};
    
    ImpresorTablaReal.imprimeTabla(tabla, 2);
    
    
  }

}
