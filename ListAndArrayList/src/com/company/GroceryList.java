package com.company;

import java.util.ArrayList;

// ArrayList methods
    // get(position) - retrieve an item in the list at the given position
    // add(item) - add an item to the ArrayList
    // size() - returns the size of the ArrayList
    // set(position, newItem) - modifies an existing item at the given position
    // remove(position) - removes an item at the given position
    // indexOf(item) - returns the position of an item



public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>(); // init a constructor

    public void addGroceryItem(String item) {
        groceryList.add(item); // pushes an element to the arrayList
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your list"); // return length of arrayList

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i)); // retrieve an item in the arrayList
        }
    }

    // overloaded method
    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem); // modify an existing element
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    // overloaded method
    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
        String item = groceryList.get(position); // removes an existing element
        groceryList.remove(position);
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if (position >= 0) {
            return true;
        }

        return false;
    }

    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }

//    public String findItem(String searchItem) {
//        boolean exists = groceryList.contains(searchItem); // look for a specific item
//        int position = groceryList.indexOf(searchItem); // returns position of an item
//        if (position >= 0) {
//            return groceryList.get(position);
//        }
//
//        return null;
//    }
}
