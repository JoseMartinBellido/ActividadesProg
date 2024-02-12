package prog.unidad06.re.ejercicio01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PruebaUsuario {

  @Test
  void testTodoOK() {
    // Caso: Todos los campos son correctos
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombreNull() {
    // Caso: Todos los campos son correctos
    //       excepto nombre que es null
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = null;
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombreVacío() {
    // Caso: Todos los campos son correctos
    //       excepto nombre que es vacío
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombre101Caracteres() {
    // Caso: Todos los campos son correctos
    //       excepto nombre que tiene 101 caracteres
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan J";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombre100Caracteres() {
    // Caso: Todos los campos son correctos
    //       nombre tiene exactamente 100 caracteres
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juan Juana";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombreVariosEspacios() {
    // Caso: Todos los campos son correctos
    //       nombre tiene varios espacios entre las partes
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Juan       Perez";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombreVariosGuiones() {
    // Caso: Todos los campos son correctos
    //       nombre tiene varios guiones entre las partes
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Juan-----Perez";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombreVariosEspaciosGuiones() {
    // Caso: Todos los campos son correctos
    //       nombre tiene varios espacios y guiones entre las partes
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Juan-  --Perez";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombreCaracteresNoValidos() {
    // Caso: Todos los campos son correctos
    //       excepto nombre que tiene caracteres no válidos (é)
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Juan Pérez";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testNombrePrimeraNoMayuscula() {
    // Caso: Todos los campos son correctos
    //       excepto nombre que tiene una parte que no comienza por mayúscula
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Juan perez";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoNull() {
    // Caso: Todos los campos son correctos
    //       excepto telefono que es null
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = null;
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoVacio() {
    // Caso: Todos los campos son correctos
    //       excepto telefono que es vacio
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoCorto() {
    // Caso: Todos los campos son correctos
    //       excepto telefono que tiene menos dígitos de lo correcto
    //       (8 en lugar de 9)
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "99999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoLargo() {
    // Caso: Todos los campos son correctos
    //       excepto telefono que tiene mas dígitos de lo correcto
    //       (10 en lugar de 9)
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "9999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoCaracterIncorrectoInicio() {
    // Caso: Todos los campos son correctos
    //       excepto telefono que tiene caracter incorrecto al inicio
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "a99999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoCaracterIncorrectoMedio() {
    // Caso: Todos los campos son correctos
    //       excepto telefono que tiene caracter incorrecto en medio
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "9999a9999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoCaracterIncorrectoFinal() {
    // Caso: Todos los campos son correctos
    //       excepto telefono que tiene caracter incorrecto al final
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "99999999a";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoComienza6() {
    // Caso: Todos los campos son correctos
    //       telefono comienza por 6
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "699999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoComienza7() {
    // Caso: Todos los campos son correctos
    //       telefono comienza por 7
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "799999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testTelefonoComienza8() {
    // Caso: Todos los campos son correctos
    //       telefono comienza por 8
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "899999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPNulo() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que es nulo
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = null;
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPVacio() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que es vacio
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPCorto() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que es mas corto de lo esperado (4 en lugar de 5)
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "2901";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPLargo() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que es mas largo de lo esperado (6 en lugar de 5)
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "290001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPCaracterNoValidoInicio() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que tiene una letra al inicio
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "a2901";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPCaracterNoValidoMedio() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que tiene una letra en medio
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29a01";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPCaracterNoValidoFinal() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que tiene una letra al final
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "2900a";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPComienzo00() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que comienza por 00
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "00001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPComienzo53() {
    // Caso: Todos los campos son correctos
    //       excepto codigo postal que comienza por 53
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "53001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testCPComienzoCorrecto() {
    // Caso: Todos los campos son correctos
    //       codigo postal va variando de 01 a 52
    // RE  : Se crea el objeto y no se lanza excepcion
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigoBase = "001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    // Probamos los códigos de 01001 a 09001
    for (int i = 1; i <= 9; i++) {
      String codigo = "0" + String.valueOf(i) + codigoBase;
      assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
    }
    // Probamos los códigos de 10001 a 52001
    for (int i = 10; i <= 52; i++) {
      String codigo = String.valueOf(i) + codigoBase;
      assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
    }
  }

  @Test
  void testCPComienzoIncorrecto() {
    // Caso: Todos los campos son correctos
    //       codigo postal va variando de 53 a 99
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigoBase = "001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;";
    // Probamos los códigos de 53001 a 99001
    for (int i = 53; i <= 99; i++) {
      String codigo = String.valueOf(i) + codigoBase;
      assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
    }
  }

  @Test
  void testUsuarioNull() {
    // Caso: Todos los campos son correctos
    //       excepto usuario que es null
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = null;
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testUsuarioVacio() {
    // Caso: Todos los campos son correctos
    //       excepto usuario que es vacío
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testUsuarioLargo() {
    // Caso: Todos los campos son correctos
    //       excepto usuario que es demasiado largo
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makako";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testUsuarioComienzoIncorrecto1() {
    // Caso: Todos los campos son correctos
    //       excepto usuario que comienza por digito
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "0pako_maka";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testUsuarioComienzoIncorrecto2() {
    // Caso: Todos los campos son correctos
    //       excepto usuario que comienza por _
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "_pako_maka";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testUsuarioCaracterIncorrectoInicio() {
    // Caso: Todos los campos son correctos
    //       excepto usuario que comienza por caracter no valido
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = ".pako_maka";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testUsuarioCaracterIncorrectoMedio() {
    // Caso: Todos los campos son correctos
    //       excepto usuario que tiene caracter no valido en medio
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_.maka";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testUsuarioCaracterIncorrectoFinal() {
    // Caso: Todos los campos son correctos
    //       excepto usuario que tiene caracter no valido al final
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_maka.";
    String password = "Am1.Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordNull() {
    // Caso: Todos los campos son correctos
    //       excepto password que es null
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = null;
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordVacia() {
    // Caso: Todos los campos son correctos
    //       excepto password que es vacía
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordCorta() {
    // Caso: Todos los campos son correctos
    //       excepto password que es demasiado corta (7)
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordLarga() {
    // Caso: Todos los campos son correctos
    //       excepto password que es demasiado larga (17)
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn2;Am1.Bn2;C";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordCaracteresNoValidos() {
    // Caso: Todos los campos son correctos
    //       excepto password que contiene caracteres no validos (-)
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1-Bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordSinMayusculas() {
    // Caso: Todos los campos son correctos
    //       excepto password que no contiene mayúsculas
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "am1;bn2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordSinMinusculas() {
    // Caso: Todos los campos son correctos
    //       excepto password que no contiene minúsculas
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "AM1;BN2;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordSinDigitos() {
    // Caso: Todos los campos son correctos
    //       excepto password que no contiene digitos
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Amp;Bnq;";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordSinEspeciales() {
    // Caso: Todos los campos son correctos
    //       excepto password que no contiene caracteres especiales
    // RE  : No se crea el objeto y se lanza IllegalArgumentException
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am13Bn24";
    assertThrows(IllegalArgumentException.class, () -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial1() {
    // Caso: Todos los campos son correctos
    //       password contiene punto 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1.Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial2() {
    // Caso: Todos los campos son correctos
    //       password contiene punto y coma
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1;Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial3() {
    // Caso: Todos los campos son correctos
    //       password contiene coma 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1,Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial4() {
    // Caso: Todos los campos son correctos
    //       password contiene dos puntos 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1:Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial5() {
    // Caso: Todos los campos son correctos
    //       password contiene barra 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1/Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial6() {
    // Caso: Todos los campos son correctos
    //       password contiene asterisco 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1*Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial7() {
    // Caso: Todos los campos son correctos
    //       password contiene ampersand 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1&Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial8() {
    // Caso: Todos los campos son correctos
    //       password contiene porcentaje 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1%Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial9() {
    // Caso: Todos los campos son correctos
    //       password contiene dolar 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1$Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial10() {
    // Caso: Todos los campos son correctos
    //       password contiene parentesis de aprtura 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1(Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

  @Test
  void testPasswordEspecial11() {
    // Caso: Todos los campos son correctos
    //       password contiene paréntesis de cierre 
    // RE  : No se lanza excepción y se crea el objeto
    String nombre = "Pako Makako";
    String telefono = "999999999";
    String codigo = "29001";
    String usuario = "pako_makak";
    String password = "Am1)Bn24";
    assertDoesNotThrow(() -> new Usuario(nombre, telefono, codigo, usuario, password));
  }

}
