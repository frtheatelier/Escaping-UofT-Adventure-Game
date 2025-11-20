package interface_adapter.return_from_card;

import use_case.card_return_to_home.CardReturnOutputBoundary;
import interface_adapter.ViewManagerModel;
import interface_adapter.navigate.NavigateViewModel;
public class ReturnFromCardPresenter implements CardReturnOutputBoundary{
    private final ViewManagerModel viewManagerModel;
    private final NavigateViewModel navigateViewModel;

    public ReturnFromCardPresenter(ViewManagerModel viewManagerModel,
                                   NavigateViewModel navigateViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.navigateViewModel = navigateViewModel;
    }

    @Override
    public void changeView() {
        this.viewManagerModel.setState(this.navigateViewModel.getViewName());
        this.viewManagerModel.firePropertyChange();
    }
}
