package Pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ref: https://www.section.io/engineering-education/how-to-create-a-user-login-page-using-java-gui/
// create groups: https://stackoverflow.com/questions/431654/is-there-a-group-box-equivalent-in-java-swing
public class AuthorisationGUI {
    private static JLabel usernameLabel, passwordLabel;
    private static JTextField username;
    private static JButton login;
    private static JPasswordField password;

    /*public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(100, 7, 70, 20);
        username = new JTextField();
        username.setBounds(100, 27, 193, 28);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 56, 70, 20);
        password = new JPasswordField();
        password.setBounds(100, 76, 193, 28);

        panel.add(usernameLabel);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);

        JFrame frame = new JFrame();
        frame.setTitle("Staff/Manager Login");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 200));
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }*/

}
