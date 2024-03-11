package prog.unidad05.ficheros.ejercicio05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase de gestión de discos cuyo sistema de almacenamiento es un fichero permanente del ordenador
 */
public class GestionaDiscosFichero implements GestionaDiscos{

  /**
   * Ruta del fichero de almacenamiento
   */
  private String rutaFichero;
  
  /**
   * Constructor de la clase que establece la ruta al fichero
   * @param rutaFichero Ruta del fichero de almacenamiento
   */
  public GestionaDiscosFichero(String rutaFichero) {
    this.rutaFichero = rutaFichero;
  }
  
  @Override
  public Set<Disco> leeDiscos() {
    
    int objetos = -1;
    
    Set<Disco> discos = new LinkedHashSet<>();
    
    // Se crea el flujo de entrada de datos
    try (DataInputStream flujoEntrada = new DataInputStream(new FileInputStream(rutaFichero))){
      
     objetos = flujoEntrada.readInt(); 
     
     // Si el programa sigue, significa que hay algo escrito y hay objetos en su interior
     System.out.printf("Listado de discos (%d)%n", objetos);
     
     for (int i = 0; i < objetos; i++) {
       // Se obtiene la información y se crea el disco
       Disco disco = leeDisco(flujoEntrada);
       
       discos.add(disco);
       // Se imprime el disco
       System.out.println(disco.aCadena());
     }
     
    } catch (IllegalArgumentException e) {
      System.out.println("Alguno de los parámetros leídos de los discos es erróneo");
    
    } catch (FileNotFoundException e) {
      System.out.println("La colección de discos está vacía");
      
    } catch (EOFException e) {
      System.out.println("Error de lectura de datos");
      
    } catch (IOException e) {
      System.out.println("Error en la lectura del archivo");
    }
    
    return discos;

  }

  @Override
  public void guardaDiscos(Set<Disco> discos) {

    // Cantidad de objetos a almacenar 
    int objetos = discos.size();
    
    // Creamos el flujo de datos
    try (DataOutputStream flujoSalida = new DataOutputStream(new FileOutputStream(rutaFichero))) {
      // Insertamos como primer dato la cantidad de objetos
      flujoSalida.writeInt(objetos);
      
      // Se recorre el conjunto de discos y se guardan en el fichero
      for (Disco disco : discos) {
        flujoSalida.writeUTF(disco.getTitulo());
        flujoSalida.writeUTF(disco.getArtista());
        flujoSalida.writeInt(disco.getAnyoPublicacion());
        flujoSalida.writeDouble(disco.getPrecio());
        flujoSalida.writeBoolean(disco.estaPublicadoCD());
        
      } 
    } catch (FileNotFoundException e) {
      System.out.println("Error en la ruta del archivo. Ruta indicada no válida."); 
    } catch (IOException e) {
     System.out.println("Error de escritura del archivo.");
    }
    
  }
  
  /**
   * Método que lee un disco completo de un fichero y lo genera
   * @param flujoEntrada Flujo de entrada de datos
   * @return El disco ya creado con los datos obtenidos del flujo de entrada
   * @throws IOException En caso de que haya algún problema en la lectura del fichero
   */
  private Disco leeDisco(DataInputStream flujoEntrada) throws IOException {
    
    // Se extrae la información por cada objeto
    String titulo = flujoEntrada.readUTF();
    String autor = flujoEntrada.readUTF();
    int anyoPublicacion = flujoEntrada.readInt();
    double precio = flujoEntrada.readDouble();
    boolean estaPublicadoCD = flujoEntrada.readBoolean();
    
    // Se crea el disco
    return new Disco(titulo, autor, anyoPublicacion, precio, estaPublicadoCD);
    
  }

  
}
