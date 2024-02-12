package prog.unidad04.actividad405.ejercicio03.pruebas;

import prog.unidad04.actividad405.ejercicio03.Cifra;
import prog.unidad04.actividad405.ejercicio03.CifraCesar;

/**
 * Prueba la cifra cesar
 */
public class PruebaCifraCesar {

  // Mensaje original
  private static final String MENSAJE = "hola caracola";
  private static final String MENSAJE_CIFRA1 = "ipmb dbsbdpmb";
  private static final String MENSAJE_CIFRAMENOS1 = "gñkz bzqzbñkz";
  private static final String MENSAJE_CIFRA10 = "qyuk mkbkmyuk";
  private static final String MENSAJE_CIFRAMENOS10 = "xfbq sqiqsfbq";
  
  public static void main(String[] args) {

    // Creamos una cifra trivial (clave = 0)
    System.out.println("Ciframos con clave 0");
    Cifra cifra = new CifraCesar(0);
    // Ciframos y desciframos
    String mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    String mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado, el descifrado y el original deben ser iguales
    if ((mensajeCifrado.equals(mensajeDescifrado)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave 0 funciona");
    } else {
      System.out.println("Error probando la cifra con clave 0");
    }
    
    // Creamos una cifra con clave 1
    System.out.println("Ciframos con clave 1");
    cifra = new CifraCesar(1);
    // Ciframos y desciframos
    mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado debe valer igual que el valor de prueba
    if ((mensajeCifrado.equals(MENSAJE_CIFRA1)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave 1 funciona");
    } else {
      System.out.println("Error probando la cifra con clave 1");
    }
    
    // Creamos una cifra con clave -1
    System.out.println("Ciframos con clave -1");
    cifra = new CifraCesar(-1);
    // Ciframos y desciframos
    mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado debe valer igual que el valor de prueba
    if ((mensajeCifrado.equals(MENSAJE_CIFRAMENOS1)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave -1 funciona");
    } else {
      System.out.println("Error probando la cifra con clave -1");
    }
    
    // Creamos una cifra con clave 10
    System.out.println("Ciframos con clave 10");
    cifra = new CifraCesar(10);
    // Ciframos y desciframos
    mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado debe valer igual que el valor de prueba
    if ((mensajeCifrado.equals(MENSAJE_CIFRA10)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave 10 funciona");
    } else {
      System.out.println("Error probando la cifra con clave 10");
    }
    
    // Creamos una cifra con clave -10
    System.out.println("Ciframos con clave -10");
    cifra = new CifraCesar(-10);
    // Ciframos y desciframos
    mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado debe valer igual que el valor de prueba
    if ((mensajeCifrado.equals(MENSAJE_CIFRAMENOS10)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave -10 funciona");
    } else {
      System.out.println("Error probando la cifra con clave -10");
    }
    
    // Probamos crear la cifra con clave inválida
    try {
      System.out.println("Probando a crear una cifra con una clave inválida");
      Cifra cifraMala = new CifraCesar(-50);
      System.out.println("Error. Se ha permitido crear una cifra con una clave inválida");
    } catch (IllegalArgumentException e) {
      System.out.println("Ok. Se ha prohibido el crear una cifra con una clave inválida");
    }
  }
}
