import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Please enter a number: ");
            int number = scanner.nextInt();
            sum += number;
        }

        double average = (double) sum / 5;

        System.out.println("Sum: " + sum + ", Average: " + average);

        scanner.close();
    }
}