package Pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ref: https://www.section.io/engineering-education/how-to-create-a-user-login-page-using-java-gui/
// create groups: https://stackoverflow.com/questions/431654/is-there-a-group-box-equivalent-in-java-swing
public class AuthorisationGUI extends JDialog implements ActionListener {
    private static JLabel usernameLabel, passwordLabel;
    private static JTextField username;
    private static JButton login;
    private static JPasswordField password;

    public AuthorisationGUI() {
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(100, 7, 70, 20);
        username = new JTextField();
        username.setBounds(100, 27, 193, 28);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 56, 70, 20);
        password = new JPasswordField();
        password.setBounds(100, 76, 193, 28);

        login = new JButton("Login");
        login.setBounds(100, 110, 90, 25);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);

        this.add(usernameLabel);
        this.add(username);
        this.add(passwordLabel);
        this.add(password);
        this.add(login);

        // Source: https://stackoverflow.com/questions/1614772/how-to-change-jframe-icon
        ImageIcon titleImg = new ImageIcon("src\\Pharmacy\\Icons\\cross.png");
        this.setIconImage(titleImg.getImage());

        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("Staff/Manager Login");
        this.setLocation(new Point(500, 300));
        this.setSize(new Dimension(400, 200));

        // source: https://stackoverflow.com/questions/13731710/allowing-the-enter-key-to-press-the-submit-button-as-opposed-to-only-using-mo
        // Amazing. All it took was one line of code, instead of implementing a KeyListener
        this.getRootPane().setDefaultButton(login);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = username.getText();

        /* getText for password fields are depreciated because getText() takes an immutable String that cannot be
         * changed, and so stays in memory until garbage collected. getPassword() gives a char array that can be
         * modified, and won't stay in memory.
         * Source: https://stackoverflow.com/questions/10443308/why-gettext-in-jpasswordfield-was-deprecated */
        String pass = String.valueOf(password.getPassword());

        if (user.equals("admin") && pass.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Login Successful. Hello Manager.");
            MainMenuGUI m = new MainMenuGUI();
            m.setVisible(true);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
            username.grabFocus();
        }
    }
}
