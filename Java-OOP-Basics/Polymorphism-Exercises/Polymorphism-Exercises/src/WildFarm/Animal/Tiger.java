package WildFarm.Animal;


import WildFarm.Food.Food;

public class Tiger extends Felime{

    public Tiger(String animalName, String animalType,
                 double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getName().equals("Meat")) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        }else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
