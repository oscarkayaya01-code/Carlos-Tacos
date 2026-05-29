package com.pluralsight.models;

import java.util.ArrayList;

public class Burrito extends Taco {

    public Burrito(ShellType shell, String meat, int extraMeatCount,
                   String cheese, int extraCheeseCount, ArrayList<Toppings> toppings,
                   String sauce, ArrayList<Sides> sides, boolean covered) {
        super(shell, TacoSize.BURRITO, meat, extraMeatCount,
                cheese, extraCheeseCount, toppings, sauce, sides, covered);
    }
}
