package prog.ud06.actividad611.proveedores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import prog.ud06.actividad611.coleccion.Cliente;
import prog.ud06.actividad611.coleccion.ProveedorUsuarios;
import prog.ud06.actividad611.coleccion.ProveedorUsuariosException;
import prog.ud06.actividad611.coleccion.TarjetaClaves;
import prog.ud06.actividad611.coleccion.Usuario;
import prog.ud06.actividad611.coleccion.Usuarios;

/**
 * Implementación de ProveedorUsuarios que obtiene la información
 * desde un archivo XML
 */
public class ProveedorUsuariosArchivoXML implements ProveedorUsuarios {

  // Atributos
  private String archivo;
  
  /**
   * Constructor
   * @param archivo Ruta al archivo XML que contiene la información de los usuarios
   */
  public ProveedorUsuariosArchivoXML(String archivo) {
    // Almacena la ruta al archivo
    this.archivo = archivo;
  }
  
  @Override
  public Usuarios obtieneUsuarios() throws ProveedorUsuariosException {
    // Creamos los usuarios vacíos
    Usuarios resultado = new Usuarios();
    try {
      // Obtenemos el DocumentBuilder
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      // Procesamos el documento
      Document documento = builder.parse(archivo);
      // Para cada usuario
      NodeList usuarios = documento.getElementsByTagName("usuario");
      // Para cada usuario
      for (int i = 0; i < usuarios.getLength(); i++) {
        Element usuario = (Element)usuarios.item(i);
        // Obtenemos el nombre de usuarios y nombre completo
        String nombreUsuario = usuario.getAttribute("id");
        String nombreCompleto = usuario.getAttribute("nombre");
        // A partir del nombre de usuario accedemos a la tarjeta
        TarjetaClaves tarjeta = leeTarjeta(documento, nombreUsuario);
        // Si la tarjeta es null
        if (tarjeta == null) {
          // Lanzamos excepcion
          throw new ProveedorUsuariosException();
        }
        // Leemos la lista de clientes
        List<Cliente> libros = leeClientes(documento, nombreUsuario);
        // Añadimos el usuario al repositorio
        resultado.addUsuario(new Usuario(nombreUsuario, nombreCompleto, tarjeta, libros));
      }
      return resultado;
    } catch (Exception e) {
      // Error accediendo al archivo. Lanza nuestra excepcion
      throw new ProveedorUsuariosException();
    }
  }

  /**
   * Lee los datos de tarjeta de un usuario
   * @param documento Documento XML
   * @param nombreUsuario Nombre de usuario del usuario del que se quiere leer la tarjeta
   * @return Tarjeta de claves si todo fue ok
   * @throws ProveedorUsuariosException Si ocurre algún error
   */
  private TarjetaClaves leeTarjeta(Document documento, String nombreUsuario) throws ProveedorUsuariosException {
    // Localizamos la tarjeta del usuario
    NodeList tarjetas = documento.getElementsByTagName("tarjeta");
    // Para cada elemento
    for (int i = 0; i < tarjetas.getLength(); i++) {
      // Accedemos al elemento
      Element tarjeta = (Element)tarjetas.item(i);
      // Si es la buscada
      if (tarjeta.getAttribute("usuario").equals(nombreUsuario)) {
        // la procesa y termina
        return procesaTarjeta(tarjeta);
      }
    }
    // Si se llega aqui es que la tarjeta no se ha localizado
    throw new ProveedorUsuariosException();
  }

  /**
   * Procesa la tarjeta de claves del usuario y la devuelve
   * @param tarjeta Elemento correspondiente a la tarjeta del usuario
   * @return Tarjeta de claves, si todo va ok
   * @throws ProveedorUsuariosException Si ocurre algún error
   */
  private TarjetaClaves procesaTarjeta(Element tarjeta) throws ProveedorUsuariosException {
    try {
      // Obtenemos las filas
      NodeList filas = tarjeta.getElementsByTagName("fila");
      int numFilas = filas.getLength();
      // Y el número de columnas
      Element fila = (Element)filas.item(0);
      NodeList columnas = fila.getElementsByTagName("celda");
      int numColumnas = columnas.getLength();
      // Creamos la tarjeta con el número de filas y columnas indicado
      TarjetaClaves tarjetaClaves = new TarjetaClaves(filas.getLength(), columnas.getLength());
      // Para cada fila
      for (int i = 0; i < numFilas; i++) {
        // Accedemos a las columnas
        fila = (Element)filas.item(i);
        columnas = fila.getElementsByTagName("celda");
        // Si el número de columnas es correcto
        if (columnas.getLength() == numColumnas) {
          // Para cada celda
          for (int j = 0; j < numColumnas; j++) {
            // Obtenemos el contenido y lo almacenamos en la tarjeta
            Element celda = (Element)columnas.item(j);
            tarjetaClaves.setClave(i + 1, j + 1, Integer.parseInt(celda.getTextContent()));
          }
        }
      }
      // Devolvemos la tarjeta de claves
      return tarjetaClaves;
    } catch (Exception e) {
      // En caso de excepción lanzamos la nuestra
      throw new ProveedorUsuariosException();
    }
  }

  /**
   * Lee la lista de clientes desde el elemento
   * @param documento Documento XML desde donde leer los clientes
   * @param nombreUsuario Nombre de usuario al que pertenecen los clientes a leer
   * @return Lista de clientes leidos (puede estar vacia)
   * @throws ProveedorUsuariosException Si ocurre algún error
   */
  private List<Cliente> leeClientes(Document documento, String nombreUsuario) throws ProveedorUsuariosException {
    try {
      // Creamos la  lista
      List<Cliente> libros = new ArrayList<>();
      // Para cada elemento cliente
      NodeList elementosCliente = documento.getElementsByTagName("cliente");
      for (int i = 0; i < elementosCliente.getLength(); i++) {
        Element elementoCliente = (Element)elementosCliente.item(i);
        // Si el usuario es nuestro usuario
        if (elementoCliente.getAttribute("usuario").equals(nombreUsuario)) {
          // Creamos el cliente con los datos
          String nombre = elementoCliente.getElementsByTagName("nombre").item(0).getTextContent();
          String apellidos = elementoCliente.getElementsByTagName("apellidos").item(0).getTextContent();
          String dni = elementoCliente.getElementsByTagName("dni").item(0).getTextContent();
          String edadCadena = elementoCliente.getElementsByTagName("edad").item(0).getTextContent();
          // Intenta convertir la edad a número. Si falla lanza ProveedorUsuariosException
          int edad = 0;
          try {
            edad = Integer.parseInt(edadCadena);
          } catch (NumberFormatException e) {
            throw new ProveedorUsuariosException();
          }
          // Crea el cliente y lo añade
          libros.add(new Cliente(nombre, apellidos, dni, edad));
        }
      }
      // Devuelve la lista de libros
      return libros;
    } catch (Exception e) {
      throw new ProveedorUsuariosException();
    }
  }

}
