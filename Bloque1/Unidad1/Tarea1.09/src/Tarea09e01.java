
public class Tarea09e01 {
  
  public static final int valor1 = 256;
  public static final int valor2 = 398;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    int suma;
    int resta;
    int producto;
    int cociente;
    int modulo;
    
    suma = valor1 + valor2;
    resta = valor2 - valor1;
    producto = valor1 * valor2;
    cociente = valor2 / valor1;
    modulo = valor2 % valor1;
    
    System.out.println("Con los datos valor1 = 256 y valor2 = 398 tenemos que: ");
    
    System.out.println("El resultado de la suma es: "+suma);
    
    System.out.println("El resultado de la resta valor2-valor1 es: "+resta);
    
    System.out.println("El resultado del producto es: "+producto);
    
    System.out.println("El resultado del cociente entero valor2/valor1 es: "+cociente);
    
    System.out.println("El resultado del módulo al dividir valor2 entre valor1 es: "+modulo);
  }

}
