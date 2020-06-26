package com.company;

public abstract class Team<T> {
    private String name;
    private int playerCount;

    public Team(String name, int playerCount) {
        this.name = name;
        this.playerCount = playerCount;
    }

    public String getName() {
        return name;
    }

    public int getPlayerCount() {
        return playerCount;
    }
}
