package Problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] data = reader.readLine().split(" ");
            String model = data[0];
            double fuelAmount = Double.valueOf(data[1]);
            double fuelCostForKm = Double.valueOf(data[2]);

            Car car = new Car(model, fuelAmount, fuelCostForKm);
            cars.add(car);
        }

        String input = reader.readLine();
        while (!input.equals("End")) {

            String[] data = input.split(" ");
            String model = data[1];
            double amountOfKm = Double.valueOf(data[2]);

            Car currCar = cars.stream().filter(c -> c.getModel().equals(model)).findFirst().get();
            currCar.drive(amountOfKm);

            input = reader.readLine();
        }

        for (Car car : cars) {

            System.out.printf("%s %.2f %d%n",
                    car.getModel(),
                    car.getFuelAmount(),
                    (int)car.getDistanceTravelled());
        }
    }
}
