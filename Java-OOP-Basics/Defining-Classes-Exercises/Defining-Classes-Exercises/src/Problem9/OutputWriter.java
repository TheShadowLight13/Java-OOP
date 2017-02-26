package Problem9;


public class OutputWriter {

    public static void printPersonData(Person targetPerson) {

        System.out.println(targetPerson.getName());
        System.out.println("Company:");
        if (targetPerson.getCompany() != null) {
            System.out.printf("%s %s %.2f%n", targetPerson.getCompany().getName(),
                    targetPerson.getCompany().getDepartment(),
                    targetPerson.getCompany().getSalary());
        }

        System.out.println("Car:");
        if (targetPerson.getCar() != null) {
            System.out.printf("%s %d%n", targetPerson.getCar().getModel(),
                    targetPerson.getCar().getSpeed());
        }

        System.out.printf("Pokemon:%n");
        targetPerson.getPokemons().forEach(p -> System.out.printf("%s %s%n",
                p.getName(), p.getType()));
        System.out.printf("Parents:%n");
        targetPerson.getParents().forEach(p -> System.out.printf("%s %s%n",
                p.getName(), p.getBirthday()));
        System.out.printf("Children:%n");
        targetPerson.getChildren().forEach(c -> System.out.printf("%s %s%n",
                c.getName(), c.getBirthday()));
    }
}
