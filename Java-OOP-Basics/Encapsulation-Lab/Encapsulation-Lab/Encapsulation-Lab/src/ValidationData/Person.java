package ValidationData;

import java.util.Collections;
import java.util.stream.Collectors;

public class Person {

        private String firstName;
        private String lastName;
        private int age;
        private double salary;

        public Person(String firstName, String lastName, int age, double salary) {
            setFirstName(firstName);
            setLastName(lastName);
            setAge(age);
            setSalary(salary);
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

    private void setFirstName(String firstName) {

        if (firstName.length() < 3) {
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {

        if (lastName.length() < 3) {
            throw new IllegalStateException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    private void setAge(int age) {

        if (age <= 0) {
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setSalary(double salary) {

        if (salary < 460) {
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    @Override
        public String toString() {
            return String.format("%s %s get %s leva",
                    this.getFirstName(), this.getLastName(), this.getSalary());
        }
}

