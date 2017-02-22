package Problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Trainer> trainersByName = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("Tournament")) {

            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            double pokemonHealth = Double.valueOf(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);

            trainersByName.putIfAbsent(trainerName, trainer);
            trainersByName.get(trainerName).getPokemonsOwned().add(pokemon);

            input = reader.readLine();
        }

        input = reader.readLine();
        while (!input.equals("End")) {

            String element = input;
            checkTrainers(trainersByName, element);
            input = reader.readLine();
        }

        trainersByName.entrySet().stream().sorted((t1,t2) -> Integer.compare(
                t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n",
                        t.getKey(), t.getValue().getNumberOfBadges(),
                        t.getValue().getPokemonsOwned().size()));
    }

    private static void checkTrainers(HashMap<String, Trainer> trainersByName, String element) {

        for (String trainerName : trainersByName.keySet()) {

            boolean isTrainerHasPokemonElement = trainersByName.get(trainerName).getPokemonsOwned()
                    .stream().anyMatch(p -> p.getElement().equals(element));
            if (isTrainerHasPokemonElement) {
                trainersByName.get(trainerName).addBadge();

            }else {
                Trainer currTrainer = trainersByName.get(trainerName);
                currTrainer.getPokemonsOwned().forEach(p -> p.removeHealth());
                List<Pokemon> newPokemonsList = currTrainer.getPokemonsOwned().stream()
                        .filter(p -> p.getHealth() > 0).collect(Collectors.toList());

                currTrainer.setPokemonsOwned(newPokemonsList);
            }
        }
    }
}
