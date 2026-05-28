package com.pluralsight;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Order order = new Order();


        while(true) {
        System.out.println("homeScreen");
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
    public static void showMenu(Order order){

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
        String flavorchoice = scanner.nextLine();



        Drink drink = new Drink(sizeEnum, flavorchoice);
        ArrayList<Drink> current = order.getDrinks();
        current.add(drink);
        order.setDrinks(current);
    }

    public static void chooseTaco(Order order){
        //public Taco(String shell, int size, String meat, String cheese, ArrayList<String> toppings, String sauce, ArrayList<String> sides)
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. shell1");
        System.out.println("2. shell2");
        System.out.println("3. shell3");
        System.out.println("4. shell4");
        String shellchoice = scanner.nextLine();

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

        System.out.println("1. meat1");
        System.out.println("2. meat2");
        System.out.println("3. meat3");
        System.out.println("4. meat4");
        System.out.println("5. meat5");
        System.out.println("6. meat6");
        String meatchoice = scanner.nextLine();

        System.out.println("1. cheese1");
        System.out.println("2. cheese2");
        System.out.println("3. cheese3");
        System.out.println("4. cheese4");
        String cheesechoice = scanner.nextLine();

        System.out.println("1. sauce1");
        System.out.println("2. sauce2");
        System.out.println("3. sauce3");
        System.out.println("4. sauce4");
        System.out.println("5. sauce5");
        System.out.println("6. sauce6");
        String saucechoice = scanner.nextLine();


        // ArrayList toppings choices
        // Arraylist sides choices


        //public Taco(String shell, int size, String meat, String cheese, ArrayList<String> toppings, String sauce, ArrayList<String> sides)
        ArrayList<String> temp = new ArrayList<>();
        Taco taco = new Taco(shellchoice, sizeEnum, meatchoice, cheesechoice,temp,saucechoice, temp );
        ArrayList<Taco> current = order.getTaco();
        current.add(taco);
        order.setTaco(current);


    }
}





