import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int storedNumber = random.nextInt(100) + 1;
        int guess;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            System.out.print("Please enter your guess: ");
            guess = scanner.nextInt();

            if (guess < storedNumber) {
                System.out.println("The stored number is greater than " + guess);
            } else if (guess > storedNumber) {
                System.out.println("The stored number is smaller than " + guess);
            } else {
                System.out.println("You have found the stored number " + storedNumber);
            }
        } while (guess != storedNumber);
        scanner.close();
    }
}