package Vehicles;

public class Bus extends Vehicle{

    private static final double FUEL_CONSUMPTION_INCREASED_WITH_PEOPLE = 1.4;
    private boolean isBusEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);

        if (!this.isBusEmpty()) {
            this.setFuelConsumption(this.getFuelConsumption() + FUEL_CONSUMPTION_INCREASED_WITH_PEOPLE);
        }
    }

    public void setIsBusEmpty(boolean isBusEmpty) {
        this.isBusEmpty = isBusEmpty;
    }

    private boolean isBusEmpty() {
        return this.isBusEmpty;
    }

    @Override
    public void refuel(double liters) {
        if (this.getFuelQuantity() + liters > this.getTankCapacity()) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }

        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }
}
