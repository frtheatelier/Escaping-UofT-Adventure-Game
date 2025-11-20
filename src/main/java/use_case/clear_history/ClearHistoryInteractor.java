package use_case.clear_history;

public class ClearHistoryInteractor implements ClearHistoryInputBoundary {
    private final ClearHistoryOutputBoundary presenter;

    public ClearHistoryInteractor(ClearHistoryOutputBoundary presenter) {
        this.presenter = presenter;
    }

    public void clearHistory() {
        presenter.execute();
    }
}