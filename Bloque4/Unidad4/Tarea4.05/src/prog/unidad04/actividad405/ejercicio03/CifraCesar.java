package prog.unidad04.actividad405.ejercicio03;

/**
 * Clase que trabaja con un cifrado César
 * @author jose
 * @version 1.0
 */
public class CifraCesar implements Cifra{

  /**
   * Cadena de caracteres con todas las letras minúsculas para recorrerlo
   */
  private static final String CARACTERES_MINUSCULA = "abcdefghijklmnñopqrstuvwxyz";
  
  /**
   * Número de caracteres para la clave a partir de la cual comienza de nuevo el bucle de letras
   */
  private static final int NUMERO_CARACTERES = 27;
  
  /**
   * Número que indica la clave a usar
   */
  private int clave;
  
  /**
   * Constructor
   * @param clave Clave de cifrado. Debe valer entre -27 y 27, ambos incluidos
   * @throws IllegalArgumentException Si el valor de la clave proporcionado está fuera de rango.
   */
  public CifraCesar(int clave) { 
    if (clave < -NUMERO_CARACTERES || clave > NUMERO_CARACTERES) {
      throw new IllegalArgumentException();
    } else {
      this.clave = clave;
    }
  }
  
  @Override
  public String cifra(String mensaje) {
    
    String cifrado = "";
    
    for (int i = 0; i < mensaje.length(); i++) {
      // Trato la letra como substring para poder usar funciones de String con ella más adelante. 
      // Otra opción es letra = "" + mensaje.charAt(i)
      String letra = mensaje.substring(i,i+1);
      
      // Para cifrar el mensaje, las mayúsculas, espacios y símbolos quedan como están y la minúscula varía según la clave 
      if (!CARACTERES_MINUSCULA.contains(letra)) {
        cifrado += letra;
      
      } else {
        // Buscamos el número que corresponde a la letra minúscula
        int numAsignado = CARACTERES_MINUSCULA.indexOf(letra);
        
        //Le sumamos el número clave, pero puede pasar que sea menor que cero. Contemplamos los casos 
        numAsignado = (numAsignado + clave < 0)? (numAsignado + clave + NUMERO_CARACTERES) % NUMERO_CARACTERES 
                                                 : (numAsignado + clave) % NUMERO_CARACTERES ;
        // Sacamos el caracter y lo añadimos al String final
        letra = CARACTERES_MINUSCULA.substring(numAsignado,numAsignado+1);
        cifrado += letra;        
      }      
    }   
    return cifrado;
  }

  @Override
  public String descifra(String mensaje) {
    CifraCesar descifrado = new CifraCesar(-clave);
    return descifrado.cifra(mensaje);
    
  }
  
  /*
  @Override
  public String descifra(String mensaje) {
    
    String descifrado = "";
    
    for (int i = 0; i < mensaje.length(); i++) {
      // Trato la letra como substring para poder usar funciones de String con ella más adelante. 
      // Otra opción es letra = "" + mensaje.charAt(i)
      String letra = mensaje.substring(i,i+1);
      
      // Para cifrar el mensaje, las mayúsculas, espacios y símbolos quedan como están y la minúscula varía según la clave 
      if (!CARACTERES_MINUSCULA.contains(letra)) {
        descifrado += letra;
      
      } else {
        // Buscamos el número que corresponde a la letra minúscula
        int numAsignado = CARACTERES_MINUSCULA.indexOf(letra);
        
        //Le restamos el número clave, pero puede pasar que sea menor que cero. Contemplamos los casos 
        numAsignado = (numAsignado - clave < 0)? (numAsignado - clave + NUMERO_CARACTERES) % NUMERO_CARACTERES 
                                                 : (numAsignado - clave) % NUMERO_CARACTERES ;       
        // Sacamos el caracter y lo añadimos al String final
        letra = CARACTERES_MINUSCULA.substring(numAsignado,numAsignado+1);
        descifrado += letra;        
      }      
    }   
    return descifrado;
  }*/
}



