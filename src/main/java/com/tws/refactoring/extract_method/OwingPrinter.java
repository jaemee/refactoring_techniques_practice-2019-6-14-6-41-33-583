package com.tws.refactoring.extract_method;

import java.util.List;

public class OwingPrinter {
    private static final String BANNER_HEADER_FOOTER = "*****************************";

    void printOwing(String name, List<Order> orders) {

        System.out.println(BANNER_HEADER_FOOTER);
        System.out.println("****** Customer totals ******");
        System.out.println(BANNER_HEADER_FOOTER);

        Double totalPrice = getTotalPrice(orders);

        System.out.println("name: " + name);
        System.out.println("amount: " + totalPrice);
    }

    private Double getTotalPrice(List<Order> orders) {
        return orders.stream()
                .map(Order::getAmount)
                .reduce(Double::sum)
                .orElse(0.0);
    }
}

class Order {
    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
