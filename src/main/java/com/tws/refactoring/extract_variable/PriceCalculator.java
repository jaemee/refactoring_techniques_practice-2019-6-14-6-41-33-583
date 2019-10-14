package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    public double getPrice(int quantity, int itemPrice) {
        double price = quantity * itemPrice;
        double discount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        double shipping_cost = Math.min(quantity * itemPrice * 0.1, 100.0);

        return price - discount + shipping_cost;
    }
}
