package SalaryIncrease;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return this.salary;
    }

    public void addSalaryBonus(double bonus) {
        bonus = this.getAge() < 30 ? bonus * 0.5 : bonus;
        this.salary = this.salary + (this.salary * bonus);
    }

    @Override
    public String toString() {
        return String.format("%s %s get %s leva",
                this.getFirstName(), this.getLastName(), this.getSalary());
    }
}