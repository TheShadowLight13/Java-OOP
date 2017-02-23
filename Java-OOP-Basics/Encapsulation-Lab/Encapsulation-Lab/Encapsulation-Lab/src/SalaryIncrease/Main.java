package SalaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.valueOf(input[2]);
            double salary = Double.valueOf(input[3]);

            Person person = new Person(firstName, lastName, age, salary);
            persons.add(person);
        }

        double bonus = Integer.valueOf(reader.readLine()) / 100.00;
        for (Person person : persons) {

            person.addSalaryBonus(bonus);
        }

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
