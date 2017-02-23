package SortPersonsByNameAndAge;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s is a %d years old.",
                this.firstName, this.getLastName(), this.getAge());
    }
}
