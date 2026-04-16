import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public Login() {
        setTitle("MyShop Login");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Title
        JLabel lblTitle = new JLabel("MyShop");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitle.setForeground(new Color(255, 87, 34));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitle = new JLabel("Login to your account");
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Username
        JLabel lblUser = new JLabel("Username / Email");
        lblUser.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtUsername = new JTextField();
        txtUsername.setMaximumSize(new Dimension(250, 35));
        txtUsername.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Password
        JLabel lblPass = new JLabel("Password");
        lblPass.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtPassword = new JPasswordField();
        txtPassword.setMaximumSize(new Dimension(250, 35));
        txtPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Login Button
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBackground(new Color(255, 87, 34));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setMaximumSize(new Dimension(250, 40));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Register Button
        JButton btnRegister = new JButton("Create Account");
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setForeground(new Color(255, 87, 34));
        btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Layout spacing
        panel.add(lblTitle);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblSubtitle);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));

        panel.add(lblUser);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(txtUsername);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        panel.add(lblPass);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(txtPassword);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));

        panel.add(btnLogin);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(btnRegister);

        add(panel);

        // Actions
        btnLogin.addActionListener(e -> handleLogin());

        btnRegister.addActionListener(e -> {
            new Register().setVisible(true);
            dispose();
        });
    }

    private void handleLogin() {
        String user = txtUsername.getText();
        String pass = new String(txtPassword.getPassword());

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        if (Account.login(user, pass)) {
            JOptionPane.showMessageDialog(this, "Welcome back!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials.");
        }
    }
}