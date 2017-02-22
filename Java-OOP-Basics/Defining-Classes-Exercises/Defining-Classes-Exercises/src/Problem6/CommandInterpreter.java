package Problem6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CommandInterpreter {

    public static void interpretCommand(List<Car> cars, String command) {

        Predicate<Car> tester = createTester(command);
        cars.stream().filter(tester).forEach(c -> System.out.println(c.getModel()));
    }

    private static Predicate<Car> createTester(String command) {

        String cargoTypeTarget = command;

        switch (command) {
            case "fragile":
                double targetPressure = 1.00;
                return car -> car.getCargo().getType().equals(cargoTypeTarget) &&
                        Arrays.stream(car.getTires()).anyMatch(t -> t.getPressure() < 1);

                case "flamable":
                int targetEnginePower = 250;
                return car -> car.getCargo().getType().equals(cargoTypeTarget) &&
                        car.getEngine().getPower() > 250;

                default: return null;
        }
    }
}
