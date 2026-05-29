package com.pluralsight.models;

import java.util.ArrayList;

public class SuperBurrito extends Taco {

    public SuperBurrito() {
        super(ShellType.FLOUR, TacoSize.BURRITO,
                "Carnitas", 0,
                "Cheddar", 0,
                new ArrayList<>(), "",
                new ArrayList<>(), true);
        getToppings().add(new Toppings("Pico de Gallo"));
        getToppings().add(new Toppings("Lettuce"));
        getToppings().add(new Toppings("Tomatoes"));
    }
}
