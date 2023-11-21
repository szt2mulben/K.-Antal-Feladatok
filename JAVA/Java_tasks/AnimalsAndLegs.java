import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the number of chickens: ");
        int chickens = scanner.nextInt();

        System.out.print("Please enter the number of pigs: ");
        int pigs = scanner.nextInt();

        // Assuming each chicken has 2 legs and each pig has 4 legs
        int totalLegs = (chickens * 2) + (pigs * 4);

        System.out.println("The number of legs: " + totalLegs);

        scanner.close();
    }
}