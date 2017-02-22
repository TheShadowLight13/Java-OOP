package Problem8;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonsOwned;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonsOwned = new ArrayList<>();
    }

    public List<Pokemon> getPokemonsOwned() {
        return this.pokemonsOwned;
    }

    public void addBadge() {
        this.numberOfBadges += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void setPokemonsOwned(List<Pokemon> pokemonsOwned) {
        this.pokemonsOwned = pokemonsOwned;
    }
}
