package com.pluralsight.models;

import java.util.ArrayList;

public class Taco {

    private ShellType shell;
    private TacoSize size;
    private String meat;
    private int extraMeatCount;
    private String cheese;
    private int extraCheeseCount;
    private ArrayList<Toppings> toppings;
    private String sauce;
    private ArrayList<Sides> sides;
    private boolean covered;

    public Taco(ShellType shell, TacoSize size, String meat, int extraMeatCount,
                String cheese, int extraCheeseCount, ArrayList<Toppings> toppings,
                String sauce, ArrayList<Sides> sides, boolean covered) {
        this.shell = shell;
        this.size = size;
        this.meat = meat;
        this.extraMeatCount = extraMeatCount;
        this.cheese = cheese;
        this.extraCheeseCount = extraCheeseCount;
        this.toppings = toppings != null ? toppings : new ArrayList<>();
        this.sauce = sauce;
        this.sides = sides != null ? sides : new ArrayList<>();
        this.covered = covered;
    }

    public double getPrice() {
        double price = size.getBasePrice();
        if (meat != null && !meat.isEmpty()) {
            price += size.getMeatPrice();
            price += extraMeatCount * size.getExtraMeatPrice();
        }
        if (cheese != null && !cheese.isEmpty()) {
            price += size.getCheesePrice();
            price += extraCheeseCount * size.getExtraCheesePrice();
        }
        return price;
    }

    public ShellType getShell()                          { return shell; }
    public void setShell(ShellType shell)                { this.shell = shell; }
    public TacoSize getSize()                            { return size; }
    public void setSize(TacoSize size)                   { this.size = size; }
    public String getMeat()                              { return meat; }
    public void setMeat(String meat)                     { this.meat = meat; }
    public int getExtraMeatCount()                       { return extraMeatCount; }
    public void setExtraMeatCount(int extraMeatCount)    { this.extraMeatCount = extraMeatCount; }
    public String getCheese()                            { return cheese; }
    public void setCheese(String cheese)                 { this.cheese = cheese; }
    public int getExtraCheeseCount()                     { return extraCheeseCount; }
    public void setExtraCheeseCount(int c)               { this.extraCheeseCount = c; }
    public ArrayList<Toppings> getToppings()             { return toppings; }
    public void setToppings(ArrayList<Toppings> toppings){ this.toppings = toppings; }
    public String getSauce()                             { return sauce; }
    public void setSauce(String sauce)                   { this.sauce = sauce; }
    public ArrayList<Sides> getSides()                   { return sides; }
    public void setSides(ArrayList<Sides> sides)         { this.sides = sides; }
    public boolean isCovered()                           { return covered; }
    public void setCovered(boolean covered)              { this.covered = covered; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size.getDisplayName())
                .append(" (").append(shell.getDisplayName()).append(")");

        if (meat != null && !meat.isEmpty()) {
            sb.append(", ").append(meat);
            if (extraMeatCount > 0) sb.append(" +").append(extraMeatCount).append(" extra");
        }
        if (cheese != null && !cheese.isEmpty()) {
            sb.append(", ").append(cheese);
            if (extraCheeseCount > 0) sb.append(" +").append(extraCheeseCount).append(" extra");
        }
        if (!toppings.isEmpty()) {
            sb.append(", ");
            for (int i = 0; i < toppings.size(); i++) {
                if (i > 0) sb.append("/");
                sb.append(toppings.get(i).getTopping());
            }
        }
        if (sauce != null && !sauce.isEmpty()) sb.append(", ").append(sauce);
        if (!sides.isEmpty()) {
            sb.append(", ");
            for (int i = 0; i < sides.size(); i++) {
                if (i > 0) sb.append("/");
                sb.append(sides.get(i).getSides());
            }
        }
        if (covered) sb.append(", Covered");
        sb.append(String.format(" - $%.2f", getPrice()));
        return sb.toString();
    }
}
