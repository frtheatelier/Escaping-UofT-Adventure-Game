package interface_adapter.validate_card_answer;

import interface_adapter.ViewManagerModel;
import interface_adapter.play_card_game.CardGameViewModel;
import use_case.validateCardAnswer.ValidateCardAnswerOutputBoundary;
/**
 * The Presenter for the Play Card Game Use Case.
 */
public class ValidateCardPresenter implements ValidateCardAnswerOutputBoundary {
    private final CardGameViewModel cardGameViewModel;
    private final ViewManagerModel viewManagerModel;
    public ValidateCardPresenter() {

    }
}
