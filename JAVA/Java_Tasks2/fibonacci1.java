import java.util.Scanner;

public class fibonacci1 {
    public static int fibonacci(int n) {
        if (n < 0) {
            System.out.println("Nem megfelelő szám!");
            return 404;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1, temp;
            for (int i = 2; i <= n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adja meg az n értékét: ");
        int n = scanner.nextInt();
        scanner.close();
        
        int result = fibonacci(n);
        System.out.println("A(z) " + n + ". Fibonacci-szám: " + result);
    }
}
