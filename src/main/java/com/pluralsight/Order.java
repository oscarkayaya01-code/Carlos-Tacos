package com.pluralsight;

import java.util.Scanner;

public class Order {
    public void showMenu(){

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
                    System.out.println("Add Taco");
                    break;
                case "2":
                    System.out.println("Add Drink");
                    break;
                case "3":
                    System.out.println("Add Chips & Salsa");
                    break;
                case "4":
                    System.out.println("Checkout");
                    break;
                case "0":
                    return;
            }
        }
    };
}
