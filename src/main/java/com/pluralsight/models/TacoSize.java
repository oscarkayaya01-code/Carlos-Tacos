package com.pluralsight.models;

public enum TacoSize {
    SINGLE("Single Taco", 3.50),
    THREE_TACO("3-Taco Plate", 9.00),
    BURRITO("Burrito", 8.50);

    private final String displayName;
    private final double basePrice;

    TacoSize(String displayName, double basePrice) {
        this.displayName = displayName;
        this.basePrice = basePrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
