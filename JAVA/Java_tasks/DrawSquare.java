import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the square size: ");
        int meret = scanner.nextInt();

        for (int i = 1; i <= meret; i++) {
            for (int j = 1; j <= meret; j++) {
                if (i == 1 || i == meret || j == 1 || j == meret) {
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}