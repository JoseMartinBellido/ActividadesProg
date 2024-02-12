package unidad06.xml.ejercicio03;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Extrae titulos desde un archivo HTML
 */
public class ExtraeTitulos {

  private static final String ARCHIVO_HTML = "parte1.html";
  
  public static void main(String[] args) {
    try {
      // Accedemos al Documento
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(ARCHIVO_HTML);
      // Obtenemos el titulo
      Element titulo = (Element)documento.getElementsByTagName("title").item(0);
      System.out.println("Titulo: " + titulo.getTextContent());
      
      // Accedemos a los títulos de los capítulos
      NodeList capitulos = documento.getElementsByTagName("h3");

      // Contador de capitulo
      int numeroCapitulo = 1;
      // Para cada capitulo del documento
      for (int i = 0; i < capitulos.getLength(); i++) {
        Element capitulo = (Element)capitulos.item(i);
        // Imprimimos el texto del titulo
        System.out.println("Capitulo " + numeroCapitulo + ": " + capitulo.getTextContent());
        numeroCapitulo++;
      }
    } catch (Exception e) {
      // Error
      System.out.println("Error accediendo al fichero XML: " + e.getMessage());
    }
    
  }

}
