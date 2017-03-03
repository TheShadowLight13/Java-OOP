package Vehicles;

public class Car extends Vehicle{

    private static final double CAR_FUEL_CONSUMPTION_INCREASED = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.setFuelConsumption(this.getFuelConsumption() + CAR_FUEL_CONSUMPTION_INCREASED);
    }

    @Override
    public void refuel(double liters) {
        if (this.getFuelQuantity() + liters > this.getTankCapacity()) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }

        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }
}
