package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;
    private double rating;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public double getRating() {
        this.calculateTotalRating();
        return this.rating;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }

    private void calculateTotalRating() {
        double totalRating = 0;

        for (Player player : this.players) {
            totalRating += player.getStats().getAverageStats();
        }

        this.setRating(totalRating);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
