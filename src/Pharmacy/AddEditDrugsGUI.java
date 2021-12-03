package Pharmacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;

public class AddEditDrugsGUI extends JFrame implements ActionListener {
    private static JLabel brandNameL, dosageL, priceL, categoryL;
    private static JTextField name, dosage, price;
    private static JComboBox<String> category;
    private static JButton addDrug;

    public AddEditDrugsGUI() {
        brandNameL = new JLabel("Brand Name");
        dosageL = new JLabel("Dosage");
        priceL = new JLabel("Price");
        categoryL = new JLabel("Category");

        brandNameL.setBounds(100, 37, 70, 20);
        dosageL.setBounds(100, 67, 70, 20);
        priceL.setBounds(100, 97, 70, 20);
        categoryL.setBounds(100, 127, 70, 20);

        name = new JTextField();
        name.setBounds(200, 37, 193, 28);
        dosage = new JTextField();
        dosage.setBounds(200, 67, 193, 28);
        price = new JTextField();
        price.setBounds(200, 97, 193, 28);

        category = new JComboBox<String>(Drug.values());
        category.setBounds(200, 127, 193, 28);

        this.add(brandNameL);
        this.add(dosageL);
        this.add(priceL);
        this.add(categoryL);

        this.add(name);
        this.add(dosage);
        this.add(price);
        this.add(category);


        addDrug = new JButton("Add Medication");
        addDrug.setBounds(100, 167, 130, 20);
        addDrug.setForeground(Color.WHITE);
        addDrug.setBackground(Color.BLACK);
        addDrug.addActionListener(this);

        this.add(addDrug);
        this.getRootPane().setDefaultButton(addDrug);

        ArrayList<Drug> drugList = new ArrayList<>();
        //File inFile = new File("src/Pharmacy/drugs.dat");

        // I literally don't know what to do. It keeps talking about ArrayList cannot be cast to Drug.
        // A real shame, adding inputted drugs to a menu seemed ingenious to me.
        /*try {
            FileInputStream inStream = new FileInputStream(inFile);
            ObjectInputStream objectInStream = new ObjectInputStream(inStream);

            drugList.add((Drug) objectInStream.readObject());

            inStream.close();
            objectInStream.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        /*******************************************************************
         *Title: How do I populate a JComboBox with an ArrayList?
         *Author: unknown
         *Site owner/sponsor: newbedev.com
         *Date: unknown
         *Code Version: Dec 01 2021
         *Availability: https://newbedev.com/how-do-i-populate-a-jcombobox-with-an-arraylist (Accessed: Dec 01 2021)
         *Modified: Code refactored
         *******************************************************************/
        // Works better with serialisation, but I can't get it to work.
        int dArraySize = drugList.size() + 1;
        String[] dArray = new String[dArraySize];
        dArray[0] = "---";
        for(int i = 1; i < dArray.length; i++) {
            dArray[i] = drugList.get(i-1).getBrandName();
        }
        JComboBox<String> drugCombo = new JComboBox<>(dArray);
        drugCombo.setBounds(100, 7, 200, 20);

        /*******************************************************************
         *Title: JComboBox Selection Change Listener?
         *Author: Viacheslav
         *Site owner/sponsor: stackoverflow.com
         *Date: Jan 20 2013
         *Code Version: Jan 20 2013
         *Availability: https://stackoverflow.com/questions/58939/jcombobox-selection-change-listener (Accessed: Dec 01 2021)
         *Modified: Code refactored
         *******************************************************************/
        drugCombo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent i) {
                int index = drugCombo.getSelectedIndex();
                addDrug.setText("Edit Medication");
                if (index > 0) {
                    name.setText(drugList.get(index-1).getBrandName());
                    dosage.setText(drugList.get(index-1).getDosage());
                    price.setText(String.valueOf(drugList.get(index-1).getPrice()));
                    category.setSelectedItem(drugList.get(index-1).getCategory());
                } else {
                    addDrug.setText("Add Medication");
                    name.setText("");
                    dosage.setText("");
                    price.setText("");
                    category.setSelectedIndex(0);
                }
            }
        });

        this.add(drugCombo);

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
        this.setTitle("Add/Edit Medication");
        this.setLocation(new Point(500, 300));
        this.setSize(new Dimension(650, 300));

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addDrug) {
            if (addDrug.getText().equals("Add Medication")) {
                String dName = name.getText();
                String dDosage = dosage.getText();
                double dPrice = Double.parseDouble(price.getText());
                String dCategory = (String) category.getSelectedItem();

                ArrayList<Drug> drugList = new ArrayList<>();
                drugList.add(new Drug(dName, dDosage, dPrice, dCategory));

                File outFile = new File("src/Pharmacy/drugs.dat");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(outFile);

                    ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutputStream);

                    objectOutStream.writeObject(drugList);

                    fileOutputStream.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
