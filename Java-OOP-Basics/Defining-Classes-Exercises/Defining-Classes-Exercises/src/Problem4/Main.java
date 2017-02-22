package Problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        HashMap<String, List<Employee>> employeesByDepartment = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split(" ");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee;

            if (data.length == 5) {

                if(tryParseInt(data[4])) {
                    int age = Integer.valueOf(data[4]);
                    employee = new Employee(name, salary, position, department, age);

                }else {
                    String email = data[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }else if (data.length == 6) {
                String email = data[4];
                int age = Integer.valueOf(data[5]);
                employee = new Employee(name, salary, position, department, email, age);

            }else {
                employee = new Employee(name, salary, position, department);
            }

            employeesByDepartment.putIfAbsent(department, new ArrayList<>());
            employeesByDepartment.get(department).add(employee);
        }

        Comparator<Map.Entry<String, List<Employee>>> departmentsByAverageSalaryDescending =
                (e1,e2) -> Double.compare(
                        e2.getValue().stream().mapToDouble(e -> e.getSalary()).average().getAsDouble(),
                        e1.getValue().stream().mapToDouble(e -> e.getSalary()).average().getAsDouble()
                );

        employeesByDepartment.entrySet().stream().sorted(departmentsByAverageSalaryDescending)
                .limit(1).forEach(d -> {
                    String department = d.getKey();
                    System.out.println("Highest Average Salary: " + department);
                    List<Employee> employees = d.getValue();

                    employees.stream().sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(e -> System.out.printf("%s %.2f %s %d%n",
                                    e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
        });
    }

    private static boolean tryParseInt(String candidateAge) {

        try {
            Integer.parseInt(candidateAge);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
