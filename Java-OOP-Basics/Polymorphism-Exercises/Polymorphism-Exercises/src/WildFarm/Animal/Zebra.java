package WildFarm.Animal;

import WildFarm.Food.Food;

public class Zebra extends Mammal{

    public Zebra(String animalName, String animalType,
                 double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food.getName().equals("Vegetable")) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        }else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }
}
