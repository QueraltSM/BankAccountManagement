/**
 * Created by QSM on 19/5/17.
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MovimientosGUI extends JFrame {
    private JFrame frame = new JFrame();
    private JTextArea movimientos = new JTextArea(15, 30);
    private JButton salir = new JButton("Salir");
    private JPanel p = new JPanel();
    private JPanel p2 = new JPanel();
    private Usuario user = PreviewGUI.getUser();
    private JRadioButton rb1 = new JRadioButton("Alfabeto");
    private JRadioButton rb2 = new JRadioButton("Invertido");
    private JRadioButton rb3 = new JRadioButton("Vendido");
    private JPanel aux = new JPanel();
    private ButtonGroup bg = new ButtonGroup();

    public MovimientosGUI() {
        frame.setTitle("Movimientos");
        movimientos.setText(user.getOrden());

        aux.setLayout(new FlowLayout());
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        aux.add(rb1);
        aux.add(rb2);
        aux.add(rb3);

        rb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                user.setOrder(0);
                movimientos.setText(user.getOrden());
            }
        });

        rb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                user.setOrder(1);
                movimientos.setText(user.getOrden());
            }
        });

        rb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                movimientos.setText("");
                user.setOrder(2);
                movimientos.setText(user.getOrden());
            }
        });

        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new MainGUI();
                dispose();
            }
        });

        p2.add(aux, BorderLayout.SOUTH);
        p2.add(movimientos);
        frame.add(p2, BorderLayout.CENTER);

        p.add(salir);
        frame.add(p, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
    }
}
