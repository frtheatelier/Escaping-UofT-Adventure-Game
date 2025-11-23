package interface_adapter.clear_history;

import interface_adapter.navigate.NavigateState;
import interface_adapter.navigate.NavigateViewModel;
import use_case.clear_history.ClearHistoryOutputBoundary;

public class ClearHistoryPresenter implements ClearHistoryOutputBoundary {
    private final NavigateViewModel viewModel;

    public ClearHistoryPresenter(NavigateViewModel viewModel) {
        this.viewModel = viewModel;
    }
    public void prepareSuccessView(String message) {
//        viewModel.setMessage(message);  // UI update
        // set up the nav model to inclue messages if need be because. ugh.
    }
    public void prepareFailView(String errorMessage) {
//        viewModel.setMessage(errorMessage);
    }

    @Override
    public void execute() {
        NavigateState state = viewModel.getState();
        System.out.println(state instanceof NavigateState);
        System.out.println("Current state is: " + state + " ; Keys: " + state.getNumberOfKeys());
        state.setNumberOfKeys(0);
        state.resetPuzzlesSolved();

        viewModel.firePropertyChange();
    }
}