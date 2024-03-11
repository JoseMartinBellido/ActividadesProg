package prog.unidad05.gui.ejercicio09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;

public class OrdenaLineasSwingApp {

  private JFrame frame;
  private JTextArea txtAreaOrdenado;
  private JTextArea txtAreaOriginal;
  private JButton btnOrdenar;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          OrdenaLineasSwingApp window = new OrdenaLineasSwingApp();
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
  public OrdenaLineasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 522, 482);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblNewLabel = new JLabel("Texto Original:");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
    
    JScrollPane scrollPane = new JScrollPane();
    
    JLabel lblTextoOrdenado = new JLabel("Texto Ordenado:");
    lblTextoOrdenado.setFont(new Font("Tahoma", Font.BOLD, 13));
    
    JScrollPane scrollPane_1 = new JScrollPane();
    
    btnOrdenar = new JButton("Ordenar");
    btnOrdenar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ordenaTexto();
      }
    });
    btnOrdenar.setFont(new Font("Tahoma", Font.BOLD, 14));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTextoOrdenado, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(205)
              .addComponent(btnOrdenar)))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblNewLabel)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblTextoOrdenado, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnOrdenar)
          .addContainerGap(51, Short.MAX_VALUE))
    );
    
    txtAreaOriginal = new JTextArea();
    scrollPane.setViewportView(txtAreaOriginal);
    
    txtAreaOrdenado = new JTextArea();
    txtAreaOrdenado.setEnabled(false);
    txtAreaOrdenado.setEditable(false);
    scrollPane_1.setViewportView(txtAreaOrdenado);
    frame.getContentPane().setLayout(groupLayout);
  }

  /**
   * Método que ordena el texto original introducido por el usuario, sin contar las líneas en blanco, 
   * y las imprime de forma ordenada en el cuadro de texto inferior
   */
  protected void ordenaTexto() {
    // Se obtiene el texto y se divide por saltos de línea
    List<String> lineas = new ArrayList<>();
    String[] lineasArray = txtAreaOriginal.getText().split("\n");
    
    // Se filtra el array obtenido
    for (String linea: lineasArray) {
      if (!linea.isBlank()) {
        lineas.add(linea);  
      }
    }

    // Se ordena la lista y se imprime
    lineas.sort(null);
    for (String linea : lineas) {
      txtAreaOrdenado.setText(txtAreaOrdenado.getText() + linea + "\n");
    }
  }
}
