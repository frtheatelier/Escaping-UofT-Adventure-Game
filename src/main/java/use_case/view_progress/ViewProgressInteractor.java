package use_case.view_progress;

import interface_adapter.navigate.NavigateViewModel;

public class ViewProgressInteractor implements ViewProgressInputBoundary {

    private final ViewProgressOutputBoundary presenter;

    public ViewProgressInteractor(ViewProgressOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute(ViewProgressInputData inputData) {
        System.out.println("Executing ViewProgressInteractor");

        String loc = inputData.getLocation();
        int keys = inputData.getKeys();
        var puzzles = inputData.getPuzzles();

        System.out.println(loc);

        ViewProgressOutputData output = new ViewProgressOutputData(loc, keys, puzzles);
        presenter.present(output);
    }
}
