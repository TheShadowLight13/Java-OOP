package Problem6;

public class Car {

    private static final int TIRES_COUNT = 4;

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires = new Tire[TIRES_COUNT];

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Tire[] getTires() {
        return this.tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getModel() {
        return model;
    }
}
