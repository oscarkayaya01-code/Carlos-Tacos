package com.pluralsight.models;

import java.util.ArrayList;

public class StreetTaco extends Taco {

    public StreetTaco() {
        super(ShellType.CORN, TacoSize.THREE_TACO,
                "Carne Asada", 0,
                "", 0,
                new ArrayList<>(), "Salsa Verde",
                new ArrayList<>(), false);
        getToppings().add(new Toppings("Onions"));
        getToppings().add(new Toppings("Cilantro"));
        getSides().add(new Sides("Lime Wedges"));
    }
}
