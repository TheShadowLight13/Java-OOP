package Problem9;

import java.util.List;

public class CommandInterpreter {

    public static void interpretCommand(String command, String[] data, List<Person> persons) {

        String personName = data[0];
        Person person;

        if (isPersonExist(persons, personName)) {
            person = getPerson(persons, personName);
        }else {
            person = new Person(personName);
            persons.add(person);
        }

        switch (command) {
            case "company":
                String companyName = data[2];
                String department = data[3];
                double salary = Double.valueOf(data[4]);
                Company company = new Company(companyName, department, salary);
                person.setCompany(company);
                break;
            case "pokemon":
                String pokemonName = data[2];
                String pokemonType = data[3];
                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                person.addPokemon(pokemon);
                break;
            case "parents":
                String parentName = data[2];
                String parentBirthday = data[3];
                Parent parent = new Parent(parentName, parentBirthday);
                person.addParent(parent);
                break;
            case "children":
                String childName = data[2];
                String childBirthday = data[3];
                Child child = new Child(childName, childBirthday);
                person.addChild(child);
                break;
            case "car":
                String carModel = data[2];
                int carSpeed = Integer.valueOf(data[3]);
                Car car = new Car(carModel, carSpeed);
                person.setCar(car);
                break;
        }
    }

    private static boolean isPersonExist(List<Person> persons, String personName) {
        return persons.stream().anyMatch(p -> p.getName().equals(personName));
    }

    private static Person getPerson(List<Person> persons, String personName) {
        return persons.stream().filter(p -> p.getName().equals(personName)).findFirst().get();
    }
}
