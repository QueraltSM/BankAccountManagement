/**
 * Created by QSM on 19/5/17.
 */
import javafx.scene.control.RadioButton;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IngresarRetirarGUI extends JFrame {
        private JFrame frame = new JFrame();
        private JLabel etiqueta = new JLabel("Introduzca cantidad: ");
        private JTextField cantidad = new JTextField(5);
        private JPanel p = new JPanel();
        private JButton salir = new JButton("Salir");
        private JPanel p2 = new JPanel();
        private Usuario u = PreviewGUI.getUser();
        private JPanel p3 = new JPanel();
        private JRadioButton ingresar = new JRadioButton("Ingresar");
        private JRadioButton retirar = new JRadioButton("Retirar");
        private ButtonGroup bg = new ButtonGroup();



        public IngresarRetirarGUI() {
            frame.setTitle("Operaciones");
            bg.add(ingresar);
            bg.add(retirar);

            p.add(etiqueta);
            p.add(cantidad);
            frame.add(p, BorderLayout.NORTH);


            p2.setLayout(new FlowLayout());


            // centro
            p3.add(ingresar);
            p3.add(retirar);
            ingresar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    u.ingresarSaldo(Integer.parseInt(cantidad.getText()));
                    cantidad.setText("INGRESADO!");
                }
            });

            retirar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    u.retirarSaldo(Integer.parseInt(cantidad.getText()));
                    cantidad.setText("RETIRADO!");
                }
            });
            frame.add(p3, BorderLayout.CENTER);

            p2.add(salir);
            salir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    new MainGUI();
                    dispose();
                }
            });
            frame.add(p2, BorderLayout.SOUTH);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setSize(200, 200);
            frame.setLocationRelativeTo(null);
        }
}
