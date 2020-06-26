package com.company;

// brown rye bread roll
// any 2 addition items from Hamburger up to 6 max
    // carrot
    // cucumber

public class HealthyBurger extends Hamburger {
    private boolean hasCarrot;
    private boolean hasCucumber;
    private double carrotPrice;
    private double cucumberPrice;
    private int numberOfAddons;
    private double costOfAddons;

    public HealthyBurger(boolean hasCarrot, boolean hasCucumber) {
        super(10d, "brownRye", "Falafel", "The Healthy Burger");
        this.hasCarrot = false;
        this.hasCucumber = false;
        this.carrotPrice = 3d;
        this.cucumberPrice = 2.5d;
        this.numberOfAddons = 0;
        this.costOfAddons = 0d;
    }

    public void setHasCarrot() {
        this.hasCarrot = !hasCarrot;
        this.numberOfAddons++;
        this.costOfAddons += this.carrotPrice;
    }

    public void setHasCucumber() {
        this.hasCucumber = !hasCucumber;
        this.numberOfAddons++;
        this.costOfAddons += this.cucumberPrice;
    }

    @Override
    public double getOrderTotal() {
        double baseTotal = super.getOrderTotal();
        double grandTotal = baseTotal + this.costOfAddons;

        System.out.println("***Healthy Burger specific costs***");

        if (this.hasCarrot) {
            System.out.println("Carrot price is " + this.carrotPrice);
        }

        if (this.hasCucumber) {
            System.out.println("Cucumber price is " + this.cucumberPrice);
        }

        System.out.println("Number of add ons is " + (this.numberOfAddons + super.getNumberOfAddons()));
        System.out.println("Your grand total is " + grandTotal);
        return this.costOfAddons;
    }
}
