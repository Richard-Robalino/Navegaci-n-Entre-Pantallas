import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThirdHobbyForm extends javax.swing.JFrame {
    private String username;
    private String bio;


    public ThirdHobbyForm(String username, String bio) {
        this.username = username;
        this.bio = bio;
        initComponents();
    }

    private void initComponents() {

        JLabel hobbyLabel = new JLabel("Otra foto de los hobbies de " + username);
        JLabel photoLabel = new JLabel();
        JButton backButton = new JButton("Volver a Hobbies");


        ImageIcon hobbyImage = new ImageIcon("C:\\Users\\USUARIO\\Downloads\\ciclismo.jpg"); // Cambia esto a la ruta de tu imagen
        photoLabel.setIcon(hobbyImage);
        Image image = hobbyImage.getImage();
        Image newImage = image.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH); // Escala la imagen a las dimensiones deseadas
        hobbyImage = new ImageIcon(newImage);
        photoLabel.setIcon(hobbyImage);


        setLayout(new BorderLayout());
        add(hobbyLabel, BorderLayout.NORTH);
        add(photoLabel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);


        backButton.addActionListener(new ActionListener() {
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
                new ThirdHobbyForm("Usuario de Prueba", "Esta es la biografía de Usuario de Prueba.").setVisible(true);
            }
        });
    }
}
