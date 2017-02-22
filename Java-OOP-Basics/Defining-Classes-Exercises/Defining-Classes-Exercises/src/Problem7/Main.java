package Problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int enginesCount = Integer.valueOf(reader.readLine());

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < enginesCount; i++) {

            String[] data = reader.readLine().split(" ");
            String engineModel = data[0];
            int enginePower = Integer.valueOf(data[1]);

            Engine engine;

            if (data.length == 3) {
                if (tryParseInt(data[2])) {
                    int displacement = Integer.valueOf(data[2]);
                    engine = new Engine(engineModel, enginePower, displacement);

                }else {
                    String efficiency = data[2];
                    engine = new Engine(engineModel, enginePower, efficiency);
                }
            }else if (data.length == 4) {
                int displacement = Integer.valueOf(data[2]);
                String efficiency = data[3];
                engine = new Engine(engineModel, enginePower, displacement, efficiency);
            }else {

                engine = new Engine(engineModel, enginePower);
            }

            engines.add(engine);
         }

        int carsCount = Integer.valueOf(reader.readLine());

        for (int i = 0; i < carsCount; i++) {

            String[] data = reader.readLine().split(" ");
            String carModel = data[0];
            String engineModel = data[1];

            Car car;
            Engine currEngine = engines.stream().filter(e -> e.getModel().equals(engineModel))
                    .findFirst().get();

            if (data.length == 3) {
                if (tryParseInt(data[2])) {
                    int weight = Integer.valueOf(data[2]);
                    car = new Car(carModel, currEngine, weight);

                }else {
                    String color = data[2];
                    car = new Car(carModel, currEngine, color);
                }
            }else if (data.length == 4) {
                int weight = Integer.valueOf(data[2]);
                String color = data[3];
                car = new Car(carModel, currEngine, weight, color);
            }else {

                car = new Car(carModel, currEngine);
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static boolean tryParseInt(String candidateInt) {

        try {
            Integer.valueOf(candidateInt);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
