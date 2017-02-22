package Problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int TIRES_DATA_START_INDEX = 5;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            Tire[] tires = new Tire[4];

            String[] data = reader.readLine().split(" ");

            String carModel = data[0];
            int engineSpeed = Integer.valueOf(data[1]);
            int enginePower = Integer.valueOf(data[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.valueOf(data[3]);
            String cargoType = data[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            int tyreInitialIndex = 0;
            for (int j = TIRES_DATA_START_INDEX; j < data.length; j++) {

                double tirePressure = Double.valueOf(data[j]);
                int tireAge = Integer.valueOf(data[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires[tyreInitialIndex] = tire;
                tyreInitialIndex++;
                j++;
            }

            Car car = new Car(carModel, engine, cargo, tires);
            cars.add(car);
        }

        String command = reader.readLine();
        CommandInterpreter.interpretCommand(cars, command);
    }
}
