package PizzaCalories;

public class Topping {

    private static final int baseCaloriesPerGram = 2;

    private String type;
    private double weight;
    private double calories;

    public Topping(String type, double weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getCalories() {
        calculateCalories();
        return calories;
    }

    public void setType(String type) {
        String normalizedType = type.toUpperCase();
        if (!normalizedType.equals("MEAT") && !normalizedType.equals("VEGGIES")
                && !normalizedType.equals("CHEESE") && !normalizedType.equals("SAUCE")) {
            throw new IllegalStateException("Cannot place " + type + " on top of your pizza.");
        }

        this.type = type;
    }

    public void setWeight(double weight) {
        if (!(weight >= 1 && weight <= 50)) {
            throw new IllegalStateException(this.getType() + " weight should be in the range [1..50].");
        }

        this.weight = weight;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    private void calculateCalories() {

        double typeModifier = 0;
        String normalizedType = this.getType().toUpperCase();

        switch (normalizedType) {
            case "MEAT": typeModifier = 1.2; break;
            case "VEGGIES": typeModifier = 0.8; break;
            case "CHEESE": typeModifier = 1.1; break;
            case "SAUCE": typeModifier = 0.9; break;
        }

        double calories = this.getWeight() * baseCaloriesPerGram * typeModifier;
        this.setCalories(calories);
    }
}
