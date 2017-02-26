package ShoppingSpree;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalStateException("Name cannot be empty");
        }

        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalStateException("Money cannot be negative");
        }

        this.price = price;
    }
}
