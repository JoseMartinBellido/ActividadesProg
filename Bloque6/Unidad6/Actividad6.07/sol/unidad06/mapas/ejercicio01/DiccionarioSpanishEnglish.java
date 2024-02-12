package unidad06.mapas.ejercicio01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Diccionario Español - Inglés
 */
public class DiccionarioSpanishEnglish {

  // Diccionario
  private Map<String, String> diccionario;
  
  /**
   * Constructor
   */
  public DiccionarioSpanishEnglish() {
    // Crea el diccionario e introduce las palabras
    diccionario = new HashMap<>();
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
   * Busca la traducción de una palabra en el diccionario
   * @param palabra Palabra a traducir. No puede ser null y debe estar todo en minúsculas
   * @return Traducción de la palabra dada, si se encuentra. null si no se
   *   encuentra
   * @throws IllegalArgumentException Si palabra es null
   */
  public String traducir(String palabra) {
    if (palabra != null) {
      return diccionario.get(palabra);
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Obtiene las palabras que contiene el diccionario
   * @return Palabras que contiene el diccionario
   */
  public Set<String> getPalabrasSpanish() {
    return diccionario.keySet();
  }
}
