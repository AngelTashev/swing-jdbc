package util;

import javax.swing.*;

public class Login {

    private final DBConnector dbConnector;

    public Login(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public void displayLogin() {
        JTextField username = new JTextField(5);
        JTextField password = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("username:"));
        myPanel.add(username);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("password:"));
        myPanel.add(password);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter credentials", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            login(username.getText(), password.getText());
        }

    }

    private void login(String username, String password) {
        try {
            this.dbConnector.connect(username, password);
            showConnectionStatus("Successfully connected!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            showConnectionStatus(e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showConnectionStatus(String message, int icon) {
        Thread t = new Thread(() ->
                JOptionPane.showMessageDialog(null, message, "Connection status", icon)
        );

        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }
}
