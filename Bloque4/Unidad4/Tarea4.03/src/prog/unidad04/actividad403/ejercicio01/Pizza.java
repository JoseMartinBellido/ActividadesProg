package prog.unidad04.actividad403.ejercicio01;

/**
 * Clase que representa a una pizza
 * @author jose
 * @version 3.0
 */
public class Pizza {

  // Estados de la pizza
  /**
   * Pizza pedida
   */
  public static final String ESTADO_PEDIDA = "pedida";
  
  /**
   * Pizza servida
   */
  public static final String ESTADO_SERVIDA = "servida";
  
  // Tamaños de la pizza
  /**
   * Tamaño mediano
   */
  public static final String TAMANYO_MEDIANA = "mediana";
 
  /**
   * Tamaño familiar
   */
  public static final String TAMANYO_FAMILIAR = "familiar";
 
  // Tipos de la pizza
  /**
   * Tipo cuatro quesos
   */
  public static final String TIPO_CUATRO_QUESOS = "cuatro quesos";
  
  /**
   * Tipo Funghi
   */
  public static final String TIPO_FUNGHI = "funghi";
  
  /**
   * Tipo Margarita
   */
  public static final String TIPO_MARGARITA = "margarita";
  
  // Costes de la Pizza
  /**
   * Coste que implica el tamaño mediano
   */
  private static final double COSTE_TAMANYO_MEDIANA = 5;
  
  /**
   * Coste que implica el tamaño familiar
   */
  private static final double COSTE_TAMANYO_FAMILIAR = 7.5;
  
  /**
   * Coste por ingrediente
   */
  private static final double COSTE_POR_INGREDIENTE = 1;
  
  /**
   * Número de ingredientes de la pizza  margarita
   */
  private static final int INGREDIENTES_MARGARITA = 2;
  
  /**
   * Número de ingredientes de la pizza cuatro quesos
   */
  private static final int INGREDIENTES_CUATRO_QUESOS = 4;

  /**
   * Número de ingredientes de la pizza funghi
   */
  private static final int INGREDIENTES_FUNGHI = 3;
  
  
  //Atributos estáticos
  // Número total de pizzas creadas
  private static int pizzasCreadas = 0;
  // Número total de pizzas servidas
  private static int pizzasServidas = 0;
   
  
  // Atributos
  private String tamanyo;
  private String tipo;
  private String estado = ESTADO_PEDIDA;
  
  // Constructor
  /**
   * Constructor. Imprime error si alguno de los parámetros no son correctos.
   * @param tamanyo - Tamaño de la pizza. Debe ser "mediana" o "familiar"
   * @param tipo - Tipo de la pizza. Debe ser "margarita", "cuatro quesos" o "funghi"
   * @throws IllegalArgumentException Si no se introduce correctamente el tamaño y el tipo, 
   * se obtiene un error IllegalArgumentException
   */
  public Pizza(String tamanyo, String tipo) {
    

    //Si el tamaño no es correcto, lanzamos error IllegalArgumentException
    if (!tamanyo.equals(TAMANYO_MEDIANA) && !tamanyo.equals(TAMANYO_FAMILIAR)) {
      throw new IllegalArgumentException();
    }
    
    // Si el tipo no es correcto, lanzamos error IllegalArgumentException
    if (!tipo.equals(TIPO_MARGARITA) && !tipo.equals(TIPO_CUATRO_QUESOS) && !tipo.equals(TIPO_FUNGHI) ) {
      throw new IllegalArgumentException();
    }
    
    // Inicializamos los atributos
    this.tamanyo = tamanyo;
    this.tipo = tipo;
    
    pizzasCreadas++;
    
  }

  /**
   * Obtiene el número de pizzas creadas hasta el momento
   * @return El número de pizzas creadas hasta el momento
   */
  public static int getPizzasCreadas() {
    return pizzasCreadas;
  }

  /**
   * Obtiene el número de pizzas servidas hasta el momento
   * @return El número de pizzas servidas hasta el momento
   */
  public static int getPizzasServidas() {
    return pizzasServidas;
  }

  /**
   * Obtiene el tamaño de la pizza
   * @return Tamaño de la pizza
   */
  public String getTamanyo() {
    return tamanyo;
  }

  /**
   * Obtiene el tipo de la pizza
   * @return Tipo de la pizza
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Obtiene el estado de la pizza
   * @return Estado de la pizza
   */
  public String getEstado() {
    return estado;
  }
 
  /**
   * Sirve la pizza. Muestra un error si la pizza ya está servida.
   * @throws PizzaAlreadyServedException Si la pizza está ya servida
   */
  public void sirve() throws PizzaAlreadyServedException {
    if (estado.equals(ESTADO_PEDIDA)) {
      estado = ESTADO_SERVIDA;
      pizzasServidas++;
    }else {
      throw new PizzaAlreadyServedException() ;
    }
  }
  
  /**
   * Calcula el coste de la pizza en función del tipo y el tamaño de la misma
   * @return El coste de la pizza
   */
  public double coste() {
    
    double costeTotal = 0;
    
    //Primero sumamos dependiendo del tamaño
    if (tamanyo.equals(TAMANYO_MEDIANA))
      costeTotal += COSTE_TAMANYO_MEDIANA;
    else
      costeTotal += COSTE_TAMANYO_FAMILIAR;
    
    // Luego sumamos en función de los ingredientes de la pizza
    if(tipo.equals(TIPO_MARGARITA))
      costeTotal += INGREDIENTES_MARGARITA * COSTE_POR_INGREDIENTE;
    else if (tipo.equals(TIPO_FUNGHI))
      costeTotal += INGREDIENTES_FUNGHI * COSTE_POR_INGREDIENTE;
    else
      costeTotal += INGREDIENTES_CUATRO_QUESOS * COSTE_POR_INGREDIENTE;
    
    // Devolvemos el resultado
    return costeTotal;
    
  }
  
}
