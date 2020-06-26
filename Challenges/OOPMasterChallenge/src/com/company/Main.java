package com.company;

public class Main {

    public static void main(String[] args) {
	    HealthyBurger theHealthyBurger = new HealthyBurger(false, false);
	    theHealthyBurger.setHasCarrot();
	    theHealthyBurger.setHasCucumber();
	    theHealthyBurger.setHasCheese();
	    theHealthyBurger.setHasLettuce();
	    theHealthyBurger.setHasPickles();
	    theHealthyBurger.setHasTomato();
	    theHealthyBurger.getOrderTotal();


	    DeluxeBurger theDeluxeBurger = new DeluxeBurger(false, false);
	    theDeluxeBurger.setHasChips();
	    theDeluxeBurger.setHasDrink();
        theDeluxeBurger.setHasCheese();
        theDeluxeBurger.setHasLettuce();
        theDeluxeBurger.setHasPickles();
        theDeluxeBurger.setHasTomato();

	    theDeluxeBurger.getOrderTotal();

    }
}
