import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 6; // Maximum attempts per round
    private static int score = 0; // Initialize score
    private static int rounds = 0; // Initialize rounds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playRound(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your final score is " + score + " out of " + rounds);
    }

    private static void playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
        int attempts = 0;

        System.out.println("Welcome to the number guessing game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println(" Congratulations! You found the number in " + attempts + " attempts.");
                score++;
                break;
            }
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you didn't guess the number. It was " + numberToGuess);
        }

        rounds++;
    }
}