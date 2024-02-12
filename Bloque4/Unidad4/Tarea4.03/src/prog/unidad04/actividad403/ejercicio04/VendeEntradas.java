package prog.unidad04.actividad403.ejercicio04;

import java.util.Scanner;

public class VendeEntradas {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    // Bloque de variables
    Zona platea = new Zona(150);
    Zona palco = new Zona(50);
    Zona atico = new Zona(100);
      
    int opcionElegida = 1;
      
    // Repetimos el proceso mientras la opción elegida no sea 3
    do {
        
      System.out.println("\nGESTIÓN DE ENTRADAS");
      System.out.println("-------------------");
       
      System.out.println("1.- Mostrar asientos libres por zona \n2.- Vender asientos \n3.- Salir del programa");
      System.out.print("Elija una opción (1,2,3): ");  
      try {
        opcionElegida = Integer.parseInt(sc.nextLine());
        
        // Opción 1: Impresión de asientos libres
        if (opcionElegida == 1) {
          System.out.println("ASIENTOS LIBRES POR ZONA");
          System.out.println("------------------------");
          
          System.out.println("Zona Platea: " + platea.getEntradasPorVender());
          System.out.println("Zona Palco: " + palco.getEntradasPorVender());
          System.out.println("Zona Ático: " + atico.getEntradasPorVender());
          
          // Opción 2: Venta de entradas
        } else if (opcionElegida == 2) {
          System.out.println("VENTA DE ENTRADAS");
          System.out.println("-----------------");
          
          System.out.print("Seleccione la zona en la que se localizan los asientos a vender (1= Platea, 2 = Palco, 3 = Ático):");
          int zonaElegida = Integer.parseInt(sc.nextLine());
          
          System.out.print("Introduzca el número de asientos a vender: ");
          int entradasAVender = Integer.parseInt(sc.nextLine());
          
          switch (zonaElegida) {
          case 1:
            try {
              platea.vender(entradasAVender);
            } catch (ZonaException e) {
              System.out.println("No se pudo realizar la venta de entradas. Probablemente no haya entradas suficientes "
                  + "en la zona elegida.");
            }

            break;
          case 2: 
            try {
              palco.vender(entradasAVender);
            } catch (ZonaException e) {
              System.out.println("No se pudo realizar la venta de entradas. Probablemente no haya entradas suficientes "
                  + "en la zona elegida.");
            }
            break;
            
          case 3:
            try {
              atico.vender(entradasAVender);
            } catch (ZonaException e) {
              System.out.println("No se pudo realizar la venta de entradas. Probablemente no haya entradas suficientes "
                  + "en la zona elegida.");
            }
            break;
            
           default:
             System.out.println("La zona en la que está intentando comprar entradas no existe. Inténtelo de nuevo.");
             break;
          }
          
        // Si nuestro caso no vale 3 (ni 1 ni 2)
        } else if (opcionElegida != 3) {
          System.out.println("La opción elegida en el menú no se encuentra disponible. Inténtelo de nuevo.");
        
          
        } else {
          System.out.println("Saliendo del programa.....");
          
        }
       
      } catch (NumberFormatException e) {
        System.out.println("La opción introducida no se encuentra en el formato correcto.");
      }

    } while (opcionElegida != 3 
        && (platea.getEntradasPorVender() > 0 && palco.getEntradasPorVender() > 0 && atico.getEntradasPorVender() > 0));
      
    sc.close();
  }

}
