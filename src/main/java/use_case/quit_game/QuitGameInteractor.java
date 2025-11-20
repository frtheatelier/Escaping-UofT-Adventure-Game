package main.java.use_case.quit_game;

//import entity.User;

/**
 * The Login Interactor.
 */
public class QuitGameInteractor implements QuitGameInputBoundary {
    private final QuitGameOutputBoundary quitGamePresenter;

    public QuitGameInteractor(QuitGameOutputBoundary quitGameOutputBoundary) {
        this.quitGamePresenter = quitGameOutputBoundary;
    }

    @Override
    public void execute() {
        // run the "save game" prompt
    }
}
