package com.pluralsight;

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
                    order.showMenu();
                    break;
                case "0":
               return;
            }
        }
    }
}
