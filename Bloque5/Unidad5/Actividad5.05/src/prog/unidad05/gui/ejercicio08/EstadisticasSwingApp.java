package prog.unidad05.gui.ejercicio08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class EstadisticasSwingApp {

  private JFrame frame;
  private JTextField txtCantidadAGenerar;
  private JTextField txtValorMinimo;
  private JTextField txtValorMaximo;
  private JButton btnGenerar;
  private JList txtListaAleatorios;
  private JLabel lblMedia;
  private JList txtListInferiorMedia;
  private JList txtListSuperiorMedia;
  DefaultListModel<Integer> modeloListaAleatorios;
  DefaultListModel<Integer> modeloListaSuperiorMedia;
  DefaultListModel<Integer> modeloListaInferiorMedia;
  
  
  // Variables del programa
  Integer cantidadNumeros;
  Integer valorMinimo;
  Integer valorMaximo;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          EstadisticasSwingApp window = new EstadisticasSwingApp();
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
  public EstadisticasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 573, 562);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblNewLabel = new JLabel("Cantidad de números a generar (mínimo 3):");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    txtCantidadAGenerar = new JTextField();
    txtCantidadAGenerar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtCantidadAGenerar.setColumns(10);
    
    JLabel lblValorMnimoDe = new JLabel("Valor mínimo de los números a generar:");
    lblValorMnimoDe.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    txtValorMinimo = new JTextField();
    txtValorMinimo.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtValorMinimo.setColumns(10);
    
    JLabel lblValorMnimoDe_2 = new JLabel("Valor mínimo de los números a generar:");
    lblValorMnimoDe_2.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    txtValorMaximo = new JTextField();
    txtValorMaximo.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtValorMaximo.setColumns(10);
    
    btnGenerar = new JButton("Generar");
    btnGenerar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (compruebaValores()) {
          generaListas();
          
        } else {
          JOptionPane.showMessageDialog(frame, "Alguno de los parámetros no tiene un valor correcto.");
        }
      }
    });
    btnGenerar.setFont(new Font("Tahoma", Font.BOLD, 13));
    
    JScrollPane scrollPane = new JScrollPane();
    
    JLabel lblNewLabel_1 = new JLabel("Lista generada:");
    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    lblMedia = new JLabel("                     ");
    lblMedia.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    JScrollPane scrollPane_1 = new JScrollPane();
    
    JScrollPane scrollPane_2 = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                      .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblValorMnimoDe_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED))
                      .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(lblValorMnimoDe, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)))
                    .addGroup(groupLayout.createSequentialGroup()
                      .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(ComponentPlacement.RELATED)))
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(txtCantidadAGenerar, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addComponent(txtValorMinimo, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                      .addGap(18)
                      .addComponent(btnGenerar))
                    .addComponent(txtValorMaximo, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                  .addGap(37)
                  .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
              .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
              .addGap(13))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblMedia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGap(36))))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtCantidadAGenerar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtValorMinimo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnGenerar)
            .addComponent(lblValorMnimoDe, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtValorMaximo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblValorMnimoDe_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
          .addGap(20)
          .addComponent(lblNewLabel_1)
          .addGap(18)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblMedia)
          .addGap(15)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
            .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    
    txtListSuperiorMedia = new JList();

    scrollPane_2.setViewportView(txtListSuperiorMedia);
    
    txtListInferiorMedia = new JList();

    scrollPane_1.setViewportView(txtListInferiorMedia);
    
    txtListaAleatorios = new JList();
    
    scrollPane.setViewportView(txtListaAleatorios);
    frame.getContentPane().setLayout(groupLayout);
  }

  /**
   * Método que genera la lista de números aleatorios
   */
  protected void generaListas() {

    // Se resetean los modelos, ya que es posible que se pulse el botón de generar varias veces
    modeloListaAleatorios = new DefaultListModel<>();
    txtListaAleatorios.setModel(modeloListaAleatorios);
    
    
    modeloListaInferiorMedia = new DefaultListModel<Integer>();
    txtListInferiorMedia.setModel(modeloListaInferiorMedia);
    
    modeloListaSuperiorMedia = new DefaultListModel<>();
    txtListSuperiorMedia.setModel(modeloListaSuperiorMedia);
    
    // Generador de aleatorios y variable para la media
    Random generadorAleatorios = new Random();
    double media = 0;
    
    // Se rellena el modelo con los números aleatorios y se calcula la media
    for (int i = 0; i < cantidadNumeros; i++) {
      Integer numero = generadorAleatorios.nextInt(valorMinimo, valorMaximo + 1);
      media += numero;
      modeloListaAleatorios.addElement(numero);
    }
    
    media = media / cantidadNumeros;
    lblMedia.setText(String.format("La media vale: %f", media));
    
    // Se recorre la lista para separar los valores
    for (Object numeroObj : modeloListaAleatorios.toArray()) {
      Integer numero = (Integer) numeroObj;
      
      if (numero < media) {
        modeloListaInferiorMedia.addElement(numero);
      } else {
        modeloListaSuperiorMedia.addElement(numero);
      }
      
    }
  }

  /**
   * Método que verifica los valores introducidos en el texto y, si son correctos, los establece para 
   * un uso posterior en el programa
   * @return true si los valores son correctos, false en caso contrario
   */
  protected boolean compruebaValores() {
    
    try {
      cantidadNumeros = Integer.parseInt(txtCantidadAGenerar.getText());
      valorMinimo = Integer.parseInt(txtValorMinimo.getText());
      valorMaximo = Integer.parseInt(txtValorMaximo.getText());
      
      return cantidadNumeros > 2 && valorMaximo > valorMinimo;
    } catch (NumberFormatException e) {
      return false;
    }
    
  }
}
