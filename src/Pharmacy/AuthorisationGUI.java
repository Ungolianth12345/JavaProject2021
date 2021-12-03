package Pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*******************************************************************
 *Title: How to create a User Login Page using Java GUI
 *Author: Abdulazeez Saidu
 *Site owner/sponsor: section.io
 *Date: Aug 03 2021
 *Code Version: Aug 03 2021
 *Availability: https://www.section.io/engineering-education/how-to-create-a-user-login-page-using-java-gui/ (Accessed: Nov 23 2021)
 *Modified: Code refactored
 *******************************************************************/
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

        /*******************************************************************
         *Title: How to change JFrame icon [duplicate]
         *Author: BFree
         *Site owner/sponsor: stackoverflow.com
         *Date: Oct 23 2009
         *Code Version: Aug 31 2015
         *Availability: https://stackoverflow.com/questions/1614772/how-to-change-jframe-icon (Accessed: Nov 29 2021)
         *Modified: Code refactored
         *******************************************************************/
        ImageIcon titleImg = new ImageIcon("src\\Pharmacy\\Icons\\cross.png");
        this.setIconImage(titleImg.getImage());

        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("Staff/Manager Login");
        this.setLocation(new Point(500, 300));
        this.setSize(new Dimension(400, 200));

        /*******************************************************************
         *Title: Allowing the "Enter" key to press the submit button, as opposed to only using MouseClick
         *Author: Martijn Courteaux
         *Site owner/sponsor: stackoverflow.com
         *Date: Dec 05 2015
         *Code Version: Dec 05 2015
         *Availability: https://stackoverflow.com/questions/13731710/allowing-the-enter-key-to-press-the-submit-button-as-opposed-to-only-using-mo (Accessed: Nov 26 2021)
         *Modified: Code refactored
         *******************************************************************/
        // Amazing. All it took was one line of code, instead of implementing a KeyListener
        this.getRootPane().setDefaultButton(login);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = username.getText();

        /*******************************************************************
         *Title: Why getText() in JPasswordField was deprecated?
         *Author: MByD
         *Site owner/sponsor: stackoverflow.com
         *Date: May 04 2012
         *Code Version: May 04 2012
         *Availability: https://stackoverflow.com/questions/10443308/why-gettext-in-jpasswordfield-was-deprecated (Accessed: Nov 23 2021)
         *Modified: Information
         *******************************************************************/
        /* getText for password fields are depreciated because getText() takes an immutable String that cannot be
         * changed, and so stays in memory until garbage collected. getPassword() gives a char array that can be
         * modified, and won't stay in memory.*/
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
