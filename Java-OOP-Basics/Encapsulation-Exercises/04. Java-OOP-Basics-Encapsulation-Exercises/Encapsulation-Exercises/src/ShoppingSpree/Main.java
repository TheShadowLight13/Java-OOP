package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        String[] personsTokens = readData(reader);
        for (int i = 0; i < personsTokens.length; i++) {

            String[] personData = personsTokens[i].split("=");
            String personName = personData[0];
            double personMoney = Double.valueOf(personData[1]);

            try {
                Person person = new Person(personName, personMoney);
                persons.add(person);
            }catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
                return;
            }
        }

        String[] productsTokens = readData(reader);
        for (int i = 0; i < productsTokens.length; i++) {

            String[] productData = productsTokens[i].split("=");
            String productName = productData[0];
            double productPrice = Double.valueOf(productData[1]);

            try {
                Product product = new Product(productName, productPrice);
                products.add(product);
            }catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
                return;
            }
        }

        String input = reader.readLine();
        while (!input.equals("END")) {

            String[] tokens = input.split("\\s+");
            String customerName = tokens[0];
            String productName = tokens[1];

            Person currPerson = persons.stream().filter(p -> p.getName().equals(customerName))
                    .findFirst().get();
            Product currProduct = products.stream().filter(prod -> prod.getName().equals(productName))
                    .findFirst().get();

            try {
                currPerson.buyProduct(currProduct);
                System.out.printf("%s bought %s%n", customerName, productName);

            }catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }

            input = reader.readLine();
        }

       printResult(persons);
    }

    private static void printResult(List<Person> persons) {

        persons.forEach(p -> {
            System.out.printf("%s - ", p.getName());
            List<Product> bagOfProducts = p.getBagOfProducts();
            StringBuilder productsNames = new StringBuilder();

            if (!bagOfProducts.isEmpty()) {
                bagOfProducts.forEach(prod -> productsNames.append(prod.getName()).append(", "));
                productsNames.delete(productsNames.length() - 2 ,productsNames.length());
                System.out.println(productsNames);
            }else {
                System.out.println("Nothing bought");
            }
        });
    }

    private static String[] readData(BufferedReader reader) throws IOException {

        String[] tokens = reader.readLine().split(";");
        return tokens;
    }
}
