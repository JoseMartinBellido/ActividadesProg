package prog.unidad06.mapas.ejercicio01;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Clase que simula un diccionario español - inglés, donde se introduce una palabra en español para obtener
 * la traducción
 * @author Jose
 *
 */
public class DiccionarioSpanishEnglish {

  /**
   * Diccionario de palabras español-inglés
   */
  private Map<String, String> diccionario;
  
  /**
   * Constructor de la clase, que inicializa un diccionario
   */
  public DiccionarioSpanishEnglish() {
    // TreeMap por el orden alfabético de un diccionario
    diccionario = new TreeMap<>();
    // Inserción de las palabras
    diccionario.put("girar", "spin");
    diccionario.put("sorpresa", "surprise");
    diccionario.put("maceta", "pot");
    diccionario.put("historiador", "historian");
    diccionario.put("enjuagar", "rinse");
    diccionario.put("casilla", "square");
    diccionario.put("signo", "sign");
    diccionario.put("importar", "import");
    diccionario.put("profesional", "professional");
    diccionario.put("ficha", "piece");
    diccionario.put("patines", "skates");
    diccionario.put("historia", "history");
    diccionario.put("tornillo", "screw");
    diccionario.put("cantante", "singer");
    diccionario.put("insulto", "insult");
    diccionario.put("firma", "sign");
    diccionario.put("lechuga", "lettuce");
    diccionario.put("tiza", "chalk");
    diccionario.put("adoptar", "adopt");
    diccionario.put("pila", "battery");
    diccionario.put("ciudad", "city");
    diccionario.put("rail", "rail");
    diccionario.put("frontera", "border");
    diccionario.put("prisionero", "prisoner");
    diccionario.put("capullo", "cocoon");
    diccionario.put("anchoa", "anchovy");
    diccionario.put("opinión", "opinion");
    diccionario.put("pierna", "leg");
    diccionario.put("hábito", "habit");
    diccionario.put("hueso", "bone");
    
  }

  /**
   * Método que obtiene el conjunto de palabras en español del diccionario
   * @return El conjunto de palabras en español del diccionario
   */
  public Set<String> getPalabrasSpanish() {
    return diccionario.keySet();
  }
  
  /**
   * Busca la traducción de una palabra en el diccionario
   * @param palabra Palabra en español a traducir al inglés. Debe ser no nula y en minúsculas
   * @return La traducción en inglés de la palabra introducida, o null si no se encuentra
   * @throws IllegalArgumentException En caso de que la palabra sea null
   */
  public String traducir(String palabra) {
    // Si la palabra no es null, buscamos su traducción
    if (palabra != null) {
      return diccionario.get(palabra);
    // Si es null, se lanza el error
    } else {
      throw new IllegalArgumentException();
    }
  }
}
