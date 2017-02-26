package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Get name of pizza and number of toppings
        String[] tokens = reader.readLine().split("\\s+");

        String command = tokens[0];
        if (!command.toUpperCase().equals("PIZZA")) {
            executeAlternativeCommands(tokens, reader);
            return;
        }

        String pizzaName = tokens[1];
        int numberOfToppings = Integer.valueOf(tokens[2]);

        Pizza pizza;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        }catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            return;
        }

         // Get dough data
        tokens = reader.readLine().split("\\s+");
        String flourType = tokens[1];
        String bakingTechnique = tokens[2];
        double doughWeight = Double.valueOf(tokens[3]);

        Dough dough;
        try {
            dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);
        }catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            return;
        }

        String input = reader.readLine();
        while (!input.equals("END")) {

            // Get topping data
            tokens = input.split("\\s+");
            String toppingType = tokens[1];
            double toppingWeight = Double.valueOf(tokens[2]);

            Topping topping;
            try {
               topping = new Topping(toppingType, toppingWeight);
               pizza.addTopping(topping);
            }catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
                return;
            }

            input = reader.readLine();
        }

        System.out.println(pizza);
    }

    private static void executeAlternativeCommands(String[] tokens, BufferedReader reader) throws IOException {

        String command = tokens[0];
        while (!command.equals("END")) {

            switch (command.toUpperCase()) {
                case "DOUGH":
                    String flourType = tokens[1];
                    String bakingTechnique = tokens[2];
                    double doughWeight = Double.valueOf(tokens[3]);
                    try {
                        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
                        System.out.printf("%.2f%n", dough.getCalories());
                    }catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case "TOPPING":
                    String toppingType = tokens[1];
                    double toppingWeight = Double.valueOf(tokens[2]);
                    try {
                        Topping topping = new Topping(toppingType, toppingWeight);
                        System.out.printf("%.2f%n", topping.getCalories());
                    }catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
            }

            tokens = reader.readLine().split("\\s+");
            command = tokens[0];
        }
    }
}
