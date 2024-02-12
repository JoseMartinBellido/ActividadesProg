package tema4;

import java.util.Scanner;

public class T23Facturas {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("EJERCICIO FACTURAS");
    
    try {
      System.out.print("Introduzca la base imponible: ");
      double baseImponible = Double.parseDouble(sc.nextLine());
      String tipoIva;
      
      do {
        System.out.print("Introduzca el tipo de IVA (general, reducido o superreducido): ");
        tipoIva = sc.nextLine();
        
        if(!tipoIva.equalsIgnoreCase("general") && !tipoIva.equalsIgnoreCase("reducido") && !tipoIva.equalsIgnoreCase("superreducido"))
          System.out.println("El tipo de iva introducido no es correcto. Por favor, introduzca un tipo correcto.");
        
      } while(!tipoIva.equalsIgnoreCase("general") && !tipoIva.equalsIgnoreCase("reducido") && !tipoIva.equalsIgnoreCase("superreducido"));
        
      String codigoDescuento;
      do {
        System.out.print("Introduzca el código promocional (nopro, mitad, meno5, 5porc): ");
        codigoDescuento = sc.nextLine();
        
        if(!codigoDescuento.equalsIgnoreCase("nopro") && !codigoDescuento.equalsIgnoreCase("mitad") 
          && !codigoDescuento.equalsIgnoreCase("meno5") && !codigoDescuento.equalsIgnoreCase("5porc"))
          System.out.println("Introduzca un código promocional válido por favor. Inténtelo de nuevo.");
        
      } while(!codigoDescuento.equalsIgnoreCase("nopro") && !codigoDescuento.equalsIgnoreCase("mitad") 
          && !codigoDescuento.equalsIgnoreCase("meno5") && !codigoDescuento.equalsIgnoreCase("5porc"));
      
      
      System.out.println("Base imponible:\t\t" + baseImponible);
      
      double iva;
      
      switch (tipoIva){
      case "general":
        iva = baseImponible * 0.21;
        System.out.println("IVA (21%):\t\t" + iva);
        break;
      
      case "reducido":
        iva = baseImponible * 0.1;
        System.out.println("IVA (10%):\t\t" + iva);
        break;
        
      default:
        iva = baseImponible * 0.04;
        System.out.println("IVA (4%):\t\t" + iva);
        break;
      }
      
      double importeTotal = baseImponible + iva;
      
      System.out.println("Precio con IVA:\t\t" + importeTotal);
      
      double descuento;
      System.out.print("Cód. promo. ");
      
      if (codigoDescuento.equalsIgnoreCase("nopro")) {
        
        descuento = 0;
        System.out.println("(nopro):\t" + descuento);
      } else if (codigoDescuento.equalsIgnoreCase("mitad")) {
        
        descuento = -(importeTotal * 0.5);
        System.out.println("(mitad):\t" + descuento);
      } else if (codigoDescuento.equalsIgnoreCase("meno5")) {
        
        descuento = -5;
        System.out.println("(meno5):\t" + descuento);
      } else {
        
        descuento = -(importeTotal * 0.05);
        System.out.println("(5porc):\t" + descuento);
      }
      
      importeTotal += descuento;
      
      System.out.println("TOTAL:\t\t\t" + importeTotal);
      
    }catch(NumberFormatException e) {
      System.out.println("La cantidad introducida no es válida.");
    }
    
    sc.close();
    
  }

}
