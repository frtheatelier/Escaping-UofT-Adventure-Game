package app;
import javax.swing.*;

public class AppBuilder {

    public void build() {

        // Main application window
        JFrame window = new JFrame("Adventure Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 650);
        window.getContentPane().setBackground(java.awt.Color.BLACK);
        window.setLayout(null);

        // Make the window visible
        window.setVisible(true);
    }
}
