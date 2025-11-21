package interface_adapter.navigate;

import entity.Puzzle;
import use_case.navigate.NavigateOutputData;

public class NavigatePresenter implements NavigateOutputBoundary {
    private viewManagerModel viewManagerModel;
    private Puzzle puzzle;

    public NavigatePresenter(NavigateOutputData navigateOutputData) {
        this.puzzle = navigateOutputData.getPuzzle();

    }

    public void prepareSuccessView(NavigateOutputData outputData) {
        this.viewManagerModel.setState(// this should be the panel of teh game)
    }
}