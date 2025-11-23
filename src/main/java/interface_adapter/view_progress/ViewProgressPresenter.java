package interface_adapter.view_progress;

import interface_adapter.navigate.NavigateState;
import interface_adapter.navigate.NavigateViewModel;
import use_case.view_progress.ViewProgressOutputBoundary;
import use_case.view_progress.ViewProgressOutputData;

public class ViewProgressPresenter implements ViewProgressOutputBoundary {

    private final NavigateViewModel viewModel;

    // changed to nav view state bc my guy, this is not even used.
    public ViewProgressPresenter(NavigateViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void present(ViewProgressOutputData data) {
        String text = "Location: " + data.getLocation() + "\n"
                + "Keys collected: " + data.getKeysCollected() + "\n"
                + "Solved puzzles: " + data.getSolvedPuzzles();

        System.out.println(text);

        NavigateState current = viewModel.getState();
        current.setProgressText(text);
        viewModel.firePropertyChange();

        // BRO YOU DO ALL THIS BUT HOW??? DO YOU WAWNT TO SHOW IT??????? MY BRO MY GUY WHAT
        // which is why i changed it to modify navigate state bc button only exists there.
    }
}
