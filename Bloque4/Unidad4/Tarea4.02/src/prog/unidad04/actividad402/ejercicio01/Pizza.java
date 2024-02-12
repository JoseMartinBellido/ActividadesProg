package prog.unidad04.actividad402.ejercicio01;


/**
 * Clase que representa a una pizza
 * @author jose
 * @version 1.0
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
   */
  public Pizza(String tamanyo, String tipo) {
    
    // Suponemos los parámetros bien
    boolean bParametrosOK = true;
    //Si el tamaño no es correcto, mostramos error
    if (!tamanyo.equals(TAMANYO_MEDIANA) && !tamanyo.equals(TAMANYO_FAMILIAR)) {
      System.out.println("El parámetro tamaño no es correcto. Debe ser uno de " + TAMANYO_MEDIANA + " o " + TAMANYO_FAMILIAR);
      bParametrosOK = false;
    }
    
    // Si el tipo no es correcto, mostramos error
    if (!tipo.equals(TIPO_MARGARITA) && !tipo.equals(TIPO_CUATRO_QUESOS) && !tipo.equals(TIPO_FUNGHI) ) {
      System.out.println("El parámetro tipo no es correcto. Debe ser uno de " + TIPO_MARGARITA + ", " + TAMANYO_FAMILIAR 
          + " o " + TIPO_FUNGHI);
      bParametrosOK = false;
    }
    
    // Inicializamos los atributos
    this.tamanyo = tamanyo;
    this.tipo = tipo;
    
    if (bParametrosOK)
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
   */
  public void sirve() {
    if (estado.equals(ESTADO_PEDIDA)) {
      estado = ESTADO_SERVIDA;
      pizzasServidas++;
    }else {
      System.out.println("Error. Esta pizza ya se ha servido.");
    }
  }
  
  
  
}
