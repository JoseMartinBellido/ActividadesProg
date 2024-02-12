package prog.unidad04.atributos.ejercicio02;

import java.util.Scanner;

public class PruebaPersona {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("PROGRAMA DE MANEJO DE PERSONAS.");
    
    try {
      // Primero, metemos todo el bloque en un try/catch para evitar un posible error en el formato numérico
      // Pedimos el número total de personas
      
      System.out.print("Introduzca la cantidad de personas a crear (1 o más): ");
      int numeroDePersonas = Integer.parseInt(sc.nextLine());
      
      // Solo hacemos toda la operación si tenemos un número de personas válido
      if (numeroDePersonas > 0) {
        
        // Por cada persona, creamos un bucle for dependiendo del número de personas requeridas
        for (int i = 1; i <= numeroDePersonas; i++) {
          
          // Creamos un objeto de la clase Persona e introducimos los atributos uno a uno según se requieren al usuario
          Persona persona = new Persona();
          
          System.out.println("Introuzca los datos de la persona " + i + ".");
          
          // Solicitamos el nombre de la persona
          System.out.print("Introduzca el nombre de la persona: ");
          persona.nombre = sc.nextLine();
          
          // Solicitamos la edad de la persona. 
          System.out.print("Introduzca la edad de la persona (debe ser mayor o igual a cero): ");
          persona.edad = Integer.parseInt(sc.nextLine());
          
          // Solicitamos el DNI. Hay que comprobar que el formato es el correcto. Sino, insistimos
          boolean comprobacionDni = true;
          do{
            System.out.print("Introduce el DNI de la persona (debe constar de 8 números y una letra): ");
            persona.dni = sc.nextLine().toUpperCase();
            
            for (int j = 0; j < 9; j++) {
              // Compruebo que los números son, efectivamente, números, mediante su numeración en la tabla ascii.
              int caracterAscii = (int) persona.dni.charAt(j);
              
              if (j < 8) {
                
                if(caracterAscii < 48 || caracterAscii > 57)
                  comprobacionDni = false;
              }else {
                
                // Compruebo que la letra está entre la A y la Z en mayúsculas, ya que antes hicimos un toUpperCase() y nos aseguramos de ello.
                if(caracterAscii < 65 || caracterAscii > 90)
                  comprobacionDni = false;
              }
            }
            
          } while (!comprobacionDni);
          
          // Solicitamos el sexo de la persona. Usamos una variable String auxiliar para luego pasar a char.
          String sexo;
          do {
            System.out.print("Introduce el sexo de la persona (H = Hombre, M = Mujer): ");
            sexo = sc.nextLine().toUpperCase();
            
            if(!sexo.equalsIgnoreCase("h") && !sexo.equalsIgnoreCase("m")) {
              System.out.println("El sexo introducido no es correcto. Por favor, inténtelo de nuevo.");
              
            } else if (sexo.equalsIgnoreCase("h")){
              persona.sexo = Persona.SEXO_HOMBRE;
              
            }else {
              persona.sexo = Persona.SEXO_MUJER;
            }
          }while(!sexo.equalsIgnoreCase("h") && !sexo.equalsIgnoreCase("m"));
         
          
          // Solicitamos el peso de la persona
          do {
            System.out.print("Introduce el peso de la persona (en kilogramos. Debe ser mayor que cero): ");
            persona.peso = Double.parseDouble(sc.nextLine());
            
            if(persona.peso <= 0)
              System.out.println("El peso introducido no es válido. Inténtelo de nuevo.");
            
          } while(persona.peso <= 0);

          
          // Solicitamos la altura de la persona
          do {
            System.out.print("Introduce la altura de la persona (en metros. Debe ser mayor que cero): ");
            persona.altura = Double.parseDouble(sc.nextLine());
            
            if(persona.altura <= 0)
              System.out.println("La altura introducida no es válida. Inténtelo de nuevo.");
            
          } while(persona.altura <= 0);
          
          
          // Imprimimos los resultados.
          
          System.out.println("Datos de la persona " + i);
          System.out.println("Nombre: " + persona.nombre);
          System.out.println("Edad: " + persona.edad);
          System.out.println("DNI: " + persona.dni);
          System.out.println("Sexo: " + persona.sexo);
          System.out.println("Peso: " + persona.peso);
          System.out.println("Altura: " + persona.altura);
        }
        

        
      } else {
        //Caso en el que no se ha metido un número de personas totales mayor que 0
        System.out.println("Lo sentimos, no podemos crear " + numeroDePersonas + " personas.");
      }
      
    } catch (NumberFormatException e) {
      System.out.println("Se ha introducido de forma incorrecta un dato numérico. Inténtelo de nuevo.");
    }
    
    
    
    sc.close();
    
    
    
  }

}
