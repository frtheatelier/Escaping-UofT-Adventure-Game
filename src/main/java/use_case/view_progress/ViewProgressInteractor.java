package use_case.view_progress;

public class ViewProgressInteractor implements ViewProgressInputBoundary {

    private final ViewProgressDataAccessInterface dataAccess;
    private final ViewProgressOutputBoundary presenter;

    public ViewProgressInteractor(ViewProgressDataAccessInterface dataAccess,
                                  ViewProgressOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        System.out.println("Executing ViewProgressInteractor");
        String loc = dataAccess.getLocation();
        int keys = dataAccess.getKeysCollected();
        var puzzles = dataAccess.getSolvedPuzzles();

        System.out.println(loc);

        ViewProgressOutputData output = new ViewProgressOutputData(loc, keys, puzzles);
        presenter.present(output);
    }
}
