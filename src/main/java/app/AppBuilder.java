package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.clear_history.ClearHistoryController;
import interface_adapter.clear_history.ClearHistoryPresenter;
import interface_adapter.navigate.NavigateViewModel;
import use_case.clear_history.ClearHistoryInputBoundary;
import use_case.clear_history.ClearHistoryInteractor;
import use_case.clear_history.ClearHistoryOutputBoundary;
import view.NavigateView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

// TODO: Add imports

public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // TODO: Add Factories
    final ViewManagerModel viewManagerModel = new ViewManagerModel();
    ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // TODO: Implement DAO

    // TODO: Implement Views and View Models
    private NavigateViewModel NavigateViewModel;
    private NavigateView NavigateView;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    // TODO: Implement add<item>View()
    public AppBuilder add___View() {
        /* Structure:
        <item>ViewModel i = new <item>ViewModel(...);
        <item>View j = new <item>View(...);
        cardPanel.add(j, j.getViewName());
        return this;
         */
    }

    // TODO: Implement add<item>UseCase()
    public AppBuilder add___UseCase() {
        /* Structure:
        final <item>OutputBoundary i = new <item>Presenter(...);
        final <item>InputBoundary j = new <item>Interactor>(...);
        <item>Controller k = new <item>Controller(...);
        <item>View.setController(k) // (private variable in AppBuilder)
        return this;
         */
    }

    public AppBuilder addClearHistoryUseCase() {
        final ClearHistoryOutputBoundary outputBoundary = new ClearHistoryPresenter(NavigateViewModel);
        final ClearHistoryInputBoundary inputBoundary = new ClearHistoryInteractor(outputBoundary);
        ClearHistoryController controller = new ClearHistoryController();
        NavigateView.setClearHistoryController(controller);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("User Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(navigationView.getViewName());
        viewManagerModel.firePropertyChange();

        return application;
    }


}