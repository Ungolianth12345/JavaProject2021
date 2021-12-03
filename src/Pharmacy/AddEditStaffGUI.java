package Pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEditStaffGUI extends JFrame implements ActionListener {
    private static JLabel nameL, eircodeL, usernameL, passwordL, dateOfBirthL, dateEmployedL;
    private static JTextField name, eircode, username;
    private static JTextField dateOfBirthDay, dateOfBirthYear, dateEmployedDay, dateEmployedYear;
    private static JComboBox<Month>  dateOfBirthMonth, dateEmployedMonth;
    private static JPasswordField password;
    private static JButton dateOfBirthChooser, dateEmployedChooser, addStaff;

    public AddEditStaffGUI() {
        nameL = new JLabel("Name");
        eircodeL = new JLabel("Eircode");
        usernameL = new JLabel("Username");
        passwordL = new JLabel("Password");
        dateOfBirthL = new JLabel("Date of Birth");
        dateEmployedL = new JLabel("Date of Employment");

        nameL.setBounds(100, 7, 70, 20);
        eircodeL.setBounds(100, 37, 70, 20);
        usernameL.setBounds(100, 67, 70, 20);
        passwordL.setBounds(100, 97, 70, 20);
        dateOfBirthL.setBounds(100, 127, 100, 20);
        dateEmployedL.setBounds(100, 157, 130, 20);

        name = new JTextField();
        name.setBounds(240, 7, 193, 28);
        eircode = new JTextField();
        eircode.setBounds(240, 37, 193, 28);
        username = new JTextField();
        username.setBounds(240, 67, 193, 28);
        password = new JPasswordField();
        password.setBounds(240, 97, 193, 28);

        dateOfBirthDay = new JTextField();
        dateOfBirthDay.setBounds(240, 127, 30, 28);

        /*******************************************************************
         *Title: How to Create Combo Boxes in Java
         *Author: Doug Lowe
         *Site owner/sponsor: dummies.com
         *Date: unknown
         *Code Version: unknown
         *Availability: https://www.dummies.com/programming/java/how-to-create-combo-boxes-in-java/ (Accessed: Nov 29 2021)
         *Modified: Code refactored
         *******************************************************************/

        /*******************************************************************
         *Title: How to get the month from a combobox and make it a month in a date
         *Author: ΦXocę 웃 Пepeúpa ツ
         *Site owner/sponsor: stackoverflow.com
         *Date: Aug 16 2017
         *Code Version: Aug 16 2017
         *Availability: https://stackoverflow.com/questions/45718098/how-to-get-the-month-from-a-combobox-and-make-it-a-month-in-a-date (Accessed: Nov 29 2021)
         *Modified: Code refactored
         *******************************************************************/
        // Source: https://www.dummies.com/programming/java/how-to-create-combo-boxes-in-java/ for combobox
        // Source: https://stackoverflow.com/questions/45718098/how-to-get-the-month-from-a-combobox-and-make-it-a-month-in-a-date?noredirect=1&lq=1
        // for a more useful combobox.

        dateOfBirthMonth = new JComboBox<>(Month.values());
        dateOfBirthMonth.setBounds(275, 127, 110, 28);
        dateOfBirthYear = new JTextField();
        dateOfBirthYear.setBounds(390, 127, 43, 28);

        dateOfBirthChooser = new JButton("Choose Date");
        dateOfBirthChooser.setBounds(440, 127, 120, 28);
        dateOfBirthChooser.addActionListener(this);

        dateEmployedDay = new JTextField();
        dateEmployedDay.setBounds(240, 157, 30, 28);
        dateEmployedMonth = new JComboBox<>(Month.values());
        dateEmployedMonth.setBounds(275, 157, 110, 28);
        dateEmployedYear = new JTextField();
        dateEmployedYear.setBounds(390, 157, 43, 28);

        dateEmployedChooser = new JButton("Choose Date");
        dateEmployedChooser.setBounds(440, 157, 120, 28);
        dateEmployedChooser.addActionListener(this);

        addStaff = new JButton("Add Staff");
        addStaff.setBounds(100, 187, 130, 20);
        addStaff.setForeground(Color.WHITE);
        addStaff.setBackground(Color.BLACK);
        addStaff.addActionListener(this);

        this.add(nameL);
        this.add(eircodeL);
        this.add(usernameL);
        this.add(passwordL);
        this.add(dateOfBirthL);
        this.add(dateEmployedL);

        this.add(name);
        this.add(eircode);
        this.add(username);
        this.add(password);

        this.add(dateOfBirthDay);
        this.add(dateOfBirthMonth);
        this.add(dateOfBirthYear);
        this.add(dateOfBirthChooser);

        this.add(dateEmployedDay);
        this.add(dateEmployedMonth);
        this.add(dateEmployedYear);
        this.add(dateEmployedChooser);

        this.add(addStaff);
        this.getRootPane().setDefaultButton(addStaff);

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
        this.setTitle("Add/Edit Staff");
        this.setLocation(new Point(500, 300));
        this.setSize(new Dimension(650, 300));

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dateOfBirthChooser) {
            GregorianCalendar cal = new DateChooser(this).getDateChosen();
            int day = cal.toZonedDateTime().getDayOfMonth();
            int month = cal.toZonedDateTime().getMonthValue();
            int year = cal.toZonedDateTime().getYear();

            dateOfBirthDay.setText(String.valueOf(day));
            dateOfBirthMonth.setSelectedIndex(month - 1);
            dateOfBirthYear.setText(String.valueOf(year));
        }

        if (e.getSource() == dateEmployedChooser) {
            GregorianCalendar cal = new DateChooser(this).getDateChosen();
            int day = cal.toZonedDateTime().getDayOfMonth();
            int month = cal.toZonedDateTime().getMonthValue();
            int year = cal.toZonedDateTime().getYear();

            dateEmployedDay.setText(String.valueOf(day));
            dateEmployedMonth.setSelectedIndex(month - 1);
            dateEmployedYear.setText(String.valueOf(year));
        }

        if (e.getSource() == addStaff) {
            /* Many else if statements. I doubt a switch case statement would have helped. i have attempted to make it
            * look neat enough. */
            if (name.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Error! Name is a necessary field.",
                        "Missing name", JOptionPane.WARNING_MESSAGE);
                name.grabFocus();
            }

            else if (eircode.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Error! Eircode is a necessary field.",
                        "Missing Eircode", JOptionPane.WARNING_MESSAGE);
                eircode.grabFocus();
            }

            else if (!eircode.getText().equals("")) {
                /*******************************************************************
                 *Title: Validation for Irish Eircode
                 *Author: Asunez
                 *Site owner/sponsor: stackoverflow.com
                 *Date: Oct 29 2015
                 *Code Version: March 26 2021
                 *Availability: https://stackoverflow.com/questions/33391412/validation-for-irish-eircode (Accessed: Nov 29 2021)
                 *Modified: Code refactored
                 *******************************************************************/

                /*******************************************************************
                 *Title: Regex doesn't work in String.matches()
                 *Author: fge
                 *Site owner/sponsor: stackoverflow.com
                 *Date: Jan 19 2012
                 *Code Version: Jan 19 2012
                 *Availability: https://stackoverflow.com/questions/8923398/regex-doesnt-work-in-string-matches (Accessed: Nov 29 2021)
                 *Modified: Code refactored
                 *******************************************************************/

                /* Source for regex: https://stackoverflow.com/questions/33391412/validation-for-irish-eircode
                 * Source for pattern and matcher: https://stackoverflow.com/questions/8923398/regex-doesnt-work-in-string-matches
                 * Now THIS is a proper showing of my love for regex. Useful but looks like a language straight out of
                 * Lovecraft.
                 * Imperfect, this was causing problems, namely staff couldn't be added for whatever reason unless the
                 * next statement (username) was an if statement instead of an else if statement. */
                Pattern p = Pattern.compile("(?:^[AC-FHKNPRTV-Y][0-9]{2}|D6W)[ -]?[0-9AC-FHKNPRTV-Y]{4}$");
                Matcher m = p.matcher(eircode.getText());
                if (!m.find()) {
                    JOptionPane.showMessageDialog(this, "Error! Eircode is invalid.",
                            "Invalid Eircode", JOptionPane.WARNING_MESSAGE);
                    eircode.setText("");
                    eircode.grabFocus();
                }
            }

            if (username.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Error! Username is a necessary field.",
                        "Missing Username", JOptionPane.WARNING_MESSAGE);
                username.grabFocus();
            }

            else if (String.valueOf(password.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(this, "Error! Password is a necessary field.",
                        "Missing Password", JOptionPane.WARNING_MESSAGE);
                password.grabFocus();
            }

            else if (dateOfBirthDay.getText().equals("") || dateOfBirthYear.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Error! Birth date is a necessary field.",
                        "Missing Birthdate Day and/or Year", JOptionPane.WARNING_MESSAGE);
            }

            else if (dateEmployedDay.getText().equals("") || dateEmployedYear.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Error! Employment date is a necessary field.",
                        "Missing Employment Day and/or Year", JOptionPane.WARNING_MESSAGE);
            }

            else {
                // Add Serializable
                JOptionPane.showMessageDialog(this, "Staff added.");
                GregorianCalendar dateOfBirth = new GregorianCalendar(Integer.parseInt(dateOfBirthYear.getText()),
                        dateOfBirthMonth.getSelectedIndex(), Integer.parseInt(dateOfBirthDay.getText()));
                GregorianCalendar dateEmployed = new GregorianCalendar(Integer.parseInt(dateEmployedYear.getText()),
                        dateEmployedMonth.getSelectedIndex(), Integer.parseInt(dateEmployedDay.getText()));
                Staff staff = new Staff(name.getText(), eircode.getText(), username.getText(),
                        String.valueOf(password.getPassword()), dateOfBirth, dateEmployed);

                JOptionPane.showMessageDialog(this, staff);
            }
        }
    }

    
}
