package use_case.card_game_hints;

import data_access.CardHintsDataAccessObject;
import entity.CardPuzzle;

public class CardGameHintsInteractor {
    private final CardGameHintsOutputBoundary cardGamePresenter;
    private final CardHintsDataAccessObject hintDataAccess;

    public CardGameHintsInteractor(CardGameHintsOutputBoundary cardGamePresenter,
                                   CardHintsDataAccessObject hintDataAccess) {
        this.cardGamePresenter = cardGamePresenter;
        this.hintDataAccess = hintDataAccess;
    }

    public void execute(CardGameHintsInputDataObject input) {
        try {
            CardPuzzle cardPuzzle = input.getCardPuzzle();
            String hint = this.hintDataAccess.generateHint(cardPuzzle);

            CardGameHintsOutputDataObject outputData = new CardGameHintsOutputDataObject(hint);
            this.cardGamePresenter.prepareSuccessView(outputData);
        }  catch (Exception e) {
            this.cardGamePresenter.prepareFailView("Failed to get hint: " + e.getMessage());
        }
    }
}
