package interface_adapter.navigate;
import interface_adapter.ViewModel;
import interface_adapter.trivia_game.TriviaGameState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// holy fucking shit what is this
// KLJSDFHSLKFFEWLJK GUYS????

public class NavigateViewModel extends ViewModel<NavigateState> {
//    public static final String TITLE = "Escaping UofT — Navigation";
//    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
//    private NavigateState state = new NavigateState();
//    public NavigateViewModel() {
//        super("navigate_view");
//    }
//
//    public void firePropertyChanged() {
//        support.firePropertyChange("navigate_state", null, this.state);
//    }
//
//    @Override
//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
//    }
//
//    public NavigateState getState() {
//        return state;
//    }
//
//    public void setState(NavigateState state) {
//        this.state = state;
//    }

    public NavigateViewModel() {
        super("navigate_view");
        setState(new NavigateState());
    }
}
