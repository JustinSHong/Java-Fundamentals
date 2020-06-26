package com.company;

// base hamburger has:
    // bread roll type
    // meat
    // additions - lettuce, tomato, cheese, pickles
    // base price
    // name

public class Hamburger {
    private double basePrice;
    private String breadRollType;
    private String meat;
    private String name;
    // additions to burger
    private boolean hasCheese;
    private boolean hasLettuce;
    private boolean hasPickles;
    private boolean hasTomato;
    private double cheeseCost;
    private double lettuceCost;
    private double pickleCost;
    private double tomatoCost;
    private int numberOfAddons;
    private double costOfAddons;

    public Hamburger(double basePrice, String breadRollType, String meat, String name) {
        this.basePrice = basePrice;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.name = name;
        // additions
        this.hasCheese = false;
        this.hasLettuce = false;
        this.hasPickles = false;
        this.hasTomato = false;
        this.cheeseCost = 1d;
        this.lettuceCost = 0.5d;
        this.pickleCost = 1.5d;
        this.tomatoCost = 2d;
        this.numberOfAddons = 0;
        this.costOfAddons = 0d;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public String getName() {
        return name;
    }

    public boolean isHasCheese() {
        return hasCheese;
    }

    public void setHasCheese() {
        this.hasCheese = !hasCheese;
        this.numberOfAddons++;
        this.costOfAddons += this.cheeseCost;
    }

    public boolean isHasLettuce() {
        return hasLettuce;
    }

    public void setHasLettuce() {
        this.hasLettuce = !hasLettuce;
        this.numberOfAddons++;
        this.costOfAddons += this.lettuceCost;
    }

    public boolean isHasPickles() {
        return hasPickles;
    }

    public void setHasPickles() {
        this.hasPickles = !hasPickles;
        this.numberOfAddons++;
        this.costOfAddons += this.pickleCost;
    }

    public boolean isHasTomato() {
        return hasTomato;
    }

    public void setHasTomato() {
        this.hasTomato = !hasTomato;
        this.numberOfAddons++;
        this.costOfAddons += this.tomatoCost;
    }

    public int getNumberOfAddons() {
        return numberOfAddons;
    }

    public void setNumberOfAddons(int numberOfAddons) {
        this.numberOfAddons = numberOfAddons;
    }

    // show burger base price
    // show all additions (name and price)
    // show and return grand total of the order
    public double getOrderTotal() {
        double orderTotal = this.basePrice + this.costOfAddons;

        System.out.println("*****BASE BURGER COSTS*****");
        System.out.println("Base burger's price is " + this.basePrice);

        if (this.hasCheese) {
            System.out.println("Cheese add on price is " + this.cheeseCost);
        }

        if (this.hasLettuce) {
            System.out.println("Lettuce add on price is " + this.lettuceCost);
        }

        if (this.hasPickles) {
            System.out.println("Pickles add on price is " + this.pickleCost);
        }

        if (this.hasTomato) {
            System.out.println("Tomato add on price is " + this.tomatoCost);
        }

        System.out.println("Your grand total is " + (this.basePrice + this.costOfAddons));

        return orderTotal;
    }
}
