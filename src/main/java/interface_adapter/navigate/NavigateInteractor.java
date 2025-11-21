package use_case.navigate;
import entity.*;

import java.util.List;

public class NavigateInteractor implements NavigateInputBoundary {

    private final NavigateOutputBoundary navigatePresenter;

    public NavigateInteractor(NavigateOutputBoundary navigatePresenter) {
        this.navigatePresenter = navigatePresenter;
    }

    /*
     * Takes a direction and returns updated story
     */
    @Override
    public void execute(NavigateInputData inputData) {
        String direction = inputData.getDirection();
        String storyText = generateStoryForDirection(direction);
        String location = generateLocation(direction);
        Puzzle puzzle = assignPuzzle(direction);
        use_case.navigate.NavigateOutputData outputData =
                new use_case.navigate.NavigateOutputData(storyText, direction, location, puzzle);
        navigatePresenter.present(outputData);
    }

    /*
     * with building traversal, puzzles, and key collection.
     */
    private String generateStoryForDirection(String direction) {
        switch (direction.toLowerCase()) {
            case "North":
                return "You head North toward University College...\n\nA cold breeze brushes past.";
            case "South":
                return "You walk South toward the Engineering buildings...\n\nSomething feels off.";
            case "East":
                return "You turn East toward Convocation Hall...\n\nThe echoes follow you.";
            case "West":
                return "You walk West toward the Quad...\n\nThe shadows grow deeper.";
            default:
                return "You stand still, unsure where to go.";
        }
    }

    private String generateLocation(String direction) {
        switch (direction.toLowerCase()) {
            case "North":
                return "University College";
            case "South":
                return "Convocation Hall";
            case "East":
                return "Gerstein Library";
            case "West":
                return "Knox College";
            default:
                return "You stand still, unsure where to go.";
        }
    }

    private Puzzle assignPuzzle(String direction) {
        switch (direction.toLowerCase()) {
            case "North":
                return new CardPuzzle(new List<Card>); //hardcoded for now, TODO: change later
            case "South":
                return new WinCondition(0); //hardcoded for now, TODO: change later
            case "East":
                return new TriviaPuzzle(0); //hardcoded for now, TODO: change later
            case "West":
                return new CardPuzzle(new List<Card>); //hardcoded for now, TODO: change later
            default:
                return null;
        }
    }
}
