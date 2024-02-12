package prog.unidad06.xml.ejercicio03;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Clase que extrae los títulos (título principal y títulos de los capítulos) del libro Don Quijote de la Mancha
 */
public class ExtraeTitulos {

  /**
   * Documento a partir de los cuales obtendremos la información
   */
  private Document documento;
  
  /**
   * Número del último capítulo impreso
   */
  private static int capitulo = 0;
  
  /**
   * Constructor de la clase
   * @param archivo archivo del cual se obtiene el texto del libro
   */
  private ExtraeTitulos(String archivo) {
    try {
      documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(archivo);
    } catch (SAXException e) {
      System.out.println("Problema en el procesado del archivo XML. Documento XML con formato incorrecto.");
    } catch (IOException e) {
      System.out.println("Fallo en la lectura del archivo");
    } catch (ParserConfigurationException e) {
      System.out.println("Fallo en la configuración del parser");
    }
  }
  
  /**
   * Clase main
   * @param args
   */
  public static void main(String[] args) {  
    try {
      // Parte 1
      System.out.println("PARTE 1: ");
      ExtraeTitulos extraeParte1 = new ExtraeTitulos("parte1.html");
      extraeParte1.run();
      // Parte 2
      System.out.println("\nPARTE 2: ");
      ExtraeTitulos extraeParte2 = new ExtraeTitulos("parte2.html");
      extraeParte2.run();
      
    // Caso en el que alguno de los documentos tiene 2 o más títulos principales
    } catch (ExtraeTitulosException e) {
      System.out.println("Alguno de los documentos tiene un formato erróneo.");
    }

  }
  
  /**
   * Clase ejecutada en el método main que realiza todas las búsquedas e impresiones de ambas partes de los libros
   */
  private void run() {
    // Se imprime el título principal 
    System.out.println("Título: " + buscaTituloPrincipal());
    // Se imprimen los títulos de los capítulos. Si no hay capítulos, no se imprimirá nada
    NodeList capitulos = buscaCapitulos();
    for (int i = 0; i < capitulos.getLength(); i++) {
      capitulo++;
      System.out.println("Capítulo " + capitulo + ": " + capitulos.item(i).getTextContent());
    }
  }

  /**
   * Método que busca el título principal del documento xhtml y lo imprime por pantalla
   * @return El título principal del documento xhtml
   * @throws ExtraeTitulosException En caso de haber más de un título en el documento
   */
  private String buscaTituloPrincipal() {
    // Lista de nodos, por si hubiese más de un título (cosa que no debería haber) en el html
    NodeList listaTitulos = documento.getElementsByTagName("title");
    // Si no hay título, se avisa de que no existe
    if (listaTitulos.getLength() == 0) {
      return "Documento sin título";
    // Si hay 1 título principal, se devuelve
    } else if (listaTitulos.getLength() == 1){
      return listaTitulos.item(0).getTextContent();
    // En caso de que haya 2 o más títulos, hay un error en el documento. Se lanza un error
    } else {
      throw new ExtraeTitulosException();
    }

  }
  
  /**
   * Método que devuelve una NodeList con todos los capítulos del documento
   * @return Una NodeList con todos los capítulos del documento
   */
  private NodeList buscaCapitulos() {
    // Lista de nodos con los títulos de los capítulos (h3)
    return documento.getElementsByTagName("h3");
  }
}
