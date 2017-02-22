package Problem8;

public class Pokemon {

    private static final int PENALTY_POINTS = 10;

    private String name;
    private String element;
    private double health;

    public Pokemon(String name, String element, double health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public void removeHealth() {
        this.health -= PENALTY_POINTS;
    }

    public String getName() {
        return this.name;
    }

    public String getElement() {
        return this.element;
    }

    public double getHealth() {
        return this.health;
    }
}
