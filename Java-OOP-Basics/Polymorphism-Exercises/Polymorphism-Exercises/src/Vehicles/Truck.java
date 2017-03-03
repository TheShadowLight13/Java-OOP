package Vehicles;

public class Truck extends Vehicle{

    private static final double TRUCK_FUEL_CONSUMPTION_INCREASED = 1.6;
    private static final double RECEIVED_FUEL_PERCENT = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.setFuelConsumption(this.getFuelConsumption() + TRUCK_FUEL_CONSUMPTION_INCREASED);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters * RECEIVED_FUEL_PERCENT);
    }
}
