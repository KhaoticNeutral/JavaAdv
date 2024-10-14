package SoccerLeague;

import java.io.*;
import java.util.*;

public class SoccerLeagueRanking {

    public static void main(String[] args) {
        // HashMap to store team points
        HashMap<String, Integer> teamPoints = new HashMap<>();

        // Reading input from file
        try (BufferedReader br = new BufferedReader(new FileReader("src/SoccerLeague/input.txt"))) {
            String line;

            // Loop through each match in the input file
            while ((line = br.readLine()) != null) {
                processMatch(line, teamPoints);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Sort teams based on points and name
        List<Map.Entry<String, Integer>> ranking = new ArrayList<>(teamPoints.entrySet());
        ranking.sort((team1, team2) -> {
            // First sort by points in descending order
            int pointComparison = team2.getValue().compareTo(team1.getValue());
            if (pointComparison == 0) {
                // If points are equal, sort lexicographically
                return team1.getKey().compareTo(team2.getKey());
            }
            return pointComparison;
        });

        // Print the final ranking table
        int rank = 1;
        for (Map.Entry<String, Integer> entry : ranking) {
            System.out.println(rank + ". " + entry.getKey() + " " + entry.getValue());
            rank++;
        }
    }

    // Function to process a match and update the points table
    private static void processMatch(String line, HashMap<String, Integer> teamPoints) {
        // Split the line to get both teams and their scores
        String[] teams = line.split(", ");
        String[] team1Data = teams[0].split(" ");
        String[] team2Data = teams[1].split(" ");

        // Extract team names and scores
        String team1Name = String.join(" ", Arrays.copyOf(team1Data, team1Data.length - 1));
        int team1Score = Integer.parseInt(team1Data[team1Data.length - 1]);

        String team2Name = String.join(" ", Arrays.copyOf(team2Data, team2Data.length - 1));
        int team2Score = Integer.parseInt(team2Data[team2Data.length - 1]);

        // Update points based on match result
        if (team1Score > team2Score) {
            teamPoints.put(team1Name, teamPoints.getOrDefault(team1Name, 0) + 3);
            teamPoints.put(team2Name, teamPoints.getOrDefault(team2Name, 0));
        } else if (team1Score < team2Score) {
            teamPoints.put(team2Name, teamPoints.getOrDefault(team2Name, 0) + 3);
            teamPoints.put(team1Name, teamPoints.getOrDefault(team1Name, 0));
        } else {
            // Draw scenario
            teamPoints.put(team1Name, teamPoints.getOrDefault(team1Name, 0) + 1);
            teamPoints.put(team2Name, teamPoints.getOrDefault(team2Name, 0) + 1);
        }
    }
}
