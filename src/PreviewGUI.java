import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviewGUI extends JFrame {
    private static CaixaRepositorio cr;
    private JFrame frame = new JFrame();
    private static Usuario u = new Usuario();

    private JPanel p1 = new JPanel();

    private JPanel aux1 = new JPanel();
    private JLabel tarjeta = new JLabel("Numero de tarjeta:");
    private JTextField nTarget = new JTextField(10);

    private JPanel aux2 = new JPanel();
    private JLabel pass = new JLabel("Contraseña:");
    private JPasswordField password = new JPasswordField(10);

    private JPanel p2 = new JPanel();
    private JButton validar = new JButton("Validar");

    public static ArrayList<Usuario> getUsuarios() {
        return cr.getUsuarios();
    }

    public static Usuario getUser(){
        return u;
    }

    public PreviewGUI(){
        init();
        frame.setTitle("Caixa Bank");
        aux1.setLayout(new FlowLayout());
        aux1.add(tarjeta);
        aux1.add(nTarget);

        aux2.setLayout(new FlowLayout());
        aux2.add(pass);
        aux2.add(password);

        p1.setLayout(new GridLayout(2, 1, 0, 0));
        p1.add(aux1);
        p1.add(aux2);

        p2.add(validar, BorderLayout.CENTER);

        validar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                u = new Usuario(Integer.parseInt(nTarget.getText()), Integer.parseInt(String.valueOf(password.getPassword())));
                for (Usuario user : cr.getUsuarios())
                    if (u.equals(user)) {
                        u = user;
                        new MainGUI();
                        dispose();
                    }
            }
        });

        frame.add(p1, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.SOUTH);


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
    }


    private void init(){
        cr = new CaixaRepositorio();
        Usuario u1 = new Usuario("Carlota", "Pérez", 1, 1);
        cr.darAlta(u1);
        u1.ingresarSaldo(10);
        u1.setMovimiento("Compra", "+12.40");
        u1.setMovimiento("Vendió la moto", "-123.456");
    }



    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
        }
        new PreviewGUI();
    }
}
