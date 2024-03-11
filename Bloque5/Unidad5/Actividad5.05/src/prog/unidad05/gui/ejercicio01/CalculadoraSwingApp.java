package prog.unidad05.gui.ejercicio01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraSwingApp {

  private JFrame frame;
  private JTextField txtOperando1;
  private JTextField txtOperando2;
  private JLabel txtResultado;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CalculadoraSwingApp window = new CalculadoraSwingApp();
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
  public CalculadoraSwingApp() {
    initialize();
  }

  
  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 579, 279);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblOperando1 = new JLabel("Primer operando:");
    lblOperando1.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    JLabel lblOperando2 = new JLabel("Segundo operando:");
    lblOperando2.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    JLabel lblResultado = new JLabel("Resultado:");
    lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    txtOperando1 = new JTextField();
    txtOperando1.setText("0");
    txtOperando1.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtOperando1.setColumns(10);
    
    txtOperando2 = new JTextField();
    txtOperando2.setText("0");
    txtOperando2.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txtOperando2.setColumns(10);
    
    txtResultado = new JLabel("                 ");
    txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    JButton btnSumar = new JButton("Suma");
    btnSumar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Double[] numeros = convierteNumeros();
        operaNumeros(numeros, 0);
      }


    });
    btnSumar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    JButton btnResta = new JButton("Resta");
    btnResta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Double[] numeros = convierteNumeros();
        operaNumeros(numeros, 1);
      }
    });
    btnResta.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    JButton btnProducto = new JButton("Producto");
    btnProducto.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Double[] numeros = convierteNumeros();
        operaNumeros(numeros, 2);
      }
    });
    btnProducto.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    JButton btnDivisin = new JButton("División");
    btnDivisin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Double[] numeros = convierteNumeros();
        operaNumeros(numeros, 3);
      }
    });
    btnDivisin.setFont(new Font("Tahoma", Font.PLAIN, 12));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(30)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
            .addComponent(lblOperando2, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
            .addComponent(lblOperando1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
            .addComponent(txtOperando1, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
            .addComponent(txtOperando2, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
            .addComponent(txtResultado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGap(105)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
              .addComponent(btnSumar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(btnResta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                .addComponent(btnProducto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)))
            .addComponent(btnDivisin, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
          .addGap(349))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(26)
          .addComponent(btnSumar)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblOperando1)
            .addComponent(txtOperando1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnResta, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(20)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblOperando2)
                .addComponent(txtOperando2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
              .addGap(46)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblResultado)
                .addComponent(txtResultado)
                .addComponent(btnDivisin, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(34)
              .addComponent(btnProducto, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(83, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
  
  /**
   * Método que convierte los números introducidos en los cuadros de texto a números reales
   * @return Un array de 2 elementos con los números en el mismo orden que se han introducido
   *  si son correctos, o un array vacío si alguno de los 2 es incorrecto
   */
  private Double[] convierteNumeros() {
    Double[] numeros = new Double[2];
    
    try {
      numeros[0] = Double.parseDouble(txtOperando1.getText());
      numeros[1] = Double.parseDouble(txtOperando2.getText());
      
      return numeros;
      
    } catch (NumberFormatException e) {
      return new Double[0];
    }
  }
  
  /**
   * Método que opera 2 números y establece el resultado en el texto de la aplicación gráfica
   * @param numeros Números con los cuales operar
   * @param operacion Operación a realizar. Si es 0, se realizará una suma. Si es 1, se realizará una
   * resta. Si es 2, se realizará el producto. Si es 3, se realizará la división
   * @throws IllegalArgumentException En caso de que se introduzca una operación errónea
   */
  private void operaNumeros(Double[] numeros, int operacion) {
    if (numeros.length == 0) {
      txtResultado.setText("NaN");
      JOptionPane.showMessageDialog(frame, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
      switch(operacion) {
        case 0:
          txtResultado.setText(String.valueOf(numeros[0] + numeros[1]));
          break;
        case 1: 
          txtResultado.setText(String.valueOf(numeros[0] - numeros[1]));
          break;        
        case 2: 
          txtResultado.setText(String.valueOf(numeros[0] * numeros[1]));
          break;        
        case 3: 
          if (numeros[1] == 0) {
            txtResultado.setText("NaN");
            JOptionPane.showMessageDialog(frame, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
          } else {
            txtResultado.setText(String.valueOf(numeros[0] / numeros[1]));
          }
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
  }
}
