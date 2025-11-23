package use_case.card_game_hints;

import entity.Card;
import use_case.play_card_game.utilities.SolutionGenerator;

import java.util.List;
import java.util.Objects;

public class CardGameHintsInteractor implements CardGameHintsInputDataBoundary{
    private final CardGameHintsOutputBoundary outputBoundary;

    public CardGameHintsInteractor(CardGameHintsOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void execute(CardGameHintsInputDataObject input) {
        try {
            String hint = "";

            List<Card> cards = input.getCardPuzzle().getCards();
            String sol = getSampleSolution(cards);
            if (Objects.equals(sol, "")) {
                hint = "No solution found! Please regenerate the question.";
            } else {
                hint = "Maybe try " + extractInner(sol) + " first.";
            }

            CardGameHintsOutputDataObject outputData = new CardGameHintsOutputDataObject(hint);
            this.outputBoundary.prepareSuccessView(outputData);
        }  catch (Exception e) {
            this.outputBoundary.prepareFailView("Failed to get hint: " + e.getMessage());
        }
    }

    public String getSampleSolution(List<Card> cards) {
        return SolutionGenerator.getFirstSolution(cards);
    }

    public String extractInner(String solution) {
        int open;
        int close;
        if (solution.contains("))")) {
            open = solution.lastIndexOf("(");
            close = solution.indexOf("))");
        } else if (solution.contains("((")) {
            open = solution.indexOf("((") + 1; // bruh not ts getting flipped
            close = solution.indexOf(")");
        } else {
            open = solution.indexOf("(");
            close = solution.indexOf(")");
        }
        return solution.substring(open + 1, close);
    }
}
