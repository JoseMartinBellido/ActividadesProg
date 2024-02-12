package prog.unidad04.actividad402.ejercicio03;

import java.util.Random;

/**
 * Clase que representa a una persona
 */
public class Persona {

  // Constantes para el sexo
  /**
   * Constante para definir el sexo de un hombre.
   */
  private static final char SEXO_HOMBRE = 'H';
  
  /**
   * Constante para definir el sexo de una mujer.
   */
  private static final char SEXO_MUJER = 'M';
  
  // Constantes para la edad
  /**
   * Límite inferior de la edad
   */
  private static final int EDAD_MINIMO = 0;
  
  /**
   * Límite superior de la edad
   */
  private static final int EDAD_MAXIMO = 120;
  
  // Constantes para el peso
  /**
   * Límite inferior para el peso
   */
  private static final double PESO_MINIMO = 0;
  
  /**
   * Límite superior para el peso
   */
  private static final double PESO_MAXIMO = 300;
  
  // Constantes para la altura
  /**
   * Límite inferior para la altura
   */
  private static final double ALTURA_MINIMO = 0;
  
  /**
   * Límite superior para la altura
   */
  private static final double ALTURA_MAXIMO = 2.5;
  
  // Constantes para el DNI
  /**
   * Constante para el cálculo del DNI
   */
  private static final int DIVISOR_CALCULO_DNI = 23;
  
  /**
   * Constante para el cálculo de la letra del DNI
   */
  private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
  
  /**
   * IMC mínimo para un peso normal
   */
  private static final double IMC_MINIMO = 20;
  
  /**
   * IMC máximo para un peso normal
   */
  private static final double IMC_MAXIMO = 25;
      
  // Atributos de clase
  /**
   * Nombre de la persona. Por defecto será una cadena de caractéres vacía.
   */
  private String nombre;
  
  /**
   * Edad de la persona. Por defecto será cero.
   */
  private int edad;
  
  /**
   * DNI de la persona.
   */
  private String dni;

  /**
   * Sexo de la persona.
   */
  private char sexo;
  
  /**
   * Peso de la persona.
   */
  private double peso;
  
  /**
   * Altura de la persona.
   */
  private double altura;

  // Constructores
  // Genero el constructor por defecto y lo uso para generar todos los demás
  
  /**
   * Constructor por defecto. Crea el objeto con los valores.
   * nombre = ""
   * edad = 0
   * sexo = 'M'
   * peso = 0
   * altura = 0
   * DNI = Valor generado al azar
   */
  public Persona () {
    nombre = "";
    edad = EDAD_MINIMO;
    sexo = SEXO_MUJER;
    peso = PESO_MINIMO;
    altura = ALTURA_MINIMO;
    generarDNI();
  }

 /**
  * Constructor con tres parámetros. Toma altura y peso por defecto.
  * @param nombre El nombre de la persona
  * @param edad La edad de la persona. Debe ser mayor que cero.
  * @param sexo El sexo de la persona. Debe ser 'H' o 'M'.
  * @throws IllegalArgumentException Si la edad o el sexo son incorrectos.
  */
  public Persona (String nombre, int edad, char sexo) {
    this();
    this.nombre=nombre;
    
    // Comprobamos la edad para insertarla
    if (edad >= EDAD_MINIMO && edad <= EDAD_MAXIMO)
      this.edad = edad;
    else
      System.out.println("La edad no es un dato válido.");
    
    // Comprobamos el sexo con el método comprobarSexo
    this.sexo = comprobarSexo(sexo);
    
  }
  
  /**
   * 
   * @param nombre El nombre de la persona
   * @param edad La edad de la persona. Debe ser mayor que cero. Establecido en años
   * @param sexo El sexo de la persona. Debe ser 'H' o 'M'.
   * @param peso El peso de la persona. Debe ser mayor que cero. Establecido en kg.
   * @param altura La altura de la persona. Debe ser mayor que cero. Establecido en cm.
   * @throws IllegalArgumentException Si la edad, el sexo, el peso o la altura son incorrectos.
   */
  public Persona (String nombre, int edad, char sexo, double peso, double altura) {
    this(nombre,edad,sexo);

    if (peso >= PESO_MINIMO && peso <= PESO_MAXIMO)
      this.peso = peso;
    else
      System.out.println("El valor introducido para el peso no es válido. Se establecerá el valor por defecto.");
    
    if (altura >= ALTURA_MINIMO && altura <= ALTURA_MAXIMO)
      this.altura = altura;
    else
      System.out.println("El valor introducido para la altura no es válido. Se establecerá el valor por defecto.");
  }
  
  // Métodos públicos

  /**
   * Método que devuelve el índice de masa corporal (IMC) de la persona a partir de la altura y el peso. 
   * Si la altura es 0, devuelve 0.
   * @return El IMC de la persona.
   */
  public double getIMC() {
    // Establecemos el valor por defecto en 0 y solo calculamos si no dividimos por 0
    double imc = 0;
    
    if (altura != 0) {
      imc = peso / (altura * altura);
    }
    return imc;
  }
  
  /**
   * Método que indica si el peso de una persona es correcto o no.
   * @return Devuelve -1 si tiene infrapeso, 0 si tiene un valor correcto, o 1 si tiene sobrepeso
   */
  public int getPesoCorrecto() {
    
    //Por defecto será correcto y comprobaremos si es inferior o superior
    int esCorrecto = 0;
    //Obtenemos el IMC y con él contemplamos casos
    double imc = getIMC();
    
    if (imc < IMC_MINIMO)
      esCorrecto = -1;
    else if (imc > IMC_MAXIMO)
      esCorrecto = 1;
    
    return esCorrecto;
  }
  
  /**
   * Método que indica si una persona es mayor de edad o no.
   * @return Devuelve true si la persona es mayor de edad y false si no lo es.
   */
  public boolean esMayorDeEdad() {
    
    // Por defecto la edad es mayor o igual a cero, por lo que solo contemplamos el corte a 18 años y no números erróneos
    boolean esMayorONo = (edad >= 18) ? true : false;
    
    return esMayorONo;
  }
  
  /**
   * Método que nos devuelve todos los datos de una persona concatenados. La cadena incluirá los datos en el siguiente orden:
   * DNI = "DDDD", Nombre = "NNNN", Edad = EE, Sexo = 'S', Peso = PP.PP, Altura = A.AA
   * Donde el DNI y Nombre son cadenas de caractéres, la Edad es un número entero, Sexo es el carácter H o M, y Peso y altura
   * son datos decimales, dando el Peso en kilogramos y la altura en metros
   * @return Devuelve una cadena con todos los datos de una persona.
   */
  public String obtenerCadena() {
    
    String datosPersona = "DNI: " + dni + ", Nombre: \"" + nombre + "\", Edad: " + edad 
        + ", Sexo: " + sexo + ", Peso: " + peso + ", Altura: " + altura;
    
    return datosPersona;
  }
  
  
  // Métodos privados
  /**
   * Genera el DNI de la persona calculando 8 dígitos al azar y la letra correspondiente.
   * @return Devuelve una cadena de caractéres con 8 dígitos y una letra.
   */
  private void generarDNI() {
    dni = "";
    // Para generar el DNI, sacamos 8 números aleatorios con un generador de la clase Random
    Random generador = new Random();
    for(int i = 0; i < 8; i++) {
      dni += generador.nextInt(0, 10);
    }
    
    int restoDNI = Integer.parseInt(dni) % DIVISOR_CALCULO_DNI;
    
    dni += LETRAS_DNI.charAt(restoDNI);

  }
  
  /**
   * Método interno que comprueba el sexo introducido.
   * @param sexo Es el sexo de la persona. Debe ser un char 'M' o 'H'.
   * @return Devuelve el sexo de la persona. Será 'H' o, por defecto, 'M'.
   */
  private char comprobarSexo(char sexo) {
    
    // Si no es ninguna de las dos, avisamos al usuario
    if (sexo != SEXO_HOMBRE && sexo != SEXO_MUJER)
      System.out.println("El sexo introducido no es válido. Se tomará el valor por defecto 'M'");
    
    if (sexo == SEXO_HOMBRE)
      return SEXO_HOMBRE;
    else
      return SEXO_MUJER;
    
    
  }
  
  
  
}
