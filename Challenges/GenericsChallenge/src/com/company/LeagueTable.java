package com.company;


import java.util.ArrayList;

class LeagueTable<T extends Team> {
    private ArrayList<T> teams;
    private String name;

    public LeagueTable(String name) {
        this.name = name;
        this.teams = new ArrayList<T>();
    }


    public ArrayList<T> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public void addTeam(T team) {
        teams.add(team);
    }

    public void printTeams() {
        for (T team : this.teams) {
            System.out.println("League Name: " + getName() + " teams: " + team.getName() + " playerCount: " + team.getPlayerCount());
        }
    }
}
