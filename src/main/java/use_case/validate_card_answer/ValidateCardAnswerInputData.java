package use_case.validate_card_answer;

import java.util.List;
import entity.Card;
import entity.CardPuzzle;

public class ValidateCardAnswerInputData {
    /**
     * The input data for the Validate Card Answer Use Case.
     */
//    private final Player player; // should not require player
    private final String expression;
    private final List<Card> cards;
    private final CardPuzzle cardPuzzle;

    public ValidateCardAnswerInputData(String expression, CardPuzzle cardPuzzle) {
        this.expression = expression;
        this.cards = cardPuzzle.getCards();
        this.cardPuzzle = cardPuzzle;
    }

    public String getExpression() {
        return this.expression;

    }
    public List<Card> getCards() {
        return this.cards;
    }

    public CardPuzzle getCardPuzzle() {
        return this.cardPuzzle;
    }
}