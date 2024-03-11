package prog.unidad05.gui.ejercicio07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlumnosConNotasSwingApp {

  // Bloque de constantes
  private static final int NUMERO_MINIMO = 0;
  private static final int NUMERO_MAXIMO = 10;
  private static final int CANTIDAD_NUMEROS = 30;
  
  // Mapa de frecuencias
  private Map<Integer, Integer> mapaFrecuencias;
  
  private JFrame frame;
  DefaultListModel<Integer> modeloLista;
  private JComboBox cbSeleccion;
  private JLabel lblResultado;
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AlumnosConNotasSwingApp window = new AlumnosConNotasSwingApp();
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
  public AlumnosConNotasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JList txtList = new JList();
    
    modeloLista = new DefaultListModel<>();
    Random generadorAleatorios = new Random();
    for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
      modeloLista.addElement(generadorAleatorios.nextInt(NUMERO_MINIMO, NUMERO_MAXIMO + 1));
    }
    
    generaMapaFrecuencias();
    
    txtList.setModel(modeloLista);
    
    txtList.setFont(new Font("Tahoma", Font.BOLD, 12));

    
    JScrollPane scrollPane = new JScrollPane();
    
    cbSeleccion = new JComboBox();
    cbSeleccion.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setNumeroMasRepetido();
      }
    });
    
    DefaultComboBoxModel<Integer> cbModelo = new DefaultComboBoxModel<>();
    for (int i = NUMERO_MINIMO; i <= NUMERO_MAXIMO; i++) {
      cbModelo.addElement(i);
    }
    
    cbSeleccion.setModel(cbModelo);
    
    cbSeleccion.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    lblResultado = new JLabel("                            ");
    lblResultado.setFont(new Font("Tahoma", Font.BOLD, 12));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(20)
              .addComponent(cbSeleccion, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
              .addGap(39)
              .addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(cbSeleccion, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(51, Short.MAX_VALUE))
    );
    
    scrollPane.setViewportView(txtList);
    frame.getContentPane().setLayout(groupLayout);
  }
  
  /**
   * Método que establece el resultado una vez se ha elegido un elemento del combobox
   */
  protected void setNumeroMasRepetido() {
 // Se puede realizar el casting a Integer porque por defecto se almacenan así
    Integer selectedItem = (Integer) cbSeleccion.getSelectedItem();
    
    Integer frecuencia = mapaFrecuencias.get(selectedItem);
    
    lblResultado.setText(String.format("Hay %d alumnos con una calificación de %d", 
        (frecuencia != null) ? frecuencia : 0, selectedItem));
    
    
  }

  /*
   * Método que genera un mapa de frecuencias con el que obtener los datos de la lista y la cantidad
   * de apariciones de cada uno
   */
  private void generaMapaFrecuencias() {
    
    // Se genera el mapa nuevo
    mapaFrecuencias = new HashMap<>();
    
    for (Object numeroObj : modeloLista.toArray()) {
      
      // Conversión posible debido a la inserción previa del tipo Integer
      Integer numero = (Integer) numeroObj;
      
      // Se actualiza el mapa de frecuencias por cada objecto. Si no está, se establece a 1
      if (mapaFrecuencias.get(numero) != null) {
        mapaFrecuencias.put(numero, mapaFrecuencias.get(numero) + 1);
        
      } else {
        mapaFrecuencias.put(numero, 1);
      }
      
    }
    
  }
}
