package com.company;

public class Main {

    public static void main(String[] args) {
	    Wall wall1 = new Wall();
        System.out.println(wall1.getHeight());
        System.out.println(wall1.getWidth());
        System.out.println(wall1.getArea());

        wall1.setHeight(-1.25d);
        wall1.setWidth(1d);
        System.out.println(wall1.getHeight());
        System.out.println(wall1.getWidth());
        System.out.println(wall1.getArea());
    }
}
