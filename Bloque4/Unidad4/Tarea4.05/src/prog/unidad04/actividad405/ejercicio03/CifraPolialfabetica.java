package prog.unidad04.actividad405.ejercicio03;

/**
 * Clase que trabaja con un cifrado polialfabético dado
 * @author jose
 * @version 1.0
 */
public class CifraPolialfabetica implements Cifra{
  
  /**
   * Todas las letras minúsculas del alfabeto
   */
  private static final String CARACTERES_MINUSCULA = "abcdefghijklmnñopqrstuvwxyz";
  
  /**
   * Clave de letras usadas para cifrar
   */
  private String clave;
  
  public CifraPolialfabetica(String clave) {
    
    if (!compruebaClave(clave)) {
      throw new IllegalArgumentException();
    } else { 
      this.clave = clave;
    }
  }

  @Override
  public String cifra(String mensaje) {
    return cifraDescifra(mensaje, CARACTERES_MINUSCULA, clave);
  }

  @Override
  public String descifra(String mensaje) {
    return cifraDescifra(mensaje, clave, CARACTERES_MINUSCULA);
  }

  private String cifraDescifra(String texto, String ordenOriginal, String ordenNuevo) {
    String descifrado = "";
    
    // Por cada carácter, buscamos su posición en el alfabeto normal y luego sacamos la letra de la clave
    for (int i = 0; i < texto.length(); i++) {
      String letra = texto.substring(i,i+1);
      
      //Diferenciamos mayúsculas y espacios de minúsculas
      if (!ordenOriginal.contains(letra)) {
        descifrado += letra;
        
      } else {
        int NumLetraCifrada = ordenOriginal.indexOf(letra);
        char letraCifrada = ordenNuevo.charAt(NumLetraCifrada);
        descifrado += letraCifrada;
      }
    }
    return descifrado;
  }
  
  private boolean compruebaClave(String clave) {
    
    // Pueden ocurrir dos problemas distintos en la clave.
    // Problema 1: Faltan caracteres
    for (int i = 0; i < CARACTERES_MINUSCULA.length(); i++) {
      if (!clave.contains(CARACTERES_MINUSCULA.substring(i,i+1))) {
        return false;
      }
    }
    // Problema 2: Hay más caracteres de la cuenta
    if (clave.length() != CARACTERES_MINUSCULA.length()) {
      return false;
    }
    
    // Si llegamos aquí, está OK la clave
    return true;
  }
  
  

}
