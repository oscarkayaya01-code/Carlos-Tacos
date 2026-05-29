package com.pluralsight.models;

public class Checkout {

    public static boolean isValidOrder(Order order) {
        return !order.getTaco().isEmpty()
                || !order.getChipsAndSalsas().isEmpty()
                || !order.getDrinks().isEmpty();
    }
}
