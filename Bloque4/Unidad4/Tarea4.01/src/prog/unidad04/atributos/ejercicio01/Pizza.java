package prog.unidad04.atributos.ejercicio01;

public class Pizza {

  // Tamaños de pizza
  
  /**
   * String. Constante. Tamaño de pizza mediana.
   */
  public static final String TAMANIO_MEDIANA = "mediana";
  
  /**
   * String. Constante. Tamaño de pizza familiar.
   */
  public static final String TAMANIO_FAMILIAR = "familiar";
  
  // Tipos de pizzas
  
  /**
   * String. Constante. Tipo de pizza margarita.
   */  
  public static final String TIPO_MARGARITA = "margarita";
  
  /**
   * String. Constante. Tipo de pizza funghi.
   */ 
  public static final String TIPO_FUNGHI = "funghi";
  
  /**
   * String. Constante. Tipo de pizza cuatro quesos.
   */ 
  public static final String TIPO_CUATRO_QUESOS = "cuatro quesos";
  
  
  // Estados de una pizza
  
  /**
   * String. Constante. Estado de pizza: pedida.
   */ 
  public static final String ESTADO_PEDIDA = "pedida";
  
  /**
   * String. Constante. Estado de pizza: servida.
   */ 
  public static final String ESTADO_SERVIDA = "servida";
  
  /**
   * int. Estática. Número total de pizzas desde que se inicia la aplicación.
   */
  public static int numeroDePizzasTotales = 0;
  
  /**
   * int. Estática. Número total de pizzas servidas desde que se inicia la aplicación  
   */
  public static int numeroDePizzasServidas = 0;
  
  /**
   * String. Tamaño de la pizza. Debe ser mediana o familiar.
   */
  public String tamanio;
  
  /**
   * String. Tipo de la pizza. Debe ser margarita, cuatro quesos o funghi.
   */
  public String tipo;
  
  /**
   * String. Estado de la pizza. Debe ser servida o creada.
   */
  public String estado;
  
}
