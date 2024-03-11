import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class PruebasArchivos {

  @Test
  void compruebaPDF() throws IOException {
    assertEquals(-1L, Files.mismatch(Path.of("copia-fichero.pdf"), 
        Path.of("actividad503f.pdf")));
  }
  
  @Test
  void compruebaSalidaTxt() throws IOException {
    assertEquals(-1L, Files.mismatch(Path.of("fichero-cremallera.txt")
        , Path.of("actividad503c_prueba_salida.txt")));
  }
  
  @Test
  void compruebaSalidaBin() throws IOException {
    assertEquals(-1L, Files.mismatch(Path.of("fichero-cremallera-binario.bin")
        , Path.of("actividad503i_prueba_salida.bin")));
  }

}
