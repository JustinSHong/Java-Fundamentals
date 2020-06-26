package com.company;

public class Room {
    private Chair theChair;
    private Door theDoor;
    private Floor theFloor;
    private Roof theRoof;
    private Sofa theSofa;
    private Table theTable;
    private Wall theWall;
    private Windows theWindows;

    public Room(Chair theChair, Door theDoor, Floor theFloor, Roof theRoof, Sofa theSofa, Table theTable, Wall theWall, Windows theWindows) {
        this.theChair = theChair;
        this.theDoor = theDoor;
        this.theFloor = theFloor;
        this.theRoof = theRoof;
        this.theSofa = theSofa;
        this.theTable = theTable;
        this.theWall = theWall;
        this.theWindows = theWindows;
    }

    public void secureTheRoom() {
        theDoor.closeDoor();
        theWindows.closeWindow();
    }
}
