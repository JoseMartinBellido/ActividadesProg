package prog;

import es.iespablopicasso.programacion.unidad02.actividad0201.GranHermano;

public class ApartadoA {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Creación de objetos GranHermano
    
    GranHermano gh1 = new GranHermano(25);
    
    GranHermano gh2 = new GranHermano(41);
    
    GranHermano gh3 = new GranHermano(18);
    
    // Imprimimos por pantalla el número de objetos creados
    
    System.out.println("El número de objetos creados la primera vez es de " + GranHermano.getNumeroObjetosCreados());
    System.out.println("Las edades son, respectivamente,  " + gh1.getEdad() + ", " + gh2.getEdad() + ", " + gh3.getEdad());
    
    // Repetimos el proceso completo
    
    GranHermano gh4 = new GranHermano(28);
    
    GranHermano gh5 = new GranHermano(48);
    
    GranHermano gh6 = new GranHermano(33);
    
    // Imprimimos por pantalla el número de objetos creados
    
    System.out.println("El número de objetos creados la segunda vez es de " + GranHermano.getNumeroObjetosCreados());
    System.out.println("Las edades son, respectivamente,  " + gh4.getEdad() + ", " + gh5.getEdad() + ", " + gh6.getEdad());
    
  }

}
