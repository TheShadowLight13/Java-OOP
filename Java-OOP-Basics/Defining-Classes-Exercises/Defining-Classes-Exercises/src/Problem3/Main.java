package Problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        List<Problem3.Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split(" ");
            String name = data[0];
            int age = Integer.valueOf(data[1]);

            Person person = new Person(name, age);
            persons.add(person);
        }

        persons = persons.stream().filter(p -> p.getAge() > 30)
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());
        for (Person person : persons) {
            System.out.printf("%s - %d%n", person.getName(), person.getAge());
        }
    }
}
