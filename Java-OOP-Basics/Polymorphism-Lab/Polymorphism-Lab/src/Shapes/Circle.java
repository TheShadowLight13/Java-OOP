package Shapes;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * this.getRadius());
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * this.getRadius() * this.getRadius());
    }
}
