package com.company;

// LinkedHashMap
// LinkedHashSet

// these collections have an ordering
// non-chaotic

// TreeMap
    // non-chaotic ordering
    // items are compared to each other to perform sorting (performance cost)
    // must determine where in the tree to insert new items

// there is a performance cost in using unsorted collections vs sorted ones

// unmodifiable collections
    // immutable - client code can not modify them
    // the returned view collection can't be changed ---> individual items can be modified!!!

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        // duplicate item
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        // unmodifiable collections provide a view in to the underlying collection
        // ordering should still be preserved in this view when using LinkedHashMap
        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        sellItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);
        System.out.println(stockList);

        System.out.println("\n============\n");
        // we can't add items to an unmodifiable map
//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp); // throws UnsupportedOperationException

        System.out.println("\n============\n");
        // individual items in unmodifiable views can be changed
        stockList.Items().get("car").adjustStock(2000);
        System.out.println(stockList);

        // collection and items can not be modified
        // actual items are not returned
        for (Map.Entry<String, Double> prices : stockList.PriceList().entrySet()) {
            System.out.println(prices.getKey() + " costs " + prices.getValue());
        }
    }

    public static int sellItem(Basket basket, String itemName, int quantity) {
        // retrieve item from stock list
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }
        if (stockList.sellStock(itemName, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0; // insufficient stock
    }
}
