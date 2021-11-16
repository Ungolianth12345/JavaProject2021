import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{
    private static final int BOARD_WIDTH = 512;
    private static final int BOARD_HEIGHT = 512;

    private final Color BLACK = Color.BLACK;
    // It is named WHITE for convention, the actual color will usually be different.
    private final Color WHITE = Color.WHITE;

    // ref: https://github.com/tobyjamesthomas/Java-Checkers/blob/master/src/Checkers/Board.java
    public void paint(Graphics g){
        int DIMENSION = 8;
        int SQ_SIZE = 512 / DIMENSION;
        for (int row = 0; row < DIMENSION; row++) {
            for (int column = 0; column < DIMENSION; column++) {
                if (row % 2 == column % 2) {
                    g.setColor(BLACK);
                } else {
                    g.setColor(WHITE);
                }
                g.fillRect(column * SQ_SIZE, row * SQ_SIZE, SQ_SIZE, SQ_SIZE);
            }
            System.out.println(row * SQ_SIZE);
        }
    }

    // ref: https://www.youtube.com/watch?v=no4m-TIX-rc
    // ref: https://1bestcsharp.blogspot.com/2015/04/Java-How-To-Draw-Chess-Board-In-Java-Swing-Using-NetBeans.html
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        // board isn't aligned properly, gets clipped off.
        frame.setSize(528,551);
        frame.getContentPane().add(new Board());
        frame.setBackground(Color.GRAY);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
