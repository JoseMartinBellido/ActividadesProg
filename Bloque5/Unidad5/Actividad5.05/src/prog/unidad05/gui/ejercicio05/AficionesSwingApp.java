package prog.unidad05.gui.ejercicio05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AficionesSwingApp {

  private JFrame frame;
  private JLabel lblResultado;
  private JCheckBox chckbxLectura;
  private JCheckBox chckbxSeries;
  private JCheckBox chckbxComic;
  private JCheckBox chckbxAnime;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AficionesSwingApp window = new AficionesSwingApp();
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
  public AficionesSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setBorder(new TitledBorder(null, "Aficiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    
    JLabel lblNewLabel = new JLabel("Tus aficiones son:");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    lblResultado = new JLabel("              ");
    lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(42)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(panel, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
              .addContainerGap())
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addComponent(lblResultado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
              .addContainerGap(174, Short.MAX_VALUE))))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(28)
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblNewLabel)
          .addGap(18)
          .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(49, Short.MAX_VALUE))
    );
    
    chckbxSeries = new JCheckBox("Series");
    chckbxSeries.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setTextoAficiones();
      }
    });
    
    chckbxLectura = new JCheckBox("Lectura");
    chckbxLectura.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setTextoAficiones();
      }
    });
    
    chckbxComic = new JCheckBox("Comic");
    chckbxComic.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setTextoAficiones();
      }
    });
    
    chckbxAnime = new JCheckBox("Anime");
    chckbxAnime.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setTextoAficiones();
      }
    });
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addComponent(chckbxLectura)
            .addComponent(chckbxSeries)
            .addComponent(chckbxComic, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
            .addComponent(chckbxAnime, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(226, Short.MAX_VALUE))
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addContainerGap()
          .addComponent(chckbxLectura)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(chckbxSeries)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(chckbxComic)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(chckbxAnime)
          .addContainerGap(19, Short.MAX_VALUE))
    );
    panel.setLayout(gl_panel);
    frame.getContentPane().setLayout(groupLayout);
  }

  protected void setTextoAficiones() {

    String resultado = "";
    
    resultado += chckbxLectura.isSelected() ? "Lectura " : "";
    resultado += chckbxSeries.isSelected() ? "Series " : "";
    resultado += chckbxComic.isSelected() ? "Comic " : "";
    resultado += chckbxAnime.isSelected() ? "Anime " : "";
    
    lblResultado.setText(resultado);
    
  }
}
