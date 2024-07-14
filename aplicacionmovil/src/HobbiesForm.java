import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HobbiesForm extends javax.swing.JFrame {
    private String username;
    private String bio;


    public HobbiesForm(String username, String bio) {
        this.username = username;
        this.bio = bio;
        initComponents();
    }

    private void initComponents() {

        JLabel hobbyLabel = new JLabel("Hobbies de " + username);
        JLabel photoLabel = new JLabel();
        JButton backButton = new JButton("Volver a Biografía");
        JButton thirdScreenButton = new JButton("Ver Otra Foto de Hobbies");



        ImageIcon hobbyImage = new ImageIcon("C:\\Users\\USUARIO\\Downloads\\lol.jpg"); // Cambia esto a la ruta de tu imagen
        photoLabel.setIcon(hobbyImage);
        Image image = hobbyImage.getImage();
        Image newImage = image.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH); // Escala la imagen a las dimensiones deseadas
        hobbyImage = new ImageIcon(newImage);
        photoLabel.setIcon(hobbyImage);

        setLayout(new BorderLayout());
        add(hobbyLabel, BorderLayout.NORTH);
        add(photoLabel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(thirdScreenButton);
        add(buttonPanel, BorderLayout.SOUTH);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BiographyForm(username, bio).setVisible(true);
                dispose();
            }
        });


        thirdScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThirdHobbyForm(username, bio).setVisible(true);
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
                new HobbiesForm("Usuario de Prueba", "Esta es la biografía de Usuario de Prueba.").setVisible(true);
            }
        });
    }
}
