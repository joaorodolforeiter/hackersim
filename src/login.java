import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Arrays;

public class login extends JFrame {

    private static String server = "jdbc:mysql://localhost:3306/hackerSimulator";
    private static String serverLogin = "root";
    private static String serverPasswd = "";

    protected JTabbedPane tabbedPane;
    private JPanel mainPanel;
    private JButton loginButton;
    private JTextField userField;
    private JPasswordField passwdField;
    private JButton createAccountButton;
    private JTextField createUserField;
    private JPasswordField createPasswdField;
    private JTextField serverField;
    private JTextField serverPasswdField;
    private JTextField serverUserField;
    private JButton configButton;

    public login() {
        super("Hacker Simulator 2");

        this.setMinimumSize(new Dimension(600, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);

        userField.addActionListener(e -> passwdField.requestFocus());

        passwdField.addActionListener(this::loginUser);

        loginButton.addActionListener(this::loginUser);

        createAccountButton.addActionListener(this::createUser);

        configButton.addActionListener(this::configServer);

    }

    private void loginUser(ActionEvent e) {

        try {
            Connection conn = DriverManager.getConnection(server, serverLogin, serverPasswd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where name='" + userField.getText().toLowerCase() + "' && passwd='" + Arrays.toString(passwdField.getPassword()) + "'");

            if (rs.next()) {
                String user = rs.getString("name");
                int idUser = Integer.parseInt(rs.getString("idUsers"));
                int upgrade = Integer.parseInt(rs.getString("upgrade"));
                final Long dinheiro = Long.parseLong(rs.getString("money"));
                dispose();

                new hackersim(idUser,user,dinheiro,upgrade);

            } else JOptionPane.showMessageDialog(null, "Informações invalidas");

            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de servidor");
            new hackersim(1,"Jose", 50000L,0);
        }

    }

    private void createUser(ActionEvent e) {

        if (!createUserField.getText().replace(" ", "").equals("")) {

            try {
                Connection conn = DriverManager.getConnection(server, serverLogin, serverPasswd);
                Statement stmt = conn.createStatement();
                stmt.execute("INSERT INTO `hackerSimulator`.`users` (`name`, `passwd`, `money`, `upgrade`) VALUES ('" + createUserField.getText().toLowerCase() + "', '" + Arrays.toString(createPasswdField.getPassword()) + "', '0', '0');");
                stmt.close();
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro de servidor");
            }

        } else JOptionPane.showMessageDialog(null, "Usuário inválido");

    }

    private void configServer(ActionEvent e) {
        server = ("jdbc:mysql://" + serverField.getText());
        serverLogin = serverUserField.getText();
        serverPasswd = serverPasswdField.getText();
        JOptionPane.showMessageDialog(null, "Servidor Configurado");
    }

}