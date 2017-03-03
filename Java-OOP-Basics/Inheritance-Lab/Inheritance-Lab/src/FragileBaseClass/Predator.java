package FragileBaseClass;

public class Predator extends Animal{

    private int health;

    public void feed(Food food) {
        super.eat(food);
        this.health++;
    }

    public void feedAll(Food[] foods) {
        for (Food food : foods) {
            this.feed(food);
        }
    }
}
