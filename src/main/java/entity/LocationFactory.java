package main.java.entity;

public class LocationFactory {
    public Location create(String name, String description, boolean locked, String coordinates) {
        return new Location(name, description, locked, coordinates);
    }
}
