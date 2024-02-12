package prog.unidad04.practica406.principal;

import java.time.LocalDate;
import java.util.Scanner;

import prog.unidad04.practica406.libreria.Automovil;
import prog.unidad04.practica406.libreria.ConvertibleATexto;
import prog.unidad04.practica406.libreria.Fecha;
import prog.unidad04.practica406.libreria.Motocicleta;
import prog.unidad04.practica406.libreria.Vehiculo;

/**
 * Clase principal de la aplicación que trabaja con vehículos. Solicita los datos necesarios para la creación de un automóvil y una motocicleta,
 * e imprime una serie de datos sobre ambos.
 */
public class VehiculosApp {
  
  public static final String MENSAJE_ERROR_GENERICO = "No se pudo crear el automóvil. Revise los datos para comprobar que todos son correctos";
  public static final String MENSAJE_ERROR_FECHA = "La fecha no es una fecha válida. Revise los valores e inténtelo de nuevo";

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    System.out.println("PRÁCTICA DE JOSÉ MARTÍN BELLIDO. GESTIÓN DE VEHÍCULOS.");
    
    // Variable que comprueba la validez de los datos para crear el vehículo
    boolean creacionOk = false;
    
    // Variables para la creación de vehículos. Se reutilizarán entre el automóvil y la motocicleta.
    String matricula;
    int diaFechaMatriculacion;
    int mesFechaMatriculacion;
    int anyoFechaMatriculacion;
    Fecha fechaMatriculacionAuto = null;
    Fecha fechaMatriculacionMoto = null;
    
    // Variables para automóvil y motocicleta
    String colorAutomovil;
    int numPlazasAutomovil;
    int cilindradaMotocicleta;
    
    // Variables automovil y motocicleta.
    Automovil automovil = null;
    Motocicleta motocicleta = null;
    
    // Fecha de hoy
    LocalDate hoyLocalDate = LocalDate.now();
    Fecha hoy = new Fecha(hoyLocalDate.getDayOfMonth(), hoyLocalDate.getMonthValue(), hoyLocalDate.getYear());
    
    // Creación del automóvil. Si la creación es errónea (false) repetimos el bucle.
    while (!creacionOk) {
      
      // Establecemos la fecha de matriculación como null en caso de que estemos en una vuelta del bucle iniciado
      fechaMatriculacionAuto = null;
      
      // Solicitamos la matrícula
      System.out.print("\nIntroduce la matrícula del automóvil (4 números, 0 ó más espacios y tres letras mayúsculas): ");
      matricula = sc.nextLine();
      
      try {
        
        // Solicitamos los datos para la fecha
        System.out.print("Introduzca el día de la fecha de matriculación del automóvil: ");
        diaFechaMatriculacion = Integer.parseInt(sc.nextLine());
        
        System.out.print("Introduzca el mes de la fecha de matriculación del automóvil: ");
        mesFechaMatriculacion = Integer.parseInt(sc.nextLine());
        
        System.out.print("Introduzca el año de la fecha de matriculación del automóvil: ");
        anyoFechaMatriculacion = Integer.parseInt(sc.nextLine());
        
        // Creamos la fecha y comprobamos que no es posterior a hoy. Si lo es, reiniciamos la fecha
        fechaMatriculacionAuto = new Fecha(diaFechaMatriculacion, mesFechaMatriculacion, anyoFechaMatriculacion);
        
        if (fechaMatriculacionAuto.compara(hoy) == 1) {
          // Si no es anterior a hoy, reiniciamos la fecha a null
          fechaMatriculacionAuto = null;
          throw new IllegalArgumentException();
        }
        
      // Si el error es de inserción de Fecha, se avisa al usuario 
      } catch (IllegalArgumentException e) {
        System.out.println("La fecha no es una fecha válida. Revise los valores e inténtelo de nuevo");
      }
      
      // Entramos en la segunda parte de la petición de datos
      try {
        // Solicitamos el color del automóvil
        System.out.print("Introduzca el color del automóvil (blanco, negro o azul): ");
        colorAutomovil = sc.nextLine();

        // Solicitamos el número de plazas del automóvil
        System.out.print("Introduzca el número de plazas del vehículo (1 ó mas): ");
        numPlazasAutomovil = Integer.parseInt(sc.nextLine());

        // Creamos el automóvil
        automovil = new Automovil(matricula, fechaMatriculacionAuto, colorAutomovil, numPlazasAutomovil);
        
        // Si llegados hasta aquí no hay ningún error, se ha creado el automóvil.
        creacionOk = true;
        
        // NumberFormatException hereda directamente de IllegalArgumentException, con lo que no es necesario hacer un catch de ambos
        // En ambos casos, sigue siendo un error al introducir parámetros, con lo que el resultado es el mismo
      } catch (IllegalArgumentException e) {

        System.out.println("No se pudo crear el automóvil. Revise los datos para comprobar que todos son correctos");
      }
    }
    
    // Reseteamos creacionOk para realizar el bucle para la motocicleta
    creacionOk = false;
    
    // Creación de la motocicleta
    while (!creacionOk) {
      
      // Establecemos la fecha de matriculación como null en caso de que estemos en una vuelta del bucle iniciado
      fechaMatriculacionMoto = null;
      
      // Solicitamos la matrícula
      System.out.print("\nIntroduce la matrícula de la motocicleta (4 números, 0 ó más espacios y tres letras mayúsculas): ");
      matricula = sc.nextLine();
      
      try {
        
        // Solicitamos los datos para la fecha
        System.out.print("Introduzca el día de la fecha de matriculación de la motocicleta: ");
        diaFechaMatriculacion = Integer.parseInt(sc.nextLine());
        
        System.out.print("Introduzca el mes de la fecha de matriculación de la motocicleta: ");
        mesFechaMatriculacion = Integer.parseInt(sc.nextLine());
        
        System.out.print("Introduzca el año de la fecha de matriculación de la motocicleta: ");
        anyoFechaMatriculacion = Integer.parseInt(sc.nextLine());

        // Creamos la fecha y comprobamos que no es posterior a hoy. Si lo es, reiniciamos la fecha
        fechaMatriculacionMoto = new Fecha(diaFechaMatriculacion, mesFechaMatriculacion, anyoFechaMatriculacion);
       
        // Si la fecha de matriculación es posterior a hoy
        if (fechaMatriculacionMoto.compara(hoy) == 1) {

          fechaMatriculacionMoto = null;
          throw new IllegalArgumentException();
        }

        }catch (IllegalArgumentException e) {
          // Si el error es de inserción de Fecha, se avisa al usuario 
          System.out.println("La fecha no es una fecha válida. Revise los valores e inténtelo de nuevo");
        }
        
        try {
        // Solicitamos la cilindrada de la motocicleta
        System.out.print("Introduzca la cilindrada de la motocicleta (50 ó mas): ");
        cilindradaMotocicleta = Integer.parseInt(sc.nextLine());
        
        // Creamos la motocicleta
        motocicleta = new Motocicleta(matricula, fechaMatriculacionMoto, cilindradaMotocicleta);
        
        // Si llegados hasta aquí no hay ningún error, se ha creado el automóvil.
        creacionOk = true;
        
      } catch (IllegalArgumentException e) {
        // Error en el resto de parámetros que no sean de la fecha
        System.out.println("No se pudo crear la motocicleta. Revise los datos para comprobar que todos son correctos"); 
      } 
    }    
    
    // En este punto, están creados el automóvil y la motocicleta. Imprimimos los datos de ambos.
    System.out.println();
    
    imprimeDatos(automovil);
    imprimeDatos(motocicleta);
    
    // Comprobamos si alguno de los dos vehículos se matriculó en un año bisiesto. Si es así, lo informamos
    if (fechaMatriculacionAuto.esBisiesto()) {          
      System.out.println("El automóvil se matriculó en el año bisiesto " + fechaMatriculacionAuto.getAnyo());
    }
    
    if (fechaMatriculacionMoto.esBisiesto()) {      
      System.out.println("La motocicleta se matriculó en el año bisiesto " + fechaMatriculacionMoto.getAnyo());
    }
    
    // Calculamos la cantidad de días que lleva matriculado cada vehículo e imprimimos  
    System.out.println(getDiasMatriculado(automovil));
    System.out.println(getDiasMatriculado(motocicleta));
    
    // Comprobamos qué vehículo se matriculó primero y lo imprimimos
    if (fechaMatriculacionAuto.compara(fechaMatriculacionMoto) == -1) {
      System.out.println("El automóvil se matriculó antes que la motocicleta.");
      
    } else if (fechaMatriculacionAuto.compara(fechaMatriculacionMoto) == 1) {
      System.out.println("El automóvil se matriculó después que la motocicleta.");
      
    } else {
      System.out.println("El automóvil y la motocicleta se matricularon el mismo día.");
    }
    
    // Número de vehículos matriculados
    System.out.println("\nNúmero de vehículos matriculados: " + Vehiculo.getVehiculosMatriculados());
    
    sc.close();
  }
   
  /**
   * Método que imprime los datos de cualquier objeto que implemente la interfaz ConvertibleATexto
   * @param objeto Objeto del interfaz ConvertibleATexto del cual se quieren imprimir los datos
   */
  private static void imprimeDatos(ConvertibleATexto objeto) {
    
    // Dependiendo de si el objeto es del tipo automóvil, motocicleta o fecha (clases que implementan la interfaz ConvertibleATexto)
    // imprimiremos unos datos u otros
    if (objeto instanceof Automovil) {
      
      Automovil automovil = (Automovil) objeto;
      System.out.print("Datos de Automóvil: ");
      System.out.println(automovil.aTexto());
      
    } else if (objeto instanceof Motocicleta) {
      
      Motocicleta motocicleta = (Motocicleta) objeto;
      System.out.print("Datos de Motocicleta: ");
      System.out.println(motocicleta.aTexto());
          
    } else if (objeto instanceof Fecha) {
      
      Fecha fecha = (Fecha) objeto;
      System.out.print("Datos de Fecha: ");
      System.out.println(fecha.aTexto());
      
    } else {
      
      System.out.println("El objeto del cual se están intentando imprimir los datos no es del tipo adecuado.");
    }
    
  }
  
  /**
   * Método que devuelve de forma genérica para cualquier vehículo los días que lleva matriculado o cuánto tiempo falta para su matriculación
   * @param Vehiculo vehículo sobre el que se desea saber la fecha de matriculación
   * @return Un texto que indica la cantidad de días que lleva matriculado un vehículo o cuanto falta para su matriculación
   */
  private static String getDiasMatriculado(Vehiculo vehiculo) {
    // Fecha actual
    LocalDate hoyLocalDate = LocalDate.now();
    Fecha hoy = new Fecha(hoyLocalDate.getDayOfMonth(), hoyLocalDate.getMonthValue(), hoyLocalDate.getYear());
    
    // Fecha de matriculación del vehículo
    Fecha fechaMatriculacion = vehiculo.getFechaMatriculacion();
    
    // Texto inicial de impresión de resultados
    String textoInicial = "";
    
    if (vehiculo instanceof Automovil) {
      textoInicial = "El automóvil lleva matriculado "; 
    } else if (vehiculo instanceof Motocicleta) {
      textoInicial = "La motocicleta lleva matriculada ";
    } else {
      textoInicial = "El vehículo lleva matriculado ";
    }
    
    // Calculamos los días transcurridos y obtenemos el resultado
    long diasTranscurridos = fechaMatriculacion.diasEntre(hoy);

    return textoInicial + diasTranscurridos + " días";
    
  }

}
