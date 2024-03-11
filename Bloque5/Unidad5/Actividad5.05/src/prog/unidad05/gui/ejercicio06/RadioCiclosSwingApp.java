package prog.unidad05.gui.ejercicio06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RadioCiclosSwingApp {

  private JFrame frame;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JLabel lblResultado;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RadioCiclosSwingApp window = new RadioCiclosSwingApp();
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
  public RadioCiclosSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 224);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setBorder(new TitledBorder(null, "Ciclo a cursar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    
    JLabel lblNewLabel = new JLabel("El ciclo que quieres cursar es:");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    lblResultado = new JLabel("         ");
    lblResultado.setFont(new Font("Tahoma", Font.BOLD, 13));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
            .addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addContainerGap(13, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblNewLabel)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblResultado)
          .addContainerGap(25, Short.MAX_VALUE))
    );
    
    JRadioButton rdbtnASIR = new JRadioButton("Administración de Sistemas Informáticos y redes");
    rdbtnASIR.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        lblResultado.setText("ASIR");
      }
    });
    buttonGroup.add(rdbtnASIR);
    rdbtnASIR.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    JRadioButton rdbtnDAM = new JRadioButton("Desarrollo de Aplicaciones Multiplataforma");
    rdbtnDAM.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        lblResultado.setText("DAM");
      }
    });
    buttonGroup.add(rdbtnDAM);
    rdbtnDAM.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    JRadioButton rdbtnDAW = new JRadioButton("Desarrollo de Aplicaciones Web");
    rdbtnDAW.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        lblResultado.setText("DAW");
      }
    });
    buttonGroup.add(rdbtnDAW);
    rdbtnDAW.setFont(new Font("Tahoma", Font.BOLD, 12));
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addComponent(rdbtnASIR, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
            .addComponent(rdbtnDAM, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
            .addComponent(rdbtnDAW, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
          .addContainerGap())
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addContainerGap()
          .addComponent(rdbtnASIR)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(rdbtnDAM)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(rdbtnDAW)
          .addContainerGap(24, Short.MAX_VALUE))
    );
    panel.setLayout(gl_panel);
    frame.getContentPane().setLayout(groupLayout);
  }
}
