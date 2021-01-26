package com.company;

    /*

    Modify the program so that adding items to the shopping basket doesn't
    actually reduce the stock count but, instead, reserves the requested
    number of items.

    You will need to add a "reserved" field to the StockItem class to store the
    number of items reserved.

    Items can continue to be added to the basket, but it should not be possible to
    reserve more than the available stock of any item. An item's available stock
    is the stock count less the reserved amount.

    The stock count for each item is reduced when a basket is checked out, at which
    point all reserved items in the basket have their actual stock count reduced.

    Once checkout is complete, the contents of the basket are cleared.

    It should also be possible to "unreserve" items that were added to the basket
    by mistake.

    The program should prevent any attempt to unreserve more items than were
    reserved for a basket.

    Add code to Main that will unreserve items after they have been added to the basket,
    as well as unreserving items that have not been added to make sure that the code
    can cope with invalid requests like that.

    After checking out the baskets, display the full stock list and the contents of each
    basket that you created.

     */

public class MainChallenge {
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

        System.out.println("\n=====basket=====\n");

        Basket timsBasket = new Basket("Tim");
//        sellItem(timsBasket, "car", 1);
        addStockItemToBasket(timsBasket, "car", 1);
        removeFromBasket(timsBasket, "car", 1);
//        sellItem(timsBasket, "car", 1);
        addStockItemToBasket(timsBasket, "car", 1);
        removeFromBasket(timsBasket, "car", 1);

        System.out.println(timsBasket);

        System.out.println(stockList);
    }

    public static int addStockItemToBasket(Basket basket, String itemName, int quantity) {
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }
        basket.addToBasket(stockItem, quantity);
        return 1;
    }

    public static int sellItem(Basket basket, String itemName, int quantity) {
        // retrieve item from stock list
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }
        if (stockList.get(itemName).availableQuantity() - quantity >= 0) {
            basket.addToBasket(stockItem, quantity);
            stockList.sellStock(itemName, quantity);
            basket.clearBasket();
            return quantity;
        }
        System.out.println("could not sell item due to insufficient stock");
        return 0; // insufficient stock
    }

    public static int removeFromBasket(Basket basket, String itemName, int quantity) {
        // retrieve item from stock list
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }

        basket.removeFromBasket(stockItem, quantity);

        System.out.println("Removed " + stockItem + " from basket\n");
        return 1; // insufficient stock
    }
}
