package FootballTeamGenerator;

public class Player {

    private String name;
    private Stats stats;

    public Player(String name, Stats stats) {
        this.setName(name);
        this.stats = stats;
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

    public Stats getStats() {
        return this.stats;
    }
}
