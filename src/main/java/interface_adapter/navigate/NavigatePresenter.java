package interface_adapter.navigate;

import interface_adapter.ViewManagerModel;
import interface_adapter.play_card_game.CardGameViewModel;
import interface_adapter.trivia_game.TriviaGameViewModel;
import interface_adapter.win_game.WinGameViewModel;
import use_case.navigate.NavigateOutputBoundary;
import use_case.navigate.NavigateOutputData;
import use_case.navigate.NavigateOutputData2;

/**
 * Presenter for the Navigation use case.
 * Receives output from the Interactor and updates the ViewModel.
 */
public class NavigatePresenter implements NavigateOutputBoundary {
    private final NavigateViewModel navigateViewModel;
    private final ViewManagerModel viewManagerModel;

    private final WinGameViewModel winGameViewModel;
    private final CardGameViewModel cardGameViewModel;
    private final TriviaGameViewModel triviaGameViewModel;

    public NavigatePresenter(NavigateViewModel navigateViewModel, ViewManagerModel viewManagerModel, WinGameViewModel winGameViewModel, CardGameViewModel cardGameViewModel, TriviaGameViewModel triviaGameViewModel) {
        this.navigateViewModel = navigateViewModel;
        this.viewManagerModel = viewManagerModel;
        this.winGameViewModel = winGameViewModel;
        this.cardGameViewModel = cardGameViewModel;
        this.triviaGameViewModel = triviaGameViewModel;
    }

    @Override
    public void present(NavigateOutputData outputData) {

        // Getting the current state
        NavigateState state = navigateViewModel.getState();
        // Update fields (story + direction)
        state.setStoryText(outputData.getStoryText());
        state.setDirection(outputData.getDirection());
        // Notify NavigateView to refresh UI
        navigateViewModel.firePropertyChange();
    }

    @Override
    public void prepareSuccessView(NavigateOutputData2 outputData) {
        switch (outputData.getTargetView().toLowerCase()) {
            case "win game":
                this.viewManagerModel.setState(winGameViewModel.getViewName());
            case "card game":
                this.viewManagerModel.setState(cardGameViewModel.getViewName());
            case "trivia game":
                this.viewManagerModel.setState(triviaGameViewModel.getViewName());
        }

        this.viewManagerModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
