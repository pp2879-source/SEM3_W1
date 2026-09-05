import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int rounds = 5;
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine().trim();

            String computerMove = moves[rand.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else if (result.equals("Draw")) draws++;
        }

        System.out.println("\nRound | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-5d | %-11s | %-14s | %s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("\nFinal Summary:");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);

        sc.close();
    }
}
