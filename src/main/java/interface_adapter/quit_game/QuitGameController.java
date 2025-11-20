package interface_adapter.quit_game;

import use_case.quit_game.QuitGameInputBoundary;

/**
 * The controller for the Login Use Case.
 */
public class QuitGameController {

//    private final QuitGameInputBoundary quitGameUseCaseInteractor;
//
//    public QuitGameController(QuitGameInputBoundary quitGameUseCaseInteractor) {
//        this.quitGameUseCaseInteractor = quitGameUseCaseInteractor;
//    }
//
//    /**
//     * Executes the Login Use Case.
//     */
//    public void execute() {
//        quitGameUseCaseInteractor.execute();
//    }

    private Runnable showSaveDialog;

    public void setShowSaveDialog(Runnable r) {
        this.showSaveDialog = r;
    }

    public void execute() {
        showSaveDialog.run();
    }
}