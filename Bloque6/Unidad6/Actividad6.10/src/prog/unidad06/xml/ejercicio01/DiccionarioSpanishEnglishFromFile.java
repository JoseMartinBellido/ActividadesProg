package prog.unidad06.xml.ejercicio01;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Diccionario español-inglés que toma la información de traducción de un archivo XML
 */
public class DiccionarioSpanishEnglishFromFile {

  /**
   * Almacenamos el documento que se usará para acceder y buscar las traducciones
   */
  private Document documento;
  
  /**
   * Constructor de la clase
   * @param archivo Archivo XML en el que acceder al diccionario
   */
  public DiccionarioSpanishEnglishFromFile(String archivo) {
    try {
      DocumentBuilderFactory builder = DocumentBuilderFactory.newNSInstance();
      documento = builder.newDocumentBuilder().parse(archivo);
    } catch (SAXException | IOException | ParserConfigurationException e) {
      throw new DiccionarioSpanishEnglishException();
    }
  }
  
  /**
   * Método que obtiene la traducción de una palabra española en inglés
   * @param palabra Palabra en español
   * @return Palabra traducida al inglés, o null si no se encuentra
   */
  public String traducir(String palabraABuscar) {
    // Obtenemos la lista de palabras
    NodeList listaPalabras = documento.getElementsByTagName("palabra");
    // Buscamos la palabra concreta
    for (int i = 0; i < listaPalabras.getLength(); i++) {
      
      // Si el elemento extraído es del tipo Element
      if (listaPalabras.item(i).getNodeType() == Node.ELEMENT_NODE) {
        // Buscamos la palabra 
        Element palabra = (Element)listaPalabras.item(i);
        String palabraES = palabra.getElementsByTagName("español").item(0).getTextContent();
       // Si se encuentra, se devuelve su significado
        if (palabraES.equals(palabraABuscar)) {
          return  palabra.getElementsByTagName("ingles").item(0).getTextContent();
        } 
      }
    }
    // Si no se ha devuelto nada, se devuelve null
    return null;
  }
}
