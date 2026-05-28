package com.pluralsight;

public class ChipsAndSalsa {

    private final double price = 1.50;
    private String salsa;

    public ChipsAndSalsa(String salsa) {
        this.salsa = salsa;
    }

    public double getPrice() {
        return price;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
}
