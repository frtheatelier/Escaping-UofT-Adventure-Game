package use_case.navigate;
import entity.*;
import org.jetbrains.annotations.NotNull;

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

        // version 1
//        String storyText = generateStoryForDirection(direction);
//        String location = generateLocation(direction);
//        Puzzle puzzle = assignPuzzle(direction);
//        use_case.navigate.NavigateOutputData outputData =
//                new use_case.navigate.NavigateOutputData(storyText, direction, location, puzzle);
//        navigatePresenter.present(outputData);

        // version 2 (MY VERSION)
        navigatePresenter.prepareSuccessView(new NavigateOutputData2(getTargetView(direction)));
    }

    @NotNull
    private static String getTargetView(String direction) {
        return switch (direction) {
            case "north" -> "Card game";
            case "south" -> "Win game";
            case "east" -> "Trivia game";
            case "west" -> "Card game";
            default -> "";
        };
    }

    /*
     * with building traversal, puzzles, and key collection.
     */
//    private String generateStoryForDirection(String direction) {
//        switch (direction.toLowerCase()) {
//            case "north":
//                return "You head North toward University College...\n\nA cold breeze brushes past.";
//            case "south":
//                return "You walk South toward the Engineering buildings...\n\nSomething feels off.";
//            case "east":
//                return "You turn East toward Convocation Hall...\n\nThe echoes follow you.";
//            case "west":
//                return "You walk West toward the Quad...\n\nThe shadows grow deeper.";
//            default:
//                return "You stand still, unsure where to go.";
//        }
//    }
//
//    private String generateLocation(String direction) {
//        switch (direction.toLowerCase()) {
//            case "north":
//                return "University College";
//            case "south":
//                return "Convocation Hall";
//            case "east":
//                return "Gerstein Library";
//            case "west":
//                return "Knox College";
//            default:
//                return "You stand still, unsure where to go.";
//        }
//    }
//
//    private Puzzle assignPuzzle(String direction) {
//        switch (direction.toLowerCase()) {
//            case "north":
//                return new CardPuzzle(new List<Card>); //hardcoded for now, TODO: change later
//            case "south":
//                return new WinCondition(0); //hardcoded for now, TODO: change later
//            case "east":
//                return new TriviaPuzzle(0); //hardcoded for now, TODO: change later
//            case "west":
//                return new CardPuzzle(new List<Card>); //hardcoded for now, TODO: change later
//            default:
//                return null;
//        }
//    }
}
