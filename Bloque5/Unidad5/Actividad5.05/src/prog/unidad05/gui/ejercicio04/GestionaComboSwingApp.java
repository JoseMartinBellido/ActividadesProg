package prog.unidad05.gui.ejercicio04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionaComboSwingApp {

  private JFrame frame;
  private JComboBox cbLista;
  private JTextField txtAgregar;
  private DefaultComboBoxModel<String> cbModel;
  private JButton btnNewButton;
  private JButton btnEliminar;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionaComboSwingApp window = new GestionaComboSwingApp();
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
  public GestionaComboSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 372, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    cbLista = new JComboBox();
    cbLista.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    cbModel = new DefaultComboBoxModel<>();
    cbLista.setModel(cbModel);
    
    txtAgregar = new JTextField();
    txtAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtAgregar.setColumns(10);
    
    btnNewButton = new JButton("Añadir");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        agregarEntradaLista();
      }
    });
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        eliminarDeEntrada();
      }
    });
    btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
            .addComponent(cbLista, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
              .addComponent(txtAgregar, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))))
          .addContainerGap(87, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(32)
          .addComponent(cbLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(59)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtAgregar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(86, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }

  protected void eliminarDeEntrada() {
    // Un elemento de la lista es siempre String
    String selectedValue = (String) cbLista.getSelectedItem();
    
    if (selectedValue != null) {
      cbModel.removeElement(selectedValue);
    } 
  }

  protected void agregarEntradaLista() {
    String selectedValue = txtAgregar.getText();
    
    if (!selectedValue.isBlank()) {
      cbModel.addElement(selectedValue);

    }
  }
}
