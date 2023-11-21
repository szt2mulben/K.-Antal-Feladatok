import java.util.Scanner;

public class Factorial {
    public static long calculateFactorialWithLoop(int n) {
        if (n < 0) {
            System.out.println("Pozitív számot adj meg.");
            return 404; 
        }
        long seged = 1;
        for (int i = 1; i <= n; i++) {
            seged *= i;
        }
        return seged;
    }

    public static long calculateFactorialWithRecursion(int n) {
        if (n < 0) {
            System.out.println("Pozitív számot adj meg.");
            return 404; 
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorialWithRecursion(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adja meg az n értékét: ");
        int n = scanner.nextInt();
        scanner.close();
        
        long ciklus = calculateFactorialWithLoop(n);
        long rekurzív = calculateFactorialWithRecursion(n);
        
        System.out.println(n + " faktoriálisa (ciklussal): " + ciklus);
        System.out.println(n + " faktoriálisa (rekurzívan): " + rekurzív);
    }
}