package view;

import javax.swing.*;
import java.awt.*;

import interface_adapter.clear_history.ClearHistoryController;

public class ConfirmRestartGameDialog {
    private ClearHistoryController clearHistoryController;

    private final JDialog dialog = new JDialog();

    public ConfirmRestartGameDialog(ClearHistoryController clearHistoryController) {
        this.setClearHistoryController(clearHistoryController);

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        final JLabel title = new JLabel("Reset progress?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        JButton clearHistory = new JButton("Reset");
        JButton cancel = new JButton("Cancel");

        clearHistory.addActionListener(evt -> {
                dialog.dispose();
                clearHistoryController.execute(); // clears history
            }
        );

        cancel.addActionListener(evt -> dialog.dispose()
        );

        buttons.add(clearHistory);
        buttons.add(cancel);
        dialog.add(title, BorderLayout.NORTH);
        dialog.add(buttons, BorderLayout.SOUTH);
    }

    public void show() {
        dialog.setVisible(true);
    }

//    public String getViewName() {
//        return viewName;
//    }

    // set controllers
    public void setClearHistoryController(ClearHistoryController clearHistoryController) {
        this.clearHistoryController = clearHistoryController;
    }
}