
public class Tarea2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Apartado 1
    
    Persona persona1 = new Persona();
    
    persona1.edad = 25;
    persona1.peso = 75.4;
    
    Persona persona2 = new Persona();
    
    persona2.edad = 65;
    persona2.numeroHijos = 3;
    persona2.peso = 65;
    
    System.out.println("La primera persona tiene " + persona1.edad + " años y pesa " + persona1.peso + "kg");
    System.out.println("La segunda persona tiene "  + persona2.edad + " años, pesa " + persona2.peso + "kg"
        + " y tiene " + persona2.numeroHijos + " hijos.");
    
    // Apartado 2
    
    System.out.println("¿Son el mismo objeto? " + (persona1 == persona2));
    
    // No pueden apuntar al mismo objeto ya que son dos distintos, persona1 y persona2
    
    // Apartado 3 y 4
    
    Persona persona3 = new Persona();
    
    persona3.edad = 33;
    persona3.numeroHijos = 1;
    persona3.peso = 80.43;
    
    Persona persona4 = persona3;
    
    persona4.peso = 79.65;
    
    System.out.println("La tercera persona tiene "  + persona3.edad + " años, pesa " + persona3.peso + "kg"
        + " y tiene " + persona3.numeroHijos + " hijo.");
    System.out.println("La cuarta persona tiene " + persona4.edad + " años y pesa " + persona4.peso + "kg");
    
    System.out.println("¿Son el mismo objeto? " + (persona3 == persona4));
    
    // Dan el mismo resultado en el peso porque son dos referencias al mismo objeto.

    // Apartado 5
    
    // Daría un error porque estaríamos intentando apuntar a un objeto que no existe, sin atributos asignados.
    
    
  }

}
