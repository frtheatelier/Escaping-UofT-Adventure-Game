package use_case.quit_game;

//import entity.User;
import use_case.quit_game.QuitGameInputBoundary;
import use_case.quit_game.QuitGameOutputBoundary;

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
