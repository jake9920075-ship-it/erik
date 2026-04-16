import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtAddress;

    public Register() {
        setTitle("Create Account");
        setSize(420, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        // Title
        JLabel lblTitle = new JLabel("Create Account");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(130, 10, 200, 30);

        // Username
        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(40, 50, 100, 25);

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 50, 200, 25);

        // Password
        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(40, 85, 100, 25);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 85, 200, 25);

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(40, 120, 100, 25);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 120, 200, 25);

        // Phone
        JLabel lblPhone = new JLabel("Phone No:");
        lblPhone.setBounds(40, 155, 100, 25);

        txtPhone = new JTextField();
        txtPhone.setBounds(150, 155, 200, 25);

        // Address
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(40, 190, 100, 25);

        txtAddress = new JTextField();
        txtAddress.setBounds(150, 190, 200, 25);

        // Buttons
        JButton btnCreate = new JButton("Create Account");
        btnCreate.setBounds(90, 260, 220, 35);
        btnCreate.setBackground(new Color(255, 87, 34));
        btnCreate.setForeground(Color.WHITE);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(90, 305, 220, 30);

        // Add components
        add(lblTitle);

        add(lblUser);
        add(txtUsername);

        add(lblPass);
        add(txtPassword);

        add(lblEmail);
        add(txtEmail);

        add(lblPhone);
        add(txtPhone);

        add(lblAddress);
        add(txtAddress);

        add(btnCreate);
        add(btnBack);

        // Actions
        btnCreate.addActionListener(e -> handleCreate());

        btnBack.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });
    }

    private void handleCreate() {
        String user = txtUsername.getText();
        String pass = new String(txtPassword.getPassword());
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();

        if (user.isEmpty() || pass.isEmpty() || email.isEmpty() ||
            phone.isEmpty() || address.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        // Save only username/password (you can expand Account later)
        Account.addAccount(user, pass);

        JOptionPane.showMessageDialog(this,
                "Account Created!\nWelcome " + user);

        new Login().setVisible(true);
        dispose();
    }
}