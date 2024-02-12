package prog.unidad06.arraysobjetos.ejercicio04;

public class Persona {

  //Constantes de dni
   private static final int DNI_LONGITUD = 9;
   private static final char[] DNI_LETRAS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 
       'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
   
   // Constantes de nombre
   private static final int NOMBRE_LONGITUD_MINIMA = 1;
   private static final int NOMBRE_LONGITUD_MAXIMA = 100;
   
   /**
    * DNI de la persona. Debe tener formato "NNNNNNNNL" donde N es un número del 0 al 10 y L la letra asignada
    */
   private String dni;
   
   /**
    * Nombre de la persona. Debe tener entre 1 y 100 caracteres
    */
   private String nombre;
   
   /**
    * Constructor de la clase con parámetros dni y nombre
    * @param dni DNI de la persona. Debe componerse de 8 dígitos comprendidos entre 0 y 9 y una letra asignada
    * @param nombre Nombre de la persona. Debe tener entre 1 y 100 caracteres
    * @throws IllegalArgumentException Si alguno de los parámetros no es correcto
    */
   public Persona(String dni, String nombre) {
     if (compruebaDNI(dni) && compruebaNombre(nombre)){
       this.dni = dni;
       this.nombre = nombre;
     } else {
       throw new IllegalArgumentException();
     }
   }

   /**
    * Método que obtiene el dni de la persona
    * @return El dni de la persona
    */
   public String getDni() {
     return dni;
   }

   /**
    * Método que devuelve el nombre de la persona
    * @return El nombre de la persona
    */
   public String getNombre() {
     return nombre;
   }
   
   /**
    * Método que comprueba si el nombre es correcto
    * @param nombre Nombre de la persona. Debe tener entre 1 y 100 caracteres
    * @return true si es correcto, false si no lo es
    */
   private boolean compruebaNombre(String nombre) {
     // Comprobamos que cumple con los requisitos de longitud
     if (nombre.length() >= NOMBRE_LONGITUD_MINIMA && nombre.length() <= NOMBRE_LONGITUD_MAXIMA) {
       return true;
     }
     // Si no se ha devuelto true, es false
     return false;
   }

   /**
    * Método que comprueba la validez de formato de un DNI
    * @param dni DNI sobre el que se comprueba si tiene un formato válido
    * @return true si es correcto, false si no lo es
    */
   private boolean compruebaDNI(String dni) {
     // Comprobamos la longitud
     if (dni.length() != DNI_LONGITUD) {
       return false;
     } else {
       // Si la longitud es correcta, comprobamos los números
       for (int i = 0; i < dni.length() - 1; i++) {
         if (dni.charAt(i) < '0' || dni.charAt(i) > '9') {
           return false;
         }
       }
       // Si llegamos hasta aquí, los números son correctos. Comprobamos la letra
       int numeroDNI = Integer.parseInt(dni.substring(0, dni.length() - 1));
       // La letra correcta la extraemos de nuestra constante con las letras en orden
       char letraAsignada = DNI_LETRAS[numeroDNI % DNI_LETRAS.length];
       if (dni.charAt(dni.length() - 1) != letraAsignada) {
         return false;
       }
     }
     // Si llegamos aquí, el DNI es correcto
     return true;
   }
}
