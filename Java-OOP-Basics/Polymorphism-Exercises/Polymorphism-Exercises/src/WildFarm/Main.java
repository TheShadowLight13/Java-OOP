package WildFarm;

import WildFarm.Animal.Cat;
import WildFarm.Animal.Mouse;
import WildFarm.Animal.Tiger;
import WildFarm.Animal.Zebra;
import WildFarm.Food.Food;
import WildFarm.Food.Meat;
import WildFarm.Food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!input.equals("End")) {

            String[] animalData = input.split("\\s+");
            String animalType = animalData[0];
            String animalName = animalData[1];
            double animalWeight = Double.valueOf(animalData[2]);
            String animalLivingRegion = animalData[3];
            String catBreed = null;

            if (animalData.length == 5) {
                catBreed = animalData[4];
            }

            String[] foodData = reader.readLine().split("\\s+");
            String foodType = foodData[0];
            int foodQuantity = Integer.valueOf(foodData[1]);

            Food food = null;

            switch (foodType) {
                case "Vegetable":
                    food = new Vegetable(foodType, foodQuantity);
                    break;
                case "Meat":
                    food = new Meat(foodType, foodQuantity);
                    break;
            }

            switch (animalType) {
                case "Cat":
                    Cat cat = new Cat(animalName, animalType,
                            animalWeight, animalLivingRegion, catBreed);
                    cat.makeSound();
                    cat.eat(food);
                    System.out.println(cat);
                    break;
                case "Mouse":
                    Mouse mouse = new Mouse(animalName, animalType,
                            animalWeight, animalLivingRegion);
                    mouse.makeSound();
                    try {
                        mouse.eat(food);
                    }catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }

                    System.out.println(mouse);
                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(animalName, animalType,
                            animalWeight, animalLivingRegion);
                    tiger.makeSound();
                    try {
                        tiger.eat(food);
                    }catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    System.out.println(tiger);
                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(animalName, animalType,
                            animalWeight, animalLivingRegion);
                    zebra.makeSound();
                    try {
                        zebra.eat(food);
                    }catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    System.out.println(zebra);
                    break;
            }

            input = reader.readLine();
        }
    }
}
