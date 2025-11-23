package use_case.view_progress;

import interface_adapter.navigate.NavigateState;
import interface_adapter.navigate.NavigateViewModel;

public class ViewProgressInteractor implements ViewProgressInputBoundary {

    private final ViewProgressDataAccessInterface dataAccess;
    private final ViewProgressOutputBoundary presenter;

    private NavigateViewModel navigateViewModel;

    public ViewProgressInteractor(ViewProgressDataAccessInterface dataAccess,
                                  ViewProgressOutputBoundary presenter, NavigateViewModel navigateViewModel) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
        this.navigateViewModel = navigateViewModel;
    }

    @Override
    public void execute() {
        System.out.println("Executing ViewProgressInteractor");

        NavigateState state = navigateViewModel.getState();
        String loc = state.getLocation();
        int keys = state.getNumberOfKeys();
        var puzzles = state.getPuzzlesSolved();

        System.out.println(loc);

        ViewProgressOutputData output = new ViewProgressOutputData(loc, keys, puzzles);
        presenter.present(output);
    }
}
