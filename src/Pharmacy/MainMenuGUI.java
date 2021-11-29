package Pharmacy;

import javax.swing.*;
import java.awt.*;

public class MainMenuGUI extends JFrame {
    public MainMenuGUI() {
        // Source: https://stackoverflow.com/questions/1614772/how-to-change-jframe-icon
        ImageIcon titleImg = new ImageIcon("src\\Pharmacy\\Icons\\cross.png");
        this.setIconImage(titleImg.getImage());

        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("Main Menu");
        this.setLocation(new Point(400, 100));
        this.setSize(new Dimension(700, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
