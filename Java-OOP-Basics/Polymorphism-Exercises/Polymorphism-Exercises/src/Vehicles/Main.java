package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Vehicle> vehicles = new ArrayList<>();

        String[] carData = reader.readLine().split("\\s+");
        initializeObject(carData, vehicles);

        String[] truckData = reader.readLine().split("\\s+");
        initializeObject(truckData, vehicles);

        String[] busData = reader.readLine().split("\\s+");
        initializeObject(busData, vehicles);

        int numberOfCommands = Integer.valueOf(reader.readLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            interpretCommand(command, tokens, vehicles);
        }

        System.out.printf("Car: %.2f%n", vehicles.get(0).getFuelQuantity());
        System.out.printf("Truck: %.2f%n", vehicles.get(1).getFuelQuantity());
        System.out.printf("Bus: %.2f", vehicles.get(2).getFuelQuantity());
    }

    private static void initializeObject(String[] data, List<Vehicle> vehicles) {

        String vehicleType = data[0];
        double fuelQuantity = Double.valueOf(data[1]);
        double fuelConsumption = Double.valueOf(data[2]);
        double tankCapacity = Double.valueOf(data[3]);

        try {
            switch (vehicleType) {
                case "Car":
                    Car car = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                    vehicles.add(car);
                    break;
                case "Truck":
                    Truck truck = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                    vehicles.add(truck);
                    break;
                case "Bus":
                    Bus bus = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                    vehicles.add(bus);
                    break;
            }
        }catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
    }

    private static void interpretCommand(String command, String[] tokens,
                                         List<Vehicle> vehicles) {

        Car car = (Car)vehicles.get(0);
        Truck truck = (Truck)vehicles.get(1);
        Bus bus = (Bus)vehicles.get(2);

        String vehicleType = tokens[1];
        try {
            if (command.equals("Drive")) {
                double distance = Double.valueOf(tokens[2]);

                switch (vehicleType) {
                    case "Car":
                        car.drive(distance);
                        break;
                    case "Truck":
                        truck.drive(distance);
                        break;
                    case "Bus":
                        bus.setIsBusEmpty(false);
                        bus.drive(distance);
                        break;
                }
            } else if (command.equals("DriveEmpty")) {
                double distance = Double.valueOf(tokens[2]);
                bus.setIsBusEmpty(true);
                bus.drive(distance);

            } else {
                double litres = Double.valueOf(tokens[2]);

                switch (vehicleType) {
                    case "Car":
                        car.refuel(litres);
                        break;
                    case "Truck":
                        truck.refuel(litres);
                        break;
                    case "Bus":
                        bus.refuel(litres);
                        break;
                }
            }
        }catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
    }
}
