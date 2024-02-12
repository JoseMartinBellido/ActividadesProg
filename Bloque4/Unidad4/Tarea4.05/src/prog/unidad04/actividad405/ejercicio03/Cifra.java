package prog.unidad04.actividad405.ejercicio03;

/**
 * Interfaz que define el proceso de cifrado y descifrado
 */
public interface Cifra {

  /**
   * Cifra un mensaje dado siguiendo un algoritmo concreto
   * @param mensaje Mensaje a cifrar
   * @return El mensaje ya cifrado
   */
  String cifra(String mensaje);
  
  /**
   * Descifra un mensaje dado siguiendo un algoritmo concreto
   * @param mensaje Mensaje a descifrar
   * @return El mensaje ya descifrado
   */
  String descifra(String mensajeCifrado);
  
}
