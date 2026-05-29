package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);
    private final ReceiptWriter receiptWriter = new ReceiptWriter();

    // ------------------------------------------------------------------ //
    //  HOME SCREEN                                                         //
    // ------------------------------------------------------------------ //

    public void display() {
        boolean running = true;
        while (running) {
            System.out.println("\n================================");
            System.out.println("    Welcome to Carlos' Tacos    ");
            System.out.println("================================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    displayOrderScreen(new Order());
                    break;
                case "0":
                    System.out.println("Goodbye! Come back soon!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // ------------------------------------------------------------------ //
    //  ORDER SCREEN                                                        //
    // ------------------------------------------------------------------ //

    private void displayOrderScreen(Order order) {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\n================================");
            System.out.println("          ORDER SCREEN          ");
            System.out.println("================================");
            printCurrentOrder(order);
            System.out.println("1) Add Taco");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips & Salsa");
            System.out.println("4) Checkout");
            System.out.println("5) Add Signature Taco (Bonus)");
            System.out.println("0) Cancel Order");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addTaco(order);
                    break;
                case "2":
                    addDrink(order);
                    break;
                case "3":
                    addChipsAndSalsa(order);
                    break;
                case "4":
                    if (checkout(order)) ordering = false;
                    break;
                case "5":
                    addSignatureTaco(order);
                    break;
                case "0":
                    System.out.println("Order cancelled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void printCurrentOrder(Order order) {
        ArrayList<Taco> tacos = order.getTaco();
        ArrayList<Drink> drinks = order.getDrinks();
        ArrayList<ChipsAndSalsa> chips = order.getChipsAndSalsas();

        if (tacos.isEmpty() && drinks.isEmpty() && chips.isEmpty()) {
            System.out.println("[Order is empty]\n");
            return;
        }

        System.out.println("--- Current Order (newest first) ---");
        for (int i = tacos.size() - 1; i >= 0; i--)
            System.out.println("  " + tacos.get(i));
        for (int i = chips.size() - 1; i >= 0; i--)
            System.out.println("  " + chips.get(i));
        for (int i = drinks.size() - 1; i >= 0; i--)
            System.out.println("  " + drinks.get(i));
        System.out.printf("  Running total: $%.2f%n", order.getPrice());
        System.out.println("------------------------------------\n");
    }

    // ------------------------------------------------------------------ //
    //  ADD TACO                                                            //
    // ------------------------------------------------------------------ //

    private void addTaco(Order order) {
        System.out.println("\n===== ADD TACO =====");

        ShellType shell = selectShell();
        TacoSize size   = selectSize();

        String meat = selectMeat(size);
        int extraMeatCount = 0;
        if (!meat.isEmpty()) {
            extraMeatCount = promptInt(
                    "How many extra servings of " + meat + "? (+$"
                            + String.format("%.2f", size.getExtraMeatPrice()) + " each, 0 = none): ", 0);
        }

        String cheese = selectCheese(size);
        int extraCheeseCount = 0;
        if (!cheese.isEmpty()) {
            extraCheeseCount = promptInt(
                    "How many extra servings of " + cheese + "? (+$"
                            + String.format("%.2f", size.getExtraCheesePrice()) + " each, 0 = none): ", 0);
        }

        ArrayList<Toppings> toppings = selectToppings();
        String sauce                 = selectSauce();
        ArrayList<Sides> sides       = selectSides();

        System.out.print("Covered in salsa & queso? (y/n): ");
        boolean covered = scanner.nextLine().trim().equalsIgnoreCase("y");

        Taco taco = new Taco(shell, size, meat, extraMeatCount,
                cheese, extraCheeseCount, toppings, sauce, sides, covered);
        order.getTaco().add(taco);
        System.out.println("\nAdded: " + taco);
    }

    // ------------------------------------------------------------------ //
    //  ADD SIGNATURE TACO (BONUS)                                         //
    // ------------------------------------------------------------------ //

    private void addSignatureTaco(Order order) {
        System.out.println("\n===== SIGNATURE TACOS =====");
        System.out.println("1) Street Taco     - 3-Taco, Corn, Carne Asada, Onions, Cilantro, Salsa Verde");
        System.out.println("2) Super Burrito   - Burrito, Flour, Carnitas, Cheddar, Pico/Lettuce/Tomatoes, Covered");
        System.out.println("0) Back");
        System.out.print("Choose: ");

        Taco sig;
        switch (scanner.nextLine().trim()) {
            case "1": sig = new StreetTaco(); break;
            case "2": sig = new SuperBurrito(); break;
            default: System.out.println("Cancelled."); return;
        }

        System.out.println("Preview: " + sig);
        System.out.println("1) Add as-is");
        System.out.println("2) Customize first");
        System.out.println("0) Cancel");
        System.out.print("Choose: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("0")) return;
        if (choice.equals("2")) sig = customizeTaco(sig);

        order.getTaco().add(sig);
        System.out.println("\nAdded: " + sig);
    }

    private Taco customizeTaco(Taco taco) {
        boolean customizing = true;
        while (customizing) {
            System.out.println("\nCurrent: " + taco);
            System.out.println("1) Change shell");
            System.out.println("2) Change meat");
            System.out.println("3) Change cheese");
            System.out.println("4) Change toppings");
            System.out.println("5) Change sauce");
            System.out.println("6) Toggle covered (currently: " + taco.isCovered() + ")");
            System.out.println("0) Done");
            System.out.print("Choose: ");

            switch (scanner.nextLine().trim()) {
                case "1": taco.setShell(selectShell()); break;
                case "2": taco.setMeat(selectMeat(taco.getSize())); break;
                case "3": taco.setCheese(selectCheese(taco.getSize())); break;
                case "4": taco.setToppings(selectToppings()); break;
                case "5": taco.setSauce(selectSauce()); break;
                case "6":
                    taco.setCovered(!taco.isCovered());
                    System.out.println("Covered set to: " + taco.isCovered());
                    break;
                case "0": customizing = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
        return taco;
    }

    // ------------------------------------------------------------------ //
    //  ADD DRINK                                                           //
    // ------------------------------------------------------------------ //

    private void addDrink(Order order) {
        System.out.println("\n===== ADD DRINK =====");
        System.out.println("Select size:");
        System.out.println("1) Small  - $2.00");
        System.out.println("2) Medium - $2.50");
        System.out.println("3) Large  - $3.00");
        System.out.print("Choose: ");
        DrinkSize size;
        switch (scanner.nextLine().trim()) {
            case "2": size = DrinkSize.MEDIUM; break;
            case "3": size = DrinkSize.LARGE;  break;
            default:  size = DrinkSize.SMALL;  break;
        }

        String[] flavors = {"", "Coke", "Diet Coke", "Sprite", "Orange Fanta", "Water", "Lemonade"};
        System.out.println("\nSelect flavor:");
        for (int i = 1; i < flavors.length; i++) System.out.println(i + ") " + flavors[i]);
        System.out.print("Choose: ");
        String flavor;
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim());
            flavor = (idx >= 1 && idx < flavors.length) ? flavors[idx] : "Coke";
        } catch (NumberFormatException e) {
            flavor = "Coke";
        }

        Drink drink = new Drink(size, flavor);
        order.getDrinks().add(drink);
        System.out.println("Added: " + drink);
    }

    // ------------------------------------------------------------------ //
    //  ADD CHIPS & SALSA                                                   //
    // ------------------------------------------------------------------ //

    private void addChipsAndSalsa(Order order) {
        System.out.println("\n===== ADD CHIPS & SALSA - $1.50 =====");
        String[] salsas = {"", "Salsa Verde", "Salsa Roja", "Chipotle", "Habanero", "Mild", "Extra Hot"};
        System.out.println("Select salsa type:");
        for (int i = 1; i < salsas.length; i++) System.out.println(i + ") " + salsas[i]);
        System.out.print("Choose: ");
        String salsa;
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim());
            salsa = (idx >= 1 && idx < salsas.length) ? salsas[idx] : "Salsa Verde";
        } catch (NumberFormatException e) {
            salsa = "Salsa Verde";
        }

        ChipsAndSalsa chips = new ChipsAndSalsa(salsa);
        order.getChipsAndSalsas().add(chips);
        System.out.println("Added: " + chips);
    }

    // ------------------------------------------------------------------ //
    //  CHECKOUT                                                            //
    // ------------------------------------------------------------------ //

    private boolean checkout(Order order) {
        if (!Checkout.isValidOrder(order)) {
            System.out.println("Your order is empty! Please add at least one item.");
            return false;
        }

        System.out.println("\n================================");
        System.out.println("            CHECKOUT            ");
        System.out.println("================================");
        System.out.println(order);
        System.out.println("\n1) Confirm - place order");
        System.out.println("0) Cancel  - delete order");
        System.out.print("Choose: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            String path = receiptWriter.writeReceipt(order);
            System.out.println("\nOrder confirmed! Receipt saved to: " + path);
        } else {
            System.out.println("Order cancelled.");
        }
        return true;
    }

    // ------------------------------------------------------------------ //
    //  SHARED SELECTION HELPERS                                            //
    // ------------------------------------------------------------------ //

    private ShellType selectShell() {
        System.out.println("Select shell:");
        System.out.println("1) Corn");
        System.out.println("2) Flour");
        System.out.println("3) Hard Shell");
        System.out.println("4) Bowl");
        System.out.print("Choose: ");
        switch (scanner.nextLine().trim()) {
            case "2": return ShellType.FLOUR;
            case "3": return ShellType.HARD_SHELL;
            case "4": return ShellType.BOWL;
            default:  return ShellType.CORN;
        }
    }

    private TacoSize selectSize() {
        System.out.println("Select taco size:");
        System.out.println("1) Single Taco  - $3.50");
        System.out.println("2) 3-Taco Plate - $9.00");
        System.out.println("3) Burrito      - $8.50");
        System.out.print("Choose: ");
        switch (scanner.nextLine().trim()) {
            case "2": return TacoSize.THREE_TACO;
            case "3": return TacoSize.BURRITO;
            default:  return TacoSize.SINGLE;
        }
    }

    private String selectMeat(TacoSize size) {
        String[] meats = {"", "Carne Asada", "Al Pastor", "Carnitas", "Pollo", "Chorizo", "Pescado"};
        System.out.printf("Select meat (premium - +$%.2f):%n", size.getMeatPrice());
        for (int i = 1; i < meats.length; i++) System.out.println(i + ") " + meats[i]);
        System.out.println("0) No Meat");
        System.out.print("Choose: ");
        String choice = scanner.nextLine().trim();
        if (choice.equals("0")) return "";
        try {
            int idx = Integer.parseInt(choice);
            return (idx >= 1 && idx < meats.length) ? meats[idx] : "";
        } catch (NumberFormatException e) { return ""; }
    }

    private String selectCheese(TacoSize size) {
        String[] cheeses = {"", "Queso Fresco", "Oaxaca", "Cotija", "Cheddar"};
        System.out.printf("Select cheese (premium - +$%.2f):%n", size.getCheesePrice());
        for (int i = 1; i < cheeses.length; i++) System.out.println(i + ") " + cheeses[i]);
        System.out.println("0) No Cheese");
        System.out.print("Choose: ");
        String choice = scanner.nextLine().trim();
        if (choice.equals("0")) return "";
        try {
            int idx = Integer.parseInt(choice);
            return (idx >= 1 && idx < cheeses.length) ? cheeses[idx] : "";
        } catch (NumberFormatException e) { return ""; }
    }

    private ArrayList<Toppings> selectToppings() {
        String[] names = {"Lettuce", "Cilantro", "Onions", "Tomatoes",
                "Jalapeños", "Radishes", "Pico de Gallo", "Guacamole", "Corn"};
        ArrayList<Toppings> toppings = new ArrayList<>();
        System.out.println("Select regular toppings (included):");
        for (int i = 0; i < names.length; i++) System.out.println((i + 1) + ") " + names[i]);
        System.out.println("0) Done");

        while (true) {
            System.out.print("Add topping (0 to finish): ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) break;
            try {
                int idx = Integer.parseInt(choice);
                if (idx >= 1 && idx <= names.length) {
                    toppings.add(new Toppings(names[idx - 1]));
                    System.out.println(names[idx - 1] + " added.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
            }
        }
        return toppings;
    }

    private String selectSauce() {
        String[] sauces = {"", "Salsa Verde", "Salsa Roja", "Chipotle", "Habanero", "Mild", "Extra Hot"};
        System.out.println("Select sauce (included):");
        for (int i = 1; i < sauces.length; i++) System.out.println(i + ") " + sauces[i]);
        System.out.println("0) No Sauce");
        System.out.print("Choose: ");
        String choice = scanner.nextLine().trim();
        if (choice.equals("0")) return "";
        try {
            int idx = Integer.parseInt(choice);
            return (idx >= 1 && idx < sauces.length) ? sauces[idx] : "";
        } catch (NumberFormatException e) { return ""; }
    }

    private ArrayList<Sides> selectSides() {
        String[] options = {"Lime Wedges", "Crema"};
        ArrayList<Sides> sides = new ArrayList<>();
        System.out.println("Select sides (included):");
        for (int i = 0; i < options.length; i++) System.out.println((i + 1) + ") " + options[i]);
        System.out.println("0) Done");

        while (true) {
            System.out.print("Add side (0 to finish): ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) break;
            try {
                int idx = Integer.parseInt(choice);
                if (idx >= 1 && idx <= options.length) {
                    sides.add(new Sides(options[idx - 1]));
                    System.out.println(options[idx - 1] + " added.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
            }
        }
        return sides;
    }

    private int promptInt(String prompt, int defaultValue) {
        System.out.print(prompt);
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return Math.max(0, value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
