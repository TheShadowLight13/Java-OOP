package WildFarm.Animal;

import WildFarm.Food.Food;

public class Mouse extends Mammal{

    public Mouse(String animalName, String animalType,
                 double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getName().equals("Vegetable")) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
            System.out.println("A cheese was just eaten!");
        }else {
           throw new IllegalArgumentException("Mouses are not eating that type of food!");
        }
    }
}
