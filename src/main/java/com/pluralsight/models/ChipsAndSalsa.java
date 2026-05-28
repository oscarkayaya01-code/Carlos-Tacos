package com.pluralsight.models;

public class ChipsAndSalsa {

    private final double PRICE = 1.50;
    private String salsa;

    public ChipsAndSalsa(String salsa) {
        this.salsa = salsa;
    }

    public double getPrice() {
        return PRICE;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    @Override
    public String toString() {
        return String.format("Chips & Salsa (%s) — $%.2f", salsa, PRICE);
    }
}
