package WildFarm.Food;

public abstract class Food {

    private String name;
    private int quantity;

    public Food(String name ,int quantity) {
        this.setName(name);
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
