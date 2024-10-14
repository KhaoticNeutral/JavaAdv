package main;

import javax.swing.*;

public class gameWindow {
    private JFrame frame;

    public gameWindow(gamePanel panel) {
        frame = new JFrame();


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
