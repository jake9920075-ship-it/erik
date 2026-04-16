import java.util.ArrayList;

public class Account {
    private String username;
    private String password;

    private static ArrayList<Account> users = new ArrayList<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void addAccount(String user, String pass) {
        users.add(new Account(user, pass));
    }

    public static boolean login(String user, String pass) {
        for (Account acc : users) {
            if (acc.username.equals(user) && acc.password.equals(pass)) {
                return true;
            }
        }
        return false;
    }
}