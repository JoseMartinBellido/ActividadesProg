package prog.unidad04.actividad405.ejercicio01;

import prog.unidad04.actividad405.comun.Alumno;
import prog.unidad04.actividad405.comun.Persona;
import prog.unidad04.actividad405.comun.Becario;
import prog.unidad04.actividad405.comun.Profesor;

public class Universidad {

  /**
   * Método que imprime por pantalla todos los datos de una persona o cualquier tipo compatible con ella
   * @param persona Persona a partir de la cual se proporcionan los datos personales
   */
  public static void imprimir(Persona persona) {
    
    // Imprimimos los datos que van a tener todos los objetos que se pasen por aquí obligatoriamente
    System.out.print("Nombre: " + persona.getNombre() + ". DNI: " + persona.getDNI());
    
    // Comprobamos si el objeto Persona es de tipo Alumno, Becario o profesor para imprimir sus características
    if (persona instanceof Alumno) {
      Alumno alumno = (Alumno) persona;
      System.out.print(". Matrícula: " + alumno.getMatricula());
    }
    
    if (persona instanceof Becario) {
      Becario becario = (Becario) persona;
      System.out.print(". Cuenta corriente: " + becario.getCuentaCorriente());
    }
    
    if (persona instanceof Profesor) {
      Profesor profesor = (Profesor) persona;
      System.out.print(". Titulación: " + profesor.getTitulacion());
    }
    
    // Salto de linea
    System.out.println();
  }
  
  /**
   * El método realiza la matrícula sobre el objeto proporcionado en caso de que sea posible y lo indica por pantalla, o imprime
   * un mensaje de error en caso de que no lo sea.
   * @param objeto objeto a matricular
   * @param matricula matrícula a realizar en caso de que sea posible
   */
  public static void matricular(Object objeto, String matricula) {
    
    // Solo podemos matricular en caso de que el objeto proporcionado sea un Alumno o una clase que herede de ella
    
    if (objeto instanceof Alumno) {
      
      Alumno alumno = (Alumno) objeto;
      alumno.matricula(matricula);
      System.out.println("Se ha podido realizar la matrícula satisfactoriamente. "
          + "El alumno " + alumno.getNombre() + " ha sido matriculado en " + alumno.getMatricula());
      
    } else {
      
      System.out.println("No se ha podido realizar la matrícula en " + matricula);
      
    }
    
    
  }
  
  
  
  
  
  
}
