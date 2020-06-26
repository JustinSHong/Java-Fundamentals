package com.company;

// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.
//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.

public class Main {

    public static void main(String[] args) {
	    LeagueTable<BaseballTeam> baseballTable = new LeagueTable<>("Baseball League");
	    LeagueTable<BasketballTeam> basketballTable = new LeagueTable<>("Basketball League");
	    LeagueTable<SoccerTeam> soccerTable = new LeagueTable<>("Soccer League");

        BaseballTeam dodgers = new BaseballTeam("Dodgers", 12);
        BasketballTeam lakers = new BasketballTeam("Lakers", 15);
        SoccerTeam galaxy = new SoccerTeam("Galaxy", 20);

        baseballTable.getTeams().add(dodgers);
        basketballTable.getTeams().add(lakers);
        soccerTable.getTeams().add(galaxy);

        baseballTable.printTeams();
        basketballTable.printTeams();
        soccerTable.printTeams();
    }
}
