import java.util.Scanner;
public class fibonacci {
        public static int fibonacciRec(int n) {
            if (n < 0) {
                System.out.println("Nem megfelelő szám!");
                return 404;
            } else if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return fibonacciRec(n - 1) + fibonacciRec(n - 2);
            }
        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adja meg az n értékét: ");
        int n = scanner.nextInt();
        scanner.close();

        int result = fibonacciRec(n);
        System.out.println("A(z) " + n + ". Fibonacci-szám: " + result);

    }
}