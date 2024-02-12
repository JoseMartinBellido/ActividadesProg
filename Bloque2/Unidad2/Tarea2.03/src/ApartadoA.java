
public class ApartadoA {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Parte a
    
    CuentaCorriente cuenta1 = new CuentaCorriente("11111");
    
    // Parte b
    
    cuenta1.ingresar(1000);
    
    // Parte c
    
    System.out.println(cuenta1.getSaldo());
    
    // Parte d
    
    cuenta1.retirar(1100);
    
    // Indica con un error, tal y como indica la clase, que no se puede retirar más cantidad de la que existe en la clase.
    
    // Parte e
    
    System.out.println(cuenta1.getSaldo());
    
    // Parte f
    
    // No ocurre nada, simplemente se retira la cantidad indicada.
    
    cuenta1.retirar(900);
    
    // Parte g
    
    System.out.println(cuenta1.getSaldo());
    
    // Parte h
    
    // No ocurre nada, se retira la cantidad indicada y se queda en 0.
    
    cuenta1.retirar(100);
    
    // Parte i
    
    cuenta1.ingresar(350);
    
    // Parte j
    
    System.out.println(cuenta1.getSaldo());   
    
    // Parte k
    
    // Da error, puesto que no se puede retirar más de lo que hay.
    
    cuenta1.retirar(400);
    
    // Parte l
    
    System.out.println(cuenta1.getSaldo());
    
  }

}
