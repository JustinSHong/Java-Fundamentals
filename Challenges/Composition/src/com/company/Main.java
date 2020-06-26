package com.company;

public class Main {

    public static void main(String[] args) {
	    Chair theChair = new Chair(new Dimensions(3, 5, 4), new Cost(100, 0 ,0), "brown", true, true, 4);
	    Door theDoor = new Door(new Dimensions(5, 7, 4), new Cost(200, 10, 20), 3, true, true);
	    Roof theRoof = new Roof(new Dimensions(100, 100, 8), new Cost(1000, 200, 0), "tiled", true, true, 20, 1);
	    Floor theFloor = new Floor("hard-wood", new Dimensions(30, 30, 0),"black",new Cost(300, 60, 0));
	    Sofa theSofa = new Sofa(new Dimensions(6,7,8), new Cost(600, 0,0 ), "recliner", "light brown",3);
	    Table theTable = new Table(new Dimensions(8, 9, 10), new Cost(300, 200, 0), "sqaure", "brown");
	    Wall theWall = new Wall(new Dimensions(20,20, 4), new Cost(600, 20,0), "offwhite", 5);
	    Windows theWindows = new Windows(new Dimensions(10, 8, 5), new Cost(300, 0, 0), true, true, 2, 2);

	    Room myRoom = new Room(theChair, theDoor, theFloor, theRoof, theSofa, theTable, theWall, theWindows);

        myRoom.secureTheRoom();

    }
}
