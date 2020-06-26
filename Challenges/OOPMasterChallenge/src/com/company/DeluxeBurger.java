package com.company;

// has chips and drinks
// no add ons allowed

public class DeluxeBurger extends Hamburger {
    private boolean hasChips;
    private boolean hasDrink;
    private double chipsCost;
    private double drinkCost;
    private int numberOfAddons;
    private double costOfAddons;

    public DeluxeBurger(boolean hasChips, boolean hasDrink) {
        super(20d, "sourdough", "ribeye", "The Deluxe Burger");
        this.hasChips = false;
        this.hasDrink = false;
        this.chipsCost = 4d;
        this.drinkCost = 6d;
        this.numberOfAddons = 0;
        this.costOfAddons = 0d;
    }

    public void setHasChips() {
        this.hasChips = !hasChips;
        this.numberOfAddons++;
        this.costOfAddons += this.chipsCost;
    }

    public void setHasDrink() {
        this.hasDrink = !hasDrink;
        this.numberOfAddons++;
        this.costOfAddons += this.drinkCost;
    }

    @Override
    public void setHasCheese() {
        System.out.println("CAN NOT ADD CHEESE TO DELUXE BURGER");
    }

    @Override
    public void setHasLettuce() {
        System.out.println("CAN NOT ADD LETTUCE TO DELUXE BURGER");
    }

    @Override
    public void setHasPickles() {
        System.out.println("CAN NOT ADD PICKLES TO DELUXE BURGER");
    }

    @Override
    public void setHasTomato() {
        System.out.println("CAN NOT ADD TOMATO TO DELUXE BURGER");
    }

    @Override
    public double getOrderTotal() {
        double baseTotal = super.getOrderTotal();
        double grandTotal = baseTotal + this.costOfAddons;

        System.out.println("***Deluxe Burger specific costs***");

        if (this.hasChips) {
            System.out.println("Chips price is " + this.chipsCost);
        }

        if (this.hasDrink) {
            System.out.println("Drink price is " + this.drinkCost);
        }
        System.out.println("Number of add ons is " + (this.numberOfAddons + super.getNumberOfAddons()));
        System.out.println("Your grand total is " + (baseTotal + this.costOfAddons));

        return grandTotal;
    }
}
