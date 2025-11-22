package app;

import data_access.FileGameDataAccessObject;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        AppBuilder appBuilder = new AppBuilder();
//        JFrame application = appBuilder
//                // .add__Views()
//                .build("game_save.json");
//
//        application.pack();
//        application.setLocationRelativeTo(null);
//        application.setVisible(true);

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Could not set look and feel: " + e.getMessage());
            }

            AppBuilder appBuilder = new AppBuilder();
            JFrame app = appBuilder.build("game_save.json");

            app.setLocationRelativeTo(null);
            app.setVisible(true);
        });
    }
}