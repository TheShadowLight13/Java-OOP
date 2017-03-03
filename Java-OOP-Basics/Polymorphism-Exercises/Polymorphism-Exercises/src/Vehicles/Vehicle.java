package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double distanceTravelled;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    private double getDistanceTravelled() {
        return this.distanceTravelled;
    }

    protected void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;

        if (this.getFuelQuantity() < 0) {
            throw new IllegalStateException("Fuel must be a positive number");
        }
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double distance) {

        double spendFuel = distance * this.getFuelConsumption();
        if (this.getFuelQuantity() >= spendFuel) {
            this.setDistanceTravelled(this.getDistanceTravelled() + distance);
            this.setFuelQuantity(this.getFuelQuantity() - spendFuel);
            System.out.printf("%s travelled %s km%n",
                    this.getClass().getSimpleName(),
                     new DecimalFormat("#.######").format(distance));
        }else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }
    public abstract void refuel(double liters);
}
