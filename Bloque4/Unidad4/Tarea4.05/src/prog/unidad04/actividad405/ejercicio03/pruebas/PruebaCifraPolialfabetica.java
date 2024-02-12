package prog.unidad04.actividad405.ejercicio03.pruebas;

import prog.unidad04.actividad405.ejercicio03.Cifra;
import prog.unidad04.actividad405.ejercicio03.CifraCesar;
import prog.unidad04.actividad405.ejercicio03.CifraPolialfabetica;

/**
 * Prueba la cifra polialfabética
 */
public class PruebaCifraPolialfabetica {

  // Mensaje original
  private static final String MENSAJE = "hola caracola";
  private static final String CLAVE_TRIVIAL = "abcdefghijklmnñopqrstuvwxyz";
  private static final String CLAVE_CIFRA1IZQDA = "bcdefghijklmnñopqrstuvwxyza";
  private static final String MENSAJE_CIFRA1IZQDA = "ipmb dbsbdpmb";
  private static final String CLAVE_CIFRA1DCHA = "zabcdefghijklmnñopqrstuvwxy";
  private static final String MENSAJE_CIFRA1DCHA = "gñkz bzqzbñkz";
  private static final String CLAVE_CIFRARANDOM = "lpaueñkjdhcsivzyrfxotqwgbmn";
  private static final String MENSAJE_CIFRARANDOM = "jysl alxlaysl";
  
  public static void main(String[] args) {

    // Creamos una cifra trivial (clave = 0)
    System.out.println("Ciframos con clave trivial");
    Cifra cifra = new CifraPolialfabetica(CLAVE_TRIVIAL);
    // Ciframos y desciframos
    String mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    String mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado, el descifrado y el original deben ser iguales
    if ((mensajeCifrado.equals(mensajeDescifrado)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave trivial funciona");
    } else {
      System.out.println("Error probando la cifra con clave trivial");
    }
    
    // Creamos una cifra con clave 1 izquierda
    System.out.println("Ciframos con clave 1 a la izquierda");
    cifra = new CifraPolialfabetica(CLAVE_CIFRA1IZQDA);
    // Ciframos y desciframos
    mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado debe valer igual que el valor de prueba
    if ((mensajeCifrado.equals(MENSAJE_CIFRA1IZQDA)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave 1 izquierda funciona");
    } else {
      System.out.println("Error probando la cifra con clave 1 izquierda");
    }
    
    // Creamos una cifra con clave 1 derecha
    System.out.println("Ciframos con clave 1 derecha");
    cifra = new CifraPolialfabetica(CLAVE_CIFRA1DCHA);
    // Ciframos y desciframos
    mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado debe valer igual que el valor de prueba
    if ((mensajeCifrado.equals(MENSAJE_CIFRA1DCHA)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave 1 derecha funciona");
    } else {
      System.out.println("Error probando la cifra con clave 1 derecha");
    }
    
    // Creamos una cifra con clave aleatoria
    System.out.println("Ciframos con clave aleatoria");
    cifra = new CifraPolialfabetica(CLAVE_CIFRARANDOM);
    // Ciframos y desciframos
    mensajeCifrado = cifra.cifra(MENSAJE);
    System.out.println("Mensaje cifrado: " + mensajeCifrado);
    mensajeDescifrado = cifra.descifra(mensajeCifrado);
    System.out.println("Mensaje descifrado " + mensajeDescifrado);
    
    // El mensaje cifrado debe valer igual que el valor de prueba
    if ((mensajeCifrado.equals(MENSAJE_CIFRARANDOM)) && (mensajeDescifrado.equals(MENSAJE))) {
      // Todo OK
      System.out.println("Prueba cifra con clave aleatoria funciona");
    } else {
      System.out.println("Error probando la cifra con clave aleatoria");
    }
    
    // Probamos crear la cifra con clave vacia
    try {
      System.out.println("Probando a crear una cifra con una clave vacia");
      Cifra cifraMala = new CifraPolialfabetica("");
      System.out.println("Error. Se ha permitido crear una cifra con una clave vacía");
    } catch (IllegalArgumentException e) {
      System.out.println("Ok. Se ha prohibido el crear una cifra con una clave vacía");
    }

    // Probamos crear la cifra con clave que falta una letra
    try {
      System.out.println("Probando a crear una cifra con una clave con una letra menos");
      Cifra cifraMala = new CifraPolialfabetica("abcdefghijklmnñopqrstuwxyz");
      System.out.println("Error. Se ha permitido crear una cifra con una clave con una letra menos");
    } catch (IllegalArgumentException e) {
      System.out.println("Ok. Se ha prohibido el crear una cifra con una clave con una letra menos");
    }

    // Probamos crear la cifra con clave que sobra una letra
    try {
      System.out.println("Probando a crear una cifra con una clave con una letra mas");
      Cifra cifraMala = new CifraPolialfabetica("abcdefghijklmnñopqrstuvwxyzz");
      System.out.println("Error. Se ha permitido crear una cifra con una clave con una letra mas");
    } catch (IllegalArgumentException e) {
      System.out.println("Ok. Se ha prohibido el crear una cifra con una clave con una letra mas");
    }


    // Probamos crear la cifra con clave con letra duplicada
    try {
      System.out.println("Probando a crear una cifra con una clave con una letra duplicada");
      Cifra cifraMala = new CifraPolialfabetica("aacdefghijklmnñopqrstuvwxyz");
      System.out.println("Error. Se ha permitido crear una cifra con una clave con una letra duplicada");
    } catch (IllegalArgumentException e) {
      System.out.println("Ok. Se ha prohibido el crear una cifra con una clave con una letra duplicada");
    }

  }

}
