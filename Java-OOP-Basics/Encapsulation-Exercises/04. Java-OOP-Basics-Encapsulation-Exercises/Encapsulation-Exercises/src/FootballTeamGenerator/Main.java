package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Team> teams = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("END")) {
            String[] data = input.split(";");
            String command = data[0];
            CommandInterpreter.interpretCommand(command, data, teams);
            input = reader.readLine();
        }
    }
}
