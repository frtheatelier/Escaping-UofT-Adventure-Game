package entity;

import java.util.*;

public class Player {

    private final String name;
    private Location currentLocation;
    private int keysCollected;
    private final Set<String> puzzlesSolved;
    private final List<Key> keyInventory;

    public Player(String name, Location startLocation) {
        this.name = name;
        this.currentLocation = startLocation;
        this.keysCollected = 0;
        this.puzzlesSolved = new HashSet<>();
        this.keyInventory = new ArrayList<>();
    }

    public boolean move(String direction) {
        if (currentLocation.getExits().containsKey(direction)) {
            Location next = currentLocation.getExits().get(direction);

            if (next.getName().equals("Convocation Hall") && keysCollected < 3) {
                System.out.println("YOU CANNOT ENTER HERE, Convocation Hall is locked. Collect 3 keys to enter.");
                return false;
            }

            currentLocation = next;
            return true;
        }
        return false;
    }

    public boolean enterLocation(Location location) {
        this.currentLocation = location;
        return true;
    }

    public void exitLocation() {
    }

    public void addKey(Key key) {
        keyInventory.add(key);
        keysCollected++;
    }

    public boolean hasKey(String keyOrigin) {
        return keyInventory.stream().anyMatch(k -> k.getOrigin().equals(keyOrigin));
    }

    public void markPuzzleSolved(String puzzleId) {
        puzzlesSolved.add(puzzleId);
    }

    public boolean isPuzzleSolved(String puzzleId) {
        return puzzlesSolved.contains(puzzleId);
    }

    public boolean canEnterConvocationHall() {
        return keysCollected >= 3;
    }

    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getKeysCollected() {
        return keysCollected;
    }

    public List<Key> getKeyInventory() {
        return keyInventory;
    }

    public String getStatus() {
        return "Player: " + name +
                "\nLocation: " + currentLocation.getName() +
                "\nKeys collected: " + keysCollected +
                "\nSolved puzzles: " + puzzlesSolved +
                "\nInventory: " + keyInventory;
    }
}
