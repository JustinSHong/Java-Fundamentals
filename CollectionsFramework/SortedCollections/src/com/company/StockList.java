package com.company;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if we already have quantities of this item
            // get item if it exists or return the default
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if item has stock, then adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.availableQuantity());
            }

            list.put(item.getName(), item);
            return item.availableQuantity();
        }

        return 0; // no stock exists for the given item
    }

    public int sellStock(String itemName, int quantity) {
        StockItem inStock = list.getOrDefault(itemName, null);

        boolean reservedAmountIsAvailable = inStock.availableQuantity() - inStock.getReserved() >= 0;

        if (inStock != null && inStock.availableQuantity() >= quantity && quantity > 0 && reservedAmountIsAvailable) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0; // stock not adjusted
    }

    public StockItem get(String itemName) {
        return list.get(itemName);
    }

    // Collections framework provides wrappers around List, Map, Set
    // to create unmodifiable collections
    // another way to obtain immutability - this is "read-only"
    // this is faster since we don't have to make a copy
    // clients can not modify the returned collections
    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    // in this impl, the Collection and individual items can not be modified
    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString() {
        String s = "\n===Stock List=== \n";
        double totalCost = 0.0;

        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + " .There are " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";

            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
