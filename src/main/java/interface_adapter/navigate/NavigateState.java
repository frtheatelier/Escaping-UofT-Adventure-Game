package interface_adapter.navigate;

import java.util.HashSet;
import java.util.Set;

public class NavigateState{
//    private String currentLocationName; // not sure if it's necessary
    private Set<String> puzzlesSolved; // store puzzle name or id or whatever
    private int numberOfKeys;

    public NavigateState() {
//        this.currentLocationName = "";
        this.puzzlesSolved = new HashSet<>();
        this.numberOfKeys = 0;
    }

    public Set<String> getPuzzlesSolved() {
        return puzzlesSolved;
    }

    public void addPuzzleSolved(String puzzle) {
        puzzlesSolved.add(puzzle);
    }

    public void removePuzzleSolved(String puzzle) {
        puzzlesSolved.remove(puzzle);
    }

    public void resetPuzzlesSolved() {
        puzzlesSolved = new HashSet<>();
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public void addNumberOfKeys() {
        this.numberOfKeys++;
    }

    public void addNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys += numberOfKeys;
    }
}