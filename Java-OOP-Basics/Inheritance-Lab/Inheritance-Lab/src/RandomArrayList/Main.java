package RandomArrayList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        RandomArrayList ral = new RandomArrayList();
        ral.add(20);
        ral.add("Yes this is string");
        ral.add(new ArrayList<Integer>());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
    }
}
