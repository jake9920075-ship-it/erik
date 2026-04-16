import javax.swing.*;

public class Menu {
    public static void main(String[] args) {

        // Add default account
        Account.addAccount("user", "1234");

        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}