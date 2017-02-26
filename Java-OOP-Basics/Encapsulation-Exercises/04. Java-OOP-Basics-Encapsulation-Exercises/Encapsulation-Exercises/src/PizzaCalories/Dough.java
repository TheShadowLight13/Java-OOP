package PizzaCalories;

public class Dough {

    private static final int baseCaloriesPerGram = 2;

    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double calories;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public void setFlourType(String flourType) {
        String normalizedFlourType = flourType.toUpperCase();
        if (!normalizedFlourType.equals("WHITE") && !normalizedFlourType.equals("WHOLEGRAIN")) {
            throw new IllegalStateException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        String normalizedBakingTechnique = bakingTechnique.toUpperCase();
        if (!normalizedBakingTechnique.equals("CRISPY") && !normalizedBakingTechnique.equals("CHEWY") &&
                !normalizedBakingTechnique.equals("HOMEMADE")) {
            throw new IllegalStateException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {
        if (!(weight >= 1 && weight <= 200)) {
            throw new IllegalStateException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    private String getFlourType() {
        return this.flourType;
    }

    private String getBakingTechnique() {
        return this.bakingTechnique;
    }

    private double getWeight() {
        return this.weight;
    }

    private void calculateCalories() {

        double flourTypeModifier = 0;
        double bakingTechniqueModifier = 0;

        String normalizedFlourType = this.getFlourType().toUpperCase();
        String normalizedBakingTechnique = this.getBakingTechnique().toUpperCase();

        switch (normalizedFlourType) {
            case "WHITE": flourTypeModifier = 1.5; break;
            case "WHOLEGRAIN": flourTypeModifier = 1.0; break;
        }
        switch (normalizedBakingTechnique) {
            case "CRISPY": bakingTechniqueModifier = 0.9; break;
            case "CHEWY": bakingTechniqueModifier = 1.1; break;
            case "HOMEMADE": bakingTechniqueModifier = 1.0; break;
        }

        double calories = this.getWeight() * baseCaloriesPerGram * flourTypeModifier * bakingTechniqueModifier;
        this.setCalories(calories);
    }

    public double getCalories() {
        this.calculateCalories();
        return this.calories;
    }
}
