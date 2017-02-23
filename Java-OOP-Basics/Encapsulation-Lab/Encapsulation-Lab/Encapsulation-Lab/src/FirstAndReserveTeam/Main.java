package FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        Team team = new Team("Barcelona");

        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.valueOf(input[2]);
            double salary = Double.valueOf(input[3]);

            Person person = new Person(firstName, lastName, age, salary);
            team.addPlayer(person);
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());
    }
}
