package prog.unidad04.actividad402.ejercicio07;

import java.util.Random;

public class TarjetaRegalo {

  // ------------------------------ Bloque de atributos ------------------------------
  /**
   * Saldo de la tarjeta regalo.
   */
  private double saldo;
  
  /**
   * Identificador de 5 cifras de la tarjeta regalo.
   */
  private String identificador;
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Creación de la Tarjeta Regalo con el saldo inicial. Debe ser mayor que cero, o su valor por defecto será 20€.
   * @param saldo
   */
  public TarjetaRegalo(double saldo) {
    if (saldo < 0) {
      saldo = 20;
      System.out.println("El saldo debe ser un número mayor a cero. Se establece por defecto 20€.");
    }
    
    this.saldo = saldo;
    identificador = creaIdentificador();
  }
  
  
  // ------------------------------ Bloque de métodos ------------------------------
  /**
   * Método para gastar una cantidad del saldo total que contiene. No se realizará el gasto si el saldo es inferior.
   * @param cantidad Cantidad del saldo a gastar
   */
  public void gasta(double cantidad) {
    
    if (cantidad < saldo) 
      saldo -= cantidad;
    else
      System.out.println("Error. No se puede gastar ese importe porque la tarjeta tiene un saldo inferior");
  }
  
  /**
   * Método que fusiona dos tarjetas en una nueva distinta con los saldos juntos. Las dos originales quedan con un saldo de 0€.
   * @param tarjeta Tarjeta con la que se fusiona la primera.
   * @return Una nueva tarjeta regalo con identificador nuevo y el saldo de ambas tarjetas juntos.
   */
  public TarjetaRegalo fusionaCon(TarjetaRegalo tarjeta) {
    
    double saldoTarjeta = tarjeta.saldo;
    
    TarjetaRegalo tarjetaFusionada = new TarjetaRegalo(saldo + saldoTarjeta);
    
    saldo = 0;
    tarjeta.saldo = 0;
    
    return tarjetaFusionada;
  }
  
  /**
   * Obtiene una cadena con el formato:
   * Tarjeta nº NNNNN - Saldo: SSSS€ donde NNNN es el identificador y SSSS el saldo en euros.
   * @return Una cadena que define los parámetros de la tarjeta regalo.
   */
  public String obtenerCadena() {
    return "Tarjeta nº " + identificador + " - Saldo: " + saldo + "€";
  }
  
  // Método auxiliar para generar el identificador
  private String creaIdentificador() {
    
    Random generador = new Random();
    String identificador = "";
    
    for (int i = 0; i < 5; i++)
      identificador += String.valueOf(generador.nextInt(0,10));
    
    return identificador;
  }
  
}
