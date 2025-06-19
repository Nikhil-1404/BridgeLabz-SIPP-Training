import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    public static String getWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if (user.equals("rock") && computer.equals("scissors") ||
            user.equals("scissors") && computer.equals("paper") ||
            user.equals("paper") && computer.equals("rock")) {
            return "Player";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];
        stats[0][0] = "Player";
        stats[1][0] = "Computer";
        stats[0][1] = String.valueOf(playerWins);
        stats[1][1] = String.valueOf(computerWins);
        stats[0][2] = String.format("%.2f%%", (playerWins * 100.0) / totalGames);
        stats[1][2] = String.format("%.2f%%", (computerWins * 100.0) / totalGames);
        return stats;
    }

    public static void displayResults(String[][] rounds, String[][] stats) {
        System.out.printf("%-10s%-15s%-15s%-10s\n", "Game", "Player Choice", "Computer Choice", "Winner");
        for (int i = 0; i < rounds.length; i++) {
            System.out.printf("%-10d%-15s%-15s%-10s\n",
                    i + 1, rounds[i][0], rounds[i][1], rounds[i][2]);
        }
        System.out.println("\nWin Statistics:");
        System.out.printf("%-10s%-10s%-15s\n", "Player", "Wins", "Winning %");
        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-10s%-10s%-15s\n",
                    stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine(); // consume newline

        String[][] rounds = new String[games][3];
        int playerWins = 0;
        int computerWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String playerChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = getWinner(playerChoice, computerChoice);

            rounds[i][0] = playerChoice;
            rounds[i][1] = computerChoice;
            rounds[i][2] = winner;

            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
        }

        String[][] stats = calculateStats(playerWins, computerWins, games);
        displayResults(rounds, stats);
    }
}
