package prog.unidad05.gui.ejercicio03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionaListaSwingApp {

  private JFrame frame;
  private JList txtList;
  private JTextField txtAgregar;
  private DefaultListModel<String> modelo;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionaListaSwingApp window = new GestionaListaSwingApp();
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
  public GestionaListaSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    txtAgregar = new JTextField();
    txtAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtAgregar.setColumns(10);
    
    JButton btnAdd = new JButton("Añadir");
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        agregaLista();
      }
    });
    btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    JButton btnRemove = new JButton("Eliminar");
    btnRemove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        eliminaDeLista();
      }
    });
    btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 13));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
              .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
              .addComponent(txtAgregar, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
              .addGap(34))))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtAgregar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(32, Short.MAX_VALUE))
    );
    
    txtList = new JList();
    
    modelo = new DefaultListModel<>();
    txtList.setModel(modelo);
    
    
    
    txtList.setFont(new Font("Tahoma", Font.PLAIN, 12));
    scrollPane.setViewportView(txtList);
    frame.getContentPane().setLayout(groupLayout);
  }

  /**
   * Método que elimina un elemento de la lista si hay alguno seleccionado
   */
  private void eliminaDeLista() {
    // Un elemento de la lista es siempre String
    String selectedValue = (String) txtList.getSelectedValue();
    
    if (selectedValue != null) {
      modelo.removeElement(selectedValue);
    }
  }

  /**
   * Método que agrega un elemento en el modelo de la lista siempre que se haya escrito algo. 
   * Si no se ha escrito nada, no hace nada
   */
  private void agregaLista() {
    
      String selectedValue = txtAgregar.getText();
      
      if (!selectedValue.isBlank()) {
        modelo.addElement(selectedValue);

      }
  }
  
  
  
  
}
