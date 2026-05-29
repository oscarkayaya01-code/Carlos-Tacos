package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Order order = new Order();


        while(true) {
            System.out.println("Welcome to Carlos Tacos");
        System.out.println("HomeScreen");
        System.out.println("1. New Order");
        System.out.println("0. Exit");


        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showMenu(order);
                    break;
                case "0":
               return;
            }
        }


    }
    public static void showMenu(Order order) {
        ReceiptWriter rw = new ReceiptWriter();

        while(true) {
            System.out.println("Order Screen");
            System.out.println("1. Add Taco");
            System.out.println("2. Add Drink");
            System.out.println("3. Add chips & Salsa");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");


            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    chooseTaco(order);
                    break;
                case "2":
                  chooseDrink(order);
                    break;
                case "3":
                    chooseSalsa(order);
                    break;
                case "4":
                    System.out.println("Checkout");
                    System.out.println(order.toString());
                    System.out.println(rw.writeReceipt(order));
                    break;
                case "0":
                    return;
            }
        }
    }

    public static void chooseSalsa(Order order){
        System.out.println("1. salsa verde");
        System.out.println("2.salsa roja");
        System.out.println("3. chipotle");
        System.out.println("4. habanero");
        System.out.println("5. mild");
        System.out.println("6. extra hot");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();



        ChipsAndSalsa cs = new ChipsAndSalsa(choice);
        ArrayList<ChipsAndSalsa> current = order.getChipsAndSalsas();
        current.add(cs);
        order.setChipsAndSalsas(current);
    }

    public static void chooseDrink(Order order){
        System.out.println("1. Small");
        System.out.println("2. Meduim");
        System.out.println("3. Large");
        Scanner scanner = new Scanner(System.in);
        String sizechoice = scanner.nextLine();
        DrinkSize sizeEnum = DrinkSize.SMALL;
        switch(sizechoice){

            case "1":
                break;
            case "2":
                sizeEnum = DrinkSize.MEDIUM;
                break;
            case "3":
                sizeEnum = DrinkSize.LARGE;
                break;
        }

        System.out.println("what flavor do you want");
        System.out.println("1. Flavor1");
        System.out.println("2. Flavor2");
        System.out.println("3. Flavor3");
        String flavorchoice = scanner.nextLine();


        Drink drink = new Drink(sizeEnum, flavorchoice);
        ArrayList<Drink> current = order.getDrinks();
        current.add(drink);
        order.setDrinks(current);
    }

    public static void chooseTaco(Order order){
        //public Taco(String shell, int size, String meat, String cheese, ArrayList<String> toppings, String sauce, ArrayList<String> sides)
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Corn");
        System.out.println("2. Flour");
        System.out.println("3. Hard Shell");
        System.out.println("4. Bowl");
        String shellchoice = scanner.nextLine();
        String shellname = "";

        switch(shellchoice){

            case "1":
                shellname = "Corn";
                break;
            case "2":
                shellname = "Flour";
                break;
            case "3":
                shellname = "Hard shell";
                break;
            case "4":
                shellname = "bowl";
                break;
        }

        System.out.println("1. Single");
        System.out.println("2. 3 tacos");
        System.out.println("3. burrito");

        String sizechoice = scanner.nextLine();
        TacoSize sizeEnum = TacoSize.SINGLE;
        switch(sizechoice){

            case "1":
                break;
            case "2":
                sizeEnum = TacoSize.THREE_TACO;
                break;
            case "3":
                sizeEnum = TacoSize.BURRITO;
                break;
        }

        System.out.println("1. Carne asada");
        System.out.println("2. Al pastor");
        System.out.println("3. Carnitas");
        System.out.println("4. Pollo");
        System.out.println("5. Chorizo");
        System.out.println("6. Pescado");
        String meatchoice = scanner.nextLine();
        String meatname = "";

        switch(meatchoice){

            case "1":
                meatname = "Carne asada";
                break;
            case "2":
                meatname = "Al pastor";
                break;
            case "3":
                meatname = "Carnitas";
                break;
            case "4":
                meatname = "Pollo";
                break;
            case "5":
                meatname = "Chorizo";
                break;
            case "6":
                meatname = "Pescado";
                break;

        }

        System.out.println("1. Queso Fresco");
        System.out.println("2. Oaxaca");
        System.out.println("3. Cotija");
        System.out.println("4. Cheddar");
        String cheesechoice = scanner.nextLine();

        System.out.println("1. Salsa verde");
        System.out.println("2. Salsa roja");
        System.out.println("3. Chipotle");
        System.out.println("4. habanero");
        System.out.println("5. mild");
        System.out.println("6. extra hot");
        String saucechoice = scanner.nextLine();


        // ArrayList toppings choices
        ArrayList<Toppings> toppings = new ArrayList<>();

        boolean toppingMenu = true;
        while (toppingMenu){

            System.out.println("What toppings would you like?");
            System.out.println("1. topping1");
            System.out.println("2. topping2");
            System.out.println("3. topping3");
            System.out.println("4. topping4");
            System.out.println("5. topping5");
            System.out.println("6. topping6");
            System.out.println("1. topping7");
            System.out.println("2. topping8");
            System.out.println("3. topping9");
            String toppingchoice = scanner.nextLine();

            toppings.add(new Toppings(toppingchoice));

            System.out.println("Would you like more toppings");
            System.out.println("1. Yes");
            System.out.println("2. No");
            String continuechoice = scanner.nextLine();

            switch(continuechoice){

                case "1":
                    break;
                case "2":
                    toppingMenu = false;
                    break;
            }
        }

        // Arraylist sides choices
        ArrayList<Sides> sides = new ArrayList<>();

        boolean sidesMenu = true;
        while (sidesMenu) {

            System.out.println("What sides would you like?");
            System.out.println("1. sides1");
            System.out.println("2. side2");

            String sideschoice = scanner.nextLine();

            sides.add(new Sides(sideschoice));

            System.out.println("Would you like more sides");
            System.out.println("1. Yes");
            System.out.println("2. No");
            String continuechoiceS = scanner.nextLine();

            switch(continuechoiceS){

                case "1":
                    break;
                case "2":
                    sidesMenu = false;
                    break;
            }
        }



        //public Taco(String shell, int size, String meat, String cheese, ArrayList<String> toppings, String sauce, ArrayList<String> sides)

        Taco taco = new Taco(shellname, sizeEnum, meatname, cheesechoice,toppings,saucechoice, sides );
        ArrayList<Taco> current = order.getTaco();
        current.add(taco);
        order.setTaco(current);


    }
}





