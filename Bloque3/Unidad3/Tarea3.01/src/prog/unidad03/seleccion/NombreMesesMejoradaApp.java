package prog.unidad03.seleccion;

import java.util.Scanner;

public class NombreMesesMejoradaApp {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Nombres del mes");
    
    // Solicitamos los datos por teclado
    System.out.print("Introduce un número del 1 al 12 y te diré qué mes ocupa esa posición: ");
    int posicion = Integer.parseInt(sc.nextLine());
    
    String mes;
    
    // Asignación de la variable mes en función de la posición
    if(posicion > 0 &&  posicion < 13) {
      if(posicion == 1) {
        mes = "Enero";
      } else if (posicion == 2) {
        mes = "Febrero";
      } else if (posicion == 3) {
        mes = "Marzo";
      } else if (posicion == 4) {
        mes = "Abril";
      } else if (posicion == 5) {
        mes = "Mayo";
      } else if (posicion == 6) {
        mes = "Junio";
      } else if (posicion == 7) {
        mes = "Julio";
      } else if (posicion == 8) {
        mes = "Agosto";
      } else if (posicion == 9) {
        mes = "Septiembre";
      } else if (posicion == 10) {
        mes = "Octubre";
      } else if (posicion == 11) {
        mes = "Noviembre";
      } else{
        mes = "Diciembre";
      }   
       
      // Impresión de resultados
      System.out.print("El mes con posición " + posicion + " tiene como nombre \"" + mes + "\".");  
      
    } else {
      
      System.out.println("La posición introducida no es válida. Introduce un número del 1 al 12.");
    }
    
   
    sc.close();

  }

}
