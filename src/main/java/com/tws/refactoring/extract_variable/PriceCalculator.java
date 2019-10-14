package com.tws.refactoring.extract_variable;

public class PriceCalculator {

    public double getPrice(int quantity, int itemPrice) {
        double price = getItemPrice(quantity, itemPrice);
        double discount = getDiscount(quantity, itemPrice);
        double shippingCost = getShippingCost(price);

        return price - discount + shippingCost;
    }

    private int getItemPrice(int quantity, int itemPrice) {
        return quantity * itemPrice;
    }

    private double getShippingCost(double itemPrice) {
        return Math.min(itemPrice * 0.1, 100.0);
    }

    private double getDiscount(int quantity, int itemPrice) {
        return Math.max(0, quantity - 500) * itemPrice * 0.05;
    }


}
