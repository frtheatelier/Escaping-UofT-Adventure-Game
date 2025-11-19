package interface_adapter.play_card_game;

import use_case.play_card_game.PlayCardGameOutputBoundary;
import use_case.play_card_game.PlayCardGameOutputData;
import interface_adapter.ViewManagerModel;

/**
 * The Presenter for the Play Card Game Use Case.
 */
public class CardGamePresenter implements PlayCardGameOutputBoundary {

    private final CardGameViewModel cardGameViewModel;
    private final ViewManagerModel viewManagerModel;

    public CardGamePresenter(CardGameViewModel cardGameViewModel,
                             ViewManagerModel viewManagerModel) {
        this.cardGameViewModel = cardGameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(PlayCardGameOutputData outputData) {
        CardGameState cardGameState = new CardGameState();

        cardGameViewModel.getState().setPassword("");
        cardGameViewModel.getState().setPasswordError(null);
        cardGameViewModel.firePropertyChange("password");
    }

    @Override
    public void prepareFailView(String errorMessage) {
        cardGameViewModel.getState().setPasswordError(errorMessage);
        cardGameViewModel.firePropertyChange("password");
    }
}