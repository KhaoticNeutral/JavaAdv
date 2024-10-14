package main;

public class Game {

    private gameWindow window;
    private gamePanel panel;

    public Game(){

        panel = new gamePanel();
        window = new gameWindow(panel);
        panel.requestFocus();


    }
}
