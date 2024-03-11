package prog.unidad05.ficheros.ejercicio05;

import java.util.Set;

/**
 * Interfaz que implementa toda clase cuya función principal sea la gestión de discos en un sistema
 * de almacenamiento.
 */
public interface GestionaDiscos {

  /**
   * Método que lee discos desde un sistema de almacenamiento permanente.
   * @return Un conjunto de discos ya formados, leídos de una estructura de almacenamiento
   */
  Set<Disco> leeDiscos();
  
  /**
   * Método que guarda los discos en un sistema de almacenamiento permanente
   * @param discos Almacén de discos que guardar en dicho sistema de almacenamiento
   */
  void guardaDiscos(Set<Disco> discos);
  
}
