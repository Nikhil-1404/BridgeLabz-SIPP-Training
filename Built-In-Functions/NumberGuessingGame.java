import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1, high = 100;
        boolean found = false;

        while (!found) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "?");
            System.out.print("Enter 'low', 'high', or 'correct': ");
            String feedback = scanner.nextLine();

            if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Guessed correctly: " + guess);
                found = true;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    static int generateGuess(int low, int high) {
        Random random = new Random();
        return low + random.nextInt(high - low + 1);
    }
}
