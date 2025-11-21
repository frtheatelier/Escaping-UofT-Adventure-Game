package use_case.navigate;

import entity.Puzzle;

/**
 * Output data returned from the NavigateInteractor.
 * Contains the updated story text and the direction the player moved.
 */
public class NavigateOutputData {

    private final String storyText;
    private final String direction;
    private final String location;
    private final Puzzle puzzle;

    public NavigateOutputData(String storyText, String direction, String location, Puzzle puzzle) {
        this.storyText = storyText;
        this.direction = direction;
        this.location = location;
        this.puzzle = puzzle;
    }

    public String getStoryText() {
        return storyText;
    }

    public String getDirection() {
        return direction;
    }

    public String getLocation () { return location; }

    public Puzzle getPuzzle() { return puzzle; }
}
