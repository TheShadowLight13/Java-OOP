package Problem9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String command = data[1];
            CommandInterpreter.interpretCommand(command, data, persons);
            input = reader.readLine();
        }

        String targetName = reader.readLine();
        Person targetPerson = persons.stream().filter(p -> p.getName().equals(targetName))
                .findFirst().get();
        OutputWriter.printPersonData(targetPerson);
    }
}
