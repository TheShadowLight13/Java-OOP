package Problem9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Child> children;
    private List<Parent> parents;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Company getCompany() {
        return this.company;
    }

    public Car getCar() {
        return this.car;
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(this.pokemons);
    }

    public List<Child> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    public List<Parent> getParents() {
        return Collections.unmodifiableList(this.parents);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }
}
