package view;

import interface_adapter.win_game.WinGameState;
import interface_adapter.win_game.WinGameViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WinGameView extends JPanel implements PropertyChangeListener {
    private final String viewName = "win game";
    private final WinGameViewModel viewModel;

    private final JLabel titleLabel;
    private final JLabel messageLabel;
    private final JLabel keysLabel;
    private final JButton newGameButton;
    private final JButton quitButton;

    public WinGameView(WinGameViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Congratulations!");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        messageLabel = new JLabel();
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        keysLabel = new JLabel();
        keysLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        newGameButton = new JButton("New Game");
        quitButton = new JButton("Quit");

        newGameButton.addActionListener(e -> {
            System.exit(0);
        });

        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        buttonPanel.add(newGameButton);
        buttonPanel.add(quitButton);

        add(Box.createVerticalGlue());
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(messageLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(keysLabel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(buttonPanel);
        add(Box.createVerticalGlue());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        WinGameState state = (WinGameState) evt.getNewValue();

        if (state.isWon()) {
            titleLabel.setText("Congratulations!");
            messageLabel.setText(state.getMessage());
            keysLabel.setText("Keys collected: " + state.getKeysCollected());
        } else {
            titleLabel.setText("Not Yet!");
            messageLabel.setText(state.getMessage());
        }
    }

    public String getViewName() {
        return viewName;
    }
}