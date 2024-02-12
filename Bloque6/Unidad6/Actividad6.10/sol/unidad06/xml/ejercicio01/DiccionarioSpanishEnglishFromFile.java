package unidad06.xml.ejercicio01;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Diccionario Español-inglés que toma la información de un archivo XML
 */
public class DiccionarioSpanishEnglishFromFile {
  
  // Atributos
  // Diccionario
  private Map<String, String> diccionario;

  /**
   * Crea un nuevo diccionario tomando la información del archivo XML proporcionado
   * @param archivo Archivo XML con la información del diccionario
   * @throws DiccionarioSpanishEnglishException Si no se puede obtener la información
   *   desde el archivo
   */
  public DiccionarioSpanishEnglishFromFile(String archivo) {
    // Intenta inicializar el diccionario desde el fichero
    iniciaDesdeFicheroXML(archivo);
  }
  
  /**
   * Obtiene la traducción de una palabra española
   * @param palabra Palabra en español (todo minúsculas)
   * @return Palabra correspondiente en inglés o null si no se encuentra la
   *   palabra en el diccionario
   */
  public String traducir(String palabra) {
    // Extrae la palabra desde el diccionario (o no, si no se encuentra)
    return diccionario.get(palabra);
  }
  
  /**
   * Inicia el diccionario desde el archivo XML especificado
   * @param archivo Archivo XML con la información del diccionario
   */
  private void iniciaDesdeFicheroXML(String archivo) {
    try {
      // Accedemos al Documento
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(archivo);
      // Obtenemos los elementos de tipo palabra
      NodeList palabras = documento.getElementsByTagName("palabra");
      // Iniciamos el mapa
      diccionario = new HashMap<>();
      // Para cada elemento del documento
      for (int i = 0; i < palabras.getLength(); i++) {
        Element palabra = (Element)palabras.item(i);
        // Obtenemos la palabra en español e ingles
        String palabraES = palabra.getElementsByTagName("español").item(0).getTextContent();
        String palabraEN = palabra.getElementsByTagName("ingles").item(0).getTextContent();
        diccionario.put(palabraES, palabraEN);
      }
    } catch (Exception e) {
      // Lanza nuestra excepcion
      throw new DiccionarioSpanishEnglishException();
    }
  }

}
