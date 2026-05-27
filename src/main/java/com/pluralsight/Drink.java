package com.pluralsight;

public class Drink {
    
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }
    
    public String toString(){
        return String.format("%s %s drink - $%.2f", size, flavor, getPrice());
    }

    public double getPrice() {
        return size.getPrice();
    }
}
