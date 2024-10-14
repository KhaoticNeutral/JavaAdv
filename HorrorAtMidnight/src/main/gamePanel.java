package main;

import inputs.keyboardInput;
import inputs.mouseInput;

import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel {

    private mouseInput mouse;
    private int xDelta = 100, yDelta = 100;

    public gamePanel() {

        mouse = new mouseInput(this);
        addKeyListener(new keyboardInput(this));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

    }

    public void changeXDelta(int value) {
        this.xDelta += value;
        repaint();
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
        repaint();
    }

    public void setRecPosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(xDelta, yDelta, 200, 50);


    }
}
