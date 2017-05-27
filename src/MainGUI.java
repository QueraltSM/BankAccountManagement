import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JFrame frame = new JFrame();

    private JPanel pCentro = new JPanel();
    private JPanel pSur = new JPanel();

    private JButton verSaldo = new JButton("Ver saldo");
    private JButton ingresarRetirar = new JButton("Ingresar/Retirar");
    private JButton imprimirMovimientos = new JButton("Últimos movimientos");

    private JButton salir = new JButton("Salir");

    private static Usuario u = PreviewGUI.getUser();


    public MainGUI(){
        frame.setTitle(u.getName()); //PONER EL NOMBRE DEL USER ARRIBA
        GridLayout g = new GridLayout(2, 2);
        g.setHgap(20);
        g.setVgap(20);

        pCentro.setLayout(g);
        pCentro.add(verSaldo);
        verSaldo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    new VerSaldoGUI();
                    dispose();
                }
         });

        pCentro.add(ingresarRetirar);
        ingresarRetirar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new IngresarRetirarGUI();
                dispose();
            }
        });


        pCentro.add(imprimirMovimientos);
        imprimirMovimientos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new MovimientosGUI();
                dispose();
            }
        });


        frame.add(pCentro, BorderLayout.CENTER);
        frame.add(pSur, BorderLayout.SOUTH);

        pSur.add(salir);
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new PreviewGUI();
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
