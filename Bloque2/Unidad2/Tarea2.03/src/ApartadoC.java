
public class ApartadoC {
  
  // Definimos las constantes de la clase. Puntos inicios de los trazos.
  
  public static final Punto INICIO_CUADRADO = new Punto(0,0);
  
  public static final Punto INICIO_TRIANGULO = new Punto(20,35);
  
  public static final Punto INICIO_PENTAGONO = new Punto(25,55);
  

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.println("Coordenadas de los vértices del cuadrado: ");
    
    Lapiz cuadrado = new Lapiz();
    
    // Inicio el trazado desde el inicio
    
    cuadrado.mueve(INICIO_CUADRADO);
    
    cuadrado.baja();
    
    //Primer trazo e impresión de coordenadas. Desplazamos 20.
    
    cuadrado.desplaza(20);
    
    Linea linea1C = cuadrado.getTrazo(1);
    
    System.out.print("(" + (int) linea1C.getInicio().getX() + "," + (int) linea1C.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea1C.getFin().getX() + "," + (int) linea1C.getFin().getY() + ")");
    
    // Segundo trazo e impresión de coordenadas. Giramos 90º y desplazamos 20.
    
    cuadrado.gira(-90);
    
    cuadrado.desplaza(20);
    
    Linea linea2C = cuadrado.getTrazo(2);
    
    System.out.print("(" + (int) linea2C.getInicio().getX() + "," + (int) linea2C.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea2C.getFin().getX() + "," + (int) linea2C.getFin().getY() + ")");
    
    // Tercer trazo e impresión de coordenadas. Giramos 90º y desplazamos 20.
    
    cuadrado.gira(-90);
    
    cuadrado.desplaza(20);
    
    Linea linea3C = cuadrado.getTrazo(3);
    
    System.out.print("(" + (int) linea3C.getInicio().getX() + "," + (int) linea3C.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea3C.getFin().getX() + "," + (int) linea3C.getFin().getY() + ")");
    
    // Cuarto trazo e impresión de coordenadas. Giramos 90º y desplazamos 20.
    
    cuadrado.gira(-90);
    
    cuadrado.desplaza(20);
    
    Linea linea4C = cuadrado.getTrazo(4);
    
    System.out.print("(" + (int) linea4C.getInicio().getX() + "," + (int) linea4C.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea4C.getFin().getX() + "," + (int) linea4C.getFin().getY() + ")");
    
    // Terminamos el trazado del cuadrado
    
    cuadrado.sube();
    
    // -----------------------------------------------------------------------------------------------------------------------
    
    System.out.println("\n\nCoordenadas de los vértices del triángulo: ");
    
    Lapiz triangulo = new Lapiz();
    
    // Inicio del trazado del triángulo
    
    triangulo.mueve(INICIO_TRIANGULO);
    
    triangulo.baja();
    
    // Primer trazo del triángulo e impresión de coordenadas
    
    triangulo.desplaza(30);
    
    Linea linea1T = triangulo.getTrazo(1);
    
    System.out.print("(" + (int) linea1T.getInicio().getX() + "," + (int) linea1T.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea1T.getFin().getX() + "," + (int) linea1T.getFin().getY() + ")");
    
    // Segundo trazo del triángulo e impresión de coordenadas
    
    triangulo.gira(120);
    
    triangulo.desplaza(30);
    
    Linea linea2T = triangulo.getTrazo(2);
    
    System.out.print("(" + (int) linea2T.getInicio().getX() + "," + (int) linea2T.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea2T.getFin().getX() + "," + (int) linea2T.getFin().getY() + ")");
    
    // Tercer trazo del triángulo e impresión de coordenadas
    
    triangulo.gira(120);
    
    triangulo.desplaza(30);
    
    Linea linea3T = triangulo.getTrazo(3);
    
    System.out.print("(" + (int) linea3T.getInicio().getX() + "," + (int) linea3T.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea3T.getFin().getX() + "," + (int) linea3T.getFin().getY() + ")");
    
    // Terminamos el trazado del triángulo
    
    triangulo.sube();
    
    // -----------------------------------------------------------------------------------------------------------------------
    
    System.out.println("\n\nCoordenadas de los vértices del pentágono: ");
    
    Lapiz pentagono = new Lapiz();
    
    // Iniciamos el trazado del pentágono
    
    pentagono.mueve(INICIO_PENTAGONO);
    
    pentagono.baja();
    
    // Primer trazo del pentágono e impresión de coordenadas
    
    pentagono.desplaza(20);
    
    Linea linea1P = pentagono.getTrazo(1);
    
    System.out.print("(" + (int) linea1P.getInicio().getX() + "," + (int) linea1P.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea1P.getFin().getX() + "," + (int) linea1P.getFin().getY() + ")");
    
    // Segundo trazo del pentágono e impresión de coordenadas
    
    pentagono.gira(72);
    
    pentagono.desplaza(20);
    
    Linea linea2P = pentagono.getTrazo(2);
    
    System.out.print("(" + (int) linea2P.getInicio().getX() + "," + (int) linea2P.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea2P.getFin().getX() + "," + (int) linea2P.getFin().getY() + ")");
    
    // Tercer trazo del pentágono e impresión de coordenadas
    
    pentagono.gira(72);
    
    pentagono.desplaza(20);
    
    Linea linea3P = pentagono.getTrazo(3);
    
    System.out.print("(" + (int) linea3P.getInicio().getX() + "," + (int) linea3P.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea3P.getFin().getX() + "," + (int) linea3P.getFin().getY() + ")");
    
    // Cuarto trazo del pentágono e impresión de coordenadas
    
    pentagono.gira(72);
    
    pentagono.desplaza(20);
    
    Linea linea4P = pentagono.getTrazo(4);
    
    System.out.print("(" + (int) linea4P.getInicio().getX() + "," + (int) linea4P.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea4P.getFin().getX() + "," + (int) linea4P.getFin().getY() + ")");
    
    // Quinto trazo del pentágono e impresión de coordenadas
    
    pentagono.gira(72);
    
    pentagono.desplaza(20);
    
    Linea linea5P = pentagono.getTrazo(5);
    
    System.out.print("(" + (int) linea5P.getInicio().getX() + "," + (int) linea5P.getInicio().getY() + ") - ");
    
    System.out.println("(" + (int) linea5P.getFin().getX() + "," + (int) linea5P.getFin().getY() + ")");
    
    pentagono.sube();
    
    
    
  }

}
