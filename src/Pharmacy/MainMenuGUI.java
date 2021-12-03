package Pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame implements ActionListener {
    public MainMenuGUI() {
        JMenuBar menuBar;
        JMenu fileMenu = createFileMenu();
        JMenu staffMenu = createStaffMenu();
        JMenu medicationMenu = createMedicationMenu();
        JMenu prescriptionMenu = createPrescriptionMenu();

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.setBackground(Color.GREEN);
        menuBar.add(fileMenu);
        menuBar.add(prescriptionMenu);
        menuBar.add(staffMenu);
        menuBar.add(medicationMenu);

        /*******************************************************************
         *Title: Test disabling a JMenu in Swing
         *Author: Bios-Marcel
         *Site owner/sponsor: gist.github.com
         *Date: Apr 17 2018
         *Code Version: Apr 17 2018
         *Availability: https://gist.github.com/Bios-Marcel/4b4c38c00c259e711f4757c12d4dc7c1 (Accessed: Nov 30 2021)
         *Modified: Code refactored
         *******************************************************************/
//        staffMenu.setEnabled(false);
//        medicationMenu.setEnabled(false);

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
        this.setTitle("Main Menu");
        this.setLocation(new Point(400, 100));
        this.setSize(new Dimension(700, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String menuName;
        menuName = e.getActionCommand();

        // It asked if it wanted to make the switch-case enhanced, so I did.
        switch (menuName) {
            case "Quit" -> System.exit(0);
            case "Add Staff", "Edit Staff" -> new AddEditStaffGUI();
            case "Add Medication", "Edit Medication" -> new AddEditDrugsGUI();
            default -> JOptionPane.showMessageDialog(this, "Menu item " + menuName + " is selected.");
        }
    }

    public JMenu createFileMenu() {
        JMenuItem item;
        JMenu fileMenu;
        fileMenu = new JMenu("File");

        item = new JMenuItem("Open");
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Quit");
        item.addActionListener( this );
        fileMenu.add(item);

        return fileMenu;
    }

    public JMenu createStaffMenu() {
        JMenuItem item;
        JMenu staffMenu;
        staffMenu = new JMenu("Staff");

        item = new JMenuItem("Add Staff");
        item.addActionListener( this );
        staffMenu.add( item );

        item = new JMenuItem("Edit Staff");
        item.addActionListener( this );
        staffMenu.add( item );

        return staffMenu;
    }

    public JMenu createMedicationMenu() {
        JMenuItem item;
        JMenu medicationMenu;
        medicationMenu = new JMenu("Medication");

        item = new JMenuItem("Add Medication");
        item.addActionListener( this );
        medicationMenu.add( item );

        item = new JMenuItem("Edit Medication");
        item.addActionListener( this );
        medicationMenu.add( item );

        item = new JMenuItem("View Medication");
        item.addActionListener( this );
        medicationMenu.add( item );

        return medicationMenu;
    }

    public JMenu createPrescriptionMenu() {
        JMenuItem item;
        JMenu prescriptionMenu;

        prescriptionMenu = new JMenu("Prescriptions");

        item = new JMenuItem("Add Prescription");
        item.addActionListener( this );
        prescriptionMenu.add( item );

        item = new JMenuItem("Renew Prescription");
        item.addActionListener( this );
        prescriptionMenu.add( item );

        return prescriptionMenu;
    }
}
