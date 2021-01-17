package com.company;

// encapsulation - mechanism that allows you to restrict access to certain components in the objects you are creating
    // protect members from external access
    // stop code/classes outside of your classes from accessing inner workings of your objects
    // gives you more control and allows you to change things without breaking things for consumers

public class Main {

    public static void main(String[] args) {
//	    Player player = new Player();
//	    player.name = "justin";
//	    player.health = 20;
//	    player.weapon = "sword";
//
//	    int damage = 10;
//	    player.loseHealth(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());
//
//		damage = 11;
//		player.health = 2000; // cheating
//		player.loseHealth(damage);
//		System.out.println("Remaining health = " + player.healthRemaining());

		// making member variables public allows players to cheat and removes control from the Player class
		// changes to the class causes more breaks - code outside of the class also relies on members directly
			// more error prone
			// can't check data is valid

		EnhancedPlayer player = new EnhancedPlayer("Justin", 200, "Sword");
		System.out.println("initial health " + player.getHealth()); // can only get health via a getter
    }
}
