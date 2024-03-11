package prog.unidad05.gui.ejercicio02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ContarPalabrasSwingApp {

  private JFrame frame;
  
  private Map<String, Integer> mapaFrecuencias;
  private JTextArea txtArea;
  private JLabel lblResultado;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ContarPalabrasSwingApp window = new ContarPalabrasSwingApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public ContarPalabrasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 495, 355);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    JButton btnNewButton = new JButton("Contar Palabras");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Se obtiene la palabra más frecuente y su frecuencia
        String textoResultado = getPalabraMasFrecuenteTexto();
        
        String palabra = textoResultado.split(":")[0];
        int frecuencia = Integer.parseInt(textoResultado.split(":")[1]);
        
        // Se escribe el resultado
        lblResultado.setText(String.format("La palabra más frecuente es: \"%s\"(%d)", 
            palabra, frecuencia));
      }
    });
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    lblResultado = new JLabel("              ");
    lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
              .addGroup(groupLayout.createSequentialGroup()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
              .addGroup(groupLayout.createSequentialGroup()
                .addComponent(btnNewButton)
                .addGap(174)))
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
              .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
              .addGap(81))))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(33)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnNewButton)
          .addGap(18)
          .addComponent(lblResultado)
          .addContainerGap(30, Short.MAX_VALUE))
    );
    
    txtArea = new JTextArea();
    txtArea.setWrapStyleWord(true);
    txtArea.setLineWrap(true);
    scrollPane.setViewportView(txtArea);
    frame.getContentPane().setLayout(groupLayout);
  }

  /*
   * Método que procesa el texto obtenido y cuenta las palabras para obtener la más repetida
   * @return Un texto en formato "P:C" donde P es la palabra más repetida y C la cantidad de veces que 
   * aparece dicha palabra
   */
  private String getPalabraMasFrecuenteTexto() {
    
    actualizaMapaFrecuencias();
    
    // Palabra y frecuencia a devolver
    String palabraMasFrecuente = "";
    Integer frecuencia = 0;
    
    // Se recorre el mapa de frecuencias para encontrar la palabra más frecuente
    for (String palabra : mapaFrecuencias.keySet()) {
      if (mapaFrecuencias.get(palabra) > frecuencia) {
        palabraMasFrecuente = palabra;
        frecuencia = mapaFrecuencias.get(palabra);
      }
    }
    
    return String.format("%s:%d", palabraMasFrecuente, frecuencia);
    
  }
  
  /**
   * Método que actualiza el mapa de frecuencias una vez se pulsa el botón
   */
  private void actualizaMapaFrecuencias() {
    // Inicialización/Reseteo del mapa de frecuencias
    mapaFrecuencias = new HashMap<>();
    
    // Palabras separadas del texto
    String[] palabras = txtArea.getText().split("[\\.,;\\s¿¡?!/«»]+");
    
    // Por cada palabra, se comprueba si está en el mapa. Si está, se suma 1 a la frecuencia.
    // Si no está, se añade
    for (String palabra : palabras) {
      Integer cantidad = mapaFrecuencias.get(palabra);
      
      if (cantidad == null) {
        mapaFrecuencias.put(palabra, 1);
        
      } else {
        mapaFrecuencias.put(palabra, mapaFrecuencias.get(palabra) + 1);
      }
    }
  }
}
