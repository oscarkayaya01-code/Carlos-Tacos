package com.pluralsight.models;

import java.util.ArrayList;

public class Order {

    private double price;
    private ArrayList<ChipsAndSalsa> chipsAndSalsas = new ArrayList<ChipsAndSalsa>();
    private ArrayList<Drink> drinks = new ArrayList<Drink>();
    private ArrayList<Taco> taco = new ArrayList<Taco>();

    public Order(double price, ArrayList<ChipsAndSalsa> chipsAndSalsas, ArrayList<Drink> drinks, ArrayList<Taco> taco) {
        this.price = price;
        this.chipsAndSalsas = chipsAndSalsas;
        this.drinks = drinks;
        this.taco = taco;
    }

    public Order(){};

    public double getPrice() {
        double total = 0.00;
        for(Taco t: this.getTaco()){
            total += t.getSize().getBasePrice();
        };
        for(ChipsAndSalsa c: this.getChipsAndSalsas()){

           total += c.getPrice();
        };
        for(Drink d: this.getDrinks()){

           total += d.getPrice();
        };

        return total;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<ChipsAndSalsa> getChipsAndSalsas() {
        return chipsAndSalsas;
    }

    public void setChipsAndSalsas(ArrayList<ChipsAndSalsa> chipsAndSalsas) {
        this.chipsAndSalsas = chipsAndSalsas;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<Taco> getTaco() {
        return taco;
    }

    public void setTaco(ArrayList<Taco> taco) {
        this.taco = taco;
    }

    @Override
    public String toString(){
        String orderString = "";
        for(Taco t: this.getTaco()){

            orderString = orderString + t.toString() + "\n";
        };
        for(ChipsAndSalsa c: this.getChipsAndSalsas()){

            orderString = orderString + c.toString()+ "\n";
        };
        for(Drink d: this.getDrinks()){

            orderString = orderString + d.toString()+ "\n";
        };
        orderString = orderString +  "Total    " + String.format("$%.2f",getPrice());
        return orderString;
    };
}
