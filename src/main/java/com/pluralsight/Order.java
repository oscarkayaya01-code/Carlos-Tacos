package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

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
        return price;
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
}
