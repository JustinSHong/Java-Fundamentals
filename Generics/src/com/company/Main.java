package com.company;

// generics allow us to create classes, interfaces, and methods that take types as parameters (type parameters)
    // parameterized type - type provided to a generic type <T>
    // can catch type errors at compile time not run time

// earlier a bug is noticed the easier and cheaper it is to fix
    // catching at compile time - no one but the programmer notices
    // test - now all other tests must pass
    // prod - now a lot of other people will notice the bug

// bounded type parameters - mechanism for restricting types that can be used as type parameters

// type parameters can be
    // class or interface
    // interfaces can also have type parameters

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//	    ArrayList items = new ArrayList();

        ArrayList<Integer> items = new ArrayList<>(); // use integer type
	    items.add(1);
	    items.add(2);
	    items.add(3);
	    items.add(4);
	    items.add(5);
//        items.add("Justin"); // can't do this without generics

	    printDoubled(items);

	    FootballPlayer joe = new FootballPlayer("Joe");
	    BaseballPlayer pat = new BaseballPlayer("Pat");
	    SoccerPlayer beckham = new SoccerPlayer("Beckham");

	    Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
	    adelaideCrows.addPlayer(joe);
//	    adelaideCrows.addPlayer(pat); // not a football player
//	    adelaideCrows.addPlayer(beckham); // not a football player

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPlayer(beckham); // still need to validate

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle,1, 0);
        hawthorn.matchResult(adelaideCrows,3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
//        adelaideCrows.matchResult(baseballTeam, 1, 1);

        System.out.println(adelaideCrows.getName() + " : " + adelaideCrows.ranking());
        System.out.println(fremantle.getName() + " : " + adelaideCrows.ranking());
        System.out.println(hawthorn.getName() + " : " + adelaideCrows.ranking());

        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
    }

    // without using generics - need to tell what type of object is in ArrayList
        // if you don't errors will go unnoticed until run time
    private static void printDoubled(ArrayList<Integer> n) {
        for (int i : n) {
            System.out.println(i * 2);
        }
    }
}
