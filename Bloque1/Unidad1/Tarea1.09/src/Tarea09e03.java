public class Tarea09e03 {
  
  public static final double IVA = 0.21;
  
  public static void main(String[] args) {
    
    double base = 1250.5;
    
    double total;
    
    total = base * (1 + IVA);
    
    System.out.println("Aplicando el 21% a la factura, queda el total en " + total + "€.");

    
  }

}
