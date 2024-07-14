import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
    }

    private void initComponents() {

        JLabel jLabel1 = new JLabel("Nombre de Usuario:");
        JLabel jLabel2 = new JLabel("Contraseña:");
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Iniciar Sesión");


        setLayout(new java.awt.GridLayout(3, 2));
        add(jLabel1);
        add(usernameField);
        add(jLabel2);
        add(passwordField);
        add(loginButton);


        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());


                String url = "jdbc:mysql://localhost:3306/usuario_db";
                String user = "root";
                String dbPassword = "123456";

                try (Connection connection = DriverManager.getConnection(url, user, dbPassword)) {
                    System.out.println("Conectado a la base de datos");

                    String query = "SELECT * FROM usuarios WHERE nombre_usuario=? AND contraseña=?";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, username);
                    pst.setString(2, password);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        String bio = rs.getString("bibliografia");
                        JOptionPane.showMessageDialog(null, "Login Exitoso");
                        new BiographyForm(username,bio).setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error de Conexión");
                }
            }
        });


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
