package examples;

import java.util.*;

class Player {
    private String name;
    private int age;
    private String team;
    private int score;

    public Player(String name, int age, String team) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.score = 0;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getTeam() { return team; }
    public int getScore() { return score; }

    public void setScore(int score) {
        if (score >= 0)
            this.score = score;
    }

    public String toString() {
        return name + " | Age: " + age + " | Team: " + team + " | Score: " + score;
    }
}

public class Scoreboard {

    static HashMap<String, Player> players = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getIntInput("Choose option: ");

            if (choice == 1) {
                addPlayer();
            } else if (choice == 2) {
                updateScore();
            } else if (choice == 3) {
                viewPlayer();
            } else if (choice == 4) {
                displayAll();
            } else if (choice == 5) {
                displayTopScorer();
            } else if (choice == 6) {
                searchByTeam();
            } else if (choice == 7) {
                removePlayer();
            } else if (choice == 8) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    static void printMenu() {
        System.out.println("\n--- Scoreboard Menu ---");
        System.out.println("1. Register New Player");
        System.out.println("2. Update Player Score");
        System.out.println("3. View Player Info");
        System.out.println("4. Display All Players");
        System.out.println("5. Display Top Scorer");
        System.out.println("6. Search Players by Team");
        System.out.println("7. Remove Player");
        System.out.println("8. Exit");
    }

    static void addPlayer() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        if (players.containsKey(name)) {
            System.out.println("Player already exists.");
            return;
        }

        int age = getIntInput("Enter player age: ");
        System.out.print("Enter team name: ");
        String team = scanner.nextLine();

        players.put(name, new Player(name, age, team));
        System.out.println("Player registered successfully.");
    }

    static void updateScore() {
        System.out.print("Enter player name to update score: ");
        String name = scanner.nextLine();
        if (players.containsKey(name)) {
            int score = getIntInput("Enter new score: ");
            players.get(name).setScore(score);
            System.out.println("Score updated.");
        } else {
            System.out.println("Player not found.");
        }
    }

    static void viewPlayer() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        if (players.containsKey(name)) {
            System.out.println(players.get(name));
        } else {
            System.out.println("Player not found.");
        }
    }

    static void displayAll() {
        if (players.isEmpty()) {
            System.out.println("No players registered.");
            return;
        }
        System.out.println("--- All Players ---");
        for (Player p : players.values()) {
            System.out.println(p);
        }
    }

    static void displayTopScorer() {
        if (players.isEmpty()) {
            System.out.println("No players to evaluate.");
            return;
        }
        Player top = null;
        for (Player p : players.values()) {
            if (top == null || p.getScore() > top.getScore()) {
                top = p;
            }
        }
        System.out.println("Top Scorer: " + top);
    }

    static void searchByTeam() {
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        boolean found = false;
        for (Player p : players.values()) {
            if (p.getTeam().equals(teamName)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No players found in team " + teamName);
        }
    }

    static void removePlayer() {
        System.out.print("Enter player name to remove: ");
        String name = scanner.nextLine();
        if (players.remove(name) != null) {
            System.out.println("Player removed successfully.");
        } else {
            System.out.println("Player not found.");
        }
    }

    static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
