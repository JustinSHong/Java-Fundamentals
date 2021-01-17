package com.company;

public class EnhancedPlayer {
    private String name;
    private int hitpoints = 100; // outside world doesn't know the name of this var
    private String weapon;

    // encapsulating member variables
        // we can validate data
        // guarantee members are initialized

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if (health > 0 && health <= 100) {
            this.hitpoints = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.hitpoints = this.hitpoints - damage;
        if (this.hitpoints <= 0) {
            System.out.println("Player knocked out");
            // reduce number of lives
        }
    }

    public int getHealth() {
        return this.hitpoints;
    }
}
