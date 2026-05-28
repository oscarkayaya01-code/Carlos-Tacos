package com.pluralsight.models;

import java.util.ArrayList;

public class Taco {

    private String shell;
    private TacoSize size;
    private String meat;
    private String cheese;
    private ArrayList<String> toppings;
    private String sauce;
    private ArrayList<String> sides;


    public Taco(String shell, TacoSize size, String meat, String cheese, ArrayList<String> toppings, String sauce, ArrayList<String> sides) {
        this.shell = shell;
        this.size = size;
        this.meat = meat;
        this.cheese = cheese;
        this.toppings = toppings;
        this.sauce = sauce;
        this.sides = sides;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public TacoSize getSize() {
        return size;
    }

    public void setSize(TacoSize size) {
        this.size = size;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public ArrayList<String> getSides() {
        return sides;
    }

    public void setSides(ArrayList<String> sides) {
        this.sides = sides;
    }
}
