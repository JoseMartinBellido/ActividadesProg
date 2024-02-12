package prog.unidad04.libro.fichasdedomino;

public class FichaDomino {

  private int ladoA;
  
  private int ladoB;
  
  
  public FichaDomino(int ladoA, int ladoB) {
    compruebaFicha(ladoA, ladoB);
    this.ladoA = ladoA;
    this.ladoB = ladoB;
  }
  
  

  
  private void compruebaFicha(int ladoA, int ladoB) {
    if (ladoA > 6  && ladoA < 0)
      ladoA = 0;

    if (ladoB > 6  && ladoB < 0)
      ladoB = 0;
    
  }
  
}
