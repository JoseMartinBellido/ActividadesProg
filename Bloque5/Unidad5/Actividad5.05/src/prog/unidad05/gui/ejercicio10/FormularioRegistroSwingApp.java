package prog.unidad05.gui.ejercicio10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioRegistroSwingApp {

  // Bloque de constantes para el ciclo 
  private static final String CICLO_ASIR = "ASIR";
  private static final String CICLO_DAM = "DAM";
  private static final String CICLO_DAW = "DAW";
  
  // Bloque de constantes para la titulación presentada
  private static final String TITULACION_BACHILLERATO = "Bachillerato";
  private static final String TITULACION_PRUEBA_DE_ACCESO = "Prueba de Acceso";
  
  private JFrame frame;
  private JTextField txtUser;
  private JTextField txtPassword;
  private JTextField txtPasswordRepetida;
  private JLabel lblCicloAlQue;
  private JRadioButton rdbtnBachillerato;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JCheckBox chckbxCertificadoDeNotas;
  private JCheckBox chckbxTituloOficial;
  private JCheckBox chckbxConvalidacion;
  private JCheckBox chckbxDni;
  private JButton btnRegistrar;
  private JComboBox cbCiclo;
  private JRadioButton rdbtnPruebaDeAcceso;
  private JTextArea txtResultado;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          FormularioRegistroSwingApp window = new FormularioRegistroSwingApp();
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
  public FormularioRegistroSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 624, 655);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblNewLabel = new JLabel("Nombre de Usuario:");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    txtUser = new JTextField();
    txtUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtUser.setColumns(10);
    
    JLabel lblPassword = new JLabel("Password:");
    lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    txtPassword = new JTextField();
    txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtPassword.setColumns(10);
    
    JLabel lblRepitePassword = new JLabel("Repite Password:");
    lblRepitePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    txtPasswordRepetida = new JTextField();
    txtPasswordRepetida.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtPasswordRepetida.setColumns(10);
    
    lblCicloAlQue = new JLabel("Ciclo al que se presenta:");
    lblCicloAlQue.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    cbCiclo = new JComboBox();
    DefaultComboBoxModel<String> cbModelo = new DefaultComboBoxModel<>();
    cbModelo.addElement(CICLO_ASIR);
    cbModelo.addElement(CICLO_DAM);
    cbModelo.addElement(CICLO_DAW);
    cbCiclo.setModel(cbModelo);
    
    
    JPanel panel = new JPanel();
    panel.setBorder(new TitledBorder(null, "Titulaci\u00F3n que presenta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    
    JPanel panel_1 = new JPanel();
    panel_1.setBorder(new TitledBorder(null, "Documentaci\u00F3n que aporta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    
    btnRegistrar = new JButton("Registrar");
    btnRegistrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        // Se verifica primero que las contraseñas sean iguales
        String password = txtPassword.getText();
        String passwordRepetida = txtPasswordRepetida.getText();
        
        // Si las contraseñas no son iguales, se lanza la excepción de contraseña incorrecta
        if (password.equals(passwordRepetida)) {
       // Se intenta devolver al usuario
          try {
            Usuario usuario = registraUsuario();
            String informacionUsuario = getInfoUsuario(usuario);
            txtResultado.setText(informacionUsuario);
            
          } catch (NombreUsuarioException exception) {
            JOptionPane.showMessageDialog(frame, "Nombre incorrecto. Debe tener una longitud de entre 1 y "
                + "8 caracteres");  
          } catch (PasswordUsuarioException exception) {
            JOptionPane.showMessageDialog(frame, "Contraseña incorrecta. Ambas contraseñas deben ser "
                + "iguales.Debe tener una longitud de entre 1 y 8 caracteres.");  
          } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(frame, "Es necesario marcar al menos una opción en cada bloque "
                + "delformulario");  
          }
        } else {
          JOptionPane.showMessageDialog(frame, "Las contraseñas deben coincidir.");
        }
        
      }
    });
    btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
    
    JScrollPane scrollPane = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblCicloAlQue, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(cbCiclo, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel))
              .addGap(20)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                  .addGap(28)
                  .addComponent(lblRepitePassword, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                  .addGap(10)
                  .addComponent(txtPasswordRepetida, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
            .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(89))
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
          .addGap(88))
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(255)
          .addComponent(btnRegistrar)
          .addContainerGap(326, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblRepitePassword, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
            .addComponent(txtPasswordRepetida, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addComponent(lblCicloAlQue, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
            .addComponent(cbCiclo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(28)
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(btnRegistrar)
          .addGap(14)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(34, Short.MAX_VALUE))
    );
    
    txtResultado = new JTextArea();
    txtResultado.setEditable(false);
    scrollPane.setViewportView(txtResultado);
    
    chckbxTituloOficial = new JCheckBox("Titulo Oficial");
    chckbxTituloOficial.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    chckbxCertificadoDeNotas = new JCheckBox("Certificado de Notas");
    chckbxCertificadoDeNotas.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    chckbxConvalidacion = new JCheckBox("Convalidación");
    chckbxConvalidacion.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    chckbxDni = new JCheckBox("DNI");
    chckbxDni.setFont(new Font("Tahoma", Font.BOLD, 12));
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(
      gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addComponent(chckbxTituloOficial, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
            .addComponent(chckbxCertificadoDeNotas, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addComponent(chckbxDni, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
            .addComponent(chckbxConvalidacion, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(30, Short.MAX_VALUE))
    );
    gl_panel_1.setVerticalGroup(
      gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
            .addComponent(chckbxTituloOficial)
            .addComponent(chckbxConvalidacion, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
            .addComponent(chckbxCertificadoDeNotas, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addComponent(chckbxDni, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(15, Short.MAX_VALUE))
    );
    panel_1.setLayout(gl_panel_1);
    
    rdbtnBachillerato = new JRadioButton("Bachillerato");
    buttonGroup.add(rdbtnBachillerato);
    rdbtnBachillerato.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    rdbtnPruebaDeAcceso = new JRadioButton("Prueba de Acceso");
    buttonGroup.add(rdbtnPruebaDeAcceso);
    rdbtnPruebaDeAcceso.setFont(new Font("Tahoma", Font.BOLD, 12));
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
            .addComponent(rdbtnBachillerato, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
            .addComponent(rdbtnPruebaDeAcceso, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
          .addContainerGap())
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addContainerGap()
          .addComponent(rdbtnBachillerato)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(rdbtnPruebaDeAcceso, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(22, Short.MAX_VALUE))
    );
    panel.setLayout(gl_panel);
    frame.getContentPane().setLayout(groupLayout);
  }

  /**
   * Método que registra un nuevo usuario dado los datos del formulario
   * @return Un nuevo Usuario ya formado
   * @throws NombreUsuarioException En caso de tener un nombre incorrecto
   * @throws PasswordUsuarioException En caso de tener una contraseña incorrecta
   * @throws IllegalArgumentException En caso de que alguno de los parámetros restantes sea incorrecto
   */
  private Usuario registraUsuario() {

    // Se obtienen los valores
    String nombre = txtUser.getText();
    String password = txtPassword.getText();
    
    // Ciclo solicitado
    String cicloSolicitado = (String) cbCiclo.getSelectedItem();
    
    //Titulación presentada
    String titulacionPresentada = getTxtTitulacion();
   
    // Documentación aportada
    String documentacionAportada = getTxtDocumentacion();
    
    return new Usuario(nombre, password, cicloSolicitado, titulacionPresentada, documentacionAportada);
    
  }
  
  /**
   * Método que obtiene el texto perteneciente a la titulación presentada
   * @return texto perteneciente a la titulación presentada. Devolverá una cadena vacía si no hay
   * ninguna opción marcada
   */
  private String getTxtTitulacion() {
    String titulacionPresentada = "";
    // Por el grupo de radiobutton, no pueden estar ambas seleccionadas a la vez
    if (rdbtnBachillerato.isSelected()) {
      titulacionPresentada = TITULACION_BACHILLERATO;
    }
    
    if (rdbtnPruebaDeAcceso.isSelected()) {
      titulacionPresentada = TITULACION_PRUEBA_DE_ACCESO;
    }
    
    return titulacionPresentada;
  }
  
  private String getTxtDocumentacion() {
    
    String documentacionAportada = "";
    
    documentacionAportada += (chckbxTituloOficial.isSelected()) ? "Titulo Oficial, " : "";
    documentacionAportada += (chckbxCertificadoDeNotas.isSelected()) ? "Certificado de Notas, " : "";
    documentacionAportada += (chckbxConvalidacion.isSelected()) ? "Convalidación, " : "";
    documentacionAportada += (chckbxDni.isSelected()) ? "DNI, " : "";

    return (!documentacionAportada.isEmpty()) ?
        documentacionAportada.substring(0, documentacionAportada.length() - 2) : "";
  }
  
  /**
   * Método que imprime toda la información relativa a un usuario
   * @param usuario Usuario aportado
   * @return 
   */
  protected String getInfoUsuario(Usuario usuario) {
    String resultado = "";
    
    resultado += String.format("Nombre de Usuario: %s%n", usuario.getNombre());
    resultado += String.format("Contraseña: %s%n", usuario.getPassword());
    resultado += String.format("Ciclo en el que se matricula: %s%n", usuario.getCicloSolicitud());
    resultado += String.format("Titulación que presenta: %s%n", usuario.getTitulacionPresentada());
    resultado += String.format("Documentos que presenta: %s%n", usuario.getDocumentacionAportada());
    
    return resultado;
  }
  
}
