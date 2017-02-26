package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private double toppingsNumber;
    private double totalCalories;

    public Pizza(String name, double toppingsNumber) {
        this.setName(name);
        this.setToppingsNumber(toppingsNumber);
        this.toppings = new ArrayList<>();
    }

    private void setToppingsNumber(double toppingsNumber) {
        if (!(toppingsNumber >= 0 && toppingsNumber <= 10)) {
            throw new IllegalStateException("Number of toppings should be in range [0..10].");
        }

        this.toppingsNumber = toppingsNumber;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0 || name.length() > 15) {
            throw new IllegalStateException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    private Dough getDough() {
        return this.dough;
    }

    public String getName() {
        return this.name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTotalCalories() {
        this.calculateTotalCalories();
        return this.totalCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getTotalCalories());
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    private void calculateTotalCalories() {
        double totalCalories = 0;

        totalCalories += this.getDough().getCalories();

        for (Topping topping : this.toppings) {
            totalCalories = totalCalories + topping.getCalories();
        }

        this.setTotalCalories(totalCalories);
    }
}
