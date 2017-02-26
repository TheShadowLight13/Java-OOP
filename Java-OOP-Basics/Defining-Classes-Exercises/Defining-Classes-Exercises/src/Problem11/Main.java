package Problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> cats = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            String catBreed = data[0];
            String catName = data[1];
            double specificBreedInfo = Double.valueOf(data[2]);
            Cat cat = new Cat(catBreed, catName, specificBreedInfo);
            cats.add(cat);

            input = reader.readLine();
        }

        String targetCatName = reader.readLine();
        Cat targetCat = cats.stream().filter(c -> c.getName().equals(targetCatName))
                .findFirst().get();
        System.out.println(targetCat);
    }
}
