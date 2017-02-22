package Problem5;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostForKm;
    private double distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return this.model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public void drive(double amountOfKm) {

        boolean isEnoughFuel = (amountOfKm * this.fuelCostForKm) <= this.fuelAmount;
        if (isEnoughFuel) {

            this.distanceTravelled += amountOfKm;
            fuelAmount -= amountOfKm * this.fuelCostForKm;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}
