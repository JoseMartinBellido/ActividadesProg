package prog.unidad04.libro.amebas;

public class Ameba {

  private int peso;
  
  public Ameba() {
    peso = 3;
    
  }
  
  public void come(int comida) {
    if ( peso + comida - 1 <= 0) {
      System.out.println("¡La ameba no puede comer o quedará desintegrada!");
    } else {
      peso += comida - 1;
    }
  }

  public void come(Ameba otraAmeba) {
    if ( peso + otraAmeba.getPeso() - 1 <= 0) {
      System.out.println("¡La ameba no puede comer o quedará desintegrada!");
    } else {
      peso += otraAmeba.getPeso() - 1;
      otraAmeba.haSidoComida();
    }
  }
  
  
  
  @Override
  public String toString() {
    return "Soy una Ameba y peso " + peso + " microgramos";
  }

  private int getPeso() {
    return peso;
  }
  
  private void haSidoComida() {
    this.peso = 0;
  }
  
  
}
