import java.util.Scanner;

public class DigitSum {
    public static int calculateDigitSum(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + calculateDigitSum(n / 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adja meg a nem negatív egész számot (n): ");
        int n = scanner.nextInt();
        scanner.close();

        if (n < 0) {
            System.out.println("A szám negatív, érvénytelen bemenet.");
        } else {
            int digitSum = calculateDigitSum(n);
            System.out.println("A(z) " + n + " szám számjegyeinek az összege: " + digitSum);
        }
    }
}