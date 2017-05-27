import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VerSaldoGUI extends JFrame {
    private JFrame frame = new JFrame();
    private JTextArea saldo = new JTextArea(10, 10);
    private JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JButton salir = new JButton("Salir");
    private static Usuario u = PreviewGUI.getUser();

    public VerSaldoGUI() {
        frame.setTitle("Ver saldo");
        saldo.setText(u.getSaldo() + " ");
        p.add(saldo);
        frame.add(p, BorderLayout.CENTER);


        p1.add(salir);
        frame.add(p1, BorderLayout.SOUTH);
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new MainGUI();
                dispose();
            }
        });




        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
    }





}
