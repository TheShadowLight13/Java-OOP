package WildFarm.Animal;

import WildFarm.Food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime{

    private String breed;

    public Cat(String animalName, String animalType, double animalWeight,
               String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(), this.getAnimalName(), this.getBreed(),
                df.format(this.getAnimalWeight()), this.getLivingRegion() ,this.getFoodEaten());
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }
}
