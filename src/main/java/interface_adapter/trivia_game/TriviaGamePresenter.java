package interface_adapter.trivia_game;

import interface_adapter.ViewManagerModel;
import interface_adapter.navigate.NavigateState;
import interface_adapter.navigate.NavigateViewModel;
import use_case.trivia_game.TriviaGameOutputBoundary;
import use_case.trivia_game.TriviaGameOutputData;

public class TriviaGamePresenter implements TriviaGameOutputBoundary {
    private final TriviaGameViewModel viewModel;

    private final NavigateViewModel navigateViewModel;
    private final ViewManagerModel viewManagerModel;

    public TriviaGamePresenter(TriviaGameViewModel viewModel, NavigateViewModel navigateViewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.navigateViewModel = navigateViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentQuestion(TriviaGameOutputData outputData) {
        TriviaGameState state = viewModel.getState();
        state.setQuestion(outputData.getQuestion());
        state.setMessage(outputData.getMessage());
        state.setCorrectAnswers(outputData.getCorrectAnswers());
        state.setRequiredAnswers(outputData.getRequiredAnswers());
        state.setPuzzleSolved(outputData.isPuzzleSolved());
        state.setAnsweredCurrentQuestion(false);

        viewModel.firePropertyChange();
    }

    @Override
    public void presentResult(TriviaGameOutputData outputData) {
        TriviaGameState state = viewModel.getState();
        state.setMessage(outputData.getMessage());
        state.setCorrectAnswers(outputData.getCorrectAnswers());
        state.setPuzzleSolved(outputData.isPuzzleSolved());
        state.setAnsweredCurrentQuestion(true);

        viewModel.firePropertyChange();
    }

    @Override
    public void exitPuzzle() {
        TriviaGameState state = viewModel.getState();
        NavigateState navState = navigateViewModel.getState();

        if (state.isPuzzleSolved() && !navState.getPuzzlesSolved().contains(state.getPuzzleName())) {
            System.out.println("Trivia Puzzle Solved");
            navState.addNumberOfKeys();
            navState.addPuzzleSolved(state.getPuzzleName());
            navState.setStoryText("Good job on solving the trivia puzzle.\nWhere would you like to go next?");

            System.out.println("Keys (1): " + navState.getNumberOfKeys());
            System.out.println("Keys (2): " + navigateViewModel.getState().getNumberOfKeys());
        }

        navState.setLocation();
        this.navigateViewModel.firePropertyChange();

        this.viewManagerModel.setState(navigateViewModel.getViewName());
        System.out.println("Keys (3): " + navigateViewModel.getState().getNumberOfKeys());
        this.viewManagerModel.firePropertyChange();
    }
}