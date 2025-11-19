package interface_adapter.validate_card_answer;
import entity.Card;
import entity.CardPuzzle;
import use_case.validateCardAnswer.ValidateCardAnswerInputData;
import use_case.validateCardAnswer.ValidateCardAnswerInputBoundary;

import java.util.List;
import entity.Player;

/**
 * Controller for the Play Card Game Use Case.
 */
public class ValidateCardController {
    private final ValidateCardAnswerInputBoundary validateInteractor;

    public ValidateCardController(ValidateCardAnswerInputBoundary validateInteractor) {
        this.validateInteractor = validateInteractor;
    }

    /**
     * Executes the Play Card Game Use Case.
     */
    public void execute(Player player, String expression, List<Card> cards, CardPuzzle cardPuzzle) {
        final ValidateCardAnswerInputData validInputData = new ValidateCardAnswerInputData(
                player, expression, cards, cardPuzzle);
        validateInteractor.execute(validInputData);
    }
}
