package com.company;

public class BaseballTeam extends Team {
    public BaseballTeam(String name, int playerCount) {
        super(name, playerCount);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPlayerCount() {
        return super.getPlayerCount();
    }
}
