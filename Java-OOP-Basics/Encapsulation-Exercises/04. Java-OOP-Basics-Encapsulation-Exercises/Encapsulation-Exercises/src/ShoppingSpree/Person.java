package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (this.money - product.getPrice() < 0) {
            throw new IllegalStateException(this.getName() + " can't afford " + product.getName());
        }

        this.money -= product.getPrice();
        this.bagOfProducts.add(product);
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalStateException("Name cannot be empty");
        }

        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalStateException("Money cannot be negative");
        }

        this.money = money;
    }
}
