package prog.unidad04.actividad405.ejercicio01;

import prog.unidad04.actividad405.comun.Alumno;
import prog.unidad04.actividad405.comun.Becario;
import prog.unidad04.actividad405.comun.Persona;
import prog.unidad04.actividad405.comun.Profesor;

/**
 * Programa que prueba el objeto Universidad
 */
public class PruebaUniversidad {

  public static void main(String[] args) {
    // Creamos una persona, un alumno, un profesor y un becario
    Persona persona = new Persona("Paco", "11111111A");
    Alumno alumno = new Alumno("Paqui", "22222222B");
    Becario becario = new Becario("Lukas", "33333333C", "111111111111111");
    Profesor profesor = new Profesor("Marcos", "44444444D", "Arqueología");
    
    // Matriculamos al becario y al alumno
    alumno.matricula("Psicología");
    becario.matricula("Informática");
    
    // Imprimimos los datos de las 4 personas
    Universidad.imprimir(persona);
    Universidad.imprimir(alumno);
    Universidad.imprimir(becario);
    Universidad.imprimir(profesor);
    
    // Intentamos matricular a los 4
    Universidad.matricular(persona, "Curso Persona");
    Universidad.matricular(alumno, "Curso Alumno");
    Universidad.matricular(profesor, "Curso Profesor");
    Universidad.matricular(becario, "Curso Becario");

    // Imprimimos los datos de las 4 personas otra vez
    Universidad.imprimir(persona);
    Universidad.imprimir(alumno);
    Universidad.imprimir(becario);
    Universidad.imprimir(profesor);
  }

}
