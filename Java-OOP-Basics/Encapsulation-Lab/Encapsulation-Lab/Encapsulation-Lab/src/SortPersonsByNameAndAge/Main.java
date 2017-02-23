package SortPersonsByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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

            Person person = new Person(firstName, lastName, age);
            persons.add(person);
        }

        Comparator<Person> orderPersonByNameAscending = (p1,p2) ->
                p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> personComparator =
                orderPersonByNameAscending.thenComparing(
                        (p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        persons.stream().sorted(personComparator)
                .forEach(p -> System.out.println(p));
    }
}
