package FootballTeamGenerator;

import java.util.List;

public class CommandInterpreter {

    public static void interpretCommand(String command, String[] data, List<Team> teams) {

        switch (command) {
            case "Team":
                String teamName = data[1];
                try {
                    Team team = new Team(teamName);
                    teams.add(team);
                }catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
                break;
            case "Add":
                teamName = data[1];
                String playerName = data[2];
                int endurance = Integer.valueOf(data[3]);
                int sprint = Integer.valueOf(data[4]);
                int dribble = Integer.valueOf(data[5]);
                int passing = Integer.valueOf(data[6]);
                int shooting = Integer.valueOf(data[7]);

                if (!isTeamExist(teams, teamName)) {
                    System.out.printf("Team %s does not exist.%n", teamName);
                    break;
                }

                try {
                    Stats stats = new Stats(endurance, sprint, dribble, passing, shooting);
                    Player player = new Player(playerName, stats);
                    Team currTeam = getTeam(teams, teamName);
                    currTeam.addPlayer(player);

                }catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
                break;
            case "Remove":
                teamName = data[1];
                playerName = data[2];

                if (!isTeamExist(teams, teamName)) {
                    System.out.printf("Team %s does not exist.%n", teamName);
                    break;
                }

                Team currTeam = getTeam(teams, teamName);

                boolean isPlayerInTeam = isPlayerInTeamExist(currTeam, playerName);
                if (isPlayerInTeam) {
                    Player currPlayer = getPlayer(currTeam, playerName);
                    currTeam.removePlayer(currPlayer);
                }else {
                    System.out.printf("Player %s is not in %s team.%n", playerName, currTeam.getName());
                }
                break;
            case "Rating":
                teamName = data[1];
                if (!isTeamExist(teams, teamName)) {
                    System.out.printf("Team %s does not exist.%n", teamName);
                    break;
                }

                currTeam = getTeam(teams, teamName);
                System.out.printf("%s - %.0f%n", currTeam.getName(), currTeam.getRating());
                break;
        }
    }

    private static Player getPlayer(Team team, String playerName) {
        return team.getPlayers().stream()
                .filter(p -> p.getName().equals(playerName)).findFirst().get();
    }

    private static Team getTeam(List<Team> teams, String teamName) {
        return teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().get();
    }

    private static boolean isPlayerInTeamExist(Team team, String playerName) {
        return team.getPlayers().stream()
                .anyMatch(p -> p.getName().equals(playerName));
    }

    private static boolean isTeamExist(List<Team> teams, String teamName) {
        return teams.stream().anyMatch(t -> t.getName().equals(teamName));
    }
}
