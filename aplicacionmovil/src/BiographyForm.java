import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BiographyForm extends javax.swing.JFrame {

    private String username;
    private String bio;


    public BiographyForm(String username, String bio) {
        this.username = username;
        this.bio = bio;
        initComponents();
    }

    private void initComponents() {

        JLabel bioLabel = new JLabel("Bienvenido, " + username);
        JTextArea bioTextArea = new JTextArea(10, 30);
        bioTextArea.setText(bio);
        bioTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bioTextArea);
        JButton hobbiesButton = new JButton("Ver Hobbies");


        setLayout(new BorderLayout());
        add(bioLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(hobbiesButton, BorderLayout.SOUTH);


        hobbiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HobbiesForm(username, bio).setVisible(true);
                dispose();
            }
        });


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BiographyForm("Usuario de Prueba", "Esta es la biografía de Usuario de Prueba.").setVisible(true);
            }
        });
    }
}
