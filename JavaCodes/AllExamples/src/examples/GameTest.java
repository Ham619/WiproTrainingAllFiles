package examples;

import java.util.Scanner;


abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}


class Cricket extends Game {
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}


class Football extends Game {
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Football Game Started. Enjoy the match!");
    }

    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}


public class GameTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter game to play (cricket/football): ");
        String choice = scanner.nextLine().toLowerCase();



        if (choice.equals("cricket")) {
            Game game = new Cricket();
            game.play();
        } else if (choice.equals("football")) {
            Game game = new Football();
            game.play();
        } else {
            System.out.println("Invalid game choice.");
        }

        scanner.close();
    }
}
