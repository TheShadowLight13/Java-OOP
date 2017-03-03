package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object>{

    private Random rndGen;

    public RandomArrayList() {
        this.rndGen = new Random();
    }

    public Object getRandomElement() {
        return this.remove(rndGen.nextInt(super.size()));
    }
}
