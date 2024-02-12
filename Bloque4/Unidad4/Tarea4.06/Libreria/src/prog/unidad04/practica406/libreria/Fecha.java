package prog.unidad04.practica406.libreria;

/**
 * Clase que representa una fecha. Ésta comienza a contar desde el 1/1/1900
 */
public class Fecha  implements ConvertibleATexto{

  // Bloque de constantes
  
  // Constantes del número del mes
  private static final int MES_ENERO = 1;
  private static final int MES_FEBRERO = 2;
  private static final int MES_MARZO = 3;
  private static final int MES_ABRIL = 4;
  private static final int MES_MAYO = 5;
  private static final int MES_JUNIO = 6;
  private static final int MES_JULIO = 7;
  private static final int MES_AGOSTO = 8;
  private static final int MES_SEPTIEMBRE = 9;
  private static final int MES_OCTUBRE = 10;
  private static final int MES_NOVIEMBRE = 11;
  private static final int MES_DICIEMBRE = 12;
  
  // Constantes para el número de días
  private static final int DIAS_MINIMO = 1;
  private static final int DIAS_MES_LARGO = 31;
  private static final int DIAS_MES_CORTO = 30;
  private static final int DIAS_FEBRERO_BISIESTO = 29;
  private static final int DIAS_FEBRERO_NORMAL = 28;
  
  // Bloque de atributos no constantes
  /**
   * Día de la fecha
   */
  private int dia;
  
  /**
   * Mes de la fecha
   */
  private int mes;
  
  /**
   * Año de la fecha
   */
  private int anyo;
  
  
  // Constructor
  /**
   * Constructor que establece una fecha a partir de un día, un mes y un año.
   * @param dia Día de la fecha. Debe ser un valor entre 1 y el día máximo del mes en el que se encuentre, incluído años bisiestos.
   * @param mes Mes de la fecha. Debe ser un valor entre 1 y 12.
   * @param anio Año de la fecha. Debe ser un valor mayor a 1900.
   * @throws IllegalArgumentException Si alguno de los parámetros no cumple las condiciones estipuladas.
   */
  public Fecha(int dia, int mes, int anyo){
    // Si este método devuelve true, la fecha es correcta. Sino, se lanza un error IllegalArgumentException
    if (compruebaFecha(dia, mes, anyo)) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    } else {
    	throw new IllegalArgumentException();
    }
   
  }
  
  // Bloque de métodos públicos
  
  @Override
  /**
   * Obtiene una representación de la fecha en texto El formato es Día de Mes de Año donde Día es el día del mes (número), 
   * Mes es el mes (en letra y minúscula) y Año es el año completo(en número)
   */
  public String aTexto() {
    String resultado = "";
    
    // Añadimos el día
    resultado += dia;
    
    // Añadimos el mes
    switch (mes) {
    case MES_ENERO:
      resultado += " de enero de ";
      break;
    case MES_FEBRERO:
      resultado += " de febrero de ";
      break;
    case MES_MARZO:
      resultado += " de marzo de ";
      break;
    case MES_ABRIL:
      resultado += " de abril de ";
      break;
    case MES_MAYO:
      resultado += " de mayo de ";
      break;
    case MES_JUNIO:
      resultado += " de junio de ";
      break;
    case MES_JULIO:
      resultado += " de julio de ";
      break;
    case MES_AGOSTO:
      resultado += " de agosto de ";
      break;
    case MES_SEPTIEMBRE:
      resultado += " de septiembre de ";
      break;
    case MES_OCTUBRE:
      resultado += " de octubre de ";
      break;
    case MES_NOVIEMBRE:
      resultado += " de noviembre de ";
      break;
    case MES_DICIEMBRE:
      resultado += " de diciembre de ";
      break;
    }

    // Añadimos el año
    resultado += anyo;
    
    // Damos el resultado
    return resultado;
  }
  
  /**
   * Método que compara dos fechas para comprobar si la segunda (parámetro) es posterior o anterior a la dada
   * @param otraFecha Fecha a comparar
   * @return 0 si ambas fechas son iguales, -1  si la nuestra es anterior a la otra o 1 si la nuestra es posterior a la otra
   */
  public int compara(Fecha otraFecha) {
    // Calculamos los días transcurridos entre fechas
    long diasTranscurridosNuestraFecha = diasTranscurridos();
    long diasTranscurridosOtraFecha = otraFecha.diasTranscurridos();
    
    // Determinamos casos en función a los días transcurridos
    if (diasTranscurridosNuestraFecha < diasTranscurridosOtraFecha) {
      return -1;
    } else if (diasTranscurridosNuestraFecha > diasTranscurridosOtraFecha) {
      return 1;
    } else {
      return 0;
    }
    
  }
  
  /**
   * Método que devuelve los días transcurridos entre nuestra fecha y otraFecha
   * @param otraFecha Fecha para realizar el cálculo de días entre fechas
   * @return El número de días entre nuestra fecha y otraFecha
   * @throws FechaException Si nuestra fecha es posterior a la dada
   */
  public long diasEntre(Fecha otraFecha){
    
    // Calculamos los días transcurridos entre fechas
    long diasTranscurridosNuestraFecha = diasTranscurridos();
    long diasTranscurridosOtraFecha = otraFecha.diasTranscurridos();
    
    // Tendremos un error si nuestra fecha es posterior a la dada
    if (compara(otraFecha) == 1) {
      throw new FechaException();
    } else {
      return diasTranscurridosOtraFecha - diasTranscurridosNuestraFecha;
    }
  }

  /**
   * Método que calcula el número de días transcurridos entre el 1/1/1900 y la fecha actual
   * @return El número de días transcurridos entre el 1/1/1900 y la fecha actual
   */
  public long diasTranscurridos() {
    
    long diasTranscurridos = 0;
    
    // Añadimos a los días transcurridos 366 días por cada año bisiesto, 365 por cada uno que no lo sea
    for (int i = 1900; i < anyo; i++) {
      diasTranscurridos += (compruebaBisiesto(i)) ? 366 : 365;
    }
    
    // Añadimos a los días transcurridos los meses ya pasados (no contamos el actual) en el mismo año
    for (int i = 1; i < mes; i++) {
      diasTranscurridos += diasDelMes(i,anyo);
    }
    
    // Añadimos a los días transcurridos del mes actual (no contamos el actual, ya que no ha pasado el día)
    diasTranscurridos += dia - 1;
    
    
    return diasTranscurridos;
  }  
  
  /**
   * Método que comprueba si un año es o no bisiesto
   * @param anio Año a comprobar
   * @return true si es bisiesto, false si no lo es
   */
  public boolean esBisiesto() {
    return compruebaBisiesto(anyo);

  }
  
  
  /**
   * Método para obtener el día introducido en la fecha
   * @return El día de la fecha
   */
  public int getDia() {
    return dia;
  }
  
  /**
   * Método para obtener el mes introducido en la fecha
   * @return El mes de la fecha
   */
  public int getMes() {
    return mes;
  }
  
  /**
   * Método para obtener el año introducido en la fecha
   * @return El año de la fecha
   */
  public int getAnyo() {
    return anyo;
  }
  
  /**
   * Método que comprueba si un año concreto es bisiesto
   * @param anyo Año a comprobar
   * @return true si es bisiesto, false si no lo es
   */
  private boolean compruebaBisiesto(int anyo) {
    // De esta forma, tenemos todos los años divisibles por 4 y no por 100
    boolean resultado = (anyo % 4 == 0 && anyo % 100 != 0) ? true : false;
    
    // Añadimos a la regla los que son divisibles por 400 y han sido descartados anteriormente
    if (!resultado && anyo % 400 == 0) {
      resultado = true;
    }
    
    return resultado;
  }
  
  // Bloque de métodos privados
  
  /**
   * Método privado que comprueba si la fecha es correcta
   */
  private boolean compruebaFecha(int dia, int mes, int anyo){
    
    // Comprobamos primero el año. Debe ser mayor o igual a 1900
    if (anyo >= 1900) {
    	if (mes >= 0 && mes <= 12) {
    		if (dia >= DIAS_MINIMO && dia <= diasDelMes(mes, anyo)) {
    			return true;
    		}
    	}
    }
    return false;
    
  }

  /**
   * Método para obtener los días que tiene un mes sabiendo el mes y el año
   * @param mes Mes de la fecha
   * @param anio Año de la fecha
   * @return El número de días que tiene el mes y año especificados
   */
  private  int diasDelMes(int mes, int anio) {
    switch (mes) {
    // Caso para meses 1, 3, 5, 7, 8, 10 y 12 (31 días)
    case MES_ENERO:
    case MES_MARZO:
    case MES_MAYO:
    case MES_JULIO:
    case MES_AGOSTO:
    case MES_OCTUBRE:
    case MES_DICIEMBRE:
      return DIAS_MES_LARGO;
    // Caso para meses 4, 6, 9 y 11
    case MES_ABRIL:
    case MES_JUNIO:
    case MES_SEPTIEMBRE:
    case MES_NOVIEMBRE:
      return DIAS_MES_CORTO;
    case MES_FEBRERO:
      if (compruebaBisiesto(anio)) {
        return DIAS_FEBRERO_BISIESTO;
      } else {
        return DIAS_FEBRERO_NORMAL;
      }
     default:
    	 throw new IllegalArgumentException();
    }
  }
  
}
