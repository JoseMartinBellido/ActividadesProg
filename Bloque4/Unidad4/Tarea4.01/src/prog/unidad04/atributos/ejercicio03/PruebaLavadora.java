package prog.unidad04.atributos.ejercicio03;

import java.util.Scanner;

public class PruebaLavadora {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("PROGRAMA DE MANEJO DE LAVADORAS.");
    
    try {
      // Primero, metemos todo el bloque en un try/catch para evitar un posible error en el formato numérico
      // Pedimos el número total de pizzas
      
      System.out.print("Introduzca la cantidad de lavadoras a crear (1 o más): ");
      int numeroDeLavadoras = Integer.parseInt(sc.nextLine());
      
      // Solo hacemos toda la operación si tenemos un número de personas válido
      if (numeroDeLavadoras > 0) {
        
        // Por cada persona, creamos un bucle for dependiendo del número de personas requeridas
        for (int i = 1; i <= numeroDeLavadoras; i++) {
          
          // Creamos un objeto de la clase Persona e introducimos los atributos uno a uno según se requieren al usuario
          Lavadora lavadora = new Lavadora();
          
          System.out.println("Introuzca los datos de la lavadora " + i + ".");
          
          // Solicitamos el precio base de la lavadora
          System.out.print("Introduzca el precio base de la lavadora: ");
          lavadora.precioBase = Double.parseDouble(sc.nextLine());
          
          // Solicitamos la color de la lavadora. Si no es uno de los obligatorios, insistimos.
          do {          
            
            System.out.print("Introduce el color de la lavadora (debe ser uno de: blanco, negro, rojo, azul, gris): ");
            lavadora.color = sc.nextLine();
            
            if (!lavadora.color.equalsIgnoreCase(Lavadora.COLOR_BLANCO) && !lavadora.color.equalsIgnoreCase(Lavadora.COLOR_NEGRO) 
              && !lavadora.color.equalsIgnoreCase(Lavadora.COLOR_ROJO) && !lavadora.color.equalsIgnoreCase(Lavadora.COLOR_AZUL) 
              && !lavadora.color.equalsIgnoreCase(Lavadora.COLOR_GRIS))
              System.out.println("El color indicado no pertenece a nuestro catálogo. Inténtelo de nuevo.");
            
          } while (!lavadora.color.equalsIgnoreCase(Lavadora.COLOR_BLANCO) && !lavadora.color.equalsIgnoreCase(Lavadora.COLOR_NEGRO) 
              && !lavadora.color.equalsIgnoreCase(Lavadora.COLOR_ROJO) && !lavadora.color.equalsIgnoreCase(Lavadora.COLOR_AZUL) 
              && !lavadora.color.equalsIgnoreCase(Lavadora.COLOR_GRIS));

          
          // Solicitamos la calificación energética. Sino insistimos. Tenemos una variable auxiliar para insertar el dato.
          String calificacionEnergetica = "";
          
          do {
            
            System.out.print("Introduce la calificación energética de la lavadora "
                + "(sebe ser una letra mayúscula entre la A y la F, ambas incluidas): ");
            calificacionEnergetica = sc.nextLine();
            
            switch (calificacionEnergetica) {
            case "A":
            case "a":
            case "B":
            case "b":
            case "C":
            case "c":
            case "D":
            case "d":
            case "E":
            case "e":
            case "F":
            case "f":
              lavadora.consumoEnergetico = calificacionEnergetica.toUpperCase().charAt(0);
              break;

            }
            
            if (calificacionEnergetica.isEmpty())
              System.out.println("La calificación energética indicada no es correcta.");
            
          }while (calificacionEnergetica.isEmpty());
          
          
          // Solicitamos el peso de la lavadora.
          do {
            
            System.out.print("Introduce el peso de la lavadora (en kilogramos. Debe ser mayor que cero): ");
            lavadora.peso = Double.parseDouble(sc.nextLine());
            
          } while (lavadora.peso <= 0);

          
          // Solicitamos la carga máxima de la lavadora
          do {
            System.out.print("Introduce la carga máxima de la lavadora (en kilogramos. Debe ser mayor que cero): ");
            lavadora.cargaMaxima = Double.parseDouble(sc.nextLine());
            
          } while(lavadora.cargaMaxima <= 0);

          
          
          // Imprimimos los resultados.
          
          System.out.println("Datos de la lavadora " + i);
          System.out.println("Precio base: " + lavadora.precioBase);
          System.out.println("Color: " + lavadora.color);
          System.out.println("Calificación Energética: " + lavadora.consumoEnergetico);
          System.out.println("Peso: " + lavadora.peso);
          System.out.println("Carga máxima: " + lavadora.cargaMaxima);
        }
        

        
      } else {
        //Caso en el que no se ha metido un número de personas totales mayor que 0
        System.out.println("Lo sentimos, no podemos crear " + numeroDeLavadoras + " lavadoras.");
      }
      
    } catch (NumberFormatException e) {
      System.out.println("Se ha introducido de forma incorrecta un dato numérico. Inténtelo de nuevo.");
    }
    
    
    
    sc.close();
    
    
  }

}
